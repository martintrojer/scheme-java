package mtscheme.Expression;

import mtscheme.Env;

public class EvalContext {
  public final Env env;
  public final IExpression expr;

  public EvalContext(Env env, IExpression expr) {
    this.env = env;
    this.expr = expr;
  }
}
