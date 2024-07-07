package br.com.srbit.sonar.repositories.service.impl

import br.com.srbit.sonar.repositories.exceptions.NotFoundException
import br.com.srbit.sonar.repositories.model.Repo
import br.com.srbit.sonar.repositories.repositories.RepoRepository
import br.com.srbit.sonar.repositories.service.IRepoService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class RepoService(private val repoRepository: RepoRepository): IRepoService {
    override fun save(repo: Repo): Repo = this.repoRepository.save(repo)

    override fun findAll(pageable: Pageable) : Page<Repo> = this.repoRepository.findAll(pageable)

    override fun findById(id: String): Repo = this.repoRepository.findById(id).orElseThrow { NotFoundException("Repo not found!")}

    override fun deleteById(id: String) = this.repoRepository.deleteById(id)

    override fun findAllPending(pageable: Pageable): Page<Repo> = this.repoRepository.findAllPending(pageable)
}