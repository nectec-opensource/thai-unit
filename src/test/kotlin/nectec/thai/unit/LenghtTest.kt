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

  @Test fun prtAll() {
    assertEquals("dd", lenght.prtAll())
  }
}
