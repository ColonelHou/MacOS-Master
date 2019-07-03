package org.macos.java.dao.beans;

public class ArticleBean {
    private String title;
    private String document;

    public ArticleBean() {
    }

    public ArticleBean(String title, String document) {
        this.title = title;
        this.document = document;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}
