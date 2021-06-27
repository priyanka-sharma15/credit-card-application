package com.credit.card.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.credit.card.spring.domain.CreditCard;
import com.credit.card.spring.repository.CardsRepository;
import com.credit.card.spring.util.Luhn10;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/cards")
public class CreditCardController {

    @Autowired
	Luhn10 luhn10;
    
	private final CardsRepository cardsRepository;
    
    public CreditCardController(CardsRepository cardsRepository ) {
        this.cardsRepository = cardsRepository;
    }

    @GetMapping
    public List<CreditCard> getClients() {
        return cardsRepository.findAll();
    }

    @GetMapping("/{id}")
    public CreditCard getCards(@PathVariable Long id) {
        return cardsRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createCard(@RequestBody CreditCard creditCard) throws URISyntaxException {
    	if(luhn10.Check(creditCard.getCcNumber())) {
    		CreditCard savedClient = cardsRepository.save(creditCard);
            return ResponseEntity.created(new URI("/cards/" + savedClient.getId())).body(savedClient);	
    	}else {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid card Number");
    	}    	
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCard(@PathVariable Long id, @RequestBody CreditCard creditCard) {
        CreditCard currentClient = cardsRepository.findById(id).orElseThrow(RuntimeException::new);
        currentClient.setName(creditCard.getName());
        currentClient.setLimit(creditCard.getLimit());
        currentClient = cardsRepository.save(creditCard);
        return ResponseEntity.ok(currentClient);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCard(@PathVariable Long id) {
    	cardsRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
