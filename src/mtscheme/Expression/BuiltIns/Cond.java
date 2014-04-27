package mtscheme.Expression.BuiltIns;

import mtscheme.Env;
import mtscheme.Expression.*;
import mtscheme.Expression.Value.Bool;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Optional;

public class Cond implements IExpression {

  private Optional<EvalContext> doExpr(Env env, Comb comb) {
    if (comb.exprs.size() != 2)
      throw new IllegalArgumentException("cond illegal expression");
    else {
      IExpression condExpr = comb.exprs.get(0);
      IExpression posExpr = comb.exprs.get(1);
      if (condExpr.equals(new Symbol("else")))
        return Optional.of(posExpr.eval(env));
      else {
        EvalContext res = condExpr.eval(env);
        if (res.expr.equals(new Bool(true)))
          return Optional.of(posExpr.eval(env));
        else
          return Optional.empty();
      }
    }
  }

  public EvalContext eval(Env env, IExpression... exprs) {
    Iterator<IExpression> it = Arrays.asList(exprs).iterator();

    while (it.hasNext()) {
      Optional<EvalContext> res = doExpr(env, (Comb) it.next());
      if (res.isPresent())
        return res.get();
    }
    return new EvalContext(env, new Nil());
  }
}
