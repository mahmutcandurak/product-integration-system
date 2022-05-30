package com.mcd.product_integration_system.service;

import com.mcd.product_integration_system.model.User;
import com.mcd.product_integration_system.repository.LoginRepository;
import org.springframework.stereotype.Service;

/**
 * @author mahmutcandurak
 */

@Service
public class LoginService {


    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public User login(String username, String password) {
        User user = loginRepository.findByUsernameAndPassword(username, password);
        return user;
    }

}
