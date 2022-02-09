package br.com.solinftec.treinamentospringboot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ORDEM_SERVICO")
@Data
public class OrdemServico implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATA_EXECUCAO")
    private Date dataExecucao;

    @OneToOne
    private Cooperativa idCooperativa;

    @OneToOne
    private Fazenda idFazenda;

    @OneToOne
    private Equipamento idEquipamento;

    @OneToOne
    private TipoServico idTipoServico;

    @OneToOne
    private Produto idProduto;
    
    
}