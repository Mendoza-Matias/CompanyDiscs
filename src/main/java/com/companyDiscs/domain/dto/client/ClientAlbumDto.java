package com.companyDiscs.domain.dto.client;

import com.companyDiscs.domain.dto.album.AlbumDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClientAlbumDto {

    private Long id;

    private List<AlbumDto> albums;
}
