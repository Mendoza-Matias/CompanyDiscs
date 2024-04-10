package com.companyDiscs.domain.dto.client;

import com.companyDiscs.domain.dto.album.AlbumDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientAlbumDto {

    private Long id;

    private List<AlbumDto> albums;
}
