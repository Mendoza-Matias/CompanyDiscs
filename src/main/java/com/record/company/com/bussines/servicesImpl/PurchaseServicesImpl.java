package com.record.company.com.bussines.servicesImpl;

import com.record.company.com.bussines.IPurchaseServices;
import com.record.company.com.domain.dto.purchase.PurchaseDto;
import com.record.company.com.domain.dto.user.UserDto;
import com.record.company.com.domain.entity.Album;
import com.record.company.com.domain.entity.Purchase;
import com.record.company.com.domain.entity.User;
import com.record.company.com.domain.mapper.PurchaseMapper;
import com.record.company.com.exception.NotFoundException;
import com.record.company.com.exception.PurchaseException;
import com.record.company.com.persistence.repository.IAlbumRepository;
import com.record.company.com.persistence.repository.IPurchaseRepository;
import com.record.company.com.persistence.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PurchaseServicesImpl implements IPurchaseServices {

    @Autowired
    private IPurchaseRepository purchaseRepository;

    @Autowired
    private IAlbumRepository albumRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PurchaseDto> GetAllPrePurchase() {
        return PurchaseMapper.purchaseMapper(purchaseRepository.findAll());
    }

    @Override
    public PurchaseDto getPurchaseById(int id) {
        return modelMapper.map(purchaseRepository.findById(id),PurchaseDto.class);
    }

    @Override
    public PurchaseDto createPurchase(int userId, int albumId ){

        User user = userRepository.findById(userId).orElseThrow(()-> new NotFoundException("User not found"));
        Album album = albumRepository.findById(albumId).orElseThrow(()-> new NotFoundException("Album not found"));

        Purchase purchase = Purchase.builder()
                .user(user)
                .dateBooking(LocalDate.now())
                .purchaseCode(UUID.randomUUID().toString())
                .album(album)
                .build();

        purchaseRepository.save(purchase);
        return new PurchaseMapper().purchaseConvertDto(purchase);
    }

    @Override
    public PurchaseDto updatePurchase(int id,int idAlbum) {

        Optional<Purchase> purchase = purchaseRepository.findById(id);
        Album album = albumRepository.findById(idAlbum).orElseThrow(()-> new NotFoundException("Album not found"));
        Purchase newPurchase = null;

        if(purchase.isPresent()){

            newPurchase = purchase.get();
            newPurchase.setAlbum(album);
            newPurchase.setDateBooking(LocalDate.now());
            newPurchase.setPurchaseCode(UUID.randomUUID().toString());

            return modelMapper.map(purchaseRepository.save(newPurchase),PurchaseDto.class);
        }else{
            throw new PurchaseException("Purchase not found");
        }

    }

    @Override
    public PurchaseDto deletePurchase(int id) {
        Optional<Purchase> purchase = purchaseRepository.findById(id);
        if(purchase.isPresent()){
            Purchase purchasDelete = purchase.get();
            purchaseRepository.deleteById(id);
            return modelMapper.map(purchasDelete,PurchaseDto.class);
        }else{
            throw new PurchaseException("Purchase not found");
        }

    }

    @Override
    public UserDto getUserByPurchaseCode(String purchaseCode) {
        return new PurchaseMapper().purchaseUserDto(purchaseRepository.getUserByPurchaseCode(purchaseCode));
    }

}
