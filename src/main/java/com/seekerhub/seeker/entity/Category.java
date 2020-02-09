package com.seekerhub.seeker.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseEntity {
    private String title;
    private String description;


    @OneToMany(
            mappedBy = "category"
    )
    private List<Project> projects = new ArrayList<>();

    //categoryId
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "skill_category" , joinColumns = { // هنا اسوي جوين لل٢ تيبلز عشان العلاقة ماني تو ماني
            @JoinColumn(name = "category_id" , referencedColumnName = "id") // التيبل الاول
    }, inverseJoinColumns = {
            @JoinColumn(name = "skill_id" , referencedColumnName = "id") // التيبل الثاني
    })
    private Set<Skill> skills = new HashSet<>();

}


