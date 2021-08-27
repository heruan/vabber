package com.vaadin.vabber.ui;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.RouterLink;

public class MainLayout extends AppLayout {

    private final Tabs tabs = new Tabs();

    public MainLayout() {
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("Vabber");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "0");

        setupTabs();
        addToDrawer(tabs);
        addToNavbar(toggle, title);
    }

    private void setupTabs() {
        tabs.add(createTab(VaadinIcon.CHAT, "general"));
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
    }

    private Tab createTab(VaadinIcon viewIcon, String viewName) {
        Icon icon = viewIcon.create();
        icon.getStyle().set("box-sizing", "border-box")
                .set("margin-inline-end", "var(--lumo-space-m)")
                .set("margin-inline-start", "var(--lumo-space-xs)")
                .set("padding", "var(--lumo-space-xs)");

        RouterLink link = new RouterLink();
        link.add(icon, new Span(viewName));
        link.setRoute(ChannelView.class, viewName);
        link.setTabIndex(-1);

        return new Tab(link);
    }

}
