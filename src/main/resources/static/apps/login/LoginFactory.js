(function () {
    'use strict';

    angular.module(Configuration.APPLICATION_NAME)
        .factory('loginFactory', LoginFactory);

    /**
     * @typedef {LoginFactory} LoginFactory
     * @param {$http} $http
     * @param {Logger} logger
     * @returns {LoginFactory}
     * @constructor
     */
    function LoginFactory($http, logger) {

        // create a new instance
        this.logger = logger.create('LoginFactory');

        this.http = $http;

        this.loginURL = Configuration.PREFERENCE_API + '/user/login';
        this.getUserURL = Configuration.PREFERENCE_API + '/user/';
        this.getPremissionURL = Configuration.PREFERENCE_API + '/accounts/roles/';

        /**
         * public getting login info
         * @returns {HttpPromise} Future object
         */
        this.login = function (loginReq) {
            this.logger.debug("login control...");
            var req = {
                method: 'POST',
                url: this.loginURL,
                data: loginReq
            };
            return this.http(req);
        };


        /**
         * public getting login info
         * @returns {HttpPromise} Future object
         */
        this.getUser = function (token) {
            this.logger.debug("login getUser...");
            var req = {
                method: 'GET',
                url: this.getUserURL,
                headers: {
                    'X-Authorization-User': token
                }
            };
            return this.http(req);
        };


        /**
         * public getting login info
         * @returns {HttpPromise} Future object
         */
        this.getPermission = function (token, roleNames) {
            this.logger.debug("login getpermission...");
            var req = {
                method: 'POST',
                url: this.getPremissionURL,
                data: roleNames,
                headers: {
                    'X-Authorization-User': token
                }
            };
            return this.http(req);
        };

        return this;

    }

})();
