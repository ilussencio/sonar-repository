package br.com.srbit.sonar.repositories.controller

import br.com.srbit.sonar.repositories.dto.RepoView
import br.com.srbit.sonar.repositories.dto.VerifySave
import br.com.srbit.sonar.repositories.service.impl.VerifyService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/verify")
class VerifyController(private val verifyService: VerifyService){
    @PutMapping("/{id}")
    fun insertVerify(@PathVariable id: String,
                     @RequestBody verify: VerifySave): ResponseEntity<RepoView>{
        return ResponseEntity.ok(RepoView(verifyService.insertVerify(id, verify.toEntity())))
    }
}