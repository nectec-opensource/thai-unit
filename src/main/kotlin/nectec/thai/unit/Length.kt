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

  //Auto RegEx Output val $1: Int


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


    //Convert centimetres to thai unit. YOT->SEN->WA->SOK->KHUEP->NIO->KRABIAT
    this.yot=(centimetres.toDouble()/CENTIMETRE_PER_YOT).toInt()
    temp_value=centimetres.remainder(BigDecimal(CENTIMETRE_PER_YOT))


    //Auto RegEx Output this.$1=\(temp_value.toDouble\(\)/CENTIMETRE_PER_$2\).toInt\(\)\r\ntemp_value=temp_value.remainder\(BigDecimal\(CENTIMETRE_PER_$2\)\)
    this.sen=(temp_value.toDouble()/CENTIMETRE_PER_SEN).toInt()
    temp_value=temp_value.remainder(BigDecimal(CENTIMETRE_PER_SEN))
    this.wa=(temp_value.toDouble()/CENTIMETRE_PER_WA).toInt()
    temp_value=temp_value.remainder(BigDecimal(CENTIMETRE_PER_WA))
    this.sok=(temp_value.toDouble()/CENTIMETRE_PER_SOK).toInt()
    temp_value=temp_value.remainder(BigDecimal(CENTIMETRE_PER_SOK))
    this.khuep=(temp_value.toDouble()/CENTIMETRE_PER_KHUEP).toInt()
    temp_value=temp_value.remainder(BigDecimal(CENTIMETRE_PER_KHUEP))
    this.nio=(temp_value.toDouble()/CENTIMETRE_PER_NIO).toInt()
    temp_value=temp_value.remainder(BigDecimal(CENTIMETRE_PER_NIO))
    this.krabiat=(temp_value.toDouble()/CENTIMETRE_PER_KRABIAT)
    //temp_value=temp_value.remainder(BigDecimal(CENTIMETRE_PER_KRABIAT))
  }

  companion object {

    //Ref. https://en.wikipedia.org/wiki/Thai_units_of_measurement
    //Auto RegEx Output @JvmField val CENTIMETRE_PER_$1 = xx
    @JvmField val CENTIMETRE_PER_KRABIAT = 0.5208
    @JvmField val CENTIMETRE_PER_NIO = 2.083
    @JvmField val CENTIMETRE_PER_KHUEP = 25
    @JvmField val CENTIMETRE_PER_SOK = 50
    @JvmField val CENTIMETRE_PER_WA = 200
    @JvmField val CENTIMETRE_PER_SEN = 4000
    @JvmField val CENTIMETRE_PER_YOT = 1600000

    //Auto RegEx Output @JvmField val $1 = "$2"
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

      //Auto RegEx Output temp_value = temp_value.add\(BigDecimal\($1.toDouble\(\)\).multiply\(BigDecimal\(CENTIMETRE_PER_$2\)\)\)
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
      //Auto RegEx Output .append\($1\).append\($2\)
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
      //Auto RegEx Output .append\(if \($1>0\){$1.toString\(\)+$2}else{""} \)
      .append(if (yot>0){yot.toString()+YOT}else{""} )
      .append(if (sen>0){sen.toString()+SEN}else{""} )
      .append(if (wa>0){wa.toString()+WA}else{""} )
      .append(if (sok>0){sok.toString()+SOK}else{""} )
      .append(if (khuep>0){khuep.toString()+KHUEP}else{""} )
      .append(if (nio>0){nio.toString()+NIO}else{""} )
      .append(if (krabiat>0){rounding_number_format.format(krabiat)+KRABIAT}else{""} )
      .toString().trim()
  }

//Auto RegEx Output fun to$2\(\):Double{\r\nreturn to$2\(centimetres\).toDouble\(\)\r\n  }\r\nfun to$2\(centimetres: Double\):Double{\r\nreturn to$2\(BigDecimal\(centimetres\)\).toDouble\(\)\r\n  }\r\n  fun to$2\(centimetres: BigDecimal\):BigDecimal{\r\nreturn centimetres.remainder\(BigDecimal\(CENTIMETRE_PER_$2\)\)\r\n  }\r\n
  fun toYOT():Double{
    return toYOT(centimetres).toDouble()
  }
  fun toYOT(centimetres: Double):Double{
    return toYOT(BigDecimal(centimetres)).toDouble()
  }
  fun toYOT(centimetres: BigDecimal):BigDecimal{
    return centimetres.remainder(BigDecimal(CENTIMETRE_PER_YOT))
  }

  fun toSEN():Double{
    return toSEN(centimetres).toDouble()
  }
  fun toSEN(centimetres: Double):Double{
    return toSEN(BigDecimal(centimetres)).toDouble()
  }
  fun toSEN(centimetres: BigDecimal):BigDecimal{
    return centimetres.remainder(BigDecimal(CENTIMETRE_PER_SEN))
  }

  fun toWA():Double{
    return toWA(centimetres).toDouble()
  }
  fun toWA(centimetres: Double):Double{
    return toWA(BigDecimal(centimetres)).toDouble()
  }
  fun toWA(centimetres: BigDecimal):BigDecimal{
    return centimetres.remainder(BigDecimal(CENTIMETRE_PER_WA))
  }

  fun toSOK():Double{
    return toSOK(centimetres).toDouble()
  }
  fun toSOK(centimetres: Double):Double{
    return toSOK(BigDecimal(centimetres)).toDouble()
  }
  fun toSOK(centimetres: BigDecimal):BigDecimal{
    return centimetres.remainder(BigDecimal(CENTIMETRE_PER_SOK))
  }

  fun toKHUEP():Double{
    return toKHUEP(centimetres).toDouble()
  }
  fun toKHUEP(centimetres: Double):Double{
    return toKHUEP(BigDecimal(centimetres)).toDouble()
  }
  fun toKHUEP(centimetres: BigDecimal):BigDecimal{
    return centimetres.remainder(BigDecimal(CENTIMETRE_PER_KHUEP))
  }

  fun toNIO():Double{
    return toNIO(centimetres).toDouble()
  }
  fun toNIO(centimetres: Double):Double{
    return toNIO(BigDecimal(centimetres)).toDouble()
  }
  fun toNIO(centimetres: BigDecimal):BigDecimal{
    return centimetres.remainder(BigDecimal(CENTIMETRE_PER_NIO))
  }

  fun toKRABIAT():Double{
    return toKRABIAT(centimetres).toDouble()
  }
  fun toKRABIAT(centimetres: Double):Double{
    return toKRABIAT(BigDecimal(centimetres)).toDouble()
  }
  fun toKRABIAT(centimetres: BigDecimal):BigDecimal{
    return centimetres.remainder(BigDecimal(CENTIMETRE_PER_KRABIAT))
  }


}


/*
RegEx Gen Code

^(.+)\t(.+)$

yot	YOT
sen	SEN
wa	WA
sok	SOK
khuep	KHUEP
nio	NIO
krabiat	KRABIAT
-------------------
krabiat	KRABIAT
nio	NIO
khuep	KHUEP
sok	SOK
wa	WA
sen	SEN
yot	YOT
-----------------
KRABIAT	กระเบียด
NIO	นิ้ว
KHUEP	คืบ
SOK	ศอก
WA	วา
SEN	เส้น
YOT	โยชน์
 */
