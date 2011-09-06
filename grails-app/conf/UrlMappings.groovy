class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

        "/$id"(controller:'bird', action:'show')

		"/"(controller:'home', action:'index')
		"500"(view:'/error')
	}
}
