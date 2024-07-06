package br.com.srbit.sonar_repositories.repositories

import br.com.srbit.sonar_repositories.model.Repo
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface RepoRepository: MongoRepository<Repo, String>{
}