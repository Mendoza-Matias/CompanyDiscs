package com.companyDiscs.domain.dto.payment;

import com.companyDiscs.domain.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDto {
    private String client;
    private String description;
    private double amount;
    private Currency currency;
}
