package mtscheme;

import mtscheme.Expression.BuiltIns.*;

public class GlobalEnv {
  public static Env globalEnv() {
    return new Env()
            .addEntry("+", new Add())
            .addEntry("-", new Sub())
            .addEntry("*", new Mul())
            .addEntry("/", new Div())

            .addEntry("=", new Eq())
            .addEntry(">", new Gt())
            .addEntry(">=", new Ge())
            .addEntry("<", new Lt())
            .addEntry("<=", new Le())

            .addEntry("not", new Not());
  }
}
