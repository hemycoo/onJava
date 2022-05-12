package com.onjava.stream;

import java.util.stream.Stream;

public class StreamOfStreams {
    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 6)
                .flatMap(s -> s>3?Stream.of(s):Stream.of())
                .forEach(System.out::println);
    }
}
