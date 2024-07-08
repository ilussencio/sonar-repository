package br.com.srbit.sonar.repositories.service.impl

import br.com.srbit.sonar.repositories.exceptions.NotFoundException
import br.com.srbit.sonar.repositories.model.Repo
import br.com.srbit.sonar.repositories.model.Verify
import br.com.srbit.sonar.repositories.repositories.RepoRepository
import org.springframework.stereotype.Service

@Service
class VerifyService(private val repoRepository: RepoRepository) {
    fun insertVerify(repo: String, verify: Verify) : Repo{
        val repoDb = repoRepository.findById(repo).orElseThrow { NotFoundException("Repo not found") }
        repoDb.verifies.add(verify)
        return repoRepository.save(repoDb)
    }
}