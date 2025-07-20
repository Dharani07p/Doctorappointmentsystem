package com.example.doctorappointment.controller;

import com.example.doctorappointment.model.Patient;
import com.example.doctorappointment.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<Patient> getAll() {
        return patientService.getAll();
    }

    @PostMapping
    public Patient create(@RequestBody Patient patient) {
        return patientService.create(patient);
    }

    @PutMapping("/{id}")
    public Patient update(@PathVariable Long id, @RequestBody Patient updated) {
        return patientService.update(id, updated);
    }
}
