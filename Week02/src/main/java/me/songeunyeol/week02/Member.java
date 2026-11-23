package me.songeunyeol.week02;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//DB 테이블의 'id' 컬럼과 매칭

    @Column(name = "name",nullable = false)
    private String name;

    public Member(String name){
        this.name = name;
    }
}
