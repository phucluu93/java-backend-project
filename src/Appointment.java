package com.project.backend.models; // đổi lại cho khớp với package thực tế của bạn

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Lớp Appointment đại diện cho một cuộc hẹn giữa bệnh nhân và bác sĩ.
 * Được đánh dấu là một JPA Entity hợp lệ.
 */
@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Mối quan hệ với Doctor (nhiều cuộc hẹn có thể thuộc 1 bác sĩ)
    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    private String patientName;
    private LocalDateTime appointmentTime;
    private String notes;

    // Constructor mặc định (bắt buộc cho JPA)
    public Appointment() {}

    // Constructor đầy đủ
    public Appointment(Doctor doctor, String patientName, LocalDateTime appointmentTime, String notes) {
        this.doctor = doctor;
        this.patientName = patientName;
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

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
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
                ", patientName='" + patientName + '\'' +
                ", appointmentTime=" + appointmentTime +
                ", notes='" + notes + '\'' +
                '}';
    }
}

