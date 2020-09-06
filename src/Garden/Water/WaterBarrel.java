package Garden.Water;

public class WaterBarrel implements Contain {

    private static double waterInBarrel;

    public WaterBarrel(double waterInBarrel) {
        WaterBarrel.waterInBarrel = waterInBarrel;
    }

    public void setWaterInBarrel(double waterInBarrel) {
        WaterBarrel.waterInBarrel = waterInBarrel;
    }

    public double getWaterInBarrel() {
        return waterInBarrel;
    }

    @Override
    public void addingWater(double rainToday) {
        waterInBarrel += rainToday;
        if (waterInBarrel >= 1000) {
            waterInBarrel = 1000;
        }
    }

    @Override
    public void stateOfContainment() {
        if (waterInBarrel < 1) {
            System.out.println("\nThe barrel is empty.\n");
        } else if (waterInBarrel >= 1_000) {
            System.out.println("\nThe barrel is full.\n");
        } else {
            System.out.printf("%nThe barrel contains %.2f liters of water.%n", waterInBarrel);
        }
    }
}
