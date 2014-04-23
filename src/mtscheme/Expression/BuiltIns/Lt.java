package mtscheme.Expression.BuiltIns;

import mtscheme.Expression.Value.Num;

public class Lt extends CompFun {
  public Lt() {
    super((a,b) -> ((Num)a).lt((Num)b));
  }
}
