package example;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.IOException;

/**
 * Created by scott.linford on 1/15/15.
 */

/*
@Controller
@RequestMapping("/rest")

    @RequestMapping(value = "/registry", method = RequestMethod.GET, headers = "Accept=application/json")
    public
    @ResponseBody
    List<Long> getRegistryList() {

    @RequestMapping(value = "/registry/{id}", method = RequestMethod.GET, headers = "Accept=application/xml, application/json")
    public
    @ResponseBody
    PatientRegistry getRegistry(@PathVariable("id") Long idRopr, HttpServletRequest request) {

    @RequestMapping(value = "/registry", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
    public
    @ResponseBody
    PrResult addRegistry(@RequestBody PatientRegistry patientRegistry) throws IllegalArgumentException,
            IllegalAccessException, NoSuchMethodException, InvocationTargetException {

    @RequestMapping(value = "/registry/{id}", method = RequestMethod.PUT, headers = "Accept=application/xml, application/json")
    public
    @ResponseBody
    PrResult updateRegistry(@PathVariable("id") Long idRopr, @RequestBody PatientRegistry patientRegistry,
                            HttpServletRequest request) throws SecurityException, IllegalArgumentException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException {

    @RequestMapping(value = "/registry/{id}/dateModified", method = RequestMethod.PUT, headers = "Accept=application/xml, application/json")
    public
    @ResponseBody
    PrResult updateRegistryDateModified(@PathVariable("id") Long idRopr, HttpServletRequest request)
            throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException,
            InvocationTargetException {

    @RequestMapping(value = "/registry/{id}", method = RequestMethod.DELETE, headers = "Accept=application/xml, application/json")
    public
    @ResponseBody
    PrResult deleteRegistry(@PathVariable("id") Long idRopr, HttpServletRequest request, HttpServletResponse response)
            throws IOException {

    @RequestMapping(value = "/registry/{idRopr}/link", method = RequestMethod.GET, headers = "Accept=application/json")
    public
    @ResponseBody
    List<Link> getLinkSet(@PathVariable("idRopr") Long idRopr, HttpServletRequest request) {

    @RequestMapping(value = "/registry/{idRopr}/link", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
    public
    @ResponseBody
    PrResult addLink(@PathVariable("idRopr") Long idRopr, @RequestBody Link link, HttpServletRequest request)
            throws IllegalArgumentException, IllegalAccessException {

    @RequestMapping(value = "/registry/{idRopr}/link/{id}", method = RequestMethod.PUT, headers = "Accept=application/xml, application/json")
    public
    @ResponseBody
    PrResult updateLink(@PathVariable("idRopr") Long idRopr, @PathVariable("id") Long id, @RequestBody Link link,
                        HttpServletRequest request) throws SecurityException, IllegalArgumentException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException {

    @RequestMapping(value = "/registry/{idRopr}/link/{id}", method = RequestMethod.DELETE, headers = "Accept=application/xml, application/json")
    public
    @ResponseBody
    PrResult deleteLink(@PathVariable("idRopr") Long idRopr, @PathVariable("id") Long id, HttpServletRequest request) {

    @RequestMapping(value = "/registry/{idRopr}/progress", method = RequestMethod.GET, headers = "Accept=application/json")
    public
    @ResponseBody
    List<Progress> getProgressSet(@PathVariable("idRopr") Long idRopr, HttpServletRequest request) {


*/



/*
POST

{
 "type": "text",
 "name": "firstName",
 "label": "First Name",
 "block": true
}

<div>
<label for="dataFirstName">First Name</label>
<input id="dataFirstName"
      type="text"
      name="firstName"/>
</div>
*/

@Path("/rest/api")
public class RestfulServiceTemplate {

    public static class HtmlFormField {
        public String type = "text";
        public String name = "firstName";
        public String label = "First Name";
        public boolean block = true;
    }

    @POST
    @Produces("application/xml")
    @Path("fields")
    public String createField(HtmlFormField hff) {
        StringBuilder sb = new StringBuilder();
        if (hff.block) sb.append("<div>\n");
        sb.append(
                "<label for=\"data%s\">%s</label>\n" +
                        "<input id=\"data%s\"\n" +
                        "      type=\"%s\"\n" +
                        "      name=\"%s\"/>\n".format(hff.name, hff.label, hff.type, hff.name));
        if (hff.block) sb.append("</div>\n");
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServerFactory.create("http://localhost:9998/");
        server.start();

        System.out.println("Server running");
        System.out.println("Visit: http://localhost:9998/rest/api/fields");
        System.out.println("Hit return to stop...");
        System.in.read();
        System.out.println("Stopping server");
        server.stop(0);
        System.out.println("Server stopped");
    }
}
