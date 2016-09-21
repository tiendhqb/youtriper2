<%-- 
    Document   : wizard
    Created on : Oct 6, 2015, 6:35:40 PM
    Author     : Nick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=1366">
        <title>Smart Wizard 3 - Multiple Wizard Example - a javascript jQuery wizard control plugin</title>
        <link href="<c:url value="/Resources/Theme/css/smart_wizard.css"/>" rel="stylesheet" type="text/css">
        
        <script src="<c:url value="/Resources/Theme/js/jquery-1.11.1.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/Resources/Theme/js/jquery.smartWizard.js"/>"></script>

        <script type="text/javascript">
            $(document).ready(function () {
                //  Wizard 1  	
                $('#wizard1').smartWizard({
                    transitionEffect: 'fade',
                    onFinish: onFinishCallback,
                    onLeaveStep: leaveAStepCallback,
                });
                function leaveAStepCallback(obj, context) {
                    // To check and enable finish button if needed
                    if (context.fromStep >= 2) {
                        $('#wizard1').smartWizard('enableFinish', true);
                    }
                    return true;
                }
                //  Wizard 2
                $('#wizard2').smartWizard({transitionEffect: 'slide', onFinish: onFinishCallback});
                function onFinishCallback() {
                    alert('Finish Called');
                }
            });
        </script>
    </head>
    <body>
        <table align="center" border="0" cellpadding="0" cellspacing="0">
            <tr><td>
                    <h2>Example: Multiple Wizards</h2>
                    <!-- Smart Wizard wizard1-->
                    <h3>Wizard 1</h3> 
                    <div id="wizard1" class="swMain">
                        <ul>
                            <li><a href="#step-1">
                                    <!--<label class="stepNumber">1</label>-->
                                    <span class="stepDesc">
                                        Step 1<br />
                                        <small>Step 1 description</small>
                                    </span>
                                </a></li>
                            <li><a href="#step-2">
                                    <!--<label class="stepNumber">2</label>-->
                                    <span class="stepDesc">
                                        Step 2<br />
                                        <small>Enable Finish Button</small>
                                    </span>
                                </a></li>
                            <li><a href="#step-3">
                                    <!--<label class="stepNumber">3</label>-->
                                    <span class="stepDesc">
                                        Step 3<br />
                                        <small>Step 3 description</small>
                                    </span>                   
                                </a></li>
                            <li><a href="#step-4">
                                    <!--<label class="stepNumber">4</label>-->
                                    <span class="stepDesc">
                                        Step 4<br />
                                        <small>Step 4 description</small>
                                    </span>                   
                                </a></li>
                        </ul>
                        <div id="step-1">	
                            <!--<h2 class="StepTitle">Step 1 Content</h2>-->
                            <ul type="disk">
                                <li>List 1</li>
                                <li>List 2</li>
                            </ul>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, 
                                sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, 
                                quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. 
                                Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                                Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                            </p>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, 
                                sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, 
                                quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. 
                                Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                                Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                            </p>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, 
                                sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, 
                                quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. 
                                Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                                Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                            </p>          			
                        </div>
                        <div id="step-2">
                            <h2 class="StepTitle">Step 2 Content</h2>	
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, 
                                sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, 
                                quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. 
                                Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                                Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                            </p>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, 
                                sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, 
                                quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. 
                                Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                                Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                            </p>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, 
                                sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, 
                                quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. 
                                Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                                Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                            </p> 
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, 
                                sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, 
                                quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. 
                                Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                                Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                            </p>          
                        </div>                      
                        <div id="step-3">
                            <!--<h2 class="StepTitle">Step 3 Content</h2>-->	
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, 
                                sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, 
                                quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. 
                                Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                                Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                            </p>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, 
                                sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, 
                                quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. 
                                Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                                Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                            </p>               				          
                        </div>
                        <div id="step-4">
                            <!--<h2 class="StepTitle">Step 4 Content</h2>-->	
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, 
                                sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, 
                                quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. 
                                Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                                Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                            </p>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, 
                                sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, 
                                quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. 
                                Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                                Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                            </p>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, 
                                sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, 
                                quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. 
                                Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                                Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                            </p>                			
                        </div>
                    </div>
                    <!-- End SmartWizard Content 1 -->
                    <br /> 
                

                </td></tr>
        </table>  
    </body>
</html>
