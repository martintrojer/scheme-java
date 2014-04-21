package mtscheme.Expression.BuiltIns;

import java.math.BigDecimal;

public class Add extends AritFun {
  public Add() {
    super(BigDecimal.ZERO, BigDecimal::add);
  }
}
