package mtscheme.Expression.BuiltIns;

import mtscheme.Env;
import mtscheme.Expression.EvalContext;
import mtscheme.Expression.IExpression;
import mtscheme.Expression.ListExpr;

public class Car implements IExpression {
  public EvalContext eval(Env env, IExpression... exprs) {
    EvalContext res = exprs[0].eval(env);
    return new EvalContext(env, ((ListExpr)res.expr).exprs.get(0));
  }
}
