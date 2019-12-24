package chapter.one.q9;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface Collection2<T> extends Collection<T> {

	default void forEachIf(Consumer<T> action, Predicate<T> filter) {
		this.forEach(e -> { if (filter.test(e)) action.accept(e); });
	}
	
}