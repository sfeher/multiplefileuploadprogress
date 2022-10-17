/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.bluesystem.multiplefileuploadprogress;

import java.io.Serializable;
import org.apache.wicket.ajax.AjaxRequestTarget;

/**
 *
 * @author sfeher
 */
public class HrpAppEvents implements Serializable {

    String target;
    String payLoad;
    String status;
    AjaxRequestTarget art;

    public HrpAppEvents(AjaxRequestTarget art, String target, String payLoad, String status) {
        this.art = art;
        this.target = target;
        this.payLoad = payLoad;
        this.status = status;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getPayLoad() {
        return payLoad;
    }

    public void setPayLoad(String payLoad) {
        this.payLoad = payLoad;
    }

    public AjaxRequestTarget getArt() {
        return art;
    }

    public void setArt(AjaxRequestTarget art) {
        this.art = art;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
