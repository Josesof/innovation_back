package com.co.nexos.innovacion.dto;

import java.io.Serializable;

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
public class SensorDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idSensor;
    private String nombreSensor;
    private String color;
    private Short estado;
    private Integer idCapturaDato;
    private Integer idVariable;
}
