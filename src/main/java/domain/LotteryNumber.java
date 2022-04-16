package domain;

public final class LotteryNumber extends Number implements Comparable<LotteryNumber> {
    /**
     * A constant tholding the minimum value an {@code LotteryNumber} can
     * have, 1.
     */
    public static final int MIN_VALUE = 1;

    /**
     * A constant tholding the maximum value an {@code LotteryNumber} can
     * have, 45.
     */
    public static final int MAX_VALUE = 45;

    public static String toString(int i) {
        return Integer.toString(i);
    }

    private static class LotteryNumberCache {
        static final int low = MIN_VALUE;
        static final int high = MAX_VALUE;
        static final LotteryNumber[] cache;

        static {
            final int cacheSize = high - low + 1;
            cache = new LotteryNumber[cacheSize];
            for (int i = 0; i < cacheSize; i++) {
                cache[i] = new LotteryNumber(low+i);
            }
        }

        private LotteryNumberCache() {
        }
    }

    public static LotteryNumber of(Integer i) throws IndexOutOfBoundsException {
        if (i >= LotteryNumberCache.low && i <= LotteryNumberCache.high) {
            return LotteryNumberCache.cache[i + (-LotteryNumberCache.low)];
        }
        throw new IndexOutOfBoundsException();
    }

    /**
     * The value of the {@code LotteryNumber}.
     *
     * @serial
     */
    private final int value;

    private LotteryNumber(int value) throws IndexOutOfBoundsException {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IndexOutOfBoundsException();
        }
        this.value = value;
    }

    /**
     * Compares two {@code LotteryNumber} objects numerically.
     *
     * @param anotherNumber the {@code LotteryNumber} to be compared.
     * @return the value {@code 0} if this {@code LotteryNumber} is
     *         equal to the argument {@code LotteryNumber}; a value less than
     *         {@code 0} if this {@code LotteryNumber} is numerically less
     *         than the argument {@code LotteryNumber}; and a value greater
     *         than {@code 0} if this {@code LotteryNumber} is numerically
     *         greater than the argument {@code LotteryNumber}.
     */
    @Override
    public int compareTo(LotteryNumber anotherNumber) {
        return Integer.compare(this.value, anotherNumber.intValue());
    }

    @Override
    public int intValue() {
        return value;
    }

    @Override
    public long longValue() {
        return (long) value;
    }

    @Override
    public float floatValue() {
        return (float) value;
    }

    @Override
    public double doubleValue() {
        return (double) value;
    }
}
