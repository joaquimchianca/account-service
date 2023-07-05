package ufrn.imd.userservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.logging.LogLevel;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Log {
    private final LocalDateTime timestamp = LocalDateTime.now();
    private final LogLevel level;
    @Value("${spring.application.name}")
    private final String microservice;
    private final String thread = Thread.currentThread().getName();
    @JsonProperty("class")
    private final String className;
    private final String method;
    private final String message;
    private final String context;
    private final String ip  = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                    .getRequest().getRemoteAddr();


//    @Data
//    @Builder
//    public static class LogBuilder {
//        @Value("${spring.application.name}")
//        private String applicationName;
//
//        private final LocalDateTime timestamp;
//        private LogLevel level;
//        private final String microservice;
//        private final String thread;
//        private String className;
//        private String method;
//        private String message;
//        private String context;
//        private final String ip;
//
//        public LogBuilder() {
//            this.timestamp = LocalDateTime.now();
//            this.microservice = applicationName;
//            this.thread = Thread.currentThread().getName();
//            this.ip = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
//                    .getRequest().getRemoteAddr();
//        }
//    }

}

