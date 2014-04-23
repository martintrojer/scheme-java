package mtscheme.Expression;

import mtscheme.Env;

import java.util.List;

public interface IExpression {
  // the exprs only needed for 'procs' like Add/Sub etc..
  public EvalContext eval(Env env, List<IExpression> exprs);
}
