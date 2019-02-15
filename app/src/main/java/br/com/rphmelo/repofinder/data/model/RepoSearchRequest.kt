package br.com.rphmelo.repofinder.data.model

data class RepoSearchRequest(
        val q: String,
        val sort: String,
        val page: Int
)