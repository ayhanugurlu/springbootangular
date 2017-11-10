// angular application context wiring
(function () {
    'use strict';

    angular
        .module('LoginApplication', [
            'pascalprecht.translate',
            'ngAlertify',
            'angularCSS'
        ]);

    // set constant Configuration
    Configuration.APPLICATION_NAME = 'LoginApplication';

    angular.module('LoginApplication')
        .constant('Configuration', Configuration);

    angular.module('LoginApplication')
        .config(function ($httpProvider, $translateProvider) {

            var langs = [
                'en',
                'tr'
            ];

            function getLanguage(lang) {
                $.ajax({
                    url: Configuration.PREFERENCE_API + "/culture/" + lang,
                    headers: {'Accept': 'application/json'},
                    type: "get",
                    async: true,
                    success: function (data) {
                        // set the abbreviation to translation map
                        $translateProvider.translations(lang, JSON.parse(data.data));
                        window.localStorage.setItem(lang, data.data);
                    },
                    error: function () {
                        console.log("translation load fail " + lang)
                    }
                });
            }

            for (var i = 0; i < langs.length; i++) {
                var lang = langs[i];
                var langMapString = window.localStorage.getItem(lang);
                if (langMapString !== null) {
                    $translateProvider.translations(lang, JSON.parse(langMapString));
                }
                getLanguage(lang);
            }

            var selectedLanguage = window.localStorage.getItem('language');
            if (selectedLanguage === null) {
                var language = window.navigator.language || $window.navigator.userLanguage;
                selectedLanguage = language.split("-")[0];
                window.localStorage.setItem('language', selectedLanguage);
            }
            $translateProvider.preferredLanguage(selectedLanguage);

            // escapes HTML in the translation
            $translateProvider.useSanitizeValueStrategy('escape');
        });


})();