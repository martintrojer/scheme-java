package mtscheme.Expression.BuiltIns;

import mtscheme.Expression.ListExpr;
import mtscheme.Expression.TestHelpers;
import mtscheme.Expression.Value.Name;
import mtscheme.Expression.Value.Num;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

public class ConsTest {

  @Test
  public void testCons() throws Exception {
    TestHelpers.testList("(cons 1 2)", Arrays.asList(new Num(BigDecimal.ONE), new Num(BigDecimal.valueOf(2))));
    TestHelpers.testList("(cons 1 ())", Arrays.asList(new Num(BigDecimal.ONE)));
    TestHelpers.testList("(cons 1 (cons 2 3))", Arrays.asList(
            new Num(BigDecimal.ONE),
            new Num(BigDecimal.valueOf(2)),
            new Num(BigDecimal.valueOf(3))));
    TestHelpers.testList("(cons (cons 1 2) 3)", Arrays.asList(
            new ListExpr(Arrays.asList(new Num(BigDecimal.ONE), new Num(BigDecimal.valueOf(2)))),
            new Num(BigDecimal.valueOf(3))));
    TestHelpers.testList("(cons \"one\" 2)", Arrays.asList(new Name("one"), new Num(BigDecimal.valueOf(2))));
  }
}