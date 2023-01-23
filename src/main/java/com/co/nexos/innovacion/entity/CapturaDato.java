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
@Table(name = "capturadatos")
public class CapturaDato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_captura_dato")
    private Integer idCapturaDato;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "longitud")
    private Float longitud;
    @Column(name = "latitud")
    private Float latitud;
    @Column(name = "estado")
    private Short estado;
    @Column(name = "id_sitio_captura")
    private Integer idSitioCaptura;
    @Column(name = "id_variable")
    private Integer idVariable;

}
