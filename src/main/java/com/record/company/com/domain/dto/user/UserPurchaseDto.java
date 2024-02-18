package com.record.company.com.domain.dto.user;

import com.record.company.com.domain.dto.album.AlbumInfoDto;
import com.record.company.com.domain.entity.Purchase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserPurchaseDto {

    private AlbumInfoDto album;

    private String purchaseCode;
}
