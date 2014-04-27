package mtscheme.Expression.BuiltIns;

import mtscheme.Env;
import mtscheme.Expression.EvalContext;
import mtscheme.Expression.Helpers;
import mtscheme.Expression.IExpression;

import java.util.Arrays;

public class Begin implements IExpression {
  public EvalContext eval(Env env, IExpression... exprs) {
    return Helpers.evalAll(env, Arrays.asList(exprs));
  }
}
