package br.com.rphmelo.repofinder.model

import io.reactivex.Observable
import retrofit2.http.GET

interface RepoAPI {
    @GET("/api/pokemon")
    fun search() : Observable<Repo>
}