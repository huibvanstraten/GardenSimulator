package Garden.Gardening;

import Garden.Water.Ground;
import Garden.Water.WaterBarrel;

public class Gardener implements Gardening {

    private final int MAX = 3;
    private final int MIN = 1;
    private final int RANGE = MAX - MIN;
    private int randomDay;
    private int visitingDay = 1;

    @Override
    public void gardening(double rainToday, int day) {
        if (rainToday > 50) {
            System.out.println("\nTom is a \"nice weather gardener\". So, he is not coming today.\n");
            Working.setWorking(false);
            visitingDay = day + 1;
        } else if (visitingDay == day) {
            System.out.println("\nToday Tom is working in the garden.");
            Working.setWorking(true);
            randomDay = (int) (Math.random() * RANGE) + MIN;
            visitingDay = day + randomDay;
        } else {
            System.out.println("\nTom is not working in the garden today.\n");
            Working.setWorking(false);
            visitingDay = day;
        }
    }

    @Override
    public void watering(WaterBarrel barrel, Ground ground) {
        if (Working.isWorking()) {
            if (ground.getWaterInGround() > 5_000) {
                System.out.println("The ground looks very moist. Tom is not giving water today.\n");
            }else if (barrel.getWaterInBarrel() == 0) {
                System.out.println("The water barrel is empty. Tom has no water to give today.\n");
            } else {
                if (barrel.getWaterInBarrel() >= 400) {
                    double waterTransfer = barrel.getWaterInBarrel() / 2;
                    barrel.setWaterInBarrel(barrel.getWaterInBarrel() / 2);
                    ground.setWaterInGround(ground.getWaterInGround() + waterTransfer);
                    System.out.println("Tom is using half of the water from the barrel for watering the plants.\n");
                } else {
                    double waterTransfer = barrel.getWaterInBarrel();
                    barrel.setWaterInBarrel(0);
                    ground.setWaterInGround(ground.getWaterInGround() + waterTransfer);
                    System.out.println("Tom used all of the water for watering the plants.\n");
                }
            }
        }
    }
}


