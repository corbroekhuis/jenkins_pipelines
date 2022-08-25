pipeline {
  agent any
  tools {
      maven 'Maven_3.8.6'
      jdk 'Jdk_11'
  }
  stages {
    stage ('Initialize') {
        steps {
            sh '''
                echo "PATH = ${PATH}"
                echo "M2_HOME = ${M2_HOME}"
            '''
        }
    }

    stage('error') {
      steps {
        echo 'Hello'
      }
    }

  }
  environment {
    DEMO = 'Mvn'
  }
}

