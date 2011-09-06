package gtwitter.repository.impl

import gtwitter.repository.exceptions.BirdNotFoundException
import gtwitter.repository.BirdRepository

import gtwitter.repository.Bird

class GormBirdRepository implements BirdRepository {
    BirdRepository leftShift(String name) {
        new PersistentBird(name:name).save(failOnError:true)
        return this
    }

    Bird findByName(String name) {
        def bird = PersistentBird.findByName(name)
        if(bird) return bird
        throw new BirdNotFoundException()
    }
}
