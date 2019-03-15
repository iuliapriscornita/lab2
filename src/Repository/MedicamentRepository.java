package Repository;

import Domain.Medicament;
import Domain.MedicamentValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicamentRepository {

    private Map<String, Medicament> storage = new HashMap<>();
    private MedicamentValidator validator;

    public MedicamentRepository(MedicamentValidator validator){
        this.validator = validator;
        }

    public Medicament findById(String id ){
        return storage.get(id);
    }

    /**
     * Adds or updates a medicine if it already exists.
     * @param medicament the medicine to add or update.
     */
    public  void upsert(Medicament medicament){
        validator.validate(medicament);
        storage.put(medicament.getId(), medicament);
    }

    /**
     * Removes a medicine with a given id.
     * @param id the id
     * @throws RuntimeException if there is no medicine with the given id
     */
    public void remove(String id){
        if (storage.containsKey(id)){
            throw new RuntimeException("There is no medicine with the given id");
        }
        storage.remove(id);
    }

    /**
     *
     * @return a list of Medicines
     */
    public List<Medicament> getAll(){return new ArrayList<>(storage.values());
    }
}
