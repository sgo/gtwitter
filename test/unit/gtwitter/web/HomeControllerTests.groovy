package gtwitter.web

import grails.test.GrailsUnitTestCase
import gtwitter.web.HomeController


class HomeControllerTests extends GrailsUnitTestCase{

    HomeController controller

    void setUp() {
        super.setUp()
        mockController HomeController
        controller = new HomeController()
    }

    private def assertRedirectToShowFor = {String id->
        assert controller.redirectArgs.controller == 'bird'
        assert controller.redirectArgs.action == 'show'
        assert controller.redirectArgs.id == id
    }

    void test_index_redirect_to_principal_home() {
        controller.session.principal = 'mockingbird'
        controller.index()
        assertRedirectToShowFor 'mockingbird'
    }

    void test_index_render_root() {
        controller.index()
        assert controller.renderArgs.view == '/index'
    }
}
