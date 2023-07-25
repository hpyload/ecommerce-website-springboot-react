package com.ecommercewebsite.service;

import com.ecommercewebsite.dto.auth.LoginDTO;
import com.ecommercewebsite.dto.auth.RegisterDTO;

public interface AuthService {
    String login(LoginDTO loginDto);
    String register(RegisterDTO loginDto);
}

