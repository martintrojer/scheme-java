package mtscheme.Expression.BuiltIns;

import mtscheme.Environment.Env;
import mtscheme.Expression.EvalContext;
import mtscheme.Expression.Value.Num;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

public class AddTest {
  Env emptyEnv = new Env();

  @Test
  public void testSimpleEval() throws Exception {
    EvalContext res =
            new Add().eval(emptyEnv, Arrays.asList(
                    new Num(BigDecimal.ONE),
                    new Num(BigDecimal.TEN)));
    Assert.assertEquals(BigDecimal.valueOf(11), ((Num) res.expr).val);
  }}
