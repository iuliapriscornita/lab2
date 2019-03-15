package Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TransactionValidator {

    public void validate(Transaction transaction) {
        if (transaction.getNumberOfItems() <= 0) {
            throw new RuntimeException("The number of items must be at least 1.");
        }

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

        try {
            format.parse(transaction.getDate());
        } catch (ParseException parseException) {
            throw new RuntimeException("The date is not in a correct format!");
        }
    }
}
