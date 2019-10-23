<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'room.label', default: 'Room')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-room" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="list-room" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <table>
                <thead>
                     <tr>
                         <g:sortableColumn property="id" title="ID" />
                         <g:sortableColumn property="name" title="Name" />
                         <g:sortableColumn property="cretedBy" title="Creted By" />
                         <g:sortableColumn property="dateCreation" title="Date Creation" />
                    </tr>
                </thead>
                <tbody>
                    <g:each status="i" in="${roomList}" var="room">
                    <!-- Alternate CSS classes for the rows. -->
                    <tr class="${ (i % 2) == 0 ? 'a' : 'b'}">
                      <td>${room.id?.encodeAsHTML()}</td>
                      <td>
                          <g:link action="show" id="${room.id}">${room.name?.encodeAsHTML()}</g:link>
                      </td>
                      <td>${room.cretedBy?.email?.encodeAsHTML()}</td>
                      <td>
                          <g:formatDate format="dd-MM-yyyy" date="${room.dateCreation}"/>
                      </td>
                    </tr>
                    </g:each>
                </tbody>
            </table>
            <!-- <f:table collection="${roomList}" properties="name, cretedBy, dateCreation"/> -->

            <div class="pagination">
                <g:paginate total="${roomCount ?: 0}" />
            </div>
        </div>
    </body>
</html>
