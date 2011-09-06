package gtwitter.web

import grails.test.*

import static gtwitter.util.DateTimeUtilities.*

import gtwitter.GTwitter.MyBird
import gtwitter.repository.Tweet
import gtwitter.repository.impl.FakeTweet

import gtwitter.GTwitter

class BirdControllerTests extends GrailsUnitTestCase {

    def twitter = new GTwitter()
    BirdController controller

    @Override
    protected void setUp() {
        super.setUp()

        mockController BirdController
        controller = new BirdController(twitter:twitter)
    }

    private def setupTwitterFor(Map<String, Object> expected) {
        twitter.registerBird(expected.bird)
        twitter.signin(expected.bird) {MyBird bird ->
            expected.tweets.each {Tweet tweet ->
                fixedCurrentTimeMillis = tweet.millis
                bird.tweet(tweet.msg)
            }
        }
    }

    private def callShowAction(name) {
        controller.params.id = name
        controller.show()
    }

    private def assertRedirectToShowFor = {String id->
        assert controller.redirectArgs.action == controller.show
        assert controller.redirectArgs.id == id
    }

    private def assertAuthenticated(String bird) {
        assert controller.session.principal == bird
    }

    void test_show_action_for_mockingbird() {
        def expected = [
                bird:'mockingbird',
                tweets:[new FakeTweet('mocking', 1), new FakeTweet('bird', 2)] as SortedSet
        ]

        setupTwitterFor expected
        def model = callShowAction(expected.bird)
        assert model == expected
    }

    void test_show_action_for_humming_bird() {
        def expected = [
                bird:'hummingbird',
                tweets:[new FakeTweet('humming', 1), new FakeTweet('bird', 2)] as SortedSet
        ]

        setupTwitterFor expected
        def model = callShowAction(expected.bird)
        assert model == expected
    }

    void test_create_action() {
        controller.create()
    }

    void test_save_action() {
        controller.params.name = 'mockingbird'

        controller.save()

        assertRedirectToShowFor 'mockingbird'
        assert twitter.findBirdByName('mockingbird')
        assertAuthenticated 'mockingbird'
    }

    void test_signin_action() {
        controller.signin()
    }

    void test_authenticate_action() {
        controller.params.name = 'mockingbird'

        controller.authenticate()

        assertRedirectToShowFor 'mockingbird'
        assertAuthenticated 'mockingbird'
    }

    void test_signout() {
        controller.session.principal = 'mockingbird'

        controller.signout()

        assert !controller.session.principal
        assert controller.redirectArgs.uri == '/'
    }

    void test_tweet_action() {
        setupTwitterFor(bird:'mockingbird', tweets:[])
        controller.session.principal = 'mockingbird'
        controller.params.msg = 'chip chip'

        controller.tweet()

        assertRedirectToShowFor 'mockingbird'
        assert controller.session.principal == 'mockingbird'
        assert twitter.findBirdByName('mockingbird').tweets*.msg == ['chip chip']
    }
}
