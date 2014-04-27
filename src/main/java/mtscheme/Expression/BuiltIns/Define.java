package mtscheme.Expression.BuiltIns;

import mtscheme.Env;
import mtscheme.Expression.*;
import org.pcollections.ConsPStack;
import org.pcollections.PStack;

import java.util.Arrays;
import java.util.List;

public class Define implements IExpression {
  public EvalContext eval(Env env, IExpression... exprs) {
    PStack<IExpression> expr = ConsPStack.from(Arrays.asList(exprs));
    IExpression comb = expr.get(0);
    List<IExpression> body = expr.minus(0);

    // Define 'values' and lambdas
    if (comb instanceof Symbol) {
      EvalContext res = body.get(0).eval(env);
      return new EvalContext(res.env.addEntry(((Symbol)comb).name, res.expr), new Nil());
    }
    // Define functions
    else if (comb instanceof Comb) {
      PStack<Symbol> syms = Helpers.getSymbols((Comb) comb);
      return new EvalContext(env.addEntry(syms.get(0).name, new Func(syms.minus(0), body)), new Nil());
    }

    throw new IllegalArgumentException("define");
  }
}
