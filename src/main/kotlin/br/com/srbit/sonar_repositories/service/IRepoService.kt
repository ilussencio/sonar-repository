package br.com.srbit.sonar_repositories.service

import br.com.srbit.sonar_repositories.model.Repo

interface IRepoService {
    fun save(repo: Repo): Repo
    fun findAll(): List<Repo>
    fun findById(id: String): Repo
    fun deleteById(id: String)
}