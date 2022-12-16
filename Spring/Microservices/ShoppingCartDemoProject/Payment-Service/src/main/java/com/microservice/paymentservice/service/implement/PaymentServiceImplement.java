package com.microservice.paymentservice.service.implement;

import com.microservice.paymentservice.entity.TransactionDetails;
import com.microservice.paymentservice.exception.PaymentServiceCustomException;
import com.microservice.paymentservice.payload.PaymentRequest;
import com.microservice.paymentservice.payload.PaymentResponse;
import com.microservice.paymentservice.repository.TransactionDetailsRepository;
import com.microservice.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
@RequiredArgsConstructor
public class PaymentServiceImplement implements PaymentService {
    private final TransactionDetailsRepository transactionDetailsRepository;

    @Override
    public long doPayment(PaymentRequest paymentRequest) {
        log.info("PaymentServiceImpl | doPayment is called");
        log.info("PaymentServiceImpl | doPayment | Recording Payment Details: {}", paymentRequest);
        TransactionDetails td = TransactionDetails.builder()
                .paymentDate(Instant.now())
                .paymentMode(paymentRequest.getPaymentMode())
                .paymentStatus("SUCCESS")
                .orderId(paymentRequest.getOrderId())
                .referenceNumber(paymentRequest.getReferenceNumber())
                .amount(paymentRequest.getAmount())
                .build();
        td = transactionDetailsRepository.save(td);
        log.info("Transaction Completed with Id: {}", td.getId());
        return td.getId();
    }

    @Override
    public PaymentResponse getPaymentDetailsByOrderId(long orderId) {
        log.info("PaymentServiceImpl | getPaymentDetailsByOrderId is called");
        log.info("PaymentServiceImpl | getPaymentDetailsByOrderId | Getting payment details for the Order Id: {}", orderId);
        TransactionDetails td = transactionDetailsRepository.findByOrderId(orderId)
                .orElseThrow(() -> new PaymentServiceCustomException(
                        "TransactionDetails with given id not found",
                        "TRANSACTION_NOT_FOUND"));
        PaymentResponse paymentResponse = PaymentResponse.builder()
                .paymentId(td.getId())
                .paymentMode(td.getPaymentMode())
                .paymentDate(td.getPaymentDate())
                .orderId(td.getOrderId())
                .status(td.getPaymentStatus())
                .amount(td.getAmount())
                .build();
        log.info("PaymentServiceImpl | getPaymentDetailsByOrderId | paymentResponse: {}", paymentResponse.toString());

        return paymentResponse;
    }
}
