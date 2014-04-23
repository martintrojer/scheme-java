package mtscheme.Expression.BuiltIns;

public class Eq extends CompFun {
  public Eq() {
    super((a,b) -> a.equals(b));
  }
}
