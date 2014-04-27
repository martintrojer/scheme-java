package mtscheme.Expression.BuiltIns;

import mtscheme.Expression.ListExpr;
import mtscheme.Expression.TestHelpers;
import mtscheme.Expression.Value.Name;
import mtscheme.Expression.Value.Num;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

public class ListAppendTest {

  @Test
  public void testList() throws Exception {
    TestHelpers.testList("(list 1 10)", Arrays.asList(new Num(BigDecimal.ONE), new Num(BigDecimal.TEN)));
    TestHelpers.testList("(list)", Arrays.asList());
    TestHelpers.testList("(list 1 \"kalle)\")", Arrays.asList(new Num(BigDecimal.ONE), new Name("kalle)")));
    TestHelpers.testList("(list 1 (list 10 10) 0", Arrays.asList(
            new Num(BigDecimal.ONE),
            new ListExpr(Arrays.asList(new Num(BigDecimal.TEN), new Num(BigDecimal.TEN))),
            new Num(BigDecimal.ZERO)));
  }

  @Test
  public void testAppend() throws Exception {
    TestHelpers.testList("(append (list 1 10))", Arrays.asList(new Num(BigDecimal.ONE), new Num(BigDecimal.TEN)));
    TestHelpers.testList("(append (list 1 2) (list 3 4))", Arrays.asList(
            new Num(BigDecimal.ONE), new Num(BigDecimal.valueOf(2)),
            new Num(BigDecimal.valueOf(3)), new Num(BigDecimal.valueOf(4))));
    TestHelpers.testList("(append (list 1 (list 2)) 3)", Arrays.asList(
            new Num(BigDecimal.ONE), new ListExpr(Arrays.asList(new Num(BigDecimal.valueOf(2)))),
            new Num(BigDecimal.valueOf(3))));
  }

  @Test
  public void testNull() throws Exception {
    TestHelpers.testBool("(null? (list 1))", false);
    TestHelpers.testBool("(null? (cdr (list 1)))", true);
    TestHelpers.testBool("(null? (cdr (cdr (list 1))))", true);
    TestHelpers.testBool("(null? (list))", true);
  }
}