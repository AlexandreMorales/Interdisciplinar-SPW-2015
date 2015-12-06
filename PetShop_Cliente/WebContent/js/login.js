function setCookie(name, value, duration) {
	document.cookie = name + "=" + value
			+ (duration ? "; duration=" + duration.toGMTString() : "")
			+ "; path=/PetShop_Cliente/view/";
}

function getCookie(name) {
	var cookies = document.cookie, prefix = name + "=", begin = cookies
			.indexOf("; " + prefix);

	if (begin == -1) {
		begin = cookies.indexOf(prefix);
		if (begin != 0)
			return null;
	} else
		begin += 2;

	return unescape(cookies.substring(begin + prefix.length, (cookies.indexOf(
			";", begin) == -1) ? cookies.length : cookies.indexOf(";", begin)));
}

function deleteCookie(name) {
	if (getCookie(name))
		document.cookie = name + "=" + "; expires=Thu, 01-Jan-70 00:00:01 GMT"
				+ "; path=/PetShop_Cliente/view/";
}

function gerenciaLogin() {
	var currentUser = JSON.parse(getCookie("userCurrent"));
	if (currentUser) {
		show("li-cadastrar", false);
		show("li-login", false);
		show("li-animais", currentUser.perfilAcesso == "Instituicao");
		getElement("#li-logout").addEventListener("click", logout);
	} else {
		show("li-logout", false);
		show("li-animais", false);
		show("li-instituicoes", false);
		show("li-usuarios", false);
		show("li-anuncios", false);
	}
}

function logout() {
	deleteCookie("userCurrent");
	if(FB)
		FB.logout(function(response) { });
}
