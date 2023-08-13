package com.company.assmblycalendar.screen.event;

import com.company.assmblycalendar.entity.CalendarViewType;
import com.company.assmblycalendar.entity.Event;
import com.company.assmblycalendar.screen.dayjscontainer.DayJsContainer;
import com.company.assmblycalendar.screen.week.Week;
import io.jmix.ui.Fragments;
import io.jmix.ui.component.ComboBox;
import io.jmix.ui.component.VBoxLayout;
import io.jmix.ui.model.CollectionContainer;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.screen.StandardLookup;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

@UiController("calendar")
@UiDescriptor("calendar.xml")
public class Calendar extends StandardLookup<Event> {
    @Autowired
    private CollectionContainer<Event> eventsDc;
    @Autowired
    private CollectionLoader<Event> eventsDl;

    @Autowired
    private Week week1;
    @Autowired
    private Week week2;
    @Autowired
    private Week week3;
    @Autowired
    private Week week4;
    @Autowired
    private Fragments fragments;
    @Autowired
    private VBoxLayout container;
    @Autowired
    private ComboBox<CalendarViewType> calendarViewType;

    public void loadCalendar() {
        eventsDl.load();
        List<Event> events = eventsDc.getItems();

        container.removeAll();

        if (CalendarViewType.MONTH.equals(calendarViewType.getValue())) {
            Week week1 = fragments.create(this, Week.class);
            week4.setCalendar(this);
            week1.setEvents(events);
            container.add(week1.getFragment());

            Week week2 = fragments.create(this, Week.class);
            week4.setCalendar(this);
            week2.setEvents(Collections.emptyList());
            container.add(week2.getFragment());

            Week week3 = fragments.create(this, Week.class);
            week4.setCalendar(this);
            week3.setEvents(events);
            container.add(week3.getFragment());

            Week week4 = fragments.create(this, Week.class);
            week4.setCalendar(this);
            week4.setEvents(Collections.emptyList());
            container.add(week4.getFragment());
        }
        if (CalendarViewType.WEEK.equals(calendarViewType.getValue())) {
            Week week1 = fragments.create(this, Week.class);
            week4.setCalendar(this);
            week1.setEvents(events);
            container.add(week1.getFragment());
        }
        if (CalendarViewType.DAY.equals(calendarViewType.getValue())) {
            DayJsContainer day = fragments.create(this, DayJsContainer.class);
            day.setCalendar(this);
            day.setEvents(events);
            container.add(day.getFragment());
        }

    }

    @Subscribe
    public void onAfterShow(AfterShowEvent event) {
        calendarViewType.setValue(CalendarViewType.MONTH);
        loadCalendar();
        calendarViewType.addValueChangeListener(calendarViewTypeValueChangeEvent -> loadCalendar());
    }


}