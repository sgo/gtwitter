package gtwitter.repository


interface Bird {
    String getName()

    SortedSet<Tweet> getTweets()

    void tweet(String msg)
}
