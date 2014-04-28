package mtscheme.Expression.BuiltIns;

import mtscheme.Expression.TestHelpers;
import org.junit.Test;

import java.math.BigDecimal;

public class LetTest {

  @Test
  public void testLet() throws Exception {
    TestHelpers.testNumber("(let ((a 1)) a)", BigDecimal.ONE);
    TestHelpers.testNumber("(let ((a 1) (b (+ 1 1))) (+ a b))", BigDecimal.valueOf(3));
    TestHelpers.testNumber("(let ((a 1)) (let ((b 2)) (+ a b)))", BigDecimal.valueOf(3));
  }

  @Test
  public void testLetLambda() throws Exception {
    TestHelpers.testNumber("(let ((add (lambda (a b) (+ a b)))) (add 1 2))", BigDecimal.valueOf(3));
  }
}