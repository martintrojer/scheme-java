package mtscheme.Expression.BuiltIns;

import mtscheme.Expression.TestHelpers;
import org.junit.Test;

import java.math.BigDecimal;

public class AritTest {

  @Test
  public void testAdd() throws Exception {
    TestHelpers.testNumber("(+ 1 2)", BigDecimal.valueOf(1 + 2));
    TestHelpers.testNumber("(+ 1 (+ 2 3))", BigDecimal.valueOf(1 + 2 + 3));
    TestHelpers.testNumber("(+ 1)", BigDecimal.valueOf(1));
    TestHelpers.testNumber("(+ 1 1 1 0.14)", BigDecimal.valueOf(1 + 1 + 1 + 0.14));
  }

  @Test
  public void testSub() throws Exception {
    TestHelpers.testNumber("(- 1 2)", BigDecimal.valueOf(1 - 2));
    TestHelpers.testNumber("(- 1 (- 2 3))", BigDecimal.valueOf(1 - (2 - 3)));
//    Helpers.testNumber("(- 1)", BigDecimal.valueOf(-1));
    TestHelpers.testNumber("(- 1 1 1)", BigDecimal.valueOf(1 - 1 - 1));
  }

  @Test
  public void testMul() throws Exception {
    TestHelpers.testNumber("(* 2 3.14)", BigDecimal.valueOf(2 * 3.14));
    TestHelpers.testNumber("(+ 1 (* 2 3))", BigDecimal.valueOf(1 + 2 * 3));
    TestHelpers.testNumber("(* 1)", BigDecimal.valueOf(1));
    TestHelpers.testNumber("(* 2 1 2 2)", BigDecimal.valueOf(2 * 1 * 2 * 2));
  }

  @Test
  public void testDiv() throws Exception {
    TestHelpers.testNumber("(/ 9 3)", BigDecimal.valueOf(9 / 3));
    TestHelpers.testNumber("(+ 1 (/ 1 5))", BigDecimal.valueOf(1 + 1 / 5));
    TestHelpers.testNumber("(/ 1)", BigDecimal.valueOf(1));
//    Helpers.testNumber("(/ 2)", BigDecimal.valueOf(1/2));
    TestHelpers.testNumber("(/ 1 2 4)", BigDecimal.valueOf(1 / 2 / 4));
  }
}
