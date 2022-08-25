pipeline {
  agent any
  tools {
      maven 'Maven_3.8.6'
      jdk 'Jdk_11'
  }
  stages {
    stage ('Initialize') {
        steps {
            sh 'echo "PATH = ${PATH}"'
            sh 'echo "M2_HOME = ${M2_HOME}"'
        }
    }

    stage('Finalize') {
      steps {
        sh echo "Done"
      }
    }

  }
  environment {
    DEMO = 'Mvn'
  }
}

