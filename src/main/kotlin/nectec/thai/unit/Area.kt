/*
 * Copyright © 2017 NECTEC
 *   National Electronics and Computer Technology Center, Thailand
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nectec.thai.unit

import java.lang.StringBuilder

data class Area(val squareMetre: Double) {

  constructor(squareMetre: Int) : this(squareMetre.toDouble())

  constructor(rai: Int, ngan: Int, squareWa: Double) : this(toMetre(rai, ngan, squareWa))

  constructor(rai: Int, ngan: Int, squareWa: Int) : this(toMetre(rai, ngan, squareWa.toDouble()))

  val rai: Int
  val ngan: Int
  val squareWa: Double

  init {
    var rai = squareMetreToRai(squareMetre)
    var ngan = squareMetreToNgan(squareMetre)
    var squareWa = squareMetreToSquareWa(squareMetre)

    if (squareWa == 100.0) {
      ngan++
      squareWa = 0.0
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
      stringBuilder.append(' ').append(squareWa.round()).append(' ').append(SQUARE_WA)
    }
    return stringBuilder.toString().trim()
  }

  fun prettyPrint(): String {
    return String.format("%d-%d-%s ไร่", rai, ngan, squareWa.round())
  }

  private fun squareMetreToRai(squareMeter: Double): Int {
    return (squareMeter / SQUARE_METRE_PER_RAI).toInt()
  }

  private fun squareMetreToNgan(squareMeter: Double): Int {
    return (squareMeter % SQUARE_METRE_PER_RAI / SQUARE_METRE_PER_NGAN).toInt()
  }

  private fun squareMetreToSquareWa(squareMeter: Double): Double {
    return squareMeter % SQUARE_METRE_PER_NGAN / SQUARE_METRE_PER_SQUARE_WA
  }

  companion object {
    @JvmField val SQUARE_METRE_PER_RAI = 1600
    @JvmField val SQUARE_METRE_PER_NGAN = 400
    @JvmField val SQUARE_METRE_PER_SQUARE_WA = 4.0
    @JvmField val RAI = "ไร่"
    @JvmField val NGAN = "งาน"
    @JvmField val SQUARE_WA = "ตารางวา"

    private fun toMetre(rai: Int, ngan: Int, squareWa: Double): Double {
      return (rai * SQUARE_METRE_PER_RAI).toDouble() + (ngan * SQUARE_METRE_PER_NGAN).toDouble() + (squareWa * SQUARE_METRE_PER_SQUARE_WA)
    }
  }

  fun Double.round(): Any {
    return if (this == Math.floor(this)) this.toInt() else this.toString()
  }

}
