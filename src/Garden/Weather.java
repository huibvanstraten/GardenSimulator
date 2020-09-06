package Garden;

import java.util.Random;

public enum Weather {
    HOT(0, "hot"),
    SUNNY(0, "sunny"),
    CLOUDY(50, "cloudy"),
    RAIN(1_000, "rain"),
    STORM(3_000, "storm");

    private final double rainFall;
    private final String weather;

    Weather(double rainFall, String weather) {
        this.rainFall = rainFall;
        this.weather = weather;
    }

    public String getWeather() {
        return weather;
    }

    private static final Weather[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public static double getRandomWeather()  {
        Weather x = VALUES[RANDOM.nextInt(SIZE)];
        double rainToday = x.rainFall;
        System.out.println("The forecast is: " + x.weather);
        System.out.printf("Expected rainfall in garden today is: %.0f liters %n", rainToday);
        return rainToday;
    }
}