package types;

public interface Mergeable<E> {
    E merge(E other);
}
