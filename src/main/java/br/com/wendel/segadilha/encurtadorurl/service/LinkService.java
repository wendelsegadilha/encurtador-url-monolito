package br.com.wendel.segadilha.encurtadorurl.service;

import br.com.wendel.segadilha.encurtadorurl.model.Link;
import br.com.wendel.segadilha.encurtadorurl.repository.LinkRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LinkService {

    private final static Logger LOGGER = LoggerFactory.getLogger(LinkService.class);

    private final LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public Link salvar(Link link, String urlApp) {
        defineSufixoUrlEncurtada(link, urlApp);
        return linkRepository.save(link);
    }

    private String gerarSufixo() {
        return RandomStringUtils.randomAlphanumeric(5, 10);
    }

    public void defineSufixoUrlEncurtada(Link link, String urlApp) {
        var sufixo = "";
        do {
            sufixo = gerarSufixo();
        } while (linkRepository.existsLinkBySufixo(sufixo));
        var urlEncurtada = urlApp.replace("encurtar-url", sufixo);
        link.setSufixo(sufixo);
        link.setUrlEncurtada(urlEncurtada);
    }

    public String buscarUrlOriginal(String sufixo) {
        var link = linkRepository.findLinkBySufixo(sufixo);
        if (link == null) {
            return "";
        }
        return link.getUrlOriginal();
    }

    public void popularBanco() {
        int quantidadeLinks = linkRepository.quantidadeLinks();
        LOGGER.info("Quantidade de registros existentes: {} ", quantidadeLinks);
        if (quantidadeLinks == 0) {
            var quantidade = 10000;
            var urlApp = "http://localhost:8080/encurtar-url";
            var links = new ArrayList<Link>();
            for (int i = 0; i < quantidade; i++) {
                var link = new Link("https://www.google.com.br/");
                defineSufixoUrlEncurtada(link, urlApp);
                links.add(link);
            }
            linkRepository.saveAll(links);
            LOGGER.info("Database populda com sucesso: {} registros cadastrados." ,quantidadeLinks);
        }
    }

}
