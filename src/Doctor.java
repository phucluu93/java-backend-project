package com.project.backend.models; // THAY ĐỔI: Tên package thực tế của bạn

import jakarta.persistence.*; // Hoặc javax.persistence.* nếu bạn dùng phiên bản cũ hơn
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

/**
 * Lớp Doctor đại diện cho một Bác sĩ trong hệ thống.
 * Đã được cấu hình là một JPA Entity.
 */
@Entity // 1. Bổ sung chú thích @Entity
@Table(name = "doctors") // Tùy chọn: Đặt tên bảng trong cơ sở dữ liệu
public class Doctor {

    // 2 & 3. Bổ sung Khóa chính (Primary Key) theo yêu cầu
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private String name;
    private String specialty;

    // 4. Bổ sung trường 'availableTimes' kiểu List<LocalDateTime>
    // Sử dụng @ElementCollection để lưu trữ danh sách các phần tử này trong một bảng riêng
    @ElementCollection 
    @CollectionTable(name = "doctor_available_times", joinColumns = @JoinColumn(name = "doctor_id"))
    private List<LocalDateTime> availableTimes = new ArrayList<>();

    // Constructors
    public Doctor() {
        // Constructor mặc định là bắt buộc cho JPA
    }

    // Constructor có tham số (không cần id vì nó tự tạo)
    public Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    // Getters và Setters cho tất cả các trường
    // (Bắt buộc phải có cho JPA)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    
    // Getters/Setters cho availableTimes
    public List<LocalDateTime> getAvailableTimes() {
        return availableTimes;
    }

    public void setAvailableTimes(List<LocalDateTime> availableTimes) {
        this.availableTimes = availableTimes;
    }
}
