package web.model;

public class Car {
    private String model;
    private String series;
    private int yearOfManufacture;

    public Car() {
    }

    public Car(String model, String series, int yearOfManufacture) {
        this.model = model;
        this.series = series;
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", series='" + series + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                '}';
    }
}