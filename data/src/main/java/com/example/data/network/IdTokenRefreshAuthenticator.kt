package com.example.data.network

/*
import com.auth0.android.jwt.JWT
import com.victra.core.account.LoggedInUserAccount.Companion.refreshAccountToken
import com.victra.core.common.NO_OF_RETRY
import com.victra.core.logger.Logger
import com.victra.core.manager.DispatcherProvider
import com.victra.core.utils.isTokenValid
import com.victra.core.utils.retry
import com.victra.data.datasource.local.AUTH_STATE
import com.victra.data.datasource.local.DataSourceInf
import com.victra.data.datasource.local.ID_TOKEN
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

private const val TAG = "IdTokenRefreshAuthenticator"

class IdTokenRefreshAuthenticator @Inject constructor(
    private val dataSourceInf: DataSourceInf, private val dispatcher:
    DispatcherProvider
) :
    Authenticator {

    companion object TokenHandler {

        private fun getIdTokenExpiry(idToken: String): Long? {
            val jwt = JWT(idToken)
            return jwt.getClaim("exp").asString()?.toLongOrNull()
        }

        fun getIdToken(dataSourceInf: DataSourceInf, dispatcher: DispatcherProvider): String {
            val idToken = dataSourceInf.getString(ID_TOKEN, "")
            val isIdTokenValid = isTokenValid(getIdTokenExpiry(idToken) ?: 0)
            Logger.v("isIdTokenValid", "isIdTokenValid:->$isIdTokenValid")
            return if (isIdTokenValid) {
                idToken
            } else {
                val updatedIdToken = retry(times = NO_OF_RETRY,
                    block = {
                        refreshAccountToken(
                            dataSourceInf.getString(AUTH_STATE, ""),
                            dispatcher
                        ) ?: ""
                    })
                { updatedIdToken ->
                    if (updatedIdToken.isNotEmpty()) {
                        dataSourceInf.putString(ID_TOKEN, updatedIdToken)
                        true
                    } else {
                        false
                    }
                }
                updatedIdToken
            }
        }
    }

    override fun authenticate(route: Route?, response: Response): Request? =
        response.createSignedRequest()

    private fun Response.createSignedRequest(): Request? = try {
        val idToken = getIdToken(dataSourceInf, dispatcher)
        if (idToken.isNotEmpty()) {
            dataSourceInf.putString(ID_TOKEN, idToken)
            request.signWithToken(idToken)
        }else{
            null
        }

    } catch (error: Throwable) {
        Logger.e(TAG, "auth failed after refreshing token.", error)
        null
    }

    private fun Request.signWithToken(accessToken: String) =
        newBuilder()
            .header(AUTHORIZATION, "$BEARER$accessToken")
            .build()
}*/
