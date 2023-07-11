pipeline {
  agent any
  options {
      // Keep the 10 most recent builds
      buildDiscarder(logRotator(numToKeepStr:'10'))
  }
  tools {
      maven 'Maven'
      jdk 'JDK'
  }
  stages {
    stage ('Initialize') {
        steps {
            //echo "${GIT_BRANCH}"
            bat '''
                docker version
                docker info
                docker compose version
            '''
            echo "${env.GIT_BRANCH}"
        }
    }
    stage ('Stop Containers') {
        steps {
          bat 'docker compose down'
        }
    }
    stage ('Test') {
        steps {
            bat 'mvn -Dmaven.test.failure.ignore=true test'
        }
        post {
            success {
                junit 'target/surefire-reports/**/*.xml'
            }
        }
    }
    stage ('Build') {
        steps {
            bat 'mvn -Dskip.tests=true package'
        }

    }
    stage ('Start Containers') {
        steps {
            bat 'docker compose up -d --build'
        }
    }
    stage('Finalize') {
      steps {
        bat 'echo "Finalizing"'
      }
      post{
        always {
         mail bcc: '', body: 'Pipeline has been succesfully executed ', cc: '', from: 'halil.dursun@capgemini.com', replyTo: 'halil.dursun@capgemini.com', subject: 'Pipeline has been succesfully executed ', to: 'halil.dursun@capgemini.com'
        }
      }
    }

  }
  environment {
    DEMO = 'Mvn'
  }

}

