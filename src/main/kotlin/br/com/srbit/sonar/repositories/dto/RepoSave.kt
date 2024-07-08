package br.com.srbit.sonar.repositories.dto

import br.com.srbit.sonar.repositories.model.Repo
import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.bson.types.ObjectId

data class RepoSave (
    val linkRepo: String = "",
    val name: String = "",
    val commits: Int = 0,
    val branches: Int = 0,
    val releases: Int = 0,
    val forks: Int = 0,
    val mainLanguage: String = "",
    val codeLines: Int = 0,
    val license: String = "",
    val lastCommitHash: String = ""
){
    fun toEntity(): Repo = Repo(
        id = ObjectId(),
        linkRepo = this.linkRepo,
        name = this.name,
        commits = this.commits,
        branches = this.branches,
        releases = this.releases,
        forks = this.forks,
        mainLanguage = this.mainLanguage,
        codeLines = this.codeLines,
        license = this.license,
        lastCommitHash = this.lastCommitHash
    )
}