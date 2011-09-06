package gtwitter

import static gtwitter.util.DateTimeUtilities.*

import static java.lang.System.*

import gtwitter.GTwitter.MyBird
import grails.test.GrailsUnitTestCase
import gtwitter.repository.exceptions.BirdNotFoundException
import gtwitter.repository.exceptions.DuplicateTimestampException
import gtwitter.GTwitter

class GTwitterTests extends GrailsUnitTestCase {

    GTwitter twitter

    def gtwitter() {new GTwitter()}

    void setUp() {
        super.setUp()
        twitter = gtwitter()
        fixedCurrentTimeMillis = currentTimeMillis()
    }

    protected def withBird(String name, Closure cl) {
        twitter.registerBird(name)
        twitter.signin(name, cl)
    }

    void test_find_bird_by_name() {
        twitter.registerBird('mockingbird')
        twitter.registerBird('hummingbird')
        assert twitter.findBirdByName('mockingbird').name == 'mockingbird'
        assert twitter.findBirdByName('hummingbird').name == 'hummingbird'
    }

    void test_signin_fails() {
        shouldFail(BirdNotFoundException) {
            twitter.signin('mockingbird')
        }
    }

    void test_signin() {
        withBird('mockingbird') {MyBird bird ->
            assert bird.name == 'mockingbird'
        }
    }

    void test_a_bird_can_tweet() {
        withBird('mockingbird') {MyBird bird ->
            bird.tweet('mock')
        }
    }

    void test_one_tweet_on_timeline() {
        withBird('mockingbird') {MyBird bird ->
            bird.tweet('mock')
            assert bird.tweets*.msg == ['mock']
        }
    }

    void test_two_same_tweets_on_timeline() {
        withBird('mockingbird') {MyBird bird ->
            bird.tweet('mock')
            stepMillis(1)
            bird.tweet('mock')
            assert bird.tweets*.msg == ['mock', 'mock']
        }
    }

    void test_two_different_tweets_on_timeline() {
        withBird('mockingbird') {MyBird bird ->
            bird.tweet('bird')
            stepMillis(1)
            bird.tweet('mocking')
            assert bird.tweets*.msg == ['mocking', 'bird']
        }
    }

    void test_on_same_millis() {
        shouldFail(DuplicateTimestampException) {
            withBird('mockingbird') {MyBird bird ->
                bird.tweet('mocking')
                bird.tweet('bird')
            }
        }
    }

    void test_on_same_millis_for_different_birds() {
        withBird('mockingbird') {MyBird bird ->
            bird.tweet('mock')
        }
        withBird('hummingbird') {MyBird bird ->
            bird.tweet('hum')
        }
    }

    void test_tweets_are_bird_specific() {
        withBird('mockingbird') {MyBird mockingBird->
            withBird('hummingbird') {MyBird hummingBird->
                mockingBird.tweet('mock')
                hummingBird.tweet('hum')
                assert mockingBird.tweets*.msg != hummingBird.tweets*.msg
            }
        }
    }

    void test_can_see_tweets_without_signin() {
        withBird('mockingbird') {MyBird bird->
            bird.tweet('mock')
        }

        assert twitter.findBirdByName('mockingbird').tweets*.msg == ['mock']
    }
}
