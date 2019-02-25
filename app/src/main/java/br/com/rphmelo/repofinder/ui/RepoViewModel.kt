package br.com.rphmelo.repofinder.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.rphmelo.repofinder.data.model.Repo
import br.com.rphmelo.repofinder.data.model.RepoResponse
import br.com.rphmelo.repofinder.data.model.RepoSearchRequest
import br.com.rphmelo.repofinder.data.repository.RepoRepository
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executor
import javax.inject.Inject

class RepoViewModel @Inject constructor(var repoRepository: RepoRepository, private val executor: Executor) : ViewModel() {

    var isLoading = MutableLiveData<Boolean>()
    var repoList = MutableLiveData<List<Repo>>()
    var repoError = MutableLiveData<Throwable>()
    var disposable: Disposable? = null

    fun searchRepos(repoSearchRequest: RepoSearchRequest) {
        isLoading.value = true

        executor.execute {
            repoRepository.searchRepos(repoSearchRequest)
                    .subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(object: Observer<RepoResponse> {
                        override fun onComplete() {
                            isLoading.value = false
                        }

                        override fun onSubscribe(d: Disposable) {
                            disposable = d
                        }

                        override fun onNext(repoResponse: RepoResponse) {
                            repoList.value = repoResponse.items
                        }

                        override fun onError(e: Throwable) {
                            repoError.value = e
                        }

                    })
        }

    }

    override fun onCleared() {
        super.onCleared()
        dispose()
    }
    fun dispose(){
        disposable?.dispose()
    }
}