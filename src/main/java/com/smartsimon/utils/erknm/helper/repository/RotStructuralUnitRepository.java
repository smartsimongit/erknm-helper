package com.smartsimon.utils.erknm.helper.repository;

import com.smartsimon.utils.erknm.helper.entity.RotStructuralUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Репозиторий структурных единиц, содержащих обязательные требования.
 *
 * @author
 */
@Repository
public interface RotStructuralUnitRepository extends JpaRepository<RotStructuralUnit, Long> {
    Optional<RotStructuralUnit> findByIdAndDeletedFalse(long id);
}
