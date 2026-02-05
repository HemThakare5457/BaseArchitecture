package com.example.data.network

/*import com.example.core.dto.ErrorResult
import com.example.core.manager.DispatcherProvider
import com.example.data.common.isReleaseBuild
import com.example.data.datasource.local.DataSourceInf
import com.example.data.datasource.local.EMAIL_TAA_TESTING
import com.example.data.datasource.local.IMPERSONATION_EMAIL
import com.example.data.datasource.local.IMPERSONATION_HEADER
import com.example.data.datasource.local.IS_TAA_TESTING
import com.victra.data.network.IdTokenRefreshAuthenticator.TokenHandler.getIdToken
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class IdTokenInterceptor @Inject constructor(private val networkHelper: NetworkHelper, private val dataSourceInf: DataSourceInf, private val dispatcher:
DispatcherProvider
) :
    Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val accessToken = getIdToken(dataSourceInf, dispatcher)
        if(accessToken.isEmpty()){
            if (networkHelper.isNetworkConnected()) {
                throw ErrorResult.BlankIdTokenException()
            }else{
                throw ErrorResult.NoConnectivityException()
            }
        }

        val impersonatedEmailId = dataSourceInf.getString(IMPERSONATION_EMAIL, "").ifEmpty {
            if (dataSourceInf.getBoolean(IS_TAA_TESTING, false) && !isReleaseBuild()) {
                dataSourceInf.getString(EMAIL_TAA_TESTING, "")
            } else {
                ""
            }
        }

        val request: Request =
            chain.request().newBuilder()
                .addHeader(AUTHORIZATION, BEARER + accessToken)
                .addConditionalHeader(IMPERSONATION_HEADER, impersonatedEmailId)
                .build()
        return chain.proceed(request)
    }
}

private fun Request.Builder.addConditionalHeader(key: String, value: String): Request.Builder {
    if(value.isNotEmpty()){
        addHeader(key, value)
    }
    return this
}*/
