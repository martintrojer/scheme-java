package mtscheme.Expression;

import mtscheme.Environment.Env;

import java.util.List;
import java.util.Optional;

public class Symbol implements IExpression {
  public String name;

  public Symbol(String name) {
    this.name = name;
  }

  public EvalContext eval(Env env, List<IExpression> exprs) {
    Optional<IExpression> val = env.lookUp(name);
    if (val.isPresent())
      return new EvalContext(env, val.get());
    else
      throw new IllegalArgumentException("unbound symbol '" + name + "'");

  }
}
