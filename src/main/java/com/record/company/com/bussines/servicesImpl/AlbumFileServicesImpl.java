package com.record.company.com.bussines.servicesImpl;

import com.record.company.com.bussines.IAlbumImageServices;
import com.record.company.com.domain.dto.albumFile.AlbumFileDto;
import com.record.company.com.domain.entity.AlbumImage;
import com.record.company.com.exception.AlbumImageException;
import com.record.company.com.exception.NotFoundException;
import com.record.company.com.persistence.repository.IAlbumFileRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

import java.io.File;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AlbumFileServicesImpl implements IAlbumImageServices {

    @Autowired
    private IAlbumFileRepository albumFileRepository;

    @Autowired
    private ModelMapper modelMapper;

    private Path rootLocation;

    private final String FILE_PATH = "C:\\Users\\leona\\Desktop\\imagenes";

    @Override
    public List<AlbumFileDto> getAllAlbumImage() {
        return albumFileRepository.findAll().stream().map(albumFile -> modelMapper.map(albumFile, AlbumFileDto.class)).collect(Collectors.toList());
    }

    @Override
    public AlbumFileDto getFileById(int id) {
        return modelMapper.map(albumFileRepository.findById(id), AlbumFileDto.class);
    }

    @Override
    public Resource getAlbumImageById(int id) throws MalformedURLException {
        AlbumImage albumImage = albumFileRepository.findById(id).orElseThrow(() -> new NotFoundException("Album image not found"));

        Path imagePath = Paths.get(albumImage.getPath(), albumImage.getNameImg());
        Resource resource = new UrlResource(imagePath.toUri());

        if (resource.exists() && resource.isReadable()) {
            return resource;
        } else {
            throw new AlbumImageException("Album image not found");
        }
    }

    @Override
    public AlbumFileDto creteAlbumImage(MultipartFile file) {

        AlbumImage albumFile = null;

        try {
            String fileName = UUID.randomUUID().toString();
            byte[] bytes = file.getBytes();
            String fileOriginalName = file.getOriginalFilename();


            long fileSize = file.getSize();
            long maxFileSize = 5 * 1024 * 1024;

            if (fileSize > maxFileSize) {
                return null;
            }

            if (!fileOriginalName.endsWith(".jpg") &&
                    !fileOriginalName.endsWith(".jpeg")
                    && !fileOriginalName.endsWith(".png")

            ) {
                throw new AlbumImageException("Album image not compatibility");
            }

            String fileExtension = fileOriginalName.substring(fileOriginalName.lastIndexOf("."));
            String newFileName = fileName + fileExtension;


            File folder = new File(FILE_PATH);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            Path path = Paths.get(FILE_PATH + "/" + newFileName);
            Files.write(path, bytes);

            albumFile.setPath(FILE_PATH);
            albumFile.setNameImg(newFileName);
            albumFile.setType(fileExtension);
            albumFile.setUrlImageLocation("/api/v1/albumFile/" + newFileName);

            return modelMapper.map(albumFileRepository.save(albumFile), AlbumFileDto.class);
        } catch (Exception e) {
            throw new AlbumImageException("Error save album image");
        }
    }

    @Override
    public AlbumFileDto updateAlbumImage(int id, MultipartFile file) {

        Optional<AlbumImage> albumFileExist = albumFileRepository.findById(id);

        if (albumFileExist.isPresent()) {
            AlbumImage albumFile = albumFileExist.get();

            try {
                String fileName = UUID.randomUUID().toString();
                byte[] bytes = file.getBytes();
                String fileOriginalName = file.getOriginalFilename();


                long fileSize = file.getSize();
                long maxFileSize = 5 * 1024 * 1024;

                if (fileSize > maxFileSize) {
                    return null;
                }

                if (!fileOriginalName.endsWith(".jpg") &&
                        !fileOriginalName.endsWith(".jpeg")
                        && !fileOriginalName.endsWith(".png")

                ) {
                    throw new AlbumImageException("Image not compatibility");
                }

                String fileExtension = fileOriginalName.substring(fileOriginalName.lastIndexOf("."));
                String newFileName = fileName + fileExtension;


                File folder = new File(FILE_PATH);
                if (!folder.exists()) {
                    folder.mkdirs();
                }

                Path path = Paths.get(FILE_PATH + "/" + newFileName);
                Files.write(path, bytes);

                albumFile.setPath(FILE_PATH);
                albumFile.setNameImg(newFileName);
                albumFile.setType(fileExtension);
                albumFile.setUrlImageLocation("/api/v1/albumFile/" + newFileName);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return modelMapper.map(albumFileRepository.save(albumFile), AlbumFileDto.class);
        }
        throw new AlbumImageException("Album image not found");
    }

    @Override
    public AlbumFileDto deleteAlbumImage(int id) {
        Optional<AlbumImage> albumFileExist = albumFileRepository.findById(id);
        if(albumFileExist.isPresent()){
            AlbumImage albumFile = albumFileExist.get();
            albumFileRepository.deleteById(id);
            return modelMapper.map(albumFile,AlbumFileDto.class);
        }else {
            throw new AlbumImageException("Album image not found");
        }
    }

}
