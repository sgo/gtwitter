package gtwitter.web

class HomeController {

    def index = {
        if(session.principal)
            redirect(controller:'bird', action:'show', id:session.principal)
        else
            render(view:'/index')
    }
}
