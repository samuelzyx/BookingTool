package bookingtool

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

class BookingController {

    BookingService bookingService
    def springSecurityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured('permitAll')
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond bookingService.list(params), model:[bookingCount: bookingService.count()]
    }

    @Secured('permitAll')
    def show(Long id) {
        respond bookingService.get(id)
    }

    @Secured(['permitAll'])
    def create() {
        respond new Booking(params)
    }

    @Secured(['permitAll'])
    def save(Booking booking) {
        if (booking == null) {
            notFound()
            return
        }

        def user = springSecurityService.currentUser

        booking.room = Room.get(params.room)
        booking.owner = user

        try {
            //Validate if endTime is greater of startTime
            if(booking.startTime.time >= booking.endTime.time){
                flash.error = "End Time es menor o igual que Start Time"
                booking.errors = null
                respond booking, view: 'create'
                return
            }


            //Validate if exist one booking at the same time / same room
            def searching = Booking.findAllByRoomAndStartTimeBetween(booking.room, booking.startTime, booking.endTime);
            if(searching){
                flash.error = message(code: 'default.duplicated.message', args: [message(code: 'booking.label', default: 'Booking'), params.id])
                booking.errors = null
                respond booking, view: 'create'
                return
            }

            bookingService.save(booking)
        } catch (ValidationException e) {
            respond booking.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'booking.label', default: 'Booking'), booking.id])
                redirect booking
            }
            '*' { respond booking, [status: CREATED] }
        }
    }

    @Secured(['permitAll'])
    def edit(Long id) {
        respond bookingService.get(id)
    }

    @Secured(['permitAll'])
    def update(Booking booking) {
        if (booking == null) {
            notFound()
            return
        }

        try {
            bookingService.save(booking)
        } catch (ValidationException e) {
            respond booking.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'booking.label', default: 'Booking'), booking.id])
                redirect booking
            }
            '*'{ respond booking, [status: OK] }
        }
    }

    @Secured(['permitAll'])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        bookingService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'booking.label', default: 'Booking'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'booking.label', default: 'Booking'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
