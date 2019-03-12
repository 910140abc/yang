<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://apis.google.com/js/api:client.js"></script>
<script async defer src="https://connect.facebook.net/en_US/sdk.js"></script>


<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">
<script>
	$(document).ready(function(){
		
	    gapi.load('auth2', function(){
	      // Retrieve the singleton for the GoogleAuth library and set up the client.
	      auth2 = gapi.auth2.init({
	        client_id: '22042621167-ikc0vnt83k0rd0bs4rq4ljn2578lk124.apps.googleusercontent.com',
	        cookiepolicy: 'single_host_origin',
	        // Request scopes in addition to 'profile' and 'email'
	        scope: 'profile'
	      });
	      attachSignin(document.getElementById('customBtn'));
	    });
	    
	    window.fbAsyncInit = function() {
			FB.init({
				appId : '419957948576260',
				cookie : true, // enable cookies to allow the server to access 
				// the session
				xfbml : true, // parse social plugins on this page
				version : 'v3.2' // The Graph API version to use for the call
			});
	    };
		  
	});
	
	function checkLoginState() {
		FB.getLoginStatus(function(response) {
			statusChangeCallback(response);
		});
	}
	
	function statusChangeCallback(response) {

		if (response.status === 'connected') {
			alert("connected");	
			var accessToken = response.authResponse.accessToken;
		}else if(response.status === 'not_authorized'){
			alert("not");
		}else{
			alert("not login");	
			FB.login(function(response) {
			    if (response.authResponse) {
			     console.log('Welcome!  Fetching your information.... ');
			     FB.api('/me', function(response) {
			       console.log('Good to see you, ' + response.name + '.');
			     });
			    } else {
			     console.log('User cancelled login or did not fully authorize.');
			    }
			});
		}
		
	}
	
	function attachSignin(element) {	// for Google
	    console.log(element.id);
	    auth2.attachClickHandler(element, {},
	        function(googleUser) {		// for google login success
	    	
	          var id_token = googleUser.getAuthResponse().id_token;
	          $.ajax({
	        	  url:"login/googleVerify",
	        	  type:"post",
	        	  data:{idTokenStr:id_token},
	        	  success:function(data){
	        		  location.href = data;
	        	  }
	          });
	        }, function(error) {		// for google login fail
	          alert(JSON.stringify(error, undefined, 2));
	        });
	  }
	
</script>
</head>
<body>
<div id="gSignInWrapper">
    <span class="label">Sign in with:</span>
    <div id="customBtn" class="customGPlusSignIn">
      <span class="icon"></span>
      <span class="buttonText">Google</span>
    </div>
  </div>
  <div id="name"></div>
  
  <i class="fab fa-facebook-square loginIcon" onclick="checkLoginState();"></i>
  <div id="testDiv1">ssss</div>
  <fb:login-button scope="public_profile,email"
		onlogin="checkLoginState();" auto_logout_link="true" size="large"
		show_faces="true">
	</fb:login-button>
</body>
</html>