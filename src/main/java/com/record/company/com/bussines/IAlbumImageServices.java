package com.record.company.com.bussines;

import com.record.company.com.domain.dto.albumFile.AlbumFileDto;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.util.List;

public interface IAlbumImageServices {

    List<AlbumFileDto> getAllAlbumImage();

    AlbumFileDto getFileById(int id);

    Resource getAlbumImageById(int id) throws MalformedURLException;


    AlbumFileDto creteAlbumImage (MultipartFile file);

    AlbumFileDto updateAlbumImage (int id , MultipartFile file);

    AlbumFileDto deleteAlbumImage (int id);

}
