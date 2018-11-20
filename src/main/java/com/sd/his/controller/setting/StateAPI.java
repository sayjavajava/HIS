package com.sd.his.controller.setting;

import com.sd.his.enums.ResponseEnum;
import com.sd.his.model.*;
import com.sd.his.service.*;
import com.sd.his.utill.HISCoreUtil;
import com.sd.his.wrapper.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.ResourceBundle;

import com.sd.his.enums.ResponseEnum;
import com.sd.his.model.Country;
import com.sd.his.service.CountryService;
import com.sd.his.utill.HISCoreUtil;
import com.sd.his.wrapper.GenericAPIResponse;
import com.sd.his.wrapper.PatientWrapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.ResourceBundle;

import com.sd.his.enums.ResponseEnum;

import com.sd.his.model.PaymentType;
import com.sd.his.service.PaymentTypeService;
import com.sd.his.utill.HISCoreUtil;
import com.sd.his.wrapper.GenericAPIResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.ResourceBundle;

@RestController
@RequestMapping(value = "/StateAPI")
public class StateAPI {

    private final Logger logger = LoggerFactory.getLogger(StateAPI.class);
    private ResourceBundle messageBundle = ResourceBundle.getBundle("messages");



    @Autowired
    private StateService stateService;


    @ApiOperation(httpMethod = "GET", value = "All States",
            notes = "This method will returns all States ",
            produces = "application/json", nickname = "States",
            response = GenericAPIResponse.class, protocols = "https")
    @ApiResponses({
            @ApiResponse(code = 200, message = "All States  fetched successfully.", response = GenericAPIResponse.class),
            @ApiResponse(code = 401, message = "Oops, your fault. You are not authorized to access.", response = GenericAPIResponse.class),
            @ApiResponse(code = 403, message = "Oops, your fault. You are forbidden.", response = GenericAPIResponse.class),
            @ApiResponse(code = 404, message = "Oops, my fault System did not find your desire resource.", response = GenericAPIResponse.class),
            @ApiResponse(code = 500, message = "Oops, my fault. Something went wrong on the server side.", response = GenericAPIResponse.class)})
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllStates(HttpServletRequest request) {

        logger.error("get All States  API initiated");
        GenericAPIResponse response = new GenericAPIResponse();
        response.setResponseMessage(messageBundle.getString("state.fetch.error"));
        response.setResponseCode(ResponseEnum.COUNTRY_FETCHED_ERROR.getValue());
        response.setResponseStatus(ResponseEnum.ERROR.getValue());
        response.setResponseData(null);

        try {
            logger.error("ALL States  API - States  fetching from DB");
            List<StateWrapper> stateLst = stateService.getAllStates();

            if (HISCoreUtil.isListEmpty(stateLst)) {
                response.setResponseMessage(messageBundle.getString("state.not.found"));
                response.setResponseCode(ResponseEnum.STATE_NOT_FOUND_ERROR.getValue());
                response.setResponseStatus(ResponseEnum.ERROR.getValue());
                response.setResponseData(null);
                logger.error("State   - State  not found");

                return new ResponseEntity<>(response, HttpStatus.OK);
            }

            response.setResponseMessage(messageBundle.getString("state.fetched.success"));
            response.setResponseCode(ResponseEnum.STATE_FETCHED_SUCCESS.getValue());
            response.setResponseStatus(ResponseEnum.SUCCESS.getValue());
            response.setResponseData(stateLst);

            logger.error("State API - State successfully fetched.");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("State   API -  exception..", ex.fillInStackTrace());
            response.setResponseStatus(ResponseEnum.ERROR.getValue());
            response.setResponseCode(ResponseEnum.EXCEPTION.getValue());
            response.setResponseMessage(messageBundle.getString("exception.occurs"));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @ApiOperation(httpMethod = "GET", value = "States",
            notes = "This method will return States",
            produces = "application/json", nickname = "Get Single User",
            response = GenericAPIResponse.class, protocols = "https")
    @ApiResponses({
            @ApiResponse(code = 200, message = "States", response = GenericAPIResponse.class),
            @ApiResponse(code = 401, message = "Oops, your fault. You are not authorized to access.", response = GenericAPIResponse.class),
            @ApiResponse(code = 403, message = "Oops, your fault. You are forbidden.", response = GenericAPIResponse.class),
            @ApiResponse(code = 404, message = "Oops, my fault System did not find your desire resource.", response = GenericAPIResponse.class),
            @ApiResponse(code = 500, message = "Oops, my fault. Something went wrong on the server side.", response = GenericAPIResponse.class)})
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getStatesByCountryIdAPI(HttpServletRequest request, @PathVariable("id") long id) {

        GenericAPIResponse response = new GenericAPIResponse();
        response.setResponseMessage(messageBundle.getString("state.not.found"));
        response.setResponseCode(ResponseEnum.STATE_NOT_FOUND_ERROR.getValue());
        response.setResponseStatus(ResponseEnum.ERROR.getValue());
        response.setResponseData(null);

        try {
            List<StateWrapper> statesLst = this.stateService.getAllStatesByCountryId(id);
            if (HISCoreUtil.isValidObject(statesLst)) {
                response.setResponseData(statesLst);
                response.setResponseMessage(messageBundle.getString("state.found"));
                response.setResponseCode(ResponseEnum.STATE_FETCHED_SUCCESS.getValue());
                response.setResponseStatus(ResponseEnum.SUCCESS.getValue());
                logger.info("User Found successfully...");

                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setResponseData(null);
                response.setResponseMessage(messageBundle.getString("state.search.not.found"));
                response.setResponseCode(ResponseEnum.STATE_FETCHED_SUCCESS.getValue());
                response.setResponseStatus(ResponseEnum.ERROR.getValue());
                logger.info("User Not Found ...");
            }
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("User Not Found", ex.fillInStackTrace());
            response.setResponseData("");
            response.setResponseStatus(ResponseEnum.ERROR.getValue());
            response.setResponseCode(ResponseEnum.EXCEPTION.getValue());
            response.setResponseMessage(messageBundle.getString("exception.occurs"));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }






}
