package br.com.rphmelo.repofinder.repository

import br.com.rphmelo.repofinder.api.getRepoService
import br.com.rphmelo.repofinder.model.RepoResponse
import br.com.rphmelo.repofinder.model.RepoSearchRequest
import io.reactivex.Observable

class RepoRepository {

    fun searchRepos(repoSearchRequest: RepoSearchRequest): Observable<RepoResponse> {
        return getRepoService().searchRepos(
                repoSearchRequest.q,
                repoSearchRequest.sort,
                repoSearchRequest.page
        )
    }
}