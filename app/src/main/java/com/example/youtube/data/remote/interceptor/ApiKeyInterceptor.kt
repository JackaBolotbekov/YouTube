package com.example.youtube.data.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url.newBuilder()
            .addQueryParameter("key", "AIzaSyAopkZ8aBEOtiD6cxfELZOuu5pLicb5ZgM").build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}