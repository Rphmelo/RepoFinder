package br.com.rphmelo.repofinder.model

import com.google.gson.annotations.SerializedName

data class RepoResponse(
        @SerializedName("total_count") val totalCount: Int,
        @SerializedName("incomplete_results") val incompleteResults: Boolean,
        @SerializedName("items") val items: List<Repo>
)