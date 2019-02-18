package br.com.rphmelo.repofinder.di.modules

import br.com.rphmelo.repofinder.ui.activities.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [FragmentModule::class])
    internal abstract fun contributeHomeActivity(): HomeActivity
}