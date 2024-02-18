package com.record.company.com.presentation.controller;

import com.record.company.com.bussines.IAlbumImageServices;
import com.record.company.com.domain.dto.albumFile.AlbumFileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.net.MalformedURLException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/albumImage")
public class AlbumImageController {


    @Autowired
    private IAlbumImageServices albumFileServices;

    @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_USER')")
    @GetMapping
    public ResponseEntity<List<AlbumFileDto>> getAllFileAlbum(){
        return ResponseEntity.ok(albumFileServices.getAllAlbumImage());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_USER')")
    @GetMapping("{id}")
    public ResponseEntity<Resource> getAlbumFileById(@PathVariable("id") int id) throws MalformedURLException {
        AlbumFileDto albumFileDto = albumFileServices.getFileById(id);
        Resource resource = albumFileServices.getAlbumImageById(id);
        HttpHeaders headers = new HttpHeaders();
        String fileExtension = StringUtils.getFilenameExtension(albumFileDto.getNameImg());
        MediaType mediaType = MediaType.parseMediaType("image/" + fileExtension.toLowerCase());
        headers.setContentType(mediaType);
        return new ResponseEntity<>(resource,headers,HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_USER')")
    @PostMapping
    public ResponseEntity<AlbumFileDto> createAlbumFile (@RequestParam("image") MultipartFile file){
        return  ResponseEntity.created(URI.create("/api/v1/albumFile")).body(albumFileServices.creteAlbumImage(file));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("{id}")
    public ResponseEntity<AlbumFileDto> uptadateAlbumFile(@PathVariable("id") int id , @RequestParam("image") MultipartFile file){
        return ResponseEntity.ok(albumFileServices.updateAlbumImage(id,file));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<AlbumFileDto> deleteAlbumFile(@PathVariable("id") int id){
        return ResponseEntity.ok(albumFileServices.deleteAlbumImage(id));
    }
}
