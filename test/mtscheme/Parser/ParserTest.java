package mtscheme.Parser;

import mtscheme.Expression.Comb;
import mtscheme.Expression.Symbol;
import mtscheme.Expression.Value.Num;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

public class ParserTest {
  @Test
  public void testParse() throws Exception {
    Assert.assertEquals(Parser.parse(Arrays.asList()), Arrays.asList());
    Assert.assertEquals(Parser.parse(Arrays.asList(new TOpen(), new TClose())),
            Arrays.asList(new Comb(Arrays.asList())));
    Assert.assertEquals(Parser.parse(Arrays.asList(new TNumber("1"), new TNumber("2"))),
            Arrays.asList(new Num(BigDecimal.valueOf(1)), new Num(BigDecimal.valueOf(2))));
    Assert.assertEquals(Parser.parse(Tokenizer.tokenize("(+ 1 2)")),
            Arrays.asList(
                    new Comb(Arrays.asList(
                            new Symbol("+"),
                            new Num(BigDecimal.valueOf(1)),
                            new Num(BigDecimal.valueOf(2))))));
    Assert.assertEquals(Parser.parse(Tokenizer.tokenize("(+ (- 2 1) 2)")),
            Arrays.asList(
                    new Comb(Arrays.asList(
                            new Symbol("+"),
                            new Comb(Arrays.asList(
                                    new Symbol("-"),
                                    new Num(BigDecimal.valueOf(2)),
                                    new Num(BigDecimal.valueOf(1)))),
                            new Num(BigDecimal.valueOf(2))))));
  }
}
