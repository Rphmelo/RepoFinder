package br.com.rphmelo.repofinder.data.model

import com.google.gson.annotations.SerializedName

data class Repo(
        @SerializedName("name") var name: String,
        @SerializedName("full_name") var fullName: String,
        @SerializedName("description") var description: String,
        @SerializedName("created_at") var createdAt: String,
        @SerializedName("updated_at") var updatedAt: String,
        @SerializedName("pushed_at") var pushedAt: String,
        @SerializedName("language") var language: String,
        @SerializedName("open_issues_count") var openIssuesCount: Int,
        @SerializedName("forks_count") var forksCounts: Int,
        @SerializedName("html_url") var htmlUrl: String,
        @SerializedName("owner") var owner: RepoOwner,
        @SerializedName("stargazers_count") var stars: Int,
        @SerializedName("has_issues") var hasIssues: Boolean
) {
    constructor(): this(
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            0,
            0,
            "",
            RepoOwner(),
            0,
            false
    )
}