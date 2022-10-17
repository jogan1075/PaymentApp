package com.jmc.paymentapp.features.payment.view.di

import android.content.Context
import com.jmc.network.Constans.URL_HOST
import com.jmc.network.RetrofitWebServiceFactory
import com.jmc.paymentapp.features.payment.data.PaymentDataRepository
import com.jmc.paymentapp.features.payment.data.remote.PaymentRemoteImpl
import com.jmc.paymentapp.features.payment.data.remote.service.PaymentApi
import com.jmc.paymentapp.features.payment.data.repository.PaymentRemote
import com.jmc.paymentapp.features.payment.domain.repository.PaymentRepository
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
    fun provideRemoteImpl(remoteImpl: PaymentRemoteImpl): PaymentRemote = remoteImpl

    @Provides
    fun bindDataRepository(dataRepository: PaymentDataRepository): PaymentRepository = dataRepository

    @Provides
    @Singleton
    fun provideWebServiceRetrofit(@ApplicationContext context: Context): PaymentApi =
        RetrofitWebServiceFactory<PaymentApi>().create(
            isDebug = true,
            tClass = PaymentApi::class.java,
            context = context,
            baseUrl = URL_HOST
        )
}