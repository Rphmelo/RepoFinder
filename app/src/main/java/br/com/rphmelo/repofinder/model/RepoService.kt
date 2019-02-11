package br.com.rphmelo.repofinder.model

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RepoService {
    @GET("/search/repositories")
    fun searchRepos(
            @Query("q") q: String,
            @Query("sort") sort: String,
            @Query("page") page: Int
    ): Observable<RepoResponse>
}