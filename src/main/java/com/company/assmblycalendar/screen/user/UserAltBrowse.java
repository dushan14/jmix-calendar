package com.company.assmblycalendar.screen.user;

import com.company.assmblycalendar.entity.User;
import io.jmix.ui.component.JavaScriptComponent;
import io.jmix.ui.model.CollectionContainer;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("UserAlt.browse")
@UiDescriptor("user-alt-browse.xml")
public class UserAltBrowse extends StandardLookup<User> {
    @Autowired
    private CollectionContainer<User> usersAddedDc;
    @Autowired
    private JavaScriptComponent firstBox;
    @Autowired
    private JavaScriptComponent secondBox;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
//        DragSource<User> dragSource = DragSource.create(usersTable);
//        DropTarget<User> dropTarget = DropTarget.create(usersAddedTable);
    }


    @Subscribe
    public void onAfterShow(AfterShowEvent event) {

    }

//    @Subscribe("usersTable")
//    protected void onItemsDataGridDragAndDrop(GridDropEvent<User> event) {
//        DataGridItems.Sortable<User> sortableDataProvider = (DataGridItems.Sortable<User>) usersTable.getItems();
//
//        // Handle drag-and-drop logic
//        // For example, reorder items based on the event
//    }

}