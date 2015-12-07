function ExecFacebook(_login) {
	// Load the SDK asynchronously
	var fjs = getElement(':script')[0].append(document.createElement('script')
			.config({
				id : 'facebook-jssdk',
				src : "//connect.facebook.net/en_US/sdk.js"
			}));

	window.fbAsyncInit = function() {
		FB.init({
			appId : '948270638583011',
			cookie : false, // enable cookies to allow the server to access
			// the session
			xfbml : true, // parse social plugins on this page
			version : 'v2.2' // use version 2.2
		});
		FB._login_ = _login;
	};
};

function checkLoginState() {
	FB
			.getLoginStatus(function(response) {
				if (response.status === 'connected')
					FB
							.api(
									'/me?fields=name,email,picture,gender,age_range,link,locale,timezone,updated_time,verified',
									function(usuario) {
										FB._login_(usuario);
									});
			});
};