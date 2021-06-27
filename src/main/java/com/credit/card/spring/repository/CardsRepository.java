package com.credit.card.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.credit.card.spring.domain.CreditCard;

public interface CardsRepository extends JpaRepository<CreditCard, Long> {
}
