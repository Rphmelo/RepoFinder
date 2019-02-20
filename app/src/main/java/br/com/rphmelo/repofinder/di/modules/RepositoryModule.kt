package br.com.rphmelo.repofinder.di.modules

import br.com.rphmelo.repofinder.data.model.RepoService
import br.com.rphmelo.repofinder.data.repository.RepoRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [
    AppModule::class,
    NetModule::class
])

class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepoRepository(
            repoService: RepoService
    ): RepoRepository {
        return RepoRepository(repoService)
    }
}