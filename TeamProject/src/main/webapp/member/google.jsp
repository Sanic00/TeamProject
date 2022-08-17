<html lang="en">
  <head>
   <!--  <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id" content="885450494757-bomd0c66ks4kg5lr578r2mr2fj9115ag.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js" async defer></script> -->
  </head>
  <body>
    <div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"></div>
    <button type ="button" onclick="signOut();">Sign Out</button>
    <script>
      function onSignIn(googleUser) {
        // Useful data for your client-side scripts:
        var profile = googleUser.getBasicProfile();
        console.log("ID: " + profile.getId()); // Don't send this directly to your server!
        console.log('Full Name: ' + profile.getName());
        console.log('Given Name: ' + profile.getGivenName());
        console.log('Family Name: ' + profile.getFamilyName());
        console.log("Image URL: " + profile.getImageUrl());
        console.log("Email: " + profile.getEmail());

        // The ID token you need to pass to your backend:
        var id_token = googleUser.getAuthResponse().id_token;
        console.log("ID Token: " + id_token);
      }
      	function signOut() {
      		gapi.auth2.getAuthInstance().disconnect();
      	}
      	
    </script>
  </body>
</html>