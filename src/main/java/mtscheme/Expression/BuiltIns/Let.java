package mtscheme.Expression.BuiltIns;

import mtscheme.Env;
import mtscheme.Expression.Comb;
import mtscheme.Expression.EvalContext;
import mtscheme.Expression.IExpression;
import mtscheme.Expression.Symbol;

import java.util.Iterator;

public class Let implements IExpression {
  public EvalContext eval(Env env, IExpression... exprs) {
    Comb binds = (Comb) exprs[0];
    IExpression body = exprs[1];
    Env newEnv = env.expand();
    Iterator<IExpression> it = binds.exprs.iterator();
    while (it.hasNext()) {
      Comb bind = (Comb) it.next();
      if (bind.exprs.size() != 2)
        throw new IllegalArgumentException("let");
      Symbol sym = (Symbol) bind.exprs.get(0);
      newEnv = newEnv.addEntry(sym.name, bind.exprs.get(1).eval(env).expr);
    }
    return body.eval(newEnv);
  }
}
