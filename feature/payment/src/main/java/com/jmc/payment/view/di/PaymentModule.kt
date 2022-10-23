package com.jmc.payment.view.di

import android.content.Context
import com.jmc.network.Constans.URL_HOST
import com.jmc.network.RetrofitWebServiceFactory
import com.jmc.payment.data.DataRepository
import com.jmc.payment.data.remote.PaymentRemoteImpl
import com.jmc.payment.data.remote.service.ApiService
import com.jmc.payment.data.repository.Remote
import com.jmc.payment.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PaymentModule {

    @Provides
    internal fun provideRemoteImpl(remoteImpl: PaymentRemoteImpl): Remote = remoteImpl

    @Provides
    internal fun bindDataRepository(dataRepository: DataRepository): Repository = dataRepository

    @Provides
    @Singleton
    internal fun provideWebServiceRetrofit(@ApplicationContext context: Context): ApiService =
        RetrofitWebServiceFactory<ApiService>().create(
            isDebug = true,
            tClass = ApiService::class.java,
            context = context,
            baseUrl = URL_HOST
        )
}