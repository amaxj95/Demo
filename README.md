# Demo

This is a demo java API and Application Development and Deployment to a kubernetes Cluster 

## Step 1. Create Java application either from scratch or using [Spring Initializer](https://start.spring.io/)
After making edits to the Java app do a maven clean and install: 

    > mvn clean
    > mvn install
    
## Step 2. Create the Docker Image
From the image Repo, pull the Image
Expose locally on port 8080
Add the created "target/<app_name>.jar" file from the target folder to the Image using the same name 
Start the App in the image by creating the Entrypoint["java", "-jar", "/<app_name>.jar"]

    > 'docker build . -t demo-app:0.0.0'
    
## Step 3. Allow kubernetes to have local access via [minikube](https://minikube.sigs.k8s.io/docs/start/)
    
    > minikube status (install if needed)
    > minikube start
    > minikube docker-env
    > minikube -p minikube docker-env 
    
    #### Note Do this in the same terminal
    
    Run the docker build command again
    
    > docker build . -t demo-app:0.0.0
    
    Check if image available
    
    > docker images ls
    
    If the image name is showing then it is valid and proceed to create the deployment
    
    > kubectl create deployment demo-app --image=demo-app:0.0.0 --port=8080
    > kubectl get deployment (check if deployment was successful)
    > kubectl get pods (check if pod is running successfully)
    > kubectl get logs demo-app<pod name>
    
## Step 4. Create and Expose Nopdeport service then access via kubenernetes dashboard
    
    > kubectl get deployments 
    > kubectl expose deployment <deployment name> --type=NodePort (exposes service)
    > kubectl get service
    > minikube service <service name> --url (get the URL to access the pod) or 'minikube dashboard'
    
## Step 5. Access the application
    > minikube ssh
    > curl <ipaddress:8080>
    
