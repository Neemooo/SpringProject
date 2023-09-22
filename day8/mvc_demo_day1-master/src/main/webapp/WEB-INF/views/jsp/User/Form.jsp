<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Greeting</title>
</head>
<body>
<section >
    <mvc:form modelAttribute="user" action="/user/result" method="post">
        <fieldset>
            <legend style="margin-left:5em">User Details</legend>

            <p> <label for="four_child">First Name </label><mvc:input path="name" id="four_child" type="text" name="firstName"/></p>

            <p> <label for="five_child">Last Name </label><mvc:input path="lastname" id="five_child" type="text" name="lastName"/></p>

            <p><label for="two_child">Password </label><mvc:input path="password" id="two_child" type="password" placeholder="Enter your password" name="passWord"/></p>

            <p><label for="one_child">Detail </label><mvc:input path="Detail" id="one_child" type="text" name="detail"/></p>

            <p><label for="six_child">Date of Birth </label><mvc:input path="birthDate" id="six_child" type="date" name="birthDay" /></p>

            <p> <label id="sex" for="Gender">Gender </label>
                <mvc:radiobuttons id="sex" path="gender" items="${genders}"/>
            </p>

            <p><label for="eight_child">Country </label><mvc:checkboxes id="eight_child" path="country" name="country" items="${countries}"/></p>
            <p><label for="nine_child">NonSomking </label><mvc:checkbox path="nonSmoking" id="nine_child" name="smoking" checked="true" /></p>
        </fieldset>
        <button type="submit">Register</button>
    </mvc:form>
</section>
</body>
</html>