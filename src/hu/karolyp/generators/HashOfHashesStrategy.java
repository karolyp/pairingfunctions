package hu.karolyp.generators;

import hu.karolyp.ByteUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashOfHashesStrategy implements GeneratorStrategy {
    private final MessageDigest md = MessageDigest.getInstance("SHA-256");

    public HashOfHashesStrategy() throws NoSuchAlgorithmException {
    }

    @Override
    public long generate(long a, long b) {
        byte[] hashOfA = md.digest(ByteUtils.longToBytes(a));
        byte[] hashOfB = md.digest(ByteUtils.longToBytes(b));
        byte[] concatenatedHashes = new byte[hashOfA.length + hashOfB.length];

        System.arraycopy(hashOfA, 0, concatenatedHashes, 0, hashOfA.length);
        System.arraycopy(hashOfB, 0, concatenatedHashes, hashOfA.length, hashOfB.length);

        return ByteUtils.bytesToLong(md.digest(concatenatedHashes));
    }
}