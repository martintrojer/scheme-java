# An interpreter of (a subset of) the Scheme programming language

```
mtscheme v0.1
nil
> (define (map f l) (if (not (null? l)) (cons (f (car l)) (map f (cdr l)))))
nil
> (map (lambda (x) (* x x)) (list 1 2 3))
(,1,4,9)
>
```

Written in Java8, uses [pcollections](http://pcollections.org).

Copyright Martin Trojer <martin.trojer@gmail.com>

Licensed under GPLv3

This is a toy, it was never the intention create a complete Scheme implementation. If you're interested in Scheme on the JVM, I suggest [Kawa](http://www.gnu.org/software/kawa/).

## Usage

Make sure you have the Java8 JDK and JAVA_HOME setup correctly.

### Maven

    $ mvn package

then

    $ mvn exec:java -Dexec.mainClass="mtscheme.Repl"

or

    $ java -cp ~/.m2/repository/org/pcollections/pcollections/2.1.2/pcollections-2.1.2.jar:target/mtscheme-java8-1.0-SNAPSHOT.jar mtscheme.Repl

### IntelliJ

Version 13.1 (or later), java 8.

Run tests or launch the `mtscheme.Repl` class
