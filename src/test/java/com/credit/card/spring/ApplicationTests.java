package com.credit.card.spring;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.credit.card.spring.domain.CreditCard;
import com.credit.card.spring.repository.CardsRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CreditCardApplication.class)
public class ApplicationTests {
	
	@Autowired
	private CardsRepository cardsRepo;

	@Test
	public void testCreditCard(){
		CreditCard cerditCardObj = new CreditCard("test", 0, "2000", "2345676543");
		CreditCard newCard = cardsRepo.save(cerditCardObj);
		assertNotNull(newCard);
		assertNotNull(newCard.getCcNumber());
		
		List<CreditCard> allCards = cardsRepo.findAll();
		assertNotNull(allCards);
		assertFalse(allCards.isEmpty());
		
	}

}
