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
public class UmbralDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idUmbrales;
    private Float max;
    private Float min;
    private String color;
    private Integer idVariable;

}
