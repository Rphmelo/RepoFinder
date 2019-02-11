package br.com.rphmelo.repofinder.model

import com.google.gson.annotations.SerializedName

data class RepoOwner(
        @SerializedName("login") val login: String,
        @SerializedName("avatar_url") val avatarUrl: String,
        @SerializedName("url") val url: String
)