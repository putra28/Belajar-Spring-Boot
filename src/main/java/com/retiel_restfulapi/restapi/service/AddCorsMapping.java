package com.retiel_restfulapi.restapi.service;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AddCorsMapping implements WebMvcConfigurer {

    @SuppressWarnings("null")
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Mengatur semua endpoint
                .allowedOrigins("http://localhost:3000") // Ganti dengan asal front-end kamu
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Metode HTTP yang diizinkan
                .allowedHeaders("*") // Header yang diizinkan
                .allowCredentials(true); // Jika kamu mengizinkan cookie untuk dikirim
    }
}