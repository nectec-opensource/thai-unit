package nectec.thai.unit;

/**
 * Created by user on 11/7/2560.
 */

import org.junit.Assert;
import org.junit.Test;

public class LenghtJavaTest {
  @Test
  public void name() throws Exception {
    Length length = new Length(50).copy(100).copy(50);
    Assert.assertEquals(1,length.getSok());
  }

}
