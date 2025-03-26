package modelcontextprotocol.sandbox.dskst.mcpserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import modelcontextprotocol.sandbox.dskst.mcpserver.service.WeatherService;

@SpringBootApplication
public class McpserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(McpserverApplication.class, args);
	}

	@Bean
	public ToolCallbackProvider weatherTools(WeatherService weatherService) {
		return MethodToolCallbackProvider.builder().toolObjects(weatherService).build();
	}

}
