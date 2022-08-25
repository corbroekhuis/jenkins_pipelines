pipeline {
  agent any
  tools {
      maven 'Maven_3.8.6'
      jdk 'Jdk_11'
  }
  stages {
    stage ('Initialize') {
        steps {
            //echo "${GIT_BRANCH}"
            echo "${env.GIT_BRANCH}"
        }
    }
    stage ('Stop Containers') {
        steps {
            bat 'docker compose down'
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
            bat 'docker compose up -d --build'
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

