package mtscheme.Expression;

import mtscheme.Env;

import java.util.List;

public class ListExpr implements IExpression {
  public List<IExpression> exprs;

  public ListExpr(List<IExpression> exprs) {
    this.exprs = exprs;
  }

  @Override
  public boolean equals(Object object) {
    return object instanceof ListExpr && ((ListExpr)object).exprs.equals(exprs);
  }

  @Override
  public String toString() {
    String parts = exprs.stream().map(e -> e.toString()).reduce("", ((acc, s) -> acc + "," + s));
    return "(" + parts + ")";
  }

  public EvalContext eval(Env env, IExpression... exprs) {
    throw new IllegalStateException("eval list");
  }
}
