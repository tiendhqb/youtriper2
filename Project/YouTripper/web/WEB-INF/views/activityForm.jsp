<%-- 
    Document   : activityForm
    Created on : Oct 5, 2015, 6:29:19 PM
    Author     : Nick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=1366">
<!--        <meta name="viewport" content="width=device-width, initial-scale=1">-->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>YouTripper - Create Package</title>

        <!-- Bootstrap -->
        <link href="<c:url value="/Resources/Theme/css/bootstrap-theme.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/bootstrap.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/jquery.tag-editor.css"/>" rel="stylesheet">


        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/angular.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/checklist-model.js"/>"></script>

        <script src="<c:url value="/Resources/Theme/js/jquery-1.11.1.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>

        <script>
            angular.module('package', ["checklist-model"]).controller('PackageController', function ($scope) {
                $scope.activityForm = ${requestScope.activityForm};
            });
        </script>
    </head>
    <body>
        <div ng-app="package" >
            <ul>
                <li>
                    <strong>Category</strong>
                </li>
                <li>
                    Description
                </li>
                <li>
                    Amenities
                </li>
                <li>
                    Photos
                </li>
                <li>
                    Location
                </li>
                <li>
                    Price
                </li>
            </ul>
            <form name="packageForm"  ng-controller="PackageController" novalidate >
                <strong>Category</strong> <br/>
                <ul ng-repeat="category in activityForm.categories">
                    <li>
                        {{category.name}}, {{category.id}}
                        <input type="checkbox" checklist-model="categoriesModel.ids" checklist-value="category.id" ng-change="change(category.id)">
                    </li>
                </ul>
                <br/>
                <strong>Sub Category</strong> <br/>
                <ul ng-repeat="subCategory in activityForm.subCategories | filter:showSubCategories">
                    <li>
                        {{subCategory.name}}, {{subCategory.subCategoryID}}
                        <input type="checkbox" checklist-model="subCategoriesModel.ids" checklist-value="subCategory" ng-model="justAnotherCheckedVar"
                               ng-attr-ofCat="{{subCategory.categoryID}}">
                    </li>
                </ul>
                Result: {{subCategoriesModel.ids}}
                <br/>
                <strong>Activities</strong> <br/> <p style="color:red" ng-show="missing.activityMsg">Please select at least an activity</p>
                <ul ng-repeat="activitiy in activityForm.activities| filter:showActivities">
                    <li>
                        {{activitiy.name}}
                        <input type="checkbox" checklist-model="activitiesModel.ids" checklist-value="activitiy.activityID">
                    </li>
                </ul>
                <br/>
                Result: {{activitiesModel.ids}}
                <br/>
                <button ng-click="checkActivity()">Next</button>
                <br/>
            </form>
        </div>
    </body>
</html>
