package hu.bluesystem.multiplefileuploadprogress;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.event.Broadcast;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxButton;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.MultiFileUploadField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class HomePage extends WebPage {


    private static final long serialVersionUID = 1L;

    WebMarkupContainer container;

    MultiFileUploadField fileUpload;
    IModel<ArrayList<FileUpload>> fmodel;
    Collection<FileUpload> uploadedFiles;
    ProgressPanel ppanel;

    public HomePage() {

        container = new WebMarkupContainer("container");
        container.setOutputMarkupId(true);
        ArrayList<FileUpload> uploads = new ArrayList<>();
        fmodel = new Model<>(uploads);
        fileUpload = new MultiFileUploadField("uploadfield", fmodel);
        Form uploadForm = new Form("uploadForm");
        uploadForm.setMultiPart(true);


        uploadForm.add(fileUpload);

        IndicatingAjaxButton send = new IndicatingAjaxButton("send") {

            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                    send(getPage(), Broadcast.BREADTH, new HrpAppEvents(target, HomePage.this.getClass().getName(), "betegseg.upload.pending", "start"));
                    uploadedFiles = fileUpload.getModelObject();
            }

            @Override
            protected void onError(AjaxRequestTarget target, Form<?> form) {
                super.onError();
            }

        };

        send.add(new Label("sendlabel", "upload"));

        uploadForm.add(send);

        container.add(uploadForm);

        add(container);

    }
}
