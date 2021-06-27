package com.credit.card.spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CreditCard")
public class CreditCard {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="name")
    private String name;
    
    @Column(name="limit2")
    private String limit;
    
    @Column(name="balance")
    private int balance=0;
    
    @Column(name="ccNumber")
    private String ccNumber;
    public CreditCard() {
    }

    public CreditCard(String name, int balance, String limit,String ccNumber) {
        this.name = name;
        this.balance = balance;
        this.limit = limit;
        this.ccNumber=ccNumber;
    }

    public CreditCard(Long id, String name, int balance, String limit,String ccNumber) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.limit = limit;
        this.ccNumber=ccNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public String getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}
	
	

}
