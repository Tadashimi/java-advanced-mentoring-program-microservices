package com.epam.collector;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CollectorRepository extends JpaRepository<BaseDto, Integer> {

}
