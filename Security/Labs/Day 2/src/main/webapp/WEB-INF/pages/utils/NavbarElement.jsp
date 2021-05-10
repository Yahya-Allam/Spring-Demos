<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01"
            aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">

            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse-navabar-collapse" id="navbarTogglerDemo01">
            <a class="navbar-brand" href="#">Spring security</a>
            <ul class="navbar-nav mr-auto mt-2 mt-lg-8">
                <li class="nav-item active">
                    <a class="nav-link" href="/security/">Home Page</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/security/products">Products</a>
                </li>

                <sec:authorize access="hasRole('ROLE_USER')">
                    <li class="nav-item">
                        <a class="nav-link" href="/security/user/profile">Profile</a>
                    </li>
                </sec:authorize>

                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <li class="nav-item">
                        <a class="nav-link" href="/security/admin/dashboard">Dashboard</a>
                    </li>
                </sec:authorize>

                <sec:authorize access="!isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="/security/login">Login</a>
                    </li>
                </sec:authorize>

                <sec:authorize access="isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="/security/logout">Logout</a>
                    </li>
                </sec:authorize>

            </ul>
        </div>
    </nav>
</header>