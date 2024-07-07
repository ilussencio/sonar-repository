package br.com.srbit.sonar.repositories.dto

import br.com.srbit.sonar.repositories.enum.Status
import br.com.srbit.sonar.repositories.model.Repo
import java.time.LocalDateTime

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
    val license: String = "",
    val status: Status? = null,
    val verifyDate: LocalDateTime? = null
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
        license = repo.license,
        status = repo.status,
        verifyDate = repo.verifyDate
    )
}