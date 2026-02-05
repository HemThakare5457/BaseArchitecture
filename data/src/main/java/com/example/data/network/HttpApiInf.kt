package com.example.data.network

import com.google.gson.JsonParseException
import com.example.core.dto.ErrorDetails
import com.example.core.dto.ErrorResult
import com.example.core.dto.OperationResult
import com.google.gson.Gson
import retrofit2.Response

private const val TAG = "HttpApiInf"
interface HttpApiInf {

    fun <RS> makeApiRequest(
        retrofitRequest: () -> Response<RS>,
        handleError: (Response<RS>) -> OperationResult.ErrorOperationResult = ::handleResponseError
    ): OperationResult<RS> {
        return try {
            val response = retrofitRequest()
            if (response.isSuccessful) {
                response.body()?.let {
                    return OperationResult.SuccessOperationResult(it)
                } ?: run {
                        @Suppress("UNCHECKED_CAST")
                        return OperationResult.SuccessOperationResult(Response.success("{\"result\": true}") as RS)
                    }
            } else {
                return handleError(response)
            }
        }catch (jse: JsonParseException){
           // Logger.e(TAG, "JsonSyntaxException occurred while making API call:", jse)
            OperationResult.ErrorOperationResult(ErrorResult.getError(jse))
        }
        catch (e: Exception) {
           // Logger.e(TAG, "Exception occurred while making API call:", e)
            OperationResult.ErrorOperationResult(ErrorResult.getError(e))
        }
    }

    fun <RS> handleResponseError(
        response: Response<RS>
    ): OperationResult.ErrorOperationResult {
        var errorMessage = ""
        var errorDetails: ErrorDetails? = null
        response.errorBody()?.let {
            errorMessage = it.string().ifEmpty { response.message()}
        }
        try {
          errorDetails = convertJsonToObject<ApiErrorDetails>(errorMessage).toDomain()
        }catch (e: Exception) {
          //  Logger.e(TAG, "Exception occurred while handling response error:", e)
        }
        return OperationResult.ErrorOperationResult(
            ErrorResult.getError(
                response.code(),
                errorDetails = errorDetails
            )
        )
    }

    fun ApiErrorDetails.toDomain(): ErrorDetails {
        return ErrorDetails(this.statusCode ?: -1)
    }
}

inline fun <reified T> convertJsonToObject(jsonString: String): T {
    return Gson().fromJson(jsonString, T::class.java)
}