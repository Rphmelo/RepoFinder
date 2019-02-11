package br.com.rphmelo.repofinder.ui

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import br.com.rphmelo.repofinder.R
import br.com.rphmelo.repofinder.model.RepoSearchRequest
import io.reactivex.Observer
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    lateinit var repoViewModel: RepoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        repoViewModel = ViewModelProviders.of(this).get(RepoViewModel::class.java)
        searchRepos()
    }

    private fun searchRepos() {
        val repoSearchRequest = RepoSearchRequest("language:java", "stars", 1)
        repoViewModel.searchRepos(repoSearchRequest, onNext = {
            val recycleView = rvRepos
            recycleView.adapter = RepoListAdapter(this, it.items)
            recycleView.layoutManager = LinearLayoutManager(this)
        }, onError ={})
    }
}
