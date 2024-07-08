package br.com.srbit.sonar.repositories.dto

import br.com.srbit.sonar.repositories.model.Verify
import java.time.LocalDateTime

data class VerifyView(
    val status: String,
    val issures: Int,
    val date: LocalDateTime,
) {
    constructor(verify: Verify): this(
        status = verify.status.name,
        issures = verify.issures,
        date = verify.date
    )
}