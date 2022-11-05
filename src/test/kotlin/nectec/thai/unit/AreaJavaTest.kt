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

import org.junit.Assert
import org.junit.Test

class AreaJavaTest {
    @Test
    fun name() {
        val area = Area(1600).copy(3200.0)
        Assert.assertEquals(2, area.rai.toLong())
    }
}
