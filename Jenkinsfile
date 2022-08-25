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
    stage ('Stop Containers') {
        steps {
            docker-compose down
        }
    }
    stage ('Build') {
        steps {
            bat 'mvn -Dmaven.test.failure.ignore=true install'
        }
        post {
            success {
                junit 'target/surefire-reports/**/*.xml'
                // publish html
                publishHTML target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: false,
                    keepAll: true,
                    reportDir: 'target/surefire-reports',
                    reportFiles: 'index.html',
                    reportName: 'RCov Report'
                  ]
            }
        }
    }
    stage ('Start Containers') {
        steps {
            docker-compose up -d --build
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

