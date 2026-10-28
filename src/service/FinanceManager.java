package service;

import model.Transaction;

import java.util.ArrayList;

public class FinanceManager {

    // store all transactions
    private ArrayList<Transaction> transactions;

    // constructor
    public FinanceManager() {
        transactions = new ArrayList<>();
    }

    // add a transaction
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        System.out.println("Transaction added successfully.");
    }

    // view all transactions
    public void viewTransactions() {

        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        System.out.println("\\n===== TRANSACTION HISTORY =====");

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public void setTransactions(
            ArrayList<Transaction> transactions) {

        this.transactions = transactions;
    }

    // calculate total income
    public double calculateTotalIncome() {

        double totalIncome = 0;

        for (Transaction transaction : transactions) {

            if (transaction.getType().equalsIgnoreCase("Income")) {
                totalIncome += transaction.getAmount();
            }
        }

       return totalIncome;
    }

    // calculate total expenses
    public double calculateTotalExpenses() {

        double totalExpenses = 0;

                for (Transaction transaction : transactions) {

                    if (transaction.getType().equalsIgnoreCase("Expense")) {
                        totalExpenses += transaction.getAmount();
                    }
                }

                return totalExpenses;
    }

    // calculate current balance
    public double calculateBalance() {
        return calculateTotalIncome() - calculateTotalExpenses();
    }

    // return transaction list
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

}