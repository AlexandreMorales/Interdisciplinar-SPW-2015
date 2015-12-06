function setCookie(name, value, duration) {
        var cookie = name + "=" + value +
        ((duration) ? "; duration=" + duration.toGMTString() : "") + "; path=/PetShop_Cliente/view/";
 
        document.cookie = cookie;
}

function getCookie(name) {
    var cookies = document.cookie;
    var prefix = name + "=";
    var begin = cookies.indexOf("; " + prefix);
 
    if (begin == -1) {
 
        begin = cookies.indexOf(prefix);
         
        if (begin != 0) {
            return null;
        }
 
    } else {
        begin += 2;
    }
 
    var end = cookies.indexOf(";", begin);
     
    if (end == -1) {
        end = cookies.length;                        
    }
 
    return unescape(cookies.substring(begin + prefix.length, end));
}

function deleteCookie(name) {
    if (getCookie(name)) {
           document.cookie = name + "=" +
           "; expires=Thu, 01-Jan-70 00:00:01 GMT";
    }
}

function gerenciaLogin(){
	getElement("#li-logout").addEventListener("click", logout);
	show("li-login", (getCookie("userCurrent")==null));
	show("li-logout", (getCookie("userCurrent")!=null));
}

function logout(){
	deleteCookie("userCurrent");
}
