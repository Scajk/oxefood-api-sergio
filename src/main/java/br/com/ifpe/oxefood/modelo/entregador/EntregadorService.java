package br.com.ifpe.oxefood.modelo.entregador;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service

public class EntregadorService {
    
   @Autowired
   private EntregadorRepository repository;

   @Transactional
   public Entregador save(Entregador entregador) {

       entregador.setHabilitado(Boolean.TRUE);
       entregador.setVersao(1L);
       entregador.setDataCriacao(LocalDate.now());
       return repository.save(entregador);
   }

    @Transactional
    public void update(Long id, Entregador entregadorAlterado) {
 
       Entregador entregador = repository.findById(id).get();
       entregador.setNome(entregadorAlterado.getNome());
       entregador.setDataNascimento(entregadorAlterado.getDataNascimento());
       entregador.setCpf(entregadorAlterado.getCpf());
       entregador.setRg(entregadorAlterado.getRg());
       entregador.setFoneCelular(entregadorAlterado.getFoneCelular());
       entregador.setFoneFixo(entregadorAlterado.getFoneFixo());
       entregador.setQtdEntregasRealizadas(entregadorAlterado.getQtdEntregasRealizadas());
       entregador.setValorFrete(entregadorAlterado.getValorFrete());
       entregador.setEnderecoRua(entregadorAlterado.getEnderecoRua());
       entregador.setEnderecoNumero(entregadorAlterado.getEnderecoNumero());
       entregador.setEnderecoBairro(entregadorAlterado.getEnderecoBairro());
       entregador.setEnderecoCidade(entregadorAlterado.getEnderecoCidade());
       entregador.setEnderecoCep(entregadorAlterado.getEnderecoCep());
       entregador.setEnderecoUf(entregadorAlterado.getEnderecoUf());
       entregador.setEnderecoComplemento(entregadorAlterado.getEnderecoComplemento());
       entregador.setHabilitado(entregadorAlterado.getHabilitado());
         
       entregador.setVersao(entregador.getVersao() + 1);
       repository.save(entregador);
   }

       public List<Entregador> listarTodos() {

        return repository.findAll();
    }

    public Entregador obterPorID(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
   public void delete(Long id) {

       Entregador entregador = repository.findById(id).get();
       entregador.setHabilitado(Boolean.FALSE);
       entregador.setVersao(entregador.getVersao() + 1);

       repository.save(entregador);
   }

}
