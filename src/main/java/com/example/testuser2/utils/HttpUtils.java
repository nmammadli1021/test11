package com.example.testuser2.utils;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public final class HttpUtils {

    private static final String[] IP_HEADERS = {
            "X-Forwarded-For",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_X_FORWARDED_FOR",
            "HTTP_X_FORWARDED",
            "HTTP_X_CLUSTER_CLIENT_IP",
            "HTTP_CLIENT_IP",
            "HTTP_FORWARDED_FOR",
            "HTTP_FORWARDED",
            "HTTP_VIA",
            "REMOTE_ADDR"
            // Ek başlıkları buraya ekleyebilirsiniz ...
    };

    private HttpUtils() {
        // Hiçbir şey yapma ...
    }

    public static String getRequestIP(HttpServletRequest request) {
        for (String header : IP_HEADERS) {
            String value = request.getHeader(header);
            if (value != null && !value.isEmpty() && !"unknown".equalsIgnoreCase(value)) {
                String[] parts = value.split("\\s*,\\s*");
                return parts[0];
            }
        }
        // Hiçbir geçerli IP başlığı bulunamadığında veya "unknown" bir değer bulunduğunda, uzak adresi kullanın.
        return request.getRemoteAddr();
    }
}
