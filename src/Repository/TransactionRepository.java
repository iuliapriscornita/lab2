package Repository;

import Domain.Transaction;
import Domain.TransactionValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionRepository {

    private Map<String, Transaction> storage = new HashMap<>();
    private TransactionValidator validator;

    public TransactionRepository(TransactionValidator validator) {
        this.validator = validator;
    }

    public Transaction findById(String id) {
        return storage.get(id);
    }

    /**
     * Adds or updates a transaction if it already exists.
     * @param transaction the transaction to add or update.
     */
    public void upsert(Transaction transaction) {
        validator.validate(transaction);
        storage.put(transaction.getId(), transaction);
    }

    /**
     * Removes a transaction with a given id.
     * @param id the id.
     * @throws RuntimeException if there is no transaction with the given id.
     */
    public void remove(String id) {
        if (!storage.containsKey(id)) {
            throw new RuntimeException("There is no transaction with the given id to remove.");
        }

        storage.remove(id);
    }

    public List<Transaction> getAll() {
        return new ArrayList<>(storage.values());
    }
}
