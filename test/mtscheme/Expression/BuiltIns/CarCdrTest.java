package mtscheme.Expression.BuiltIns;

import mtscheme.Expression.ListExpr;
import mtscheme.Expression.TestHelpers;
import mtscheme.Expression.Value.Num;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

public class CarCdrTest {

  @Test
  public void testCar() throws Exception {
    TestHelpers.testNumber("(car (list 1 2))", BigDecimal.ONE);
    TestHelpers.testList("(car (list (list 1) 2))", Arrays.asList(new Num(BigDecimal.ONE)));
  }

  @Test
  public void testCdr() throws Exception {
    TestHelpers.testList("(cdr (list 1))", Arrays.asList());
    TestHelpers.testList("(cdr (list 1 2))", Arrays.asList(new Num(BigDecimal.valueOf(2))));
    TestHelpers.testList("(cdr (list 1 (list 2 3)))", Arrays.asList(new ListExpr(Arrays.asList(
            new Num(BigDecimal.valueOf(2)), new Num(BigDecimal.valueOf(3))))));
    TestHelpers.testList("(cdr (list (list 1)))", Arrays.asList());
  }
}