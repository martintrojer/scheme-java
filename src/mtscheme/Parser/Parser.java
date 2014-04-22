package mtscheme.Parser;

import mtscheme.Expression.Comb;
import mtscheme.Expression.IExpression;
import org.pcollections.ConsPStack;
import org.pcollections.PStack;
import org.pcollections.PVector;
import org.pcollections.TreePVector;

import java.util.List;

public class Parser {

  public static List<IExpression> parse(List<Token> tokens) {
    return doParse(TreePVector.empty(), ConsPStack.from(tokens)).exprs;
  }

  static class ParseContext {
    PVector<IExpression> exprs;
    PStack<Token> toks;

    public ParseContext(PVector<IExpression> exprs, PStack<Token> toks) {
      this.toks = toks;
      this.exprs = exprs;
    }
  }

  private static ParseContext doParse(PVector<IExpression> acc, PStack<Token> toks) {
    Token first = toks.get(0);
    PStack<Token> rest = toks.minus(0);
    if (toks.isEmpty())
      return new ParseContext(acc, ConsPStack.empty());
    else if (first instanceof TOpen) {
      ParseContext res = doParse(TreePVector.empty(), rest);
      return doParse(acc.plus(new Comb(res.exprs)), res.toks);
    }
    else if (first instanceof TClose)
      return new ParseContext(acc, rest);
    else
      return doParse(acc.plus(first.toExpression()), rest);
  }
}
