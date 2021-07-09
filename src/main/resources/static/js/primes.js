// program to check if a number is prime or not
// take input from the user
function findPrime(form){
    let isPrime = true;
    var result = "Result: ";
    let number = form.prime.value;
    // check if number is equal to 1
    if (number == 1) {
        document.getElementById("result").innerHTML = result + "1 is neither prime nor composite number.";
        console.log("1 is neither prime nor composite number.");
    }else if (number > 1) {
        // looping through 2 to number-1
        for (let i = 2; i < number; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            document.getElementById("result").innerHTML = result + `${number} is a prime number`;
            console.log(`${number} is a prime number`);
        } else {
            document.getElementById("result").innerHTML = result + `${number} is a not prime number`;
            console.log(`${number} is a not prime number`);
        }
    }else {
        document.getElementById("result").innerHTML = result + "The number is not a prime number.";
        console.log("The number is not a prime number.");
    }
}

function convertToBased64(form){
    try{
        let input = form.string.value;
        var encodedStringBtoA = btoa(input);
        console.log(encodedStringBtoA);
        document.getElementById("based64result").innerHTML = encodedStringBtoA;
    }catch(err){
        document.getElementById("based64result").innerHTML = err.message;
        console.log("Error: " + err.message);
    }
}

function based64ToString(form){
    try{
        let input = form.string.value;
        var encodedStringBtoA = atob(input);
        console.log(encodedStringBtoA);
        document.getElementById("based64result").innerHTML = encodedStringBtoA;
    }catch(err){
        document.getElementById("based64result").innerHTML = err.message;
        console.log("Error: " + err.message);
    }
}

var slider = document.getElementById("lengthrandom");
var output = document.getElementById("lengthoutput");
output.innerHTML = slider.value;

slider.oninput = function() {
  output.innerHTML = this.value;
}

function generateRandom(form){
    // declare all characters
    try{
        let characters ='ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
        var result = ' ';
        let charactersLength = characters.length;
        for ( let i = 0; i < lengthrandom.value; i++ ) {
            result += characters.charAt(Math.floor(Math.random() * charactersLength));
        }
        document.getElementById("randomresult").innerHTML = result;
    }catch(err){
        console.log("Error: " + err.message);
    }

}
