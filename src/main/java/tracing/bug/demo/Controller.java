package tracing.bug.demo;

import io.micrometer.tracing.Tracer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class Controller {

  private final Tracer tracer;

  public Controller(Tracer tracer) {
    this.tracer = tracer;
  }

  @GetMapping("/hello")
  Mono<String> endpoint() {
    return Mono.just(tracer.currentSpan().context().traceId());
  }
}
