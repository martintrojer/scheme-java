package mtscheme.Expression.BuiltIns;

import mtscheme.Expression.Value.Num;

public class Gt extends CompFun {
  public Gt() {
    super((a,b) -> ((Num)a).gt((Num)b));
  }
}
