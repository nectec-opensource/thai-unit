package nectec.thai.unit

import java.lang.StringBuilder

/**
 * Thai length unit.
 * Created by user on 11/7/2560.
 */
data class Length (val cm: Double) {
  /**
   * Create convert object
   * @param cm is centimetres SI Ref. https://en.wikipedia.org/wiki/Centimetre/
   * @see <a href="http://google.com">http://google.com</a>
   */
  constructor(cm: Number) : this(cm.toDouble())

  /**
   * Create by Thai Unit Length <a href="https://en.wikipedia.org/wiki/Thai_units_of_measurement">https://en.wikipedia.org/wiki/Thai_units_of_measurement</a>
   */
  //Auto Gen \($1.toDouble\(\)*CENTIMETRE_PER_$2\)+
  constructor(yot: Number,sen:Number,wa:Number,sok:Number,khuep:Number,nio:Number,krabiat:Number) : this((yot.toDouble()*CENTIMETRE_PER_YOT)+(sen.toDouble()*CENTIMETRE_PER_SEN)+(wa.toDouble()*CENTIMETRE_PER_WA)+(sok.toDouble()*CENTIMETRE_PER_SOK)+(khuep.toDouble()*CENTIMETRE_PER_KHUEP)+(nio.toDouble()*CENTIMETRE_PER_NIO)+(krabiat.toDouble()*CENTIMETRE_PER_KRABIAT))

  //Auto Gen val $1: Int
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

    //Auto Gen this.$1=\(tmp/CENTIMETRE_PER_$2\).toInt\(\)\r\ntmp=\(tmp%CENTIMETRE_PER_$2\)
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


    //Auto Gen @JvmField val CENTIMETRE_PER_$1 = xx
    @JvmField val CENTIMETRE_PER_KRABIAT = 0.5208
    @JvmField val CENTIMETRE_PER_NIO = 2.083
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

  }

  /**
   * Print standart output.
   * @return String "%d โยชน์ %d เส้น %d วา %d ศอก %d คืบ %d นิ้ว %d กระเบียด"
   */
  fun prtAll(): String {

    val stringBuilder = StringBuilder()
    //Auto Gen .append\($1\).append\($2\)
    return stringBuilder.append(yot).append(YOT).append(sen).append(SEN).append(wa).append(WA).append(sok).append(SOK).append(khuep).append(KHUEP).append(nio).append(NIO).append(krabiat).append(KRABIAT).toString().trim()
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
