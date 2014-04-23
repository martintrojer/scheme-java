package mtscheme.Expression.BuiltIns;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Div extends AritFun {
  public Div() {
    super((a,b) -> a.divide(b, RoundingMode.HALF_UP));
  }
}
