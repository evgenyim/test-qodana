pipeline {
    agent any
    stages {
        stage('Qodana') {
            environment {
                QODANA_TOKEN = credentials('qodana-token')
            }
            agent {
                docker {
                    args '''
                        -v "${WORKSPACE}":/data/project
                        --entrypoint=""
                        '''
                    image 'jetbrains/qodana-jvm'
                }
            }
            when {
                branch 'main'
            }
            steps {
                sh '''qodana'''
            }
        }
    }
}