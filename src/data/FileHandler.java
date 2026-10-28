package data;

import model.Transaction;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    private static final String FILE_NAME =
            "transactions.txt";

    public static void saveTransactions(
            ArrayList<Transaction> transactions) {

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(FILE_NAME))) {

            for (Transaction transaction : transactions) {

                writer.write(
                        transaction.getId() + "," +
                                transaction.getType() + "," +
                                transaction.getCategory() + "," +
                                transaction.getAmount() + "," +
                                transaction.getDate() + "," +
                                transaction.getDescription()
                );

                writer.newLine();
            }

            System.out.println(
                    "Transactions saved successfully."
            );

        } catch (IOException e) {

            System.out.println(
                    "Error saving transactions."
            );
        }
    }

    public static ArrayList<Transaction>
    loadTransactions() {

        ArrayList<Transaction> transactions =
                new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return transactions;
        }

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String type = data[1];
                String category = data[2];
                double amount =
                        Double.parseDouble(data[3]);
                String date = data[4];
                String description = data[5];

                Transaction transaction =
                        new Transaction(
                                id,
                                type,
                                category,
                                amount,
                                date,
                                description
                        );

                transactions.add(transaction);
            }

        } catch (IOException e) {

            System.out.println(
                    "Error loading transactions."
            );
        }

        return transactions;
    }
}