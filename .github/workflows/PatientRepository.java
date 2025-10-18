package com.project.back_end.repo;

import com.project.back_end.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * PatientRepository là giao diện kho lưu trữ (Repository) cho thực thể Patient.
 * Nó mở rộng JpaRepository để cung cấp các phương thức CRUD cơ bản 
 * và các truy vấn tùy chỉnh dựa trên tên phương thức.
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    /**
     * Tìm kiếm một bệnh nhân dựa trên tên người dùng (username).
     * @param username Tên người dùng của bệnh nhân.
     * @return Optional chứa thực thể Patient nếu tìm thấy, ngược lại là Optional trống.
     */
    Optional<Patient> findByUsername(String username);

    /**
     * Kiểm tra xem một bệnh nhân có tồn tại hay không dựa trên ID.
     * @param id ID của bệnh nhân.
     * @return true nếu tồn tại, ngược lại là false.
     */
    boolean existsById(Long id);
}
