package mtscheme.Expression;

import mtscheme.Env;
import org.pcollections.ConsPStack;
import org.pcollections.PStack;

import java.util.List;

public class Comb implements IExpression {

  public PStack<IExpression> exprs;

  public Comb(List<IExpression> exprs) {
    this.exprs = ConsPStack.from(exprs);
  }

  @Override
  public boolean equals(Object object) {
    return object instanceof Comb && ((Comb)object).exprs.equals(exprs);
  }

  public EvalContext eval(Env env, IExpression... exprs) {
    if (this.exprs.isEmpty())
      throw new IllegalStateException("trying to evaluate an empty combination");
    IExpression head = this.exprs.get(0);
    List<IExpression> rest = this.exprs.minus(0);
    EvalContext headCtx = head.eval(env);
    return headCtx.expr.eval(env, rest.toArray(new IExpression[rest.size()]));
  }
}
