package Garden.PlantAbstract;

import Garden.Water.Ground;

public interface Hydrate {

    void hydrate(Ground y);

    boolean dehydrated(Plant x);

    boolean overWatered(Ground y, Plant x);
}
