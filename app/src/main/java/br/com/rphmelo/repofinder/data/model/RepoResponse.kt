package br.com.rphmelo.repofinder.data.model

import com.google.gson.annotations.SerializedName

data class RepoResponse(
        @SerializedName("total_count") var totalCount: Int,
        @SerializedName("incomplete_results") var incompleteResults: Boolean,
        @SerializedName("items") var items: List<Repo>
)