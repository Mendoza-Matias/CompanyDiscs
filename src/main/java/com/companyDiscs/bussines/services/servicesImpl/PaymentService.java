package com.companyDiscs.bussines.services.servicesImpl;

import com.companyDiscs.domain.dto.album.AlbumDto;
import com.companyDiscs.domain.dto.client.ClientDto;
import com.companyDiscs.domain.dto.payment.PaymentDto;
import com.companyDiscs.domain.enums.Currency;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${stripe.key.secret}")
    private String secretKey;

    public PaymentIntent paymentForAlbum(Long clientId , Long albumId , Currency currency) throws StripeException {
        Stripe.apiKey = secretKey;

        PaymentDto paymentDto = PaymentDto.builder()
                .currency(currency)
                .build();

        Map<String,Object> params = new HashMap<>();
        //params.put("description " , "Payment for album" + albumDto.getName());
        //params.put("amount", albumDto.getPrice());
        params.put("currency", currency);

        ArrayList<Object> payment_method_types = new ArrayList<>();
        payment_method_types.add("card");
        params.put("payment_method_types",payment_method_types);

        return PaymentIntent.create(params);
    }

    public PaymentIntent confirm (String id) throws StripeException {
        Stripe.apiKey = secretKey;
        PaymentIntent paymentIntent = PaymentIntent.retrieve(id);

        Map<String,Object> params = new HashMap<>();
        params.put("payment_method","pm_card_visa");
        paymentIntent.confirm(params);
        return paymentIntent;
    }

    public  PaymentIntent cancel (String id) throws StripeException {
        Stripe.apiKey = secretKey;
        PaymentIntent paymentIntent = PaymentIntent.retrieve(id);
        paymentIntent.cancel();
        return paymentIntent;
    }
}
