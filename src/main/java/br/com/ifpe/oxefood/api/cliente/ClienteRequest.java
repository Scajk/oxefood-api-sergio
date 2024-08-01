package br.com.ifpe.oxefood.api.cliente;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ClienteRequest {

   @NotNull(message = "O nome é de preenchimento obrigatório")
   @NotEmpty(message = "O nome é de preenchimento obrigatório")
   @Length(max = 100, message = "O nome deverá ter no máximo {max} caracteres")
   private String nome;

   @JsonFormat(pattern = "dd/MM/yyyy")
   private LocalDate dataNascimento;

   @NotBlank(message = "O CPF é de preenchimento obrigatório")
   private String cpf;

   @Length(min = 8, max = 20, message = "O campo fone tem que ter entre {min} e {max} caracteres")
   private String foneCelular;

   private String foneFixo;

   public Cliente build() {

       return Cliente.builder()
           .nome(nome)
           .dataNascimento(dataNascimento)
           .cpf(cpf)
           .foneCelular(foneCelular)
           .foneFixo(foneFixo)
           .build();
   }
}
