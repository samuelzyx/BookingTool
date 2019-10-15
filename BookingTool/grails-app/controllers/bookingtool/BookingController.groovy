package bookingtool

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class BookingController {

    BookingService bookingService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond bookingService.list(params), model:[bookingCount: bookingService.count()]
    }

    def show(Long id) {
        respond bookingService.get(id)
    }

    def create() {
        respond new Booking(params)
    }

    def save(Booking booking) {
        if (booking == null) {
            notFound()
            return
        }

        try {
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

    def edit(Long id) {
        respond bookingService.get(id)
    }

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
