<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'booking.label', default: 'Booking')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-booking" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="list-booking" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <table>
                <thead>
                     <tr>
                         <g:sortableColumn property="id" title="ID" />
                         <g:sortableColumn property="requestByEagleId" title="Request By EagleId" />
                         <g:sortableColumn property="requestByName" title="Request By Name" />
                         <g:sortableColumn property="owner?.email" title="Owner email" />
                         <g:sortableColumn property="room?.name" title="Room" />
                         <g:sortableColumn property="startTime" title="Start Time" />
                         <g:sortableColumn property="startTime" title="End Time" />
                    </tr>
                </thead>
                <tbody>
                    <g:each status="i" in="${bookingList}" var="booking">
                    <!-- Alternate CSS classes for the rows. -->
                    <tr class="${ (i % 2) == 0 ? 'a' : 'b'}">
                      <td>${booking.id?.encodeAsHTML()}</td>
                      <td>
                          <g:link action="show" id="${booking.id}">${booking.requestByEagleId?.encodeAsHTML()}</g:link>
                      </td>
                      <td>${booking.requestByName?.encodeAsHTML()}</td>
                      <td>${booking.owner?.email?.encodeAsHTML()}</td>
                      <td>${booking.room?.name?.encodeAsHTML()}</td>
                      <td>
                          <g:formatDate format="HH:mm dd-MM-yyyy" date="${booking.startTime}"/>
                      </td>
                      <td>
                          <g:formatDate format="HH:mm dd-MM-yyyy" date="${booking.endTime}"/>
                      </td>
                    </tr>
                    </g:each>
                </tbody>
            </table>
            <!-- <f:table collection="${bookingList}" /> -->

            <div class="pagination">
                <g:paginate total="${bookingCount ?: 0}" />
            </div>
        </div>
    </body>
</html>
