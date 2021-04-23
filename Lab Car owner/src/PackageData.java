import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {//
    private String operationType;//
    private CarOwner carOwner;
    private ArrayList<CarOwner> carOwners;
    private int id;
    private String category;
    private String text;

    public PackageData(String operationType) {///list all info from server/database
        this.operationType = operationType;
    }

    public PackageData(String operationType, CarOwner carOwner) {//
        this.operationType = operationType;
        this.carOwner = carOwner;
    }
    public PackageData(ArrayList<CarOwner> carOwners) {///send back to client
        this.carOwners = carOwners;
    }

    public PackageData(String operationType, int id, String category, String text) {
        this.operationType = operationType;
        this.id = id;
        this.category = category;
        this.text = text;
    }

    public PackageData(String operationType, int id) {//
        this.operationType = operationType;
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public CarOwner getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(CarOwner carOwner) {
        this.carOwner = carOwner;
    }

    public ArrayList<CarOwner> getCarOwners() {
        return carOwners;
    }

    public void setCarOwners(ArrayList<CarOwner> carOwners) {
        this.carOwners = carOwners;
    }
}
