package com.project.backend.models; // THAY ĐỔI: Tên package thực tế của bạn

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Khóa chính (Long)

    private Long patientId; // Liên kết với Patient (có thể thay bằng @ManyToOne)
    private Long doctorId; // Liên kết với Doctor
    private LocalDateTime appointmentTime;
    private String reason;
    private String status; // Trường String bắt buộc (Ví dụ: BOOKED, COMPLETED, CANCELED)

    // Constructor mặc định (Bắt buộc cho JPA)
    public Appointment() {
    }

    // Getters and Setters cho TẤT CẢ các trường (Bắt buộc cho JPA)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }
    public Long getDoctorId() { return doctorId; }
    public void setDoctorId(Long doctorId) { this.doctorId = doctorId; }
    public LocalDateTime getAppointmentTime() { return appointmentTime; }
    public void setAppointmentTime(LocalDateTime appointmentTime) { this.appointmentTime = appointmentTime; }
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
