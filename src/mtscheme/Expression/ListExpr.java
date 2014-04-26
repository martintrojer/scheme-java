package mtscheme.Expression;

import mtscheme.Env;

import java.util.List;

public class ListExpr implements IExpression {
  public List<IExpression> exprs;

  public boolean equals(Object object) {
    return object instanceof ListExpr && ((ListExpr)object).exprs.equals(exprs);
  }

  public ListExpr(List<IExpression> exprs) {
    this.exprs = exprs;
  }

  public EvalContext eval(Env env, IExpression... exprs) {
    throw new IllegalStateException("eval list");
  }
}
