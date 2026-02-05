package com.example.data.network

import android.Manifest
import android.content.Context
import androidx.annotation.RequiresPermission
import com.example.core.dto.ErrorResult
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class NetworkConnectionInterceptor @Inject constructor(
    val context: Context, private val
    networkHelper: NetworkHelper
) : Interceptor {

    @RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
    @Throws(ErrorResult.NoConnectivityException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!networkHelper.isNetworkConnected()) {
            throw ErrorResult.NoConnectivityException()
        }
        val builder: Request.Builder = chain.request().newBuilder()
        return chain.proceed(builder.build())
    }
}

