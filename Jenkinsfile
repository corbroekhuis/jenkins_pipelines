pipeline {
  agent any
  options {
      // Keep the 10 most recent builds
      buildDiscarder(logRotator(numToKeepStr:'10'))
  }
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
    stage ('Test') {
        steps {
            bat 'mvn clean compile test'
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
            always {
                emailext body: 'Build finished', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Pipeline'
            }
        }

    }
    stage ('Build') {
        steps {
            bat 'mvn -DskipTests clean package'
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
         mail bcc: '', body: 'Pipeline has been succesfully executed ', cc: '', from: 'cornelius.broekhuis@capgemini.com', replyTo: 'cornelius.broekhuis@capgemini.com', subject: 'Pipeline has been succesfully executed ', to: 'cornelius.broekhuis@capgemini.com'
        }
      }
    }

  }
  environment {
    DEMO = 'Mvn'
  }

}

