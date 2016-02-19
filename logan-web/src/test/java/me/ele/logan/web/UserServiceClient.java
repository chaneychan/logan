
package me.ele.logan.web;

import com.rop.MessageFormat;
import com.rop.client.ClientRequest;
import com.rop.client.CompositeResponse;
import com.rop.client.DefaultRopClient;
import com.rop.request.UploadFile;
import com.rop.response.ErrorResponse;
import com.rop.security.MainErrorType;

import me.ele.logan.web.converter.TelephoneConverter;
import me.ele.logan.web.request.*;
import me.ele.logan.web.response.CreateUserResponse;
import me.ele.logan.web.response.LogonResponse;
import me.ele.logan.web.response.UploadUserPhotoResponse;
import me.ele.logan.web.response.UserListResponse;

import org.springframework.core.io.ClassPathResource;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.*;


public class UserServiceClient {

    public static final String SERVER_URL = "http://localhost:8088/router";
    public static final String APP_KEY = "00001";
    public static final String APP_SECRET = "abcdeabcdeabcdeabcdeabcde";
    private DefaultRopClient ropClient = new DefaultRopClient(SERVER_URL, APP_KEY, APP_SECRET);

    {
        ropClient.addRopConvertor(new TelephoneConverter());
    }


    @SuppressWarnings("rawtypes")
	@BeforeClass
    public void createSession() {
        LogonRequest ropRequest = new LogonRequest();
        ropRequest.setUserName("tomson");
        ropRequest.setPassword("123456");
        CompositeResponse response = ropClient.buildClientRequest()
                                   .get(ropRequest, LogonResponse.class, "user.getSession", "1.0");
        assertNotNull(response);
        assertTrue(response.isSuccessful());
        assertNotNull(response.getSuccessResponse());
        assertTrue(response.getSuccessResponse() instanceof LogonResponse);
        assertEquals(((LogonResponse) response.getSuccessResponse()).getSessionId(), "mockSessionId1");
        ropClient.setSessionId(((LogonResponse) response.getSuccessResponse()).getSessionId());
    }

    @SuppressWarnings("rawtypes")
	@Test
    public void createSessionWithParamMap() {
        CompositeResponse response = ropClient.buildClientRequest()
                .addParam("userName", "tomson")
                .addParam("password", "123456", true)
                .get(LogonResponse.class, "user.getSession", "1.0");

        assertNotNull(response);
        assertTrue(response.isSuccessful());
        assertNotNull(response.getSuccessResponse());
        assertTrue(response.getSuccessResponse() instanceof LogonResponse);
        assertEquals(((LogonResponse) response.getSuccessResponse()).getSessionId(), "mockSessionId1");
    }

    @Test
    public void addUser() {
        CompositeResponse response = ropClient.buildClientRequest()
                .addParam("userName", "tomson")
                .addParam("password", "123456", true)
                .get(LogonResponse.class, "user.getSession", "1.0");
        String sessionId = ((LogonResponse) response.getSuccessResponse()).getSessionId();
        ropClient.setSessionId(sessionId);


        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setUserName("katty");
        createUserRequest.setSalary(2500L);

        Telephone telephone = new Telephone();
        telephone.setZoneCode("010");
        telephone.setTelephoneCode("12345678");
        createUserRequest.setTelephone(telephone);

        //add1
        response = ropClient.buildClientRequest()
                .post(createUserRequest, CreateUserResponse.class, "user.add", "1.0");
        assertNotNull(response);
        assertTrue(response.isSuccessful());
        assertTrue(response.getSuccessResponse() instanceof CreateUserResponse);

        //add2
        response = ropClient.buildClientRequest()
                .post(createUserRequest, CreateUserResponse.class, "user.add", "1.0");
    }

    @Test
    public void addUserUseParamMap() {
        CompositeResponse response = ropClient.buildClientRequest()
                .addParam("userName", "tomson")
                .addParam("password", "123456", true)
                .get(LogonResponse.class, "user.getSession", "1.0");
        String sessionId = ((LogonResponse) response.getSuccessResponse()).getSessionId();
        ropClient.setSessionId(sessionId);


        ClientRequest cr2 = ropClient.buildClientRequest();
        cr2.addParam("userName", "katty");
        cr2.addParam("salary", 2500L);
        Telephone telephone = new Telephone();
        telephone.setZoneCode("010");
        telephone.setTelephoneCode("12345678");
        cr2.addParam("telephone", telephone);

        response = cr2.post(CreateUserResponse.class, "user.add", "1.0");
        assertNotNull(response);
        assertTrue(response.isSuccessful());
        assertTrue(response.getSuccessResponse() instanceof CreateUserResponse);
    }


