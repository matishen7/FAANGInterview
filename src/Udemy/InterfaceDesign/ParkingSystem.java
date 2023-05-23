package Udemy.InterfaceDesign;

public class ParkingSystem implements IParkingSystem {

    private int bigParking;
    private int mediumParking;
    private int smallParking;

    public ParkingSystem(int big, int medium, int small) {
        bigParking = big;
        mediumParking = medium;
        smallParking = small;
    }

    @Override
    public boolean addCar(int carType) {
        if (carType == 1) {
            if (this.bigParking > 0) {
                this.bigParking--;
                return true;
            } else return false;
        } else if (carType == 2) {
            if (this.mediumParking > 0) {
                this.mediumParking--;
                return true;
            } else return false;
        } else if (carType == 3) {
            if (this.smallParking > 0) {
                this.smallParking--;
                return true;
            }
            else return false;
        }
        return false;
    }
}
