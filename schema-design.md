Thiết Kế Lược Đồ Cơ Sở Dữ Liệu MySQL

Đây là thiết kế cơ sở dữ liệu cho hệ thống Quản lý Phòng Khám Thông Minh. Chúng tôi sử dụng MySQL.

1. Bảng user (Tài khoản người dùng)

Đây là bảng chính chứa thông tin đăng nhập và vai trò.

Cột

Kiểu Dữ Liệu

Mô Tả

id (PK)

BIGINT

ID duy nhất của người dùng

username

VARCHAR(50)

Tên đăng nhập (DUY NHẤT)

password

VARCHAR(255)

Mật khẩu đã được mã hóa

role

ENUM('ADMIN', 'DOCTOR', 'PATIENT')

Vai trò người dùng (QTV, BS, BN)

created_at

TIMESTAMP

Ngày tạo tài khoản

2. Bảng patient (Bệnh nhân)

Chứa thông tin chi tiết của bệnh nhân. Liên kết 1-1 với bảng user.

Cột

Kiểu Dữ Liệu

Mô Tả

id (PK)

BIGINT

ID bệnh nhân (Giống user.id)

full_name

VARCHAR(100)

Tên đầy đủ

date_of_birth

DATE

Ngày sinh

address

VARCHAR(255)

Địa chỉ

phone_number

VARCHAR(15)

Số điện thoại

3. Bảng doctor (Bác sĩ)

Chứa thông tin chi tiết của bác sĩ. Liên kết 1-1 với bảng user.

Cột

Kiểu Dữ Liệu

Mô Tả

id (PK)

BIGINT

ID bác sĩ (Giống user.id)

full_name

VARCHAR(100)

Tên đầy đủ

specialty

VARCHAR(100)

Chuyên khoa

license_number

VARCHAR(50)

Số giấy phép hành nghề

email

VARCHAR(100)

Email liên hệ

4. Bảng appointment (Lịch hẹn)

Quản lý các cuộc hẹn giữa bác sĩ và bệnh nhân.

Cột

Kiểu Dữ Liệu

Mô Tả

id (PK)

BIGINT

ID duy nhất của lịch hẹn

patient_id (FK)

BIGINT

Tham chiếu đến patient.id

doctor_id (FK)

BIGINT

Tham chiếu đến doctor.id

appointment_date

DATE

Ngày hẹn

appointment_time

TIME

Giờ hẹn

status

ENUM('SCHEDULED', 'COMPLETED', 'CANCELED')

Trạng thái cuộc hẹn

5. Bảng prescription (Đơn thuốc)

Lưu trữ thông tin đơn thuốc do bác sĩ kê.

Cột

Kiểu Dữ Liệu

Mô Tả

id (PK)

BIGINT

ID duy nhất của đơn thuốc

appointment_id (FK)

BIGINT

Tham chiếu đến appointment.id (buổi khám)

doctor_id (FK)

BIGINT

Tham chiếu đến doctor.id

patient_id (FK)

BIGINT

Tham chiếu đến patient.id

medication_details

TEXT

Chi tiết thuốc (tên, liều lượng, hướng dẫn)

prescription_date

TIMESTAMP

Ngày kê đơn
