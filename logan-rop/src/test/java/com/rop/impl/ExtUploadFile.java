/**
 
 * 日    期：12-8-1
 */
package com.rop.impl;

import com.rop.request.UploadFile;

import java.io.File;


public class ExtUploadFile extends UploadFile {
    public ExtUploadFile(String fileType, byte[] content) {
        super(fileType, content);
    }

    public ExtUploadFile(File file) {
        super(file);
    }
}

