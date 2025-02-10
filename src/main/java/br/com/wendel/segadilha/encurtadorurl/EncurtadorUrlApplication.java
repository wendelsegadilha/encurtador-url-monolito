package br.com.wendel.segadilha.encurtadorurl;

import br.com.wendel.segadilha.encurtadorurl.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EncurtadorUrlApplication implements CommandLineRunner {

    @Autowired
    private LinkService linkService;

    public static void main(String[] args) {
        SpringApplication.run(EncurtadorUrlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        linkService.popularBanco();
    }
}
