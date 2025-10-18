package com.project.backend.models; // THAY ĐỔI: Tên package thực tế của bạn

import jakarta.persistence.*; 
import java.time.LocalDateTime;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Khóa chính (Long)

    // Lỗi 1: Thay thế ID bằng đối tượng Entity và sử dụng @ManyToOne
    @ManyToOne(fetch = FetchType.LAZY) // Quan hệ N-1 (Nhiều lịch hẹn - Một Bệnh nhân)
    @JoinColumn(name = "patient_id", nullable = false) // Khóa ngoại, thiết lập không null
    private Patient patient; 
    
    // Lỗi 1: Thay thế ID bằng đối tượng Entity và sử dụng @ManyToOne
    @ManyToOne(fetch = FetchType.LAZY) // Quan hệ N-1 (Nhiều lịch hẹn - Một Bác sĩ)
    @JoinColumn(name = "doctor_id", nullable = false) // Khóa ngoại, thiết lập không null
    private Doctor doctor; 
    
    // Lỗi 2: Bổ sung @NotNull để đảm bảo tính toàn vẹn dữ liệu
    @Column(nullable = false) 
    private LocalDateTime appointmentTime; 
    
    private String reason;
    private String status; 

    // Constructor mặc định (Bắt buộc cho JPA)
    public Appointment() {
    }

    // Getters và Setters cho TẤT CẢ các trường (Bắt buộc cho JPA)
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    // Getters/Setters cho Patient (Entity)
    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }
    
    // Getters/Setters cho Doctor (Entity)
    public Doctor getDoctor() { return doctor; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }
    
    public LocalDateTime getAppointmentTime() { return appointmentTime; }
    public void setAppointmentTime(LocalDateTime appointmentTime) { this.appointmentTime = appointmentTime; }
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
