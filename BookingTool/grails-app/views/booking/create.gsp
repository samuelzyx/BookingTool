<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'booking.label', default: 'Booking')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#create-booking" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="create-booking" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.booking}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.booking}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.booking}" method="POST">
                <fieldset class="form">
                    <div class="fieldcontain required">
                        <label for="requestByName">Request By Name
                            <span class="required-indicator">*</span>
                        </label>
                        <input type="text" name="requestByName" value="" required="" id="requestByName">
                    </div>
                    <div class="fieldcontain required">
                        <label for="requestByEagleId">Request By EAGLE ID
                            <span class="required-indicator">*</span>
                        </label>
                        <input type="text" name="requestByEagleId" value="" required="" id="requestByEagleId">
                    </div>
                    <div class="fieldcontain required">
                        <label for="room">Room
                            <span class="required-indicator">*</span>
                        </label>
                        <g:select name="room" from="${bookingtool.Room.list()}" value="${booking?.room?.id}" optionKey="id" optionValue="name"/>
                    </div>
                    <div class="fieldcontain required">
                        <label for="startTime">Start Time
                            <span class="required-indicator">*</span>
                        </label>
                        <g:datePicker name="startTime" value="${new Date()}" precision="minute"/>
                    </div>
                    <div class="fieldcontain required">
                        <label for="endTime">End Time
                            <span class="required-indicator">*</span>
                        </label>
                        <g:datePicker name="endTime" value="${new Date()}" precision="minute" />
                    </div>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
