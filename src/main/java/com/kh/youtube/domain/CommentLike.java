package com.kh.youtube.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
public class CommentLike {

    @Id
    @Column(name = "COMM_LIKE_CODE")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "commLikeSequence")
    @SequenceGenerator(name = "commLikeSequence", sequenceName = "SEQ_COMMENT_LIKE", allocationSize = 1)
    private int commLikeCode;

    @Column(name = "COMM_LIKE_DATE")
    private Date commLikeDate;

    @ManyToOne
    @JoinColumn(name = "COMMENT_CODE")
    private VideoComment comment;

    @ManyToOne
    @JoinColumn(name = "id")
    private Member member;
}
