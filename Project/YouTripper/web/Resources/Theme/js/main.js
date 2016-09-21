jQuery(document).ready(function ($) {
    var $form_modal = $('.cd-user-modal'),
            $form_login = $form_modal.find('#cd-login'),
            $form_signup_1 = $form_modal.find('#cd-signup-1'),
            $form_signup_2 = $form_modal.find('#cd-signup-2'),
            $form_forgot_password = $form_modal.find('#cd-reset-password'),
            $form_modal_tab = $('.cd-switcher'),
            $tab_login = $form_modal_tab.children('li').eq(0).children('a'),
            $tab_signup = $form_modal_tab.children('li').eq(1).children('a'),
            $forgot_password_link = $form_login.find('.cd-form-forgot-password a'),
            $go_to_signup1_link = $form_login.find('.cd-form-bottom-message a'),
            $go_to_signup2_link = $form_signup_1.find('.cd-form input[type=submit].login'),
            $go_to_login_link1 = $form_signup_1.find('.cd-form-bottom-message a'),
            $go_to_login_link2 = $form_signup_2.find('.cd-form-top-message a'),
            $main_nav = $('.main-nav'),
            $option_nav = $('.main-nav'),
            $provider_link = $('.user-profile-caption ul li');

    // search click
    $provider_link.on('click', function (event) {
        if (!$(this).hasClass("active")) {
            var link = $(this).find('a').attr("href");
            $(location).attr('href', link);
        }
    });

    //open modal
    $main_nav.on('click', function (event) {
        if ($(event.target).is($main_nav)) {
            // on mobile open the submenu
            if ($(event.target).is('.cd-signup-1') || $(event.target).is('.cd-login')) {
                $(this).children('ul').toggleClass('is-visible');
            }
        } else {
            // on mobile close submenu
            $main_nav.children('ul').removeClass('is-visible');

            //show the selected form
            if ($(event.target).is('.cd-signup-1')) {
                //show modal layer
                $form_modal.addClass('is-visible');
                signup1_selected();
            }
            if ($(event.target).is('.cd-login')) {
                //show modal layer
                $form_modal.addClass('is-visible');
                login_selected();
                
            }
//            ($(event.target).is('.cd-signup-1')) ? signup1_selected() : login_selected();
        }
    });

    //close modal
    $('.cd-user-modal').on('click', function (event) {
        if ($(event.target).is(".cd-user-modal .tbl-cell") || $(event.target).is('.cd-close-form')) {
            $form_modal.removeClass('is-visible');
        }
    });
    //close modal when clicking the esc keyboard button
    $(document).keyup(function (event) {
        if (event.which == '27') {
            $form_modal.removeClass('is-visible');
        }
    });

    //switch from a tab to another
    $form_modal_tab.on('click', function (event) {
        event.preventDefault();
        ($(event.target).is($tab_login)) ? login_selected() : signup1_selected();
    });

    //hide or show password
    $('.hide-password').on('click', function () {
        var $this = $(this),
                $password_field = $this.prev('input');

        ('password' == $password_field.attr('type')) ? $password_field.attr('type', 'text') : $password_field.attr('type', 'password');
        ('Hide' == $this.text()) ? $this.text('Show') : $this.text('Hide');
        //focus and move cursor to the end of input field
        $password_field.putCursorAtEnd();
    });

    //show forgot-password form 
    $forgot_password_link.on('click', function (event) {
//        event.preventDefault();
//        forgot_password_selected();
    });

    //go to signup 1 from the login form
    $go_to_signup1_link.on('click', function (event) {
//        event.preventDefault();
//        signup1_selected();
    });

    //go to signup 2 from the login form
    $go_to_signup2_link.on('click', function (event) {
//        alert("aaaaa");
//		event.preventDefault();
//		signup2_selected();
    });

    //go to login from the signup 1 form
    $go_to_login_link1.on('click', function (event) {
        event.preventDefault();
        login_selected();
    });

    //go to login from the signup 2 form
    $go_to_login_link2.on('click', function (event) {
//        event.preventDefault();
//        login_selected();
    });

    function login_selected() {
        $form_login.addClass('is-selected');
        $form_signup_1.removeClass('is-selected');
        $form_signup_2.removeClass('is-selected');
        $form_forgot_password.removeClass('is-selected');
        $tab_login.addClass('selected');
        $tab_signup.removeClass('selected');
    }

    function signup1_selected() {
        $form_login.removeClass('is-selected');
        $form_signup_1.addClass('is-selected');
        $form_signup_2.removeClass('is-selected');
        $form_forgot_password.removeClass('is-selected');
        $tab_login.removeClass('selected');
        $tab_signup.addClass('selected');
    }

    function signup2_selected() {
        $form_login.removeClass('is-selected');
        $form_signup_1.removeClass('is-selected');
        $form_signup_2.addClass('is-selected');
        $form_forgot_password.removeClass('is-selected');
        $tab_login.removeClass('selected');
        $tab_signup.addClass('selected');
    }

    function forgot_password_selected() {
        $form_login.removeClass('is-selected');
        $form_signup_1.removeClass('is-selected');
        $form_signup_2.removeClass('is-selected');
        $form_forgot_password.addClass('is-selected');
    }

    //REMOVE THIS - it's just to show error messages 
    $form_login.find('input[type="submit"]').on('click', function (event) {
//        event.preventDefault();
//        $form_login.find('input[type="email"]').toggleClass('has-error').next('span').toggleClass('is-visible');
    });
    $form_signup_2.find('input[type="submit"]').on('click', function (event) {
//        event.preventDefault();
//        $form_signup_2.find('input[type="email"]').toggleClass('has-error').next('span').toggleClass('is-visible');
    });


    //IE9 placeholder fallback
    //credits http://www.hagenburger.net/BLOG/HTML5-Input-Placeholder-Fix-With-jQuery.html
   
    // options click

    $(document).on("click", ".item-function", function () {
        $("div.package-option").removeClass("active");
        var selectedElement = $(this).parent().find("div.package-option");

        if (selectedElement.hasClass("active")) {
            selectedElement.removeClass("active");
        } else {
            $(this).removeClass("active");
            selectedElement.addClass("active");
        }
    });

});


//credits http://css-tricks.com/snippets/jquery/move-cursor-to-end-of-textarea-or-input/
jQuery.fn.putCursorAtEnd = function () {
    return this.each(function () {
        // If this function exists...
        if (this.setSelectionRange) {
            // ... then use it (Doesn't work in IE)
            // Double the length because Opera is inconsistent about whether a carriage return is one character or two. Sigh.
            var len = $(this).val().length * 2;
            this.setSelectionRange(len, len);
        } else {
            // ... otherwise replace the contents with itself
            // (Doesn't work in Google Chrome)
            $(this).val($(this).val());
        }
    });
};