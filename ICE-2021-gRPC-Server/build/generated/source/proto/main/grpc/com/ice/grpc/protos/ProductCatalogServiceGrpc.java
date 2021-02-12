package com.ice.grpc.protos;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: ProductCatalog.proto")
public final class ProductCatalogServiceGrpc {

  private ProductCatalogServiceGrpc() {}

  public static final String SERVICE_NAME = "com.ice.shopping.ProductCatalogService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.ice.grpc.protos.ProductListRequest,
      com.ice.grpc.protos.ProductListResponse> getFilterProductByCategoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "filterProductByCategory",
      requestType = com.ice.grpc.protos.ProductListRequest.class,
      responseType = com.ice.grpc.protos.ProductListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ice.grpc.protos.ProductListRequest,
      com.ice.grpc.protos.ProductListResponse> getFilterProductByCategoryMethod() {
    io.grpc.MethodDescriptor<com.ice.grpc.protos.ProductListRequest, com.ice.grpc.protos.ProductListResponse> getFilterProductByCategoryMethod;
    if ((getFilterProductByCategoryMethod = ProductCatalogServiceGrpc.getFilterProductByCategoryMethod) == null) {
      synchronized (ProductCatalogServiceGrpc.class) {
        if ((getFilterProductByCategoryMethod = ProductCatalogServiceGrpc.getFilterProductByCategoryMethod) == null) {
          ProductCatalogServiceGrpc.getFilterProductByCategoryMethod = getFilterProductByCategoryMethod =
              io.grpc.MethodDescriptor.<com.ice.grpc.protos.ProductListRequest, com.ice.grpc.protos.ProductListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "filterProductByCategory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ice.grpc.protos.ProductListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ice.grpc.protos.ProductListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProductCatalogServiceMethodDescriptorSupplier("filterProductByCategory"))
              .build();
        }
      }
    }
    return getFilterProductByCategoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ice.grpc.protos.ProductListRequest,
      com.ice.grpc.protos.ProductListResponse> getGetProductListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getProductList",
      requestType = com.ice.grpc.protos.ProductListRequest.class,
      responseType = com.ice.grpc.protos.ProductListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.ice.grpc.protos.ProductListRequest,
      com.ice.grpc.protos.ProductListResponse> getGetProductListMethod() {
    io.grpc.MethodDescriptor<com.ice.grpc.protos.ProductListRequest, com.ice.grpc.protos.ProductListResponse> getGetProductListMethod;
    if ((getGetProductListMethod = ProductCatalogServiceGrpc.getGetProductListMethod) == null) {
      synchronized (ProductCatalogServiceGrpc.class) {
        if ((getGetProductListMethod = ProductCatalogServiceGrpc.getGetProductListMethod) == null) {
          ProductCatalogServiceGrpc.getGetProductListMethod = getGetProductListMethod =
              io.grpc.MethodDescriptor.<com.ice.grpc.protos.ProductListRequest, com.ice.grpc.protos.ProductListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getProductList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ice.grpc.protos.ProductListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ice.grpc.protos.ProductListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProductCatalogServiceMethodDescriptorSupplier("getProductList"))
              .build();
        }
      }
    }
    return getGetProductListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ice.grpc.protos.ProductImageRequest,
      com.ice.grpc.protos.ProductImageResponse> getGetProductImageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getProductImage",
      requestType = com.ice.grpc.protos.ProductImageRequest.class,
      responseType = com.ice.grpc.protos.ProductImageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.ice.grpc.protos.ProductImageRequest,
      com.ice.grpc.protos.ProductImageResponse> getGetProductImageMethod() {
    io.grpc.MethodDescriptor<com.ice.grpc.protos.ProductImageRequest, com.ice.grpc.protos.ProductImageResponse> getGetProductImageMethod;
    if ((getGetProductImageMethod = ProductCatalogServiceGrpc.getGetProductImageMethod) == null) {
      synchronized (ProductCatalogServiceGrpc.class) {
        if ((getGetProductImageMethod = ProductCatalogServiceGrpc.getGetProductImageMethod) == null) {
          ProductCatalogServiceGrpc.getGetProductImageMethod = getGetProductImageMethod =
              io.grpc.MethodDescriptor.<com.ice.grpc.protos.ProductImageRequest, com.ice.grpc.protos.ProductImageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getProductImage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ice.grpc.protos.ProductImageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ice.grpc.protos.ProductImageResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProductCatalogServiceMethodDescriptorSupplier("getProductImage"))
              .build();
        }
      }
    }
    return getGetProductImageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ice.grpc.protos.ProductDetailRequest,
      com.ice.grpc.protos.ProductDetailResponse> getGetProductByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getProductById",
      requestType = com.ice.grpc.protos.ProductDetailRequest.class,
      responseType = com.ice.grpc.protos.ProductDetailResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ice.grpc.protos.ProductDetailRequest,
      com.ice.grpc.protos.ProductDetailResponse> getGetProductByIdMethod() {
    io.grpc.MethodDescriptor<com.ice.grpc.protos.ProductDetailRequest, com.ice.grpc.protos.ProductDetailResponse> getGetProductByIdMethod;
    if ((getGetProductByIdMethod = ProductCatalogServiceGrpc.getGetProductByIdMethod) == null) {
      synchronized (ProductCatalogServiceGrpc.class) {
        if ((getGetProductByIdMethod = ProductCatalogServiceGrpc.getGetProductByIdMethod) == null) {
          ProductCatalogServiceGrpc.getGetProductByIdMethod = getGetProductByIdMethod =
              io.grpc.MethodDescriptor.<com.ice.grpc.protos.ProductDetailRequest, com.ice.grpc.protos.ProductDetailResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getProductById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ice.grpc.protos.ProductDetailRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ice.grpc.protos.ProductDetailResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProductCatalogServiceMethodDescriptorSupplier("getProductById"))
              .build();
        }
      }
    }
    return getGetProductByIdMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProductCatalogServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductCatalogServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductCatalogServiceStub>() {
        @java.lang.Override
        public ProductCatalogServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductCatalogServiceStub(channel, callOptions);
        }
      };
    return ProductCatalogServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProductCatalogServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductCatalogServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductCatalogServiceBlockingStub>() {
        @java.lang.Override
        public ProductCatalogServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductCatalogServiceBlockingStub(channel, callOptions);
        }
      };
    return ProductCatalogServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProductCatalogServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductCatalogServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductCatalogServiceFutureStub>() {
        @java.lang.Override
        public ProductCatalogServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductCatalogServiceFutureStub(channel, callOptions);
        }
      };
    return ProductCatalogServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ProductCatalogServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void filterProductByCategory(com.ice.grpc.protos.ProductListRequest request,
        io.grpc.stub.StreamObserver<com.ice.grpc.protos.ProductListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFilterProductByCategoryMethod(), responseObserver);
    }

    /**
     * <pre>
     * Bi-directional
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.ice.grpc.protos.ProductListRequest> getProductList(
        io.grpc.stub.StreamObserver<com.ice.grpc.protos.ProductListResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getGetProductListMethod(), responseObserver);
    }

    /**
     * <pre>
     * server Stream
     * </pre>
     */
    public void getProductImage(com.ice.grpc.protos.ProductImageRequest request,
        io.grpc.stub.StreamObserver<com.ice.grpc.protos.ProductImageResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetProductImageMethod(), responseObserver);
    }

    /**
     */
    public void getProductById(com.ice.grpc.protos.ProductDetailRequest request,
        io.grpc.stub.StreamObserver<com.ice.grpc.protos.ProductDetailResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetProductByIdMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFilterProductByCategoryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.ice.grpc.protos.ProductListRequest,
                com.ice.grpc.protos.ProductListResponse>(
                  this, METHODID_FILTER_PRODUCT_BY_CATEGORY)))
          .addMethod(
            getGetProductListMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                com.ice.grpc.protos.ProductListRequest,
                com.ice.grpc.protos.ProductListResponse>(
                  this, METHODID_GET_PRODUCT_LIST)))
          .addMethod(
            getGetProductImageMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.ice.grpc.protos.ProductImageRequest,
                com.ice.grpc.protos.ProductImageResponse>(
                  this, METHODID_GET_PRODUCT_IMAGE)))
          .addMethod(
            getGetProductByIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.ice.grpc.protos.ProductDetailRequest,
                com.ice.grpc.protos.ProductDetailResponse>(
                  this, METHODID_GET_PRODUCT_BY_ID)))
          .build();
    }
  }

  /**
   */
  public static final class ProductCatalogServiceStub extends io.grpc.stub.AbstractAsyncStub<ProductCatalogServiceStub> {
    private ProductCatalogServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductCatalogServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductCatalogServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void filterProductByCategory(com.ice.grpc.protos.ProductListRequest request,
        io.grpc.stub.StreamObserver<com.ice.grpc.protos.ProductListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFilterProductByCategoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Bi-directional
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.ice.grpc.protos.ProductListRequest> getProductList(
        io.grpc.stub.StreamObserver<com.ice.grpc.protos.ProductListResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getGetProductListMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * server Stream
     * </pre>
     */
    public void getProductImage(com.ice.grpc.protos.ProductImageRequest request,
        io.grpc.stub.StreamObserver<com.ice.grpc.protos.ProductImageResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetProductImageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getProductById(com.ice.grpc.protos.ProductDetailRequest request,
        io.grpc.stub.StreamObserver<com.ice.grpc.protos.ProductDetailResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProductByIdMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ProductCatalogServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ProductCatalogServiceBlockingStub> {
    private ProductCatalogServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductCatalogServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductCatalogServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public com.ice.grpc.protos.ProductListResponse filterProductByCategory(com.ice.grpc.protos.ProductListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFilterProductByCategoryMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * server Stream
     * </pre>
     */
    public java.util.Iterator<com.ice.grpc.protos.ProductImageResponse> getProductImage(
        com.ice.grpc.protos.ProductImageRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetProductImageMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ice.grpc.protos.ProductDetailResponse getProductById(com.ice.grpc.protos.ProductDetailRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProductByIdMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ProductCatalogServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ProductCatalogServiceFutureStub> {
    private ProductCatalogServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductCatalogServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductCatalogServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ice.grpc.protos.ProductListResponse> filterProductByCategory(
        com.ice.grpc.protos.ProductListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFilterProductByCategoryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ice.grpc.protos.ProductDetailResponse> getProductById(
        com.ice.grpc.protos.ProductDetailRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProductByIdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FILTER_PRODUCT_BY_CATEGORY = 0;
  private static final int METHODID_GET_PRODUCT_IMAGE = 1;
  private static final int METHODID_GET_PRODUCT_BY_ID = 2;
  private static final int METHODID_GET_PRODUCT_LIST = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProductCatalogServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProductCatalogServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FILTER_PRODUCT_BY_CATEGORY:
          serviceImpl.filterProductByCategory((com.ice.grpc.protos.ProductListRequest) request,
              (io.grpc.stub.StreamObserver<com.ice.grpc.protos.ProductListResponse>) responseObserver);
          break;
        case METHODID_GET_PRODUCT_IMAGE:
          serviceImpl.getProductImage((com.ice.grpc.protos.ProductImageRequest) request,
              (io.grpc.stub.StreamObserver<com.ice.grpc.protos.ProductImageResponse>) responseObserver);
          break;
        case METHODID_GET_PRODUCT_BY_ID:
          serviceImpl.getProductById((com.ice.grpc.protos.ProductDetailRequest) request,
              (io.grpc.stub.StreamObserver<com.ice.grpc.protos.ProductDetailResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_PRODUCT_LIST:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getProductList(
              (io.grpc.stub.StreamObserver<com.ice.grpc.protos.ProductListResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ProductCatalogServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProductCatalogServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ice.grpc.protos.ProductCatalog.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProductCatalogService");
    }
  }

  private static final class ProductCatalogServiceFileDescriptorSupplier
      extends ProductCatalogServiceBaseDescriptorSupplier {
    ProductCatalogServiceFileDescriptorSupplier() {}
  }

  private static final class ProductCatalogServiceMethodDescriptorSupplier
      extends ProductCatalogServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProductCatalogServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ProductCatalogServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProductCatalogServiceFileDescriptorSupplier())
              .addMethod(getFilterProductByCategoryMethod())
              .addMethod(getGetProductListMethod())
              .addMethod(getGetProductImageMethod())
              .addMethod(getGetProductByIdMethod())
              .build();
        }
      }
    }
    return result;
  }
}
