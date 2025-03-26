package modelcontextprotocol.sandbox.dskst.mcpserver.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class WeatherService {

    private final RestClient restClient;

    public WeatherService() {
        this.restClient = RestClient.builder()
                .baseUrl("https://api.weather.gov")
                .defaultHeader("Accept", "application/geo+json")
                .defaultHeader("User-Agent", "WeatherApiClient/1.0 (your@email.com)")
                .build();
    }

    @Tool(description = "Get weather forecast for a specific latitude/longitude")
    public String getWeatherForecastByLocation(
            double latitude,
            double longitude) {
        // Returns detailed forecast including:
        // - Temperature and unit
        // - Wind speed and direction
        // - Detailed forecast description
        return "No forecast found";
    }

    @Tool(description = "Get weather alerts for a US state")
    public String getAlerts(
            @ToolParam(description = "Two-letter US state code (e.g. CA, NY") String state) {
        // Returns active alerts including:
        // - Event type
        // - Affected area
        // - Severity
        // - Description
        // - Safety instructions
        return "No alerts found";
    }
}
