package br.com.srbit.sonar.repositories.service

import br.com.srbit.sonar.repositories.model.Repo
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface IRepoService {
    fun save(repo: Repo): Repo
    fun findAll(pageable: Pageable): Page<Repo>
    fun findById(id: String): Repo
    fun deleteById(id: String)
    fun findAllPending(pageable: Pageable): Page<Repo>
}