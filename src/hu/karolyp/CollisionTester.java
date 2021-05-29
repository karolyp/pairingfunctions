package hu.karolyp;

import hu.karolyp.generators.GeneratorStrategy;

import java.util.HashSet;
import java.util.Set;

class CollisionTester {
    private final long[] NUMBERS_TO_TEST = {1L, 2L, 3L, 4L, 6789L, -89875L};
    private final GeneratorStrategy generatorStrategy;
    private final Set<Long> numberSeen;
    private final long[] numbers;

    CollisionTester(GeneratorStrategy generatorStrategy, long[] numbers) {
        System.out.println("Testing for strategy " + generatorStrategy.getClass().getSimpleName() + "...");
        this.generatorStrategy = generatorStrategy;
        this.numbers = numbers;
        this.numberSeen = new HashSet<>();
    }

    void testForCollision() {
        long start = System.currentTimeMillis();
        int numberOfCollisions = 0;
        for (long b : NUMBERS_TO_TEST) {
            for (long a : numbers) {
                if (!numberSeen.add(generatorStrategy.generate(a, b))) {
                    numberOfCollisions++;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Finished in " + (end - start) + " ms. Number of collisions: " + numberOfCollisions);
    }
}
