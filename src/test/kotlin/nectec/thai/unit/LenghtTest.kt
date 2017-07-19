package nectec.thai.unit

/**
 * Created by Max on 12/7/2560.
 */

import org.junit.Test
import kotlin.test.assertEquals
class LenghtTest {

  val lenght = Length(1200.0)


  @Test fun getsok() {
    assertEquals(0, lenght.sok)
  }

  @Test fun getkhup() {
    assertEquals(0, lenght.khuep)
  }


//Test
  @Test fun prtAll4() {
    assertEquals("10 โยชน์ 1 คืบ 2 นิ้ว 1 กระเบียด", Length(10,0,0,0,1,2,1).formalPrint())
  }


}
