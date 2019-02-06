package br.com.rphmelo.repofinder.repository

import br.com.rphmelo.repofinder.api.getRepoService
import br.com.rphmelo.repofinder.model.Repo
import br.com.rphmelo.repofinder.model.RepoSearchRequest
import io.reactivex.Observable

class RepoRepository {

    fun searchRepos(repoSearchRequest: RepoSearchRequest): Observable<Repo> {
        return getRepoService().searchRepos(
                repoSearchRequest.language,
                repoSearchRequest.page,
                repoSearchRequest.sort
        )
    }
}