package com.record.company.com.bussines.services;

import com.record.company.com.domain.dto.prePurchase.AlbumPrePurchaseDto;
import com.record.company.com.domain.dto.prePurchase.CreatePrePurchaseDto;
import com.record.company.com.domain.dto.prePurchase.PrePurchaseDto;
import com.record.company.com.domain.dto.prePurchase.UserPrePurchaseDto;

import java.util.List;

public interface IPrePurchaseServices {


    List<PrePurchaseDto> GetAllPrePurchase();

    PrePurchaseDto getPrePurchaseById(int id);

    PrePurchaseDto createPrePurchase(CreatePrePurchaseDto prePurchase);

    PrePurchaseDto updatePrePurchase(int id , CreatePrePurchaseDto prePurchase);

    PrePurchaseDto deletePrePurchase(int id);

    UserPrePurchaseDto getUserPrePurchaseById (int id);

    AlbumPrePurchaseDto getAlbumPrePurchaseById (int id);


}
