package me.zhengjie.modules.process.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author jie
 * @date 2019-04-09
 */
@Entity
@Data
@Table(name = "ocv_recipe")
public class OcvRecipe implements Serializable {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 名称
     */
    @Column(name = "ocv_name")
    private String name;

    /**
     * ocv上限
     */
    @Column(name = "upper_ocv")
    private Double upperOcv;

    /**
     * ocv下限
     */
    @Column(name = "lower_ocv")
    private Double lowerOcv;
    /**
     * acr上限
     */
    @Column(name = "upper_acr")
    private Double upperAcr;

    /**
     * acr下限
     */
    @Column(name = "lower_acr")
    private Double lowerAcr;

    /**
     * k1上限
     */
    @Column(name = "upper_k_one")
    private Double upperKOne;

    /**
     * k1下限
     */
    @Column(name = "lower_k_one")
    private Double lowerKOne;
}