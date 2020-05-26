package ru.informaticsprac.own_aspects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "methodd")
public class Method {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_method")
    private Long id;

    @Column(name="name_of_method")
    private String name;
    @Column(name="uuid_of_method")
    private String uuid;
    @Column(name = "parameters_of_method")
    private String parameters;
    @Column(name = "return_of_method")
    private String return_object;
}
