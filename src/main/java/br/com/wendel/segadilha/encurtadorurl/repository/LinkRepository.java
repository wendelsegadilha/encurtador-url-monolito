package br.com.wendel.segadilha.encurtadorurl.repository;

import br.com.wendel.segadilha.encurtadorurl.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {

    boolean existsLinkBySufixo(String sufixo);

    Link findLinkBySufixo(String sufixo);

    @Query(nativeQuery = true, value = "select count(*) from links")
    int quantidadeLinks();

}
