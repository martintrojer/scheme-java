package mtscheme.Expression;

import mtscheme.Env;
import mtscheme.Expression.Value.Bool;
import mtscheme.Expression.Value.Num;
import mtscheme.GlobalEnv;
import mtscheme.Repl;
import org.junit.Assert;

import java.math.BigDecimal;
import java.util.List;

public class TestHelpers {

  private static EvalContext getEvalContext(String expr, Env... env) {
    Env evalEnv = GlobalEnv.globalEnv();
    if (env.length > 0)
      evalEnv = env[0];
    return Repl.readAndEvalFirstForm(expr, evalEnv);
  }

  public static void testNumber(String expr, BigDecimal expect, Env... env) {
    EvalContext res = getEvalContext(expr, env);
    Assert.assertEquals(expect, ((Num) res.expr).val);
  }

  public static void testBool(String expr, boolean expect) {
    EvalContext res = getEvalContext(expr);
    Assert.assertEquals(expect, ((Bool) res.expr).val);
  }

  public static void testNull(String expr) {
    Assert.assertEquals(new Nil(), getEvalContext(expr).expr);
  }

  public static void testEnv(String expr, String key, BigDecimal expect) {
    EvalContext res = getEvalContext(expr);
    Assert.assertEquals(expect, ((Num)res.env.lookUp(key).get()).val);
  }

  public static void testList(String expr, List<IExpression> expect, Env... env) {
    EvalContext res = getEvalContext(expr, env);
    Assert.assertEquals(expect, ((ListExpr)res.expr).exprs);
  }

  public static Env getEnv(String expr, Env... env) {
    return getEvalContext(expr, env).env;
  }
}
