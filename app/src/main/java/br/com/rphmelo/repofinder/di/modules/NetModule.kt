package br.com.rphmelo.repofinder.di.modules

import br.com.rphmelo.repofinder.data.model.RepoService
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [OkHttpClientModule::class])
class NetModule {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
            gson: Gson,
            @Named("githubURL") githubURL: String,
            okhttp: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(githubURL)
                .client(okhttp)
                .build()
    }

    @Provides
    @Singleton
    @Named("githubURL")
    fun provideGithubURL(): String {
        return "https://api.github.com"
    }

    @Provides
    @Singleton
    fun provideRepoService(retrofit: Retrofit): RepoService {
        return retrofit.create(RepoService::class.java)
    }
}