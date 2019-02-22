package br.com.rphmelo.repofinder.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.rphmelo.repofinder.R
import br.com.rphmelo.repofinder.data.model.Repo
import br.com.rphmelo.repofinder.util.getPicasso
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.repos_list_row.view.*
import javax.inject.Inject

class RepoListAdapter @Inject constructor(
        private val context: Context,
        private val repoList: List<Repo>
): RecyclerView.Adapter<RepoListAdapter.RepoListViewHolder>() {

    lateinit var picasso: Picasso

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoListViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.repos_list_row, parent, false)
        picasso = getPicasso(context!!)
        return RepoListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return repoList.size
    }

    override fun onBindViewHolder(holder: RepoListViewHolder, position: Int) {
        holder.bindView(repoList[position])
    }

    inner class RepoListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindView(repo: Repo) = with(itemView){
            tvRepoTitle.text = repo.name
            tvRepoDescription.text = repo.description
            tvFork.text = repo.forksCounts.toString()
            tvUsername.text = repo.owner.login
            tvNameLastName.text = repo.owner.login
            tvStars.text = repo.stars.toString()
            picasso.load(repo.owner.avatarUrl)
                    .into(ivUser)
        }

    }
}

