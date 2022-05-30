package com.mcd.product_integration_system.repository;

import com.mcd.product_integration_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author mahmutcandurak
 */

public interface LoginRepository extends JpaRepository<User, Long> {

    User findByUsernameAndPassword(String username, String password);
}
