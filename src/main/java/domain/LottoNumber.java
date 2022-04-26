package domain;

import java.io.Serializable;

// - 1~45 범위의 숫자만 있음을 보장
public final class LottoNumber implements Serializable, Comparable<LottoNumber> {
    /**
     * A constant holding the minimum value an {@code LottoNumber} can
     * have, 1.
     */
    public static final int MIN_VALUE = 1;

    /**
     * A constant holding the maximum value an {@code LottoNumber} can
     * have, 45.
     */
    public static final int MAX_VALUE = 45;

    private static class LottoNumberCache {
        static final int low = MIN_VALUE;
        static final int high = MAX_VALUE;
        static final LottoNumber[] cache;

        static {
            final int cacheSize = high - low + 1;
            cache = new LottoNumber[cacheSize];
            for (int i = 0; i < cacheSize; i++) {
                cache[i] = new LottoNumber(low+i);
            }
        }

        private LottoNumberCache() {
        }
    }

    public static LottoNumber of(Integer i) throws IndexOutOfBoundsException {
        if (i >= LottoNumberCache.low && i <= LottoNumberCache.high) {
            return LottoNumberCache.cache[i + (-LottoNumberCache.low)];
        }
        throw new IndexOutOfBoundsException();
    }

    /**
     * The value of the {@code LottoNumber}.
     *
     * @serial
     */
    private final int value;

    private LottoNumber(int value) throws IndexOutOfBoundsException {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IndexOutOfBoundsException();
        }
        this.value = value;
    }

    /**
     * Compares two {@code LottoNumber} objects numerically.
     *
     * @param anotherNumber the {@code LottoNumber} to be compared.
     * @return the value {@code 0} if this {@code LottoNumber} is
     *         equal to the argument {@code LottoNumber}; a value less than
     *         {@code 0} if this {@code LottoNumber} is numerically less
     *         than the argument {@code LottoNumber}; and a value greater
     *         than {@code 0} if this {@code LottoNumber} is numerically
     *         greater than the argument {@code LottoNumber}.
     */
    @Override
    public int compareTo(LottoNumber anotherNumber) {
        return Integer.compare(this.value, anotherNumber.value);
    }

    @Override
    public String toString() {
        return Integer.toString(this.value);
    }
}
