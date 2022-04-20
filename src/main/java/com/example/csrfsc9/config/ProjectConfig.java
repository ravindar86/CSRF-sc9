package com.example.csrfsc9.config;

import com.example.csrfsc9.security.CustomCsrfTokenFilter;
import com.example.csrfsc9.security.CustomCsrfTokenRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        //  http.csrf().disable();      // disable the csrf which enable hacker to access the resource

        http.csrf( c -> {
           c.ignoringAntMatchers("/csrfdisabled/**");
          // c.csrfTokenRepository(new CustomCsrfTokenRepository());        // generates the custom token
        });

        // add the custom filter to log the token after the default csrf filter
        // CsrfFilter will generate the token
        // Custom Csrf Filter will log the token
        http.addFilterAfter(new CustomCsrfTokenFilter(), CsrfFilter.class);
    }
}
