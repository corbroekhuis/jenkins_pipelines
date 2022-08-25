pipeline {
  agent any
  stages {
    stage('First') {
      steps {
        echo "**This is Demo $DEMO"
      }
    }

    stage('error') {
      steps {
        echo 'Hello'
      }
    }

  }
  environment {
    DEMO = '3'
  }
}

