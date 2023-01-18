package com.co.nexos.innovacion.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "sensores")
public class Sensor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_sensor")
    private Integer idSensor;
    @Column(name = "nombre_sensor")
    private String nombreSensor;
    @Column(name = "color")
    private String color;
    @Column(name = "estado")
    private Short estado;
    @JoinColumn(name = "id_captura_dato", referencedColumnName = "id_captura_dato")
    @ManyToOne(optional = false)
    private CapturaDato idCapturaDato;
    @JoinColumn(name = "id_variable", referencedColumnName = "id_variable")
    @ManyToOne(optional = false)
    private Variable idVariable;
    
}
