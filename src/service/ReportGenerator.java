package service;

import model.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReportGenerator {

    public void generateReport(ArrayList<Transaction> transactions) {

        if (transactions.isEmpty()) {
            System.out.println("No transactions available for reporting.");
            return;
        }

        double totalIncome = 0;
        double totalExpenses = 0;

        HashMap<String, Double> categoryTotals = new HashMap<>();

        for (Transaction transaction : transactions) {

            if (transaction.getType().equalsIgnoreCase("Income")){

                totalIncome += transaction.getAmount();

            } else if (transaction.getType().equalsIgnoreCase("Expense")) {

                totalExpenses += transaction.getAmount();

                String category = transaction.getCategory();

                categoryTotals.put(category,
                        categoryTotals.getOrDefault(category, 0.0)
                                + transaction.getAmount()

                );
            }
        }

        double balance = totalIncome - totalExpenses;

        double savingsRate = 0;

        if (totalIncome > 0) {
            savingsRate = (balance / totalIncome) * 100;
        }

        String topCategory = "None";
        double highestSpending = 0;

        for (Map.Entry<String, Double> entry : categoryTotals.entrySet()) {

            if (entry.getValue() > highestSpending) {

                highestSpending = entry.getValue();
                topCategory = entry.getKey();
            }
        }

        System.out.println("\n=================================");
        System.out.println("      FINANCIAL REPORT");
        System.out.println("\n=================================");

        System.out.printf("Total Income:       R%.2f%n", totalIncome);
        System.out.printf("Total Expenses:     R%.2f%n", totalExpenses);
        System.out.printf("Current Balance:    R%.2f%n", balance);

        System.out.println();

        System.out.printf("Savings Rate:       %.2f%%%n", savingsRate);
        System.out.println("Transactions:       "
                + transactions.size());

        System.out.println("Top Spending Category: "
                + topCategory);

        System.out.println();

        System.out.println("===== EXPENSE BREAKDOWN =====");

        for (Map.Entry<String, Double> entry : categoryTotals.entrySet()) {

            System.out.printf("%-15s R%.2f%n",
                    entry.getKey(),
                    entry.getValue());
            }
        }
    }
