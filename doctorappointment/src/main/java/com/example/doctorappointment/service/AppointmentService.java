package com.example.doctorappointment.service;

import com.example.doctorappointment.model.Appointment;
import com.example.doctorappointment.model.Doctor;
import com.example.doctorappointment.model.Patient;
import com.example.doctorappointment.repository.AppointmentRepository;
import com.example.doctorappointment.repository.DoctorRepository;
import com.example.doctorappointment.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public AppointmentService(AppointmentRepository appointmentRepository,
                              DoctorRepository doctorRepository,
                              PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    public Appointment create(Appointment appointment) {
        // Fetch doctor and patient by ID
        Doctor fullDoctor = doctorRepository.findById(appointment.getDoctor().getId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        Patient fullPatient = patientRepository.findById(appointment.getPatient().getId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        // Set full objects before saving
        appointment.setDoctor(fullDoctor);
        appointment.setPatient(fullPatient);

        return appointmentRepository.save(appointment);
    }

    public void delete(Long id) {
        appointmentRepository.deleteById(id);
    }
}
