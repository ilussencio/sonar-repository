package br.com.srbit.sonar.repositories.repositories

import br.com.srbit.sonar.repositories.model.Repo
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface RepoRepository: MongoRepository<Repo, String>{

}