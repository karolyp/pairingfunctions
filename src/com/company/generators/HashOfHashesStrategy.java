package com.company.generators;

import com.company.AuthenticationType;
import com.company.ByteUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashOfHashesStrategy implements PrivateKeyGeneratorStrategy {
    private final MessageDigest md = MessageDigest.getInstance("SHA-256");

    public HashOfHashesStrategy() throws NoSuchAlgorithmException {
    }

    @Override
    public long generate(long accountId, AuthenticationType authenticationType) {
        return hashOfHashes(accountId, authenticationType.getValue());
    }

    private long hashOfHashes(long x, long y) {
        byte[] hashOfX = md.digest(ByteUtils.longToBytes(x));
        byte[] hashOfY = md.digest(ByteUtils.longToBytes(y));
        byte[] concatenatedHashes = new byte[hashOfX.length + hashOfY.length];

        System.arraycopy(hashOfX, 0, concatenatedHashes, 0, hashOfX.length);
        System.arraycopy(hashOfY, 0, concatenatedHashes, hashOfX.length, hashOfY.length);

        return ByteUtils.bytesToLong(md.digest(concatenatedHashes));
    }
}