package mtscheme.Expression.BuiltIns;

import java.math.BigDecimal;

public class Mul extends AritFun {
  public Mul() {
    super(BigDecimal::multiply);
  }
}
