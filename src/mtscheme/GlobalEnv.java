package mtscheme;

import mtscheme.Expression.BuiltIns.*;
import mtscheme.Expression.Value.Bool;
import mtscheme.Expression.Value.Num;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class GlobalEnv {
  public static Env globalEnv() {
    return new Env()
            .addEntry("+", new AritFun(BigDecimal::add))
            .addEntry("-", new AritFun(BigDecimal::subtract))
            .addEntry("*", new AritFun(BigDecimal::multiply))
            .addEntry("/", new AritFun((a,b) -> a.divide(b, RoundingMode.HALF_UP)))

            .addEntry("=",  new CompFn((a, b) -> a.equals(b)))
            .addEntry(">",  new CompFn((a, b) -> ((Num) a).gt((Num) b)))
            .addEntry(">=", new CompFn((a, b) -> ((Num) a).ge((Num) b)))
            .addEntry("<",  new CompFn((a, b) -> ((Num) a).lt((Num) b)))
            .addEntry("<=", new CompFn((a, b) -> ((Num) a).le((Num) b)))

            .addEntry("true", new Bool(true))
            .addEntry("false", new Bool(false))

            .addEntry("not", new Not())
            .addEntry("if", new If())
            .addEntry("cond", new Cond())
            .addEntry("define", new Define())

            .addEntry("cons", new Cons())
            .addEntry("list", new ListFn())
            .addEntry("append", new Append())
            .addEntry("car", new Car())
            .addEntry("cdr", new Cdr())
            .addEntry("null?", new Null())

            .addEntry("let", new Let())
            .addEntry("begin", new Begin())
            .addEntry("lambda", new Lambda());
  }
}
