package mtscheme.Expression.BuiltIns;

import mtscheme.Expression.TestHelpers;
import org.junit.Test;

import java.math.BigDecimal;

public class BeginTest {

  @Test
  public void testBegin() throws Exception {
    TestHelpers.testNumber("(begin 1 2)", BigDecimal.valueOf(2));
    TestHelpers.testNumber("(begin (define x 1) x)", BigDecimal.ONE);

  }
}