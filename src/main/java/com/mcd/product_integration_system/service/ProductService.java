package com.mcd.product_integration_system.service;

import com.mcd.product_integration_system.model.Product;
import com.mcd.product_integration_system.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mahmutcandurak
 */

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void saveProducts(Product product) {
        productRepository.save(product);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id).get();
    }

    public void saveAll(List<Product> productList) {
        productRepository.saveAll(productList);
    }

}