package service;

import model.Transaction;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVExporter {

    private static final String FILE_NAME =
            "transactions.csv";

    public static void exportTransactions(
            ArrayList<Transaction> transactions) {

        try (FileWriter writer =
                new FileWriter(FILE_NAME)) {

            // CSV Header
            writer.append(
                    "ID,Type,Category,Amount,Date,Description\n"
            );

            // transaction data

            for (Transaction transaction : transactions) {

                writer.append(
                        String.valueOf(
                                transaction.getId())
                );

                writer.append(",");

                writer.append(
                        transaction.getType());

                writer.append(",");

                writer.append(
                        transaction.getCategory());

                writer.append(",");

                writer.append(
                        String.valueOf(
                                transaction.getAmount())
                );

                writer.append(",");

                writer.append(
                        transaction.getDate());

                writer.append(",");

                writer.append(
                        transaction.getDescription());

                writer.append("\n");
            }

            System.out.println(
                    "CSV export completed successfully."
            );

        } catch (IOException e) {

            System.out.println(
                    "Error exporting CSV file."
            );
        }
    }
}