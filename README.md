# Enterprise FizzBuzz

This application serves as an example of some classic Object Orientated design patterns illustrated around the FizzBuzz problem.

Search for the `@PATTERN` comment to find examples of patterns in the code.

## FizzBuzz Types

This app supports two flavours of FizzBuzz:

* `Standard` where divisibility by 3 and 5 is used 
* `Stage2` where the `Standard` behaviour is enhanced to also include checks if the number contains the digit 3 or 5   

## Introduction To The Code

The `main` method in `App.java` is the entry point.

There are two very important low level interfaces - `NumberProcessor` and `NumberTextResolver`

```java
public interface NumberProcessor {
    Optional<String> processNumber(Integer number);
}
```

```java
public interface NumberTextResolver {
    String convertToText(Integer number);
}
``` 

`NumberProcessor` takes a number and if it can handle the number returns a result, otherwise empty

`NumberTextResolver` gives a stronger result - given a number, return a string. 

These two classes are related by the `ChainingNumberTextResolver` class which uses Chain Of Responsibility pattern to iterate over a list of `NumberProcessor` instances until it finds one which can handle the number.

Best to dig into the code to see how it all hangs together - begin in `App.java`. 

## Patterns Included

| Pattern name | Implementing class                     | Background |
|--------------|----------------------------------------|------------|
| Factory      | FizzBuzzRunnerFactory.java             | Allows to create an instance of `FizzBuzzRunner` based on type - `Standard` or `Stage2` |
| Factory      | FizzBuzzNumberTextResolverFactory.java | Create a NumberTextResolver based on `Predicate`s |
| Composite    | ValidatingNumberTextResolver.java      | Wraps an object of same type (`NumberTextResolver`) to add validation functionality |
| Chain Of Responsibility  | ChainingNumberTextResolver.java | Iterates over a list of `NumberProcessor` until it finds one which can handle the number |

 ## High Level Patterns
 
This code uses Dependency Injection - `FizzBuzzRunnerFactory.java` is responsible for application wiring in this example.
 
All other classes have collaborators wired in as constructor parameters.