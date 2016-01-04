package com.tracebucket.x1.saleschannel.test.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tracebucket.x.saleschannel.query.model.SalesChannels;
import org.dozer.Mapper;
import com.tracebucket.x.saleschannel.domain.model.SalesChannel;
import com.tracebucket.x.saleschannel.domain.model.SalesChannelType;
import com.tracebucket.x.saleschannel.query.model.AddressEntry;
import com.tracebucket.x.saleschannel.query.model.SalesChannelEntry;
import com.tracebucket.x.saleschannel.rest.SalesChannelApplicationStarter;
import com.tracebucket.x.saleschannel.rest.resource.CreateSalesChannelRequest;
import com.tracebucket.x.saleschannel.rest.resource.SalesChannelAddressRequest;
import com.tracebucket.x.saleschannel.rest.resource.SalesChannelContactRequest;
import com.tracebucket.x1.saleschannel.test.fixture.SalesChannelResourceFixture;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.security.Principal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by Madhavi on 09-09-2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SalesChannelApplicationStarter.class)
@WebIntegrationTest
public class SalesChannelControllerTest {

    private static final Logger log = LoggerFactory.getLogger(SalesChannelControllerTest.class);

    private RestTemplate restTemplate = null;

    @Value("http://localhost:${server.port}${server.contextPath}")
    private String basePath;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private Mapper mapper;

    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
    }

    private void createOrganization() throws Exception{


    }

    @Test
     public void testCreate() throws Exception {
        CreateSalesChannelRequest salesChannel = SalesChannelResourceFixture.standardSalesChannel();
        log.info("Create Sales Channel NEW NEW NEW : " + objectMapper.writeValueAsString(salesChannel) );
        restTemplate.postForObject(basePath+"/saleschannel", salesChannel,CreateSalesChannelRequest.class);
    }

    @Test
    public void testFindByName() throws Exception {
        SalesChannelEntry salesChannelEntry ;
        log.info("RETRIEVING SALES CHANNLE BY NAME ##################"  );
        ResponseEntity<SalesChannelEntry> responseEntity = restTemplate.getForEntity(new URI(basePath + "/saleschannel/"+"Catalogue5"),SalesChannelEntry.class);
        Assert.assertNotNull(responseEntity);
        Assert.assertNotNull( salesChannelEntry = responseEntity.getBody());
        Assert.assertNotNull(salesChannelEntry.getId());
        log.info("Found : " + objectMapper.writeValueAsString(salesChannelEntry));
    }

    @Test
    public void testFindAll() throws Exception {
        log.info("RETRIEVING SALES CHANNELS##################"  );
        String salesChannel = restTemplate.getForObject(new URI(basePath + "/saleschannels"), String.class);
        System.out.println("SALES CHANNELS: "+salesChannel);

        List<SalesChannelEntry> salesChannels = restTemplate.getForObject(new URI(basePath + "/saleschannels"), SalesChannels.class).getSalesChannels();
        salesChannels.forEach(s-> {SalesChannelEntry salesChannelEntry = new SalesChannelEntry();
            mapper.map(s, salesChannelEntry);
           // allSalesChannels.add(index,salesChannelEntry);
            try {
                log.info("SalesChannel : " + objectMapper.writeValueAsString(salesChannelEntry));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void testDelete() throws Exception {
        String salesChannelId = "28db2a2b-63bc-426f-a6e5-78e982682ecb";
        log.info("Delete Sales Channel with Id: " + salesChannelId);
        restTemplate.delete(new URI(basePath + "/saleschannel/"+ salesChannelId));
    }

    //@Test
    public void testUpdate() throws Exception {
        SalesChannelEntry salesChannelEntry ;
        log.info("RETRIEVING SALES CHANNLE BY NAME ##################"  );
        ResponseEntity<SalesChannelEntry> responseEntity = restTemplate.getForEntity(new URI(basePath + "/saleschannel/"+"Catalogue5"),SalesChannelEntry.class);
        Assert.assertNotNull(responseEntity);
        Assert.assertNotNull( salesChannelEntry = responseEntity.getBody());
        Assert.assertNotNull(salesChannelEntry.getId());
        log.info("Found : " + objectMapper.writeValueAsString(salesChannelEntry));

        salesChannelEntry.setDescription("CATLOGUE NUMBER FIVE  ");
      //  salesChannelEntry.setChannelType(SalesChannelType.MOBILE);
        CreateSalesChannelRequest salesChannel = new CreateSalesChannelRequest();
        salesChannel.setId(salesChannelEntry.getId());
        salesChannel.setName(salesChannelEntry.getName());
        salesChannel.setCode(salesChannelEntry.getCode());
        salesChannel.setDescription(salesChannelEntry.getDescription());
        salesChannel.setChannelType(salesChannelEntry.getChannelType());

        log.info("MODIFYING  Sales Channel : " + objectMapper.writeValueAsString(salesChannel.getName()) );
        restTemplate.postForObject(basePath+"/saleschannel/update", salesChannel,CreateSalesChannelRequest.class);

    }

    @Test
    public void testAddAddress() throws Exception {
        SalesChannelEntry salesChannelEntry ;
        ResponseEntity<SalesChannelEntry> responseEntity = restTemplate.getForEntity(new URI(basePath + "/saleschannel/"+"Catalogue5"),SalesChannelEntry.class);
        Assert.assertNotNull(responseEntity);
        Assert.assertNotNull( salesChannelEntry = responseEntity.getBody());
        Assert.assertNotNull(salesChannelEntry.getId());
        log.info("Found : " + objectMapper.writeValueAsString(salesChannelEntry));

        //salesChannelEntry.setDescription("THE NEW FIRST CATALOGUE");
        SalesChannelAddressRequest addressEntry = new SalesChannelAddressRequest();
        addressEntry.setLine1("LINE1 NEW ADDRESS 1 for 5");
        addressEntry.setLine2("LINE2 NEw ADDRESS 1 for 5");
        addressEntry.setCity("NEw ADDRESS CITY5 for 5");
        addressEntry.setState("New ADDRESS STATE5 for 5");
        addressEntry.setCountry("ADDRESS COUNTRY5for 5");
        addressEntry.setPincode("5555-44-5");
        addressEntry.setWebsite("abc-xyz5.com");
        addressEntry.setSalesChannelId(salesChannelEntry.getId());

        log.info("Adding address to Sales Channel : " + objectMapper.writeValueAsString(addressEntry.toString()) );
        restTemplate.postForObject(basePath+"/saleschannel/address", addressEntry,SalesChannelAddressRequest.class);

    }

    //@Test
    public void testFindAllAddressesForSalesChannel() throws Exception {
        SalesChannelEntry salesChannelEntry ;
        ResponseEntity<SalesChannelEntry> responseEntity = restTemplate.getForEntity(new URI(basePath + "/saleschannel/"+"Catalogue5"),SalesChannelEntry.class);
        Assert.assertNotNull(responseEntity);
        Assert.assertNotNull( salesChannelEntry = responseEntity.getBody());
        Assert.assertNotNull(salesChannelEntry.getId());
        log.info("Found : " + objectMapper.writeValueAsString(salesChannelEntry));
        int counter = 1;
        for(AddressEntry addressEntries : salesChannelEntry.getAddressEntry())
        {
            log.info("Address : " +addressEntries);
        }
    }


    @Test
    public void testAddContact() throws Exception {
        SalesChannelEntry salesChannelEntry ;
        ResponseEntity<SalesChannelEntry> responseEntity = restTemplate.getForEntity(new URI(basePath + "/saleschannel/"+"Catalogue5"),SalesChannelEntry.class);
        Assert.assertNotNull(responseEntity);
        Assert.assertNotNull( salesChannelEntry = responseEntity.getBody());
        Assert.assertNotNull(salesChannelEntry.getId());
        log.info("Found : " + objectMapper.writeValueAsString(salesChannelEntry));

        //salesChannelEntry.setDescription("THE NEW FIRST CATALOGUE");
        SalesChannelContactRequest contactRequest = new SalesChannelContactRequest();
        contactRequest.setName("TESTC1");
        contactRequest.setPhone("1243-122");
        contactRequest.setEmail("abcij@xyx.com");
        contactRequest.setMobile("34-78-123");
        contactRequest.setFax("11-123-1212");
        contactRequest.setWorkTimeFrom(Date.from(Instant.now()));
        contactRequest.setWorkTimeTo(Date.from(Instant.now().plusSeconds(300L)));
        contactRequest.setSalesChannelId(salesChannelEntry.getId());


        log.info("Adding contact to Sales Channel : " + objectMapper.writeValueAsString(contactRequest.toString()) );
        restTemplate.postForObject(basePath+"/saleschannel/contact", contactRequest,SalesChannelAddressRequest.class);

    }


    @After
    public void tearDown() throws Exception{
       /* if(organization != null && organization.getUid() != null) {
            ResponseEntity<Boolean> responseEntity = restTemplate.exchange(basePath + "/organization/" + organization.getUid(), HttpMethod.DELETE, AccessTokenRequestBuilder.build(accessToken), Boolean.class);
            Assert.assertNotNull(responseEntity);
            Assert.assertFalse(responseEntity.getBody());
            try {
                restTemplate.exchange(basePath + "/organization/" + organization.getUid(), HttpMethod.GET, AccessTokenRequestBuilder.build(accessToken), DefaultOrganizationResource.class);
            } catch (HttpClientErrorException httpClientErrorException) {
                Assert.assertEquals(HttpStatus.NOT_FOUND, httpClientErrorException.getStatusCode());
            }
        }*/
    }
}
