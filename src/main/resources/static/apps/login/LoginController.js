(function () {
    'use strict';

    angular
        .module(Configuration.APPLICATION_NAME)
        .controller('loginController', LoginController);

    /**
     *
     * @param {$scope} $scope
     * @param {$window} $window
     * @param {$translate} $translate
     * @param {LoginFactory} loginFactory
     * @param {alertify} alertify
     * @param {Logger} logger
     * @constructor
     */
    function LoginController($scope, $window, $translate, loginFactory, alertify, logger) {

        //
        //Private and public field declarations
        //

        /**
         * @property {Logger} logger
         */
        this.logger = null;

        /**
         * @property {Object} viewModel
         */
        this.viewModel = {
            loginReq: new LoginReq()
        };

        /**
         * @property {LoginFactory} loginFactory
         */
        this.loginFactory = null;


        /**
         * @property {alertify} alertify
         */
        this.alertify = null;


        //
        // Private and public method declarations
        //

        /**
         * validates LoginReq model
         * @private
         * @param {LoginReq} loginReq
         */
        function validateLoginRequest(loginReq) {
            if (loginReq.username !== null && loginReq.username !== undefined && loginReq.username !== '' &&
                loginReq.password !== null && loginReq.password !== undefined && loginReq.password !== '') {
                return true;
            } else {
                return false;
            }
        };


        this.login = function () {
            // create local variable
            var LoginController = this;

            if (validateLoginRequest(this.viewModel.loginReq) === false) {
                var message = $translate.instant('login_username_password_cannot_be_null');
                this.logger.debug(message);
                this.alertify.error(message);

            } else {
                this.loginFactory.login(LoginController.viewModel.loginReq)
                    .success(function (data, status, headers) {
                        LoginController.logger.debug("login got response data from server, response message: " + data.message);
                        if (data.status === 200) {
                            window.localStorage.setItem('token', data.data);
                            window.localStorage.setItem('username', LoginController.viewModel.loginReq.username);

                            LoginController.getUserInfo(data, headers);

                        } else {
                            alertify.error(PreferenceUtils.translate(data.message, $translate, headers));
                        }

                    })
                    .error(function (data, status, headers) {
                        var errorMessage = 'login got error, data: ' + data + ' status: ' + status;
                        LoginController.logger.debug(errorMessage);
                        LoginController.alertify.error(PreferenceUtils.translate(data.message, $translate, headers));
                    });
            }

        };

        /**
         * change current language
         * @public
         * @example en, tr, ar
         * @param {string} language
         * @returns {void|undefined}
         */
        this.changeLanguage = function (language) {
            // change current language
            window.localStorage.setItem('language', language);
            $translate.use(language);

            // remove localized css file
            this.removeCustomLocalizedCssFile();

            // add localized css file
            this.addCustomLocalizedCssFile(
                this.startInfoResponse.customLoginCssPath,
                this.startInfoResponse.customLoginCss,
                language
            );

        };


        //
        // constructor of controller
        //
        (function (self, $scope, $window, $translate, loginFactory, alertify, logger) {
            // create a new instance
            self.logger = logger.create('LoginController');

            self.logger.setLogLevel(Configuration.LOG_LEVEL);
            // log that the constructor is called
            self.logger.debug("Login controller constructor called");

            $scope.controller = self;
            $scope.viewModel = self.viewModel;

            // set empty request object to scope
            self.loginFactory = loginFactory;

            // set alertify
            self.alertify = alertify;
            self.alertify.logPosition("bottom right");


        })(this, $scope, $window, $translate, loginFactory, alertify, logger);

    }

})();
