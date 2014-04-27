package mtscheme.Expression;

import mtscheme.Env;

public class Nil implements IExpression {

  public boolean equals(Object object) {
    return object instanceof Nil;
  }

  public EvalContext eval (Env env, IExpression... exprs) {
    return new EvalContext(env, new Nil());
  }
}
