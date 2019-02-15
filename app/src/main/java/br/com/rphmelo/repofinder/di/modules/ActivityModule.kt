package br.com.rphmelo.repofinder.di.modules

import br.com.rphmelo.repofinder.ui.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector()
    internal abstract fun contributeHomeActivity(): HomeActivity
}