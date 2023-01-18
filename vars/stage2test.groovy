def call(String imageName) {
    withCredentials ([usernamePassword(credentialsId: "dockerhub-cred", usernameVariable: "Username", passwordVariable: "Password")])
    sh "docker build -t $imageName ."
    sh "docker tag $imageName $imageName':$BUILD_NUMBER'"
    sh "docker push $imageName':$BUILD_NUMBER' "
    sh "docker rmi $imageName':$BUILD_NUMBER' "

}

