package br.com.rphmelo.repofinder.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.rphmelo.repofinder.model.Repo
import br.com.rphmelo.repofinder.model.RepoResponse
import br.com.rphmelo.repofinder.model.RepoSearchRequest
import br.com.rphmelo.repofinder.repository.RepoRepository
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class RepoViewModel: ViewModel() {

    val repoRepository = RepoRepository()
    val isLoading = MutableLiveData<Boolean>()
    var disposable: Disposable? = null

    fun searchRepos(
            repoSearchRequest: RepoSearchRequest,
            onNext: (RepoResponse) -> Unit,
            onError: (Throwable?) -> Unit
    ) {
        isLoading.value = true

        repoRepository.searchRepos(repoSearchRequest)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object: Observer<RepoResponse> {
                    override fun onComplete() {

                    }

                    override fun onSubscribe(d: Disposable) {
                        disposable = d
                    }

                    override fun onNext(repoResponse: RepoResponse) {
                        onNext(repoResponse)
                    }

                    override fun onError(e: Throwable) {
                        onError(e)
                    }

                })
    }
    fun dispose(){
        disposable?.dispose()
    }
}