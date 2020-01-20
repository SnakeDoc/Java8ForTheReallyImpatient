Q: It should be possible to concurrently collect stream results in a single `ArrayList`, instead of merging multiple array lists, provided it has been constructed with the stream's size, since concurrent `set` operations at disjoint positions are threadsafe. How can you achieve that?

A: 
