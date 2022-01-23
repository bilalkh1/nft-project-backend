package project.nft.nft.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Collection {
    @Id
    private String _id;

    @Field
    private String number;

    @Field
    private String name;

    @Field
    private String totalSupply;

    @Field
    private String owners;

    @Field
    private String estimatedMarketCap;

}
