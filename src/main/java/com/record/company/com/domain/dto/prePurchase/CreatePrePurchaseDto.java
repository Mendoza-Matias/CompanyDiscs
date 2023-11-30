package com.record.company.com.domain.dto.prePurchase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePrePurchaseDto {

    private int numberBooking;

    private Date dateBooking;
}
