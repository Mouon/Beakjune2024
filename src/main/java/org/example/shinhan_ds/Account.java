package org.example.shinhan_ds;

public class Account {
    private String accountNumber;
    private String owner;
    private int balance;

    // 빌더
    private Account(Builder builder) {
        this.accountNumber = builder.accountNumber;
        this.owner = builder.owner;
        this.balance = builder.balance;
    }

    public static class Builder{
        private String accountNumber;
        private String owner;
        private int balance;

        public Builder accountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder owner(String owner) {
            this.owner = owner;
            return this;
        }

        public Builder balance(int balance) {
            this.balance = balance;
            return this;
        }


        public Account build() {
            return new Account(this);
        }
    }

    // 게터, 세터
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public int getBalance() {
        return balance;
    }

    /** 예금
     * @param : 입금액*/
    public void deposit(int money) {
        this.balance+=money;
    }

    /** 출금
     * @param : 출금액*/
    public void withdraw(int money) {
        this.balance-=money;
    }

}