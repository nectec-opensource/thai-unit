package nectec.thai.unit

import javafx.beans.binding.Bindings
import java.lang.StringBuilder

/**
 * Created by user on 11/7/2560.
 */
data class Length (val cm: Double) {


  val sok: Int

  init {
      var sok=cm/50

    this.sok=sok.toInt()
  }

  fun cmtoSok(): String {

    val stringBuilder = StringBuilder()
    return stringBuilder.append(sok).append(" ศอก").toString().trim()
  }

}
