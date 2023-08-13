package com.company.assmblycalendar.screen.dayjscontainer;

import com.company.assmblycalendar.entity.Event;
import com.company.assmblycalendar.screen.event.Calendar;
import elemental.json.JsonArray;
import io.jmix.core.common.util.ParamsMap;
import io.jmix.ui.component.JavaScriptComponent;
import io.jmix.ui.screen.ScreenFragment;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@UiController("DayJsContainer")
@UiDescriptor("day-js-container.xml")
public class DayJsContainer extends ScreenFragment {
    @Autowired
    private JavaScriptComponent dayContainer;

    private List<Event> events;
    private Calendar calendar;

    public void setEvents(List<Event> events) {
        this.events = events;
        setupJSComponent();
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    @Subscribe
    public void onInit(InitEvent event) {
        setupJSComponent();
    }

    public void setupJSComponent() {
        DayJsContainerState state = new DayJsContainerState();
        JSONArray eventsJsonArray = new JSONArray();
        if (events != null) {
            eventsJsonArray = new JSONArray(events);
        }

        state.options = ParamsMap.of("events", eventsJsonArray);
        dayContainer.setState(state);
        dayContainer.addFunction("dropped", javaScriptCallbackEvent -> {
            JsonArray arguments = javaScriptCallbackEvent.getArguments();
            onDropped(arguments);
        });
    }

    private void onDropped(JsonArray arguments) {

    }


    static class DayJsContainerState {
        public Map<String, Object> options;
    }
}