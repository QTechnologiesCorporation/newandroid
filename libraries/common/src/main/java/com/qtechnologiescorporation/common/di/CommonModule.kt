package com.qtechnologiescorporation.common.di

import com.qtechnologiescorporation.common.dispatchers.AppCoroutineDispatchers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.dsl.module

//@Module
//@ComponentScan("com.qtechnologiescorporation.libraries.common")
//class CommonModule
//
//@Single
//fun createDispatchers(): AppCoroutineDispatchers =
//    AppCoroutineDispatchers(
//        io = Dispatchers.IO,
//        computation = Dispatchers.Default,
//        main = Dispatchers.Main,
//    )
//
//@Factory
//fun createAppScope(): CoroutineScope {
//    val supervisorJob = SupervisorJob()
//    return CoroutineScope(Dispatchers.IO + supervisorJob)
//}

val CommonKoinModule = module {
    single {
        AppCoroutineDispatchers(
            io = Dispatchers.IO,
            computation = Dispatchers.Default,
            main = Dispatchers.Main,
        )
    }

    factory {
        CoroutineScope(Dispatchers.IO + SupervisorJob())
    }
}
