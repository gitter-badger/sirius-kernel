/*
 * Made with all the love in the world
 * by scireum in Remshalden, Germany
 *
 * Copyright by scireum GmbH
 * http://www.scireum.de - info@scireum.de
 */

package sirius.kernel.commons;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Provides a mutable value holder
 * <p>
 * Can be used to create final variable which can be modified from within an inner class.
 *
 * @author Andreas Haufler (aha@scireum.de)
 * @since 2013/08
 */
public class ValueHolder<T> implements Supplier<T>, Consumer<T> {
    private T value;

    /**
     * Creates a new <tt>ValueHolder</tt> with the given initial value.
     * <p>
     * This method can be used instead of a constructor, so that the type parameters don't need to be re-typed.
     *
     * @param initialValue sets the value of the value holder
     * @param <T>          the type of the value being held by this <tt>ValueHolder</tt>
     * @return a new ValueHolder initialized with the given value.
     */
    public static <T> ValueHolder<T> of(T initialValue) {
        return new ValueHolder<>(initialValue);
    }

    /**
     * Creates a new value holder with the given initial value
     *
     * @param initialValue sets the value of the value holder
     */
    public ValueHolder(T initialValue) {
        this.value = initialValue;
    }

    @Override
    public T get() {
        return value;
    }

    /**
     * Sets the value of this value holder
     *
     * @param value the new value of this value holder
     */
    public void set(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Strings.toString(value);
    }

    @Override
    public void accept(T t) {
        this.value = t;
    }
}
