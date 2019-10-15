package bookingtool

//Created by Samuel Seda 1741412

//This class is used by the users when need it to booking the space of time
//of some room

class Booking {
    String requestByEagleId
    String requestByName
    Date startTime //dd-mm-yyyy HH:mm
    Date endTime //dd-mm-yyyy HH:mm

    static belongsTo = [room:Room,owner:User]

    static constraints = {
    }
}
