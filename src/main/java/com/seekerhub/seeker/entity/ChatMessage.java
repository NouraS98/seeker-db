package com.seekerhub.seeker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    private User sender;
    private String message;

    @ManyToOne
    private Chat chat;
}
