package mtscheme.Expression.BuiltIns;

import mtscheme.Env;
import mtscheme.Expression.EvalContext;
import mtscheme.Expression.IExpression;
import mtscheme.Expression.ListExpr;
import mtscheme.Expression.Value.Bool;

import java.util.Arrays;

public class Null implements IExpression {
  public EvalContext eval(Env env, IExpression... exprs) {
    EvalContext res = exprs[0].eval(env);
    if (res.expr.equals(new ListExpr(Arrays.asList())))
      return new EvalContext(env, new Bool(true));
    else
      return new EvalContext(env, new Bool(false));
  }
}
