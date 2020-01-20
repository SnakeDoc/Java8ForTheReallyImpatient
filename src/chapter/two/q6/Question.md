Q: The `characterStream` method in Section 2.3, "The `filter`, `map`, and `flatMap` Methods," on page 25, was a bit clumsy, first filling an array list and then turning it into a stream. Write a stream-based one-liner instead. One approach is to make a stream of integers from `0` to `s.length() - 1` and map that with the `s::charAt` method reference.

A: 
