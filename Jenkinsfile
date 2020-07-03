#!/usr/bin/env groovy
pipeline {
	agent any
    stages {
       stage('Build') { 
             echo 'start build'
            }
        }
        stage('Deploy') {
            steps {
               echo 'start deploy'
            }
        }
    }
    post {
        always {
            echo 'build and deploy finished'
        }
        failure {
            echo 'build failed'
        }
    }
}
