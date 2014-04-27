package mtscheme.Expression;

import mtscheme.Env;

import java.util.Optional;

public class Symbol implements IExpression {
  public String name;

  public Symbol(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object object) {
    return object instanceof Symbol && ((Symbol)object).name.equals(name);
  }

  public EvalContext eval(Env env, IExpression... exprs) {
    Optional<IExpression> val = env.lookUp(name);
    if (val.isPresent())
      return new EvalContext(env, val.get());
    else
      throw new IllegalArgumentException("unbound symbol '" + name + "'");

  }
}
