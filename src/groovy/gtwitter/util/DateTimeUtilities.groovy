package gtwitter.util


class DateTimeUtilities {

    private static long fixedCurrentTimeMillis

    static setFixedCurrentTimeMillis(long millis) {
        fixedCurrentTimeMillis = millis
    }

    static void stepMillis(int millis) {
        fixedCurrentTimeMillis = fixedCurrentTimeMillis + millis
    }

    static long currentTimeMillis() {
        fixedCurrentTimeMillis ?: System.currentTimeMillis()
    }
}
