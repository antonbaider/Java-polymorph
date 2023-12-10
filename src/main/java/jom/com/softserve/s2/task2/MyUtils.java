package jom.com.softserve.s2.task2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

interface DrinkReceipt {
    String getName();

    DrinkReceipt addComponent(String componentName, int componentCount);
}

interface DrinkPreparation {
    Map<String, Integer> makeDrink();
}

interface Rating {
    int getRating();
}

public class MyUtils {

    public Map<String, Double> averageRating(List<Coffee> coffees) {
        return coffees.stream()
                .collect(Collectors.groupingBy(
                        Coffee::getName,
                        LinkedHashMap::new,
                        Collectors.averagingDouble(Coffee::getRating)));
    }
}

class Coffee implements DrinkReceipt, DrinkPreparation, Rating {
    private final String name;
    private final int rating;
    private final Map<String, Integer> ingredients;

    public Coffee(String name, int rating) {
        this.name = name;
        this.rating = rating;
        this.ingredients = new HashMap<>();
        addComponent("Water", 100);
        addComponent("Arabica", 20);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public DrinkReceipt addComponent(String componentName, int componentCount) {
        ingredients.put(componentName, componentCount);
        return this;
    }

    @Override
    public Map<String, Integer> makeDrink() {

        return new HashMap<>(ingredients);
    }

    @Override
    public int getRating() {
        return rating;
    }
}

class Espresso extends Coffee {
    public Espresso(String name, int rating) {
        super(name, rating);
        addComponent("Water", 50);
    }

    @Override
    public Map<String, Integer> makeDrink() {
        return super.makeDrink();
    }
}

class Cappuccino extends Coffee {
    public Cappuccino(String name, int rating) {
        super(name, rating);
        addComponent("Milk", 50);
    }

    @Override
    public Map<String, Integer> makeDrink() {
        return super.makeDrink();
    }

}