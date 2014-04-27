package mtscheme.Expression;

import mtscheme.Env;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Func implements IExpression {
  List<Symbol> args;
  List<IExpression> body;

  public Func(List<Symbol> args, List<IExpression> body) {
    this.args = args;
    this.body = body;
  }

  public EvalContext eval(Env env, IExpression... exprs) {
    if (args.size() != exprs.length)
      throw new IllegalArgumentException("wrong number of arguments");

    Env newEnv = env.expand();
    Iterator<Symbol> argsIt = args.iterator();
    Iterator<IExpression> paramsIt = Arrays.asList(exprs).iterator();
    while (argsIt.hasNext() && paramsIt.hasNext())
      newEnv = newEnv.addEntry(argsIt.next().name, paramsIt.next().eval(env).expr);

    return Helpers.evalAll(newEnv, body);
  }
}
