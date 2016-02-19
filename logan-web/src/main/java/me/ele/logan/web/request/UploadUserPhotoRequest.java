/**
 
 * 日    期：12-8-1
 */
package me.ele.logan.web.request;

import com.rop.AbstractRopRequest;
import com.rop.request.UploadFile;


public class UploadUserPhotoRequest extends AbstractRopRequest {

    private String userId;

    private UploadFile photo;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UploadFile getPhoto() {
        return photo;
    }

    public void setPhoto(UploadFile photo) {
        this.photo = photo;
    }
}

