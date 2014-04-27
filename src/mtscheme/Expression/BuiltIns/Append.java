package mtscheme.Expression.BuiltIns;

import mtscheme.Env;
import mtscheme.Expression.EvalContext;
import mtscheme.Expression.IExpression;
import mtscheme.Expression.ListExpr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Append implements IExpression, IProc {
  public EvalContext eval(Env env, IExpression... exprs) {
    Iterator<IExpression> it = Arrays.asList(exprs).iterator();
    ArrayList<IExpression> resExprs = new ArrayList<>();

    while (it.hasNext()) {
      EvalContext res = it.next().eval(env);
      if (res.expr instanceof ListExpr)
        resExprs.addAll(((ListExpr)res.expr).exprs);
      else
        resExprs.add(res.expr);
    }
    return new EvalContext(env, new ListExpr(resExprs));
  }
}
