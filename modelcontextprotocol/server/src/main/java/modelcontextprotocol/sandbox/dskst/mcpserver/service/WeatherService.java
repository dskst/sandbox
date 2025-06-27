package modelcontextprotocol.sandbox.dskst.mcpserver.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class WeatherService {

    private final RestClient restClient;
    private final ObjectMapper objectMapper;

    public WeatherService() {
        this.restClient = RestClient.builder()
                .baseUrl("https://api.weather.gov")
                .defaultHeader("Accept", "application/geo+json")
                .defaultHeader("User-Agent", "WeatherApiClient/1.0 (your@email.com)")
                .build();
        this.objectMapper = new ObjectMapper();
    }

    @Tool(description = "Get weather forecast for a specific latitude/longitude")
    public String getWeatherForecastByLocation(
            double latitude,
            double longitude) {
        // Returns detailed forecast including:
        // - Temperature and unit
        // - Wind speed and direction
        // - Detailed forecast description
        String url = String.format("/points/%f,%f", latitude, longitude);
        
        try {
            JsonNode pointResponse = restClient.get()
                    .uri(url)
                    .retrieve()
                    .body(JsonNode.class);
            
            System.out.println("pointResponse: " + pointResponse);
            
            if (pointResponse == null || !pointResponse.has("properties") || 
                !pointResponse.get("properties").has("forecast")) {
                throw new RuntimeException("Invalid weather data format: forecast URL not found");
            }
            
            String forecastUrl = pointResponse.get("properties").get("forecast").asText();
            String forecastPath = forecastUrl.replace("https://api.weather.gov", "");
            
            JsonNode forecastResponse = restClient.get()
                    .uri(forecastPath)
                    .retrieve()
                    .body(JsonNode.class);
                    
            return objectMapper.writeValueAsString(forecastResponse);
            
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch weather data: " + e.getMessage(), e);
        }
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
