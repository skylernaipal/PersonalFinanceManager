package util;

public class InputValidator {

    public static boolean isPositiveAmount(double amount) {
        return amount > 0;
    }

    public static boolean isValidCategory(String category) {
        return category != null &&
                !category.trim().isEmpty();
    }

    public static boolean isValidDescription(String description) {
        return description != null &&
                !description.trim().isEmpty();
    }

    public static boolean isValidDate(String date) {

        return date.matches(
                "\\d{4}-\\d{2}-\\d{2}"
        );
    }
}