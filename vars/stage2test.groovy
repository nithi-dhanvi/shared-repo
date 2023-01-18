def call(String imageName) {
    withCredtials ([usernamePassword(CredentialsId: "dockerhub-cred", usernameVariable: "username", passwordVariable: "password"])
    

}

registry = "pothakamuri06/webapp" 
        registryCredential = 'dockerhub-cred' 
        dockerImage = ''

stage ("Build the docker image") {
            steps {
                script {
                dockerImage = docker.build registry + ":$BUILD_NUMBER" 
                sh "docker images"
                }
            }
        }
              
        stage ("Push image to dockerhub") {
            steps {
                script {
                     docker.withRegistry( '', registryCredential ) { 
                        dockerImage.push()
                                                         
                    }
                }
            }
        }