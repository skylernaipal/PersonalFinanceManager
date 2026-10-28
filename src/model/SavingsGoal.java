package model;
public class SavingsGoal {
    private double goalAmount;
    private double currentAmount;

    // constructor
    public SavingsGoal(double goalAmount) {
        this.goalAmount = goalAmount;
        this.currentAmount = 0;
    }

    // add money towards the goal
    public void addSavings(double amount) {

        if (amount > 0) {
            currentAmount += amount;
        } else {
            System.out.println("Amount must be greater than zero.");
        }
    }

    // getters
    public double getGoalAmount() {
        return goalAmount;
    }

    public double getCurrentAmount() {
        return currentAmount;
    }

    // calculate percentage complete
    public double getProgressPercentage() {

        if (goalAmount == 0) {
            return 0;
        }

        return (currentAmount / goalAmount) * 100;
    }

    // amount still needed
    public double getRemainingAmount() {

        double remaining = goalAmount - currentAmount;

        if (remaining < 0) {
            return 0;
        }

        return remaining;
    }

    // check if goal achieved
    public boolean isGoalReached() {
        return currentAmount >= goalAmount;
    }

    // display goal summary
    public void displayGoalStatus() {

        System.out.println("\n===== SAVINGS GOAL STATUS =====");
        System.out.printf("Goal Amount      : R%.2f%n", goalAmount);
        System.out.printf("Current Savings  : R%.2f%n", currentAmount);
        System.out.printf("Remaining Amount : R%.2f%n",
                getRemainingAmount());
        System.out.printf("Progress         : %.2f%%%n",
                getProgressPercentage());

        if (isGoalReached()) {
            System.out.println("Congratulations! Goal achieved.");
        } else {
            System.out.println("Goal not yet reached.");
        }

        System.out.println("===============================\n");
    }

    @Override
    public String toString() {

        return "Goal Amount: R" + String.format("%.2f", goalAmount)
                + ", Current Savings: R"
                + String.format("%.2f", currentAmount)
                + ", Progress: "
                + String.format("%.2f", getProgressPercentage())
                + "%";
    }
}
