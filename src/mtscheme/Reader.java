package mtscheme;

import mtscheme.Expression.IExpression;
import mtscheme.Parser.Parser;
import mtscheme.Parser.Tokenizer;

import java.util.List;

public class Reader {
  public static List<IExpression> readString(String str) {
    return Parser.parse(Tokenizer.tokenize(str));
  }
}
