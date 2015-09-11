package com.tracebucket.x1.saleschannel.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tracebucket.x.saleschannel.domain.model.SalesChannel;
import com.tracebucket.x.saleschannel.query.model.SalesChannelEntry;
import com.tracebucket.x.saleschannel.rest.SalesChannelApplicationStarter;
import com.tracebucket.x.saleschannel.rest.resource.CreateSalesChannelRequest;
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
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by sadath on 20-Apr-15.
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
        CreateSalesChannelRequest salesChannel = SalesChannelResourceFixture.standardSalesChannel();
        log.info("Create Sales Channel : " + objectMapper.writeValueAsString(salesChannel));
        salesChannel = restTemplate.postForObject(basePath+"/saleschannel", salesChannel, CreateSalesChannelRequest.class);
        Assert.assertNotNull(salesChannel);
        Assert.assertNotNull(salesChannel.getName());
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
