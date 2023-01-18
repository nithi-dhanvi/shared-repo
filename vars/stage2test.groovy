def call(String imageName) {
    withCredentials ([usernamePassword(credentialsId: "dockerhub-cred", usernameVariable: "username", passwordVariable: "password")]) {


    sh "docker build -t $imageName ."
    sh "docker tag $imageName $username/$imageName':$BUILD_NUMBER'"
    sh "echo $password | docker login -u $username --password-stdin "
    sh "docker push $username/$imageName':$BUILD_NUMBER' "
    sh "docker rmi $(docker images -a -q)"
    }
}

