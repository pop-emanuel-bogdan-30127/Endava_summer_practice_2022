package com.example.demo.service;

import com.example.demo.model.Card;
import com.example.demo.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@Service
public class CardService {

    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public boolean setCard(Card card) throws Exception {
        if(checkCard(card.getNumber())) {
            cardRepository.setCard(card);
            return true;
            //return "Card approved\n";
        }
        else throw new Exception("Invalid card\n");
    }

    public boolean checkCard(String cardNo) throws Exception {
        int nDigits = cardNo.length();
        int nSum = 0;
        boolean isSecond = false;
        for (int i = nDigits - 1; i >= 0; i--)
        {
            int d = cardNo.charAt(i) - '0';
            if (isSecond == true)
                d = d * 2;
            nSum += d / 10;
            nSum += d % 10;
            isSecond = !isSecond;
        }
        if (nSum % 10 == 0)
            return true;
        throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).entity("Invalid card number.").build());
    }

}
