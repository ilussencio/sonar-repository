#!/usr/bin/env groovy
pipeline {
    agent any
    stages {
        stage('Maven Clean'){
            steps {
                script {
                    sh "mvn clean"
                }
            }
        }
        stage('Maven Package') {
            steps {
                script {
                    sh "mvn package"
                }
            }
        }
        stage('Docker Build'){
            steps{
                script {
                    dockerapp = docker.build("ilussencio/sonar-repository:${env.BUILD_ID}", '.')
                }
            }
        }
        stage('Docker Push'){
            steps{
                script {
                    docker.withRegistry('https://registry.hub.docker.com/', 'dockerhub'){
                        dockerapp.push('latest')
                        dockerapp.push("${env.BUILD_ID}")
                    }
                }
            }
        }
    }
    post {
        failure {
            emailext(
                subject: "PIPELINE FAILED",
                mimeType: 'text/html',
                to: "ilussencio@gmail.com",
                body: "PIPE FAILED"
            )
        }
        success {
            emailext(
                subject: "PIPELINE PASSED",
                mimeType: 'text/html',
                to: "ilussencio@gmail.com",
                body: "PIPELINE PASSED"
            )
        }
    }
}
