package model.application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.AccountExceptions;

public class program {

	public static void main(String[] args) throws AccountExceptions {
	
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		int escolha = 0;
		
		System.out.println("***** Banco do Tiago *****");
		System.out.println();
		System.out.println("Você não tem uma conta criada, vamos criar uma!!");
		System.out.println("Entre com os dados da conta: ");
		
		System.out.print("Número da conta: ");
		int number = sc.nextInt();
		System.out.print("Nome do Titular: ");
		sc.nextLine();
		String holder = sc.next();
		System.out.print("Valor Inicial da conta: ");
		double balance = sc.nextDouble();
		System.out.print("Limite de Saques: ");
		double withDrawLimit = sc.nextDouble();
		
		Account account = new Account(number, holder, balance, withDrawLimit);
		
		System.out.println();
		System.out.println("Conta criada!!!!");
		do {
		System.out.println();
		System.out.println("**Opções Disponíveis**");
		System.out.println("1 - Sacar um valor"); 
		System.out.println("2 - Depositar um valor");
		System.out.print("Selecione uma opção!!");
		escolha = sc.nextInt();

		switch(escolha){
			case 1:{
				System.out.println();
				System.out.print("Insira um valor de saque: ");
				double amount = sc.nextDouble();
				try {
					account.withDraw(amount);
					System.err.println("Novo Saldo! " + String.format("%.2f",  account.getBalance()));
				}
				catch(AccountExceptions e){
					System.out.println("Erro no saque: " + e.getMessage());
				}
				catch(RuntimeException e) {
					System.out.println("Erro não tratado, contate o suporte");
				}
				break;
			}
			case 2:{
				System.out.println();
				System.out.print("Insira um valor de deposito: ");
				double amount = sc.nextDouble();
				try {
					account.Deposit(amount);
					System.err.println("Novo Saldo! " + String.format("%.2f",  account.getBalance()));
				}
				catch(AccountExceptions e) {
					System.out.println("Erro no saque: " + e.getMessage());
				}
				catch(RuntimeException e) {
					System.out.println("Erro não tratado, contate o suporte)");
				}
				break;
			}
			default:
				System.err.println("Opção Inválida!!");
				break;
			} 
		}while (escolha != 0);
		sc.close();
	}
}
