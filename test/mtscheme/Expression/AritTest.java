package mtscheme.Expression;

import mtscheme.Env;
import mtscheme.Expression.Value.Num;
import mtscheme.GlobalEnv;
import mtscheme.Parser.Parser;
import mtscheme.Parser.Tokenizer;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class AritTest {
  List<IExpression> noExprs = Arrays.asList();
  Env testEnv = GlobalEnv.globalEnv();

  private void testNumber(String expr, BigDecimal expect) {
    EvalContext res =
            Parser.parse(Tokenizer.tokenize(expr))
                    .get(0).eval(testEnv, noExprs);
    Assert.assertEquals(expect, ((Num) res.expr).val);
  }

  @Test
  public void testAdd() throws Exception {
    testNumber("(+ 1 2)", BigDecimal.valueOf(1+2));
    testNumber("(+ 1 (+ 2 3))", BigDecimal.valueOf(1+2+3));
    testNumber("(+ 1)", BigDecimal.valueOf(1));
    testNumber("(+ 1 1 1 0.14)", BigDecimal.valueOf(1+1+1+0.14));
  }

  @Test
  public void testSub() throws Exception {
    testNumber("(- 1 2)", BigDecimal.valueOf(1-2));
    testNumber("(- 1 (- 2 3))", BigDecimal.valueOf(1-(2-3)));
//    testNumber("(- 1)", BigDecimal.valueOf(-1));
    testNumber("(- 1 1 1)", BigDecimal.valueOf(1-1-1));
  }

  @Test
  public void testMul() throws Exception {
    testNumber("(* 2 3.14)", BigDecimal.valueOf(2*3.14));
    testNumber("(+ 1 (* 2 3))", BigDecimal.valueOf(1+2*3));
    testNumber("(* 1)", BigDecimal.valueOf(1));
    testNumber("(* 2 1 2 2)", BigDecimal.valueOf(2*1*2*2));
  }

  @Test
  public void testDiv() throws Exception {
    testNumber("(/ 9 3)", BigDecimal.valueOf(9/3));
    testNumber("(+ 1 (/ 1 5))", BigDecimal.valueOf(1+1/5));
    testNumber("(/ 1)", BigDecimal.valueOf(1));
//    testNumber("(/ 2)", BigDecimal.valueOf(1/2));
    testNumber("(/ 1 2 4)", BigDecimal.valueOf(1/2/4));
  }
}
