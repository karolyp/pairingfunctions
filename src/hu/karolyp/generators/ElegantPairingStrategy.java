package hu.karolyp.generators;

public class ElegantPairingStrategy implements GeneratorStrategy {
    @Override
    public long generate(long a, long b) {
        return a > b ? a * a + a + b : b * b + a;
    }
}