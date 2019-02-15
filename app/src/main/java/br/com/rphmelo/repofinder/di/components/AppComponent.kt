package br.com.rphmelo.repofinder.di.components

import android.app.Application
import br.com.rphmelo.repofinder.MyApplication
import br.com.rphmelo.repofinder.di.modules.ActivityModule
import br.com.rphmelo.repofinder.di.modules.AppModule
import br.com.rphmelo.repofinder.di.modules.RepositoryModule
import br.com.rphmelo.repofinder.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityModule::class,
    ViewModelModule::class,
    RepositoryModule::class
])

interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: MyApplication){

    }
}