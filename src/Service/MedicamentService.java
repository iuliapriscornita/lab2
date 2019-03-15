package Service;

import Domain.Medicament;
import Repository.MedicamentRepository;

import java.util.List;

public class MedicamentService {

    private MedicamentRepository repository;

    public MedicamentService(MedicamentRepository repository){
        this.repository = repository;
    }
    public void addOrUpdate( String id, String name, String producer, double price, boolean prescription){
        Medicament existing = repository.findById(id);
        if (existing != null) {
            if (name.isEmpty()) {
                name = existing.getName();
            }
            if (producer.isEmpty()) {
                producer = existing.getProducer();
            }
            if (price == 0) {
                price = existing.getPrice();
            }
        }
        Medicament medicament =new Medicament(id, name, producer,price, prescription);
        repository.upsert(medicament);
    }

    public void remove(String id){
        repository.remove(id);
    }

    public List<Medicament> getAll(){
        return repository.getAll();
    }
}
