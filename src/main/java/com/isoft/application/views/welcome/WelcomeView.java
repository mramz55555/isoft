package com.isoft.application.views.welcome;

import com.isoft.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.listbox.MultiSelectListBox;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import java.util.ArrayList;
import java.util.List;

@PageTitle("Welcome")
@Route(value = "", layout = MainLayout.class)
@Uses(Icon.class)
public class WelcomeView extends Composite<VerticalLayout> {

    public WelcomeView() {
        VerticalLayout layoutColumn2 = new VerticalLayout();
        H1 h1 = new H1();
        Paragraph textMedium = new Paragraph();
        H2 h2 = new H2();
        Paragraph textMedium2 = new Paragraph();
        H3 h3 = new H3();
        MultiSelectListBox textItems = new MultiSelectListBox();
        HorizontalLayout layoutRow = new HorizontalLayout();
        H6 h6 = new H6();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        h1.setText("welcome!");
        h1.setWidth("max-content");
        textMedium.setText(
                "Welcome to our new website! This website is designed as a portfolio website in Java programming and using the Spring framework.                                           Our website, as a sample work platform, allows you to view the latest projects and works carried out .");
        layoutColumn2.setAlignSelf(FlexComponent.Alignment.CENTER, textMedium);
        textMedium.setWidth("100%");
        textMedium.getStyle().set("font-size", "var(--lumo-font-size-m)");
        h2.setText("What is Isoft ?");
        h2.setWidth("max-content");
        textMedium2.setText("Isoft is a portfolio website, and in addition, future applications may also be included.");
        textMedium2.setWidth("100%");
        textMedium2.getStyle().set("font-size", "var(--lumo-font-size-m)");
        h3.setText("Technologies");
        h3.setWidth("max-content");
        textItems.setWidth("min-content");
        setMultiSelectListBoxSampleData(textItems);
        layoutRow.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.addClassName(Padding.XSMALL);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        layoutRow.setAlignItems(Alignment.CENTER);
        layoutRow.setJustifyContentMode(JustifyContentMode.CENTER);
        h6.setText("2023-2024 isoft");
        layoutRow.setAlignSelf(FlexComponent.Alignment.CENTER, h6);
        h6.setWidth("max-content");
        getContent().add(layoutColumn2);
        layoutColumn2.add(h1);
        layoutColumn2.add(textMedium);
        layoutColumn2.add(h2);
        layoutColumn2.add(textMedium2);
        layoutColumn2.add(h3);
        layoutColumn2.add(textItems);
        layoutColumn2.add(layoutRow);
        layoutRow.add(h6);
    }

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setMultiSelectListBoxSampleData(MultiSelectListBox multiSelectListBox) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("first", "First", null));
        sampleItems.add(new SampleItem("second", "Second", null));
        sampleItems.add(new SampleItem("third", "Third", Boolean.TRUE));
        sampleItems.add(new SampleItem("fourth", "Fourth", null));
        multiSelectListBox.setItems(sampleItems);
        multiSelectListBox.setItemLabelGenerator(item -> ((SampleItem) item).label());
        multiSelectListBox.setItemEnabledProvider(item -> !Boolean.TRUE.equals(((SampleItem) item).disabled()));
    }
}
