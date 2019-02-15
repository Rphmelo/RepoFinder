package br.com.rphmelo.repofinder.ui

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import br.com.rphmelo.repofinder.R
import br.com.rphmelo.repofinder.data.model.RepoSearchRequest
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    lateinit var repoViewModel: RepoViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        this.configureDagger()
        this.configureViewModel()

        searchRepos()
    }

    private fun searchRepos() {
        val repoSearchRequest = RepoSearchRequest("language:java", "stars", 1)
        repoViewModel.searchRepos(repoSearchRequest, onNext = {
            val recycleView = rvRepos
            recycleView.adapter = RepoListAdapter(this, it.items)
            recycleView.layoutManager = LinearLayoutManager(this)
        }, onError = {})
    }

    private fun configureDagger() {
        AndroidInjection.inject(this)
    }

    private fun configureViewModel() {
        repoViewModel = ViewModelProviders.of(this, viewModelFactory).get(RepoViewModel::class.java)
    }
}
