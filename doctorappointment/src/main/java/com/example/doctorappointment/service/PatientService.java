package com.example.doctorappointment.service;

import com.example.doctorappointment.model.Patient;
import com.example.doctorappointment.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    public Patient create(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient update(Long id, Patient updated) {
        return patientRepository.findById(id)
            .map(p -> {
                p.setName(updated.getName());
                p.setPhone(updated.getPhone());
                return patientRepository.save(p);
            })
            .orElse(null);
    }
}
