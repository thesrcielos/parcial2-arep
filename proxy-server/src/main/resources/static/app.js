function getSeq(){
    const value = document.getElementById("seq-value").value;
    if(!value){
        alert("Please type a number. The number must be greater or equals to zero");
        return;
    }

    const divAnswer = document.getElementById("seq-answer");
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        divAnswer.innerHTML = this.responseText;
    }
    xhttp.open("GET", "/lucasseq?value="+value);
    xhttp.send();
}