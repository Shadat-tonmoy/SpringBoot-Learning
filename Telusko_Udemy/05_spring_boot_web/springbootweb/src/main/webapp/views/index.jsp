<%@page language="java" %>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    </body>
        <h2>Telusko Calculator</h2>

         <form action="add">
            <label for="num1">Enter 1st Number :</label>
            <input type="text" id=num1" name="num1"><br>
            <label for="num2">Enter 2nd Number :</label>
            <input type="text" id="num2" name="num2"><br>
            <input type="submit" value="Submit">
        </form>

        <form action="addAlien">
            <label for="name">Enter Name :</label>
            <input type="text" id="name" name="name"><br>
            <label for="age">Enter Age :</label>
            <input type="text" id="age" name="age"><br>
            <input type="submit" value="Submit">
        </form>

    </body>
</html>