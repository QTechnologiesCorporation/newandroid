package com.qtechnologiescorporation.qtechhealth

import android.app.Application
import com.qtechnologiescorporation.common.di.CommonKoinModule
import com.qtechnologiescorporation.di.NavigationModule
import com.qtechnologiescorporation.presentation.di.BusinessChatPresentationModule
import com.qtechnologiescorporation.presentation.di.BusinessHomePresentationModule
import com.qtechnologiescorporation.presentation.di.BusinessRecordsPresentationModule
import com.qtechnologiescorporation.presentation.di.BusinessSignInPresentationModule
import com.qtechnologiescorporation.presentation.di.QMedicalFormPresentationModule
import com.qtechnologiescorporation.presentation.di.UserAskTypePresentationModule
import com.qtechnologiescorporation.presentation.di.UserChatPresentationModule
import com.qtechnologiescorporation.presentation.di.UserHomePresentationModule
import com.qtechnologiescorporation.presentation.di.UserProfilePresentationModule
import com.qtechnologiescorporation.presentation.di.UserQiPresentationModule
import com.qtechnologiescorporation.presentation.di.UserRecordsPresentationModule
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
                BusinessSignInPresentationModule,
                QMedicalFormPresentationModule,
                UserChatPresentationModule,
                UserQiPresentationModule,
                UserRecordsPresentationModule,
                BusinessHomePresentationModule,
                BusinessRecordsPresentationModule,
                BusinessChatPresentationModule

            )
        }
    }
}