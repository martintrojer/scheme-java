package mtscheme.Expression.BuiltIns;

import mtscheme.Expression.TestHelpers;
import org.junit.Test;

import java.math.BigDecimal;

public class IfTest {

  @Test
  public void testIf() throws Exception {
    TestHelpers.testNumber("(if (< 2 1) 10 11", BigDecimal.valueOf(11));
    TestHelpers.testNumber("(if (< (+ 1 1) 1) 11 (* 2 5))", BigDecimal.valueOf(10));
    TestHelpers.testNumber("(if true 1", BigDecimal.valueOf(1));
    TestHelpers.testNull("(if false 1");
  }
}