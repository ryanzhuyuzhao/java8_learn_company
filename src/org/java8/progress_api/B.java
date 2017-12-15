package org.java8.progress_api;

public interface B extends A{
    default void hello() {
        System.out.println("Hello from B");
    }
}
