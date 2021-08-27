package com.vaadin.vabber.ui;

import com.vaadin.collaborationengine.CollaborationMessageInput;
import com.vaadin.collaborationengine.CollaborationMessageList;
import com.vaadin.collaborationengine.UserInfo;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

@Route(value = "channel", layout = MainLayout.class)
public class ChannelView extends VerticalLayout
        implements HasUrlParameter<String> {

    private final CollaborationMessageList chat;

    private final CollaborationMessageInput input;

    public ChannelView() {
        chat = new CollaborationMessageList(new UserInfo("foo"), null);
        input = new CollaborationMessageInput(chat);
        chat.setWidthFull();
        input.setWidthFull();
        addAndExpand(chat);
        add(input);
    }

    @Override
    public void setParameter(BeforeEvent event, String channel) {
        chat.setTopic(channel);
    }

}
