package com.record.company.com.bussines;

import com.record.company.com.domain.dto.purchase.PurchaseDto;
import com.record.company.com.domain.dto.user.UserDto;

import java.util.List;


public interface IPurchaseServices {


    List<PurchaseDto> GetAllPrePurchase();

    PurchaseDto getPurchaseById(int id);

    PurchaseDto createPurchase(int idAlbum ,int idUser);

    PurchaseDto updatePurchase(int id , int idAlbum);

    PurchaseDto deletePurchase(int id);

    UserDto getUserByPurchaseCode(String purchaseCode);
}
