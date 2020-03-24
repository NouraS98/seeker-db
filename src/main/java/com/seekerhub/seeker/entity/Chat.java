package com.seekerhub.seeker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Chat extends BaseEntity{


    @OneToOne
    @JoinColumn(name = "user1_id", referencedColumnName = "id")
    private User firstUser;

    @OneToOne
    @JoinColumn(name = "user2_id", referencedColumnName = "id")
    private User secondUser;

    @OneToMany(
            mappedBy = "chat"
    )
    private List<ChatMessage> chatMessages = new ArrayList<>();

}
