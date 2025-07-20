package com.example.doctorappointment.controller;

import com.example.doctorappointment.model.Appointment;
import com.example.doctorappointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public List<Appointment> getAll() {
        return appointmentService.getAll();
    }

    @PostMapping
    public Appointment create(@RequestBody Appointment appointment) {
        return appointmentService.create(appointment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        appointmentService.delete(id);
    }
}
