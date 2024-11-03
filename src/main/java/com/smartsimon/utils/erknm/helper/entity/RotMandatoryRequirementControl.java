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
@Table(schema = "catalogs_external", name = "rot_mandatory_requirement_control")
@IdClass(RotMandatoryRequirementControl.class)
public class RotMandatoryRequirementControl implements Serializable {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mr_id")
    private RotMandatoryRequirement rmr;

    @Id
    private UUID oivControlId;

    @Id
    private UUID oivControlTypeId;
}
