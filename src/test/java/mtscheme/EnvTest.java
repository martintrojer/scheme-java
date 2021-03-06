package mtscheme;

import mtscheme.Expression.Nil;
import mtscheme.Expression.Value.Name;
import mtscheme.Expression.Value.Num;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class EnvTest {

  Nil nilExpr = new Nil();
  Num FortyTwo = new Num(BigDecimal.valueOf(42));
  Name Baz = new Name("baz");

  Env simpleTestEnv = new Env().addEntry("foo", nilExpr);
  Env nestedTestEnv = simpleTestEnv.expand().addEntry("bar", Baz);
  Env shadowedTestEnv = nestedTestEnv.expand().addEntry("foo", FortyTwo);

  @Test
  public void testSimpleLookUp() throws Exception {
    Assert.assertEquals(simpleTestEnv.lookUp("foo").get(), nilExpr);
    Assert.assertFalse(simpleTestEnv.lookUp("bar").isPresent());
  }

  @Test
  public void testNestedLookup() throws Exception {
    Assert.assertEquals(nestedTestEnv.lookUp("bar").get(), Baz);
    Assert.assertEquals(nestedTestEnv.lookUp("foo").get(), nilExpr);
    Assert.assertFalse(simpleTestEnv.lookUp("baz").isPresent());
  }

  @Test
  public void testShadowedLookup() throws Exception {
    Assert.assertEquals(shadowedTestEnv.lookUp("bar").get(), Baz);
    Assert.assertEquals(shadowedTestEnv.lookUp("foo").get(), FortyTwo);
    Assert.assertFalse(shadowedTestEnv.lookUp("baz").isPresent());
  }
}
