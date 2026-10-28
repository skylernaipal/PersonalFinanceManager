package app;

import model.Transaction;
import service.FinanceManager;
import model.SavingsGoal;
import service.ReportGenerator;
import data.FileHandler;
import service.CSVExporter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FinanceManager manager = new FinanceManager();
        manager.setTransactions(
                FileHandler.loadTransactions()
        );

        manager.setTransactions(FileHandler.loadTransactions());
        SavingsGoal savingsGoal = new SavingsGoal(0);
        ReportGenerator reportGenerator = new ReportGenerator();

        int choice;
        int transactionId = 1;

                do {

                    System.out.println("\n=================================");
                    System.out.println(" PERSONAL FINANCE MANAGER");
                    System.out.println("=================================");
                    System.out.println("1. Add Income");
                    System.out.println("2. Add Expense");
                    System.out.println("3. View Transactions");
                    System.out.println("4. View Financial Summary");
                    System.out.println("5. Generate Report");
                    System.out.println("6. Set Savings Goal");
                    System.out.println("7. Add To Savings");
                    System.out.println("8. View Savings Goal");
                    System.out.println("9. Export CSV");
                    System.out.println("10. Exit");
                    System.out.print("Enter choice: ");

                    choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {

                        case 1:

                            System.out.println("\n--- Add Income ---");

                            System.out.print("Enter category: ");
                            String incomeCategory = scanner.nextLine();

                            System.out.print("Enter amount: ");
                            double incomeAmount = scanner.nextDouble();
                            scanner.nextLine();

                            System.out.print("Enter date (YYYY-MM-DD): ");
                            String incomeDate = scanner.nextLine();

                            System.out.print("Enter description: ");
                            String incomeDescription = scanner.nextLine();

                            Transaction income = new Transaction(
                                    transactionId++,
                                    "Income",
                                    incomeCategory,
                                    incomeAmount,
                                    incomeDate,
                                    incomeDescription
                            );

                            manager.addTransaction(income);
                            break;

                        case 2:

                            System.out.println("\n--- Add Expense ---");

                            System.out.print("Enter category: ");
                            String expenseCategory = scanner.nextLine();

                            System.out.print("Enter amount: ");
                            double expenseAmount = scanner.nextDouble();
                            scanner.nextLine();

                            System.out.print("Enter date (YYYY-MM-DD): ");
                            String expenseDate = scanner.nextLine();

                            System.out.print("Enter description: ");
                            String expenseDescription = scanner.nextLine();

                            Transaction expense = new Transaction(
                                    transactionId++,
                                    "Expense",
                                    expenseCategory,
                                    expenseAmount,
                                    expenseDate,
                                    expenseDescription
                            );

                            manager.addTransaction(expense);
                            break;

                        case 3:

                            manager.viewTransactions();
                            break;

                        case 4:

                            System.out.println("\n===== FINANCIAL SUMMARY =====");

                            System.out.printf("Total Income: R%.2f%n",
                                    manager.calculateTotalIncome());

                            System.out.printf("Total Expenses: R%.2f%n",
                                    manager.calculateTotalExpenses());

                            System.out.printf("Current Balance: R%.2f%n",
                                    manager.calculateBalance());

                            break;

                        case 5:

                            reportGenerator.generateReport(
                                    manager.getTransactions());

                            break;

                        case 6:

                            System.out.println("\n--- Set Savings Goal ---");

                            System.out.print("Enter savings goal amount: R");
                            double goalAmount = scanner.nextDouble();
                            scanner.nextLine();

                            savingsGoal = new SavingsGoal(goalAmount);

                            System.out.println("Savings goal set successfully!");

                            break;

                        case 7:

                            System.out.println("\n--- Add To Savings ---");

                            System.out.print("Enter amount saved: R");
                            double amountSaved = scanner.nextDouble();
                            scanner.nextLine();

                            savingsGoal.addSavings(amountSaved);

                            System.out.println("Savings updated successfully!");

                            break;

                        case 8:

                            System.out.println("\n===== SAVINGS GOAL =====");

                            System.out.printf("Goal Amount: R%.2f%n",
                                    savingsGoal.getGoalAmount());

                            System.out.printf("Current Savings: R%.2f%n",
                                    savingsGoal.getCurrentAmount());

                            System.out.printf("Progress: %.2f%%%n",
                                    savingsGoal.getProgressPercentage());

                            break;

                        case 9:

                            CSVExporter.exportTransactions(
                                    manager.getTransactions());

                            break;

                        case 10:

                            FileHandler.saveTransactions(
                                    manager.getTransactions());

                            System.out.println("Transactions saved.");

                            System.out.println(
                                    "Thank you for using Personal Finance Manager!");

                            break;

                        default:

                            System.out.println("Invalid choice. Try again.");
                    }

                } while (choice != 10);

                scanner.close();
                    }
                }