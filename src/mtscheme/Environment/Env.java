package mtscheme.Environment;

import mtscheme.Expression.IExpression;
import org.pcollections.*;

import java.util.Optional;

public class Env {

  private PStack<PMap<String, IExpression>> env = ConsPStack.empty();

  private static PMap<String, IExpression> emptyEnvMap() {
    return HashTreePMap.empty();
  }

  public Env() {
    this.env = this.env.plus(emptyEnvMap());
  }
  public Env(PStack<PMap<String, IExpression>> env) {
    this.env = env;
  }

  public Env expand() {
    return new Env(this.env.plus(emptyEnvMap()));
  }

  public Env addEntry(String key, IExpression value) {
    PStack<PMap<String, IExpression>> newEnv = this.env.minus(0);
    PMap<String, IExpression> firstEnv = this.env.get(0);
    return new Env(newEnv.plus(firstEnv.plus(key, value)));
  }

  public Optional<IExpression> lookUp(String key) {
    PStack<PMap<String, IExpression>> env = this.env;
    while (!env.isEmpty()) {
      IExpression val = env.get(0).get(key);
      if (val != null)
        return Optional.of(val);
      env = env.minus(0);
    }
    return Optional.empty();
  }
}
