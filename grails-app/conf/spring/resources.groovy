import gtwitter.GTwitter
import gtwitter.repository.impl.GormBirdRepository

// Place your Spring DSL code here
beans = {

    birdRepository(GormBirdRepository)

    twitter(GTwitter, birdRepository)
}
