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
        always {
            script {
                currentBuild.result = currentBuild.result ?: 'SUCCESS'
                def status = currentBuild.result
                def duration = currentBuild.durationString.replace(' and counting', '')
                def logs = currentBuild.rawBuild.getLog(100).join('\n')
                
                emailext(
                    subject: "PIPELINE ${env.BUILD_ID}",
                    mimeType: 'text/html',
                    to: "ilussencio@gmail.com",
                    body: """
                        <p>PIPELINE EXEC</p>
                    """
                )
            }
        }
    }
}
