package grpc.server;

import com.ice.grpc.protos.Product;
import com.ice.grpc.protos.ProductCatalogServiceGrpc;
import com.ice.grpc.protos.ProductDetailRequest;
import com.ice.grpc.protos.ProductDetailResponse;
import com.ice.grpc.protos.ProductImageRequest;
import com.ice.grpc.protos.ProductImageResponse;
import com.ice.grpc.protos.ProductListRequest;
import com.ice.grpc.protos.ProductListResponse;

import grpc.database.ProductDao;
import io.grpc.stub.StreamObserver;

import java.util.List;

class ProductCatalogServiceImpl extends ProductCatalogServiceGrpc.ProductCatalogServiceImplBase {

    @Override
    public void getProductById(ProductDetailRequest request, StreamObserver<ProductDetailResponse> responseObserver) {
        // ToDo Implementation pending
        System.out.println("Product request to server -> " + request.getProductId());
    }

    /**
     * BiDirectional Streaming: Client send page numbers, server send product lists for the requested page number
     * @param responseObserver
     * @return
     */
    @Override
    public StreamObserver<ProductListRequest> getProductList(StreamObserver<ProductListResponse> responseObserver) {

        return new StreamObserver<ProductListRequest>() {

            @Override
            public void onNext(ProductListRequest request) {
                // Client Request next set of data
                ProductDao dao = new ProductDao();
                List<Product> products = dao.getAllProductsForCategory(request.getProductType(), request.getPageNumber());
                if (products.size() == 0) {
                    responseObserver.onCompleted();
                    return;
                }
                ProductListResponse response = ProductListResponse.newBuilder()
                        .addAllProducts(products)
                        .setTotalPages(dao.getTotalPageCount(request.getProductType()))
                        .build();
                responseObserver.onNext(response);
            }

            @Override
            public void onError(Throwable t) {
                responseObserver.onCompleted();
            }

            @Override
            public void onCompleted() {
                // Client closed the stream
                responseObserver.onCompleted();
            }
        };
    }

    /**
     * Unary communication - Client request for a single page number, server send list of products for the same
     * @param request
     * @param responseObserver
     */
    @Override
    public void filterProductByCategory(ProductListRequest request, StreamObserver<ProductListResponse> responseObserver) {

        ProductDao dao = new ProductDao();
        ProductListResponse response = ProductListResponse.newBuilder()
                .addAllProducts(dao.getAllProductsForCategory(request.getProductType(), request.getPageNumber()))
                .setTotalPages(dao.getTotalPageCount(request.getProductType()))
                .build();
        responseObserver.onNext(response);   // Publish result like Reactive Programming
        responseObserver.onCompleted();     // Closing the stream
//        responseObserver.onError();       To Send any specific Error
    }

    @Override
    public void getProductImage(ProductImageRequest request, StreamObserver<ProductImageResponse> responseObserver) {
        // ToDo Implementation pending
        super.getProductImage(request, responseObserver);
    }
}
