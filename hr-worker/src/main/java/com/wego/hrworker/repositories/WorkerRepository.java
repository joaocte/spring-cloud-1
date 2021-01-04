package com.wego.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wego.hrworker.entities.Worker;


public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
