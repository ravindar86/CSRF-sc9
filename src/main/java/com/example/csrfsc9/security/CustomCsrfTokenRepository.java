package com.example.csrfsc9.security;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * To overwrite the token generation with custom token
 */
public class CustomCsrfTokenRepository implements CsrfTokenRepository {


    @Override
    public CsrfToken generateToken(HttpServletRequest httpServletRequest) {
        CsrfToken customToken = new DefaultCsrfToken("X-CSRF-TOKEN",
                "_csrf","123456789");

        return customToken;
    }

    @Override
    public void saveToken(CsrfToken csrfToken, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

    }

    @Override
    public CsrfToken loadToken(HttpServletRequest httpServletRequest) {
        return null;
    }
}
