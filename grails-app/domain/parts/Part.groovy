package parts

import base.BaseDomainClass

class Part extends BaseDomainClass {
    String name

    static constraints = {

    }

    static searchable = {
        except = ['springSecurityService']
        creator reference: true, parent: true
        updatedBy reference: true, parent: true
    }
}
