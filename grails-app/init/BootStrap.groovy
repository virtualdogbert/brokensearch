import security.Role
import security.User
import security.UserRole

class BootStrap {


    def init = { servletContext ->
        Role role = new Role(authority: 'ROLE_USER').save(flush: true, failOnError:true)
        User user = new User(username: 'test', password: "password").save(flush: true, failOnError:true)
        UserRole userRole=  UserRole.create(user, role, true)



    }
    def destroy = {
    }
}
