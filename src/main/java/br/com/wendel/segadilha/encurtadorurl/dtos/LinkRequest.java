package br.com.wendel.segadilha.encurtadorurl.dtos;

import br.com.wendel.segadilha.encurtadorurl.model.Link;

public class LinkRequest {

    private String urlOriginal;

    public LinkRequest() {
    }

    public LinkRequest(String urlOriginal) {
        this.urlOriginal = urlOriginal;
    }

    public String getUrlOriginal() {
        return urlOriginal;
    }

    public void setUrlOriginal(String urlOriginal) {
        this.urlOriginal = urlOriginal;
    }

    public Link toLink() {
        return new Link(this.urlOriginal);
    }

}
