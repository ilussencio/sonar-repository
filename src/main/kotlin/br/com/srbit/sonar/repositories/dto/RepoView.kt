package br.com.srbit.sonar.repositories.dto

import br.com.srbit.sonar.repositories.model.Repo

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
    val lastCommitHash: String = "",
    val verifies: List<VerifyView>
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
        lastCommitHash = repo.lastCommitHash,
        verifies = repo.verifies.map { VerifyView(it) }
    )
}