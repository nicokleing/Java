public class Main {
    public static void main(String[] args) {
        Vehicle vehicleStandar = new VehicleStandar("1234", "Red");
        Vehicle vehicleDeluxe = new VehicleDeluxe("5678", "Blue", 3.0);

        Driver driver = new Driver("Nicolas", vehicleStandar);
        driver.howMuchForTrip(10.0);
        driver.howMuchForTrip(60.0);

        driver.setVehicle(vehicleDeluxe);
        driver.howMuchForTrip(60.0);
    }
}
