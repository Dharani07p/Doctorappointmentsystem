package com.example.doctorappointment.service;

import com.example.doctorappointment.model.Doctor;
import com.example.doctorappointment.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }

    public Doctor create(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor update(Long id, Doctor updated) {
        return doctorRepository.findById(id)
            .map(doctor -> {
                doctor.setName(updated.getName());
                doctor.setSpecialization(updated.getSpecialization());
                return doctorRepository.save(doctor);
            })
            .orElse(null);
    }

    public void delete(Long id) {
        doctorRepository.deleteById(id);
    }
}
