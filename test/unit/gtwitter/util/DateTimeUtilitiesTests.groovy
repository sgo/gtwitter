package gtwitter.util

import static gtwitter.util.DateTimeUtilities.*
import org.junit.*

class DateTimeUtilitiesTests {

    @Test void current_time_millis_is_system_millis() {
        fixedCurrentTimeMillis = 0
        assert DateTimeUtilities.currentTimeMillis() == System.currentTimeMillis()
    }

    @Test void current_time_millis_is_fixed() {
        fixedCurrentTimeMillis = 5
        assert DateTimeUtilities.currentTimeMillis() == 5
    }
}
