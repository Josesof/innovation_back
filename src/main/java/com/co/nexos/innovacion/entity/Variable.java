package com.co.nexos.innovacion.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @ManyToMany(mappedBy = "variableList")
    private List<Cliente> clienteList;
    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVariable")
    private List<Sensor> sensorList;
    @JoinColumn(name = "id_unidad_medida", referencedColumnName = "id_unidad_medida")
    //@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @ManyToOne(optional = false)
    private UnidadMedida idUnidadMedida;
    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVariable")
    private List<CapturaDato> capturaDatoList;
    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVariable")
    private List<Umbral> umbralList;
    
}
