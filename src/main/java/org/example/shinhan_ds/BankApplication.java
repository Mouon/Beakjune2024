package org.example.shinhan_ds;

import java.util.*;

public class BankApplication {
    private static ArrayList<Account> accounts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("-----------------------------------------");
            System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료 ");
            System.out.println("-----------------------------------------\n");
            System.out.print("선택> ");

            int selectNo = scanner.nextInt();
            scanner.nextLine();

            if(selectNo==1) {
                createAccount();
            }else if(selectNo==2) {
                listAccounts();
            }else if(selectNo==3) {
                deposit();
            }else if(selectNo==4){
                withdraw();
            }else if(selectNo==5) {
                System.out.println("프로그램 종료");
                break;
            }
        }
    }

    private static void createAccount() {
        System.out.print("계좌번호: ");
        String accountNumber = scanner.nextLine();

        System.out.print("계좌주: ");
        String owner = scanner.nextLine();

        System.out.print("초기입금액: ");
        int initBalance = scanner.nextInt();

        Account account = new Account.Builder()
                .accountNumber(accountNumber)
                .owner(owner)
                .balance(initBalance)
                .build();

        accounts.add(account);
        System.out.println("결과: 계좌가 생성되었습니다.");
    }

    private static void listAccounts() {
        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            System.out.println(account.getAccountNumber() + "   " + account.getOwner() + "   " + account.getBalance());
        }
    }

    private static void deposit() {
        System.out.print("계좌번호: ");
        String accountNumber = scanner.nextLine();

        System.out.print("예금액: ");
        int money = scanner.nextInt();

        Account account = findAccount(accountNumber);
        if (account != null) {
            account.deposit(money);
            System.out.println("결과: 예금이 성공되었습니다.");
            System.out.println("잔액: "+account.getBalance());
        }
    }

    private static void withdraw() {
        System.out.print("계좌번호: ");
        String accountNumber = scanner.nextLine();

        System.out.print("출금액: ");
        int amount = scanner.nextInt();

        Account account = findAccount(accountNumber);
        if (account != null) {
            if (account.getBalance() >= amount) {
                account.withdraw(amount);
                System.out.println("결과: 출금이 성공되었습니다.");
            } else {
                System.out.println("결과: 잔액이 부족합니다.");
            }
        }
    }

    private static Account findAccount(String accNumber) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber().equals(accNumber)) {
                return accounts.get(i);
            }
        }
        return null;
    }
}