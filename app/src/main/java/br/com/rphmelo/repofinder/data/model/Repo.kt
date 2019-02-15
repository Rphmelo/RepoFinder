package br.com.rphmelo.repofinder.data.model

import com.google.gson.annotations.SerializedName

data class Repo(
        @SerializedName("name") val name: String,
        @SerializedName("full_name") val fullName: String,
        @SerializedName("description") val description: String,
        @SerializedName("created_at") val createdAt: String,
        @SerializedName("updated_at") val updatedAt: String,
        @SerializedName("pushed_at") val pushedAt: String,
        @SerializedName("language") val language: String,
        @SerializedName("open_issues_count") val openIssuesCount: Int,
        @SerializedName("forks_count") val forksCounts: Int,
        @SerializedName("html_url") val htmlUrl: String,
        @SerializedName("owner") val owner: RepoOwner
)