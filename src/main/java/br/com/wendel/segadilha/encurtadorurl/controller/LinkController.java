package br.com.wendel.segadilha.encurtadorurl.controller;

import br.com.wendel.segadilha.encurtadorurl.dtos.LinkRequest;
import br.com.wendel.segadilha.encurtadorurl.dtos.LinkResponse;
import br.com.wendel.segadilha.encurtadorurl.service.LinkService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping
public class LinkController {

    private final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/encurtar-url")
    public ResponseEntity<LinkResponse> encurtarUrl(@RequestBody LinkRequest linkRequest, HttpServletRequest request) {
        var urlApp = request.getRequestURL().toString();
        var link = linkService.salvar(linkRequest.toLink(), urlApp);
        return ResponseEntity.ok(LinkResponse.toResponse(link));
    }

    @GetMapping("/{sufixo}")
    public ResponseEntity<Void> redirecionar(@PathVariable String sufixo, HttpServletRequest request) {
        var urlOriginal = linkService.buscarUrlOriginal(sufixo);
        if (urlOriginal.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var headers = new HttpHeaders();
        headers.setLocation(URI.create(urlOriginal));
        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
    }

}
