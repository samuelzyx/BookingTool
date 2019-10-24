package bookingtool

//Created by Samuel Seda 1741412

//This class it was created with the finallity of initializer the registers in
//DB

import grails.util.Environment

class BootStrap {

    def init = { servletContext ->

        //if (
        //Environment.current == Environment.DEVELOPMENT
    //                ||Environment.current == Environment.TEST
        //) {
            Role RoleAdmin = new Role("ROLE_ADMIN").save()
            Role RoleUser = new Role("ROLE_USER").save()

            User AdminAccount = new User("admin@tcs.com", "admin123","Nombre Admin").save()
            UserRole.create(AdminAccount, RoleAdmin, true)

            User UserAccount = new User("user@tcs.com", "user123","Nombre User").save()
            UserRole.create(UserAccount, RoleUser, true)

            Room room = new Room("Chennai", new Date())
            room.setCretedBy(AdminAccount)
            room.save(flush: true)

            room = new Room("New Delhi", new Date())
            room.setCretedBy(AdminAccount)
            room.save(flush: true)

            room = new Room("Tequila", new Date())
            room.setCretedBy(AdminAccount)
            room.save(flush: true)
        //}
    }
    def destroy = {
    }
}
