package com.jmc.androidutils.helper

import android.content.res.Resources

interface Translatable {
    fun getStringResource(resources: Resources) : String
}