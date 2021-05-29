package hu.karolyp.generators;

public class XORStrategy implements GeneratorStrategy {
    @Override
    public long generate(long a, long b) {
        return a ^ b;
    }
}
