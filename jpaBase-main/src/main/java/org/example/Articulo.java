package org.example;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Setter
@Getter
@Entity
@Table(name = "Articulo")
@Audited
public class Articulo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "cantidad")
        private int cantidad;
        @Column(name = "denominacion")
        private String denominacion;
        @Column(name = "precio")
        private int precio;

        @OneToMany(mappedBy = "articulo")
        @Builder.Default
        private List<DetalleFactura> detalleFacturas = new ArrayList<DetalleFactura>();

        @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
        @JoinTable(name = "articulo_categoria", joinColumns = @JoinColumn(name = "articulo_id"),
        inverseJoinColumns = @JoinColumn(name = "categoria_id"))
        @Builder.Default
        private List<Categoria> categorias = new ArrayList<Categoria>();



}
