package br.com.srbit.sonar.repositories.model

import br.com.srbit.sonar.repositories.enum.Status
import java.time.LocalDateTime

data class Verify(
    val status: Status,
    val issures: Int,
    val date: LocalDateTime = LocalDateTime.now(),
)