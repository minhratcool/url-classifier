## How to run the application
- run command: `./gradlew clean build` then `./gradlew bootRun`
- demo curl: `curl --location --request POST "localhost:8080/classify" \
  --header "Content-Type: application/json" \
  --data-raw "[
  \"http://www.starwars.com\",
  \"https://www.imdb.com/find?q=star+wars&ref_=nv_sr_sm\",
  \"https://www.sbnation.com/2019/12/20/21030182/star-wars-character-draft-basketball-teams\",
  \"https://edition.cnn.com/sport\"
  ]"`
## Solution Architecture Using K8s
1. Our solution architecture for the web page categorization system using Kubernetes (K8s) will consist of the following components:

2. Kubernetes Cluster: We will use a managed Kubernetes service, such as Google Kubernetes Engine (GKE) or Amazon Elastic Kubernetes Service (EKS), to manage our Kubernetes cluster. This will allow us to focus on deploying and managing our service rather than managing the underlying infrastructure.

3. Docker Container: We will package our service in a Docker container to ensure consistency in the deployment environment. This will help to avoid compatibility issues between different environments.

4. Kubernetes Deployment: We will create a Kubernetes deployment that defines how many replicas of our service should be running at any given time. We will use a rolling deployment strategy to ensure that there is no downtime during deployments.

5. Kubernetes Service: We will create a Kubernetes service of type LoadBalancer that exposes our service to external requests. This will allow us to scale our service horizontally by adding more replicas behind the load balancer.

6. Monitoring: We will use Prometheus for monitoring our service. We will set up metrics and alerts to track key performance indicators (KPIs) such as request latency and error rates. We will also set up dashboards to visualize the data and make it easier to analyze.

7. Scaling: We will implement Horizontal Pod Autoscaling (HPA) to automatically adjust the number of replicas based on CPU utilization. This will allow us to scale our service up and down automatically based on demand.

8. Logging: We will use a centralized logging solution such as ELK stack to collect logs from all instances of our service. This will allow us to troubleshoot issues and analyze usage patterns.

9. High Availability and Fault-Tolerance: We will configure our deployment to use a multi-zone cluster to ensure high availability and fault-tolerance. We will also configure our service to automatically recover from node and pod failures.

By using Kubernetes, we can ensure that our web page categorization system is scalable, reliable, and fault-tolerant. We can easily deploy and manage our service, monitor its performance, and make adjustments as needed. This will enable us to provide a high-quality service to our users.