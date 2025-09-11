package comspringboot.audiotranscriber.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.ai.audio.transcription.AudioTranscriptionPrompt;
import org.springframework.ai.audio.transcription.AudioTranscriptionResponse;
import org.springframework.ai.model.ApiKey;
import org.springframework.ai.openai.OpenAiAudioTranscriptionModel;
import org.springframework.ai.openai.OpenAiAudioTranscriptionOptions;
import org.springframework.ai.openai.api.OpenAiAudioApi;
import org.springframework.ai.openai.api.OpenAiAudioApi.TranscriptResponseFormat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/transcriber")
public class TranscriberController {

    private final OpenAiAudioTranscriptionModel openAiAudioTranscriptionModel;

//    public TranscriberController(
//            @Value("${spring.ai.openai.api-key}") String apiKey,
//            RestClient.Builder restClientBuilder) {
//
//        // ✅ Properly initialize OpenAiAudioApi with a valid RestClient.Builder
//    	OpenAiAudioApi openAiAudioApi = new OpenAiAudioApi(apiKey, (ApiKey) restClientBuilder, null, null, null, null);
//        this.openAiAudioTranscriptionModel = new OpenAiAudioTranscriptionModel(openAiAudioApi);
//    }
    
    public TranscriberController(OpenAiAudioTranscriptionModel openAiAudioTranscriptionModel) {
        this.openAiAudioTranscriptionModel = openAiAudioTranscriptionModel;
    }
    
    
    @PostMapping
    public ResponseEntity<String> transcriberAudio(@RequestParam("file") MultipartFile file) {
        File tempFile = null;
        try {
            tempFile = File.createTempFile("audio", ".wav");
            file.transferTo(tempFile);

            OpenAiAudioTranscriptionOptions transcriptionOptions = OpenAiAudioTranscriptionOptions.builder()
                    .responseFormat(TranscriptResponseFormat.TEXT)
                    .language("en")
                    .temperature(0f)
                    .build();

            FileSystemResource audioFile = new FileSystemResource(tempFile);

            AudioTranscriptionPrompt transcriptionRequest =
                    new AudioTranscriptionPrompt(audioFile, transcriptionOptions);

            AudioTranscriptionResponse response =
                    openAiAudioTranscriptionModel.call(transcriptionRequest);

            return new ResponseEntity<>(response.getResult().getOutput(), HttpStatus.OK);

        } catch (Exception ex) {
            // ✅ Custom error response
            return new ResponseEntity<>(
                    "Your Requests Limit has been Crossed please try to recharge your credit score",
                    HttpStatus.TOO_MANY_REQUESTS
            );
        } finally {
            if (tempFile != null && tempFile.exists()) {
                tempFile.delete();
            }
        }
    }

}
