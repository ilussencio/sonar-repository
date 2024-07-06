package br.com.srbit.sonar_repositories.service.impl

import br.com.srbit.sonar_repositories.model.Repo
import br.com.srbit.sonar_repositories.repositories.RepoRepository
import br.com.srbit.sonar_repositories.service.IRepoService
import org.springframework.stereotype.Service

@Service
class RepoService(private val repoRepository: RepoRepository): IRepoService {
    override fun save(repo: Repo): Repo = this.repoRepository.save(repo)

    override fun findAll(): List<Repo> = this.repoRepository.findAll()

    override fun findById(id: String): Repo = this.repoRepository.findById(id).orElseThrow { Exception("Repo not found")}

    override fun deleteById(id: String) = this.repoRepository.deleteById(id)
}