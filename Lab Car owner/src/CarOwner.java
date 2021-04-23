import java.io.Serializable;

public class CarOwner implements Serializable {
    private Integer id;
    private String name;
    private String surname;
    private String carBrand;
    private String carColor;
    private String carNumber;
    private String regNum;
    private int yearOfIssue;

    public CarOwner() {
    }

    public CarOwner(Integer id, String name, String surname, String carBrand, String carColor, String carNumber, String regNum, int yearOfIssue) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.carBrand = carBrand;
        this.carColor = carColor;
        this.carNumber = carNumber;
        this.regNum = regNum;
        this.yearOfIssue = yearOfIssue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(int yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    @Override
    public String toString() {
        return id+" "+name + " " +surname +
                " "+carBrand +
                " "+carColor +
                " " +carNumber +
                " " + regNum +
                " " + yearOfIssue;
    }
}
