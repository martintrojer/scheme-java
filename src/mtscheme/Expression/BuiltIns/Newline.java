package mtscheme.Expression.BuiltIns;

import mtscheme.Env;
import mtscheme.Expression.EvalContext;
import mtscheme.Expression.IExpression;
import mtscheme.Expression.Nil;

public class Newline implements IExpression {
  public EvalContext eval(Env env, IExpression... exprs) {
    System.out.println();
    return new EvalContext(env, new Nil());
  }
}
