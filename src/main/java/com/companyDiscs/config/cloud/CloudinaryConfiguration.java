package com.companyDiscs.config.cloud;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfiguration {

    @Value("${spring.cloudinary.cloudName}")
    private String cloudName;
    @Value("${spring.cloudinary.apiKey}")
    private String apiKey;
    @Value("${spring.cloudinary.apiSecret}")
    private String apiSecret;

    @Bean
    public Cloudinary cloudinary(){
        return  new Cloudinary(
                ObjectUtils.asMap(
                        "nameCloud",cloudName,
                        "apiKey",apiKey,
                        "apiSecret", apiKey
                ));
    }
}
