package nectec.thai.unit
import org.junit.Test
import kotlin.test.assertEquals

class WeightTest {
  val weightTest1 :Weight
  val weightTest2 :Weight

  constructor(){
    weightTest1 = Weight(2000.0)
    weightTest2 = Weight(3000)
  }




  @Test fun toHapFunction() {
    assertEquals(0.5, weightTest1.toHAP(30000.0))
  }

  @Test fun toChangFunction() {
    assertEquals(25.0, weightTest1.toCHANG(30000.0))
  }

  @Test fun toTamluengFunction() {
    assertEquals(500.0, weightTest1.toTAMLUENG(30000.0))
  }

  @Test fun toBahtFunction() {
    assertEquals(2000.0, weightTest1.toBAHT(30000.0))
  }

  @Test fun toSaluengFunction() {
    assertEquals(8000.0, weightTest1.toSALUENG(30000.0))
  }



}
