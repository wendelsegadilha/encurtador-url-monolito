package br.com.wendel.segadilha.encurtadorurl.dtos;

import br.com.wendel.segadilha.encurtadorurl.model.Link;

public class LinkResponse {

    private String urlEncurtada;

    public LinkResponse() {
    }

    public LinkResponse(String urlEncurtada) {
        this.urlEncurtada = urlEncurtada;
    }

    public String getUrlEncurtada() {
        return urlEncurtada;
    }

    public void setUrlEncurtada(String urlEncurtada) {
        this.urlEncurtada = urlEncurtada;
    }

    public static LinkResponse toResponse(Link link) {
        return new LinkResponse(link.getUrlEncurtada());
    }

}
