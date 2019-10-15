package bookingtool

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes='email')
@ToString(includes='email', includeNames=true, includePackage=false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    String email
    String password
	String nombre
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    User(String email,
        String password,
        String nombre) {
		this()
		this.email = email
		this.password = password
		this.nombre = nombre
	}

    Set<Role> getAuthorities() {
        (UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
    }

    static constraints = {
        password nullable: false, blank: false, password: true
        email nullable: false, blank: false, unique: true, email: true
        nombre nullable: false, blank: false, unique: true
    }

    static hasMany = [
			rooms:Room,
			bookings:Booking
	]

    static mapping = {
	    password column: '`password`'
    }
}
