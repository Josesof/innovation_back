package com.co.nexos.innovacion.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author jdrivera
 */
@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@Table(name = "variables")
public class Variable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_variable")
    private Integer idVariable;
    @Column(name = "nombre_variable")
    private String nombreVariable;
    @Column(name = "estado")
    private Short estado;
    @Column(name = "tiempo_muestreo")
    private Integer tiempoMuestreo;
    @Column(name = "id_unidad_medida")
    private Integer idUnidadMedida;
    /*@ManyToMany(mappedBy = "variableList")
    private List<Cliente> clienteList;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Sensor> sensorList;
    @JoinColumn(name = "id_unidad_medida", referencedColumnName = "id_unidad_medida")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private UnidadMedida idUnidadMedida;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CapturaDato> capturaDatoList;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Umbral> umbralList;*/
    
}
