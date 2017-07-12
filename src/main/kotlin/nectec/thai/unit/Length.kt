package nectec.thai.unit

import javafx.beans.binding.Bindings
import java.lang.StringBuilder

/**
 * Created by user on 11/7/2560.
 */
data class Length (val cm: Double) {


  val krabiat: Int
  val nio: Int
  val khuep: Int
  val sok: Int
  val wa: Int
  val sen: Int
  val yot: Int

  init {
    var tmp :Double
    this.yot=(cm/CENTIMETRE_PER_YOT).toInt()
    tmp=(cm%CENTIMETRE_PER_YOT)
    this.sen=(tmp/CENTIMETRE_PER_SEN).toInt()
    tmp=(tmp%CENTIMETRE_PER_SEN)
    this.wa=(tmp/CENTIMETRE_PER_WA).toInt()
    tmp=(tmp%CENTIMETRE_PER_WA)
    this.sok=(tmp/CENTIMETRE_PER_SOK).toInt()
    tmp=(tmp%CENTIMETRE_PER_SOK)
    this.khuep=(tmp/CENTIMETRE_PER_KHUEP).toInt()
    tmp=(tmp%CENTIMETRE_PER_KHUEP)
    this.nio=(tmp/CENTIMETRE_PER_NIO).toInt()
    tmp=(tmp%CENTIMETRE_PER_NIO)
    this.krabiat=(tmp/CENTIMETRE_PER_KRABIAT).toInt()
    tmp=(tmp%CENTIMETRE_PER_KRABIAT)

  }

  companion object {

    @JvmField val CENTIMETRE_PER_KRABIAT = 0.5208
    @JvmField val CENTIMETRE_PER_NIO = 2.083
    @JvmField val CENTIMETRE_PER_KHUEP = 25
    @JvmField val CENTIMETRE_PER_SOK = 50
    @JvmField val CENTIMETRE_PER_WA = 200
    @JvmField val CENTIMETRE_PER_SEN = 4000
    @JvmField val CENTIMETRE_PER_YOT = 1600000

    @JvmField val KRABIAT = " กระเบียด "
    @JvmField val NIO = " นิ้ว "
    @JvmField val KHUEP = " คืบ "
    @JvmField val SOK = " ศอก "
    @JvmField val WA = " วา "
    @JvmField val SEN = " เส้น "
    @JvmField val YOT = " โยชน์ "

  }

  fun prtAll(): String {

    val stringBuilder = StringBuilder()
    return stringBuilder.append(krabiat).append(KRABIAT).append(nio).append(NIO).append(khuep).append(KHUEP).append(sok).append(SOK).append(wa).append(WA).append(sen).append(SEN).append(yot).append(YOT).toString().trim()
  }

}
