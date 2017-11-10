(function () {

    // translation map
    var translationMap = {

        // static html and menu entries

        // main page
        'login.title': 'Sign In | Preference',
        'login.username': 'Username',
        'login.password': 'Password',
        'login.button': 'sign in'
    };

    // add translation
    angular.module(Configuration.APPLICATION_NAME)
        .config(function ($translateProvider) {
            // set the abbreviation to translation map
            $translateProvider.translations('en', translationMap);
            // put defaults to local storage
            window.localStorage.setItem('en', JSON.stringify(translationMap));
            // default language
            $translateProvider.preferredLanguage('en');
            // escapes HTML in the translation
            $translateProvider.useSanitizeValueStrategy('escape');
        });

})();
