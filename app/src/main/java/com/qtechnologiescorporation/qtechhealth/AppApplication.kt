package com.qtechnologiescorporation.qtechhealth

import android.app.Application
import com.qtechnologiescorporation.common.di.CommonKoinModule
import com.qtechnologiescorporation.di.NavigationModule
import com.qtechnologiescorporation.presentation.di.BusinessSignInPresentationModule
import com.qtechnologiescorporation.presentation.di.UserAskTypePresentationModule
import com.qtechnologiescorporation.presentation.di.UserHomePresentationModule
import com.qtechnologiescorporation.presentation.di.UserProfilePresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@AppApplication)

            modules(
                CommonKoinModule,
                NavigationModule,
                UserHomePresentationModule,
                UserProfilePresentationModule,
                UserAskTypePresentationModule,
                BusinessSignInPresentationModule
            )
        }
    }
}