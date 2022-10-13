package com.jmc.paymentapp

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

//    @Singleton
//    @Provides
//     fun provideRemoteImpl2(
//        authInstance: FirebaseAuth
//    ) = RemoteImpl(authInstance)

//    @Singleton
//    @Provides
//    fun provideInitFirabase(context : Application) = FirebaseApp.initializeApp(context)

//    @Singleton
//    @Provides
//    fun provideFirebaseAuth() = FirebaseAuth.getInstance()

//    @Singleton
//    @Provides
//    fun provideAuthenticationLogin(): FirebaseAuth = Firebase.auth


//    @Singleton
//    @Provides
//    fun provideFirebaseAuth() = Firebase.auth

    //    @Singleton
//    @Provides
//    fun provideRemoteImpl(remoteImpl: RemoteImpl): Remote = remoteImpl

//    @Singleton
//    @Provides
//    fun bindDataSourceFactory(dataSourceFactory: DataSourceFactory) = dataSourceFactory


    //    @Singleton
//    @Provides
//    fun bindDataRepository(dataRepository: DataRepository): Repository = dataRepository
//

//    @Singleton
//    @Provides
//    fun provideApiHelper(apiHelper: HomeApiHelperImpl): HomeApiHelper = apiHelper
//
//    @Singleton
//    @Provides
//    fun provideUserRepository(
//        userRepositoryImpl: UserRepositoryImpl
//    ): UserRepository = userRepositoryImpl


//    @Binds
//    fun bindDataSourceFactory(dataSourceFactory: DataSourceFactory): Remote
//
//    @Binds
//    fun bindDataRepository(movieRepoImp: DataRepository): Repository
//
//
//    @Binds
//     fun provideRemoteImpl(
//        authInstance: FirebaseAuth
//    ) = RemoteImpl(authInstance)


//    @Provides
//     fun provideDataRepository(
//        factory: DataSourceFactory
//    ): Repository = DataRepository(factory)
//
//    @Provides
//     fun provideRegisterSourceFactory(
//        remote: Remote,
//    ) = DataSourceFactory(remote)

//    @Singleton
//    @Provides
//    fun provideUserRepository(
//        userRepositoryImpl: DataRepository
//    ): Repository = userRepositoryImpl

}
