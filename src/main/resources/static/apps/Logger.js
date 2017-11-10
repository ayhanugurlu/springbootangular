(function () {
    'use strict';

    angular.module(Configuration.APPLICATION_NAME)
        .factory('logger', Logger);

    /**
     * @typedef {Logger} Logger
     * @param $log
     * @constructor
     */
    function Logger($log) {

        /**
         * current log level
         * @private
         * @type {string}
         */
        var _logLevel = Configuration.LOG_LEVEL;

        /**
         * available log levels
         * @private
         * @type {string[]}
         */
        var _logLevels = [
            'log',
            'debug',
            'info',
            'warn',
            'error'
        ];

        /**
         * caller
         * @type {string}
         */
        this._caller = null;

        /**
         * @private
         * @type {Logger}
         */
        var _instance = this;

        /**
         * create a new instance of logger
         * @param {string} caller
         * @return {Logger}
         */
        this.create = function (caller) {
            var logger = new Logger($log);
            logger._caller = '[' + caller + '] ';
            return logger;
        };

        /**
         * return caller
         */
        this.getCaller = function () {
            if (this._caller === null || this._caller === undefined) {
                throw new Error('CALLER undefined, please create an instance using create() method!');
            }
            return this._caller;
        };

        /**
         * set current log level
         * @param {string} logLevel
         */
        this.setLogLevel = function (logLevel) {
            _logLevel = logLevel;
        };

        /**
         * log level logging
         * @param message
         * @returns {void|undefined}
         */
        this.log = function (message) {
            if (_logLevels.indexOf(LogLevel.LOG) >= _logLevels.indexOf(_logLevel)) {
                $log.log(this.getCaller() + message);
            }
        };

        /**
         * debug level logging
         * @param message
         * @returns {void|undefined}
         */
        this.debug = function (message) {
            if (_logLevels.indexOf(LogLevel.DEBUG) >= _logLevels.indexOf(_logLevel)) {
                $log.log(this.getCaller() + message);
            }
        };

        /**
         * info level logging
         * @param message
         * @returns {void|undefined}
         */
        this.info = function (message) {
            if (_logLevels.indexOf(LogLevel.INFO) >= _logLevels.indexOf(_logLevel)) {
                $log.info(this.getCaller() + message);
            }
        };

        /**
         * warn level logging
         * @param message
         * @returns {void|undefined}
         */
        this.warn = function (message) {
            if (_logLevels.indexOf(LogLevel.WARN) >= _logLevels.indexOf(_logLevel)) {
                $log.warn(this.getCaller() + message);
            }
        };

        /**
         * error level logging
         * @param message
         * @returns {void|undefined}
         */
        this.error = function (message) {
            if (_logLevels.indexOf(LogLevel.ERROR) >= _logLevels.indexOf(_logLevel)) {
                $log.warn(this.getCaller() + message);
            }
        };

        return {
            create: _instance.create,
            setLogLevel: _instance.setLogLevel,
            getCaller: _instance.getCaller,
            log: _instance.log,
            debug: _instance.debug,
            info: _instance.info,
            warn: _instance.warn,
            error: _instance.error
        };

    }

})();
