<%@ include file="../../includes/header.jsp" %>


<div class="container main-container">

    <div class="row">
        <div class="span8">

            <form class="form-horizontal" id="signup" method='post' action="signup">
                <fieldset>

                    <legend>Registration</legend>

                    <div class="control-group">
                        <label class="control-label">First Name</label>
                        <div class="controls">
                            <input type="text" class="input-xlarge" id="firstname" name="firstname" value="${firstname}"  >
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label">Last Name</label>
                        <div class="controls">
                            <input type="text" class="input-xlarge" id="lastname" name="lastname" value="${lastname}"  >
                        </div>
                    </div>


                    <div class="control-group">
                        <label class="control-label">Username</label>
                        <div class="controls">
                            <input type="text" class="input-xlarge" id="username" name="username" value="${username}" >
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label">Password</label>
                        <div class="controls">
                            <input type="password" class="input-xlarge" id="password" name="password" >
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label">Re-Password</label>
                        <div class="controls">
                            <input type="password" class="input-xlarge" id="repassword" name="repassword" >
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label"></label>
                        <div class="controls">
                            <button type="submit" class="btn btn-success" >Create Account</button>
                        </div>
                    </div>

                </fieldset>
            </form>



        </div>
    </div>



    <%--<div>--%>
        <%--<form class="form-horizontal" action="add" method="POST">--%>
            <%--<div class="control-group">--%>
                <%--<label class="control-label" for="firstName">First Name</label>--%>

                <%--<div class="controls">--%>
                    <%--<input type="text" name="firstName" id="firstName" placeholder="First Name">--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="control-group">--%>
                <%--<label class="control-label" for="lastName">Last Name</label>--%>

                <%--<div class="controls">--%>
                    <%--<input type="text" name="lastName" id="lastName" placeholder="Last Name">--%>
                <%--</div>--%>
            <%--</div>--%>

            <%--<div class="control-group">--%>
                <%--<label class="control-label" for="username">Username</label>--%>

                <%--<div class="controls">--%>
                    <%--<input type="text" name="username" id="username" placeholder="Username">--%>
                    <%--<label class="">Validation</label>--%>
                <%--</div>--%>
            <%--</div>--%>

            <%--<div class="control-group">--%>
                <%--<label class="control-label" for="password">Password</label>--%>

                <%--<div class="controls">--%>
                    <%--<input type="password" name="password" id="password" placeholder="Password">--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="control-group">--%>
                <%--<label class="control-label" for="repassword">Retype Password</label>--%>

                <%--<div class="controls">--%>
                    <%--<input type="password" name="repassword" id="repassword" placeholder="Password">--%>
                <%--</div>--%>
            <%--</div>--%>


            <%--<div class="control-group">--%>
                <%--<div class="controls">--%>
                    <%--<button type="submit" class="btn btn-primary">Signup</button>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</form>--%>
    <%--</div>--%>

</div>
<!-- /container -->
<%@ include file="../../includes/footer.jsp" %>


<!-- Include Bootstrap Asserts JavaScript Files. -->
<script type="text/javascript">
    $(document).ready(function()
    {
// Popover
//        $('#signup input').hover(function()
//        {
//            $(this).popover('show')
//        });

// Validation
        $("#signup").validate({
            rules:{
                name:"required",
                username:"required",
                password:{required:true,minlength: 6},
                repassword:{required:true,equalTo: "#password"}

//                user_name:"required",
//                user_email:{required:true,email: true},
//                pwd:{required:true,minlength: 6},
//                cpwd:{required:true,equalTo: "#pwd"},
//                gender:"required"
            },

            messages:{
                name:"Enter your name",
                username:"Enter unique username",
                password:{
                    required:"Enter your password",
                    minlength:"Password must be minimum 6 characters"},
                repassword:{
                    required:"Enter confirm password",
                    equalTo:"Password and Confirm Password must match"}



//                user_name:"Enter your first and last name",
//                user_email:{
//                    required:"Enter your email address",
//                    email:"Enter valid email address"},
//                pwd:{
//                    required:"Enter your password",
//                    minlength:"Password must be minimum 6 characters"},
//                cpwd:{
//                    required:"Enter confirm password",
//                    equalTo:"Password and Confirm Password must match"},
//                gender:"Select Gender"
            },

            errorClass: "help-inline",
            errorElement: "span",
            highlight:function(element, errorClass, validClass)
            {
                $(element).parents('.control-group').addClass('error');
            },
            unhighlight: function(element, errorClass, validClass)
            {
                $(element).parents('.control-group').removeClass('error');
                $(element).parents('.control-group').addClass('success');
            }
        });
    });
</script>


<%--<script>--%>
    <%--$(document).ready(function() {--%>
        <%--$('#username').change(function(event) {--%>
            <%--var username=$('#username').val();--%>
            <%--$.get('checkusername',{username:username},function(response) {--%>

                <%--$('#welcometext').text(responseText);--%>
            <%--});--%>
        <%--});--%>
    <%--});--%>
<%--</script>--%>