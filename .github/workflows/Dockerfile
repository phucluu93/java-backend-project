# Tên tệp: Dockerfile (Không có phần mở rộng)
# Vị trí: Đặt ở thư mục gốc của dự án Java Backend

# Giai đoạn 1: Build (Sử dụng SDK để biên dịch)
FROM eclipse-temurin:17-jdk-focal AS build

# Đặt thư mục làm việc trong container
WORKDIR /app

# Sao chép tệp cấu hình Maven (pom.xml) để tận dụng bộ nhớ cache
COPY pom.xml .

# Sao chép mã nguồn
COPY src ./src

# Biên dịch và đóng gói ứng dụng thành file JAR
# '-DskipTests' để bỏ qua các bài kiểm thử trong quá trình build Docker (nên chạy tests trong GitHub Actions)
RUN ./mvnw clean package -DskipTests

# Giai đoạn 2: Runtime (Sử dụng JRE nhẹ hơn để chạy ứng dụng)
FROM eclipse-temurin:17-jre-focal

# Thiết lập biến môi trường cho múi giờ và port
ENV TZ=Asia/Ho_Chi_Minh
ENV PORT=8080
EXPOSE 8080

# Sao chép file JAR đã build từ giai đoạn 'build'
# Giả định tên file JAR được tạo là 'target/app.jar' (Tên này có thể cần điều chỉnh)
COPY --from=build /app/target/*.jar app.jar

# Lệnh khởi chạy ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]
    
