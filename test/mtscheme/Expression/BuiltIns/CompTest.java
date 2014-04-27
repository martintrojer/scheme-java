package mtscheme.Expression.BuiltIns;

import mtscheme.Expression.TestHelpers;
import org.junit.Test;

public class CompTest {

  @Test
  public void testEq() throws Exception {
    TestHelpers.testBool("(= 2 2)", 2 == 2);
    TestHelpers.testBool("(= 2 (+ 1 1))", 2 == (1 + 1));
    TestHelpers.testBool("(= 1)", true);
    TestHelpers.testBool("(= 1 1 2)", false);
    TestHelpers.testBool("(= 1 1 (+ 1 1) 1)", false);
  }

  @Test
  public void testGt() throws Exception {
    TestHelpers.testBool("(> 2 2)", 2 > 2);
    TestHelpers.testBool("(> 1 2)", 1 > 2);
    TestHelpers.testBool("(> 2 1)", 2 > 1);
    TestHelpers.testBool("(> (+ 1 1 1) 2)", (1 + 1 + 1) > 2);
    TestHelpers.testBool("(> 1)", true);
    TestHelpers.testBool("(> 1 1 (+ 1 1) 1)", false);
  }

  @Test
  public void testGe() throws Exception {
    TestHelpers.testBool("(>= 2 2)", 2 >= 2);
    TestHelpers.testBool("(>= 1 2)", 1 >= 2);
    TestHelpers.testBool("(>= 2 1)", 2 >= 1);
    TestHelpers.testBool("(>= (+ 1 1 1) 2)", (1 + 1 + 1) >= 2);
    TestHelpers.testBool("(>= 1)", true);
    TestHelpers.testBool("(>= 1 1 (+ 1 1) 1)", false);
  }

  @Test
  public void testLt() throws Exception {
    TestHelpers.testBool("(< 2 2)", 2 < 2);
    TestHelpers.testBool("(< 1 2)", 1 < 2);
    TestHelpers.testBool("(< 2 1)", 2 < 1);
    TestHelpers.testBool("(< (+ 1 1 1) 2)", (1 + 1 + 1) < 2);
    TestHelpers.testBool("(< 1)", true);
    TestHelpers.testBool("(< 1 1 (+ 1 1) 1)", false);
  }

  @Test
  public void testLe() throws Exception {
    TestHelpers.testBool("(<= 2 2)", 2 <= 2);
    TestHelpers.testBool("(<= 1 2)", 1 <= 2);
    TestHelpers.testBool("(<= 2 1)", 2 <= 1);
    TestHelpers.testBool("(<= (+ 1 1 1) 2)", (1 + 1 + 1) <= 2);
    TestHelpers.testBool("(<= 1)", true);
    TestHelpers.testBool("(<= 1 1 (+ 1 1) 1)", true);
  }

  @Test
  public void testNot() throws Exception {
    TestHelpers.testBool("(not (= 1 1))", false);
    TestHelpers.testBool("(not (not (= 1 1)))", true);
  }

}
