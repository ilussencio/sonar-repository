package br.com.srbit.sonar.repositories

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@EnableMongoRepositories
@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class], scanBasePackages = arrayOf("br.com.srbit.sonar.repositories"))
class SonarRepositoriesApplication

fun main(args: Array<String>) {
	runApplication<SonarRepositoriesApplication>(*args)
}