package br.com.wendel.segadilha.encurtadorurl.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "links")
@SequenceGenerator(name = "seq_links", sequenceName = "seq_links", allocationSize = 1, initialValue = 1)
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_links")
    private Long id;
    private String urlOriginal;
    private String urlEncurtada;
    private String sufixo;

    public Link() {
    }

    public Link(String urlOriginal) {
        this.urlOriginal = urlOriginal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlOriginal() {
        return urlOriginal;
    }

    public void setUrlOriginal(String urlOriginal) {
        this.urlOriginal = urlOriginal;
    }

    public String getUrlEncurtada() {
        return urlEncurtada;
    }

    public void setUrlEncurtada(String urlEncurtada) {
        this.urlEncurtada = urlEncurtada;
    }

    public String getSufixo() {
        return sufixo;
    }

    public void setSufixo(String sufixo) {
        this.sufixo = sufixo;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Link link)) return false;
        return Objects.equals(id, link.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
