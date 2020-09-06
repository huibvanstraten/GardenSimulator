package Garden.PlantAbstract.Plants;

import Garden.PlantAbstract.Plant;

public class Courgette extends Plant {

    public Courgette(double absorb, String plantName, String fruitName, int fruit, int ripe, boolean dead) {
        this.absorb = absorb;
        this.plantName = plantName;
        this.fruitName = fruitName;
        this.fruit = fruit;
        this.ripe = ripe;
        this.dead = false;
    }
}
