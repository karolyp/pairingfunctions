package hu.karolyp;

import hu.karolyp.generators.*;

import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        final int N = 1000000;
        long[] numbers = ThreadLocalRandom.current().longs(N, N, 10 * N).distinct().toArray();
        System.out.println("Generated " + numbers.length + " distinct numbers.");

        CollisionTester collisionTester = new CollisionTester(new XORStrategy(), numbers);
        collisionTester.testForCollision();

        collisionTester = new CollisionTester(new HashOfHashesStrategy(), numbers);
        collisionTester.testForCollision();

        collisionTester = new CollisionTester(new CantorPairingStrategy(), numbers);
        collisionTester.testForCollision();

        collisionTester = new CollisionTester(new ElegantPairingStrategy(), numbers);
        collisionTester.testForCollision();

        collisionTester = new CollisionTester(new RosenbergStrongPairingStrategy(), numbers);
        collisionTester.testForCollision();
    }

}