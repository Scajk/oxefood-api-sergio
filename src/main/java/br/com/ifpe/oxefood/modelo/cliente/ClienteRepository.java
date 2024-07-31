package br.com.ifpe.oxefood.modelo.cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

  //ilike faz o ignore case
  //Site com exemplos de requisições https://www.baeldung.com/spring-data-jpa-query
  //Exemplo de uma busca exata
   @Query(value = "SELECT p FROM Cliente p WHERE p.nome LIKE %:nome%")
   List<Cliente> consultarPorNome(String nome);

   //Exemplo de uma busca aproximada com ordenação:
   // @Query(value = "SELECT p FROM Produto p WHERE p.titulo like %:titulo% ORDER BY p.titulo")
   // List<Produto> consultarPorTitulo(String titulo);
   List<Cliente> findByCpfContainingIgnoreCase(String cpf);

   //Exemplo de uma busca com mais de um atributo
   @Query(value = "SELECT p FROM Cliente p WHERE p.nome like %:nome% AND p.cpf = :cpf")
   List<Cliente> consultarPorNomeECpf(String nome, String cpf);
}