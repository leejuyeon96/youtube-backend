package com.kh.youtube.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicInsert
public class Subscribe {

    @Id
    @Column(name = "SUBS_CODE")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "subSequence")
    @SequenceGenerator(name = "subSequence", sequenceName="SEQ_SUBSCRIBE", allocationSize = 1)
    private int subsCode;


    @Column(name="SUBS_DATE")
    private Date subsDate;

    @ManyToOne
    @JoinColumn(name = "id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "CHANNEL_CODE")
    private Channel channel;

}
