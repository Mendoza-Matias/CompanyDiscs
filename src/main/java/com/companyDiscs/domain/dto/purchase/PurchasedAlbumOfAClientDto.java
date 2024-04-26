package com.companyDiscs.domain.dto.purchase;

import com.companyDiscs.domain.dto.album.AlbumBasicInformationDto;
import com.companyDiscs.domain.dto.album.AlbumDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PurchasedAlbumOfAClientDto {

    private String name;

    private List<AlbumBasicInformationDto> albums;
}
