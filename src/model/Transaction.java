package model;

public class Transaction {

    // attributes
    private int id;
    private String type;
    private String category;
    private double amount;
    private String date;
    private String description;

    // constructor
    public Transaction(int id, String type, String category, double amount, String date, String description) {

        this.id = id;
        this.type = type;
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    // getters
    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    // display transaction information
    @Override
    public String toString() {

        return "\nTransaction ID: " + id +
                "\nType: " + type +
                "\nCategory: " + category +
                "\nAmount: R" + String.format("%.2f", amount) +
                "\nDate: " + date +
                "\nDescription: " + description +
                "\n----------------------------";
    }
}