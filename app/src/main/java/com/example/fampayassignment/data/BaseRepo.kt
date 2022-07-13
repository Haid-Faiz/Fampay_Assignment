package com.example.fampayassignment.data

import com.example.fampayassignment.utils.Constants.INTERNET_CONNECTION
import com.example.fampayassignment.utils.Constants.SOMETHING_WENT_WRONG
import com.example.fampayassignment.utils.ErrorType
import com.example.fampayassignment.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

open class BaseRepo {

    suspend fun <T> safeApiCall(api: suspend () -> Response<T>) = withContext(Dispatchers.IO) {

        try {
            val response = api.invoke()

            if (response.isSuccessful)
                Resource.Success(data = response.body())
            else
                Resource.Error(errorMessage = response.message(), errorType = ErrorType.HTTP)
        } catch (e: HttpException) {
            Resource.Error(
                errorMessage = e.localizedMessage ?: SOMETHING_WENT_WRONG,
                errorType = ErrorType.HTTP
            )
        } catch (e: IOException) {
            Resource.Error(errorMessage = INTERNET_CONNECTION, errorType = ErrorType.HTTP)
        } catch (e: Exception) {
            Resource.Error(
                errorMessage = e.localizedMessage ?: SOMETHING_WENT_WRONG,
                errorType = ErrorType.HTTP
            )
        }
    }
}
