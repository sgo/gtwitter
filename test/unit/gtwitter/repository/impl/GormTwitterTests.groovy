package gtwitter.repository.impl

import gtwitter.GTwitter
import gtwitter.GTwitterTests

class GormTwitterTests extends GTwitterTests {

    def gtwitter() {
        mockDomain PersistentBird
        mockDomain PersistentTweet

        PersistentBird.metaClass.static.withTransaction = {Closure c-> c()}

        new GTwitter(repository: new GormBirdRepository())
    }

    void tearDown() {
        super.tearDown()
        GroovySystem.metaClassRegistry.removeMetaClass PersistentBird
    }
}
