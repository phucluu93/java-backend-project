package com.project.backend.models; // THAY ĐỔI: Tên package thực tế của bạn

import jakarta.persistence.*; // Hoặc javax.persistence.* nếu bạn dùng phiên bản cũ hơn
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

/**
 * Lớp Doctor đã được cấu hình là một JPA Entity hợp lệ.
 * Đã bổ sung các chú thích JPA bắt buộc và trường khóa chính (id).
 */
@Entity // BẮT BUỘC: Đánh dấu là thực thể JPA
public class Doctor {

    // BẮT BUỘC: Khóa chính (Primary Key)
    @Id // Đánh dấu là khóa chính
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Thiết lập tự động tăng
    private Long id; // BẮT BUỘC: Kiểu Long theo yêu cầu

    private String name;
    private String specialty;

    // Trường 'availableTimes' bị thiếu (Đã sửa ở hướng dẫn trước, nhưng tôi thêm lại)
    @ElementCollection 
    @CollectionTable(name = "doctor_available_times", joinColumns = @JoinColumn(name = "doctor_id"))
    private List<LocalDateTime> availableTimes = new ArrayList<>();

    // Constructor mặc định (bắt buộc cho JPA)
    public Doctor() {
    }

    // Constructor có tham số (tùy chọn)
    public Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    // Getters và Setters cho tất cả các trường (BẮT BUỘC cho JPA)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    // Các getters/setters còn lại... (Bạn phải tự bổ sung hoặc dùng IDE tạo tự động)
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
    
    public List<LocalDateTime> getAvailableTimes() {
        return availableTimes;
    }

    public void setAvailableTimes(List<LocalDateTime> availableTimes) {
        this.availableTimes = availableTimes;
    }
}
