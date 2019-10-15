package bookingtool

//Created by Samuel Seda 1741412

//This class is used by the users when need it to crate a new room


class Room {
    String name
    User cretedBy
    Date dateCreation

    Room(String name,
         Date dateCreation) {
        this()
        this.name = name
        this.dateCreation = dateCreation
    }

    static constraints = {
    }
}
