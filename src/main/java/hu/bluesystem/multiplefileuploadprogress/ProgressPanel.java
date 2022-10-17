/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.bluesystem.multiplefileuploadprogress;


import java.util.ArrayList;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.event.IEvent;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

/**
 *
 * @author sfeher
 */
public class ProgressPanel extends Panel {

    WebMarkupContainer container;
    IModel<ArrayList<FileUpload>> fmodel;
    Label msg;
    String prop;

    public ProgressPanel(String id, WebMarkupContainer container, IModel<ArrayList<FileUpload>> fmodel) {
        super(id);
        this.fmodel = fmodel;
        this.container = container;
        msg = new Label("pending", new LoadableDetachableModel() {
            @Override
            protected Object load() {
                return prop;
            }
        }
        );
        msg.setOutputMarkupId(true);
        add(msg);
    }

    @Override
    public void onEvent(IEvent<?> event) {
        if (event.getPayload() instanceof HrpAppEvents) {
            HrpAppEvents e = (HrpAppEvents) event.getPayload();
            AjaxRequestTarget target = e.getArt();
            //if (fmodel != null && !fmodel.getObject().isEmpty()) {
                if (e.getStatus() != null) {
                    prop = e.getPayLoad();
                }
            //}
            if (target != null) {
                target.add(container);
            }
        }
    }

}
