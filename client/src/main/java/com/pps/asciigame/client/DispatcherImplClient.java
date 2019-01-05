package com.pps.asciigame.client;

import com.pps.asciigame.client.chat.ChatController;
import com.pps.asciigame.common.Dispatcher;
import com.pps.asciigame.common.protocol.ChatEntry;
import com.pps.asciigame.common.protocol.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DispatcherImplClient implements Dispatcher {
    @Autowired
    private ChatController chatController;

    @Override
    @SuppressWarnings("unchecked")
    public void dispatch(final Message message) {
        if (message instanceof ChatEntry) {
            chatController.handle((ChatEntry) message);
        } else {
            throw new UnsupportedOperationException("Unsupported message type.");
        }
    }
}
