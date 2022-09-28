package com.example.demo.web;

import com.example.demo.domain.Player;
import com.example.demo.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.AsyncListenableTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequestMapping("/player")
public class PlayerController {

    private PlayerService playerService;
    private AsyncListenableTaskExecutor asyncListenableTaskExecutor;
    private Logger logger = LoggerFactory.getLogger(PlayerController.class);

    @Autowired
    public PlayerController(PlayerService playerService, AsyncListenableTaskExecutor asyncListenableTaskExecutor) {
        this.playerService = playerService;
        this.asyncListenableTaskExecutor = asyncListenableTaskExecutor;
    }

    @GetMapping("/callable")
    public Callable<String> listPlayersCallable(Model model) {
        logger.info("Start thread name: " + Thread.currentThread().getName());

        Callable<String> callable = () -> {
            logger.info("Callable thread name " + Thread.currentThread().getName());
            List<Player> players = this.playerService.getAll();
            Thread.sleep(5000);
            model.addAttribute("players", players);
            return "player";
        };

        logger.info("End thread name: " + Thread.currentThread().getName());
        return callable;
    }

    @GetMapping("/deferredResult")
    public DeferredResult<String> listPlayersDeferredResult(Model model) {
        final DeferredResult<String> deferredResult = new DeferredResult<>();
        logger.info("Start thread name: " + Thread.currentThread().getName());

        asyncListenableTaskExecutor.execute(() -> {
            logger.info("ThreadPoolTaskExecutor thread name " + Thread.currentThread().getName());
            List<Player> players = this.playerService.getAll();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            model.addAttribute("players", players);
            deferredResult.setResult("player");
        });

        logger.info("End thread name: " + Thread.currentThread().getName());
        return deferredResult;
    }

    @GetMapping("/completableFuture")
    public CompletableFuture<String> completableFuture(Model model) {
        logger.info("Start thread name: " + Thread.currentThread().getName());

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            logger.info("CompletableFuture - thread name " + Thread.currentThread().getName());
            List<Player> players = this.playerService.getAll();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            model.addAttribute("players", players);
            return "player";
        }, asyncListenableTaskExecutor);

        logger.info("End thread name: " + Thread.currentThread().getName());
        return completableFuture;
    }

    @GetMapping("/listenableFuture")
    public ListenableFuture<String> listenableFuture(Model model) {
        logger.info("Start thread name: " + Thread.currentThread().getName());

        ListenableFuture<String> listenableFuture = asyncListenableTaskExecutor.submitListenable(() -> {
            logger.info("AsyncListenableTaskExecutor thread name " + Thread.currentThread().getName());
            List<Player> players = this.playerService.getAll();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            model.addAttribute("players", players);
            return "player";
        });

        logger.info("End thread name: " + Thread.currentThread().getName());
        return listenableFuture;
    }
}
