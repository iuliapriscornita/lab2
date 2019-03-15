package Domain;

import java.util.Objects;

public class Transaction {

    private String id, idMedicament, idCardClient, date, time;
    private int numberOfItems;
    private double initialPrice;
    private double discount;

    public Transaction (String id, String idMedicament, String idCardClient, String date, String time, int numberOfItems, double initialPrice, double discount) {
        this.id = id;
        this.idMedicament = idMedicament;
        this.idCardClient = idCardClient;
        this.date = date;
        this.time = time;
        this.numberOfItems = numberOfItems;
        this.initialPrice = initialPrice;
        this.discount = discount;
    }

    @Override
    public String toString () {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", idMedicament='" + idMedicament + '\'' +
                ", idCardClient='" + idCardClient + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", numberOfItems=" + numberOfItems +
                ", initialPrice=" + initialPrice +
                ", discount=" + discount +
                '}';
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;
        Transaction that = (Transaction) o;
        return getNumberOfItems() == that.getNumberOfItems() &&
                Double.compare(that.getInitialPrice(), getInitialPrice()) == 0 &&
                Double.compare(that.getDiscount(), getDiscount()) == 0 &&
                Objects.equals(getId(), that.getId()) &&
                Objects.equals(getIdMedicament(), that.getIdMedicament()) &&
                Objects.equals(getIdCardClient(), that.getIdCardClient()) &&
                Objects.equals(getDate(), that.getDate()) &&
                Objects.equals(getTime(), that.getTime());
    }

    @Override
    public int hashCode () {
        return Objects.hash(getId(), getIdMedicament(), getIdCardClient(), getDate(), getTime(), getNumberOfItems(), getInitialPrice(), getDiscount());
    }

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getIdMedicament () {
        return idMedicament;
    }

    public void setIdMedicament (String idMedicament) {
        this.idMedicament = idMedicament;
    }

    public String getIdCardClient () {
        return idCardClient;
    }

    public void setIdCardClient (String idCardClient) {
        this.idCardClient = idCardClient;
    }

    public String getDate () {
        return date;
    }

    public void setDate (String date) {
        this.date = date;
    }

    public String getTime () {
        return time;
    }

    public void setTime (String time) {
        this.time = time;
    }

    public int getNumberOfItems () {
        return numberOfItems;
    }

    public void setNumberOfItems (int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public double getInitialPrice () {
        return initialPrice;
    }

    public void setInitialPrice (double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public double getDiscount () {
        return discount;
    }

    public void setDiscount (double discount) {
        this.discount = discount;
    }

    /**
     * Custom getter for the discounted price.
     * @return the price after applying the discount.
     */
    public double getDiscountedPrice() {
        return initialPrice*numberOfItems - discount * initialPrice*numberOfItems;
    }
}
