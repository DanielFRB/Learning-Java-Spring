package com.microservice.productservice.service.implementation;

import com.microservice.productservice.entity.Product;
import com.microservice.productservice.exception.ProductServiceCustomException;
import com.microservice.productservice.payload.request.ProductRequest;
import com.microservice.productservice.payload.response.ProductResponse;
import com.microservice.productservice.repository.ProductRepository;
import com.microservice.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProductServiceImplementation implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("ProductServiceImplementation | addProduct is called");
        Product p = Product.builder()
                .productName(productRequest.getName())
                .quantity(productRequest.getQuantity())
                .price(productRequest.getPrice())
                .build();
        p = productRepository.save(p);
        log.info("ProductServiceImpl | addProduct | Product Created");
        log.info("ProductServiceImpl | addProduct | Product Id : " + p.getProductId());
        return p.getProductId();
    }

    @Override
    public ProductResponse getProductById(long productId) {
        log.info("ProductServiceImplementation | getProductById is called");
        log.info("ProductServiceImplementation | getProductById | Get the product for productId: {}", productId);
        Product p = productRepository.findById(productId).orElseThrow(
                () -> new ProductServiceCustomException("Product with given Id not found","Product Not Found"));
        ProductResponse productResponse = new ProductResponse();
        copyProperties(p, productResponse);
        log.info("ProductServiceImpl | getProductById | productResponse :" + productResponse.toString());
        return productResponse;
    }

    @Override
    public void reduceQuantity(long productId, long quantity) {
        log.info("Reduce Quantity {} for Id: {}", quantity, productId);
        Product p = productRepository.findById(productId).orElseThrow(
                () -> new ProductServiceCustomException("Product with given Id not found","PRODUCT_NOT_FOUND"));
        if (p.getQuantity() < quantity) {
            throw new ProductServiceCustomException(
                    "Product does not have sufficient Quantity",
                    "INSUFFICIENT_QUANTITY"
            );
        }
        p.setQuantity(p.getQuantity() - quantity);
        productRepository.save(p);
        log.info("Product Quantity updated Successfully");
    }

    @Override
    public void deleteProductById(long productId) {
        log.info("Product id: {}", productId);
        if (!productRepository.existsById(productId)) {
            log.info("Im in this loop {}", !productRepository.existsById(productId));
            throw new ProductServiceCustomException(
                    "Product with given with Id: \" + productId + \" not found:",
                    "PRODUCT_NOT_FOUND"
            );
        }
        log.info("Deleting Product with id: {}", productId);
        productRepository.deleteById(productId);
    }
}
