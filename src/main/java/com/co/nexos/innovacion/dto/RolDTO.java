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
public class RolDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idRol;
    private String nombreRol;
    private List<UsuarioDTO> usuarioList;
    
}
