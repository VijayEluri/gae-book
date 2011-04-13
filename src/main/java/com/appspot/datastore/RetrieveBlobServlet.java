package com.appspot.datastore;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class RetrieveBlobServlet extends HttpServlet {

  private static final long serialVersionUID = 2380641632803777837L;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
            IOException {

        String id = request.getRequestURI()
                .replaceAll("/retrieve-blob/", "");

        BlobstoreService blobstoreService =
            BlobstoreServiceFactory.getBlobstoreService();

        blobstoreService.serve(new BlobKey(id), response);
  }
}
