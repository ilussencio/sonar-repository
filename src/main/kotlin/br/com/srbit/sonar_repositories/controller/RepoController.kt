package br.com.srbit.sonar_repositories.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class RepoController {
    @GetMapping
    fun olaMundo():String {
        print("REQUISIÇÃO FEITA COM SUCESSO!")
        return "INICIALIZADO COM SUCESSO!"
    }
}