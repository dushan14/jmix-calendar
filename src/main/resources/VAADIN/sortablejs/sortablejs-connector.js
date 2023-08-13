ui_ex1_components_javascript_SortableJs = function () {
    let connector = this;
    let dayWrapper = connector.getElement();

    dayWrapper.innerHTML = `<div class="day-container"></div>`

    connector.onStateChange = function () {

        let state = connector.getState();
        let data = state.data;

        const events = createEvents(data);
        events.forEach(function(event) {
             dayWrapper.firstChild.appendChild(event);
        });

        let sortable = new Sortable(dayWrapper.firstChild, {
          group: 'shared',
          animation: 150,
          draggable: '.event',
          onEnd: function(evt) {
            // Handle reordering between containers
            if (evt.from !== evt.to) {
              // Do something when an event is moved between containers
            }
          }
        });
    }
};

createEvents = function(params) {
  let events = [];
  for(event of params?.options?.events?.myArrayList) {
    events.push(createEvent(event?.map));
  }
  return events;
}

createEvent = function(params) {
    let div = document.createElement('div');

    let htmlString = `
        <div class="event">
          <div class="event-description">${params?.description}</div>
          <div class="event-squares">
            <div class="square">${params?.phase1}</div>
            <div class="square">${params?.phase2}</div>
            <div class="square">${params?.phase3}</div>
            <div class="square">${params?.phase4}</div>
          </div>
        </div>
    `;
    div.innerHTML = htmlString.trim();
    return div.firstChild;
}