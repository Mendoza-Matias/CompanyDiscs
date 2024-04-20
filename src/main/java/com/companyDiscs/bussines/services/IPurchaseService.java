package com.companyDiscs.bussines.services;

import com.companyDiscs.domain.dto.purchase.PurchaseDto;

public interface IPurchaseService {
    PurchaseDto purchaseAlbum(Long clientId , Long albumId);
}
