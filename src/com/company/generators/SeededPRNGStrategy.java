package com.company.generators;

import com.company.AuthenticationType;

import java.util.Random;

public class SeededPRNGStrategy implements PrivateKeyGeneratorStrategy {
    @Override
    public long generate(long accountId, AuthenticationType authenticationType) {
        Random r = new Random(accountId);
        long privateKey = r.nextLong();
        for (int i = 0; i < authenticationType.ordinal(); i++) {
            privateKey = r.nextLong();
        }
        return privateKey;
    }
}
