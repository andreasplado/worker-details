
(function ($) {
    "use strict";

    
    /*==================================================================
    [ Validate ]*/
    var name = $('.validate-input input[name="name"]');
    var email = $('.validate-input input[name="email"]');
    var subject = $('.validate-input input[name="subject"]');
    var message = $('.validate-input textarea[name="message"]');


    $('.validate-form').on('submit',function(){
        var check = true;

        if($(name).val().trim() == ''){
            showValidate(name);
            check=false;
        }

        if($(subject).val().trim() == ''){
            showValidate(subject);
            check=false;
        }


        if($(email).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
            showValidate(email);
            check=false;
        }

        if($(message).val().trim() == ''){
            showValidate(message);
            check=false;
        }

        return check;
    });


    $('.validate-form .input1').each(function(){
        $(this).focus(function(){
           hideValidate(this);
       });
    });

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }

    $('#logout').click(function(){
        logOut();
    });


    function logOut(){

          gapi.load('auth2', function() {
            var auth2 = gapi.auth2.init({
              client_id: '485896048610-rk8i4i4fkh9c1ss58207kl3ltoibpsaa.apps.googleusercontent.com',
              // Scopes to request in addition to 'profile' and 'email'
              //scope: 'additional_scope'
            });
              auth2.authorize(
                                  {
                                      'client_id': '485896048610-rk8i4i4fkh9c1ss58207kl3ltoibpsaa.apps.googleusercontent.com',
                                  },
                                  function (authResult) {

                                      gapi.auth.signOut();
                                      window.location.href="https://worker-details.herokuapp.com/logout";
                                      }
                              )
          });
    }
    
    

})(jQuery);