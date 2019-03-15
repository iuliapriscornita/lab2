package Domain;

import java.util.Objects;

public class Medicament {

    private String id,name, producer;
    private  double price;
    private boolean prescription;

    public Medicament(String id, String name, String producer, double price, boolean prescription) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.price = price;
        this.prescription = prescription;
    }

    @Override
    public String toString() {
        return "Medicament{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", price=" + price +
                ", prescription=" + prescription +
                '}';
    }

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getName () { return name;}

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPrescription() {
        return prescription;
    }

    public void setPrescription(boolean prescription) {
        this.prescription = prescription;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (!(o instanceof Medicament)) return false;
        Medicament that = (Medicament) o;
        return Double.compare(that.getPrice(), getPrice()) == 0 &&
                isPrescription() == that.isPrescription() &&
                Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getProducer(), that.getProducer());
    }

    @Override
    public int hashCode () {
        return Objects.hash(getId(), getName(), getProducer(), getPrice(), isPrescription());
    }


}
