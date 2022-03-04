//package c3s.blog.repository;
//
//import c3s.blog.entity.BlogDetails;
//import c3s.blog.entity.PrimaryKey;
//import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
//import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTransactionLoadExpression;
//import com.amazonaws.services.dynamodbv2.document.DynamoDB;
//import com.amazonaws.services.dynamodbv2.document.Item;
//import com.amazonaws.services.dynamodbv2.document.Table;
//import org.socialsignin.spring.data.dynamodb.repository.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//
//@Repository
//public class DynamoDBCustomRepo {
//
////    @Autowired
////    DynamoDBMapper dynamoDBMapper;
//
//    static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
//    static DynamoDB dynamoDB = new DynamoDB(client);
//
//
////    public BlogDetails save(BlogDetails obj){
////        dynamoDBMapper.save(obj);
////        return obj;
////    }
//
//    public Item findById(String id){
//        Table table = dynamoDB.getTable("blogDetails");
//        Item item=null;
//        try{
//            item = table.getItem("hashKey",id);
//        } catch (Exception e){
//            System.out.println("item not found");
//        }
//        return item;
////        System.out.println(id.getHashKey()+ " "+id.getRangeKey());
////        return dynamoDBMapper.load(BlogDetails.class,id);
//    }
//
//}
