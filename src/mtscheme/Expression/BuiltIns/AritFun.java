package mtscheme.Expression.BuiltIns;

import mtscheme.Env;
import mtscheme.Expression.EvalContext;
import mtscheme.Expression.IExpression;
import mtscheme.Expression.Value.Num;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AritFun implements IExpression, IProc {

  // functional interface, to hold a reference to the lambda
  interface AritFn {
    BigDecimal invoke(BigDecimal a, BigDecimal b);
  }

  private AritFn fn;

  public AritFun(AritFn fn) {
    this.fn = fn;
  }

  public EvalContext eval(Env env, List<IExpression> exprs) {
    List<BigDecimal> nums =
            exprs.stream()
                    .map(e -> e.eval(env, Arrays.asList(e)))
                    .map(ctx -> ((Num) ctx.expr).val)
                    .collect(Collectors.toList());
    BigDecimal head = nums.remove(0);
    BigDecimal res = nums.stream().reduce(head, fn::invoke);
    return new EvalContext(env, new Num(res));
  }
}
