package br.com.rphmelo.repofinder.data.model

import com.google.gson.annotations.SerializedName

data class RepoOwner(
        @SerializedName("login") val login: String,
        @SerializedName("avatar_url") val avatarUrl: String,
        @SerializedName("url") val url: String
) {
    constructor(): this("", "http://simpleicon.com/wp-content/uploads/user1.png", "")
}