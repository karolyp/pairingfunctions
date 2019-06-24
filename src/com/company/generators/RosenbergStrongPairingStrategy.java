package com.company.generators;

import com.company.AuthenticationType;

public class RosenbergStrongPairingStrategy implements PrivateKeyGeneratorStrategy {
    @Override
    public long generate(long accountId, AuthenticationType authenticationType) {
        return rosenbergStrongPairing(accountId, authenticationType.getValue());
    }

    private long rosenbergStrongPairing(long x, long y) {
        long max = Math.max(x, y);
        return max * max + max + x - y;
    }
}