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
@Table(name = "clientes")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_cliente")
    private Integer idCliente;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "correo")
    private String correo;
    @Column(name = "contacto")
    private String contacto;
    @Column(name = "permiso")
    private String permiso;
   /* @JoinTable(name = "clientes_has_variables", joinColumns = {
        @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")}, inverseJoinColumns = {
        @JoinColumn(name = "id_variable", referencedColumnName = "id_variable")})
    @ManyToMany
    private List<Variable> variableList;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "idCliente")
    private List<Usuario> usuarioList;*/
       
}
