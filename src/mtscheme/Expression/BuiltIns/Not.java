package mtscheme.Expression.BuiltIns;

import mtscheme.Env;
import mtscheme.Expression.EvalContext;
import mtscheme.Expression.IExpression;
import mtscheme.Expression.Value.Bool;

public class Not implements IExpression, IProc {

  public EvalContext eval(Env env, IExpression... exprs) {
    if (exprs.length != 1)
      throw new IllegalArgumentException("not");
    EvalContext ctx = exprs[0].eval(env, exprs);
    if (ctx.expr instanceof Bool)
      return new EvalContext(env, new Bool(!((Bool)ctx.expr).val));
    else
      throw new IllegalArgumentException("improper use of not");
  }
}
