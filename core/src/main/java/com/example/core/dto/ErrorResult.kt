package com.example.core.dto
import java.io.IOException
import java.net.HttpURLConnection
import java.net.SocketTimeoutException

class ErrorResult {

    var errorCode: Int = -1 // Something went wrong please try again.
    var errorMessage: String = ""
    var errorDetails: ErrorDetails? = null
    var isWorkDayDown: Boolean = false

    companion object {

        //HTTP Error Codes
        const val HTTP_NOT_FOUND = 404

        const val SOME_THING_WENT_WRONG = 4000
        const val NO_INTERNET_CONNECTION = 4001
        const val SOCKET_TIMEOUT_EXCEPTION = 4002
        const val NO_PAY_PAY_PERIOD_FOUND = 4004
        const val LOGIN_ERROR = 4005
        const val CLOCK_IN_PREREQUISITE_FAIL = 4006
        const val CLOCK_OUT_PREREQUISITE_FAIL = 4007
        const val BAD_URL = 4008
        const val NO_BROWSER_DETECTED_LOGIN_ERROR = 4009
        const val NULL_MDM_EMPLOYEE_ID = 4010
        const val FILE_WRITE_FAIL = 4011
        const val NO_PAY_PERIOD_FOUND = 4012
        const val FILE_READ_FAIL = 4013
        const val NO_COST_CENTER_AVAILABLE = 4014
        const val WEB_PAGE_LOADING_ERROR = 4015


        // Login Screen
        const val FROM_AUTHENTICATION_LIB: Int = 1
        const val FROM_AUTH_LIB_INVALID_RES: Int = 2
        const val FROM_LOGIN_API: Int = 3
        const val FROM_TERM_AND_CONDITION_API_FAILED: Int = 4
        const val ON_CLEAR_USER_PREFERENCES_ERROR: Int = 5
        const val NO_BROWSER_ON_PHONE_ERROR: Int = 6
        const val ID_TOKEN_NULL_IN_BIOMETRIC_WORKFLOW: Int = 7


        // App Errors
        fun getError(errorCode: Int, errorMessage: String = "", errorDetails: ErrorDetails? = null): ErrorResult {
            val error = ErrorResult()
            error.errorCode = errorCode
            error.errorMessage = errorMessage
            error.errorDetails = errorDetails
            error.isWorkDayDown = isWorkDayDown(errorDetails)
            return error
        }

        private fun isWorkDayDown(errorDetails: ErrorDetails?): Boolean {
            return errorDetails != null &&  errorDetails.statusCode >= 500
        }

        fun getError(t: Throwable): ErrorResult {
            val error = ErrorResult()
            if (t is NoConnectivityException) {
                error.errorCode = NO_INTERNET_CONNECTION
            }
            if (t is SocketTimeoutException) {
                error.errorCode = SOCKET_TIMEOUT_EXCEPTION
            }

            if (t is BlankIdTokenException) {
                error.errorCode = HttpURLConnection.HTTP_UNAUTHORIZED
            }

            return error
        }

        fun getWebPageLoadingError(): ErrorResult {
            return getError(WEB_PAGE_LOADING_ERROR, "The page couldn't be loaded. Please try again later.")
        }

        fun getDefaultError(): OperationResult.ErrorOperationResult {
            return OperationResult.ErrorOperationResult(getError(SOME_THING_WENT_WRONG, "Something went wrong. Please try again."))
        }
    }

    class NoConnectivityException : IOException() {
        override val message: String
            get() = "No Internet Connection"
    }

    class BlankIdTokenException : IOException() {
        override val message: String
            get() = "Blank Id token Exception"
    }
}
