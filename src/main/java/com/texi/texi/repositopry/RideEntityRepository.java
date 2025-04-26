package com.texi.texi.repositopry;

import com.texi.texi.entity.RiderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideEntityRepository extends JpaRepository<RiderEntity,Integer> {
}
