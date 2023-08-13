package com.company.assmblycalendar.screen.event;

import io.jmix.ui.screen.*;
import com.company.assmblycalendar.entity.Event;

@UiController("Event.edit")
@UiDescriptor("event-edit.xml")
@EditedEntityContainer("eventDc")
public class EventEdit extends StandardEditor<Event> {
}