package gtwitter

import static java.util.Collections.*
import gtwitter.repository.BirdRepository
import gtwitter.repository.Tweet

import gtwitter.repository.impl.FakeBirdRepository
import gtwitter.repository.Bird

class GTwitter {

    private BirdRepository repository = new FakeBirdRepository()

    GTwitter() {
    }

    GTwitter(BirdRepository repository) {
        this.repository = repository
    }

    void registerBird(String name) {
        repository << name
    }

    ReadonlyBird findBirdByName(String name) {
        return new ReadonlyBird(signin(name))
    }

    MyBird signin(String name) {
        new MyBird(repository.findByName(name))
    }

    void signin(String name, Closure cl) {
        def bird = signin(name)
        bird.with(cl)
    }

    static class ReadonlyBird {

        private MyBird bird

        ReadonlyBird(MyBird bird) {
            this.bird = bird
        }

        String getName() {bird.name}

        SortedSet<Tweet> getTweets() {bird.tweets}
    }

    static class MyBird {

        private Bird bird

        MyBird(Bird bird) {
            this.bird = bird
        }

        String getName() {bird.name}

        void tweet(String msg) {
            bird.tweet(msg)
        }

        SortedSet<Tweet> getTweets() {
            unmodifiableSortedSet(bird.tweets)
        }
    }
}
