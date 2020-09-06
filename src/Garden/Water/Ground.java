package Garden.Water;

public class Ground implements Contain {

    private static double waterInGround;

    public Ground(double waterInGround) {
        Ground.waterInGround = waterInGround;
    }

    public void setWaterInGround(double waterInGround) {
        Ground.waterInGround = waterInGround;
    }

    public double getWaterInGround() {
        return waterInGround;
    }

    @Override
    public void addingWater(double rainToday) {
        waterInGround += rainToday;
    }

    @Override
    public void stateOfContainment() {
        System.out.printf("%nThe ground contains %.2f liters of water.%n", waterInGround);
        if (waterInGround < 300) {
            System.out.println("\nThe ground is dry and dusty. Cracks start to form.");
        } else if (waterInGround > 6_000) {
            System.out.println("\nThe ground is muddy. Puddles are forming everywhere.");
        } else {
            System.out.println("\nThe ground looks healthy.");
        }
    }
}