package m.gaw.kafkademo.implementation.components;

import m.gaw.kafkademo.abstraction.components.Validator;
import m.gaw.kafkademo.implementation.model.Triangle;
import org.springframework.stereotype.Component;

import static java.lang.Math.max;

@Component
public class TriangleValidator implements Validator<Triangle> {

    public boolean isValid(Triangle triangle) {
        return hasPositiveSides(triangle) && canBeConstructed(triangle);
    }

    private boolean canBeConstructed(Triangle triangle) {
        int longest = max(triangle.getA(), max(triangle.getB(), triangle.getC()));
        int circuit = triangle.getA() + triangle.getB() + triangle.getC();
        return 2 * longest < circuit;
    }

    private boolean hasPositiveSides(Triangle triangle) {
        return triangle.getA() > 0
                && triangle.getB() > 0
                && triangle.getC() > 0;
    }

}
