package br.com.rphmelo.repofinder.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.rphmelo.repofinder.model.Repo
import br.com.rphmelo.repofinder.model.RepoSearchRequest
import br.com.rphmelo.repofinder.repository.RepoRepository
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class RepoViewModel: ViewModel() {

    val repoRepository = RepoRepository()
    val repos = MutableLiveData<Repo>()
    val errorMessage = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()
    var disposable: Disposable? = null

    fun searchRepos(
            repoSearchRequest: RepoSearchRequest,
            onNext: (Repo?) -> Unit,
            onError: (Throwable?) -> Unit
    ) {
        isLoading.value = true

        repoRepository.searchRepos(repoSearchRequest)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object: Observer<Repo> {
                    override fun onComplete() {

                    }

                    override fun onSubscribe(d: Disposable) {
                        disposable = d
                    }

                    override fun onNext(t: Repo) {
                        onNext(t)
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