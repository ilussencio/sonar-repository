#!/usr/bin/env groovy
pipeline {
    agent {
        label 'docker-slave'
    }
    stages {
        stage('Compile') {
            steps {
                script {
                    sh "mvn clean compile"
                }
            }
        }
        stage('Unit Test') {
            steps {
                script {
                    sh "mvn test"
                }
            }
        }
        stage('package') {
            steps {
                script {
                    sh "mvn package"
                }
            }
        }
        stage('Docker Build'){
            steps{
                script {
                    dockerapp = docker.build("ilussencio/sonar-repository:${env.BUILD_ID}", '-f ./Dockerfile')
                }
            }
        }
        stage('Docker Build'){
            steps{
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub'){
                        dockerapp.push('latest')
                        dockerapp.push("${env.BUILD_ID}")
                    }
                }
            }
        }
        stage('Install') {
            steps {
                script {
                    sh "mvn install"
                }
            }
        }
    }
}
