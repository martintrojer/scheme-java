package mtscheme.Expression.BuiltIns;

import mtscheme.Env;
import mtscheme.Expression.EvalContext;
import mtscheme.Expression.IExpression;
import mtscheme.Expression.Nil;
import mtscheme.Expression.Value.Bool;

import java.util.Arrays;
import java.util.Iterator;

public class If implements IExpression, IProc {

  public EvalContext eval(Env env, IExpression... exprs) {
    Iterator<IExpression> it = Arrays.asList(exprs).iterator();

    IExpression cond = null;
    IExpression thenClause = null;
    IExpression elseClause = null;

    if (it.hasNext())
      cond = it.next();
    else
      throw new IllegalArgumentException("if pred missing");
    if (it.hasNext())
      thenClause = it.next();
    else
      throw new IllegalArgumentException("if then clause missing");
    if (it.hasNext())
      elseClause = it.next();
    else
      elseClause = ((a, b) -> new EvalContext(env, new Nil()));  // look how nice this replaced the anonymous class!

    EvalContext ctx = cond.eval(env);
    if (ctx.expr instanceof Bool) {
      if (((Bool)ctx.expr).val)
        return thenClause.eval(env);
      else
        return elseClause.eval(env);
    }
    else
      throw new IllegalArgumentException("if");
  }
}
