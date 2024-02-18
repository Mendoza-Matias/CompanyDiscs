package com.record.company.com.domain.dto.purchase;

import com.record.company.com.domain.dto.album.AlbumDto;
import com.record.company.com.domain.dto.album.AlbumInfoDto;
import com.record.company.com.domain.dto.album.AlbumTitleDto;
import com.record.company.com.domain.dto.user.UserDto;
import com.record.company.com.domain.entity.Album;
import com.record.company.com.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDto {

    private Integer id;

    private UserDto user;

    private String purchaseCode;

    private LocalDate dateBooking;

    private AlbumTitleDto albumInfo;

}
