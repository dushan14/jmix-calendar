package com.company.assmblycalendar.screen.week;

import com.company.assmblycalendar.entity.Event;
import com.company.assmblycalendar.screen.dayjscontainer.DayJsContainer;
import com.company.assmblycalendar.screen.event.Calendar;
import io.jmix.ui.screen.ScreenFragment;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

@UiController("Week")
@UiDescriptor("week.xml")
public class Week extends ScreenFragment {
    @Autowired
    private DayJsContainer day1;
    @Autowired
    private DayJsContainer day2;
    @Autowired
    private DayJsContainer day3;
    @Autowired
    private DayJsContainer day4;
    @Autowired
    private DayJsContainer day5;

    private Calendar calendar;

    private List<Event> events;

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
        loadDays();
    }

    public void setEvents(List<Event> events) {
        this.events = events;
        loadDays();
    }

    public void loadDays() {
        if (this.calendar != null) {
            day1.setCalendar(this.calendar);
            day2.setCalendar(this.calendar);
            day3.setCalendar(this.calendar);
            day4.setCalendar(this.calendar);
            day5.setCalendar(this.calendar);

        }

        if (this.events != null) {
            day1.setEvents(events);
        }
        day2.setEvents(Collections.emptyList());
        day3.setEvents(Collections.emptyList());
        day4.setEvents(Collections.emptyList());
        day5.setEvents(Collections.emptyList());
    }

    @Subscribe
    public void onAfterInit(AfterInitEvent event) {
        loadDays();
    }
}