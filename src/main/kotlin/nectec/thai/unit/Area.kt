package nectec.thai.unit

import java.lang.StringBuilder

class Area(val squareMetre: Int) {

  val rai: Int
  val ngan: Int
  val squareWa: Int

  init {
    var rai = squareMetreToRai(squareMetre)
    var ngan = squareMetreToNgan(squareMetre)
    var squareWa = squareMetreToSquareWa(squareMetre)

    if (squareWa == 100) {
      ngan++
      squareWa = 0
    }
    if (ngan == 4) {
      rai++
      ngan = 0
    }

    this.rai = rai
    this.ngan = ngan
    this.squareWa = squareWa
  }

  fun formalPrint(): String {
    val stringBuilder = StringBuilder()
    if (rai > 0) {
      stringBuilder.append(rai).append(' ').append(RAI)
    }
    if (ngan > 0) {
      stringBuilder.append(' ').append(ngan).append(' ').append(NGAN)
    }
    if (squareWa > 0) {
      stringBuilder.append(' ').append(squareWa).append(' ').append(SQUARE_WA)
    }
    return stringBuilder.toString().trim()
  }

  fun prettyPrint(): String {
    return StringBuilder().append(rai).append('-').append(ngan).append('-').append(squareWa).append(" ไร่").toString()
  }

  private fun squareMetreToRai(squareMeter: Int): Int {
    return squareMeter / SQUARE_METRE_PER_RAI
  }

  private fun squareMetreToNgan(squareMeter: Int): Int {
    return squareMeter % SQUARE_METRE_PER_RAI / SQUARE_METRE_PER_NGAN
  }

  private fun squareMetreToSquareWa(squareMeter: Int): Int {
    val squareWa = squareMeter % SQUARE_METRE_PER_NGAN / SQUARE_METRE_PER_SQUARE_WA
    return Math.round(squareWa)
  }

  companion object {
    val SQUARE_METRE_PER_RAI = 1600
    val SQUARE_METRE_PER_NGAN = 400
    val SQUARE_METRE_PER_SQUARE_WA = 4f
    val RAI = "ไร่"
    val NGAN = "งาน"
    val SQUARE_WA = "ตารางวา"

    fun from(rai: Int, ngan: Int, squareWa: Int): Area {
      return Area(RaiToSqMeter(rai, ngan, squareWa))
    }

    private fun RaiToSqMeter(rai: Int, ngan: Int, squareWa: Int): Int {
      val sqMeter = (rai * SQUARE_METRE_PER_RAI).toFloat() + (ngan * SQUARE_METRE_PER_NGAN).toFloat() + squareWa * SQUARE_METRE_PER_SQUARE_WA
      return Math.round(sqMeter)
    }
  }
}