package mtscheme.Expression.BuiltIns;

import mtscheme.Env;
import mtscheme.Expression.EvalContext;
import mtscheme.Expression.IExpression;
import mtscheme.Expression.Nil;

public class Display implements IExpression {
  public EvalContext eval (Env env, IExpression... exprs) {
    EvalContext res = exprs[0].eval(env);
    System.out.println(res.expr.toString());
    return new EvalContext(env, new Nil());
  }
}
