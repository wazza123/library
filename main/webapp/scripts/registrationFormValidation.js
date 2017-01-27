function registrationFormIsValid() {

    var login = document.getElementById("login").value;
    var passwordOne = document.getElementById("password").value;
    var passwordTwo = document.getElementById("password1").value;

    if(login.length < 4 || passwordOne.length < 4) {

        document.getElementById("msg").innerText = "login or password should not be less than 4 characters";
        return false;
    }
    else if(passwordOne != passwordTwo) {

        document.getElementById("msg").innerText = "passwords does not match";
        return false;
    }
    else {

        return true;
    }
}