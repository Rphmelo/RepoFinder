package br.com.rphmelo.repofinder.ui

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.rphmelo.repofinder.R
import br.com.rphmelo.repofinder.model.RepoSearchRequest
import io.reactivex.Observer

class HomeActivity : AppCompatActivity() {

    lateinit var repoViewModel: RepoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        repoViewModel = ViewModelProviders.of(this).get(RepoViewModel::class.java)
    }

    private fun searchRepos() {
        val repoSearchRequest = RepoSearchRequest("", "", 1)
        repoViewModel.searchRepos(repoSearchRequest, onNext = {}, onError ={})
//        repoViewModel.repos.observe(this, Observer {
//
//        })
//        repoViewModel.errorMessage.observe(this, Observer {
//
//        })
//        repoViewModel.isLoading.observe(this, Observer {
//
//        })
    }
}
