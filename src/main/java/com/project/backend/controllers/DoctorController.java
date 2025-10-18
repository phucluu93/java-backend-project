package com.project.backend.controllers; // THAY ĐỔI: Tên package thực tế của bạn

import com.project.backend.models.Doctor; // Import lớp Doctor đã sửa lỗi JPA
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controller chịu trách nhiệm xử lý các yêu cầu RESTful liên quan đến Bác sĩ.
 */
@RestController // BẮT BUỘC: Đánh dấu là Controller xử lý RESTful API
@RequestMapping("/api/doctors") // BẮT BUỘC: Định nghĩa đường dẫn cơ sở
public class DoctorController {

    // Giả định có lớp DoctorService để thực hiện logic nghiệp vụ
    // private final DoctorService doctorService; 

    // @Autowired
    // public DoctorController(DoctorService doctorService) {
    //     this.doctorService = doctorService;
    // }

    // API để lấy danh sách tất cả Bác sĩ (Ví dụ)
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        // List<Doctor> doctors = doctorService.findAll();
        // Thay thế bằng mã logic thực tế, ở đây chỉ là cấu trúc mẫu:
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    
    // API để thêm Bác sĩ mới (Ví dụ)
    @PostMapping
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        // Doctor newDoctor = doctorService.save(doctor);
        return new ResponseEntity<>(doctor, HttpStatus.CREATED);
    }

    // Các phương thức khác như getDoctorById, updateDoctor, deleteDoctor...
}
