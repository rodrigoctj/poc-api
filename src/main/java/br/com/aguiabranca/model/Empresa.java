package br.com.aguiabranca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name="Empresa")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class Empresa {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
		
	private String cnpj;
	
	@Column(name="razao_social")
	private String razaoSocial;
	
	@Column(name="nome_fantasia")
	private String nomeFantasia;
	
	@Column(name="inscricao_estadual")
	private Integer inscricaoEstadual;	
	
}

