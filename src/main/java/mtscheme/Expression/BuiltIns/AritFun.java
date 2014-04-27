package mtscheme.Expression.BuiltIns;

import mtscheme.Env;
import mtscheme.Expression.EvalContext;
import mtscheme.Expression.IExpression;
import mtscheme.Expression.Value.Num;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AritFun implements IExpression {

  // functional interface, to hold a reference to the lambda
  public interface AritFn {
    BigDecimal invoke(BigDecimal a, BigDecimal b);
  }

  private AritFn fn;

  public AritFun(AritFn fn) {
    this.fn = fn;
  }

  public EvalContext eval(Env env, IExpression... exprs) {
    List<BigDecimal> nums =
            Arrays.asList(exprs).stream()
                    .map(e -> e.eval(env))
                    .map(ctx -> ((Num) ctx.expr).val)
                    .collect(Collectors.toList());
    BigDecimal head = nums.remove(0);
    BigDecimal res = nums.stream().reduce(head, fn::invoke);
    return new EvalContext(env, new Num(res));
  }
}
