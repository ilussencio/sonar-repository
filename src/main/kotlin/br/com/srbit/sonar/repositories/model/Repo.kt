package br.com.srbit.sonar.repositories.model

import br.com.srbit.sonar.repositories.enum.Status
import jakarta.persistence.Id
import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime


@Document(collection = "repos")
data class Repo (
    @Id val id: ObjectId,
    val linkRepo: String = "",
    @Indexed(unique = true) val name: String = "",
    val commits: Int = 0,
    val branches: Int = 0,
    val releases: Int = 0,
    val forks: Int = 0,
    val mainLanguage: String = "",
    val codeLines: Int = 0,
    val license: String = "",
    val status: Status = Status.PENDING,
    val verifyDate: LocalDateTime? = null
)