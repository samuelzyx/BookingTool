<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Booking tool</title>
</head>
<body>

<div class="svg" role="presentation">
    <div class="booking-logo-container">
        <a class="navbar-brand" href="/#">
            <asset:image src="booking-logo-white.svg" class="booking-logo"/>
        </a>
    </div>
</div>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>Welcome to Booking tool</h1>
        <p style="text-align: center;width: 100%;">
            <sec:ifNotLoggedIn>
                <g:link controller="login">Login</g:link>
            </sec:ifNotLoggedIn>
            <sec:ifLoggedIn>
                    Logged in as <b> <sec:username/></b>
                    <sec:ifAnyGranted roles='ROLE_ADMIN'>
                        ROLE ADMIN
                    </sec:ifAnyGranted>
                    <sec:ifAnyGranted roles='ROLE_USER'>
                        ROLE USER
                    </sec:ifAnyGranted>
                    <g:link controller="logout">Logout</g:link>
            </sec:ifLoggedIn>
        </p>


        <div id="controllers" role="navigation">
            <br>
            <p>
                Below is a list of controllers that are currently deployed in
                this application, click on each to execute its default action:
            </p>
            <h2>Available Controllers:</h2>
            <ul>
                <li class="controller">
                        CRUD <g:link controller="booking">Bookings</g:link>
                </li>
                <li class="controller">
                    CRUD <g:link controller="room">Rooms</g:link>
                </li>
                <!-- <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                    <li class="controller">
                        <g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link>
                    </li>
                </g:each> -->
            </ul>
            <br>
            <h2><g:link resource="presentation">Proposal Features</g:link></h2>
            <h2>Users created:</h2>
            <p>admin@tcs.com: admin123 <br>user@tcs.com: user123</p>
            <br>
            <h2>Available Features (V.2019.10.14.0.0.1):</h2>
            <ul>
                <li>CRUD booking</li>
                <li>CRUD rooms</li>
                <li>First user with ROLE_ADMIN created</li>
                <li>First user with ROLE_USER created</li>
                <li>Security restricted by ROLE_ADMIN, ROLE_USER</li>
                <li>Login/Logout</li>
            </ul>
            <br>
            <p style="text-align: center;">
                V.2019.10.14.0.0.1
            </p>
            <br>
        </div>
    </section>
</div>

</body>
</html>
