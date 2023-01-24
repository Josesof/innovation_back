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
public class ClienteDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idCliente;
    private String nombre;
    private String correo;
    private String contacto;
    private String Permiso;
    private Integer idVariable;
    private String nombreVariable;
    private String estado;
    private Integer tiempoMuestreo;
    private Integer idUnidadMedida;
    private String nombreMedida;
       
}
