package grpc.database;


import com.ice.grpc.protos.Product;
import com.ice.grpc.protos.ProductCategory;
import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;

public class ProductDao {

    private final MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
    MongoDatabase database = mongoClient.getDatabase("MyGroceryShop");
    MongoCollection<Document> collection = database.getCollection("ProductCollection");
    private final int pageSize = 10;

    public static void main(String[] args) throws Exception {
        ProductDao dao = new ProductDao();
        dao.getAllProductsForCategory(ProductCategory.ALL, 1);
        dao.getTotalPageCount(ProductCategory.DAIRY);
    }

    public ArrayList<Product> getAllProductsForCategory(ProductCategory categoryName, int pageNumber) {

        Document query = new Document();
        if (categoryName != ProductCategory.ALL) {
            query.append("category", new Document("$regex", categoryName.name()).append("$options", "i"));
        }
        ArrayList<Product> products = new ArrayList<>();

        try (MongoCursor<Document> cur = collection.find(query).skip(pageSize * (pageNumber - 1)).limit(pageSize).iterator()) {

            while (cur.hasNext()) {
                var doc = cur.next();
                products.add(getProductFromDocument(doc));
            }
        }
        return products;
    }

    public int getTotalPageCount(ProductCategory categoryName) {
        Document query = new Document();
        if (categoryName != ProductCategory.ALL) {
            query.append("category", new Document("$regex", categoryName.name()).append("$options", "i"));
        }
        return (int) (collection.countDocuments(query)/pageSize);
    }

    private Product getProductFromDocument(Document dbResponse) {
        return Product.newBuilder()
                .setId(Math.toIntExact(dbResponse.getLong("id")))
                .setName(dbResponse.getString("product_name"))
                .setPrice(dbResponse.getDouble("price"))
                .setDescription(dbResponse.getString("description"))
                .setImageUrlSmall(dbResponse.getString("image_url_thumb"))
                .setImageUrlBig(dbResponse.getString("image_url_full"))
                .setCategory(getProductCategory(dbResponse)).build();
    }
    private ProductCategory getProductCategory(Document dbResponse) {
        String category = dbResponse.getString("category");
        if (category.equalsIgnoreCase(ProductCategory.DESSERTS.name()))
            return ProductCategory.DESSERTS;
        else if(category.equalsIgnoreCase(ProductCategory.DAIRY.name()))
            return ProductCategory.DAIRY;
        else if(category.equalsIgnoreCase(ProductCategory.BEVERAGES.name()))
            return ProductCategory.BEVERAGES;
        else if(category.equalsIgnoreCase(ProductCategory.SPICES.name()))
            return ProductCategory.SPICES;
        else if(category.equalsIgnoreCase(ProductCategory.BREADS.name()))
            return ProductCategory.BREADS;
        else if(category.equalsIgnoreCase(ProductCategory.BAKERY.name()))
            return ProductCategory.BAKERY;
        else if(category.equalsIgnoreCase(ProductCategory.FRUITS.name()))
            return ProductCategory.FRUITS;
        else if(category.equalsIgnoreCase(ProductCategory.VEGETABLES.name()))
            return ProductCategory.VEGETABLES;
        else if(category.equalsIgnoreCase(ProductCategory.HERBS.name()))
            return ProductCategory.HERBS;
        else if(category.equalsIgnoreCase(ProductCategory.OILS.name()))
            return ProductCategory.OILS;
        else if(category.equalsIgnoreCase(ProductCategory.DRINKS.name()))
            return ProductCategory.DRINKS;
        else if(category.equalsIgnoreCase(ProductCategory.CHEESE.name()))
            return ProductCategory.CHEESE;
        else if(category.equalsIgnoreCase(ProductCategory.COOKIES.name()))
            return ProductCategory.COOKIES;
        return ProductCategory.ALL;
    }

}
