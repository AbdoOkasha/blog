package c3s.blog.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "blogDetails")
public class BlogDetails {

    @DynamoDBTypeConvertedJson
    @Id
    @DynamoDBAttribute
    @DynamoDBIgnore
    PrimaryKey primaryKey;
//    @DynamoDBAutoGeneratedKey
//            @DynamoDBHashKey
//    String id;

    @DynamoDBTypeConvertedJson
    @DynamoDBAttribute
//    @NotNull
    User user;

//    @DynamoDBAttribute
//    String address;

    @DynamoDBTypeConvertedJson
    @DynamoDBAttribute
    Post posts;
//
//    @DynamoDBAttribute
//    @DynamoDBTypeConvertedJson
//    Comment comments;
//
//    @DynamoDBAttribute
//    @DynamoDBTypeConvertedJson
//    User followers;

    public BlogDetails( User user) {
        this.user = user;
    }

    public BlogDetails( User user, Post posts) {
        this.user = user;
        this.posts = posts;
    }

//    public BlogDetails(BlogDetails bd){
//        this.user=bd.getUser();
//        this.primaryKey=bd.getPrimaryKey();
//    }


    @DynamoDBHashKey
    @DynamoDBAttribute
    public String getHashKey() {
        return primaryKey != null ? primaryKey.getHashKey() : null;
    }

    public void setHashKey(final String partitionKey) {
        if (primaryKey == null) {
            primaryKey = new PrimaryKey();
        }
        primaryKey.setHashKey(partitionKey);
    }

    @DynamoDBRangeKey
    @DynamoDBAttribute
    @DynamoDBAutoGeneratedKey
    public String getRangeKey() {
        return primaryKey != null ? primaryKey.getRangeKey() : null;
    }

    public void setRangeKey(final String sortKey) {
        if (primaryKey == null) {
            primaryKey = new PrimaryKey();
        }
        primaryKey.setRangeKey(sortKey);
    }

    //    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
}
