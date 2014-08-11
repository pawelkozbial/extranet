function Animuj() {
	var span = document.getElementById('napis').style.display;
	if (span == "none") {
		document.getElementById('napis').style.display = "inline";
	} else {
		document.getElementById('napis').style.display = "none";
	}
}

window.setInterval("Animuj()", 1000);