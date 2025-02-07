package com.example.board.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "board")
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String contents;
    //하나의 멤버가 여러개의 게시물을 작성할 수 있으므로 주인은 멤버인 단방향 연관관계 작성
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public Board(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public Board() {

    }

    public void setMember(Member member) {
        this.member = member;
    }
}
