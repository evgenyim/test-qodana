pipeline {
   environment {
       QODANA_TOKEN=credentials('qodana-token')
   }
   agent {
      docker {
         args '''
              -v "${WORKSPACE}":/data/project
              --entrypoint=""
              '''
         image 'jetbrains/qodana-jvm-community'
      }
   }
   stages {
      stage('Qodana') {
         when {
            branch 'main'
         }
         steps {
            sh "printenv"
            sh '''
               qodana --save-report --results-dir=/data/project
               '''
         }
      }
   }
}