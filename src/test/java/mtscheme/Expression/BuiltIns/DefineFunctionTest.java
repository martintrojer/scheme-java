package mtscheme.Expression.BuiltIns;

import mtscheme.Env;
import mtscheme.Expression.TestHelpers;
import mtscheme.Expression.Value.Num;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

public class DefineFunctionTest {

  @Test
  public void testDefine() throws Exception {
    TestHelpers.testEnv("(define lisa 4)", "lisa", BigDecimal.valueOf(4));
    TestHelpers.testEnv("(define nisse (+ 1 1 1))", "nisse", BigDecimal.valueOf(3));
  }

  @Test
  public void testFunction() throws Exception {
    Env env1 = TestHelpers.getEnv("(define (add a b) (+ a b))");
    TestHelpers.testNumber("(add 1 2)", BigDecimal.valueOf(3), env1);

    Env env2 = TestHelpers.getEnv("(define (fact x) (if (= x 0) 1 (* x (fact (- x 1)))))");
    TestHelpers.testNumber("(fact (+ 5 5))", BigDecimal.valueOf(3628800), env2);

    Env env3 = TestHelpers.getEnv("(define (add a b) (begin (define (worker x y) (+ x y)) (worker a b)))");
    TestHelpers.testNumber("(add 1 2)", BigDecimal.valueOf(3), env3);
  }

  @Test
  public void lambdaTest() {
    Env env1 = TestHelpers.getEnv("(define (adder val) (lambda (x) (+ x val)))");
    Env env2 = TestHelpers.getEnv("(define add4 (adder 4))", env1);
    TestHelpers.testNumber("(add4 4)", BigDecimal.valueOf(8), env2);

    Env env3 = TestHelpers.getEnv("(define (map f l) (if (not (null? l)) (cons (f (car l)) (map f (cdr l)))))");
    TestHelpers.testList("(map (lambda (x) (* x x)) (list 1 2 3))",
            Arrays.asList(new Num(BigDecimal.ONE), new Num(BigDecimal.valueOf(4)), new Num(BigDecimal.valueOf(9))),
            env3);
  }
}