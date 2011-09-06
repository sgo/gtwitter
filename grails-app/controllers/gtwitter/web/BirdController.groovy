package gtwitter.web

import gtwitter.GTwitter.MyBird
import gtwitter.GTwitter

class BirdController {

    GTwitter twitter

    def show = {
        def bird = twitter.findBirdByName(params.id)
        [bird:bird.name, tweets:bird.tweets]
    }

    def create = {}

    def save = {
        twitter.registerBird(params.name)
        authenticate()
    }

    def signin = {}

    def authenticate = {
        session.principal = params.name
        redirect(action: show, id:params.name)
    }

    def tweet = {
        def msg = params.msg
        twitter.signin(session.principal) {MyBird bird->
            bird.tweet(msg)
        }
        redirect(action: show, id:session.principal)
    }

    def signout = {
        session.principal = null
        redirect(uri:'/')
    }
}
