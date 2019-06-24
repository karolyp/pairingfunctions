package com.company.generators;

import com.company.AuthenticationType;

public class CantorPairingStrategy implements PrivateKeyGeneratorStrategy {
    @Override
    public long generate(long accountId, AuthenticationType authenticationType) {
        return cantorPairing(accountId, authenticationType.getValue());
    }

    private long cantorPairing(long x, long y) {
        return (x + y) * (x + y + 1) / 2 + y;
    }
}
