package test

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional
import parts.Part

@Secured(['ROLE_USER'])
@Transactional
class TestController {


    def index() {
        Part part = new Part(name: "testPart").save(flush: true, failOnError: true)

        render 'Index part created'
    }

    def search() {
        def search = Part.search([from: 0, size: 10], {
            bool {
                must {
                    query_string(query: "name:*${'test'}*")
                }
            }
        })

        render search as JSON
    }

    def delete() {
        Part.get(1).delete(flush: true)
    }
}