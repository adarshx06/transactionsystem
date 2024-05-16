**Important: Don't forget to update the [Candidate README](#candidate-readme) section**

Real-time Transaction Challenge
===============================
## Overview
Welcome to Current's take-home technical assessment for backend engineers! We appreciate you taking the time to complete this, and we're excited to see what you come up with.

Today, you will be building a small but critical component of Current's core banking enging: real-time balance calculation through [event-sourcing](https://martinfowler.com/eaaDev/EventSourcing.html).

## Schema
The [included service.yml](service.yml) is the OpenAPI 3.0 schema to a service we would like you to create and host. 

## Details
The service accepts two types of transactions:
1) Loads: Add money to a user (credit)

2) Authorizations: Conditionally remove money from a user (debit)

Every load or authorization PUT should return the updated balance following the transaction. Authorization declines should be saved, even if they do not impact balance calculation.

You may use any technologies to support the service. We do not expect you to use a persistent store (you can you in-memory object), but you can if you want. We should be able to bootstrap your project locally to test.

## Expectations
We are looking for attention in the following areas:
1) Do you accept all requests supported by the schema, in the format described?

2) Do your responses conform to the prescribed schema?

3) Does the authorizations endpoint work as documented in the schema?

4) Do you have unit and integrations test on the functionality?

# Candidate README
## Bootstrap instructions
To run:
1. Make sure you have Java 17 install.
2. Clone the repository.
3. Run the application through TransactionServiceApplication.java file.
4. Application will start running (port 8080) on "hhtp;//localhost:8080".

## Design considerations
*Replace this: I decided to build X for Y reasons.*
1. The service is bulid using Spring framework and Java 17 tried using the concept of event sourcing through logging each transaction.
2. I tried to follow standard architecture which I know separating controller, services and model layers.
3. The `Controller` handles the incoming requests and delegates the processing to the `TransactionService`.
4. The `Service` contains the business logic for processing transactions, includes authorization and loading of user balance.
5. The Models contains all the schema which is define in service.yml file.
6. The Event contains event that needs to be log, allows for capturing and storing all the changes in the system.


## Bonus: Deployment considerations
*Replace this: If I were to deploy this, I would host it in this way with these technologies.*

Hosting the service on a cloud platform like Amazon Web Services (AWS) or Google Cloud Platform (GCP) will be help full in leverage their scalability and reliability.

1. Containerizing the application using Docker will ensure portability and ease of deployment across different environments.
2. I would use a dedicated event store database like Apache Kafka to persist the events unlike I did in-memory. These databases are optimized for storing and retrieving event streams and provide scalability and fault tolerance.
3. Implementing a CI/CD pipeline using tools to automate the build, testing, and deployment processes.
4. Implementing secure communication using HTTPS and API authentication mechanisms to protect sensitive data.
5. Monitoring the application using tools like Grafana to gain insights into performance, errors, and usage patterns.
7. I dont have a robust error handling way implemented such that retry mechanism to handle transient failures and ensure data consistency.
8. Regularly backing up the transaction data and implementing disaster recovery procedures to minimize data loss in case of failures.

## ASCII art
*Optional but suggested, replace this:*
```
                                                                                
                   @@@@@@@@@@@@@@                                               
               @@@@@@@@@@@@@@@@@@@@@                                            
             @@@@@@@@@@@@@@@@@@@@@@@@@@                                         
          @@@@@@@@@@@@@@@@@@@@@@@@                                  @@@@        
        @@@@@@@@@@@@@@@@@@@@@      @@@@@@                        @@@@@@@@@      
     @@@@@@@@@@@@@@@@@@@@@    @@@@@@@@@@@@@@@                 .@@@@@@@@@@@@@@   
   @@@@@@@@@@@@@@@@@@@@   @@@@@@@@@@@@@@@@@@@@@           @@@@@@@@@@@@@@@@@@@@@ 
 @@@@@@@@@@@@@@@@@@@    @@@@@@@@@@@@@@@@@@@@@@@@@@   @@@@@@@@@@@@@@@@@@@@@@@@@@ 
    @@@@@@@@@@@@@@               @@@@@@@@@@@@@@@@@@@    @@@@@@@@@@@@@@@@@@@@    
      @@@@@@@@@@                     @@@@@@@@@@@@@@@@@@    @@@@@@@@@@@@@@       
         @@@@                          @@@@@@@@@@@@@@@@@@@@                     
                                          @@@@@@@@@@@@@@@@@@@@@@@@@@@@@         
                                            @@@@@@@@@@@@@@@@@@@@@@@@            
                                               @@@@@@@@@@@@@@@@@@               
                                                    @@@@@@@@                    
```
## License

At CodeScreen, we strongly value the integrity and privacy of our assessments. As a result, this repository is under exclusive copyright, which means you **do not** have permission to share your solution to this test publicly (i.e., inside a public GitHub/GitLab repo, on Reddit, etc.). <br>

## Submitting your solution

Please push your changes to the `main branch` of this repository. You can push one or more commits. <br>

Once you are finished with the task, please click the `Submit Solution` link on <a href="https://app.codescreen.com/candidate/9242f07d-198f-4481-a66e-584706e2fc47" target="_blank">this screen</a>.