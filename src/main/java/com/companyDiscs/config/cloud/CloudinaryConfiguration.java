package com.companyDiscs.config.cloud;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfiguration {

    @Value("${spring.cloudinary.nameCloud}")
    private String nameCloud;
    @Value("${spring.cloudinary.apiKey}")
    private String apiKey;
    @Value("${spring.cloudinary.apiSecret}")
    private String apiSecret;
    public Cloudinary cloudinary(){
        return  new Cloudinary(
                ObjectUtils.asMap(
                        "nameCloud",nameCloud,
                        "apiKey",apiKey,
                        "apiSecret", apiKey
                ));
    }
}
