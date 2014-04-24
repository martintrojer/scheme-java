package mtscheme.Expression.BuiltIns;

import mtscheme.Expression.Helpers;
import org.junit.Test;

public class CompTest {

  @Test
  public void testEq() throws Exception {
    Helpers.testBool("(= 2 2)", 2 == 2);
    Helpers.testBool("(= 2 (+ 1 1))", 2 == (1 + 1));
    Helpers.testBool("(= 1)", true);
    Helpers.testBool("(= 1 1 2)", false);
    Helpers.testBool("(= 1 1 (+ 1 1) 1)", false);
  }

  @Test
  public void testGt() throws Exception {
    Helpers.testBool("(> 2 2)", 2 > 2);
    Helpers.testBool("(> 1 2)", 1 > 2);
    Helpers.testBool("(> 2 1)", 2 > 1);
    Helpers.testBool("(> (+ 1 1 1) 2)", (1 + 1 + 1) > 2);
    Helpers.testBool("(> 1)", true);
    Helpers.testBool("(> 1 1 (+ 1 1) 1)", false);
  }

  @Test
  public void testGe() throws Exception {
    Helpers.testBool("(>= 2 2)", 2 >= 2);
    Helpers.testBool("(>= 1 2)", 1 >= 2);
    Helpers.testBool("(>= 2 1)", 2 >= 1);
    Helpers.testBool("(>= (+ 1 1 1) 2)", (1 + 1 + 1) >= 2);
    Helpers.testBool("(>= 1)", true);
    Helpers.testBool("(>= 1 1 (+ 1 1) 1)", false);
  }

  @Test
  public void testLt() throws Exception {
    Helpers.testBool("(< 2 2)", 2 < 2);
    Helpers.testBool("(< 1 2)", 1 < 2);
    Helpers.testBool("(< 2 1)", 2 < 1);
    Helpers.testBool("(< (+ 1 1 1) 2)", (1 + 1 + 1) < 2);
    Helpers.testBool("(< 1)", true);
    Helpers.testBool("(< 1 1 (+ 1 1) 1)", false);
  }

  @Test
  public void testLe() throws Exception {
    Helpers.testBool("(<= 2 2)", 2 <= 2);
    Helpers.testBool("(<= 1 2)", 1 <= 2);
    Helpers.testBool("(<= 2 1)", 2 <= 1);
    Helpers.testBool("(<= (+ 1 1 1) 2)", (1 + 1 + 1) <= 2);
    Helpers.testBool("(<= 1)", true);
    Helpers.testBool("(<= 1 1 (+ 1 1) 1)", true);
  }

  @Test
  public void testNot() throws Exception {
    Helpers.testBool("(not (= 1 1))", false);
    Helpers.testBool("(not (not (= 1 1)))", true);
  }

}
