package mtscheme.Expression;

import mtscheme.Env;
import org.pcollections.ConsPStack;
import org.pcollections.PStack;

import java.util.List;
import java.util.stream.Collectors;

public class Helpers {

  public static EvalContext evalAll(Env env, List<IExpression> exprs) {
    switch (exprs.size()) {
      case 0:
        return new EvalContext(env, new Nil());
      case 1:
        return exprs.get(0).eval(env);
      default:
        PStack<IExpression> exprSt = ConsPStack.from(exprs);
        EvalContext res = exprSt.get(0).eval(env);
        return evalAll(res.env, exprSt.minus(0));
    }
  }

  public static PStack<Symbol> getSymbols(Comb comb) {
    return ConsPStack.from(
            comb.exprs.stream()
                    .map(e -> (Symbol) e)
                    .collect(Collectors.toList()));
  }
}
