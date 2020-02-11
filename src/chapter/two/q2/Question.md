Q: Verify that asking for the first five long words does not call the filter method once the fifth long word has been found. Simply log each method call.

A: Using the `limit` operation causes the `filter` method to only be executed as long as the limit number has not been reached. Note that using `parallelStream` does cause a greater number of executions since it is not known where in the words list each stream starts evaluating from.
