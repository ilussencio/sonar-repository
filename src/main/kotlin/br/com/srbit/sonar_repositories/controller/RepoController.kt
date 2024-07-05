package br.com.srbit.sonar_repositories.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
@Component
class RepoController(
    @Value("\${eureka.instance.instance-id}") var instance: String = ""
){
    @GetMapping
    fun olaMundo():String {
        println("REQUISIÇÃO FEITA COM SUCESSO!")
        return instance
    }
}