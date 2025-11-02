// package com.kiro.agenticai.service;

// import com.fasterxml.jackson.databind.JsonNode;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import okhttp3.*;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Service;

// @Service
// public class GeminiService {

//     @Value("${gemini.api.key}")
//     private String apiKey;

//     private final ObjectMapper mapper = new ObjectMapper();

//     public String summarizeText(String input) {
//         try {
//             OkHttpClient client = new OkHttpClient();
//             String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=" + apiKey;

//             String json = "{ \"contents\": [{\"parts\":[{\"text\":\"Summarize this IT insight text: " + input + "\"}]}]}";

//             RequestBody body = RequestBody.create(json, MediaType.get("application/json"));
//             Request request = new Request.Builder().url(url).post(body).build();

//             Response response = client.newCall(request).execute();
//             String resBody = response.body().string();
//             JsonNode root = mapper.readTree(resBody);

//             return root.path("candidates").get(0)
//                        .path("content").path("parts").get(0)
//                        .path("text").asText();

//         } catch (Exception e) {
//             e.printStackTrace();
//             return "(Fallback) Unable to reach Gemini API.";
//         }
//     }
// }
