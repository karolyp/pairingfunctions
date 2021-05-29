package hu.karolyp;

public class ByteUtils {
    public static byte[] longToBytes(long number) {
        byte[] result = new byte[8];
        for (int i = 8 - 1; i >= 0; i--) {
            result[i] = (byte) (number & 0xFF);
            number >>= 8;
        }
        return result;
    }

    public static long bytesToLong(byte[] bytes) {
        long result = 0;
        for (int i = 0; i < 8; i++) {
            result <<= 8;
            result |= (bytes[i] & 0xFF);
        }
        return result;
    }
}