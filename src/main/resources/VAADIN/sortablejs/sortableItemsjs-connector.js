ui_ex1_components_javascript_SortableJsItems = function () {
    var connector = this;
    var element = connector.getElement();

    element.innerHTML = `<div id="area_2" class="drop-target">
                             <div class="list-group-item tinted" parent_id="" data-id="item_1">Item 1</div>
                             <div class="list-group-item tinted" parent_id="" data-id="item_2">Item 2</div>
                             <div class="list-group-item tinted" parent_id="" data-id="item_3">Item 3</div>
                           </div>`

    var itemArea = element.querySelector("#area_2")
    connector.onStateChange = function () {
        var state = connector.getState();
        var data = state.data;

        var sortable = new Sortable(itemArea, {
          group: {
            name: "shared",
            put: false // Do not allow items to be put into this list
          },
          animation: 150,
          sort: false // To disable sorting: set sort to false
        });
    }
};