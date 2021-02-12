package grpc.server;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

class EcommerceServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(30071)
                .addService(new ProductCatalogServiceImpl())
                .build();
        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Received Shutdown Request");
            server.shutdown();
            System.out.println("Successfully stopped the server");
        }));

        server.awaitTermination();
    }
}
