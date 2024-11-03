package com.smartsimon.utils.erknm.helper.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Структурные единицы НПА, содержащие обязательные требования.
 *
 * @author Dmitry.Steklyannikov
 */
@Entity
@Data
@Table(schema = "catalogs_external", name = "rot_structural_unit")
@SQLDelete(sql = "UPDATE catalogs_external.rot_structural_unit set deleted=true where id=?")
public class RotStructuralUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "public_id")
    private UUID publicId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "npa_id")
    private RotRequirementsNPA npa;

    /**
     * Пункт
     */
    private String item;
    /**
     * под-пункт
     */
    private String subItem;
    /**
     * часть
     */
    private String part;
    /**
     * другое
     */
    private String other;
    /**
     * Абзац
     */
    private String indent;
    /**
     * Статья
     */
    private String article;
    /**
     * Глава
     */
    private String chapter;
    /**
     * Секция
     */
    private String section;
    /**
     * под-секция
     */
    private String subSection;

    /**
     * параграф
     */
    private String paragraph;

    private boolean sourceRot;

    private boolean deleted;

    @OneToMany(mappedBy = "structuralUnit", orphanRemoval = true, cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<RotMandatoryRequirement> mandatoryRequirements = new HashSet<>();


    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime updated;

}

