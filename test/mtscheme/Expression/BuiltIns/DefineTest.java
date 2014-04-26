package mtscheme.Expression.BuiltIns;

import mtscheme.Expression.Helpers;
import org.junit.Test;

import java.math.BigDecimal;

public class DefineTest {

  @Test
  public void testIf() throws Exception {
    Helpers.testEnv("(define lisa 4)", "lisa", BigDecimal.valueOf(4));
    Helpers.testEnv("(define nisse (+ 1 1 1))", "nisse", BigDecimal.valueOf(3));
  }
}