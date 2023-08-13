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

        let sortable = new Sortable(dayWrapper, {
            group: {"shared", put: false}, //nested
            animation: 150,
            fallbackOnBody: true,
            swapThreshold: 0.65,
            sort: false,
            multiDrag: true, // Enable multi-drag
            selectedClass: "selected", // The class applied to the selected items
            fallbackTolerance: 3, // So that we can select items on mobile



            setData: function (
             /** DataTransfer */ dataTransfer,
             /** HTMLElement*/ dragEl
            ) {
             dataTransfer.setData("Text", dragEl.textContent); // `dataTransfer` object of HTML5 DragEvent
             console.log("setData");
            },

            // Element is chosen
            onChoose: function (/**Event*/ evt) {
             evt.oldIndex; // element index within parent
             console.log("onChoose");
            },

            // Element is unchosen
            onUnchoose: function (/**Event*/ evt) {
             // same properties as onEnd
             console.log("onUnchoose");
            },

            // Element dragging started
            onStart: function (/**Event*/ evt) {
             evt.oldIndex; // element index within parent
             console.log("onStart");
            },

            // Element dragging ended
            onEnd: function (/**Event*/ evt) {
             let itemEl = evt.item; // dragged HTMLElement
             evt.to; // target list
             evt.from; // previous list
             evt.oldIndex; // element's old index within old parent
             evt.newIndex; // element's new index within new parent
             evt.oldDraggableIndex; // element's old index within old parent, only counting draggable elements
             evt.newDraggableIndex; // element's new index within new parent, only counting draggable elements
             evt.clone; // the clone element
             evt.pullMode; // when item is in another sortable: `"clone"` if cloning, `true` if moving
             console.log("onEnd");

             console.log(evt);
            },

            // Element is dropped into the list from another list
            onAdd: function (/**Event*/ evt) {
             // same properties as onEnd
             console.log("onAdd");
            },

            // Changed sorting within list
            onUpdate: function (/**Event*/ evt) {
             // same properties as onEnd
             console.log("onUpdate");
            },
            // Called by any change to the list (add / update / remove)
            onSort: function (/**Event*/ evt) {
             // same properties as onEnd
             console.log("onSort");
            },

            // Element is removed from the list into another list
            onRemove: function (/**Event*/ evt) {
             // same properties as onEnd
             console.log("onRemove");
            },

            // Attempt to drag a filtered element
            onFilter: function (/**Event*/ evt) {
             let itemEl = evt.item; // HTMLElement receiving the `mousedown|tapstart` event.
             console.log("onFilter");
            },

            // Called when creating a clone of element
            onClone: function (/**Event*/ evt) {
             let origEl = evt.item;
             let cloneEl = evt.clone;
             console.log("onClone");
            },

            // Called when dragging element changes position
            onChange: function (/**Event*/ evt) {
             evt.newIndex; // most likely why this event is used is to get the dragging element's current index
             // same properties as onEnd
             //
             console.log("onChange");
             console.log({
               event: name,
               this: this,
               item: evt.item,
               from: evt.from,
               to: evt.to,
               oldIndex: evt.oldIndex,
               newIndex: evt.newIndex,
               oldDraggableIndex: evt.oldDraggableIndex,
               newDraggableIndex: evt.newDraggableIndex
             });
            }
            }
        );
    }
};

createEvents = function(params) {
  let events = [];
  for(event in params?.options?.events?.myArrayList) {
    events.push(createEvent(event));
  }
  return events;
}

createEvent = function(params) {
    let div = document.createElement('div');

    let htmlString = `
        <div class="event">
          <div class="event-description">Event 1</div>
          <div class="event-squares">
            <div class="square"></div>
            <div class="square"></div>
            <div class="square"></div>
            <div class="square"></div>
          </div>
        </div>
    `;
    div.innerHTML = htmlString.trim();
    return div.firstChild;
}