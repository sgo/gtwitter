package gtwitter.repository.impl

import grails.test.GrailsUnitTestCase
import grails.validation.ValidationException


class PersistentTweetTests extends GrailsUnitTestCase {

    void setUp() {
        super.setUp()
        mockDomain PersistentTweet
    }

    void test_duplicate_millis() {
        shouldFail(ValidationException) {
            new PersistentTweet(msg:'msg', millis:1).save(failOnError:true)
            new PersistentTweet(msg:'msg', millis:1).save(failOnError:true)
        }
    }
}
