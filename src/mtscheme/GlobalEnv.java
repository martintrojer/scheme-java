package mtscheme;

import mtscheme.Expression.BuiltIns.Add;
import mtscheme.Expression.BuiltIns.Div;
import mtscheme.Expression.BuiltIns.Mul;
import mtscheme.Expression.BuiltIns.Sub;

public class GlobalEnv {
  public static Env globalEnv() {
    return new Env()
            .addEntry("+", new Add())
            .addEntry("-", new Sub())
            .addEntry("*", new Mul())
            .addEntry("/", new Div());
  }
}
