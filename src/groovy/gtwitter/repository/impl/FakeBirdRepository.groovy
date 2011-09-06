package gtwitter.repository.impl

import gtwitter.repository.exceptions.BirdNotFoundException
import gtwitter.repository.BirdRepository

import gtwitter.repository.Bird

class FakeBirdRepository implements BirdRepository {

    private def birds = [] as Set<Bird>

    @Override BirdRepository leftShift(String name) {
        def bird = new FakeBird(name: name)
        birds << bird
        return this
    }

    Bird findByName(String name) {
        def bird = birds.find {it.name == name}
        if(bird) return bird
        else throw new BirdNotFoundException()
    }
}
