package project.nft.nft.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "top-collections")
public class TopCollections {
    @Id
    private String _id;

    @Field
    private String name;

    @Field
    private String link;

    @Field
    private String volume;

    @Field
    private String image;


    public TopCollections(String _id, String name, String link, String volume, String image) {
        this._id = _id;
        this.name = name;
        this.link = link;
        this.volume = volume;
        this.image = image;
    }

    public TopCollections() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
