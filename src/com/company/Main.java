package com.company;

import com.company.generators.*;

import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        final int N = 1000000;
        long[] accountIds = ThreadLocalRandom.current().longs(N, N, 10 * N).distinct().toArray();
        System.out.println("Generated " + accountIds.length + " distinct account ids.");

        CollisionTester collisionTester = new CollisionTester(new FormerPrivateKeyStrategy(), accountIds);
        collisionTester.testForCollision();

        collisionTester = new CollisionTester(new SeededPRNGStrategy(), accountIds);
        collisionTester.testForCollision();

        collisionTester = new CollisionTester(new SHAStrategy(), accountIds);
        collisionTester.testForCollision();

        collisionTester = new CollisionTester(new HashOfHashesStrategy(), accountIds);
        collisionTester.testForCollision();

        collisionTester = new CollisionTester(new CantorPairingStrategy(), accountIds);
        collisionTester.testForCollision();

        collisionTester = new CollisionTester(new ElegantPairingStrategy(), accountIds);
        collisionTester.testForCollision();

        collisionTester = new CollisionTester(new RosenbergStrongPairingStrategy(), accountIds);
        collisionTester.testForCollision();
    }

}