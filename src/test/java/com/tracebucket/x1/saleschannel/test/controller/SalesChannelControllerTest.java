package com.tracebucket.x1.saleschannel.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tracebucket.x.saleschannel.domain.model.SalesChannel;
import com.tracebucket.x.saleschannel.domain.model.SalesChannelType;
import com.tracebucket.x.saleschannel.query.model.AddressEntry;
import com.tracebucket.x.saleschannel.query.model.SalesChannelEntry;
import com.tracebucket.x.saleschannel.rest.SalesChannelApplicationStarter;
import com.tracebucket.x.saleschannel.rest.resource.CreateSalesChannelRequest;
import com.tracebucket.x.saleschannel.rest.resource.SalesChannelAddressRequest;
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
import java.util.List;


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

    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
    }

    private void createOrganization() throws Exception{


    }

    @Test
     public void testCreate() throws Exception {
        CreateSalesChannelRequest salesChannel = SalesChannelResourceFixture.standardSalesChannel5();
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

   // @Test
    public void testDelete() throws Exception {
        String salesChannelId = "09393d18-5ebd-4307-9b36-f85bdd4b8cae";
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

    //@Test
    public void testAddAddress() throws Exception {
        SalesChannelEntry salesChannelEntry ;
        ResponseEntity<SalesChannelEntry> responseEntity = restTemplate.getForEntity(new URI(basePath + "/saleschannel/"+"Catalogue5"),SalesChannelEntry.class);
        Assert.assertNotNull(responseEntity);
        Assert.assertNotNull( salesChannelEntry = responseEntity.getBody());
        Assert.assertNotNull(salesChannelEntry.getId());
        log.info("Found : " + objectMapper.writeValueAsString(salesChannelEntry));

        //salesChannelEntry.setDescription("THE NEW FIRST CATALOGUE");
        SalesChannelAddressRequest addressEntry = new SalesChannelAddressRequest();
        addressEntry.setLine1("LINE1 NEW ADDRESS 5");
        addressEntry.setLine2("LINE2 NEw ADDRESS 5");
        addressEntry.setCity("NEw ADDRESS CITY55");
        addressEntry.setState("New ADDRESS STATE55");
        addressEntry.setCountry("ADDRESS COUNTRY55");
        addressEntry.setPincode("5555-44");
        addressEntry.setWebsite("abc-xyz.com");
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
