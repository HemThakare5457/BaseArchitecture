package com.example.data.network

/*

*//**
 * Interceptor that automatically injects mdmEmployeeId and mdmCompanyId into API path parameters.
 * This eliminates the need to manually pass these parameters as path parameters in
 * RemoteDataSource implementations, but they may still need to be included in request bodies
 * where required by the API.
 *//*
class UserDetailsInterceptor @Inject constructor(
    private val dataSourceInf: DataSourceInf
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url.toString()

        // Extract mdmEmployeeId and mdmCompanyId from UserPreferencesStore
        val mdmEmployeeId = UserPreferencesStore.getMDMEmployeeId(dataSourceInf)
        val companyId = UserPreferencesStore.getUserCompanyID(dataSourceInf)

        // Replace path parameter placeholders in the URL
        // Note: Retrofit URL-encodes the curly braces, so we need to replace the encoded versions
        // {mdmEmployeeId} becomes %7BmdmEmployeeId%7D after URL encoding
        // {mdmCompanyId} becomes %7BmdmCompanyId%7D after URL encoding
        val newUrl = originalUrl
            .replace("%7B$MDM_EMPLOYEE_ID%7D", mdmEmployeeId.toString())
            .replace("%7B$MDM_COMPANY_ID%7D", companyId.toString())
            // Also handle lowercase encoding (some HTTP clients encode to lowercase)
            .replace("%7b$MDM_EMPLOYEE_ID%7d", mdmEmployeeId.toString())
            .replace("%7b$MDM_COMPANY_ID%7d", companyId.toString())

        // Create a new request with the modified URL
        val newRequest = originalRequest.newBuilder()
            .url(newUrl)
            .build()

        return chain.proceed(newRequest)
    }
}*/

