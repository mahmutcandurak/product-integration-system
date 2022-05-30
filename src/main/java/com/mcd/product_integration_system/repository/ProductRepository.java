package com.mcd.product_integration_system.repository;

import com.mcd.product_integration_system.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author mahmutcandurak
 */

public interface ProductRepository extends JpaRepository<Product,Long> {

}
