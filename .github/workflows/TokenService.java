package com.project.back_end.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

/**
 * TokenService là lớp dịch vụ chịu trách nhiệm tạo và mã hóa JWT (JSON Web Tokens).
 * Lớp này thường được sử dụng trong quá trình đăng nhập để tạo token truy cập.
 */
@Service
public class TokenService {

    private final JwtEncoder jwtEncoder;

    // Giá trị thời gian hết hạn (ví dụ: 1 giờ)
    @Value("${jwt.expiration.time:3600}")
    private long jwtExpirationTime; 

    // Sử dụng Dependency Injection để tiêm JwtEncoder
    public TokenService(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    /**
     * Tạo JWT (JSON Web Token) từ đối tượng Authentication (thông tin người dùng đã xác thực).
     * @param authentication Đối tượng Authentication chứa thông tin người dùng.
     * @return Chuỗi JWT đã được ký.
     */
    public String generateToken(Authentication authentication) {
        Instant now = Instant.now();
        
        // Trích xuất vai trò (roles/authorities) của người dùng
        String scope = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));

        // Xây dựng bộ claim (thông tin) cho JWT
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(jwtExpirationTime)) // Thời gian hết hạn
                .subject(authentication.getName()) // Tên người dùng
                .claim("roles", scope) // Thêm vai trò vào token
                .build();

        // Mã hóa và trả về JWT
        return this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}
