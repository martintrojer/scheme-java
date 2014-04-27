package mtscheme.Expression;

import mtscheme.Env;
import mtscheme.Expression.BuiltIns.AritFun;
import mtscheme.Expression.Value.Num;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

public class CombTest {
  Env testEnv = new Env().addEntry("+", new AritFun(BigDecimal::add));

  @Test
  public void testSimpleEval() throws Exception {
    EvalContext res =
          new Comb(Arrays.asList(
            new Symbol("+"),
            new Num(BigDecimal.ONE),
            new Num(BigDecimal.TEN)))
          .eval(testEnv);
    Assert.assertEquals(BigDecimal.valueOf(11), ((Num) res.expr).val);
  }

  @Test
  public void testNestedEval() throws Exception {
    EvalContext res =
          new Comb(Arrays.asList(
            new Symbol("+"),
            new Comb(Arrays.asList(new Symbol("+"), new Num(BigDecimal.ONE), new Num(BigDecimal.ONE))),
            new Num(BigDecimal.TEN)))
          .eval(testEnv);
    Assert.assertEquals(BigDecimal.valueOf(12), ((Num) res.expr).val);
  }
}
