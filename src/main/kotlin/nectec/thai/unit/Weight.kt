package nectec.thai.unit

import java.math.BigDecimal
import java.text.NumberFormat

data class Weight (val gram :BigDecimal){

  constructor(gram: Number) : this(BigDecimal(gram.toDouble()))
  constructor(gram: Double) : this(BigDecimal(gram))
  constructor(hap: Number,chang: Number,tamlueng: Number,baht: Number,salueng: Number) : this(toGram(hap, chang, tamlueng, baht, salueng))


  val salueng: Double
  val baht: Int
  val tamlueng: Int
  val chang: Int
  val hap: Int

  val rounding_number_format : NumberFormat

  init {

    //Number rounding format.
    rounding_number_format = NumberFormat.getNumberInstance()
    rounding_number_format.maximumFractionDigits=0
    rounding_number_format.roundingMode=java.math.RoundingMode.HALF_UP

    var temp_value :BigDecimal

    this.hap=toHAP(gram).toInt()
    temp_value=gram.remainder(BigDecimal(GRAM_PER_HAP))

    this.chang = toCHANG(temp_value).toInt()
    temp_value = temp_value.remainder(BigDecimal(GRAM_PER_CHANG))
    this.tamlueng = toTAMLUENG(temp_value).toInt()
    temp_value = temp_value.remainder(BigDecimal(GRAM_PER_TAMLUENG))
    this.baht = toBAHT(temp_value).toInt()
    temp_value = temp_value.remainder(BigDecimal(GRAM_PER_BAHT))
    this.salueng = toSALUENG(temp_value).toDouble()
    //temp_value = temp_value.remainder(BigDecimal(GRAM_PER_SALUENG))


  }

  companion object {

    @JvmField val GRAM_PER_SALUENG = 3.75
    @JvmField val GRAM_PER_BAHT = 15
    @JvmField val GRAM_PER_TAMLUENG = 60
    @JvmField val GRAM_PER_CHANG = 1200
    @JvmField val GRAM_PER_HAP = 60000

    @JvmField val SALUENG = " สลึง "
    @JvmField val BAHT = " บาท "
    @JvmField val TAMLUENG = " ตำลึง "
    @JvmField val CHANG = " ชั่ง "
    @JvmField val HAP = " หาบ "

    private fun toGram( hap: Number,chang: Number,tamlueng: Number,baht: Number,salueng: Number): BigDecimal{

      var temp_value : BigDecimal
      temp_value= BigDecimal.ZERO

      temp_value = temp_value.add(BigDecimal(salueng.toDouble()).multiply(BigDecimal(GRAM_PER_SALUENG)))
      temp_value = temp_value.add(BigDecimal(baht.toDouble()).multiply(BigDecimal(GRAM_PER_BAHT)))
      temp_value = temp_value.add(BigDecimal(tamlueng.toDouble()).multiply(BigDecimal(GRAM_PER_TAMLUENG)))
      temp_value = temp_value.add(BigDecimal(chang.toDouble()).multiply(BigDecimal(GRAM_PER_CHANG)))
      temp_value = temp_value.add(BigDecimal(hap.toDouble()).multiply(BigDecimal(GRAM_PER_HAP)))
      return temp_value
    }
  }

  /**
   * Print All
   * Exam create object input Weight(2,2,2,2,30000)
   * formalPrintAll output = 3 หาบ 45 ชั่ง 17 ตำลึง 2 บาท 0 สลึง
   */
  fun formalPrintAll(): String {
    val stringBuilder = StringBuilder()
    return stringBuilder
      //Auto RegEx Output .append\($2\).append\($1\)

      .append(hap).append(HAP)
      .append(chang).append(CHANG)
      .append(tamlueng).append(TAMLUENG)
      .append(baht).append(BAHT)
      .append(rounding_number_format.format(salueng)).append(SALUENG)
      .toString().trim()
  }

  /**
   * Zero value no print.
   * Exam create object input Weight(2,2,2,2,30000)
   * formalPrint output = 3 หาบ 45 ชั่ง 17 ตำลึง 2 บาท
   */
  fun formalPrint(): String {
    val stringBuilder = StringBuilder()
    return stringBuilder
      //Auto RegEx Output .append\(if \($2>0\){$2.toString\(\)+$1}else{""} \)
      .append(if (hap>0){hap.toString()+HAP}else{""} )
      .append(if (chang>0){chang.toString()+CHANG}else{""} )
      .append(if (tamlueng>0){tamlueng.toString()+TAMLUENG}else{""} )
      .append(if (baht>0){baht.toString()+BAHT}else{""} )
      .append(if (salueng>0){rounding_number_format.format(salueng)+SALUENG}else{""} )
      .toString().trim()
  }


  fun toSALUENG(gram: Double): Double {
    return gram / GRAM_PER_SALUENG
  }
  fun toSALUENG(gram: BigDecimal): BigDecimal {
    return BigDecimal(toSALUENG(gram.toDouble()))
  }
  fun toSALUENG(): Double {
    return toSALUENG(gram.toDouble())
  }

  fun toBAHT(gram: Double): Double {
    return gram / GRAM_PER_BAHT
  }
  fun toBAHT(gram: BigDecimal): BigDecimal {
    return BigDecimal(toBAHT(gram.toDouble()))
  }
  fun toBAHT(): Double {
    return toBAHT(gram.toDouble())
  }

  fun toTAMLUENG(gram: Double): Double {
    return gram / GRAM_PER_TAMLUENG
  }
  fun toTAMLUENG(gram: BigDecimal): BigDecimal {
    return BigDecimal(toTAMLUENG(gram.toDouble()))
  }
  fun toTAMLUENG(): Double {
    return toTAMLUENG(gram.toDouble())
  }

  fun toCHANG(gram: Double): Double {
    return gram / GRAM_PER_CHANG
  }
  fun toCHANG(gram: BigDecimal): BigDecimal {
    return BigDecimal(toCHANG(gram.toDouble()))
  }
  fun toCHANG(): Double {
    return toCHANG(gram.toDouble())
  }

  fun toHAP(gram: Double): Double {
    return gram / GRAM_PER_HAP
  }
  fun toHAP(gram: BigDecimal): BigDecimal {
    return BigDecimal(toHAP(gram.toDouble()))
  }
  fun toHAP(): Double {
    return toHAP(gram.toDouble())
  }

}


/*

^ *(.+)\t(.+)\t(.+)\t(.+)\t(.+)$
SALUENG	salueng	Salueng	สลึง	3.75
BAHT	baht	Baht	บาท	15
TAMLUENG	tamlueng	Tamlueng	ตำลึง	60
CHANG	chang	Chang	ชั่ง	1200
HAP	hap	Hap	หาบ	60000

^ *(.+)\t(.+)\t(.+)\t(.+)$
HAP	hap	Hap	หาบ
CHANG	chang	Chang	ชั่ง
TAMLUENG	tamlueng	Tamlueng	ตำลึง
BAHT	baht	Baht	บาท
SALUENG	salueng	Salueng	สลึง
 */
