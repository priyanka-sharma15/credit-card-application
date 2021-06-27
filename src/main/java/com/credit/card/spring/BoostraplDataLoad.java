package com.credit.card.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.credit.card.spring.repository.CardsRepository;

@Component
public class BoostraplDataLoad implements CommandLineRunner {

    private final CardsRepository cardsRepository;
    
    public BoostraplDataLoad(CardsRepository cardsRepository) {
        this.cardsRepository = cardsRepository;
    }

    @Override
    public void run(String... args) {
    }
}
