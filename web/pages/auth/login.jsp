<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="movie" uri="http://pramodbhandari.com" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Sign in &middot; Movies</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <movie:background/>

    <style type="text/css">
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            /*background:transparent !important;*/
        }

        <%--html {--%>
        <%--background: url("${pageContext.request.contextPath}/resources/img/login_page_1.jpg") no-repeat center center fixed; -webkit-background-size: cover;--%>
            <%---moz-background-size: cover;--%>
            <%---o-background-size: cover;--%>
            <%--background-size: cover;--%>
        <%--}--%>

        .form-signin {
            max-width: 400px;
            padding: 19px 29px 29px;
            background: rgba(240, 240, 240, .7);
            margin: 0 auto 20px;
            border: 1px solid #e5e5e5;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            text-decoration-color: black;

        }

        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }

        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }
        .form-signin a {
            color: #008AE6;
        }

    </style>
    <link href="${pageContext.request.contextPath}/resources/css/foundation.css" rel="stylesheet">




</head>
<body>

<div class="row">
    <div class="large-5 large-centered columns ">
        <div class="">

            <form class="form-signin" action="login" method="POST">
                <h3 class="form-signin-heading">Please log in</h3>
                <hr/>
                <input name="username" type="text" class="input-block-level" placeholder="Username">
                <input name="password" type="password" class="input-block-level" placeholder="Password">
                <label class="checkbox">
                    <input name="remember" type="checkbox" value="true"> Remember me
                </label>
                <button class="btn btn-large btn-primary" type="submit">Log in</button>


                <a href="<c:url value="/auth/signup"/>">Forgot Password</a>

                <div>
                    Don't have an account?
                    <a href="<c:url value="/auth/signup"/>">Signup</a>
                </div>
            </form>

        </div>

    </div>

</div>

</body>
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
</body>
</html>