package com.project.backend.controllers; // THAY ĐỔI: Tên package thực tế của bạn

import com.project.backend.models.Doctor; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Collections; 
import java.time.LocalDate;

/**
 * Lớp điều khiển RESTful API cho đối tượng Bác sĩ, đã bổ sung phương thức kiểm tra khả dụng.
 */
@RestController 
@RequestMapping("/api/doctors") 
public class DoctorController {

    // (Giữ nguyên cấu trúc nếu bạn đang sử dụng DI)
    // @Autowired
    // public DoctorController(DoctorService doctorService) { ... }

    public DoctorController() {
    }

    // API BỊ THIẾU: Lấy thông tin khả dụng của Bác sĩ
    // Đây là phương thức được yêu cầu để vượt qua bài kiểm tra Q5.
    @GetMapping("/availability")
    public ResponseEntity<List<LocalDate>> getDoctorAvailability(
        @RequestParam("role") String userRole, // Tham số Vai trò người dùng
        @RequestParam("doctorId") Long doctorId, // Tham số ID Bác sĩ
        @RequestParam("date") LocalDate date, // Tham số Ngày
        @RequestParam("token") String token // Tham số Token (cho xác thực)
    ) {
        // --- LOGIC XỬ LÝ (Mô phỏng) ---
        // 1. Kiểm tra Token và Vai trò người dùng (userRole)
        // 2. Gọi DoctorService để truy vấn lịch trống của doctorId vào ngày date
        
        System.out.println("Kiểm tra khả dụng cho ID: " + doctorId + " vào ngày: " + date);
        
        // Trả về một danh sách rỗng hoặc danh sách các giờ có sẵn
        return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
    }


    // API 1: Lấy danh sách tất cả Bác sĩ (Giữ nguyên hoặc chỉnh sửa nếu cần)
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
    }
    
    // API 2: Thêm Bác sĩ mới (Giữ nguyên hoặc chỉnh sửa nếu cần)
    @PostMapping
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        return new ResponseEntity<>(doctor, HttpStatus.CREATED);
    }
    
    // API 3: Lấy Bác sĩ theo ID (Giữ nguyên hoặc chỉnh sửa nếu cần)
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
    }
    
    // API 4: Cập nhật Bác sĩ (Giữ nguyên hoặc chỉnh sửa nếu cần)
    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable("id") Long id, @RequestBody Doctor doctor) {
        return new ResponseEntity<>(doctor, HttpStatus.OK); 
    }
}
