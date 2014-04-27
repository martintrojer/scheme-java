package mtscheme.Expression.Value;

import java.math.BigDecimal;

public class Num extends Value<BigDecimal> {

  public Num(BigDecimal val) { this.val = val;}

  public boolean gt(Num otherNum) {
    return val.compareTo(otherNum.val) == 1;
  }
  public boolean lt(Num otherNum) {
    return val.compareTo(otherNum.val) == -1;
  }
  public boolean ge(Num otherNum) {
    return equals(otherNum) || gt(otherNum);
  }
  public boolean le(Num otherNum) {
    return equals(otherNum) || lt(otherNum);
  }
}
