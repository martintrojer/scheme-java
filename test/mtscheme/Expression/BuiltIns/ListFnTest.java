package mtscheme.Expression.BuiltIns;

import mtscheme.Expression.Helpers;
import mtscheme.Expression.ListExpr;
import mtscheme.Expression.Value.Name;
import mtscheme.Expression.Value.Num;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ListFnTest {

  @Test
  public void testList() throws Exception {
    Helpers.testList("(list 1 10)", Arrays.asList(new Num(BigDecimal.ONE), new Num(BigDecimal.TEN)));
    Helpers.testList("(list)", Arrays.asList());
    Helpers.testList("(list 1 \"kalle)\")", Arrays.asList(new Num(BigDecimal.ONE), new Name("kalle)")));
    Helpers.testList("(list 1 (list 10 10) 0", Arrays.asList(
            new Num(BigDecimal.ONE),
            new ListExpr(Arrays.asList(new Num(BigDecimal.TEN), new Num(BigDecimal.TEN))),
            new Num(BigDecimal.ZERO)));
  }
}