package mtscheme.Expression;

import mtscheme.Expression.Value.Bool;
import mtscheme.Expression.Value.Num;
import mtscheme.GlobalEnv;
import mtscheme.Parser.Parser;
import mtscheme.Parser.Tokenizer;
import org.junit.Assert;

import java.math.BigDecimal;
import java.util.List;

public class Helpers {

  public static void testNumber(String expr, BigDecimal expect) {
    EvalContext res =
            Parser.parse(Tokenizer.tokenize(expr))
                    .get(0).eval(GlobalEnv.globalEnv());
    Assert.assertEquals(expect, ((Num) res.expr).val);
  }

  public static void testBool(String expr, boolean expect) {
    EvalContext res =
            Parser.parse(Tokenizer.tokenize(expr))
                    .get(0).eval(GlobalEnv.globalEnv());
    Assert.assertEquals(expect, ((Bool) res.expr).val);
  }

  public static void testNull(String expr) {
    EvalContext res =
            Parser.parse(Tokenizer.tokenize(expr))
                    .get(0).eval(GlobalEnv.globalEnv());
    Assert.assertEquals(new Nil(), res.expr);
  }

  public static void testEnv(String expr, String key, BigDecimal expect) {
    EvalContext res =
            Parser.parse(Tokenizer.tokenize(expr))
                    .get(0).eval(GlobalEnv.globalEnv());
    Assert.assertEquals(expect, ((Num)res.env.lookUp(key).get()).val);
  }

  public static void testList(String expr, List<IExpression> expect) {
    EvalContext res =
            Parser.parse(Tokenizer.tokenize(expr))
                    .get(0).eval(GlobalEnv.globalEnv());
    Assert.assertEquals(expect, ((ListExpr)res.expr).exprs);
  }
}
