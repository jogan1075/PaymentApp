package com.jmc.banks.view.di

import android.content.Context
import com.jmc.banks.data.DataRepository
import com.jmc.banks.data.remote.RemoteImpl
import com.jmc.banks.data.remote.service.ApiService
import com.jmc.banks.data.repository.Remote
import com.jmc.banks.domain.repository.Repository
import com.jmc.network.Constans.URL_HOST
import com.jmc.network.RetrofitWebServiceFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BankModule {

    @Provides
    internal fun provideRemoteImpl(remoteImpl: RemoteImpl): Remote = remoteImpl

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