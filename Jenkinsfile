pipeline {
  agent any
  tools {
      maven 'Maven_3.8.6'
      jdk 'Jdk_11'
  }
  stages {
    stage ('Initialize') {
        steps {
            bat 'echo "PATH = ${PATH}"'
            bat 'echo "M2_HOME = ${M2_HOME}"'
        }
    }
    stage ('Build') {
        steps {
            sh 'mvn -Dmaven.test.failure.ignore=true install'
        }
        post {
            success {
                junit 'target/surefire-reports/**/*.xml'
            }
        }
    }
    stage('Finalize') {
      steps {
        bat 'echo "Finalizing"'
      }
    }

  }
  environment {
    DEMO = 'Mvn'
  }
}

