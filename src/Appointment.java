package com.yourproject.controllers; // THAY ĐỔI: Tên package thực tế của bạn

import com.yourproject.models.Appointment; // Giả sử Appointment.java nằm trong package models
import com.yourproject.services.AppointmentService; // Giả sử bạn có lớp AppointmentService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller chịu trách nhiệm xử lý các yêu cầu liên quan đến Lịch hẹn (Appointment).
 */
@RestController // Đánh dấu đây là một Controller xử lý RESTful API
@RequestMapping("/api/appointments") // Định nghĩa đường dẫn cơ sở
public class AppointmentController {

    private final AppointmentService appointmentService;

    // Sử dụng Dependency Injection (DI)
    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    // API 1: Lấy danh sách tất cả Lịch hẹn
    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        List<Appointment> appointments = appointmentService.findAll();
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    // API 2: Lấy thông tin một Lịch hẹn theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable("id") int id) {
        Appointment appointment = appointmentService.findById(id);
        if (appointment != null) {
            return new ResponseEntity<>(appointment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // API 3: Tạo một Lịch hẹn mới
    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        Appointment newAppointment = appointmentService.save(appointment);
        return new ResponseEntity<>(newAppointment, HttpStatus.CREATED); // Mã 201 Created
    }

    // API 4: Cập nhật thông tin Lịch hẹn
    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable("id") int id, @RequestBody Appointment appointment) {
        Appointment updatedAppointment = appointmentService.update(id, appointment);
        if (updatedAppointment != null) {
            return new ResponseEntity<>(updatedAppointment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // API 5: Xóa một Lịch hẹn
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAppointment(@PathVariable("id") int id) {
        appointmentService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Mã 204 No Content
    }
}
