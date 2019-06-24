package com.company.generators;

import com.company.AuthenticationType;

public class FormerPrivateKeyStrategy implements PrivateKeyGeneratorStrategy {
    @Override
    public long generate(long accountId, AuthenticationType authenticationType) {
        return accountId ^ authenticationType.getValue();
    }
}
