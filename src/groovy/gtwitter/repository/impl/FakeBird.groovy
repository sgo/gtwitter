package gtwitter.repository.impl

import static gtwitter.util.DateTimeUtilities.*
import gtwitter.repository.exceptions.DuplicateTimestampException

import gtwitter.repository.Bird

class FakeBird implements Bird {

    String name
    SortedSet<FakeTweet> tweets = [] as SortedSet

    void tweet(String msg) {
        def tweet = new FakeTweet(msg, currentTimeMillis())
        if(tweet in tweets) throw new DuplicateTimestampException()
        tweets << tweet
    }
}
