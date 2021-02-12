// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ProductCatalog.proto

package com.ice.grpc.protos;

/**
 * Protobuf enum {@code com.ice.shopping.ProductCategory}
 */
public enum ProductCategory
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>ALL = 0;</code>
   */
  ALL(0),
  /**
   * <code>DESSERTS = 1;</code>
   */
  DESSERTS(1),
  /**
   * <code>DAIRY = 2;</code>
   */
  DAIRY(2),
  /**
   * <code>BEVERAGES = 3;</code>
   */
  BEVERAGES(3),
  /**
   * <code>SPICES = 4;</code>
   */
  SPICES(4),
  /**
   * <code>BREADS = 5;</code>
   */
  BREADS(5),
  /**
   * <code>BAKERY = 6;</code>
   */
  BAKERY(6),
  /**
   * <code>FRUITS = 7;</code>
   */
  FRUITS(7),
  /**
   * <code>VEGETABLES = 8;</code>
   */
  VEGETABLES(8),
  /**
   * <code>COOKIES = 9;</code>
   */
  COOKIES(9),
  /**
   * <code>HERBS = 10;</code>
   */
  HERBS(10),
  /**
   * <code>OILS = 11;</code>
   */
  OILS(11),
  /**
   * <code>CHEESE = 12;</code>
   */
  CHEESE(12),
  /**
   * <code>DRINKS = 13;</code>
   */
  DRINKS(13),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>ALL = 0;</code>
   */
  public static final int ALL_VALUE = 0;
  /**
   * <code>DESSERTS = 1;</code>
   */
  public static final int DESSERTS_VALUE = 1;
  /**
   * <code>DAIRY = 2;</code>
   */
  public static final int DAIRY_VALUE = 2;
  /**
   * <code>BEVERAGES = 3;</code>
   */
  public static final int BEVERAGES_VALUE = 3;
  /**
   * <code>SPICES = 4;</code>
   */
  public static final int SPICES_VALUE = 4;
  /**
   * <code>BREADS = 5;</code>
   */
  public static final int BREADS_VALUE = 5;
  /**
   * <code>BAKERY = 6;</code>
   */
  public static final int BAKERY_VALUE = 6;
  /**
   * <code>FRUITS = 7;</code>
   */
  public static final int FRUITS_VALUE = 7;
  /**
   * <code>VEGETABLES = 8;</code>
   */
  public static final int VEGETABLES_VALUE = 8;
  /**
   * <code>COOKIES = 9;</code>
   */
  public static final int COOKIES_VALUE = 9;
  /**
   * <code>HERBS = 10;</code>
   */
  public static final int HERBS_VALUE = 10;
  /**
   * <code>OILS = 11;</code>
   */
  public static final int OILS_VALUE = 11;
  /**
   * <code>CHEESE = 12;</code>
   */
  public static final int CHEESE_VALUE = 12;
  /**
   * <code>DRINKS = 13;</code>
   */
  public static final int DRINKS_VALUE = 13;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static ProductCategory valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static ProductCategory forNumber(int value) {
    switch (value) {
      case 0: return ALL;
      case 1: return DESSERTS;
      case 2: return DAIRY;
      case 3: return BEVERAGES;
      case 4: return SPICES;
      case 5: return BREADS;
      case 6: return BAKERY;
      case 7: return FRUITS;
      case 8: return VEGETABLES;
      case 9: return COOKIES;
      case 10: return HERBS;
      case 11: return OILS;
      case 12: return CHEESE;
      case 13: return DRINKS;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<ProductCategory>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      ProductCategory> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<ProductCategory>() {
          public ProductCategory findValueByNumber(int number) {
            return ProductCategory.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return com.ice.grpc.protos.ProductCatalog.getDescriptor().getEnumTypes().get(0);
  }

  private static final ProductCategory[] VALUES = values();

  public static ProductCategory valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private ProductCategory(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:com.ice.shopping.ProductCategory)
}
