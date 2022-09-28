package com.example.demo.web;

import com.example.demo.domain.Player;
import com.example.demo.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.AsyncListenableTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequestMapping("/player")
public class PlayerController {

    private PlayerService playerService;
    private TaskExecutor taskExecutor;
    private Logger logger = LoggerFactory.getLogger(PlayerController.class);

    @Autowired
    public PlayerController(PlayerService playerService, TaskExecutor taskExecutor) {
        this.playerService = playerService;
        this.taskExecutor = taskExecutor;
    }

    @GetMapping("/responseBodyEmitter")
    public ResponseEntity<ResponseBodyEmitter> listPlayersResponseBodyEmitter() {
        logger.info("Response body emitter started!");
        final ResponseBodyEmitter emitter = new ResponseBodyEmitter();

        taskExecutor.execute(() -> {
            logger.info("Player list thread name: " + Thread.currentThread().getName());
            List<Player> players = this.playerService.getAll();
            for (Player player : players) {
                try {
                    Thread.sleep(1000);
                    logger.info(player.toString());
                    emitter.send(player);
                } catch (Exception e) {
                    emitter.completeWithError(e);
                }
            }

            emitter.complete();
        });

        logger.info("Response body emitter finished!");
        return ResponseEntity.status(200)
            .header("Content-Type", "text/event-stream")
            .body(emitter);
    }

    @GetMapping("/sseEmitter")
    public SseEmitter listPlayersSseEmitter() {
        final SseEmitter emitter = new SseEmitter();

        taskExecutor.execute(() -> {
            logger.info("Player list thread name: " + Thread.currentThread().getName());
            List<Player> players = this.playerService.getAll();
            for (Player player : players) {
                try {
                    Thread.sleep(1500);
                    logger.info(player.toString());
//                    emitter.send(player);
                    emitter.send(SseEmitter.event().id(String.valueOf(player.hashCode())).data(player));
                } catch (Exception e) {
                    emitter.completeWithError(e);
                }
            }

            emitter.complete();
        });

        return emitter;
    }
}
