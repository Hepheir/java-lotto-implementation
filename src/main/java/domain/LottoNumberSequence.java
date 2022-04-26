package domain;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;


// - 숫자가 6개만 있음을 보장 -> 여기서 책임지자.
// - 객체의 동등성 보다는 논리적 동일성을 봄.
// - 중복된 숫자가 없음을 보장 -> HashSet 으로 책임을 위임
// - 1~45 범위의 숫자만 있음을 보장 -> LottoNumber 로 책임을 위임
public class LottoNumberSequence extends TreeSet<LottoNumber> implements SortedSet<LottoNumber>, Cloneable {
    private final Integer maxCapacity;

    public LottoNumberSequence(Integer maxCapacity) throws IllegalArgumentException {
        this.maxCapacity = maxCapacity;
    }

    public LottoNumberSequence(Collection<LottoNumber> collection, Integer maxCapacity) throws IllegalArgumentException {
        this.maxCapacity = maxCapacity;
        this.addAll(collection);
    }

    @Override
    public boolean add(LottoNumber number) throws IllegalArgumentException {
        checkIsAddable(number);
        return super.add(number);
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends LottoNumber> numbers) throws IllegalArgumentException {
        checkIsAddable(numbers);
        return super.addAll(numbers);
    }

    @Override
    public LottoNumberSequence clone() throws IllegalArgumentException {
        return new LottoNumberSequence(this, maxCapacity);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof LottoNumberSequence) {
            return o.hashCode() == hashCode();
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (LottoNumber number : this) {
            hash += 31 * hash + number.hashCode();
        }
        return hash;
    }

    public Boolean isFull() {
        return size() == maxCapacity;
    }

    private void checkIsAddable(LottoNumber lottoNumber) throws IllegalArgumentException {
        if (this.contains(lottoNumber)) {
            return;
        }
        checkIsAddable(1);
    }

    private void checkIsAddable(Collection<? extends LottoNumber> collection) throws IllegalArgumentException {
        Set<LottoNumber> set = new HashSet<>(collection);
        checkIsAddable(set);
    }

    private void checkIsAddable(Set<LottoNumber> set) throws IllegalArgumentException {
        set.retainAll(this);
        checkIsAddable(set.size());
    }

    private void checkIsAddable(int requiredSize) throws IllegalArgumentException {
        if (size() + requiredSize > maxCapacity) {
            throw new IllegalArgumentException("Exceeds maximum capacity");
        }
    }
}
