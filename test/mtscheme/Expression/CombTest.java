package mtscheme.Expression;

import mtscheme.Environment.Env;
import mtscheme.Expression.BuiltIns.Add;
import mtscheme.Expression.Value.Num;
import org.junit.Assert;
import org.junit.Test;
import org.pcollections.ConsPStack;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class CombTest {
  Env emptyEnv = new Env();
  List<IExpression> noExprs = Arrays.asList(new Null());

  @Test
  public void testSimpleEval() throws Exception {
    EvalContext res =
          new Comb(Arrays.asList(
            new Add(),
            new Num(BigDecimal.ONE),
            new Num(BigDecimal.TEN)))
          .eval(emptyEnv, noExprs);
    Assert.assertEquals(BigDecimal.valueOf(11), ((Num) res.expr).val);
  }

  @Test
  public void testNestedEval() throws Exception {
    EvalContext res =
          new Comb(Arrays.asList(
            new Add(),
            new Comb(Arrays.asList(new Add(), new Num(BigDecimal.ONE), new Num(BigDecimal.ONE))),
            new Num(BigDecimal.TEN)))
          .eval(emptyEnv, noExprs);
    Assert.assertEquals(BigDecimal.valueOf(12), ((Num) res.expr).val);
  }
}
