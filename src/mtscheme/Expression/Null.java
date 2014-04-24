package mtscheme.Expression;

import mtscheme.Env;

public class Null implements IExpression {

  public boolean equals(Object object) {
    return object instanceof Null;
  }

  public EvalContext eval (Env env, IExpression... exprs) {
    throw new IllegalStateException("trying to eval Null");
  }
}
