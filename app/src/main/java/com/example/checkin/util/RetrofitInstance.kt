package com.example.checkin.util

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class RetrofitInstance {
	companion object {
		private const val BASE_URL = ""
		fun getRetrofitInstance (): Retrofit {
			val logging = HttpLoggingInterceptor()
			logging.level = HttpLoggingInterceptor.Level.BODY
			val client = OkHttpClient.Builder()
			client.addInterceptor(logging)
			return Retrofit.Builder()
				.baseUrl(BASE_URL)
				.client(client.build())
				.addConverterFactory(ScalarsConverterFactory.create())
				.addConverterFactory(GsonConverterFactory.create())
				.build()
		}
	}
}