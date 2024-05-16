**Important: Don't forget to update the [Candidate README](#candidate-readme) section**

Real-time Transaction
===============================
## Details
The service accepts 2 types of transactions:
1) Loads: Add money to a user (credit)
2) Authorizations: Conditionally remove money from a user (debit)
Every load or authorization PUT should return the updated balance following the transaction. Authorization declines should be saved, even if they do not impact balance calculation.

# README
To run:
1. Make sure you have Java 17 install.
2. Clone the repository.
3. Run the application through TransactionServiceApplication.java file.
4. Application will start running (port 8080) on "hhtp;//localhost:8080".

## Design considerations
1. The service is bulid using Spring framework and Java 17 tried using the concept of event sourcing through logging each transaction.
2. I tried to follow standard architecture which I know separating controller, services and model layers.
3. The `Controller` handles the incoming requests and delegates the processing to the `TransactionService`.
4. The `Service` contains the business logic for processing transactions, includes authorization and loading of user balance.
5. The Models contains all the schema which is define in service.yml file.
6. The Event contains event that needs to be log, allows for capturing and storing all the changes in the system.


## Deployment considerations

Hosting the service on a cloud platform like Amazon Web Services (AWS) or Google Cloud Platform (GCP) will be help full in leverage their scalability and reliability.

1. Containerizing the application using Docker will ensure portability and ease of deployment across different environments.
2. I would use a dedicated event store database like Apache Kafka to persist the events unlike I did in-memory. These databases are optimized for storing and retrieving event streams and provide scalability and fault tolerance.
3. Implementing a CI/CD pipeline using tools to automate the build, testing, and deployment processes.
4. Implementing secure communication using HTTPS and API authentication mechanisms to protect sensitive data.
5. Monitoring the application using tools like Grafana to gain insights into performance, errors, and usage patterns.
7. I dont have a robust error handling way implemented such that retry mechanism to handle transient failures and ensure data consistency.
8. Regularly backing up the transaction data and implementing disaster recovery procedures to minimize data loss in case of failures.
