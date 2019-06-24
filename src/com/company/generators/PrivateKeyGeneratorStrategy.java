package com.company.generators;

import com.company.AuthenticationType;

public interface PrivateKeyGeneratorStrategy {
    long generate(long accountId, AuthenticationType authenticationType);
}
