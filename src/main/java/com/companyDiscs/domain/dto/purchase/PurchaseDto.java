package com.companyDiscs.domain.dto.purchase;

import com.companyDiscs.domain.dto.album.AlbumDto;
import com.companyDiscs.domain.dto.client.ClientDto;
import com.companyDiscs.domain.entity.Album;
import com.companyDiscs.domain.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PurchaseDto {

    private ClientDto clientDto;

    private AlbumDto albumDto;

}
