# gRPC-Demo
### How to Build on local system

#### Prerequisite
1. Java JDK
2. Android studio
3. Mongo DB
4. Protocol buffer compiler - https://github.com/protocolbuffers/protobuf/releases/tag/v3.14.0


#### Local Setup
1. Clone the repo, it has 2 projects ICE-2021-Android which is android project for client side and ICE-2021-gRPC-Server java based server.
2. Import ProductCollection.csv into mongodb, you can use mongoimport - https://docs.mongodb.com/database-tools/mongoimport/
3. Run there should be single collection in the database called ProductCollection which has nearly 1000 random records.
4. Make sure path to mongodb is there in your PATH variable, then run mongod --dbpath /path/to/your/database/. It should be runing at default port 27017

#### Java Server 

1. Build the project with gradle build system. 
2. once build you will have task called "generateProto" which you can run to generate stub code.
3. Now run the class which start the server - grpc/server/EcommerceServer.java, It will open 30071 post for GRPC request

#### Android Client

1. Import the project in Android sudio. It may ask to install SDK platforms, follow the on screen instructions.
2. build the project with gradle, it will generate the Stubs automatically
3. Make sure to update your system IP address where server is running at 2 places  - 1) src/main/java/edu/sapient/ice/UnaryDemo.kt in getChannel() and 2) src/main/java/edu/sapient/ice/BiDirectionalDemo.kt in getChannel()
3. Run the app in emulator.


