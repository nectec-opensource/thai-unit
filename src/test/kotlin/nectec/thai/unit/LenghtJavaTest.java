package nectec.thai.unit;

/**
 * Created by user on 11/7/2560.
 */

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class LenghtJavaTest {
  @Test
  public void name() throws Exception {
    //Length length = new Length(new BigDecimal(50)).copy(new BigDecimal(100)).copy(new BigDecimal(50));
    Length length = new Length(50);
    Assert.assertEquals(1,length.getSok());
  }

}
