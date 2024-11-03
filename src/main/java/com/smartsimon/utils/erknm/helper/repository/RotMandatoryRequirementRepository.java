package com.smartsimon.utils.erknm.helper.repository;

import com.smartsimon.utils.erknm.helper.entity.RotMandatoryRequirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий формулировок обязательных требований.
 *
 * @author
 */
@Repository
public interface RotMandatoryRequirementRepository extends JpaRepository<RotMandatoryRequirement, Long> {

}
