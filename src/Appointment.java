package com.project.backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Lớp Appointment đại diện cho một cuộc hẹn giữa bệnh nhân và bác sĩ.
 * Được đánh dấu là JPA Entity với quan hệ tới Doctor và Patient.
 */
@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Quan hệ: Nhiều cuộc hẹn thuộc về 1 bác sĩ
    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    // Quan hệ: Nhiều cuộc hẹn thuộc về 1 bệnh nhân
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @NotNull
    @Future // đảm bảo thời gian cuộc hẹn nằm trong tương lai
    private LocalDateTime appointmentTime;

    private String notes;

    // Constructor mặc định (bắt buộc cho JPA)
    public Appointment() {}

    // Constructor đầy đủ
    public Appointment(Doctor doctor, Patient patient, LocalDateTime appointmentTime, String notes) {
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentTime = appointmentTime;
        this.notes = notes;
    }

    // Getters và Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", doctor=" + (doctor != null ? doctor.getName() : "null") +
                ", patient=" + (patient != null ? patient.getName() : "null") +
                ", appointmentTime=" + appointmentTime +
                ", notes='" + notes + '\'' +
                '}';
    }
}


