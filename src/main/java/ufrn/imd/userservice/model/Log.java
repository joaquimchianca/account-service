package ufrn.imd.userservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.logging.LogLevel;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Log {
    private final LocalDateTime timestamp;
    private final LogLevel level;
    private final String microservice;
    private final String thread;
    @JsonProperty("class")
    private final String className;
    private final String method;
    private final String message;
    private final String context;
    private final String ip;

    private Log(LogBuilder logBuilder) {
        this.timestamp = logBuilder.timestamp;
        this.level = logBuilder.level;
        this.microservice = logBuilder.microservice;
        this.thread = logBuilder.thread;
        this.className = logBuilder.className;
        this.method = logBuilder.method;
        this.message = logBuilder.message;
        this.context = logBuilder.context;
        this.ip = logBuilder.ip;
    }
    @Data
    public static class LogBuilder {
        @Value("${spring.application.name}")
        private String applicationName;

        private final LocalDateTime timestamp;
        private LogLevel level;
        private final String microservice;
        private final String thread;
        private String className;
        private String method;
        private String message;
        private String context;
        private final String ip;

        public LogBuilder() {
            this.timestamp = LocalDateTime.now();
            this.microservice = applicationName;
            this.thread = Thread.currentThread().getName();
            this.ip = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                    .getRequest().getRemoteAddr();
        }
    }

}

