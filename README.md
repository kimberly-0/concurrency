# Concurrency

This program uses concurrency to repeatedly print the letters  'W', 'X', 'y', and 'z', while satisfying the following conditions:

- "W"s and "X"s must alternate in the output string and the first "W" must precede the first "X"
- "y"s and "z"s must alternate in the output string and the first "y" must precede the first "z"
- The total number of "y"s and "z"s that have been output at any given point in the output string cannot exceed the number of "W"s that have been output up to that point

Each letter is printed by a separate thread and semaphores are used to communicate between the threads.

## Getting started

1. Install [Java](https://www.oracle.com/java/technologies/downloads/#java17)

2. Download the code in a ZIP file or clone the repository

``` $ git clone https://github.com/kimberly-0/concurrency.git ```

3. Open `PrintLetters.java` (located in *src/main/java/kd*) in an IDE

4. Run the `main` method
