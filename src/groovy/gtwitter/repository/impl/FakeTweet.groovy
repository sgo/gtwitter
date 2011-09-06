package gtwitter.repository.impl

import gtwitter.repository.Tweet

class FakeTweet implements Tweet, Comparable<FakeTweet> {

    private String msg
    private long millis

    FakeTweet(String msg, long millis) {
        this.msg = msg
        this.millis = millis
    }

    String getMsg() {msg}

    long getMillis() {millis}

    int compareTo(FakeTweet t) {
        return (millis <=> t.millis) * -1
    }
}
