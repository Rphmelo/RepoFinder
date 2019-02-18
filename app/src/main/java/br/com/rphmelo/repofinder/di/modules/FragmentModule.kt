package br.com.rphmelo.repofinder.di.modules

import br.com.rphmelo.repofinder.ui.fragments.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment
}