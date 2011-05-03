package com.appspot.capabilities;

import com.google.appengine.api.capabilities.CapabilitiesService;
import com.google.appengine.api.capabilities.CapabilitiesServiceFactory;
import com.google.appengine.api.capabilities.Capability;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CapabilitiesServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request,
                       HttpServletResponse response)
      throws ServletException, IOException {
    long start = System.currentTimeMillis();

    CapabilitiesService service =
        CapabilitiesServiceFactory.getCapabilitiesService();

    StringTemplateGroup group = new StringTemplateGroup("xhtml",
        "WEB-INF/templates/xhtml");
    StringTemplate template = group.getInstanceOf("capabilities");
    template.setAttribute("blobstore",
        service.getStatus(Capability.BLOBSTORE));
    template.setAttribute("datastore",
            service.getStatus(Capability.DATASTORE));
    template.setAttribute("datastorewrite",
            service.getStatus(Capability.DATASTORE_WRITE));
    template.setAttribute("images",
            service.getStatus(Capability.IMAGES));
    template.setAttribute("mail",
            service.getStatus(Capability.MAIL));
    template.setAttribute("memcache",
            service.getStatus(Capability.MEMCACHE));
    template.setAttribute("taskqueue",
            service.getStatus(Capability.TASKQUEUE));
    template.setAttribute("urlfetch",
            service.getStatus(Capability.URL_FETCH));
    template.setAttribute("xmpp",
        service.getStatus(Capability.XMPP));
    template.setAttribute("loadtime",
        "" + (System.currentTimeMillis() - start));
    template.setAttribute("gaestatus", "OK");

    response.getWriter().write(template.toString());

  }
}
