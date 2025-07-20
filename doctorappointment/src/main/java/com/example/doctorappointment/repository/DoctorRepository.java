package com.example.doctorappointment.repository;

import com.example.doctorappointment.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
