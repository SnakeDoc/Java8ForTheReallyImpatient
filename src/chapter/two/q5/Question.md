Q: Using `Stream.iterate`, make an infinite stream of random numbers - not by calling `Math.random` but by directly implementing a _linear congruential generator_. IN such a generator, you start with `x<sub>0</sub> = seed` and then produce `x<sub>n + 1</sub> = (a x<sub>n</sub> + c) % m`, for appropriate values of `a, c`, and `m`. You should implement a method with parameters `a, c, m,` and `seed` that yields a `Stream<Long>`. Try out `a = 25214903917`, `c = 11`, `m = 2<sup>48</sup>`.

A: 
