package br.com.dreamtravel.specification;

import java.time.LocalDate;

import org.springframework.data.jpa.domain.Specification;

import br.com.dreamtravel.model.Passagem;

/**
 * @see https://docs.spring.io/spring-data/jpa/reference/jpa/specifications.html
 * @see https://youtu.be/G1w7RZXaYE4?list=PLoyb0HJlmv_lvsJv02JKe7hz45oB3qlgX
 */
public class PassagemSpec {

	public static Specification<Passagem> destinoVazioOuIgual(String valor) {

		return (root, query, builder) -> {
			return valor == null || valor.isEmpty() ? 
					null 
					:  builder.equal(root.get("destino").get("nome"), valor);
		};
	}

	public static Specification<Passagem> origemVazioOuIgual(String valor) {

		return (root, query, builder) -> {
			return valor == null || valor.isEmpty() ? 
					null 
					: builder.equal(root.get("origem"), valor);
		};
	}

	public static Specification<Passagem> dataPartidaVazioOuMaiorIgual(LocalDate dataInferior) {

		return (root, query, builder) -> {
			return dataInferior == null ? 
					null 
					: builder.greaterThanOrEqualTo(root.get("dataPartida"), dataInferior);
		};
	}

	public static Specification<Passagem> dataPartidaVazioOuMenorIgual(LocalDate dataSuperior) {

		return (root, query, builder) -> {
			return dataSuperior == null ? 
					null 
					: builder.lessThanOrEqualTo(root.get("dataPartida"), dataSuperior);
		};
	}
	
	public static Specification<Passagem> idDestinoVazioOuIgual(Integer id) {

		return (root, query, builder) -> {
			return id == null ? 
					null 
					: builder.equal(root.get("destino").get("id"), id);
		};
	}
	
	public static Specification<Passagem> idPromocaoVazioOuIgual(Integer id) {

		return (root, query, builder) -> {
			return id == null ? 
					null 
					: builder.equal(root.get("promocao").get("id"), id);
		};
	}
}