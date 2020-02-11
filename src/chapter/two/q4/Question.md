Q: Suppose you have an array `int[] values = { 1, 4, 9, 16 }`. What is `Stream.of(values)`? How do you get a stream of `int` instead?

A: `Stream.of(values)` produces a stream of `int[]` type - more specifically a `Stream<int[]>`. To obtain a stream of `int` instead, we must use `IntStream` as shown in `Four.java`.
