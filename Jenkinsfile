pipeline {
   agent {
      docker {
         args '''
              -v "${WORKSPACE}":/data/project
              --entrypoint=""
              '''
         image 'jetbrains/qodana-jvm'
      }
   }
   stages {
      stage('Qodana') {
         when {
            branch 'main'
         }
         steps {
            sh '''
               qodana
               '''
         }
      }
   }
}