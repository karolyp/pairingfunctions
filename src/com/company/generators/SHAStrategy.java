package com.company.generators;

import com.company.AuthenticationType;
import com.company.ByteUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHAStrategy implements PrivateKeyGeneratorStrategy {
    private final MessageDigest shaDigest;

    public SHAStrategy() throws NoSuchAlgorithmException {
        shaDigest = MessageDigest.getInstance("SHA-256");
    }

    @Override
    public long generate(long accountId, AuthenticationType authenticationType) {
        byte[] digest = shaDigest.digest(ByteUtils.longToBytes(accountId));
        for (int i = 0; i < authenticationType.ordinal(); i++) {
            digest = shaDigest.digest(digest);
        }
        return ByteUtils.bytesToLong(digest);
    }
}