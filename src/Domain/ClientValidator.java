package Domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ClientValidator {


    /**
     * Valideaza un client
     * @param client clientul care trebuie validat
     */
    public void validate(Client client){

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

        try {
            format.parse(client.getDateOfBirth());
        } catch (ParseException parseException) {
            throw new RuntimeException("The date of birth is not in a correct format!");
        }

        try {
            format.parse(client.getDateOfRegistration());
        } catch (ParseException parseException) {
            throw new RuntimeException("The date of registration is not in a correct format!");
        }

        String CNP = client.getCNP();
        if (CNP.length() != 13){
            throw new RuntimeException("CNP-ul trebuie sa contina 13 cifre!");
        }
        if (!(CNP.charAt(0) <= '2' && CNP.charAt(0) != '0')){
            throw new RuntimeException("CNP-ul trebuie sa inceapa cu 1 sau 2");
        }
        }

}
