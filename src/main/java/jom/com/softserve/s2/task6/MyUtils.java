package jom.com.softserve.s2.task6;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyUtils {

    List<Shape> maxAreas(List<Shape> shapes) {
        if (shapes == null || shapes.isEmpty()) {
            return List.of();
        }

        Map<String, Double> maxAreasMap = shapes.stream()
                .collect(Collectors.toMap(
                        shape -> Objects.toString(shape != null ? shape.getClass().getSimpleName() : null, "NullShape"),
                        shape -> Objects.requireNonNullElse(shape != null ? shape.getArea() : null, 0.0),
                        Double::max
                ));

        return shapes.stream()
                .filter(shape -> {
                    Double shapeArea = Objects.requireNonNullElse(shape != null ? shape.getArea() : null, 0.0);
                    Double maxArea = maxAreasMap.get(Objects.toString(shape != null ? shape.getClass().getSimpleName() : null, "NullShape"));
                    return shapeArea.equals(maxArea);
                })
                .toList();
    }
}
