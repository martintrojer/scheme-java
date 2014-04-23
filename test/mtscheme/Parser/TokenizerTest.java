package mtscheme.Parser;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TokenizerTest {
  @Test
  public void testTokenize() throws Exception {
    Assert.assertEquals(Tokenizer.tokenize(""), Arrays.asList());
    Assert.assertEquals(Tokenizer.tokenize("()"), Arrays.asList(new TOpen(), new TClose()));
    Assert.assertEquals(Tokenizer.tokenize("\"kalle\""), Arrays.asList(new TString("kalle")));
    Assert.assertEquals(Tokenizer.tokenize("\"kalle\" \"olle\""),
            Arrays.asList(new TString("kalle"), new TString("olle")));
    Assert.assertEquals(Tokenizer.tokenize("42"), Arrays.asList(new TNumber("42")));
    Assert.assertEquals(Tokenizer.tokenize("+42"), Arrays.asList(new TNumber("42")));
    Assert.assertEquals(Tokenizer.tokenize("-42"), Arrays.asList(new TNumber("42")));
    Assert.assertEquals(Tokenizer.tokenize("3.14"), Arrays.asList(new TNumber("3.14")));
    Assert.assertEquals(Tokenizer.tokenize("kalle"), Arrays.asList(new TSymbol("kalle")));

    Assert.assertEquals(Tokenizer.tokenize("(+ 1 2)"),
            Arrays.asList(new TOpen(), new TSymbol("+"), new TNumber("1"), new TNumber("2"), new TClose()));

  }
}
