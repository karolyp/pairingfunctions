package com.company.generators;

import com.company.AuthenticationType;

public class ElegantPairingStrategy implements PrivateKeyGeneratorStrategy {
    @Override
    public long generate(long accountId, AuthenticationType authenticationType) {
        return elegantPairing(accountId, authenticationType.getValue());
    }

    private long elegantPairing(long x, long y) {
        return x > y ? x * x + x + y : y * y + x;
    }
}