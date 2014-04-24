package mtscheme.Expression.BuiltIns;

import mtscheme.Expression.Helpers;
import org.junit.Test;

import java.math.BigDecimal;

public class CondTest {

  @Test
  public void testCond() throws Exception {
    Helpers.testNumber("(cond (true 1) ((= 1 2) 2))", BigDecimal.valueOf(1));
    Helpers.testNumber("(cond ((= 1 2) 1) (true 2))", BigDecimal.valueOf(2));
    Helpers.testNumber("(cond (false 1) (false 2) (else 3))", BigDecimal.valueOf(3));
    Helpers.testNull("(cond (false 1) (false 2))");
  }
}