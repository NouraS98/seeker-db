package com.seekerhub.seeker.entity;

import com.seekerhub.seeker.enums.RoleEnum;
import javassist.bytecode.ByteArray;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends BaseEntity {

    @Column(unique = true , nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true , nullable = false)
    private String email;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role" , joinColumns = { // هنا اسوي جوين لل٢ تيبلز عشان العلاقة ماني تو ماني
            @JoinColumn(name = "user_id" , referencedColumnName = "id") // التيبل الاول
    }, inverseJoinColumns = {
            @JoinColumn(name = "role_id" , referencedColumnName = "id") // التيبل الثاني
    })
    private Set<Role> roles = new HashSet<>();

    @Column(unique = true)
    private String phone_number;

    @Column(unique = true)
    private String national_id;
    private String rating;

    // TODO: User Entity: cascade = CascadeType.REMOVE
    @OneToOne(mappedBy = "user", cascade = REMOVE)
    private Employer employer;

    @OneToOne(mappedBy = "user", cascade = REMOVE)
    private Freelancer freelancer;

    @OneToOne
    private UserSocialMedia userSocialMedia;

    @ColumnDefault("1")
    private String isEnabled;

    @Enumerated(EnumType.STRING)
    private RoleEnum current_type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "avatar_id", referencedColumnName = "id")
    private StorageDocument avatar;

//    @ColumnDefault("NA")
    private String twitter;

    private String facebook;

    private String linkedIn;

    private String education;
    private byte[] img;
    private String token_id;

    @ColumnDefault("false")
   private boolean verified;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<StorageDocument> sampleWorks = new ArrayList<>();

}
