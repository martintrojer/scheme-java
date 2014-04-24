package mtscheme.Expression.BuiltIns;

import mtscheme.Env;
import mtscheme.Expression.EvalContext;
import mtscheme.Expression.IExpression;
import mtscheme.Expression.Value.Bool;
import mtscheme.Expression.Value.Value;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CompFun implements IExpression, IProc {

  public interface CmpFn {
    boolean invoke(Value a, Value b);
  }

  private CmpFn fn;

  public CompFun(CmpFn fn) {
    this.fn = fn;
  }

  public EvalContext eval(Env env, IExpression... exprs) {
    List<Value> nums =
            Arrays.asList(exprs).stream()
                    .map(e -> e.eval(env))
                    .map(ctx -> (Value) ctx.expr)
                    .collect(Collectors.toList());
    Value head = nums.remove(0);
    boolean res = nums.stream().allMatch(a -> fn.invoke(head, a));
    return new EvalContext(env, new Bool(res));
  }
}
