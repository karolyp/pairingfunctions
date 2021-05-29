package hu.karolyp.generators;

public class CantorPairingStrategy implements GeneratorStrategy {
    @Override
    public long generate(long a, long b) {
        return (a + b) * (a + b + 1) / 2 + b;
    }
}
