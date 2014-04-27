package mtscheme.Expression.BuiltIns;

import mtscheme.Expression.TestHelpers;
import org.junit.Test;

import java.math.BigDecimal;

public class CondTest {

  @Test
  public void testCond() throws Exception {
    TestHelpers.testNumber("(cond (true 1) ((= 1 2) 2))", BigDecimal.valueOf(1));
    TestHelpers.testNumber("(cond ((= 1 2) 1) (true 2))", BigDecimal.valueOf(2));
    TestHelpers.testNumber("(cond (false 1) (false 2) (else 3))", BigDecimal.valueOf(3));
    TestHelpers.testNull("(cond (false 1) (false 2))");
  }
}