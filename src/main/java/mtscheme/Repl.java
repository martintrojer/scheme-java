package mtscheme;

import mtscheme.Expression.EvalContext;
import mtscheme.Expression.Value.Name;

import java.util.Scanner;

public class Repl {

  private static Scanner s = new Scanner(System.in);

  public static EvalContext readAndEvalFirstForm(String str, Env env) {
    return Reader.readString(str).get(0).eval(env);
  }

  private static void commandLoop(EvalContext ctx) {
    System.out.println(ctx.expr.toString());
    System.out.print("> ");
    String line = s.nextLine();
    try {
      commandLoop(readAndEvalFirstForm(line, ctx.env));
    }
    catch (Exception e) {
      commandLoop(new EvalContext(ctx.env, new Name("Error; " + e.getMessage())));
    }
  }


  public static void main(String[] args) {
    commandLoop(readAndEvalFirstForm("(display \"mtscheme v0.1\")", GlobalEnv.globalEnv()));
  }
}
