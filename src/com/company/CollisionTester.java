package com.company;

import com.company.generators.PrivateKeyGeneratorStrategy;

import java.util.HashSet;
import java.util.Set;

class CollisionTester {
    private final PrivateKeyGeneratorStrategy privateKeyGeneratorStrategy;
    private final Set<Long> privateKeys;
    private final long[] accountIds;

    CollisionTester(PrivateKeyGeneratorStrategy privateKeyGeneratorStrategy, long[] accountIds) {
        System.out.println("Testing for " + privateKeyGeneratorStrategy.getClass().getSimpleName() + "...");
        this.privateKeyGeneratorStrategy = privateKeyGeneratorStrategy;
        this.accountIds = accountIds;
        this.privateKeys = new HashSet<>();
    }

    void testForCollision() {
        long start = System.currentTimeMillis();
        int numberOfCollisions = 0;
        for (AuthenticationType authenticationType : AuthenticationType.values()) {
            for (long accountId : accountIds) {
                if (!privateKeys.add(privateKeyGeneratorStrategy.generate(accountId, authenticationType))) {
                    numberOfCollisions++;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Finished in " + (end - start) + " ms. Number of collisions: " + numberOfCollisions);
    }
}
