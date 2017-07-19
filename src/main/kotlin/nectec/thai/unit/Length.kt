package nectec.thai.unit

import java.lang.StringBuilder
import java.text.NumberFormat


/**
 * Thai length unit.
 * Created by user on 11/7/2560.
 */
data class Length (val centimetres: Double) {


  /**
   * Create convert object
   */
  constructor(centimetres: Number) : this(centimetres.toDouble())

  constructor(yot: Number,sen:Number,wa:Number,sok:Number,khuep:Number,nio:Number,krabiat:Number) : this(toCentimetres(yot, sen, wa, sok, khuep, nio, krabiat))

  //Auto Gen val $1: Int
  val krabiat: Double
  val nio: Int
  val khuep: Int
  val sok: Int
  val wa: Int
  val sen: Int
  val yot: Int

  val number_format = NumberFormat.getNumberInstance()

  init {

    var temp_value :Double

    //Number rounding format.
    number_format.maximumFractionDigits=0
    number_format.roundingMode=java.math.RoundingMode.DOWN

    //Convert centimetres to thai unit. YOT->SEN->WA->SOK->KHUEP->NIO->KRABIAT
    this.yot=(centimetres /CENTIMETRE_PER_YOT).toInt()
    temp_value=(centimetres %CENTIMETRE_PER_YOT)

    //Auto Gen this.$1=\(temp_value/CENTIMETRE_PER_$2\).toInt\(\)\r\ntemp_value=\(temp_value%CENTIMETRE_PER_$2\)
    this.sen=(temp_value/CENTIMETRE_PER_SEN).toInt()
    temp_value=(temp_value%CENTIMETRE_PER_SEN)

    this.wa=(temp_value/CENTIMETRE_PER_WA).toInt()
    temp_value=(temp_value%CENTIMETRE_PER_WA)

    this.sok=(temp_value/CENTIMETRE_PER_SOK).toInt()
    temp_value=(temp_value%CENTIMETRE_PER_SOK)

    this.khuep=(temp_value/CENTIMETRE_PER_KHUEP).toInt()
    temp_value=(temp_value%CENTIMETRE_PER_KHUEP)

    this.nio=(temp_value/CENTIMETRE_PER_NIO).toInt()
    temp_value=(temp_value%CENTIMETRE_PER_NIO)

    this.krabiat=((temp_value/CENTIMETRE_PER_KRABIAT)+(temp_value%CENTIMETRE_PER_KRABIAT))


  }

  companion object {

    //Ref. https://en.wikipedia.org/wiki/Thai_units_of_measurement
    //Auto Gen @JvmField val CENTIMETRE_PER_$1 = xx
    @JvmField val CENTIMETRE_PER_KRABIAT = 0.5208
    @JvmField val CENTIMETRE_PER_NIO = 2.0//83
    @JvmField val CENTIMETRE_PER_KHUEP = 25
    @JvmField val CENTIMETRE_PER_SOK = 50
    @JvmField val CENTIMETRE_PER_WA = 200
    @JvmField val CENTIMETRE_PER_SEN = 4000
    @JvmField val CENTIMETRE_PER_YOT = 1600000

    //Auto Gen @JvmField val $1 = "$2"
    @JvmField val KRABIAT = " กระเบียด "
    @JvmField val NIO = " นิ้ว "
    @JvmField val KHUEP = " คืบ "
    @JvmField val SOK = " ศอก "
    @JvmField val WA = " วา "
    @JvmField val SEN = " เส้น "
    @JvmField val YOT = " โยชน์ "

    private fun toCentimetres(yot: Number,sen:Number,wa:Number,sok:Number,khuep:Number,nio:Number,krabiat:Number):Number{
      return +

      //Auto Gen \($1.toDouble\(\)*CENTIMETRE_PER_$2\)+
        (yot.toDouble()*CENTIMETRE_PER_YOT)+
        (sen.toDouble()*CENTIMETRE_PER_SEN)+
        (wa.toDouble()*CENTIMETRE_PER_WA)+
        (sok.toDouble()*CENTIMETRE_PER_SOK)+
        (khuep.toDouble()*CENTIMETRE_PER_KHUEP)+
        (nio.toDouble()*CENTIMETRE_PER_NIO)+
        (krabiat.toDouble()*CENTIMETRE_PER_KRABIAT)
    }
  }

  fun formalPrint(): String {
    val stringBuilder = StringBuilder()
    //Auto Gen .append\($1\).append\($2\)
    return stringBuilder
      .append(when(yot) {0-> "" else -> yot.toString()+YOT } )
      .append(when(sen) {0-> "" else -> sen.toString()+SEN } )
      .append(when(wa) {0-> "" else -> wa.toString()+WA } )
      .append(when(sok) {0-> "" else -> sok.toString()+SOK } )
      .append(when(khuep) {0-> "" else -> khuep.toString()+KHUEP } )
      .append(when(nio) {0-> "" else -> nio.toString()+NIO } )
      .append(when(krabiat) {0.0-> "" else -> number_format.format(krabiat)+KRABIAT } )
      .toString().trim()
  }
}



//Auto Gen
/*
yot	YOT
sen	SEN
wa	WA
sok	SOK
khuep	KHUEP
nio	NIO
krabiat	KRABIAT

krabiat	KRABIAT
nio	NIO
khuep	KHUEP
sok	SOK
wa	WA
sen	SEN
yot	YOT
 */
