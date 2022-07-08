var relogio = document.getElementsByClassName("rc");
    function Relogio() {
    var hora = new Date();
    var h = hora.getHours() +"";
    var min = hora.getMinutes()+"";
    var s = hora.getSeconds()+"";
    if (h < 10) {
        relogio[0].innerHTML = "0";
        relogio[1].innerHTML = h;
    } else {
        relogio[0].innerHTML = h.substr(0, 1);
        relogio[1].innerHTML = h.substr(1, 1);
    }
    if (s < 10) {
        relogio[4].innerHTML = "0";
        relogio[5].innerHTML = s;
    } else {
        relogio[4].innerHTML = s.substr(0, 1);
        relogio[5].innerHTML = s.substr(1, 1);
    }
    if (min < 10) {
        relogio[2].innerHTML = "0";
        relogio[3].innerHTML = min;
    } else {
        relogio[2].innerHTML = min.substr(0, 1);
        relogio[3].innerHTML = min.substr(1, 1);
    }
    hora = h + ":" + min + ":" + s;
    relogio.innerHTML = hora;
    setTimeout("Relogio()", 500);
}
Relogio();