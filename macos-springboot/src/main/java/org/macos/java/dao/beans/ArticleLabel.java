package org.macos.java.dao.beans;

public class ArticleLabel {
    private String article_id;
    private String serial_id;
    private int emotion;
    private String brand_id;
    private double master_brand_ratio;
    private String label_json;

    public int getEmotion() {
        return emotion;
    }

    public void setEmotion(int emotion) {
        this.emotion = emotion;
    }

    public String getArticle_id() {
        return article_id;
    }

    public void setArticle_id(String article_id) {
        this.article_id = article_id;
    }

    public String getSerial_id() {
        return serial_id;
    }

    public void setSerial_id(String serial_id) {
        this.serial_id = serial_id;
    }

    public String getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(String brand_id) {
        this.brand_id = brand_id;
    }

    public double getMaster_brand_ratio() {
        return master_brand_ratio;
    }

    public void setMaster_brand_ratio(double master_brand_ratio) {
        this.master_brand_ratio = master_brand_ratio;
    }

    public String getLabel_json() {
        return label_json;
    }

    public void setLabel_json(String label_json) {
        this.label_json = label_json;
    }
}
