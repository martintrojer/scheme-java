package mtscheme.Expression.BuiltIns;

import java.math.BigDecimal;

public class Sub extends AritFun {
  public Sub() {
    super(BigDecimal::subtract);
  }
}
