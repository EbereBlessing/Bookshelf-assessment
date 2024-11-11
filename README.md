# Bookshelf Assessment - Coding Challenge
## Prerequisites
Docker installed on your system.
### Step 1: Docker Installation (if required)
If you're using Ubuntu, you can install Docker and its dependencies by running the provided bash.sh script in the working directory. For other operating systems, please refer to the official Docker documentation for installation instructions.

### Step 2: Deploy the Book Catalog Service
Navigate to the bookcatalog directory:

bash
Copy code
cd bookcatalog
Build the Docker image using the Dockerfile located in the directory:

bash
Copy code
docker build --rm -t ebereblessing/book-catalog-service .
Once the image is built, run the Docker container with the following command:

bash
Copy code
docker run -d --name book-catalog-service --net host --restart unless-stopped ebereblessing/book-catalog-service:latest
Note:
The Docker image has already been pushed to my Docker Hub account and is made public. If you prefer, you can skip the first two steps and directly run the following command:

bash
Copy code
docker run -d --name book-catalog-service --net host --restart unless-stopped ebereblessing/book-catalog-service:latest
You have the option to change the repository name and push the image to a different repository to make it accessible to other team members or build it locally for personal use.

###  Deploy the Book Catalog Management Service
Navigate to the bookcatalog-management-service directory:

bash
Copy code
cd bookcatalog
Build the Docker image using the Dockerfile located in the directory:

bash
Copy code
docker build --rm -t ebereblessing/book-catalog-service .
Once the image is built, run the Docker container with the following command:

bash
Copy code
docker run -d --name book-catalog-service --net host --restart unless-stopped ebereblessing/book-catalog-service:latest
Note:
The Docker image has already been pushed to my Docker Hub account and is made public. If you prefer, you can skip the first two steps and directly run the following command:

bash
Copy code
docker run -d --name book-catalog-service --net host --restart unless-stopped ebereblessing/book-catalog-service:latest
You have the option to change the repository name and push the image to a different repository to make it accessible to other team members or build it locally for personal use.