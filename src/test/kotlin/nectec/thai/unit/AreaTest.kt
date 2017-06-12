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

import com.google.gson.Gson
import org.junit.Test
import kotlin.test.assertEquals

class AreaTest {

    val area = Area(1600)

    @Test fun getRai() {
        assertEquals(1, area.rai)
    }

    @Test fun getNgan() {
        assertEquals(0, area.ngan)
    }

    @Test fun getSquareWa() {
        assertEquals(0, area.squareWa)
    }

    @Test fun getSquareMetre() {
        assertEquals(1600, area.squareMetre)
    }

    @Test fun formalPrint() {
        assertEquals("1 ไร่", Area.from(1, 0, 0).formalPrint());
        assertEquals("2 งาน", Area.from(0, 2, 0).formalPrint());
        assertEquals("1 ตารางวา", Area.from(0, 0, 1).formalPrint());
        assertEquals("1 ไร่ 99 ตารางวา", Area.from(0, 0, 499).formalPrint());
        assertEquals("2 ไร่ 3 งาน 99 ตารางวา", Area.from(0, 7, 499).formalPrint());
    }

    @Test fun prettyPrint() {
        assertEquals("1-0-0 ไร่", Area.from(1, 0, 0).prettyPrint());
        assertEquals("0-2-0 ไร่", Area.from(0, 2, 0).prettyPrint());
        assertEquals("0-0-1 ไร่", Area.from(0, 0, 1).prettyPrint());
        assertEquals("1-0-99 ไร่", Area.from(0, 0, 499).prettyPrint());
        assertEquals("2-3-99 ไร่", Area.from(0, 7, 499).prettyPrint());
    }

    @Test fun rounding() {
        val ex1 = Area(2400)
        assertEquals(1, ex1.rai)
        assertEquals(2, ex1.ngan)
        assertEquals(0, ex1.squareWa)

        val ex2 = Area(1599)
        assertEquals(1, ex2.rai)
        assertEquals(0, ex2.ngan)
        assertEquals(0, ex2.squareWa)

        val ex3 = Area(1605)
        assertEquals(1, ex3.rai)
        assertEquals(0, ex3.ngan)
        assertEquals(1, ex3.squareWa)

        val ex4 = Area(1601)
        assertEquals(1, ex4.rai)
        assertEquals(0, ex4.ngan)
        assertEquals(0, ex4.squareWa)
    }

    @Test fun gsonToJson() {
        assertEquals("{\"rai\":1,\"ngan\":0,\"squareWa\":0,\"squareMetre\":1600}",
                Gson().toJson(Area(1600)))
    }

    @Test fun gsonFromJson() {
        val area = Gson().fromJson("{\"rai\":1,\"ngan\":0,\"squareWa\":0,\"squareMetre\":1600}",
                Area::class.java)
        assertEquals(1, area.rai)
    }

    @Test fun equal() {
        assertEquals(Area.from(1, 0, 0), area);
        assertEquals(Area.from(0, 0, 67), Area(268))
    }
}
