package nectec.thai.unit

import org.junit.Test
import kotlin.test.assertEquals

class AreaTest {

  val area = Area(1600)

  @Test fun getRai() {
    assertEquals(1, area.rai)
  }

  @Test fun getNgan() {
    assertEquals(0, area.ngan)
  }

  @Test fun getSquareWa() {
    assertEquals(0, area.squareWa)
  }

  @Test fun getSquareMetre() {
    assertEquals(1600, area.squareMetre)
  }

  @Test fun formalPrint() {
    assertEquals("1 ไร่", Area.from(1, 0, 0).formalPrint());
    assertEquals("2 งาน", Area.from(0, 2, 0).formalPrint());
    assertEquals("1 ตารางวา", Area.from(0, 0, 1).formalPrint());
    assertEquals("1 ไร่ 99 ตารางวา", Area.from(0, 0, 499).formalPrint());
    assertEquals("2 ไร่ 3 งาน 99 ตารางวา", Area.from(0, 7, 499).formalPrint());
  }

  @Test fun prettyPrint() {
    assertEquals("1-0-0 ไร่", Area.from(1, 0, 0).prettyPrint());
    assertEquals("0-2-0 ไร่", Area.from(0, 2, 0).prettyPrint());
    assertEquals("0-0-1 ไร่", Area.from(0, 0, 1).prettyPrint());
    assertEquals("1-0-99 ไร่", Area.from(0, 0, 499).prettyPrint());
    assertEquals("2-3-99 ไร่", Area.from(0, 7, 499).prettyPrint());
  }

  @Test fun rounding(){
    val ex1 = Area(2400)
    assertEquals(1, ex1.rai)
    assertEquals(2, ex1.ngan)
    assertEquals(0, ex1.squareWa)

    val ex2 = Area(1599)
    assertEquals(1, ex2.rai)
    assertEquals(0, ex2.ngan)
    assertEquals(0, ex2.squareWa)

    val ex3 = Area(1605)
    assertEquals(1, ex3.rai)
    assertEquals(0, ex3.ngan)
    assertEquals(1, ex3.squareWa)

    val ex4 = Area(1601)
    assertEquals(1, ex4.rai)
    assertEquals(0, ex4.ngan)
    assertEquals(0, ex4.squareWa)
  }
}