package mtscheme.Expression;

import mtscheme.Environment.Env;
import org.pcollections.ConsPStack;
import org.pcollections.PStack;

import java.util.List;

public class Comb implements IExpression {

  public PStack<IExpression> exprs;

  public Comb(List<IExpression> exprs) {
    this.exprs = ConsPStack.from(exprs);
  }

  public EvalContext eval(Env env, List<IExpression> exprs) {
    if (this.exprs.isEmpty())
      throw new IllegalStateException("trying to evaluate an empty combination");
    return this.exprs.get(0).eval(env, this.exprs.minus(0));
  }
}
