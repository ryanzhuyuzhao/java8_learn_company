package org.java8.date_java8;

import java.time.Instant;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;

public class InstantTest {
    public static void main(String[] args) {
        System.out.println(Instant.ofEpochSecond(3));
        System.out.println(Instant.ofEpochSecond(3,0));
        System.out.println(Instant.ofEpochSecond(2,1_000_000_000));
        System.out.println(Instant.ofEpochSecond(2,-1_000_000_000));
    }
}
