package com.gihtub.onechesz.gpt_therapy.services;

import com.gihtub.onechesz.gpt_therapy.entities.EmailsEntity;
import com.gihtub.onechesz.gpt_therapy.repositories.EmailsRepository;
import com.gihtub.onechesz.gpt_therapy.util.api_models.MessageModel;
import com.gihtub.onechesz.gpt_therapy.util.api_models.RequestModel;
import com.gihtub.onechesz.gpt_therapy.util.api_models.ResponseModel;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class EmailsService {
    private final EmailsRepository emailsRepository;
    @Value("${openai-gpt-token}")
    private String openAIToken;
    private final RestTemplate restTemplate;

    public EmailsService(EmailsRepository emailsRepository, RestTemplate restTemplate) {
System.out.println("!!!! EmailsService !");
        this.emailsRepository = emailsRepository;
        this.restTemplate = restTemplate;
        System.out.println("!!!! EmailsService 2 !");
    }

    @Transactional
    public EmailsEntity saveAndRetrieveEntity(String story) {
        return emailsRepository.save(new EmailsEntity(story));
    }

    @Async
    @Transactional
    public void sendApiRequestAndUpdateDatabase(@NotNull EmailsEntity emailsEntity, String story) {
        String URL = "https://api.openai.com/v1/chat/completions";
        HttpHeaders httpHeaders = new HttpHeaders();
        RequestModel requestModel = new RequestModel();
System.out.println("!!!! 1231232 !");
        requestModel.appendMessage(new MessageModel("user", story));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("Authorization", "Bearer " + openAIToken);

        HttpEntity<RequestModel> requestEntity = new HttpEntity<>(requestModel, httpHeaders);
        ResponseEntity<ResponseModel> responseEntity = restTemplate.exchange(
                URL,
                HttpMethod.POST,
                requestEntity,
                ResponseModel.class
        );

        emailsEntity.setGptAnswer(Objects.requireNonNull(responseEntity.getBody()).getChoices().get(0).getMessage().getContent());
        emailsRepository.save(emailsEntity);
    }

    public Optional<EmailsEntity> findById(int id) {
        return emailsRepository.findById(id);
    }
}
