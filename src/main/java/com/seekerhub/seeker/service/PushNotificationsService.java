package com.seekerhub.seeker.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.seekerhub.seeker.dto.Bid.BidDto;
import com.seekerhub.seeker.dto.Chat.ChatMessageDto;
import com.seekerhub.seeker.dto.Milestone.MilestoneDto;
import com.seekerhub.seeker.dto.Project.ProjectDto;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class PushNotificationsService {

    private static final String FIREBASE_SERVER_KEY = "AAAACxifpR4:APA91bGaZ3yKDtlj-n8PCkLP6orVULQjDowcx74t5KLB8TGrqEchiogBsKPJ4CbkyUbht6eQAQeRGzfV6uT2c246dygY9Nw0-aIXADeu0ouJui2acPhRp9-A_ffRnRNWUdXqbQvChBch";
    private static final String FIREBASE_API_URL = "https://fcm.googleapis.com/fcm/send";

    @Async
    public CompletableFuture<String> send(HttpEntity<String> entity) {

        RestTemplate restTemplate = new RestTemplate();

        /**
         https://fcm.googleapis.com/fcm/send
         Content-Type:application/json
         Authorization:key=FIREBASE_SERVER_KEY*/

        ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new HeaderRequestInterceptor("Authorization", "key=" + FIREBASE_SERVER_KEY));
        interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json"));
        restTemplate.setInterceptors(interceptors);

        String firebaseResponse = restTemplate.postForObject(FIREBASE_API_URL, entity, String.class);

        return CompletableFuture.completedFuture(firebaseResponse);
    }

    public void sendToAUser(ChatMessageDto notificationDto, String token) throws JSONException {

        JSONObject body = new JSONObject();
        body.put("to", token);
        body.put("priority", "high");

        JSONObject notification = new JSONObject();
//        notification.put("title", notificationDto.getSender().getUsername());
//        notification.put("body", notificationDto.getMessage());

        JSONObject data = new JSONObject();
        ObjectMapper mapper = new ObjectMapper( );
      mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
      mapper.registerModule(new JavaTimeModule());
        try {
            data.put("title", notificationDto.getSender().getUsername());
            data.put("body", notificationDto.getMessage());
            data.put("type", "chat");

            data.put("message", mapper.writeValueAsString(notificationDto));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // data.put("Key-2", "JSA Data 2");

//        body.put("notification", notification);

        body.put("data", data);

        HttpEntity<String> request = new HttpEntity<>(body.toString());

        CompletableFuture<String> pushNotification = send(request);
        CompletableFuture.allOf(pushNotification).join();

        try {
            String firebaseResponse = pushNotification.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    public void sendBeforeExpiry(ProjectDto projectDto) {
        JSONObject body = new JSONObject();
        String token = projectDto.getEmployer().getUser().getToken_id();
        body.put("to", token);
        body.put("priority", "high");

        JSONObject notification = new JSONObject();
//        notification.put("title", projectDto.getTitle());
//        notification.put("body", "The project will expire very soon and it will be deleted, extend it now ");

        JSONObject data = new JSONObject();
        ObjectMapper mapper = new ObjectMapper( );
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.registerModule(new JavaTimeModule());
        try {
            data.put("title", projectDto.getTitle());
            data.put("body", "The project will expire very soon and it will be deleted, extend it now ");
            data.put("type", "expiry");
            data.put("message", mapper.writeValueAsString(projectDto));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // data.put("Key-2", "JSA Data 2");

//        body.put("notification", notification);

        body.put("data", data);

        HttpEntity<String> request = new HttpEntity<>(body.toString());

        CompletableFuture<String> pushNotification = send(request);
        CompletableFuture.allOf(pushNotification).join();

        try {
            String firebaseResponse = pushNotification.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void sendAcceptBidNotification(BidDto bid , String token) {
        JSONObject body = new JSONObject();
        body.put("to", token);
        body.put("priority", "high");

        JSONObject notification = new JSONObject();
//        notification.put("title", bid.getTitle());
//        notification.put("body", "Your bid on  " + bid.getProject().getTitle() + " is accepted");

        JSONObject data = new JSONObject();
        ObjectMapper mapper = new ObjectMapper( );
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.registerModule(new JavaTimeModule());
        try {
            data.put("title", bid.getTitle());
            data.put("body", "Your bid on  " + bid.getProject().getTitle() + " is accepted");

            data.put("type", "acceptBid");
            data.put("message", mapper.writeValueAsString(bid));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // data.put("Key-2", "JSA Data 2");

//        body.put("notification", notification);

        body.put("data", data);

        HttpEntity<String> request = new HttpEntity<>(body.toString());

        CompletableFuture<String> pushNotification = send(request);
        CompletableFuture.allOf(pushNotification).join();

        try {
            String firebaseResponse = pushNotification.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void sendBeforeMilestone(MilestoneDto milestoneDto, String token) {
        JSONObject body = new JSONObject();
        body.put("to", token);
        body.put("priority", "high");

        JSONObject notification = new JSONObject();

        JSONObject data = new JSONObject();
        ObjectMapper mapper = new ObjectMapper( );
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.registerModule(new JavaTimeModule());
        try {
            data.put("title", milestoneDto.getProject().getTitle());
            data.put("body", "Deadline of milestone of  " + milestoneDto.getProject().getTitle() + " is tomorrow, pay now");

            data.put("type", "milestone");
            data.put("message", mapper.writeValueAsString(milestoneDto));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // data.put("Key-2", "JSA Data 2");

//        body.put("notification", notification);

        body.put("data", data);

        HttpEntity<String> request = new HttpEntity<>(body.toString());

        CompletableFuture<String> pushNotification = send(request);
        CompletableFuture.allOf(pushNotification).join();

        try {
            String firebaseResponse = pushNotification.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void sendToFreelancerAccordingToSkills(ProjectDto projectDto, String token) {
        JSONObject body = new JSONObject();
        body.put("to", token);
        body.put("priority", "high");

        JSONObject notification = new JSONObject();
        notification.put("title", projectDto.getTitle());
        notification.put("body", "A project was posted according to your skills ");
//        notification.put("click_action","open_project");

        JSONObject data = new JSONObject();
        ObjectMapper mapper = new ObjectMapper( );
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.registerModule(new JavaTimeModule());
        try {
            data.put("title", projectDto.getTitle());
            data.put("body", "A project was posted according to your skills ");
            data.put("type", "skills");
            data.put("message", mapper.writeValueAsString(projectDto));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // data.put("Key-2", "JSA Data 2");

//        body.put("notification", notification);

        body.put("data", data);

        HttpEntity<String> request = new HttpEntity<>(body.toString());

        CompletableFuture<String> pushNotification = send(request);
        CompletableFuture.allOf(pushNotification).join();

        try {
            String firebaseResponse = pushNotification.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
