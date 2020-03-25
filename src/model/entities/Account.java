package model.entities;

import model.exceptions.AccountExceptions;

public class Account {
	private Integer number;
	private String holder;
	private double balance;
	private double withDrawLimit;
	
	//constructors
	public Account(){
	}
	
	public Account(Integer number, String holder, double balance, double withDrawLimit){
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withDrawLimit = withDrawLimit;
	}

	//getters and setters
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public double getBalance() {
		return balance;
	}

	public double getWithDrawLimit() {
		return withDrawLimit;
	}

	//metods withDraw and Deposit
	public void withDraw(double amount) throws AccountExceptions{
		
		if(amount > balance) {
			throw new AccountExceptions("Valor de saque maior que o saldo disponível!!");
		}
		else if(amount > withDrawLimit) {
			throw new AccountExceptions("Valor de saque maior que o limite!!");
		}
		else if(amount < 0) {
			throw new AccountExceptions("Valor de Saque deve ser Positivo!!");
		}
		balance -= amount;
		
	}
	public void Deposit(double amount) throws AccountExceptions {
		if (amount < 0) {
			throw new AccountExceptions("Valor de deposito deve ser positivo!!");
		}
		 balance += amount;
	}
}
