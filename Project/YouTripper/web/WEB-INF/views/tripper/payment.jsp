<%-- 
    Document   : home
    Created on : Oct 21, 2015, 10:15:53 AM
    Author     : Nick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=1366">
        <!--        <meta name="viewport" content="width=device-width, initial-scale=1">-->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="">
        <link rel="icon" href="<c:url value="/Images/Icon/favicon.png"/>" >

        <!-- Bootstrap -->
        <link href="<c:url value="/Resources/Theme/css/bootstrap-theme.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/bootstrap.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/pepper-ginder-custom.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/lightgallery.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/lg-transitions.css"/>" rel="stylesheet">
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css?999999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css?999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style-login.css"/>" >
        <%@ include file="../angular.jsp" %>
        <script src="<c:url value="/Resources/Theme/js/angular.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/angular-recaptcha.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/checklist-model.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/ng-file-upload-shim.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/ng-file-upload.min.js"/>"></script>

        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>

        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>
        <!--<script src="<c:url value="/Resources/Theme/js/jquery-ui.multidatespicker.js"/>"></script>-->
        <script src="<c:url value="/Resources/Theme/js/lightgallery.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/lg-thumbnail.js"/>"></script>
        <title>Payment Page</title>
    </head>
    <body>
        <div ng-app="YouTripper" ng-controller="PaymentController">
            <%@ include file="../header.jsp" %>            
            <div class="container section-content padding-header">
                <!--Selector-->
                <div class="payment">
                    <div class="row">
                        <div class="col-lg-8 col-md-8 col-sm-12">
                            <div class="payment-left">
                                <form action="
                                      <c:choose>
                                          <c:when test="${empty param.language }">
                                              <c:url value="/Tripper/Payment"/>
                                          </c:when>
                                          <c:otherwise>
                                              <c:url value="/Tripper/Payment?language=${param.language}"/>
                                          </c:otherwise>
                                      </c:choose>" 
                                      method="POST">
                                    <h3>Payment</h3>
                                    <h5 style="color: red">${requestScope.message}</h5>
                                    <div class="rr">
                                        <div class="rr-col">
                                            <p>Country</p>
                                            <select class="paymentSelect"><option>Thai Lan</option></select>
                                            <p class="rr-note">
                                                Lorem ipsum dolor sit, consectetur 10% adipiscing elit
                                            </p>

                                        </div>
                                        <div class="rr-col">


                                        </div>
                                        <div class="clear"></div>
                                    </div>

                                    <div class="rr">
                                        <div class="rr-col">
                                            <p>Payment type</p>
                                            <select class="paymentSelect" name="paymentMethod">
                                                <option  ng-click="showCreditCard()" value="creditCard">Credit Card</option>
                                                <option ng-click="hideCreditCard()" value="paypal">Paypal</option>
                                            </select>
                                        </div>
                                        <div class="rr-col">
                                            <p>&nbsp;</p>

                                            <img alt="" src="image/pay.png" />
                                        </div>
                                        <div class="clear"></div>
                                    </div>
                                    <div id="creditCard">
                                        <div class="rr">
                                            <div class="rr-col">
                                                <p>Card type</p>
                                                <select name="cardType" class="paymentSelect">
                                                    <option value="visa">Visa</option>
                                                    <option value="mastercard">MasterCard</option>
                                                    <option value="discover">Discover</option>
                                                    <option value="amex">American Express</option>
                                                </select>
                                            </div>
                                            <div class="rr-col">
                                                <p>Card number</p>
                                                <input type="text" name="cardNumber" value="000 000 000" />
                                            </div>
                                            <div class="clear"></div>
                                        </div>

                                        <div class="rr">
                                            <div class="rr-col">
                                                <p>Expires on</p>
                                                <input type="text" name="expireMonth" value="" class="feild40" placeholder="MM" />
                                                <input type="text" name="expireYear" value="" class="feild50" placeholder="YYYY" />
                                            </div>
                                            <div class="rr-col">
                                                <p>Security code</p>
                                                <input type="text" class="feild50" value="" name="cvv" placeholder="CVV" />
                                            </div>
                                            <div class="clear"></div>
                                        </div>
                                    </div>
                                    <h3>Billing Information</h3>
                                    <div class="rr">
                                        <div class="rr-col">
                                            <p>First name</p>
                                            <input name="firstName" type="text" value="" />
                                        </div>
                                        <div class="rr-col">
                                            <p>Last name</p>
                                            <input name="lastName" type="text" value="" />
                                        </div>
                                        <div class="clear"></div>
                                    </div>
                                    <div class="rr">
                                        <div class="rr-col">
                                            <p>Postal code</p>
                                            <input type="text" value="" class="feild50" />
                                            <em>Thai lan</em>
                                        </div>

                                        <div class="clear"></div>
                                    </div>

                                    <input style="display:none" type="text" name="packageID" value="${requestScope.packageDTO.id}" />
                                    <input style="display:none" type="text" name="numberOfAdults" value="${requestScope.numberOfAdults}" />
                                    <input style="display:none" type="text" name="numberOfChilds" value="${requestScope.numberOfChilds}" />
                                    <input style="display:none" type="text" name="selectedDate" value="${requestScope.selectedDate}" />

                                    <button class="btn-trip">Book this trip</button>
                                    <p class="rr-note1">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam eu urna dui.
                                        Nullam a egestas nibh aliquam elementum.</p>

                                </form>
                                <div class="clear"></div>
                            </div>

                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-12">
                            <div class="payment-right">
                                <div class="box-lime">
                                    <h3>${requestScope.packageDTO.name}</h3>
                                    <p>${requestScope.packageDTO.country} ${requestScope.packageDTO.city} ${requestScope.packageDTO.state}</p>
                                </div>
                                <div class="payment-right-info">
                                    <h6>Location:${requestScope.packageDTO.departureLocation} in ${requestScope.selectedDate}</h6>
                                    <div class="line"></div>
                                    <p>  CANCELLATION POLICY	STRICT</p>
                                    <p>   RULES	READ POLICY </p>
                                    {{isPrivate}}
                                    <p ng-show="isPrivate === 'true'">Price for 1 package (${requestScope.packageDTO.minTripper} peoples) is {{${requestScope.priceForAdult} * ((100 - ${requestScope.packageDTO.youtripperPercentage}) / 100) | currency}}</p>
                                    <p ng-show="isPrivate === 'true'">Price: {{${requestScope.priceForAdult} * ((100 - ${requestScope.packageDTO.youtripperPercentage}) / 100)}} x {{Math.round(Math.ceil((${param.numberOfAdults} + ${requestScope.numberOfChilds}) / ${requestScope.packageDTO.minTripper}))}} package  =<span>{{${requestScope.priceForAdult} * ((100 - ${requestScope.packageDTO.youtripperPercentage}) / 100) * Math.round(Math.ceil((${param.numberOfAdults} + ${requestScope.numberOfChilds}) / ${requestScope.packageDTO.minTripper})) | currency}}</span></p>
                                    <p ng-hide="isPrivate === 'true'">Adult: $${requestScope.priceForAdult * (100-requestScope.packageDTO.youtripperPercentage)/100} x ${requestScope.numberOfAdults} =<span> $${requestScope.priceForAdult * (100-requestScope.packageDTO.youtripperPercentage)/100 * requestScope.numberOfAdults}</span></p>
                                    <p ng-hide="isPrivate === 'true'">Child: $${requestScope.priceForChild * (100-requestScope.packageDTO.youtripperPercentage)/100} x ${requestScope.numberOfChilds}= 	 <span> $${requestScope.priceForChild * (100-requestScope.packageDTO.youtripperPercentage)/100 * requestScope.numberOfChilds}</span></p>
                                    <p>  SERVICE FEE<span> </span></p>
                                    <p>   COUPON CODE	<span></span></p>
                                    <h5 class="total">
                                        TOTAL 
                                        <span id="showitotal" ng-show="isPrivate === 'true'"> 
                                            {{ Math.round(Math.ceil((${param.numberOfAdults} + ${requestScope.numberOfChilds}) / ${requestScope.packageDTO.minTripper}) * ${requestScope.priceForAdult} * ((100 - ${requestScope.packageDTO.youtripperPercentage}) / 100)) | currency}}
                                        </span>  
                                        <span ng-hide="isPrivate === 'true'"> 
                                            $${(requestScope.priceForAdult * param.numberOfAdults + requestScope.priceForChild * requestScope.numberOfChilds)* (100-requestScope.packageDTO.youtripperPercentage)/100}
                                        </span>  
                                    </h5>
                                    <h6>You are paying in Dollar. Your total charge is $${requestScope.priceForAdult * requestScope.numberOfAdults + requestScope.priceForChild * requestScope.numberOfChilds}.
                                        The exchange rate for booking this listing is $1 to
                                        $30.93 (your host's listing currency).</h6>
                                    <div class="avatar1">
                                        <img alt="" src="images/avatar1.png" />
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

            </div>               

        </div>
        <%@ include file="../footer.jsp" %>
        <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.plugin.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/wow.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/main.js"/>"></script>
        <script>
                                                    var isPrivate = '${requestScope.packageDTO.isPrivateTour}';
                                                    var package = '${requestScope.packageDTO}';
                                                    $(document).ready(function () {
                                            toggleHeader.init({
                                            toggleControl: false
                                            });
                                            });
        </script>
        <script src="<c:url value="/Resources/Theme/js/youtripper.js?9999999999999999999999999999999999999999999999999999999999"/>"></script>
        <script type='text/javascript' src="https://maps.googleapis.com/maps/api/js?&sensor=false&extension=.js"></script>
    </body>
</html>
