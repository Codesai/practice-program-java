### TextConverter exercise 

The `HtmlTextConverter` class is designed to reformat a plain text file for display in a browser.

We'll use TDD to add any new behavior to this code.

Try to do the minimum changes possible to the code.

#### First iteration
Modify the code so that it escapes `'` and `"` substituting them by `&quot;`.

1. Have a look at the code and identify the **change points** (the things that need to be modified
to add the new behavior).

2. Write unit tests to protect the existing behavior to avoid introducing regressions when you change the code.

    a. First you'll have to find some **test points** (places around the **change points** where
you need to add tests).

      * Which **test points** did you find?

      * How much code will the unit tests using those **test points** cover?

      * What would be your choice? Which criteria would you use to make that choice?

    b. You might need to break some dependencies before you can write the unit tests.

      * Which parts of the code make it difficult to write unit tests?

      * Which dependency-breaking technique will you need to be able to write unit tests?

      * Does the chosen dependency-breaking technique depend on the chosen **test points**?

      * Imagine you are really in a hurry, what technique could you apply?

      * Imagine you are not so much in a hurry, what technique could you apply?

4. Once the existing behavior is protected, start using TDD to add the new behavior.


#### Second iteration

Modify the code so that the html file has automatically
the same name as the input file and its written in the same place.

Follow the same procedure that in the previous step:

1. Identify the **change points**.

2. Identify the **test points**.

3. Write unit tests to protect the existing code, (you might need to break some dependencies).

4. Use TDD to add the new behavior, (you might have to refactor the code a bit first).

#### Third iteration

Modify the code so that we can create a `HtmlTextConverter`
that gets the input lines from a file,
or create one that gets them from a user writing on a console.

The program will consume lines written by the user until it detects
a line containing only `:q` which will mean the end of lines.

Follow the same procedure that in the previous step:

1. Identify the **change points**.

2. Identify the **test points**.

3. Write unit tests to protect the existing code, (you might need to break some dependencies).

4. Use TDD to add the new behavior, (you might have to refactor the code a bit first).

#### Fourth iteration

Modify the code so that we can create an object that converts the input text into markdown,
or into HTML and write it to a file.

Follow the same procedure that in the previous step:

1. Identify the **change points**.

2. Identify the **test points**.

3. Write unit tests to protect the existing code, (you might need to break some dependencies).

4. Use TDD to add the new behavior, (you might have to refactor the code a bit first).

  * How close are you from separating the different responsibilities in the class?

This kata is based on Luca Minudel's [Text Converter exercise](https://github.com/lucaminudel/TDDwithMockObjectsAndDesignPrinciples/tree/master/TDDMicroExercises/Java/TextConverter)
from his [TDDwithMockObjectsAndDesignPrinciples
](https://github.com/lucaminudel/TDDwithMockObjectsAndDesignPrinciples) exercises.