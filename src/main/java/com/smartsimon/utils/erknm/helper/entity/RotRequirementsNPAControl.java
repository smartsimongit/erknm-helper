package com.smartsimon.utils.erknm.helper.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@Table(schema = "catalogs_external", name = "rot_npa_control")
@IdClass(RotRequirementsNPAControl.class)
public class RotRequirementsNPAControl implements Serializable {
    @Id
    private UUID oivControlId;

    @Id
    private UUID oivControlTypeId;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "npa_id")
    private RotRequirementsNPA npa;

}
