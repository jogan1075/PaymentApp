package com.jmc.network

import android.content.Context
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitWebServiceFactory<TRetrofitWebService> {

    fun create(
        isDebug: Boolean,
        tClass: Class<TRetrofitWebService>,
        context: Context,
        baseUrl: String
    ): TRetrofitWebService {

        val okHttpClient = makeOkHttpClient(
            makeLoggingInterceptor(isDebug),
            RequestInterceptor()
//            makeIntepcetorUrl(),
//            makeHeadersInterceptors(context)
        )
        return create(okHttpClient, tClass, baseUrl)
    }

    private fun create(
        okHttpClient: OkHttpClient,
        tClass: Class<TRetrofitWebService>,
        baseUrl: String
    ): TRetrofitWebService {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(tClass)
    }

    private fun makeOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        requestInterceptor: RequestInterceptor
    ): OkHttpClient {
            return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(requestInterceptor)
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build()

    }


    private fun makeLoggingInterceptor(isDebug: Boolean): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = if (isDebug) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
        return logging
    }

    internal class RequestInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val originalRequest = chain.request()
            val originalUrl = originalRequest.url
            val url = originalUrl.newBuilder()
                .addQueryParameter("public_key", "444a9ef5-8a6b-429f-abdf-587639155d88")
                .build()

            val requestBuilder = originalRequest.newBuilder().url(url)
            val request = requestBuilder.build()
            return chain.proceed(request)
        }
    }


    /* private fun makeIntepcetorUrl(): Interceptor {
         return Interceptor { chain ->
             val url = chain.request().url.toUrl().toString()
                 .replace(INTERCEPTOR_FILTER_3D, INTERCEPTOR_FILTER_EQUAL)
                 .replace(INTERCEPTOR_FILTER_26, INTERCEPTOR_FILTER_AND)
                 .replace(INTERCEPTOR_FILTER_20, INTERCEPTOR_FILTER_BLANK_SPACE)
             val urlFilter = url
             val request = chain.request()
                 .newBuilder()
                 .url(url)
                 .build()
             return@Interceptor chain.proceed(request)
         }
     }
 */
  /*  private fun makeHeadersInterceptors(context: Context): Interceptor {
        val sharedPreferences = context.getSharedPreferences(
            ConstantsGenerals.NAME, 0
        )

        val platform = ConstantsGenerals.PLATFORM_APP
        val email =
            sharedPreferences.getString(ConstantsCustomerInfo.MAIL_KEY, DefaultValues.emptyString())
        val userType =
            if (email!!.isNotEmpty()) ConstantsTypeAuthentication.LOGIN_CREDENTIALS else ConstantsTypeAuthentication.LOGIN_GUEST
        val uniqueID = UUID.randomUUID().toString()
        val rut = sharedPreferences.getString(IDENTIFIERID_KEY, String()) ?: String()

        return Interceptor { chain ->
            val request = chain.request()
                .newBuilder()
                .addHeader(PLATFORM_HEADER, platform)
                .addHeader(
                    VERSION_HEADER,
                    context.getVersionApp().toString()
                )
                .addHeader(USER_TYPE_HEADER, userType)
                .addHeader(DEVICE_HEADER, uniqueID)
                .addHeader(X_FRAME_HEADER, X_FRAME_HEADER_VALUE)
                .addHeader(X_XSS_HEADER, X_XSS_HEADER_VALUE)
                .addHeader(X_DOWNLOAD_HEADER, X_DOWNLOAD_HEADER_VALUE)
                .addHeader(REFERRED_HEADER, REFERRED_HEADER_VALUE)
                .addHeader(STRICT_TRANSPORT_HEADER, STRICT_TRANSPORT_HEADER_VALUE)
                .addHeader(CONTENT_SECURITY_HEADER, CONTENT_SECURITY_HEADER_VALUE)
                .addHeader(CUSTOMER_NUMBER_HEADER, rut)
                .build()
            return@Interceptor chain.proceed(request)
        }
    }
*/

}




