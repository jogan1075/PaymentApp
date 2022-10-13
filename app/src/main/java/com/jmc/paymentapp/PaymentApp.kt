package com.jmc.paymentapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PaymentApp: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}