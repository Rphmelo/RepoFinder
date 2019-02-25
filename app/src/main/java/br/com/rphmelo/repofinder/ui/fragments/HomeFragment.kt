package br.com.rphmelo.repofinder.ui.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import br.com.rphmelo.repofinder.R
import br.com.rphmelo.repofinder.data.model.RepoSearchRequest
import br.com.rphmelo.repofinder.ui.RepoListAdapter
import br.com.rphmelo.repofinder.ui.RepoViewModel
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : Fragment() {

    lateinit var repoViewModel: RepoViewModel
    lateinit var recycleView: RecyclerView

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        configureDagger()

        configureViewModel()
        setupRecyclerView()

        observeSearchRepoLoading()
        observeSearchRepoList()

        observeSearchRepoError()
        searchRepos()
    }

    private fun setupRecyclerView(){
        recycleView = rvRepos
        recycleView.layoutManager = LinearLayoutManager(context!!)
    }

    private fun observeSearchRepoError() {
        repoViewModel.repoError.observe(this, Observer {
            Toast.makeText(context, it?.message.toString(), Toast.LENGTH_LONG).show()
        })
    }

    private fun observeSearchRepoLoading() {
        repoViewModel.isLoading.observe(this, Observer {
            if(it!!){
                pbLoading.visibility = View.VISIBLE
            } else {
                pbLoading.visibility = View.GONE
            }
        })
    }

    private fun observeSearchRepoList() {
        repoViewModel.repoList.observe(this, Observer {
            recycleView.adapter = RepoListAdapter(context!!, it!!)
        })
    }

    private fun searchRepos() {
        val repoSearchRequest = RepoSearchRequest("language:java", "stars", 1)
        repoViewModel.searchRepos(repoSearchRequest)
    }

    private fun configureDagger() {
        AndroidSupportInjection.inject(this)
    }

    private fun configureViewModel() {
        repoViewModel = ViewModelProviders.of(this, viewModelFactory).get(RepoViewModel::class.java)
    }
}
