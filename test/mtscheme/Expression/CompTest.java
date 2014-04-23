package mtscheme.Expression;

import mtscheme.Env;
import mtscheme.Expression.Value.Bool;
import mtscheme.GlobalEnv;
import mtscheme.Parser.Parser;
import mtscheme.Parser.Tokenizer;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CompTest {
  List<IExpression> noExprs = Arrays.asList();
  Env testEnv = GlobalEnv.globalEnv();

  private void testBool(String expr, boolean expect) {
    EvalContext res =
            Parser.parse(Tokenizer.tokenize(expr))
                    .get(0).eval(testEnv, noExprs);
    Assert.assertEquals(expect, ((Bool) res.expr).val);
  }

  @Test
  public void testEq() throws Exception {
    testBool("(= 2 2)", 2 == 2);
    testBool("(= 2 (+ 1 1))", 2 == (1+1));
    testBool("(= 1)", true);
    testBool("(= 1 1 2)", false);
    testBool("(= 1 1 (+ 1 1) 1)", false);
  }

  @Test
  public void testGt() throws Exception {
    testBool("(> 2 2)", 2>2);
    testBool("(> 1 2)", 1>2);
    testBool("(> 2 1)", 2>1);
    testBool("(> (+ 1 1 1) 2)", (1+1+1)>2);
    testBool("(> 1)", true);
    testBool("(> 1 1 (+ 1 1) 1)", false);
  }

  @Test
  public void testGe() throws Exception {
    testBool("(>= 2 2)", 2>=2);
    testBool("(>= 1 2)", 1>=2);
    testBool("(>= 2 1)", 2>=1);
    testBool("(>= (+ 1 1 1) 2)", (1+1+1)>=2);
    testBool("(>= 1)", true);
    testBool("(>= 1 1 (+ 1 1) 1)", false);
  }

  @Test
  public void testLt() throws Exception {
    testBool("(< 2 2)", 2<2);
    testBool("(< 1 2)", 1<2);
    testBool("(< 2 1)", 2<1);
    testBool("(< (+ 1 1 1) 2)", (1+1+1)<2);
    testBool("(< 1)", true);
    testBool("(< 1 1 (+ 1 1) 1)", false);
  }

  @Test
  public void testLe() throws Exception {
    testBool("(<= 2 2)", 2<=2);
    testBool("(<= 1 2)", 1<=2);
    testBool("(<= 2 1)", 2<=1);
    testBool("(<= (+ 1 1 1) 2)", (1+1+1)<=2);
    testBool("(<= 1)", true);
    testBool("(<= 1 1 (+ 1 1) 1)", true);
  }

  @Test
  public void testNot() throws Exception {
    testBool("(not (= 1 1))", false);
    testBool("(not (not (= 1 1)))", true);
  }

}
