package nectec.thai.unit

import java.lang.StringBuilder
import java.math.BigDecimal
import java.text.NumberFormat


/**
 * Thai length unit.
 * Ref. https://en.wikipedia.org/wiki/Thai_units_of_measurement
 * Created by max on 11/7/2560.
 */
data class Length (val centimetres: BigDecimal) {

  constructor(centimetres: Number) : this(BigDecimal(centimetres.toDouble()))
  constructor(centimetres: Double) : this(BigDecimal(centimetres))

  constructor(yot: Number,sen:Number,wa:Number,sok:Number,khuep:Number,nio:Number,krabiat:Number) : this(toCentimetres(yot, sen, wa, sok, khuep, nio, krabiat))

  val krabiat: Double
  val nio: Int
  val khuep: Int
  val sok: Int
  val wa: Int
  val sen: Int
  val yot: Int

  val rounding_number_format :NumberFormat

  init {

    //Number rounding format.
    rounding_number_format = NumberFormat.getNumberInstance()
    rounding_number_format.maximumFractionDigits=0
    rounding_number_format.roundingMode=java.math.RoundingMode.HALF_UP

    var temp_value :BigDecimal


    this.yot=toYOT(centimetres).toInt()
    temp_value=centimetres.remainder(BigDecimal(CENTIMETRE_PER_YOT))

    this.sen = toSEN(temp_value).toInt()
    temp_value = temp_value.remainder(BigDecimal(CENTIMETRE_PER_SEN))

    this.wa = toWA(temp_value).toInt()
    temp_value = temp_value.remainder(BigDecimal(CENTIMETRE_PER_WA))

    this.sok = toSOK(temp_value).toInt()
    temp_value = temp_value.remainder(BigDecimal(CENTIMETRE_PER_SOK))

    this.khuep = toKHUEP(temp_value).toInt()
    temp_value = temp_value.remainder(BigDecimal(CENTIMETRE_PER_KHUEP))

    this.nio = toNIO(temp_value).toInt()
    temp_value = temp_value.remainder(BigDecimal(CENTIMETRE_PER_NIO))

    this.krabiat = toKRABIAT(temp_value).toDouble()

  }

  companion object {

    //Ref. https://en.wikipedia.org/wiki/Thai_units_of_measurement
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

    private fun toCentimetres(yot: Number,sen:Number,wa:Number,sok:Number,khuep:Number,nio:Number,krabiat:Number):BigDecimal{
      var temp_value : BigDecimal
      temp_value= BigDecimal.ZERO
      temp_value = temp_value.add(BigDecimal(yot.toDouble()).multiply(BigDecimal(CENTIMETRE_PER_YOT)))
      temp_value = temp_value.add(BigDecimal(sen.toDouble()).multiply(BigDecimal(CENTIMETRE_PER_SEN)))
      temp_value = temp_value.add(BigDecimal(wa.toDouble()).multiply(BigDecimal(CENTIMETRE_PER_WA)))
      temp_value = temp_value.add(BigDecimal(sok.toDouble()).multiply(BigDecimal(CENTIMETRE_PER_SOK)))
      temp_value = temp_value.add(BigDecimal(khuep.toDouble()).multiply(BigDecimal(CENTIMETRE_PER_KHUEP)))
      temp_value = temp_value.add(BigDecimal(nio.toDouble()).multiply(BigDecimal(CENTIMETRE_PER_NIO)))
      temp_value = temp_value.add(BigDecimal(krabiat.toDouble()).multiply(BigDecimal(CENTIMETRE_PER_KRABIAT)))

      return temp_value
    }
  }

  /**
   * Print All
   * Exam create object input Length(10,0,0,0,1,2,1)
   * formalPrintAll output = 10 โยชน์ 0 เส้น 0 วา 0 ศอก 1 คืบ 2 นิ้ว 1 กระเบียด
   */
  fun formalPrintAll(): String {
    val stringBuilder = StringBuilder()
    return stringBuilder
      .append(yot).append(YOT)
      .append(sen).append(SEN)
      .append(wa).append(WA)
      .append(sok).append(SOK)
      .append(khuep).append(KHUEP)
      .append(nio).append(NIO)
      .append(rounding_number_format.format(krabiat)).append(KRABIAT)
      .toString().trim()
  }

  /**
   * Zero value no print.
   * Exam create object input Length(10,0,0,0,1,2,1)
   * formalPrint output = 10 โยชน์ 1 คืบ 2 นิ้ว 1 กระเบียด
   */
  fun formalPrint(): String {
    val stringBuilder = StringBuilder()
    return stringBuilder
      .append(if (yot>0){yot.toString()+YOT}else{""} )
      .append(if (sen>0){sen.toString()+SEN}else{""} )
      .append(if (wa>0){wa.toString()+WA}else{""} )
      .append(if (sok>0){sok.toString()+SOK}else{""} )
      .append(if (khuep>0){khuep.toString()+KHUEP}else{""} )
      .append(if (nio>0){nio.toString()+NIO}else{""} )
      .append(if (krabiat>0){rounding_number_format.format(krabiat)+KRABIAT}else{""} )
      .toString().trim()
  }


  fun toYOT(centimetres: Double): Double {
    return centimetres / CENTIMETRE_PER_YOT
  }
  fun toYOT(centimetres: BigDecimal): BigDecimal {
    return BigDecimal(toYOT(centimetres.toDouble()))
  }
  fun toYOT(): Double {
    return toYOT(centimetres.toDouble())
  }

  fun toSEN(centimetres: Double): Double {
    return centimetres / CENTIMETRE_PER_SEN
  }
  fun toSEN(centimetres: BigDecimal): BigDecimal {
    return BigDecimal(toSEN(centimetres.toDouble()))
  }
  fun toSEN(): Double {
    return toSEN(centimetres.toDouble())
  }

  fun toWA(centimetres: Double): Double {
    return centimetres / CENTIMETRE_PER_WA
  }
  fun toWA(centimetres: BigDecimal): BigDecimal {
    return BigDecimal(toWA(centimetres.toDouble()))
  }
  fun toWA(): Double {
    return toWA(centimetres.toDouble())
  }

  fun toSOK(centimetres: Double): Double {
    return centimetres / CENTIMETRE_PER_SOK
  }
  fun toSOK(centimetres: BigDecimal): BigDecimal {
    return BigDecimal(toSOK(centimetres.toDouble()))
  }
  fun toSOK(): Double {
    return toSOK(centimetres.toDouble())
  }

  fun toKHUEP(centimetres: Double): Double {
    return centimetres / CENTIMETRE_PER_KHUEP
  }
  fun toKHUEP(centimetres: BigDecimal): BigDecimal {
    return BigDecimal(toKHUEP(centimetres.toDouble()))
  }
  fun toKHUEP(): Double {
    return toKHUEP(centimetres.toDouble())
  }

  fun toNIO(centimetres: Double): Double {
    return centimetres / CENTIMETRE_PER_NIO
  }
  fun toNIO(centimetres: BigDecimal): BigDecimal {
    return BigDecimal(toNIO(centimetres.toDouble()))
  }
  fun toNIO(): Double {
    return toNIO(centimetres.toDouble())
  }

  fun toKRABIAT(centimetres: Double): Double {
    return centimetres / CENTIMETRE_PER_KRABIAT
  }
  fun toKRABIAT(centimetres: BigDecimal): BigDecimal {
    return BigDecimal(toKRABIAT(centimetres.toDouble()))
  }
  fun toKRABIAT(): Double {
    return toKRABIAT(centimetres.toDouble())
  }

}
