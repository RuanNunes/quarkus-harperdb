package ruan.nunes;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;

@QuarkusTest
public class MetricsTest {

    @Test
    public void metricsJvmThreadsAlive() {
        given()
          .when().get("/q/metrics")
          .then()
             .statusCode(200)
             .body(containsStringIgnoringCase("jvm_threads_live_threads"));
    }
    @Test
    public void metricsJvmMemoryUsedBytes() {
        given()
                .when().get("/q/metrics")
                .then()
                .statusCode(200)
                .body(containsStringIgnoringCase("jvm_memory_used_bytes"));
    }
    @Test
    public void metricsJvmCpuUsed() {
        given()
                .when().get("/q/metrics")
                .then()
                .statusCode(200)
                .body(containsStringIgnoringCase("process_cpu_usage"));
    }
    @Test
    public void metricsSystemCpuCount() {
        given()
                .when().get("/q/metrics")
                .then()
                .statusCode(200)
                .body(containsStringIgnoringCase("system_cpu_count"));
    }

}