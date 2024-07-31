package br.com.ifpe.oxefood.modelo.produto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
  //ilike faz o ignore case
  //Site com exemplos de requisições https://www.baeldung.com/spring-data-jpa-query
  //Exemplo de uma busca exata
   @Query(value = "SELECT p FROM Produto p WHERE p.codigo = :codigo ORDER BY p.titulo DESC")
   List<Produto> consultarPorCodigo(String codigo);

   //Exemplo de uma busca aproximada com ordenação:
   // @Query(value = "SELECT p FROM Produto p WHERE p.titulo like %:titulo% ORDER BY p.titulo")
   // List<Produto> consultarPorTitulo(String titulo);
   List<Produto> findByTituloContainingIgnoreCaseOrderByTituloAsc(String titulo);

   //Exemplo de uma busca exata como um atributo de relacionamento
   @Query(value = "SELECT p FROM Produto p WHERE p.categoria.id = :idCategoria")
   List<Produto> consultarPorCategoria(Long idCategoria);

   //Exemplo de uma busca com mais de um atributo
   @Query(value = "SELECT p FROM Produto p WHERE p.titulo like %:titulo% AND p.categoria.id = :idCategoria")
   List<Produto> consultarPorTituloECategoria(String titulo, Long idCategoria);

}
