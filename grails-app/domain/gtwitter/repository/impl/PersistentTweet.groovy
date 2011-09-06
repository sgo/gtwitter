package gtwitter.repository.impl

import gtwitter.repository.Tweet

class PersistentTweet implements Tweet, Comparable<PersistentTweet> {

    static constraints = {
        millis unique:'bird'
    }

    static belongsTo = [bird:PersistentBird]

    String msg
    long millis

    int compareTo(PersistentTweet t) {
        return (millis <=> t.millis) * -1
    }
}
