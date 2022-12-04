package com.example.datn_motel_project.security.config;

import com.example.datn_motel_project.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.singletonList;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AccountService accountService;

    @Autowired
    private LoginSuccessHandler loginSuccessHandler;
    @Bean
    public PasswordEncoder passwordEncoder() {
        // Password encoder, để Spring Security sử dụng mã hóa mật khẩu người dùng
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(accountService) // Cung cáp accountservice cho spring security
                .passwordEncoder(passwordEncoder()); // cung cấp password encoder
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String[] staticResources  =  {
                "/css/**",
                "/image/**",
                "/js/**",
                "/vendor/**"
        };
        http.cors().configurationSource(corsConfigurationSource()).and().csrf().
                disable()
                .authorizeRequests()
                .antMatchers(staticResources).permitAll()
                .antMatchers("/", "/home","/dummy/**").permitAll() // Cho phép tất cả mọi người truy cập vào 2 địa chỉ này
                .anyRequest().authenticated() // Tất cả các request khác đều cần phải xác thực mới được truy cập
                .and()
                .formLogin()
                .loginPage("/login").loginProcessingUrl("/login") // Cho phép người dùng xác thực bằng form login
                .successHandler(loginSuccessHandler)
                .permitAll() // Tất cả đều được truy cập vào địa chỉ này
                .and()
                .logout() // Cho phép logout
                .permitAll();
        http.csrf().disable();
    }
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        List<String> allowOrigins = Arrays.asList("*");
        configuration.setAllowedOrigins(allowOrigins);
        configuration.setAllowedMethods(singletonList("*"));
        configuration.setAllowedHeaders(singletonList("*"));
        //in case authentication is enabled this flag MUST be set, otherwise CORS requests will fail
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
