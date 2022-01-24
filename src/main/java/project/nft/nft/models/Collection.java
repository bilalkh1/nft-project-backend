package project.nft.nft.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "collections")
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

    public NFT[] getNfts() {
        return nfts;
    }

    public void setNfts(NFT[] nfts) {
        this.nfts = nfts;
    }

    public Collection() {
    }

    public Collection(String _id,
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

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(String totalSupply) {
        this.totalSupply = totalSupply;
    }

    public String getOwners() {
        return owners;
    }

    public void setOwners(String owners) {
        this.owners = owners;
    }

    public String getEstimatedMarketCap() {
        return estimatedMarketCap;
    }

    public void setEstimatedMarketCap(String estimatedMarketCap) {
        this.estimatedMarketCap = estimatedMarketCap;
    }

    public String getAdded() {
        return Added;
    }

    public void setAdded(String added) {
        Added = added;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImgCover() {
        return imgCover;
    }

    public void setImgCover(String imgCover) {
        this.imgCover = imgCover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }

    public String getDiscord() {
        return Discord;
    }

    public void setDiscord(String discord) {
        Discord = discord;
    }

    public String getTwitter() {
        return Twitter;
    }

    public void setTwitter(String twitter) {
        Twitter = twitter;
    }

    public String getVolume_7d() {
        return volume_7d;
    }

    public void setVolume_7d(String volume_7d) {
        this.volume_7d = volume_7d;
    }

    public String getAvg_price_7d() {
        return avg_price_7d;
    }

    public void setAvg_price_7d(String avg_price_7d) {
        this.avg_price_7d = avg_price_7d;
    }

    public String getSales_7d() {
        return sales_7d;
    }

    public void setSales_7d(String sales_7d) {
        this.sales_7d = sales_7d;
    }

    public String getSales_all_time() {
        return sales_all_time;
    }

    public void setSales_all_time(String sales_all_time) {
        this.sales_all_time = sales_all_time;
    }

    public String getVolume_all_time() {
        return volume_all_time;
    }

    public void setVolume_all_time(String volume_all_time) {
        this.volume_all_time = volume_all_time;
    }

    public String getOwners_percentage() {
        return owners_percentage;
    }

    public void setOwners_percentage(String owners_percentage) {
        this.owners_percentage = owners_percentage;
    }

    @Override
    public String toString() {
        return  name + ';' +
                totalSupply + ';' +
                owners + ';' +
                estimatedMarketCap + ';' +
                volume_7d + ';' +
                avg_price_7d + ';' +
                sales_7d + ';' +
                sales_all_time + ';' +
                volume_all_time + ';' +
                owners_percentage + '\n';
    }
}
