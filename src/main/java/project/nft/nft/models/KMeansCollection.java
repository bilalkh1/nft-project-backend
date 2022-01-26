package project.nft.nft.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collection;

@Document(collection = "KMeansCollections")
public class KMeansCollection {

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

    @Field
    private String Added;

    @Field
    private String link;

    @Field
    private String image;

    @Field
    private String imgCover;

    @Field
    private String description;

    @Field
    private String Website;

    @Field
    private String Discord;

    @Field
    private String Twitter;

    @Field
    private String volume_7d;

    @Field
    private String avg_price_7d;

    @Field
    private String sales_7d;

    @Field
    private String sales_all_time;

    @Field
    private String volume_all_time;

    @Field
    private String owners_percentage;

    @Field
    private NFT[] nfts;

    public KMeansCollection() {
    }

    public KMeansCollection(String _id,
                      String number,
                      String name,
                      String totalSupply,
                      String owners,
                      String estimatedMarketCap,
                      String added,
                      String link,
                      String image,
                      String imgCover,
                      String description,
                      String website,
                      String discord,
                      String twitter,
                      String volume_7d,
                      String avg_price_7d,
                      String sales_7d,
                      String sales_all_time,
                      String volume_all_time,
                      String owners_percentage) {
        this._id = _id;
        this.number = number;
        this.name = name;
        this.totalSupply = totalSupply;
        this.owners = owners;
        this.estimatedMarketCap = estimatedMarketCap;
        Added = added;
        this.link = link;
        this.image = image;
        this.imgCover = imgCover;
        this.description = description;
        Website = website;
        Discord = discord;
        Twitter = twitter;
        this.volume_7d = volume_7d;
        this.avg_price_7d = avg_price_7d;
        this.sales_7d = sales_7d;
        this.sales_all_time = sales_all_time;
        this.volume_all_time = volume_all_time;
        this.owners_percentage = owners_percentage;
    }
}