    @Test
    public void testAddUserByVersion3() {
        CreateUserRequest ropRequest = new CreateUserRequest();
        ropRequest.setUserName("tomson");
        ropRequest.setSalary(2500L);
        ropClient.setMessageFormat(MessageFormat.xml);

        CompositeResponse response = ropClient.buildClientRequest()
                .post(ropRequest, CreateUserResponse.class, "user.add", "3.0");
        assertNotNull(response);
        assertFalse(response.isSuccessful());
        assertNull(response.getSuccessResponse());
        assertNotNull(response.getErrorResponse());
        assertTrue(response.getErrorResponse() instanceof ErrorResponse);
        assertEquals(response.getErrorResponse().getCode(), MainErrorType.UNSUPPORTED_VERSION.value());
    }

    @Test
    public void testFileUpload() throws Throwable {
        ClientRequest cr = ropClient.buildClientRequest();

        UploadUserPhotoRequest request = new UploadUserPhotoRequest();
        ClassPathResource resource = new ClassPathResource("photo.png");
        UploadFile uploadFile = new UploadFile(resource.getFile());
        request.setPhoto(uploadFile);
        request.setUserId("1");
        ropClient.setMessageFormat(MessageFormat.xml);

        CompositeResponse response = ropClient.buildClientRequest()
                .post(request, UploadUserPhotoResponse.class, "user.upload.photo", "1.0");
        assertNotNull(response);
        assertTrue(response.isSuccessful());
        assertTrue(response.getSuccessResponse() instanceof UploadUserPhotoResponse);
        assertEquals(((UploadUserPhotoResponse) response.getSuccessResponse()).getFileType(), "png");
        assertEquals(((UploadUserPhotoResponse) response.getSuccessResponse()).getLength(), uploadFile.getContent().length);
    }

    @Test
    public void testServiceXmlRequestAttr() throws Throwable {
        CreateUserRequest request = new CreateUserRequest();
        request.setUserName("tomson");
        request.setLocked(true);
        request.setSalary(2500L);
        Address address = new Address();
        address.setZoneCode("0001");
        address.setDoorCode("002");
        Street street1 = new Street();
        street1.setName("street1");
        street1.setNo("001");
        Street street2 = new Street();
        street2.setName("street2");
        street2.setNo("002");
        ArrayList<Street> streets = new ArrayList<Street>();
        streets.add(street1);
        streets.add(street2);
        address.setStreets(streets);
        request.setAddress(address);

        ropClient.setMessageFormat(MessageFormat.xml);
        CompositeResponse response = ropClient.buildClientRequest()
                .post(request, CreateUserResponse.class, "user.add", "1.0");
        assertNotNull(response);
        assertTrue(response.isSuccessful());
        assertTrue(response.getSuccessResponse() instanceof CreateUserResponse);
    }

    @Test
    public void testServiceJsonRequestAttr() throws Throwable {
        ropClient.setMessageFormat(MessageFormat.json);
        CreateUserRequest request = new CreateUserRequest();
        request.setUserName("tomson");
        request.setSalary(2500L);
        Address address = new Address();
        address.setZoneCode("0001");
        address.setDoorCode("002");
        Street street1 = new Street();
        street1.setName("street1");
        street1.setNo("001");
        Street street2 = new Street();
        street2.setName("street2");
        street2.setNo("002");
        ArrayList<Street> streets = new ArrayList<Street>();
        streets.add(street1);
        streets.add(street2);
        address.setStreets(streets);
        request.setAddress(address);

        CompositeResponse response = ropClient.buildClientRequest()
                .post(request, CreateUserResponse.class, "user.add", "1.0");
        assertNotNull(response);
        assertTrue(response.isSuccessful());
        assertTrue(response.getSuccessResponse() instanceof CreateUserResponse);
    }

    @Test
    public void testUserList() throws Throwable {
        ropClient.setMessageFormat(MessageFormat.json);
        CompositeResponse response = ropClient.buildClientRequest().get(UserListResponse.class,"user.list", "1.0");
        assertNotNull(response);
        assertTrue(response.isSuccessful());
        assertTrue(response.getSuccessResponse() instanceof UserListResponse);
    }


    @Test
    public void testCustomConverter() {
        ropClient.addRopConvertor(new TelephoneConverter());
        CreateUserRequest request = new CreateUserRequest();
        request.setUserName("tomson");
        request.setSalary(2500L);
        Telephone telephone = new Telephone();
        telephone.setZoneCode("0592");
        telephone.setTelephoneCode("12345678");

        CompositeResponse response = ropClient.buildClientRequest().post(request, CreateUserResponse.class, "user.add", "1.0");

        assertNotNull(response);
        assertTrue(response.isSuccessful());
        assertTrue(response.getSuccessResponse() instanceof CreateUserResponse);
    }
}

