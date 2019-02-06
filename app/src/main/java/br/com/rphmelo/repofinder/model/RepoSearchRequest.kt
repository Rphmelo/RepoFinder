package br.com.rphmelo.repofinder.model

data class RepoSearchRequest(
        val language: String,
        val page: String,
        val sort: Int
)