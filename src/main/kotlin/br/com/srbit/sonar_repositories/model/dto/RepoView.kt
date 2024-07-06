package br.com.srbit.sonar_repositories.model.dto

import br.com.srbit.sonar_repositories.model.Repo
import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.bson.types.ObjectId

data class RepoView (
    val id: String,
    val linkRepo: String = "",
    val name: String = "",
    val commits: Int = 0,
    val branches: Int = 0,
    val releases: Int = 0,
    val forks: Int = 0,
    val mainLanguage: String = "",
    val codeLines: Int = 0,
    val license: String = ""
){
    constructor(repo: Repo): this(
        id = repo.id.toString(),
        linkRepo = repo.linkRepo,
        name = repo.name,
        commits = repo.commits,
        branches = repo.branches,
        releases = repo.releases,
        forks = repo.forks,
        mainLanguage = repo.mainLanguage,
        codeLines = repo.codeLines,
        license = repo.license
    )
}