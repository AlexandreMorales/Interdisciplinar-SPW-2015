function getLayout(fDone) {
	window.onload = function() {
		var container = document.documentElement.innerHTML;
		window.rooturl = "/PetShop_Cliente/";
		AjaxPuro({
			_path : "view/Home/home.html",
			_done : function(data) {
				document.documentElement.innerHTML = data;
				getElement("#container").innerHTML = container;
				gerenciaLogin();
				if (fDone)
					fDone();
			},
			_error : function(request, textStatus, error) {
				var err = textStatus + ", " + error;
				console.log("Request Failed: " + err);
			}
		});
		window.rooturl = "/PetShop_Servidor/";
	};
};