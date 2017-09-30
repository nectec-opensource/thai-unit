package nectec.thai.unit

/**
 * Created by Max on 12/7/2560.
 */

import org.junit.Test
import kotlin.test.assertEquals
class LenghtTest {

  val lenght :Length
  val lenght2 :Length

  constructor(){
    lenght2 = Length(1200.0)
    lenght = Length(1200)
  }




  @Test fun sokvalue() {
    assertEquals(0, lenght.sok)
  }

  @Test fun khupvalue() {
    assertEquals(0, lenght.khuep)
  }

  @Test fun formalPrintAll1() {
    assertEquals("0 โยชน์ 0 เส้น 6 วา 0 ศอก 0 คืบ 0 นิ้ว 0 กระเบียด", lenght.formalPrintAll())
  }
  @Test fun formalPrintAll2() {
    assertEquals("10 โยชน์ 1 เส้น 1 วา 1 ศอก 1 คืบ 1 นิ้ว 1 กระเบียด", Length(10,1,1,1,1,1,1).formalPrintAll())
  }

  @Test fun formalPrintAll3() {
    assertEquals("10 โยชน์ 7 เส้น 8 วา 0 ศอก 1 คืบ 7 นิ้ว 1 กระเบียด", Length(10,7,6,6,5,7,1).formalPrintAll())
  }

  @Test fun formalPrintAll4() {
    assertEquals("10 โยชน์ 0 เส้น 0 วา 0 ศอก 1 คืบ 2 นิ้ว 1 กระเบียด", Length(10,0,0,0,1,2,1).formalPrintAll())
  }

  @Test fun formalPrint() {
    assertEquals("10 โยชน์ 1 คืบ 2 นิ้ว 1 กระเบียด", Length(10,0,0,0,1,2,1).formalPrint())
  }


}
