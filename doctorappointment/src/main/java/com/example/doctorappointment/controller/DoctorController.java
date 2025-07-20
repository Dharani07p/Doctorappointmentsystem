package com.example.doctorappointment.controller;

import com.example.doctorappointment.model.Doctor;
import com.example.doctorappointment.service.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<Doctor> getAll() {
        return doctorService.getAll();
    }

    @PostMapping
    public Doctor create(@RequestBody Doctor doctor) {
        return doctorService.create(doctor);
    }

    @PutMapping("/{id}")
    public Doctor update(@PathVariable Long id, @RequestBody Doctor updated) {
        return doctorService.update(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        doctorService.delete(id);
    }
}
