package mtscheme.Expression;

import mtscheme.Env;

public interface IExpression {

  public EvalContext eval(Env env, IExpression... exprs);
}
