package cars;




import javax.persistence.*;


@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    protected int id;
    protected String manufacturedName;
    protected String engine;
    protected String modelName;
    protected String wheel;
    protected String transmission;
    protected String gear; //?

    public void setManufacturerName(String manufacturerName) {
        this.manufacturedName = manufacturerName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setId(int id) {
        this.id = id;
    }



    Car(String modelName, String manufacturedName, String engine, String wheel, String transmission, String gear){
        this.engine=engine;
        this.manufacturedName=manufacturedName;
        this.modelName=modelName;
        this.gear=gear;
        this.wheel=wheel;
        this.transmission=transmission;
    }

    public int getId() {
        return id;
    }

    public String getManufacturerName() {
        return manufacturedName;
    }

    public String getModelName() {
        return modelName;
    }

    public String toString() {

        return String.join(" ", manufacturedName, modelName, engine,wheel, gear, transmission );
    }
}
