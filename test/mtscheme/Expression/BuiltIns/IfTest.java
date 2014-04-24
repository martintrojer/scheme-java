package mtscheme.Expression.BuiltIns;

import mtscheme.Expression.Helpers;
import org.junit.Test;

import java.math.BigDecimal;

public class IfTest {

  @Test
  public void testEval() throws Exception {
    Helpers.testNumber("(if (< 2 1) 10 11", BigDecimal.valueOf(11));
    Helpers.testNumber("(if (< (+ 1 1) 1) 11 (* 2 5))", BigDecimal.valueOf(10));
    Helpers.testNumber("(if true 1", BigDecimal.valueOf(1));
    Helpers.testNull("(if false 1");
  }
}