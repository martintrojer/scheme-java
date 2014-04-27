package mtscheme.Expression.Value;

import mtscheme.Env;
import mtscheme.Expression.EvalContext;
import mtscheme.Expression.IExpression;

public abstract class Value<T> implements IExpression {
  public T val;

  @Override
  public boolean equals(Object object) {
    return object instanceof Value && ((Value)object).val.equals(val);
  }

  @Override
  public String toString() {
    return val.toString();
  }

  // Values evaluate to themselves
  public EvalContext eval(Env env, IExpression... exprs) {
    return new EvalContext(env, this);
  }
}
