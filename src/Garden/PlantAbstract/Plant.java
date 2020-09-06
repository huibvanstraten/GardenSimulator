package Garden.PlantAbstract;

import Garden.Water.Ground;

public abstract class Plant implements Hydrate, Symptom, Fruit {
    protected double absorb;
    protected boolean dead;
    protected String plantName = null;
    protected String fruitName = null;
    protected int ripe;
    protected int fruit;
    protected int totalFruit;

    public boolean isDead() {
        return dead;
    }

    public boolean setDead(boolean dead) {
        this.dead = dead;
        return dead;
    }

    private int dayDry;
    private int dayDrown;
    private int dayGrow;

    @Override
    public void hydrate(Ground y) {
        if (y.getWaterInGround() >= absorb) {
            y.setWaterInGround(y.getWaterInGround() - absorb);
            dayDry = 0;
        } else {
            dayDry++;
        }
    }

    @Override
    public boolean dehydrated(Plant x) {
        if (dayDry == 3) {
            return x.setDead(dead);
        } else {
            return x.setDead(!dead);
        }
    }

    @Override
    public boolean overWatered(Ground y, Plant x) {
            if (y.getWaterInGround() > 6_000) {
                dayDrown++;
            } else {
                dayDrown = 0;
            }
            if (dayDrown == 3) {
                return x.setDead(dead);
            } else {
                return x.setDead(!dead);
        }
    }

    @Override
    public void foliate() {
        if (dayDry == 1) {
            System.out.printf("The leaves of the %s are starting to show dry spots.The %s died.. %n", plantName, fruitName);
        } else if (dayDry == 2) {
            System.out.printf("The leaves of the %s are dry and cracked.%n", plantName);
        }else if (dayDry== 3) {
            System.out.printf("The leaves of the %s have fallen off. It is dead and withered.%n", plantName);
        }
    }

    @Override
    public void color() {
        if (dayDrown == 1) {
            System.out.printf("The leaves of the %s are starting to turn yellow.The %s died.. %n", plantName, fruitName);
        } else if (dayDrown == 2) {
            System.out.printf("The leaves of the %s are limp and yellow.%n", plantName);
        }else if (dayDrown == 3) {
            System.out.printf("The %s is hanging. The leaves are yellow and limp. It is dead and withered.%n", plantName);
        }
    }

    @Override
    public void grow() {
        if (dayGrow == ripe) {
            dayGrow = 0;
            totalFruit += fruit;
            System.out.printf("You harvested %d %s!%n", fruit, fruitName);
        } else if (dayDrown == 0 && dayDry == 0) {
            System.out.printf("The %s are growing.%n", fruitName);
            dayGrow++;
        }
    }

    @Override
    public void harvest() {
        System.out.printf("You harvested %d %s!%n", totalFruit, fruitName);
    }
}

