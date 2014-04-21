package mtscheme.Expression.Value;

import mtscheme.Environment.Env;
import mtscheme.Expression.EvalContext;
import mtscheme.Expression.IExpression;

import java.util.List;

public class Value<T> implements IExpression {
  public T val;

  public boolean equals(Object object) {
    return object instanceof Value && ((Value)object).val == val;
  }

  // Values evaluate to themselves
  public EvalContext eval(Env env, List<IExpression> exprs) {
    return new EvalContext(env, this);
  }
}
