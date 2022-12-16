package com.microservice.orderservice.service.implement;

import com.microservice.orderservice.entity.Order;
import com.microservice.orderservice.exception.OrderServiceCustomException;
import com.microservice.orderservice.payload.request.OrderRequest;
import com.microservice.orderservice.payload.request.PaymentRequest;
import com.microservice.orderservice.payload.response.OrderResponse;
import com.microservice.orderservice.payload.response.PaymentResponse;
import com.microservice.orderservice.repository.OrderRepository;
import com.microservice.orderservice.service.OrderService;
import com.microservice.orderservice.external.client.PaymentService;
import com.microservice.orderservice.external.client.ProductService;
import com.microservice.productservice.payload.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;

@Service
@Log4j2
@RequiredArgsConstructor
public class OrderServiceImplement implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductService productService;
    private final PaymentService paymentService;
    private RestTemplate restTemplate;

    @Override
    public long placeOrder(OrderRequest orderRequest) {
        log.info("OrderServiceImplement | placeOrder is called");
        log.info("OrderServiceImplement | placeOrder | Placing Order Request orderRequest: " + orderRequest.toString());

        log.info("OrderServiceImpl | placeOrder | Calling productService through FeignClient");
        productService.reduceQuantity(orderRequest.getProductId(), orderRequest.getQuantity());

        log.info("OrderServiceImplement | placeOrder | Creating Order with Status CREATED");
        Order order = Order.builder()
                .amount(orderRequest.getTotalAmount())
                .orderStatus("CREATED")
                .productId(orderRequest.getProductId())
                .orderDate(Instant.now())
                .quantity(orderRequest.getQuantity())
                .build();
        order = orderRepository.save(order);

        log.info("OrderServiceImplement | placeOrder | Calling Payment Service to complete the payment");
        PaymentRequest paymentRequest = PaymentRequest.builder()
                .orderId(order.getId())
                .paymentMode(orderRequest.getPaymentMode())
                .amount(orderRequest.getTotalAmount())
                .build();

        String orderStatus = null;
        try {
            paymentService.doPayment(paymentRequest);
            log.info("OrderServiceImplement | placeOrder | Payment done Successfully. Changing the Oder status to PLACED");
            orderStatus = "PLACED";
        } catch (Exception e) {
            log.error("OrderServiceImplement | placeOrder | Error occurred in payment. Changing order status to PAYMENT_FAILED");
            orderStatus = "PAYMENT_FAILED";
        }
        order.setOrderStatus(orderStatus);
        orderRepository.save(order);
        log.info("OrderServiceImplement | placeOrder | Order Places successfully with Order Id: {}", order.getId());
        return order.getId();
    }

    @Override
    public OrderResponse getOrderDetails(long orderId) {
        log.info("OrderServiceImplement | getOrderDetails | Get order details for Order Id: {}", orderId);
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderServiceCustomException("Order not found with Id: "+ orderId, "NOT_FOUND", 404));

        log.info("OrderServiceImplement | getOrderDetails | Invoking Product service to fetch the product for id: {}", order.getProductId());
        ProductResponse productResponse = restTemplate
                .getForObject("http://PRODUCT-SERVICE/product/"+ order.getProductId(), ProductResponse.class);

        log.info("OrderServiceImplement | getOrderDetails | Getting payment information form the payment Service");
        PaymentResponse paymentResponse = restTemplate
                .getForObject("http://PAYMENT-SERVICE/payment/order/"+ order.getId(), PaymentResponse.class);

        OrderResponse.ProductDetails productDetails = OrderResponse.ProductDetails.builder()
                .productName(productResponse.getProductName())
                .productId(productResponse.getProductId())
                .build();
        OrderResponse.PaymentDetails paymentDetails = OrderResponse.PaymentDetails.builder()
                .paymentId(paymentResponse.getPaymentId())
                .paymentStatus(paymentResponse.getStatus())
                .paymentDate(paymentResponse.getPaymentDate())
                .paymentMode(paymentResponse.getPaymentMode())
                .build();
        OrderResponse orderResponse = OrderResponse.builder()
                .orderId(order.getId())
                .orderStatus(order.getOrderStatus())
                .amount(order.getAmount())
                .orderDate(order.getOrderDate())
                .productDetails(productDetails)
                .paymentDetails(paymentDetails)
                .build();
        log.info("OrderServiceImplement | getOrderDetails | orderResponse: " + orderResponse.toString());
        return  orderResponse;
    }
}
