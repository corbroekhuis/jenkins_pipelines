pipeline {
  agent any
  stages {
    stage('First') {
      steps {
        echo "This is Demo $DEMO"
        mvn clean
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

