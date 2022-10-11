package part3.util;

@FunctionalInterface
public interface TriFunction<T, U, V, R> {
	R apply(T t, U u, R r);
}
