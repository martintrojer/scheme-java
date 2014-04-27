package mtscheme.Expression.BuiltIns;

import mtscheme.Expression.Helpers;
import mtscheme.Expression.ListExpr;
import mtscheme.Expression.Value.Num;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.Assert.*;

public class CarCdrTest {

  @Test
  public void testCar() throws Exception {
    Helpers.testNumber("(car (list 1 2))", BigDecimal.ONE);
    Helpers.testList("(car (list (list 1) 2))", Arrays.asList(new Num(BigDecimal.ONE)));
  }

  @Test
  public void testCdr() throws Exception {
    Helpers.testList("(cdr (list 1))", Arrays.asList());
    Helpers.testList("(cdr (list 1 2))", Arrays.asList(new Num(BigDecimal.valueOf(2))));
    Helpers.testList("(cdr (list 1 (list 2 3)))", Arrays.asList(new ListExpr(Arrays.asList(
            new Num(BigDecimal.valueOf(2)), new Num(BigDecimal.valueOf(3))))));
    Helpers.testList("(cdr (list (list 1)))", Arrays.asList());
  }
}