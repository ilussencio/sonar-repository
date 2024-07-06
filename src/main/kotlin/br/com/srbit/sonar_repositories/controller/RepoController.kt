package br.com.srbit.sonar_repositories.controller

import br.com.srbit.sonar_repositories.model.Repo
import br.com.srbit.sonar_repositories.model.dto.RepoSave
import br.com.srbit.sonar_repositories.model.dto.RepoView
import br.com.srbit.sonar_repositories.service.impl.RepoService
import org.hibernate.query.sqm.tree.SqmNode.log
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
@Component
class RepoController(
    @Value("\${eureka.instance.instance-id}") var instance: String = "",
    private val repoService: RepoService
){
    @GetMapping
    fun findAll():ResponseEntity<List<RepoView>> {
        val list: List<RepoView> = this.repoService.findAll()
            .stream()
            .map { repo: Repo -> RepoView(repo) }
            .toList()

        return ResponseEntity(list, HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody repoSave: RepoSave): ResponseEntity<RepoView> {
        val repoSaved: Repo = this.repoService.save(repoSave.toEntity())
        val repoView: RepoView = RepoView(repoSaved)

        return ResponseEntity(repoView, HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String): ResponseEntity<Unit> {
        this.repoService.deleteById(id)
        return ResponseEntity(Unit, HttpStatus.OK)
    }
}