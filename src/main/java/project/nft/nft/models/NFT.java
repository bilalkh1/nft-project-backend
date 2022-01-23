package project.nft.nft.models;

public class NFT {
    private String img;
    private String title;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public NFT(String img, String title) {
        this.img = img;
        this.title = title;
    }
}
