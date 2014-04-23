package mtscheme.Expression.BuiltIns;

import mtscheme.Expression.Value.Num;

public class Le extends CompFun {
  public Le() {
    super((a,b) -> ((Num)a).le((Num) b));
  }
}
