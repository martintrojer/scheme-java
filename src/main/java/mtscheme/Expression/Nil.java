package mtscheme.Expression;

import mtscheme.Env;

public class Nil implements IExpression {

  @Override
  public boolean equals(Object object) {
    return object instanceof Nil;
  }

  @Override
  public String toString() {
    return "nil";
  }

  public EvalContext eval (Env env, IExpression... exprs) {
    return new EvalContext(env, new Nil());
  }
}
