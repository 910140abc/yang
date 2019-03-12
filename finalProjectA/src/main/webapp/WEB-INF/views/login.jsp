<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">
<meta name="google-signin-client_id"
	content="22042621167-ikc0vnt83k0rd0bs4rq4ljn2578lk124.apps.googleusercontent.com">
<style>
.loginIcon {
	font-size: 80px;
}
</style>
<script>
	$(document).ready(function() {
		alert("ready");
		window.fbAsyncInit = function() {
			FB.init({
				appId : '419957948576260',
				cookie : true, // enable cookies to allow the server to access 
				// the session
				xfbml : true, // parse social plugins on this page
				version : 'v3.2' // The Graph API version to use for the call
			});

			FB.getLoginStatus(function(response) {
				statusChangeCallback(response);
			});
		};

	});

	function statusChangeCallback(response) {
		//可用於後臺驗證，但是前臺呼叫SDK則會自動驗證
		if (response.status === 'connected') {//sdk會自動保留accessToken，並且驗證該請求是否來自我的應用
			alert("connected")
			var accessToken = response.authResponse.accessToken;
			console.log(response.authResponse.accessToken);
			//         FB.api('/me?fields=name,first_name,last_name,email', function(response) { 
			//         	//將使用者資訊傳回服務端
			//         	//alert(JSON.stringify(response));
			//         	//window.location.href="userInfo?userInfo="+JSON.stringify(response);
			//         	 $.ajax({
			//                     url:"userInfo",
			//                     type:"POST",
			//                     data:{
			//                     	userInfo:JSON.stringify(response)
			//                     },
			//                     dataType:"html",
			//                     async:false,
			//                     success:function(data){
			//                     	alert("login success"+data);
			//                     } 
			//                 }); 
			//         	document.getElementById('status').innerHTML =
			// 		        'Thanks for logging in, ' + response.name + '!';
			//         });

		} else if (response.status === 'not_authorized') {
			alert("是否使用FB登入");
			FB.api('/me?fields=name,first_name,last_name,email', function(
					response) {
				//         	//將使用者資訊傳回服務端
				//         	//alert(JSON.stringify(response));
				//window.location.href="userInfo?userInfo="+JSON.stringify(response);
				$.ajax({
					url : "userInfo",
					type : "POST",
					data : {
						userInfo : JSON.stringify(response)
					},
					dataType : "html",
					async : false,
					success : function(data) {
						alert("login success" + data);
					}
				});
			});
		} else {
			alert("log into this app")
			// 		document.getElementById('status').innerHTML = 'Please log '
			// 				+ 'into this app.';
		}
	}

	function checkLoginState() {
		FB.getLoginStatus(function(response) {
			statusChangeCallback(response);
		});
	}

	(function(d, s, id) {
		var js, fjs = d.getElementsByTagName(s)[0];
		if (d.getElementById(id))
			return;
		js = d.createElement(s);
		js.id = id;
		js.src = "//connect.facebook.net/en_US/sdk.js";
		fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));

	// function onSignIn(googleUser) {
	//   var profile = googleUser.getBasicProfile();
	//   console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
	//   console.log('Name: ' + profile.getName());
	//   console.log('Image URL: ' + profile.getImageUrl());
	//   console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
	// }
	// function onSignIn(googleUser) {
	// 	  alert(googleUser);
	// 	  var id_token = googleUser.getAuthResponse().id_token;

	// 	  var xhr = new XMLHttpRequest();
	// 	  xhr.open('POST', 'login/googleVerify');
	// 	  xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	// 	  xhr.onload = function() {
	// 	    console.log('Signed in as: ' + xhr.responseText);
	// 	  };
	// 	  xhr.send('idTokenStr=' + id_token);
	// 	}

	// function signOut() {
	//   var auth2 = gapi.auth2.getAuthInstance();
	//   auth2.signOut().then(function () {
	//     console.log('User signed out.');
	//   });
	// }
</script>
</head>
<body>
	<div class="g-signin2" data-onsuccess="onSignIn"></div>
	<!-- <a href="#" onclick="signOut();">Sign out</a><br> -->

	<fb:login-button scope="public_profile,email"
		onlogin="checkLoginState();" auto_logout_link="true" size="large"
		show_faces="true">
	</fb:login-button>
	<div id="status"></div>

	帳號:
	<input type="text" id="accountId" /> 密碼:
	<input type="text" id="password" />
	<!-- <div class="fbIconDiv"> -->
	<!-- <i class="fab fa-facebook-square loginIcon" onclick=""></i> -->
	<!-- <i class="fab fa-google loginIcon" data-onsuccess="onSignIn"></i> -->
	<!-- </div> -->
</body>
</html>