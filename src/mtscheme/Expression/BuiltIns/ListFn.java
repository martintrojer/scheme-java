package mtscheme.Expression.BuiltIns;

import mtscheme.Env;
import mtscheme.Expression.EvalContext;
import mtscheme.Expression.IExpression;
import mtscheme.Expression.ListExpr;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListFn implements IExpression, IProc {

  public EvalContext eval(Env env, IExpression... exprs) {
    List<IExpression> contents =
            Arrays.asList(exprs).stream()
            .map(e -> e.eval(env))
            .map(ctx -> ctx.expr)
            .collect(Collectors.toList());
    return new EvalContext(env, new ListExpr(contents));
  }
}
