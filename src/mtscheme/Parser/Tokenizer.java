package mtscheme.Parser;

import mtscheme.Expression.IExpression;
import mtscheme.Expression.Symbol;
import mtscheme.Expression.Value.Bool;
import mtscheme.Expression.Value.Name;
import mtscheme.Expression.Value.Num;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Token {
  public IExpression toExpression() {
    throw new IllegalArgumentException("syntax error");
  }
}
class TOpen extends Token {
  public boolean equals(Object object) {
    return object instanceof TOpen;
  }
}
class TClose extends Token {
  public boolean equals(Object object) {
    return object instanceof TClose;
  }
}
class TNumber extends Token {
  public boolean equals(Object object) {
    return object instanceof TNumber && ((TNumber)object).val.equals(val);
  }
  public java.lang.String val;
  public TNumber(java.lang.String val) {
    this.val = val;
  }
  public IExpression toExpression() {
    return new Num(new BigDecimal(val));
  }
}
class TString extends Token {
  public boolean equals(Object object) {
    return object instanceof TString && ((TString)object).val.equals(val);
  }
  public java.lang.String val;
  public TString(java.lang.String val) {
    this.val = val;
  }
  public IExpression toExpression() {
    return new Name(val);
  }
}
class TSymbol extends Token {
  public boolean equals(Object object) {
    return object instanceof TSymbol && ((TSymbol) object).val.equals(val);
  }
  public java.lang.String val;
  public TSymbol(java.lang.String val) {
    this.val = val;
  }
  public IExpression toExpression() {
    if (val.equals("true"))
      return new Bool(true);
    else if (val.equals("false"))
      return new Bool(false);
    else
      return new Symbol(val);
  }
}

public class Tokenizer {

  static Pattern stringPat = Pattern.compile("^\"(\\S*)\".*");
  static Pattern digitPat = Pattern.compile("^([+-]*)([\\d\\.]*).*");
  static Pattern symPat = Pattern.compile("^([\\S&&[^)]]*).*");

  public static List<Token> tokenize(java.lang.String src) {
    List<Token> res = new ArrayList<>();
    while (!src.isEmpty()) {
      char first = src.charAt(0);
      java.lang.String rest = src.substring(1);
      Matcher strm = stringPat.matcher(src);
      Matcher digm = digitPat.matcher(src);
      Matcher symm = symPat.matcher(src);

      if (Character.isWhitespace(first)) {
        src = rest;
      }
      else if ('(' == first) {
        res.add(new TOpen());
        src = rest;
      }
      else if (')' == first) {
        res.add(new TClose());
        src = rest;
      }
      else if (strm.matches()) {
        java.lang.String str = strm.group(1);
        res.add(new TString(str));
        src = src.substring(strm.end(1) + 1);
      }
      else if (digm.matches() && !digm.group(2).isEmpty()) {
        java.lang.String str = digm.group(2);
        res.add(new TNumber(str));
        src = src.substring(digm.end(2));
      }
      else if (symm.matches()) {
        java.lang.String str = symm.group(1);
        res.add(new TSymbol(str));
        src = src.substring(symm.end(1));
      }
      else
        throw new IllegalArgumentException("Parsing error");
    }
    return res;
  }
}
