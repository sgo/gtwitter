package gtwitter.repository.impl

import static gtwitter.util.DateTimeUtilities.*
import gtwitter.repository.Bird
import gtwitter.repository.exceptions.DuplicateTimestampException
import grails.validation.ValidationException

class PersistentBird implements Bird {

    static constraints = {
    }

    static hasMany = [tweets:PersistentTweet]

    String name

    SortedSet<PersistentTweet> tweets

    void tweet(String msg) {
        PersistentBird.withTransaction {
            def tweet = new PersistentTweet(msg: msg, millis: currentTimeMillis())
            addToTweets(tweet)
            save(failOnError:true)
            try {
                tweet.save(failOnError:true)
            } catch(ValidationException e) {
                if(uniqueMillisForBird(e))
                    throw new DuplicateTimestampException()
            }
        }
    }

    private def uniqueMillisForBird(ValidationException e) {
        def error = e.errors.fieldError
        error.field == 'millis' && error.code == 'unique'
    }
}
