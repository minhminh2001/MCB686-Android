package com.qslib.interfaces;

/**
 * Created by dangpp on 2/9/2018.
 */

public interface Supplier<T, R> {
    R accept(T t);
}
