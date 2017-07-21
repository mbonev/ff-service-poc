def myBuildVersion = new Date().format('yyyyMMddHHmmss') + '-b' + env.BUILD_NUMBER

node {
    try {
        echo 'starting a build'

        stage('prepare') {
            checkout scm
            sh 'pwd'
            sh 'ls -la'
            sh './gradlew clean'
        }

        echo 'build passed...'
    } catch (e) {
        echo 'build failed'
    }
}
