package com.jmc.paymentapp.features.banks.view.di

import android.content.Context
import com.jmc.network.RetrofitWebServiceFactory
import com.jmc.paymentapp.features.banks.data.BankDataRepository
import com.jmc.paymentapp.features.banks.data.remote.BankRemoteImpl
import com.jmc.paymentapp.features.banks.data.remote.service.BankApi
import com.jmc.paymentapp.features.banks.data.repository.BankRemote
import com.jmc.paymentapp.features.banks.domain.repository.BankRepository
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
object BankModule {

    @Provides
    fun provideRemoteImpl(remoteImpl: BankRemoteImpl): BankRemote = remoteImpl

    @Provides
    fun bindDataRepository(dataRepository: BankDataRepository): BankRepository = dataRepository

//    @Provides
//    fun provideDataSourceFactory(remote: Remote): Remote = remote


    @Provides
    @Singleton
    fun provideWebServiceRetrofit(@ApplicationContext context: Context): BankApi =
        RetrofitWebServiceFactory<BankApi>().create(
            isDebug = true,
            tClass = BankApi::class.java,
            context = context,
            baseUrl = "https://api.mercadopago.com/v1/"
        )
}