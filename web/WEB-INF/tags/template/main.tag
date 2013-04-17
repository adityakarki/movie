<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Main template" pageEncoding="UTF-8" %>
<%@ attribute name="head" fragment="true" %>
<%@ attribute name="header" fragment="true" %>
<%@ attribute name="nav" fragment="true" %>
<%@ attribute name="footer" fragment="true" %>
<%@ attribute name="title" rtexprvalue="true" %>


<!DOCTYPE html>
<!--[if IE 8]> <html class="no-js lt-ie9" lang="en" > <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="en"> <!--<![endif]-->

<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width"/>
    <link href="${pageContext.request.contextPath}/resources/css/foundation.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/normalize.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/resources/js/vendor/custom.modernizr.js"></script>
    <title>Movie<c:if test="${not empty title}">-${title}</c:if></title>
    <jsp:invoke fragment="head"/>
    <style>
        body {
            padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
        }

        .main-container {
            min-height: 440px;
        }
    </style>
</head>


<body>
<div class="main-container">

    <div id="nav">

        <jsp:invoke fragment="nav"/>

    </div>

    <div id="pageheader">
        <jsp:invoke fragment="header"/>

    </div>

    <div id="body">

        <jsp:doBody/>

    </div>

</div>

<div id="pagefooter">

    <footer class="footer">
        <div class="container">
            <p>
                <jsp:invoke fragment="footer"/>
            </p>

            <p> Movies
                <jsp:useBean id="date" class="java.util.Date"/>
                <fmt:formatDate value="${date}" pattern="yyyy"/>
            </p>
        </div>
    </footer>

</div>

<script src="${pageContext.request.contextPath}/resources/js/foundation.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/vendor/jquery.js"></script>
<!--

<script src="js/foundation/foundation.js"></script>

<script src="js/foundation/foundation.dropdown.js"></script>

<script src="js/foundation/foundation.placeholder.js"></script>

<script src="js/foundation/foundation.forms.js"></script>

<script src="js/foundation/foundation.alerts.js"></script>

<script src="js/foundation/foundation.magellan.js"></script>

<script src="js/foundation/foundation.reveal.js"></script>

<script src="js/foundation/foundation.tooltips.js"></script>

<script src="js/foundation/foundation.clearing.js"></script>

<script src="js/foundation/foundation.cookie.js"></script>

<script src="js/foundation/foundation.joyride.js"></script>

<script src="js/foundation/foundation.orbit.js"></script>

<script src="js/foundation/foundation.section.js"></script>

<script src="js/foundation/foundation.topbar.js"></script>

-->

<script>
    $(document).foundation();
</script>
</body>
</html>