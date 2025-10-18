package project.models;

/**
 * Đại diện cho một đối tượng Bác sĩ trong hệ thống.
 */
public class Doctor {
    private int doctorId;
    private String name;
    private String specialty;

    // Constructor
    public Doctor(int doctorId, String name, String specialty) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialty = specialty;
    }

    // Getters
    public int getDoctorId() {
        return doctorId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    // Setters (Nếu cần)
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
