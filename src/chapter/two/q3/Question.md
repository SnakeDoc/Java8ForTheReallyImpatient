Q: Measure the difference when counting long words with a `parallelStream` instead of a `stream`. Call `System.currentTimeMillis` before and after the call, and print the difference. Switch to a larger document (such as _War and Peace_) if you have a fast computer.

A: Using the code written for Chapter 2 Question 1's Answer, `One.java`, the following results were produced (snippet of 50 tests run in a loop):

```
Stream Word Count: 7536 in 29 milliseconds
Parallel Stream Word Count: 7536 in 14 milliseconds
Parallel Thread Word Count: 7536 in 12 milliseconds
Stream Word Count: 7536 in 27 milliseconds
Parallel Stream Word Count: 7536 in 14 milliseconds
Parallel Thread Word Count: 7536 in 14 milliseconds
Stream Word Count: 7536 in 27 milliseconds
Parallel Stream Word Count: 7536 in 13 milliseconds
Parallel Thread Word Count: 7536 in 17 milliseconds
Stream Word Count: 7536 in 31 milliseconds
Parallel Stream Word Count: 7536 in 12 milliseconds
Parallel Thread Word Count: 7536 in 15 milliseconds
Stream Word Count: 7536 in 28 milliseconds
Parallel Stream Word Count: 7536 in 13 milliseconds
Parallel Thread Word Count: 7536 in 14 milliseconds
```

So, on average, `Stream` takes at least twice as long to count words longer than 12 characters in a data file which contains three copies of __War and Peace__. The Parallel Thread code written for the same answer performed about on par with `ParallelStream`, but was far more difficult to write and consumes a lot more lines of code for the same result.
