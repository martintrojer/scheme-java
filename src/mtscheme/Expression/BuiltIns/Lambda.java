package mtscheme.Expression.BuiltIns;

import mtscheme.Env;
import mtscheme.Expression.*;
import org.pcollections.ConsPStack;
import org.pcollections.PStack;

import java.util.Arrays;

public class Lambda implements IExpression {
  public EvalContext eval(Env env, IExpression... exprs) {
    PStack<IExpression> exprSt = ConsPStack.from(Arrays.asList(exprs));
    Comb args = (Comb)exprSt.get(0);
    return new EvalContext(env, new Func(Helpers.getSymbols(args), exprSt.minus(0)));
  }
}
