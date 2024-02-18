package com.record.company.com.domain.mapper;


import com.record.company.com.domain.dto.album.AlbumTitleDto;
import com.record.company.com.domain.dto.purchase.PurchaseDto;
import com.record.company.com.domain.dto.user.UserDto;
import com.record.company.com.domain.entity.Album;
import com.record.company.com.domain.entity.Purchase;
import com.record.company.com.domain.entity.User;

import java.util.ArrayList;
import java.util.List;

public class PurchaseMapper {


    public static List<PurchaseDto> purchaseMapper(List<Purchase> purchase){

        List<PurchaseDto> purchaseDtos = new ArrayList<>();

        for (Purchase purchaseList : purchase){

            PurchaseDto purchaseConvertDto = new PurchaseDto();

            purchaseConvertDto.setId(purchaseList.getId());
            purchaseConvertDto.setPurchaseCode(purchaseList.getPurchaseCode());
            purchaseConvertDto.setDateBooking(purchaseList.getDateBooking());
            purchaseConvertDto.setAlbumInfo(albumTitleDto(purchaseList.getAlbum()));
            purchaseConvertDto.setUser(userDto(purchaseList.getUser()));

            purchaseDtos.add(purchaseConvertDto);
        }

        return purchaseDtos;
    }

    public static AlbumTitleDto albumTitleDto (Album album){

        AlbumTitleDto albumTitle = new AlbumTitleDto();
        albumTitle.setId(album.getId());
        albumTitle.setTitleAlbum(album.getTitleAlbum());

        return albumTitle;
    }

    public static UserDto userDto (User user){

        String userName = user.getName();
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(userName);

        return userDto;
    }

    public PurchaseDto purchaseConvertDto (Purchase purchase){
        PurchaseDto purchaseDto = new PurchaseDto();

        purchaseDto.setUser(userDto(purchase.getUser()));
        purchaseDto.setPurchaseCode(purchase.getPurchaseCode());
        purchaseDto.setAlbumInfo(albumTitleDto(purchase.getAlbum()));
        purchaseDto.setDateBooking(purchase.getDateBooking());

        return purchaseDto;
    }

    public UserDto purchaseUserDto(Purchase purchase){
       return userDto(purchase.getUser());
    }
}


