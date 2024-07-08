package br.com.srbit.sonar.repositories.dto

import br.com.srbit.sonar.repositories.enum.Status
import br.com.srbit.sonar.repositories.model.Verify
import java.time.LocalDateTime

data class VerifySave(
    val status: String,
    val issures: Int
) {
    fun toEntity() : Verify = Verify(
        status = Status.valueOf(this.status),
        issures = this.issures,
        date = LocalDateTime.now()
    )
}