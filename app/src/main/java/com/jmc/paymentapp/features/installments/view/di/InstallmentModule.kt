package com.jmc.paymentapp.features.installments.view.di

import android.content.Context
import com.jmc.network.Constans.URL_HOST
import com.jmc.network.RetrofitWebServiceFactory
import com.jmc.paymentapp.features.installments.data.InstallmentDataRepository
import com.jmc.paymentapp.features.installments.data.remote.InstallmentRemoteImpl
import com.jmc.paymentapp.features.installments.data.remote.service.InstallmentsApi
import com.jmc.paymentapp.features.installments.data.repository.InstallmentRemote
import com.jmc.paymentapp.features.installments.domain.repository.InstallmentRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InstallmentModule {

    @Provides
    fun provideRemoteImpl(remoteImpl: InstallmentRemoteImpl): InstallmentRemote = remoteImpl

    @Provides
    fun bindDataRepository(dataRepository: InstallmentDataRepository): InstallmentRepository = dataRepository

    @Provides
    @Singleton
    fun provideWebServiceRetrofit(@ApplicationContext context: Context): InstallmentsApi =
        RetrofitWebServiceFactory<InstallmentsApi>().create(
            isDebug = true,
            tClass = InstallmentsApi::class.java,
            context = context,
            baseUrl = URL_HOST
        )
}