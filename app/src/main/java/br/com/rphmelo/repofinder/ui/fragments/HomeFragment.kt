package br.com.rphmelo.repofinder.ui.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.com.rphmelo.repofinder.R
import br.com.rphmelo.repofinder.data.model.RepoSearchRequest
import br.com.rphmelo.repofinder.ui.RepoListAdapter
import br.com.rphmelo.repofinder.ui.RepoViewModel
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : Fragment() {

    lateinit var repoViewModel: RepoViewModel

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
        searchRepos()
    }

    private fun searchRepos() {
        repoViewModel.isLoading.observe(this, Observer {
            if(it == true){
                pbLoading.visibility = View.VISIBLE
            } else {
                pbLoading.visibility = View.GONE
            }
        })

        val repoSearchRequest = RepoSearchRequest("language:java", "stars", 1)

        repoViewModel.searchRepos(repoSearchRequest, onNext = {
            val recycleView = rvRepos
            recycleView.adapter = RepoListAdapter(context!!, it.items)
            recycleView.layoutManager = LinearLayoutManager(context!!)
        }, onError = {})
    }

    private fun configureDagger() {
        AndroidSupportInjection.inject(this)
    }

    private fun configureViewModel() {
        repoViewModel = ViewModelProviders.of(this, viewModelFactory).get(RepoViewModel::class.java)
    }


}
