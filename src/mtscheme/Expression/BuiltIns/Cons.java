package mtscheme.Expression.BuiltIns;

import mtscheme.Env;
import mtscheme.Expression.EvalContext;
import mtscheme.Expression.IExpression;
import mtscheme.Expression.ListExpr;
import mtscheme.Expression.Nil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cons implements IExpression {

  public EvalContext eval(Env env, IExpression... exprs) {
    if (exprs.length != 2)
      throw new IllegalArgumentException("cons");

    EvalContext res1 = exprs[0].eval(env);
    EvalContext res2 = exprs[1].eval(env);

    if (res2.expr.equals(new Nil()))
      return new EvalContext(env, new ListExpr(Arrays.asList(res1.expr)));
    else if (res2.expr instanceof ListExpr) {
      List<IExpression> list2 = ((ListExpr)res2.expr).exprs;
      ArrayList<IExpression> newList = new ArrayList<>(Arrays.asList(res1.expr));
      newList.addAll(list2);
      return new EvalContext(env, new ListExpr(newList));
    } else
      return new EvalContext(env, new ListExpr(Arrays.asList(res1.expr, res2.expr)));

  }
}
