package mtscheme.Expression.BuiltIns;

import mtscheme.Expression.Value.Num;

public class Ge extends CompFun {
  public Ge() {
    super((a,b) -> ((Num)a).ge((Num)b));
  }
}
