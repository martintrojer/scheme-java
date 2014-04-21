package mtscheme.Expression.BuiltIns;

import mtscheme.Environment.Env;
import mtscheme.Expression.EvalContext;
import mtscheme.Expression.IExpression;
import mtscheme.Expression.Value.Num;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public abstract class AritFun implements IExpression {

  // functional interface, to hold a reference to the lambda
  interface AritFn {
    BigDecimal invoke(BigDecimal a, BigDecimal b);
  }

  private AritFn fn;
  private BigDecimal identity;

  public AritFun(BigDecimal identity, AritFn fn) {
    this.identity = identity;
    this.fn = fn;
  }

  public EvalContext eval(Env env, List<IExpression> exprs) {
    BigDecimal res =
            exprs.stream()
                    .map(e -> e.eval(env, Arrays.asList(e)))
                    .map(ctx -> ((Num) ctx.expr).val)
                    .reduce(identity, fn::invoke);
    return new EvalContext(env, new Num(res));
  }
}
