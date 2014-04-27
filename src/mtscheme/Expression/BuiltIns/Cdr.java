package mtscheme.Expression.BuiltIns;

import mtscheme.Env;
import mtscheme.Expression.EvalContext;
import mtscheme.Expression.IExpression;
import mtscheme.Expression.ListExpr;

import java.util.List;

public class Cdr implements IExpression, IProc {
  public EvalContext eval(Env env, IExpression... exprs) {
    EvalContext res = exprs[0].eval(env);
    List<IExpression> resList = ((ListExpr)res.expr).exprs;
    resList.remove(0);
    return new EvalContext(env, new ListExpr(resList));
  }
}
