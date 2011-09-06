package gtwitter.repository

interface BirdRepository {

    BirdRepository leftShift(String name)

    Bird findByName(String name)
}
