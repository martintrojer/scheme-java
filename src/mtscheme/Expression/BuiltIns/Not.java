package mtscheme.Expression.BuiltIns;

import mtscheme.Env;
import mtscheme.Expression.EvalContext;
import mtscheme.Expression.IExpression;
import mtscheme.Expression.Value.Bool;

import java.util.List;

public class Not implements IExpression, IProc {

  public EvalContext eval(Env env, List<IExpression> exprs) {
    EvalContext ctx = exprs.get(0).eval(env, exprs);
    if (ctx.expr instanceof Bool)
      return new EvalContext(env, new Bool(!((Bool)ctx.expr).val));
    else
      throw new IllegalArgumentException("improper use of not");
  }
}
