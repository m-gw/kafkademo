package m.gaw.kafkademo.implementation.components;

import m.gaw.kafkademo.abstraction.components.Validator;
import m.gaw.kafkademo.implementation.model.Triangle;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class  TriangleValidator implements Validator<Triangle> {

    public boolean isValid(Triangle triangle) {
        return hasPositiveSides(triangle)
                && canBeConstructed(triangle);
    }

    private boolean hasPositiveSides(Triangle triangle) {
        return triangle.getA() > 0
                && triangle.getB() > 0
                && triangle.getC() > 0;
    }

    private boolean canBeConstructed(Triangle triangle) {
        int[] sides = {triangle.getA(), triangle.getB(), triangle.getC()};

        int circuit = Arrays.stream(sides)
                .sum();

        return Arrays.stream(sides)
                .noneMatch(side -> 2*side >= circuit);
    }

}
