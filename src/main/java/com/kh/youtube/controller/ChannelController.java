package com.kh.youtube.controller;

import com.kh.youtube.domain.Channel;
import com.kh.youtube.domain.Subscribe;
import com.kh.youtube.domain.Video;
import com.kh.youtube.service.ChannelService;
import com.kh.youtube.service.SubscribeService;
import com.kh.youtube.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/*")
public class ChannelController {
    



    //채널 추가 post http://localhost:8080/api/channel
    //채널 수정 put http://localhost:8080/api/channel
    //채널 삭제 delete http://localhost:8080/api/channel/1
    //내가 구독한 채널 조회 get http://localhost:8080/api/subscribe/user1
    //채널 구독 post http://localhost:8080/api/subscribe
    //채널 구독 취소  delete http://localhost:8080/api/subscribe/1
    @Autowired
    private ChannelService channel;

    @Autowired
    private VideoService video;
    @Autowired
    private SubscribeService subscribe;

    //채널 조회 get http://localhost:8080/api/channel/1
    @GetMapping("/channel/{id}")
    public ResponseEntity<Channel> showChannel(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(channel.show(id));
    }
    //채널에 있는 영상 조회 get http://localhost:8080/api/channel/1/video
    @GetMapping("/channel/{id}/video")
    public ResponseEntity<List<Video>> channelVideoList(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(video.findByChannelCode(id));
    }

    @PostMapping("/channel")
    public ResponseEntity<Channel> createChannel(@RequestBody Channel vo){
        return ResponseEntity.status(HttpStatus.OK).body(channel.create(vo));

    }
    @PutMapping("/channel")
    public ResponseEntity<Channel> updateChannel(@RequestBody Channel vo){
        return ResponseEntity.status(HttpStatus.OK).body(channel.update(vo));

    }

    @DeleteMapping("/channel/{id}")
    public ResponseEntity<Channel> deleteChannel(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(channel.delete(id));
    }

    @GetMapping("/subscribe/{user}")
    public ResponseEntity<List<Subscribe>> subscribeList(@PathVariable String user){
        return ResponseEntity.status(HttpStatus.OK).body(subscribe.findByMemberId(user));
}

    @PostMapping("/subscribe")
    public ResponseEntity<Subscribe> createsubscribeList(@RequestBody Subscribe vo){
        return ResponseEntity.status(HttpStatus.OK).body(subscribe.create(vo));
    }

    @DeleteMapping("/subscribe/{id}")
    public ResponseEntity<Subscribe> deletesubscribeList(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(subscribe.delete(id));
    }


}
