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
        def status = currentBuild.result
        def duration = currentBuild.durationString.replace(' and counting', '')
        def logs = currentBuild.rawBuild.getLog(100).join('\n')

        failure {
            emailext(
                subject: "PIPELINE ${status} ${env.BUILD_ID}",
                mimeType: 'text/html',
                to: "ilussencio@gmail.com",
                body: """
                    <p>Pipeline ${status}</p>
                    <p>Build ID: ${env.BUILD_ID}</p>
                    <p>Job: ${env.JOB_NAME}</p>
                    <p>Build URL: <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>
                    <p>Duration: ${duration}</p>
                    <p>Logs:</p>
                    <pre>${logs}</pre>
                """
            )
        }
        success {
            emailext(
                subject: "PIPELINE ${status} ${env.BUILD_ID}",
                mimeType: 'text/html',
                to: "ilussencio@gmail.com",
                body: """
                    <p>Pipeline ${status}</p>
                    <p>Build ID: ${env.BUILD_ID}</p>
                    <p>Job: ${env.JOB_NAME}</p>
                    <p>Build URL: <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>
                    <p>Duration: ${duration}</p>
                    <p>Logs:</p>
                    <pre>${logs}</pre>
                """
            )
        }
    }
}
