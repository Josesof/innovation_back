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
public class VariableDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer idVariable;
    private String nombreVariable;
    private Short estado;
    private Integer tiempoMuestreo;
    private List<ClienteDTO> clienteList;
    private List<SensorDTO> sensorList;
    private Integer idUnidadMedida;
    private List<CapturaDatoDTO> capturaDatoList;
    private List<UmbralDTO> umbralList;
    
}
