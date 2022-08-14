package com.example.demo.repository;

import com.example.demo.model.Card;
import org.springframework.stereotype.Repository;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@Repository
public class CardRepository {

    private Card card;

    public CardRepository() {
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Card getCard(){
        return card;
    }

}

