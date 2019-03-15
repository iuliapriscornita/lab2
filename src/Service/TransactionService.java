package Service;

import Domain.Medicament;
import Domain.Transaction;
import Domain.TransactionValidator;
import Repository.MedicamentRepository;
import Repository.TransactionRepository;

import java.util.List;

public class TransactionService {

    public TransactionService (TransactionRepository transactionRepository, MedicamentRepository medicamentRepository) {
        this.transactionRepository = transactionRepository;
        this.medicamentRepository = medicamentRepository;
    }

    private TransactionRepository transactionRepository;
    private MedicamentRepository medicamentRepository;

    public Transaction addOrUpdate(String id, String idMedicament, String idClientCard, int numberOfItems, String date, String time) {
        Transaction existing = transactionRepository.findById(id);
        if (existing != null) {
            if (idMedicament.isEmpty()) {
                idMedicament = existing.getIdMedicament();
            }
            if (idClientCard.isEmpty()) {
                idClientCard = existing.getIdCardClient();
            }
            if (numberOfItems == 0) {
                numberOfItems = existing.getNumberOfItems();
            }
            if (date.isEmpty()) {
                date = existing.getDate();
            }
            if (time.isEmpty()) {
                time = existing.getTime();
            }
        }

        Medicament soldMed = medicamentRepository.findById(idMedicament);
        if (soldMed == null) {
            throw new RuntimeException("There is no Medicine with that id");
        }
        double initialPrice = soldMed.getPrice();
        double discount = 0;
        if (idClientCard != null) {
            if (soldMed.isPrescription()) {
                discount = 0.15;
            } else {
                discount = 0.1;
            }
        }
        Transaction transaction = new Transaction(id, idMedicament, idClientCard, date, time, numberOfItems, initialPrice, discount);
        return transaction;

    }
        public void remove(String id) {
            transactionRepository.remove(id);
        }

        public List<Transaction> getAll() {
            return transactionRepository.getAll();
        }
    }

