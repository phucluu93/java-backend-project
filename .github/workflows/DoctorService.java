package com.project.back_end.services;

import com.project.back_end.models.Doctor;
import com.project.back_end.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * DoctorService là lớp dịch vụ (Service Layer) xử lý logic nghiệp vụ liên quan đến Bác sĩ.
 * Nó giao tiếp với DoctorRepository để truy cập dữ liệu.
 */
@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    // Sử dụng Dependency Injection để tiêm DoctorRepository
    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    /**
     * Lấy tất cả danh sách bác sĩ.
     * @return Danh sách các đối tượng Doctor.
     */
    public List<Doctor> getAllDoctors() {
        // Đây là nơi áp dụng các quy tắc kinh doanh phức tạp nếu cần
        return doctorRepository.findAll();
    }

    /**
     * Tìm kiếm một bác sĩ theo ID.
     * @param id ID của bác sĩ.
     * @return Optional chứa Doctor nếu tìm thấy, ngược lại là Optional trống.
     */
    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    /**
     * Lưu trữ (hoặc cập nhật) thông tin bác sĩ.
     * @param doctor Đối tượng Doctor cần lưu.
     * @return Doctor đã được lưu.
     */
    public Doctor saveDoctor(Doctor doctor) {
        // Có thể thêm logic kiểm tra dữ liệu trước khi lưu
        return doctorRepository.save(doctor);
    }

    /**
     * Xóa một bác sĩ theo ID.
     * @param id ID của bác sĩ cần xóa.
     */
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    /**
     * Tìm kiếm bác sĩ theo tên (Hỗ trợ cho yêu cầu Q17).
     * @param name Tên bác sĩ.
     * @return Danh sách bác sĩ khớp với tên.
     */
    public List<Doctor> findDoctorByName(String name) {
        // Trong môi trường thực tế, Repository sẽ có một phương thức findByTên
        // Giả sử có một phương thức tùy chỉnh trong Repository:
        return doctorRepository.findByNameContainingIgnoreCase(name);
    }
}
