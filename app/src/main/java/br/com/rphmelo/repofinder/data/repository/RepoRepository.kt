package br.com.rphmelo.repofinder.data.repository

import br.com.rphmelo.repofinder.data.model.RepoResponse
import br.com.rphmelo.repofinder.data.model.RepoSearchRequest
import br.com.rphmelo.repofinder.data.model.RepoService
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepoRepository  @Inject
constructor(private val repoService: RepoService) {

    fun searchRepos(repoSearchRequest: RepoSearchRequest): Observable<RepoResponse> {
        return repoService.searchRepos(
                repoSearchRequest.q,
                repoSearchRequest.sort,
                repoSearchRequest.page
        )
    }
}