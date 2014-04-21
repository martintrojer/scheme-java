package mtscheme.Expression;

import mtscheme.Environment.Env;

import java.util.List;

public class Null implements IExpression {

  public boolean equals(Object object) {
    return object instanceof Null;
  }

  public EvalContext eval (Env env, List<IExpression> exprs) {
    throw new IllegalStateException("trying to eval Null");
  }
}
