package com.record.company.com.domain.dto.user;

import com.record.company.com.domain.entity.PrePurchase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PrePurchaseUserDto {

    private List<PrePurchase> purchasedAlbum;
}
