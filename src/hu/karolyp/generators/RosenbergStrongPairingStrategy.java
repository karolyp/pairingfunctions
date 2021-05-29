package hu.karolyp.generators;

public class RosenbergStrongPairingStrategy implements GeneratorStrategy {
    @Override
    public long generate(long a, long b) {
        long max = Math.max(a, b);
        return max * max + max + a - b;
    }
}