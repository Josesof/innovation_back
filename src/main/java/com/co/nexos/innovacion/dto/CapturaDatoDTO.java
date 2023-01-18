package com.co.nexos.innovacion.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author jdrivera
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CapturaDatoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idCapturaDato;
    private String nombre;
    private Float longitud;
    private Float latitud;
    private Short estado;
    private List<SensorDTO> sensorList;
    private SitioCapturaDatoDTO idSitioCaptura;
    private Integer idVariable; 
}
