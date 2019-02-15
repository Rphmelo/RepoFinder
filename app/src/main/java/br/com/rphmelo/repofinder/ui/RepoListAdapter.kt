package br.com.rphmelo.repofinder.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.rphmelo.repofinder.R
import br.com.rphmelo.repofinder.api.getPicassoAuth
import br.com.rphmelo.repofinder.data.model.Repo
import kotlinx.android.synthetic.main.repos_list_row.view.*

class RepoListAdapter(
        private val context: Context,
        private val repoList: List<Repo>
): RecyclerView.Adapter<RepoListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoListViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.repos_list_row, parent, false)
        return RepoListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return repoList.size
    }

    override fun onBindViewHolder(holder: RepoListViewHolder, position: Int) {
        holder.bindView(repoList[position])
    }
}

class RepoListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bindView(repo: Repo) = with(itemView){
        tvRepoTitle.text = repo.name
        tvRepoDescription.text = repo.description
        tvFork.text = repo.forksCounts.toString()
        tvUsername.text = repo.owner.login
        tvNameLastName.text = repo.owner.login

        setImage(repo.owner.avatarUrl)
    }

    fun setImage(imageUrl: String) = with(itemView){
        getPicassoAuth(itemView.context)
                .load(imageUrl)
                .into(ivUser)
    }
}