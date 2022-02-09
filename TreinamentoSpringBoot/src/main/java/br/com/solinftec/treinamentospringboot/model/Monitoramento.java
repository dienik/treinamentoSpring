package br.com.solinftec.treinamentospringboot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "MONITORAMENTO")
public class Monitoramento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "LATITUDE")
    private Float latitude;

    @Column(name = "LONGITUDE")
    private Float longitude;

    @Column(name = "DATA_HORA")
    private Date dataHora;

    @Column(name = "ID_EQUIPAMENTO")
    private Equipamento idEquipamento;

    @Column(name = "ID_ORDEM_SERVICO")
    private OrdemServico idOrdemServico;


  

    

    
}
