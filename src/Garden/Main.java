package Garden;

import Garden.Gardening.Gardener;
import Garden.PlantAbstract.Plant;
import Garden.PlantAbstract.Plants.*;
import Garden.Water.Ground;
import Garden.Water.WaterBarrel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double rainToday;

        Ground ground = new Ground(4000);
        WaterBarrel barrel = new WaterBarrel(1000);
        Gardener tom = new Gardener();

        Plant cabbage = new Cabbage(150, "cabbage plants", "cabbages", 4, 3, false);
        Plant appleTree = new AppleTree( 400, "apple tree", "apples", 15, 14, false);
        Plant beetroot = new Beetroot(150, "beetroot plants", "beetroots", 7, 4, false);
        Plant courgette = new Courgette(225, "courgette plant", "courgettes",3, 6,false);
        Plant lettuce = new Lettuce(200, "lettuce plants", "lettuces", 3, 4,false);
        Plant strawberry = new Strawberry(150, "strawberries", "strawberry fruits", 16, 7, false);
        Plant[] listOfPlants = {cabbage, appleTree, beetroot, courgette, lettuce, strawberry};

        System.out.println("\nWelcome to Tom's garden. Where weather and an unpredictable gardener decide the faith of your harvest.\n");
        System.out.print("How many days would you like to simulate?: ");
        int loopDays = scanner.nextInt();

        System.out.println("Alright. Let's see if the gods will favor you..");

        for (int day = 1; day <= loopDays; day++) {
            System.out.printf("%nToday is day %d.%n", day);
            rainToday = Weather.getRandomWeather();
            ground.addingWater(rainToday);
            barrel.addingWater(rainToday);

            tom.gardening(rainToday, day);
            tom.watering(barrel, ground);

            for (Plant x : listOfPlants) {

                if (!x.isDead()) {
                    x.hydrate(ground);
                    x.overWatered(ground, x);
                    x.dehydrated(x);
                    x.color();
                    x.foliate();
                    x.grow();
                }
            }

            ground.stateOfContainment();
            barrel.stateOfContainment();


            System.out.println("\nPress any button and enter to continue");
            String a = scanner.next();
        }
        System.out.println("Congratulations! You are a master gardener!");
        for (Plant x : listOfPlants) {
            x.harvest();
        }
    }
}
