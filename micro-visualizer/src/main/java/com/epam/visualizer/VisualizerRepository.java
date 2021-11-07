package com.epam.visualizer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface VisualizerRepository extends JpaRepository<BaseDto, Integer> {

}
