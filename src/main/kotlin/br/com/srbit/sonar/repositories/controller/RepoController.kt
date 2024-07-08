package br.com.srbit.sonar.repositories.controller

import br.com.srbit.sonar.repositories.model.Repo
import br.com.srbit.sonar.repositories.dto.RepoSave
import br.com.srbit.sonar.repositories.dto.RepoView
import br.com.srbit.sonar.repositories.service.impl.RepoService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/repos")
@Component
class RepoController(
    private val repoService: RepoService
){
    @GetMapping
    fun findAll(@PageableDefault(page = 0, size = 10, sort = arrayOf("id"), direction = Sort.Direction.DESC) pageable: Pageable):ResponseEntity<Page<RepoView>> {
        return ResponseEntity(this.repoService.findAll(pageable).map { RepoView(it) }, HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody repoSave: RepoSave): ResponseEntity<RepoView> {
        val repoSaved: Repo = this.repoService.save(repoSave.toEntity())
        val repoView: RepoView = RepoView(repoSaved)

        return ResponseEntity(repoView, HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String): ResponseEntity<String> {
        this.repoService.deleteById(id)
        return ResponseEntity("$id deletado com sucesso!", HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String): ResponseEntity<RepoView> {
        val repo: Repo = this.repoService.findById(id)
        val repoView: RepoView = RepoView(repo)

        return ResponseEntity(repoView, HttpStatus.OK)
    }
}