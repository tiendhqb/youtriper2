<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

        <div ng-app="YouTripper" ng-controller="SaleManagementController" class="pagesearch">
            <div role="tabpanel" class="tab-pane active" id="step7">                                
                                <div id="totalValue" class="row">
                                    <div class="col-xs-12">
                                        <div style="margin-top: 0px; padding-left: 90px; background-color: rgb(87, 87, 85); color: white; height: 30px; font-size: 15px; padding-top: 2px;">TOTAL</div>
                                    </div>

                                    <!--                            <div style="float: left; width: 200px; text-align: center;">
                                                                    <label id="totalRevenue" ng-model="totalRevenue" name="totalRevenue" ></label>
                                                                </div>-->
                                </div>
                                <div class="row">
                                    <div id="leftSelection" class="col-xs-12"> 
                                        <div style="    background-color: #F5F5F5;    padding-top: 20px; padding-bottom: 20px;">
                                            <div class="row">
                                                <div class="col-xs-2 total-article col-xs-5-5"> 
                                                    <div class="total-articleHeader">
                                                        <div class="tempCheckbox">
                                                            <input id="defaultRadio" type="radio" name="viewBy" 
                                                                   ng-model="totalType" value="complete">
                                                            <span></span>
                                                        </div>
                                                        <p>Payment Complete</p>
                                                    </div>
                                                    <label id="totalRevenue" ng-model="totalRevenue" name="totalRevenue" ></label>
                                                </div>
                                                <div class="col-xs-2 total-article col-xs-5-5">
                                                    <div class="total-articleHeader">
                                                        <div class="tempCheckbox">
                                                            <input type="radio" name="viewBy" ng-model="totalType" value="review">
                                                            <span></span>
                                                        </div>
                                                        <p>Pending Review</p>
                                                    </div>
                                                    <label id="totalReview" ng-model="totalReview" name="totalReview" ></label>
                                                </div>
                                                <div class="col-xs-2 total-article col-xs-5-5">
                                                    <div class="total-articleHeader">
                                                        <div class="tempCheckbox">
                                                            <input type="radio" name="viewBy" ng-model="totalType" value="revoked">
                                                            <span></span>
                                                        </div>
                                                        <p>Payment Revoked</p>
                                                    </div>
                                                    <label id="totalRevoked" ng-model="totalRevoked" name="totalRevoked" ></label>
                                                </div>
                                                <div class="col-xs-2 total-article col-xs-5-5">
                                                    <div class="total-articleHeader">
                                                        <div class="tempCheckbox">
                                                            <input type="radio" name="viewBy" ng-model="totalType" value="booked">
                                                            <span></span>
                                                        </div>
                                                        <p>Payment Booked</p>
                                                    </div>
                                                    <label id="totalBooked" ng-model="totalBooked" name="totalBooked" ></label>
                                                </div>
                                                <div class="col-xs-3 total-article col-xs-5-5"> 
                                                    <div class="total-articleHeader">
                                                        <div class="tempCheckbox">
                                                            <input id="defaultRadio" type="radio" name="viewBy" 
                                                                   ng-model="totalType" value="total">
                                                            <span></span>
                                                        </div>
                                                        <p>Payment Total</p>
                                                    </div>
                                                    <label id="mainTotal" ng-model="mainTotal" name="totalRevenue" ></label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <table class="table" border="0"  id="saleHeader">
                                    <thead>
                                        <tr>
                                            <th id="bookingHeader">BOOKING</th>
                                            <th id="statusHeader">STATUS</th>
                                            <th id="revenueHeader">REVENUE</th>
                                        </tr>
                                    </thead>
                                </table>
                                <div id="Saletable" class="tabble">
                                    <div ng-show="loadingSale" class="loadingSale"></div>
                                    <div ng-hide="loadingSale" class="table-responsive">
                                        <table class="table" border="0">
                                            <!--{{currentPage}}-->
                                            <tr data-ng-repeat="x in sales| filter:{status: filterCondition}">
                                                <td class="bookingCell col-xs-4" style="text-align: left;">
                                                    <img class="col-lg-6" ng-src="{{getThumbnail(x.packageID)}}">
                                                    <div class="col-lg-6" style="width: 60%;"><p style="font-weight: bold"> {{ x.packageName}}</p>Tripper Name: {{ x.tripperName}} </div>                                         
                                                </td>
                                                <td class=" revenueColor col-xs-4" ng-show="{{x.status == 1}}">Payment Complete</td>
                                                <td class=" revenueColor col-xs-4" ng-show="{{x.status == 2}}">Pending Review</td>
                                                <td class=" revenueColor col-xs-4" ng-show="{{x.status == 3}}">Payment Revoked</td>
                                                <td class=" revenueColor col-xs-4" ng-show="{{x.status == 4}}">Payment Booked</td>
                                                <td class=" StaReCell col-xs-4">{{ x.revenue | number : 3 }}</td>
                                            </tr>                                        
                                        </table>
                                    </div>
                                </div>

                            </div>
        </div>
  