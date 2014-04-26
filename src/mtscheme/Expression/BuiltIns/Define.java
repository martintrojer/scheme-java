package mtscheme.Expression.BuiltIns;

import mtscheme.Env;
import mtscheme.Expression.EvalContext;
import mtscheme.Expression.IExpression;
import mtscheme.Expression.Nil;
import mtscheme.Expression.Symbol;
import org.pcollections.ConsPStack;
import org.pcollections.PStack;

import java.util.Arrays;
import java.util.List;

public class Define implements IExpression, IProc {
  public EvalContext eval(Env env, IExpression... exprs) {
    PStack<IExpression> expr = ConsPStack.from(Arrays.asList(exprs));
    IExpression name = expr.get(0);
    List<IExpression> body = expr.minus(0);
    if (name instanceof Symbol) {
      EvalContext res = body.get(0).eval(env);
      return new EvalContext(env.addEntry(((Symbol)name).name, res.expr), new Nil());
    }
    // TODO -- function definition
    throw new IllegalArgumentException("define");
  }
}
