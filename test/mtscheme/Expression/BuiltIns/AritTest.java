package mtscheme.Expression.BuiltIns;

import mtscheme.Expression.Helpers;
import org.junit.Test;

import java.math.BigDecimal;

public class AritTest {

  @Test
  public void testAdd() throws Exception {
    Helpers.testNumber("(+ 1 2)", BigDecimal.valueOf(1 + 2));
    Helpers.testNumber("(+ 1 (+ 2 3))", BigDecimal.valueOf(1 + 2 + 3));
    Helpers.testNumber("(+ 1)", BigDecimal.valueOf(1));
    Helpers.testNumber("(+ 1 1 1 0.14)", BigDecimal.valueOf(1 + 1 + 1 + 0.14));
  }

  @Test
  public void testSub() throws Exception {
    Helpers.testNumber("(- 1 2)", BigDecimal.valueOf(1 - 2));
    Helpers.testNumber("(- 1 (- 2 3))", BigDecimal.valueOf(1 - (2 - 3)));
//    Helpers.testNumber("(- 1)", BigDecimal.valueOf(-1));
    Helpers.testNumber("(- 1 1 1)", BigDecimal.valueOf(1 - 1 - 1));
  }

  @Test
  public void testMul() throws Exception {
    Helpers.testNumber("(* 2 3.14)", BigDecimal.valueOf(2 * 3.14));
    Helpers.testNumber("(+ 1 (* 2 3))", BigDecimal.valueOf(1 + 2 * 3));
    Helpers.testNumber("(* 1)", BigDecimal.valueOf(1));
    Helpers.testNumber("(* 2 1 2 2)", BigDecimal.valueOf(2 * 1 * 2 * 2));
  }

  @Test
  public void testDiv() throws Exception {
    Helpers.testNumber("(/ 9 3)", BigDecimal.valueOf(9 / 3));
    Helpers.testNumber("(+ 1 (/ 1 5))", BigDecimal.valueOf(1 + 1 / 5));
    Helpers.testNumber("(/ 1)", BigDecimal.valueOf(1));
//    Helpers.testNumber("(/ 2)", BigDecimal.valueOf(1/2));
    Helpers.testNumber("(/ 1 2 4)", BigDecimal.valueOf(1 / 2 / 4));
  }
}
