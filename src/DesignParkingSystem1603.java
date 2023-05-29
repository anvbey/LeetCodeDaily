class ParkingSystem {
    int slot[] = new int[3];
    public ParkingSystem(int big, int medium, int small) {
        slot[0]= big;
        slot[1]= medium;
        slot[2]= small;
    }
    
    public boolean addCar(int carType) {
        if(carType == 1)
        {
            if(slot[0] > 0)
            {
                slot[0]--;
                return true;
            }
            else
                return false;
        }
        else if(carType == 2)
        {
            if(slot[1] > 0)
            {
                slot[1]--;
                return true;
            }
            else
                return false;
        }
        else
        {
            if(slot[2] > 0)
            {
                slot[2]--;
                return true;
            }
            else
                return false;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
