package com.companyDiscs.bussines.services.servicesImpl;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ImageService {
    @Autowired
    private Cloudinary cloudinary;
    public String UploadImage(byte image , String folderName){
        String imageUrl = "";

        try{
            HashMap<Object,Object> storage = new HashMap<>();
            storage.put("folder",folderName);
            Map saveImage = cloudinary.uploader().upload(image,storage);
            String id = (String) saveImage.get("public_id");
            imageUrl = cloudinary.url().secure(true).generate(id);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return imageUrl;
    }

}
