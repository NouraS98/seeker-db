package com.seekerhub.seeker.entity;

import com.seekerhub.seeker.service.user.TokenTypeE;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

import static javax.persistence.CascadeType.REMOVE;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
public class VerificationToken extends BaseEntity {

    private static final int EXPIRATION_HOURS = 24;

    @Column(name = "token", updatable = false, nullable = false)
    private String token;

    @OneToOne(fetch = FetchType.EAGER, cascade = REMOVE)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    @Column(name = "expiry_date")
    private Date expiryDate;

    @Column(name = "active", columnDefinition = "boolean default true")
    private boolean active;

    @Enumerated(EnumType.STRING)
    private TokenTypeE type;

    public VerificationToken(User user, String token, TokenTypeE tokenType) {
        this.user = user;
        this.token = token;
        this.setExpiryDate();
        this.type = tokenType;
    }


    public void setExpiryDate() {
        this.expiryDate = calculateExpiryDate(EXPIRATION_HOURS * 60);
    }

    private Date calculateExpiryDate(int expiryTimeInMinutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }
}
