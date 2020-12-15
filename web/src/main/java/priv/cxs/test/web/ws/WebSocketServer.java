package priv.cxs.test.web.ws;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@ServerEndpoint("/ws/asset")
@Component
@Slf4j
public class WebSocketServer implements ApplicationContextAware {

    private final static AtomicInteger clientCount = new AtomicInteger(0);

    private static Map<String, Session> sessions;

    private static final Object sessionOpLock = new Object();

    private ScheduledExecutorService timedBroadCaster;

    public WebSocketServer() {
        System.out.println("instantiate a new server");
    }

    @PostConstruct
    public void init() {
        sessions = new HashMap<>();
        timedBroadCaster = Executors.newSingleThreadScheduledExecutor();
        timedBroadCaster.scheduleWithFixedDelay(() -> {
            Collection<Session> currentSessions = sessions.values();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for (Session session : currentSessions) {
                if (session.isOpen()) {
                    sendMessage(session, String.format("contact you %s at %s",
                            session.getId(), formatter.format(new Date())));
                }
            }
        }, 5, 3, TimeUnit.SECONDS);
    }

    @OnOpen
    public void onOpen(Session session) {
        int currentClients;
        synchronized (sessionOpLock) {
            currentClients = clientCount.incrementAndGet();
            sessions.put(session.getId(), session);
        }
        log.info("client connected, current client count = {}", currentClients);
    }

    @OnClose
    public void close(Session session) {
        int currentClients;
        synchronized (sessionOpLock) {
            sessions.remove(session.getId());
            currentClients = clientCount.decrementAndGet();
        }
        log.info("client disconnected, current client count = {}", currentClients);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("receive message {}, from client {}", message, session.getId());
        sendMessage(session, "message received");
    }


    @OnError
    public void onError(Session session, Throwable error) {
        log.error("unexcepted error with client {}", session.getId(), error);
    }

    private boolean sendMessage(Session session, String message) {
        try {
            session.getBasicRemote().sendText(message);
            return true;
        } catch (IOException e) {
            log.error("send feed back failed", e);
            return false;
        }
    }

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
