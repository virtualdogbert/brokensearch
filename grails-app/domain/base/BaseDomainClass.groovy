package base
import security.User
import grails.plugin.springsecurity.SpringSecurityService

public abstract class BaseDomainClass {

    SpringSecurityService springSecurityService

    Date dateCreated
    Date lastUpdated
    User creator
    User updatedBy

    static transients = [
            'springSecurityService',
    ]

    static constraints = {
        dateCreated(nullable: true)
        lastUpdated(nullable: true)
        creator(nullable: true)
        updatedBy(nullable: true)
    }

    def beforeInsert() {
        if (springSecurityService?.isLoggedIn()) {
            creator = springSecurityService.loadCurrentUser()
        }
    }

    def beforeUpdate() {
        if (springSecurityService?.isLoggedIn()) {
            updatedBy = springSecurityService.loadCurrentUser()
        } else {
            updatedBy = null
        }
    }

}
