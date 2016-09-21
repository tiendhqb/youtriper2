/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global description */

var myApp = angular.module('YouTripper', ['ui.bootstrap', 'vcRecaptcha', "checklist-model", "ngFileUpload", "bw.paging", 'ngTagsInput', 'angular.filter', 'ngRoute', 'ngSanitize']).factory('service', function () {
    var d = new Date();
    var months = new Array();
    months[0] = "January";
    months[1] = "February";
    months[2] = "March";
    months[3] = "April";
    months[4] = "May";
    months[5] = "June";
    months[6] = "July";
    months[7] = "August";
    months[8] = "September";
    months[9] = "October";
    months[10] = "November";
    months[11] = "December";
    var month = months[d.getMonth()];
    var year = d.getFullYear();
    return {
        getCurrentMonth: function () {
            return month;
        },
        getCurrentYear: function () {
            return year;
        },
        getContextPath: function () {
//            return '/YouTripper';
            return '';
        }, getArrayToRepeatOptions: function (lineSize, totalOptions) {
            var array = new Array();
            var max = Math.ceil(totalOptions / lineSize);
            for (var i = 0; i < max; i++) {
                array.push(i);
            }
            return array;
        }, getErrorPageUrl: function () {
            return '/Common/Error';
        }, sizeOfHashMap: function (obj) {
            var size = 0, key;
            for (key in obj) {
                if (obj.hasOwnProperty(key))
                    size++;
            }
            return size;
        }
    };
}).directive('convertToNumber', function () {
    return {
        require: 'ngModel',
        link: function (scope, element, attrs, ngModel) {
            ngModel.$parsers.push(function (val) {
                return parseInt(val, 10);
            });
            ngModel.$formatters.push(function (val) {
                return '' + val;
            });
        }
    };
}).directive('initBoxer', function ($timeout) {
    return {
        link: function (scope, element, attr) {
            if (scope.$last === true) {
                $timeout(function () {
                    $(".boxer").boxer(
                            {
                                fixed: true
                            });
                });
            }
        }
    };
}).directive('focusSearch', function ($timeout) {
    return {
        link: function (scope, element, attr) {
            setTimeout(function () {
                $("#header-search-top").focus();
            }, 100);
        }
    };
}).directive('initThnumnailScroller', function ($timeout) {
    return {
        link: function (scope, element, attr) {
            $timeout(function () {
                $("#locations-1").length && $("#locations-1").mThumbnailScroller({theme: "hover-classic"});
            });
        }
    };
}).directive('checkOutSide', function ($timeout) {
    return {
        link: function (scope, element, attr) {
            $timeout(function () {
// for youtripper popup
//close modal

                $(document).on('click', '.ytPopup.active', function (event) {
                    if ($(event.target).is(".ytPopup.active .tbl-cell:not(.noClick)"))
                    {
                        $(".ytPopup.active").removeClass("active");
                    }
                });
                $(document).click(function (event) {

                    if (!$(event.target).closest('.package-option').length && !$(event.target).is('.package-option') && !$(event.target).is('.item-function')) {
                        if ($(".package-option.active").length > 0) {
                            $(".package-option.active").removeClass("active");
                        }
                    }
                    if (!$(event.target).closest('.overview-menu').length && !$(event.target).is('.overview-menu') && !$(event.target).is('.overview-icon a')) {
                        if ($(".overview-menu.active").length > 0) {
                            $(".overview-menu.active").removeClass("active");
                        }
                    }
                    if (!$(event.target).closest('.form-booking').length && !$(event.target).is('.form-booking') && !$(event.target).is('.bookButton')) {
                        if ($(".form-booking.active").length > 0) {
                            $(".form-booking.active").removeClass("active");
                        }
                    }
                    if (!$(event.target).closest('.clockpicker-popover').length && !$(event.target).is('.clockpicker-popover') && !$(event.target).is('.clockPicker') && !$(event.target).is('.clock-input')) {
                        if ($(".clockpicker-popover.active").length > 0) {
                            $(".clockpicker-popover.active").removeClass("active");
                        }
                    }

                    if (!$(event.target).closest('.packagesDdl .dpackageDdlSelect').length && !$(event.target).is('.packagesDdl .dpackageDdlSelect')
                            && !$(event.target).is('.packagesDdl .packageDdlMenu')) {
                        if ($(".packagesDdl .packageDdlMenu.active").length > 0) {
                            $(".packagesDdl .packageDdlMenu.active").removeClass("active");
                        }
                    }

                    if (!$(event.target).closest('.packagesDdl .dpcertificateDdlSelect').length && !$(event.target).is('.packagesDdl .dpcertificateDdlSelect')
                            && !$(event.target).is('.packagesDdl .CertificateMenu')) {
                        if ($(".packagesDdl .CertificateMenu.active").length > 0) {
                            $(".packagesDdl .CertificateMenu.active").removeClass("active");
                        }
                    }

                    if (!$(event.target).closest('.PackageColorSelect').length && !$(event.target).is('.PackageColorSelect')
                            && !$(event.target).is('.PackageColorMenu')) {
                        if ($(".PackageColorMenu.active").length > 0) {
                            $(".PackageColorMenu.active").removeClass("active");
                        }
                    }

                    if (!$(event.target).closest('#availableCalendar').length && !$(event.target).is('#availableCalendar')
                            && !$(event.target).is('input.calendarInput')) {
                        if ($("#availableCalendar.active").length > 0) {
                            $("#availableCalendar.active").removeClass("active");
                        }
                    }
                    if (!$(event.target).closest('#bookingCalendar').length && !$(event.target).is('#bookingCalendar')
                            && !$(event.target).is('input#bookingBtn')) {
                        if ($("#bookingCalendar.active").length > 0) {
                            $("#bookingCalendar.active").removeClass("active");
                        }
                    }

                    if (!$(event.target).closest('.businessTypeSelect').length && !$(event.target).is('.businessTypeSelect')
                            && !$(event.target).is('.businessTypeDdlMenu')) {
                        if ($(".businessTypeDdlMenu.active").length > 0) {
                            $(".businessTypeDdlMenu.active").removeClass("active");
                        }
                    }

                    if (!$(event.target).closest('.countrySelect').length && !$(event.target).is('.countrySelect')
                            && !$(event.target).is('.countryDdlMenu')) {
                        if ($(".countryDdlMenu.active").length > 0) {
                            $(".countryDdlMenu.active").removeClass("active");
                        }
                    }
                    if (!$(event.target).closest('.citySelect').length && !$(event.target).is('.citySelect')
                            && !$(event.target).is('.cityDdlMenu')) {
                        if ($(".cityDdlMenu.active").length > 0) {
                            $(".cityDdlMenu.active").removeClass("active");
                        }
                    }
                    if (!$(event.target).closest('.PackageColorSelect').length && !$(event.target).is('.PackageColorSelect')
                            && !$(event.target).is('.packgeDropdownMenu')) {
                        if ($(".packgeDropdownMenu.active").length > 0) {
                            $(".packgeDropdownMenu.active").removeClass("active");
                        }
                    }
                    if (!$(event.target).closest('#bookingSelect').length && !$(event.target).is('#bookingSelect')) {
                        if ($("#bookingDropdown.active").length > 0) {
                            $("#bookingDropdown.active").removeClass("active");
                        }
                    }
                    if (!$(event.target).closest('#resourceSelectType').length && !$(event.target).is('#resourceSelectType')) {
                        if ($("#resourceSelect.active").length > 0) {
                            $("#resourceSelect.active").removeClass("active");
                        }
                    }
                    if (!$(event.target).closest('#freeResourceSelectType').length && !$(event.target).is('#freeResourceSelectType')) {
                        if ($("#freeResourceSelect.active").length > 0) {
                            $("#freeResourceSelect.active").removeClass("active");
                        }
                    }
                    if (!$(event.target).closest('#todayBookingSelectType').length && !$(event.target).is('#todayBookingSelectType')) {
                        if ($("#todayBookingSelect.active").length > 0) {
                            $("#todayBookingSelect.active").removeClass("active");
                        }
                    }
                    if (!$(event.target).closest('#highestPackage').length && !$(event.target).is('#highestPackage')) {
                        if ($("#highestPackageSelect.active").length > 0) {
                            $("#highestPackageSelect.active").removeClass("active");
                        }
                    }
                    if (!$(event.target).closest('#highestPackageDate').length && !$(event.target).is('#highestPackageDate')) {
                        if ($("#highestPackageDateSelect.active").length > 0) {
                            $("#highestPackageDateSelect.active").removeClass("active");
                        }
                    }
                    if (!$(event.target).closest('#lowestPackage').length && !$(event.target).is('#lowestPackage')) {
                        if ($("#lowestPackageSelect.active").length > 0) {
                            $("#lowestPackageSelect.active").removeClass("active");
                        }
                    }
                    if (!$(event.target).closest('#lowestPackageDate').length && !$(event.target).is('#lowestPackageDate')) {
                        if ($("#lowestPackageDateSelect.active").length > 0) {
                            $("#lowestPackageDateSelect.active").removeClass("active");
                        }
                    }
                    if (!$(event.target).closest('#selectPackageType').length && !$(event.target).is('#selectPackageType')) {
                        if ($("#packageTypeSelect.active").length > 0) {
                            $("#packageTypeSelect.active").removeClass("active");
                        }
                    }
                    if (!$(event.target).closest('#selectStatisticType').length && !$(event.target).is('#selectStatisticType')) {
                        if ($("#statisticTypeSelect.active").length > 0) {
                            $("#statisticTypeSelect.active").removeClass("active");
                        }
                    }
                    if (!$(event.target).closest('#selectStatisticDate').length && !$(event.target).is('#selectStatisticDate')) {
                        if ($("#statisticDateSelect.active").length > 0) {
                            $("#statisticDateSelect.active").removeClass("active");
                        }
                    }
                });
            });
        }
    };
}).directive('balanceSquare', function ($timeout) {
    return {
        link: function (scope, element, attr) {
            if (scope.$last === true) {
                $timeout(function () {
                    var height = element[0].offsetWidth * 237 / 327;
                    $(".category-item-block .item-image").css("height", height + 'px');
                });
            }
        }
    };
}).directive('initScrollHeight', function ($timeout) {
    return {
        link: function (scope, element, attr) {
            if (scope.$last === true) {
                $timeout(function () {
                    var height = $("div.search-left").height() - 65;
//                alert(element[0].offsetHeight);
//                    var height = element[0].offsetWidth * 237 / 327;
                    $(".search-nav").css("height", height + 'px');
                    $(".fillter-content").css("height", height + 'px');
                });
            }
        }
    };
}).directive('initFilterHeight', function ($timeout) {
    return {
        link: function (scope, element, attr) {
            $timeout(function () {
                var height = $("div.search-left").height() - 65;
//                alert(element[0].offsetHeight);
//                    var height = element[0].offsetWidth * 237 / 327;
                $(".fillter-content").css("height", height + 'px');
            });
        }
    };
}).filter('ifEmpty', function () {
    return function (input, defaultValue) {
        if (angular.isUndefined(input) || input === null || input.replace(/\s+/g, '') === '') {
            return defaultValue;
        }
        return input;
    };
}).directive('detectHover', function () {
    return {
        link: function (scope, element, attrs, ctrl) {
            element.bind("mouseover", function (e) {
                !element.hasClass("active") ? element.addClass('active') : 0;
            });
            element.bind("mouseout", function (e) {
                element.hasClass("active") ? element.removeClass('active') : 0;
            });
        }
    };
}).directive('enableTimeClock', function ($timeout) {
    return {
        link: function (scope, element, attr) {
            if (scope.$last === true) {
                $timeout(function () {
//                    $(".clockPicker").on("keyup", function () {
//                        var data = $(this).val();
//                        if (data.length === 2) {
//                            $(this).val(data + ":");
//                        }
//                    });
//                    $(".clockPicker").keydown(function (e) {
//                        if (e.shiftKey || e.ctrlKey || e.altKey) { // if shift, ctrl or alt keys held down
//                            e.preventDefault();         // Prevent character input
//                        } else {
//                            var n = e.keyCode;
//                            if (!((n == 8)              // backspace
//                                    || (n == 46)                // delete
//                                    || (n >= 35 && n <= 40)     // arrow keys/home/end
//                                    || (n >= 48 && n <= 57)     // numbers on keyboard
//                                    || (n >= 96 && n <= 105))   // number on keypad
//                                    ) {
//                                e.preventDefault();
//                                // alert("in if");
//                                // Prevent character input
//                            }
//                        }
//                    });
                });
            }
        }
    };
}).directive('hideMonthProcessing', function ($timeout) {
    return {
        link: function (scope, element, attr) {
            $timeout(function () {
                if (scope.$last === true) {
                    $("table.monthTable").show();
                } else {
                    $("table.monthTable").hide();
                }
            });
        }
    };
}).directive('hideDateProcessing', function ($timeout) {
    return {
        link: function (scope, element, attr) {
            $timeout(function () {
            });
        }
    };
}).directive('hideChildDateProcessing', function ($timeout) {
    return {
        link: function (scope, element, attr) {
            $timeout(function () {
                if (scope.outerLast && scope.$last) {
                    !$("table.dayTable").hasClass("active") ? $("table.dayTable").addClass("active") : 0;
                }
            });
        }
    };
}).directive('initCustomScroll', function () {
    return function (scope, element, attrs) {
        $(".scrollbar-light").scrollbar();
    };
}).directive('numbersOnly', function () {
    return {
        restrict: 'A',
        require: 'ngModel',
        link: function (scope, element, attrs, ngModel) {
            if (!ngModel)
                return;
            ngModel.$parsers.push(function (val) {
                var parsed = val.replace(/[^0-9]+/g, '');
                if (parseInt(parsed) > parseInt(attrs.rangeMax))
                    parsed = attrs.rangeMax;
                if (parseInt(parsed) < parseInt(attrs.rangeMin))
                    parsed = attrs.rangeMin;
                if (val !== parsed) {
                    ngModel.$setViewValue(parsed);
                    ngModel.$render();
                }
                return parsed;
            });
        }
    };
}).directive('imageOnload', function ($timeout) {
    return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            element.bind('error', function () {

                $timeout(function () {
                    var imageSrc = $('.packageCoverImage').attr('src');
                    $('.packageCoverImage').attr('src', imageSrc);
                }, 3000);
            });
        }
    };
});
myApp.run(['$route', '$rootScope', '$location', function ($route, $rootScope, $location) {
        var original = $location.path;
        $location.path = function (path, reload) {
            if (reload === false) {
                var lastRoute = $route.current;
                var un = $rootScope.$on('$locationChangeSuccess', function () {
                    $route.current = lastRoute;
                    un();
                });
            }
            return original.apply($location, [path]);
        };
    }]);
myApp.filter('limitObjectFromTo', function () {
    return function (obj, limitFrom, limitTo) {
        var newObj = {},
                i = 0;
        for (var p in obj) {
            if (i >= limitFrom)
                newObj[p] = obj[p];
            if (++i === limitTo)
                break;
        }
        return newObj;
    };
}).filter('pagingFilter', function () {
    return function (obj, pageNumber, pageSize) {
        var newObj = {},
                i = 0;
        var startIndex = (pageNumber - 1) * pageSize;
        var record = 0;
        for (var p in obj) {
            if (i >= startIndex) {
                newObj[p] = obj[p];
                record++;
            }
            if (record >= pageSize) {
                break;
            }
            i++;
        }
        return newObj;
    };
}).filter('pagingFilterWithArray', function () {
    return function (obj, pageNumber, pageSize) {
        var newObj = [];
        var startIndex = (pageNumber - 1) * pageSize;
        var record = 0;
        for (var i = 0; i < obj.length; i++) {
            if (i >= startIndex) {
                newObj.push(obj[i]);
//                newObj[p] = obj[p];
                record++;
            }
            if (record >= pageSize) {
                break;
            }
        }
        return newObj;
    };
});
myApp.controller('DevelopingControler', function ($scope, $http, $q, service) {

    $scope.toggleDevelopingBox = function () {
        $("#developingBox").toggleClass("active");
    };
    $scope.sendDone = false;
    $scope.sendInfo = true;
    $scope.submitEmailUrl = service.getContextPath() + "/Common/EmailRegister";
    $scope.submitEmail = function () {
        $scope.sendDone = false;
        if ($scope.missing.emailValid && $scope.missing.emailRegex) {
//            var oMyForm = new FormData();
//            oMyForm.append("email", $scope.email);
//            $.ajax({
//                url: $scope.submitEmailUrl,
//                data: oMyForm,
//                dataType: 'text',
//                processData: false,
//                contentType: false,
//                type: 'POST',
//                beforeSend: function (jqXHR, settings) {
//                  //  $(".popupContent").css("background", '#fff url(' + service.getContextPath() + '/Resources/Theme/image/loading.gif) no-repeat center');
////                $scope.package.coverImage = ;
//                    $scope.sendInfo = false;
//                },
//                success: function (data) {
//                    console.log("mydata " + data);
//                    if (data.result !== "error") {
//                    } else {
//                    }
//                }, error: function (respone) {
//                    $(".popupContent").css("background", '');
//                    $scope.sendDone = true;
//                    $scope.sendInfo = true;
//                }
//            });
            $scope.sendInfo = false;
            var data = {"email": $scope.email};
            $http.post($scope.submitEmailUrl, data)
                    .then(function successCallback(response) {
                        if (response.data.result === "error") {
                            var pageError = service.getContextPath() + service.getErrorPageUrl();
                            $(location).attr('href', pageError);
                        } else if (response.data.result !== "fail") {
                            $scope.sendDone = true;
                            $scope.sendInfo = true;
                        } else {
                        }
                    });
        }
    };
//    $scope.register = {"email": $scope.email};



    /**
     * ValidatevalidateListAmenities
     */

    $scope.showError = {all: false};
    $scope.missing = {emailValid: false, emailRegex: false};
    $scope.onlyNumbers = /^\d+$/;
    $scope.emailRegex = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    $scope.validateRegisterForm = function (event) {

        if (!$scope.missing.emailValid) {
            $scope.showError.all = true;
            event.preventDefault();
        }
    };
    var pending = false;
    var deferred = $q.defer();
    var checkEmailUrl = service.getContextPath() + "/Common/checkEmailRegister";
    $scope.emailLoading = false;
    $scope.$watch('email', function (newVal, oldVal) {
        $scope.emailLoading = false;
        $scope.showError.emailValid = false;
        clearTimeout($scope.timeout);
        $scope.timeout = setTimeout(function () { // start a new timeout
            if (oldVal !== null && oldVal !== undefined && oldVal !== "") {
                $scope.showError.emailValid = true;
                if ($scope.emailRegex.test(newVal)) {
                    $scope.missing.emailRegex = true;
                    if (pending) {
                        deferred.resolve();
                        deferred = $q.defer();
                    }
                    pending = true;
                    $scope.emailLoading = true;
                    var data = {"email": $scope.email};
                    $http.post(checkEmailUrl, data, {timeout: deferred.promise})
                            .then(function successCallback(response) {
                                pending = false;
                                deferred = $q.defer();
                                if (response.data.result === "error") {
                                    var pageError = service.getContextPath() + service.getErrorPageUrl();
                                    $(location).attr('href', pageError);
                                } else if (response.data.result !== "fail") {
                                    $scope.missing.emailValid = true;
                                } else {
                                    $scope.missing.emailValid = false;
                                }
                                $scope.emailLoading = false;
                            });
                    $scope.$digest();
                } else {
                    $scope.missing.emailRegex = false;
                }
                $scope.$digest();
            }
            clearTimeout($scope.timeout); // clear time out just in case.
        }, 1000);
    });
    $("input#email").on({
        keydown: function (e) {
            if (e.which === 32)
                return false;
        },
        change: function () {
            this.value = this.value.replace(/\s/g, "");
        }
    });
    /* END DEVELOPING BOX */


});
myApp.controller('BeProviderController', function (vcRecaptchaService, $scope, $http, $q, service) {
    /**
     * Initiate
     */
    $scope.loading = true;
    $scope.form = form;

    $scope.register = {"businessType": businessType, "businessName": businessName,
        "country": country, "city": city, "address": address, "phoneCode": '0',
        "phone": phone, "firstName": firstName, "lastName": lastName, "displayName": "",
        "jobTitle": jobTitle, "email": email, "password": "", "rePassword": "", "salesCode": "", "reEmail": ""};
    // YouTripper
    $scope.publicKey = "6LcR5xUTAAAAAPbeJma29e1OeNBQGOznrhPvfZoM";
// Server
//    $scope.publicKey = "6LfkbRATAAAAAA2FgdG5jg26oZEYE1M0AzxPL8Iv";
    $scope.captcha = "true";
    /**
     * End Initiate
     */

    /**
     * ValidatevalidateListAmenities
     */

//    $scope.showError = {matchPassword: false, emailValid: false, businessName: false,
//        usernameURL: false, salesCode: false, all: false};
//    $scope.missing = {matchPassword: false, emailValid: false, businessName: false,
//        usernameURL: false, salesCode: false, emailRegex: false, businessType: false, urlRegex: false};

    $scope.showError = {matchPassword: false, matchEmail: false, emailValid: false, businessName: false,
        salesCode: false, all: false};
    $scope.missing = {matchPassword: false, matchEmail: false, emailValid: false, businessName: false,
        salesCode: false, emailRegex: false, businessType: false};
    $scope.loading = false;
    $scope.onlyAnphanumeric = /^[a-zA-Z0-9]+$/i;
    $scope.onlyNumbers = /^\d+$/;
    $scope.emailRegex = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    $scope.validateRegisterForm = function (event) {
        $scope.validateTimes();
        if (!angular.isString($scope.register.referralCode) || $scope.register.referralCode === '') {
            $scope.showError.salesCode = false;
        }
        if (!$scope["signupForm"].$valid || !$scope.missing.matchPassword ||
                !$scope.missing.emailValid || !$scope.missing.businessName ||
                !$scope.missing.businessType || !$scope.missing.matchEmail ||
                !$scope.missing.emailRegex || $scope.showError.salesCode || !isValidTime) {
            $scope.showError.all = true;
            event.preventDefault();
        }
    };
    $(".timeMaskInput").inputmask("h:s", {
        onKeyValidation: function (key, result) {
            angular.element($(this)).triggerHandler('input');
        }
    });
    var pending = false;
    var deferred = $q.defer();
    $scope.$watch('register.referralCode', function (newVal, oldVal) {
        clearTimeout($scope.timeout);
        $scope.timeout = setTimeout(function () {
            if (pending) {
                deferred.resolve();
                deferred = $q.defer();
            }
            pending = true;
            if ($scope.isShowSalesman) {
                if (!angular.isString($scope.register.referralCode) || $scope.register.referralCode === '') {
                    $scope.showError.salesCode = false;
                } else {
                    var data = {"salesCode": $scope.register.referralCode};
                    $http.post(checkSalesCode, data)
                            .then(function successCallback(response) {
                                pending = false;
                                deferred = $q.defer();
                                if (response.data.result === "error") {
                                    var pageError = service.getContextPath() + service.getErrorPageUrl();
                                    $(location).attr('href', pageError);
                                } else if (response.data.result === "fail") {
                                    $scope.missing.salesCode = true;
                                    $scope.showError.salesCode = true;
                                } else {
                                    $scope.showError.salesCode = false;
                                }
                            });
                }
            }
            $scope.$digest();
            clearTimeout($scope.timeout); // clear time out just in case.
        }, 1000);
    });
    var pending = false;
    var deferred = $q.defer();
    $scope.businessNameLoading = false;
    $scope.$watch('register.businessName', function (newVal, oldVal) {
        $scope.businessNameLoading = false;
        $scope.showError.businessName = false;
        clearTimeout($scope.timeout);
        $scope.timeout = setTimeout(function () { // start a new timeout
            if (oldVal !== null && oldVal !== undefined && oldVal !== "") {
                $scope.showError.businessName = true;
                if ($scope["signupForm"].businessName.$valid) {
                    if (pending) {
                        deferred.resolve();
                        deferred = $q.defer();
                    }
                    pending = true;
                    $scope.businessNameLoading = true;
                    var data = {"businessName": $scope.register.businessName};
                    $http.post(checkBusinessName, data, {timeout: deferred.promise})
                            .then(function successCallback(response) {
                                pending = false;
                                deferred = $q.defer();
                                if (response.data.result === "error") {
                                    var pageError = service.getContextPath() + service.getErrorPageUrl();
                                    $(location).attr('href', pageError);
                                } else if (response.data.result !== "fail") {
                                    $scope.missing.businessName = true;
                                } else {
                                    $scope.missing.businessName = false;
                                }
                                $scope.businessNameLoading = false;
                            });
                    $scope.$digest();
                } else {
                    $scope.missing.businessName = false;
                }
                $scope.$digest();
            }
            clearTimeout($scope.timeout); // clear time out just in case.
        }, 1000);
    });
    $scope.emailLoading = false;
    $scope.$watch('register.email', function (newVal, oldVal) {
        $scope.emailLoading = false;
        $scope.showError.emailValid = false;
        clearTimeout($scope.timeout);
        $scope.timeout = setTimeout(function () { // start a new timeout
            if (oldVal !== null && oldVal !== undefined && oldVal !== "") {
                $scope.showError.emailValid = true;
                if ($scope["signupForm"].email.$valid && $scope.emailRegex.test(newVal)) {
                    $scope.missing.emailRegex = true;
                    if (pending) {
                        deferred.resolve();
                        deferred = $q.defer();
                    }
                    pending = true;
                    $scope.emailLoading = true;
                    var data = {"email": $scope.register.email};
                    $http.post(checkEmailUrl, data, {timeout: deferred.promise})
                            .then(function successCallback(response) {
                                pending = false;
                                deferred = $q.defer();
                                if (response.data.result === "error") {
                                    var pageError = service.getContextPath() + service.getErrorPageUrl();
                                    $(location).attr('href', pageError);
                                } else if (response.data.result !== "fail") {
                                    $scope.missing.emailValid = true;
                                } else {
                                    $scope.missing.emailValid = false;
                                }
                                $scope.emailLoading = false;
                            });
                    $scope.$digest();
                } else {
                    $scope.missing.emailRegex = false;
                }
                $scope.$digest();
            }
            clearTimeout($scope.timeout); // clear time out just in case.
        }, 1000);
    });
    $("input#phone").on({
        keydown: function (e) {
            if (e.which === 32)
                return false;
        },
        change: function () {
            this.value = this.value.replace(/\s/g, "");
        }
    });
    $("input#email").on({
        keydown: function (e) {
            if (e.which === 32)
                return false;
        },
        change: function () {
            this.value = this.value.replace(/\s/g, "");
        }
    });

    $scope.validatePassword = function () {
        if (angular.isString($scope.register.rePassword) && $scope.register.rePassword !== ""
                && angular.isString($scope.register.password) && $scope.register.password !== "") {
            $scope.showError.matchPassword = true;
            if ($scope.register.rePassword !== $scope.register.password) {
                $scope.missing.matchPassword = false;
            } else {
                $scope.missing.matchPassword = true;
            }
        } else {
            $scope.showError.matchPassword = false;
        }
    };

    $scope.validateEmail = function () {
        if (angular.isString($scope.register.reEmail) && $scope.register.reEmail !== ""
                && angular.isString($scope.register.email) && $scope.register.email !== "") {
            $scope.showError.matchEmail = true;
            if ($scope.register.reEmail !== $scope.register.email) {
                $scope.missing.matchEmail = false;
            } else {
                $scope.missing.matchEmail = true;
            }
        } else {
            $scope.showError.matchEmail = false;
        }
    };

    $scope.setResponse = function (response) {
        $scope.captcha = vcRecaptchaService.getResponse();
        $scope.$digest();
    };
    //$scope.choosenBusinessType = false;
    $scope.choosenCountry = false;
    $scope.showDDlBusinessType = function () {
        $(".businessTypeDdlMenu").toggleClass("active");
    };
    $scope.businessType = {};
    $scope.chooseBusinessType = function (bussinessTypeId) {
        $(".businessTypeDdlMenu").removeClass("active");
        var x = document.getElementsByClassName("businessTypeSelect")[0];
        for (var i = 0; i < $scope.form.businesses.length; i++) {
            var business = $scope.form.businesses[i];
            if (business.businessTypeID === bussinessTypeId) {
                x.innerHTML = business.type;
                $scope.missing.businessType = true;
                break;
            }
        }

        $scope.businessType.businessTypeID = bussinessTypeId;
    };
    $scope.showDDlCountry = function () {
        $(".countryDdlMenu").toggleClass("active");
    };
    $scope.country = {};
    $scope.chooseCountry = function (countryId) {
        $(".countryDdlMenu").removeClass("active");
        var x = document.getElementsByClassName("countrySelect")[0];
        for (var i = 0; i < $scope.form.countries.length; i++) {
            var country = $scope.form.countries[i];
            if (country.countryID === countryId) {
                x.innerHTML = country.name;
                $scope.choosenCountry = true;
                break;
            }
        }
        if (countryId !== $scope.country.countryId) {
            $scope.country.countryId = countryId;
            var tempCity = $scope.listCityFiltered();
            var city = document.getElementsByClassName("citySelect")[0];
            city.innerHTML = tempCity[0].name;
            $scope.city.name = tempCity[0].name;
        }

    };

    $scope.showDDlCity = function () {
        $(".cityDdlMenu").toggleClass("active");
    };
    $scope.city = {};
    $scope.chooseCity = function (cityID) {
        $(".cityDdlMenu").removeClass("active");
        var x = document.getElementsByClassName("citySelect")[0];
        for (var i = 0; i < $scope.form.cities.length; i++) {
            var city = $scope.form.cities[i];
            if (city.cityID === cityID) {
                x.innerHTML = city.name;
                $scope.city.name = city.name;
                break;
            }
        }
    };

    $scope.listCityFiltered = function () {
        var result = [];
        angular.forEach($scope.form.cities, function (child) {
            if (child.countryID === $scope.country.countryId) {
                result.push(child);
            }
        });
        return result;
    };

    $scope.isShowSalesman = false;
    $scope.showSalesmanField = function () {
        $scope.showError.salesCode = true;
        $scope.isShowSalesman = true;
    };
    var x = document.getElementsByClassName("countrySelect")[0];
    for (var i = 0; i < $scope.form.countries.length; i++) {
        var country = $scope.form.countries[i];
        if (country.name === "Thailand") {
            x.innerHTML = country.name;
            $scope.choosenCountry = true;
            $scope.country.countryId = country.countryID;
            break;
        }
    }
    /**
     * End Validate
     */


    $scope.clockInputTypeOpen = true;
    var typeClockPicker;

    var resetClock = function () {
        $scope.hourArray = ['00', '01', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23'];
        $scope.minuteArray = ['00', '05', '10', '15', '20', '25', '30', '35', '40', '45', '50', '55'];
    };

    var resetMinute = function () {
        $scope.minuteArray = ['00', '05', '10', '15', '20', '25', '30', '35', '40', '45', '50', '55'];
    };

    resetClock();

    $scope.openTimeClock = function (type) {
        typeClockPicker = type;
        var topClockInput = $('.clock-input').offset().top;
        var heightHeader = $('header .navbar-header').outerHeight(true);
        var disTance = topClockInput - heightHeader;
        var scrollPosition = $('#provider-signup-bg').scrollTop();
        $('#provider-signup-bg').animate({
            scrollTop: (scrollPosition + disTance)
        }, 500);
        resetClock();

        if (type === 'openTime') {
            $scope.clockInputTypeOpen = true;
            if (angular.isString($scope.register.closeTime)) {
                var tempPickhour = $scope.register.closeTime.split(':')[0];
                for (var i = 0; i < $scope.hourArray.length; i++) {
                    if ($scope.hourArray[i] === tempPickhour) {
                        if ($scope.register.closeTime.split(':')[1] === '00') {
                            $scope.hourArray.splice(i, $scope.hourArray.length - i + 1);
                        } else {
                            $scope.hourArray.splice(i + 1, $scope.hourArray.length - i);
                        }
                        break;
                    }
                }
                if (angular.isString($scope.register.openTime)) {
                    if ($scope.register.openTime.split(':')[0] === $scope.register.closeTime.split(':')[0]) {
                        for (var i = 0; i < $scope.minuteArray.length; i++) {
                            if ($scope.minuteArray[i] === $scope.register.closeTime.split(':')[1]) {
                                $scope.minuteArray.splice(i, $scope.minuteArray.length - i + 1);
                                break;
                            }
                        }
                        if ($scope.register.openTime.split(':')[1] >= $scope.register.closeTime.split(':')[1]) {
                            $scope.providerPickMinute = '';
                        }
                    }
                }

            }
            if (angular.isString($scope.register.openTime)) {
                var res = $scope.register.openTime.split(':');
                $scope.providerPickHour = res[0];
                $scope.providerPickMinute = res[1];
            } else {
                $scope.providerPickHour = '';
                $scope.providerPickMinute = '';

            }
            $(".popover").css("right", "240px");
        } else {
            $scope.clockInputTypeOpen = false;
            if (angular.isString($scope.register.openTime)) {
                var tempPickhour = $scope.register.openTime.split(':')[0];
                for (var i = 0; i < $scope.hourArray.length; i++) {
                    if ($scope.hourArray[i] === tempPickhour) {
                        if ($scope.register.openTime.split(':')[1] === 55) {
                            $scope.hourArray.splice(0, i + 1);
                        } else {
                            $scope.hourArray.splice(0, i);
                        }

                        break;
                    }
                }
                if (angular.isString($scope.register.closeTime)) {
                    if ($scope.register.closeTime.split(':')[0] === $scope.register.openTime.split(':')[0]) {
                        for (var i = 0; i < $scope.minuteArray.length; i++) {
                            if ($scope.minuteArray[i] === $scope.register.openTime.split(':')[1]) {
                                $scope.minuteArray.splice(0, i + 1);
                                break;
                            }
                        }
                        if ($scope.register.closeTime.split(':')[1] === '--') {
                            $scope.providerPickMinute = '';
                        } else if ($scope.register.closeTime.split(':')[1] <= $scope.register.openTime.split(':')[1]) {
                            $scope.providerPickMinute = '';
                        }
                    }
                }
            }
            if (angular.isString($scope.register.closeTime)) {
                var res = $scope.register.closeTime.split(':');
                $scope.providerPickHour = res[0];
                $scope.providerPickMinute = res[1];
            } else {
                $scope.providerPickHour = '';
                $scope.providerPickMinute = '';

            }
            $(".popover").css("right", "10px");
        }
        $(".popover").addClass("active");
    };
    var isValidTime;
    $scope.validateTimes = function () {
        if (angular.isString($scope.register.openTime)) {
            if (($scope.register.openTime.split(':')[0] >= '00') && ($scope.register.openTime.split(':')[1] >= '00')) {
                $scope.invalidStartTime = false;
            } else {
                $scope.invalidStartTime = true;
            }
        }
        if (angular.isString($scope.register.closeTime)) {
            if (($scope.register.closeTime.split(':')[0] >= '00') && ($scope.register.closeTime.split(':')[1] >= '00')) {
                $scope.invalidCloseTime = false;
            } else {
                $scope.invalidCloseTime = true;
            }
        }
        if (!$scope.invalidCloseTime && !$scope.invalidOpenTime) {
            if (!(Date.parse('01/01/2011 ' + $scope.register.openTime) < Date.parse('01/01/2011 ' + $scope.register.closeTime))) {
                isValidTime = false;
            } else {
                isValidTime = true;
            }
        }
    };

    $scope.choosenHour = function () {
        if ($scope.clockInputTypeOpen) {
            if (!($scope.providerPickMinute >= '00')) {
                $scope.register.openTime = $scope.providerPickHour + ":" + '--';
            } else {
                $scope.register.openTime = $scope.providerPickHour + ":" + $scope.providerPickMinute;
            }

            if (angular.isString($scope.register.closeTime)) {
                if ($scope.providerPickHour === $scope.register.closeTime.split(':')[0]) {
                    for (var i = 0; i < $scope.minuteArray.length; i++) {
                        if ($scope.minuteArray[i] === $scope.register.closeTime.split(':')[1]) {
                            $scope.minuteArray.splice(i, $scope.minuteArray.length - i + 1);
                            break;
                        }
                    }
                    if ($scope.register.openTime.split(':')[1] >= $scope.register.closeTime.split(':')[1]) {
                        $scope.providerPickMinute = '';
                        $scope.register.openTime = $scope.providerPickHour + ":" + '--';
                    }
                } else {
                    resetMinute();
                }
            }
        } else {
            if (!($scope.providerPickMinute >= '00')) {
                $scope.register.closeTime = $scope.providerPickHour + ":" + '--';
            } else {
                $scope.register.closeTime = $scope.providerPickHour + ":" + $scope.providerPickMinute;
            }
            if (angular.isString($scope.register.openTime)) {
                if ($scope.providerPickHour === $scope.register.openTime.split(':')[0]) {
                    for (var i = 0; i < $scope.minuteArray.length; i++) {
                        if ($scope.minuteArray[i] === $scope.register.openTime.split(':')[1]) {
                            $scope.minuteArray.splice(0, i + 1);
                            break;
                        }
                    }
                    if ($scope.register.closeTime.split(':')[1] <= $scope.register.openTime.split(':')[1]) {
                        $scope.providerPickMinute = '';
                        $scope.register.closeTime = $scope.providerPickHour + ":" + '--';
                    }
                } else {
                    resetMinute();
                }
            }
        }
    };

    $scope.choosenMinute = function () {
        if ($scope.clockInputTypeOpen) {
            if (!($scope.providerPickHour >= '00')) {
                $scope.register.openTime = '--' + ":" + $scope.providerPickMinute;
            } else {
                $scope.register.openTime = $scope.providerPickHour + ":" + $scope.providerPickMinute;
            }
        } else {
            if (!($scope.providerPickHour >= '00')) {
                $scope.register.closeTime = '--' + ":" + $scope.providerPickMinute;
            } else {
                $scope.register.closeTime = $scope.providerPickHour + ":" + $scope.providerPickMinute;
            }
        }

    };

    $scope.loading = false;
});
myApp.controller('ProviderPackages', function ($scope, $http, service) {
    $scope.loaded = false;
    $scope.packages = packages;
    //set color and status for packages
    for (var i = 0; i < $scope.packages.listPackage.length; i++) {

        var package = $scope.packages.listPackage[i];
        package.isTemporary = false;
        if (package.isPending === true) {
            package.packageStatus = 'Pending Approval';
            package.color = '#F7AC3B';
        } else if (package.isEditing === true) {
            package.packageStatus = 'Incomplete Submission';
            package.color = '#FF514E';
        } else if (package.isStopped === true) {
            package.packageStatus = 'Not Operating';
            package.color = '#FF514E';
        } else {
            package.packageStatus = 'Approved';
            package.color = '#3FBDC5';
        }
    }

    for (var i = 0; i < $scope.packages.listTemporaryPackage.length; i++) {
        var package = $scope.packages.listTemporaryPackage[i];
        if (package.isFinished === true) {
            package.packageStatus = 'Pending Approval';
            package.color = '#F7AC3B';
        } else {
            package.packageStatus = 'Creation in Process';
            package.color = '#F7AC3B';
        }
    }

    for (var i = 0; i < $scope.packages.listTemporaryPackage.length; i++) {
        var tempPackage = $scope.packages.listTemporaryPackage[i];
        var package = {"NoTrippSources": "", "color": tempPackage.color, "coverImage": tempPackage.coverImage, "createdTime": tempPackage.createdTime, "isFinished": false, "isDeleting": false, "isEditing": false, "isPending": false, "isStopped": false, "isUsingMaxQuota": tempPackage.isUsingMaxQuota,
            "keywords": "", "lastName": "", "location": tempPackage.city, "mainDescription": "", "numberRates": "", "ordinaryPrice": tempPackage.ordinaryPriceForAdult, "packageID": tempPackage.id, "packageName": tempPackage.name,
            "packageStatus": tempPackage.packageStatus, "providerID": tempPackage.providerID, "providerImage": "", "rate": "", "totalRecords": "", "isTemporary": true};
        $scope.packages.listPackage.push(package);

    }


    $scope.page = page;
    $scope.loaded = true;
    $scope.clonePackageID = 0;
    $scope.clonePackageStatus = '';
    $scope.checkClonePackage = function (packageID, status) {
        $scope.clonePackageID = packageID;
        $scope.clonePackageStatus = status;
        $scope.loaded = false;
        var data = {"packageID": packageID};
        $http.post(service.getContextPath() + "/Provider/Package/CloneCheck", data)
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else if (response.data.result === "packageExisting") {
                        $('#ConfirmBox').toggleClass('active');
                    } else {
                        $scope.submitCloneForm();
                    }
                    $scope.loaded = true;
                });
    };


    $scope.submitCloneForm = function () {
        document.getElementById("clonePackageForm").submit();
    };

    $scope.closeClonePackage = function () {
        $('#ConfirmBox').toggleClass('active');
    };
    $scope.checkRequireTrippsource = function (isUsingMaxQuota, noOfTrippsource) {
        if (isUsingMaxQuota === false) {
            if (noOfTrippsource > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    };
    var stopPackageID, stopPackageIndex;
    $scope.openStopPackageBox = function (packageID, index) {
        stopPackageID = packageID;
        stopPackageIndex = $scope.packages.listPackage.indexOf(index);
        ;
        $('#stopPopup').toggleClass('active');
    };
    $scope.openStopPackageBoxTypeDelete = function (packageID, index) {
        stopPackageID = packageID;
        stopPackageIndex = $scope.packages.listPackage.indexOf(index);
        ;
        $('#stopPopupWhenDelete').toggleClass('active');
    };

    $scope.openClonePackagePopup = function (packageID, isTemporary) {
        $scope.penddingStatus = true;
        $scope.clonePackageID = packageID;
        if (isTemporary === true)
            $scope.penddingStatus = true;
        if (isTemporary === false)
            $scope.penddingStatus = false;
        $('#clonePackPopup').toggleClass('active');
    };
    $scope.closeClonePackagePopup = function () {
        $('#clonePackPopup').toggleClass('active');
    };
    $scope.validateCloneAll = function () {
        //$('#clonePackPopup').toggleClass('active');
        if ($scope.clonePart.all === true) {
            $scope.clonePart.category = false;
            $scope.clonePart.description = false;
            $scope.clonePart.photos = false;
            $scope.clonePart.booking = false;
            $scope.clonePart.pricing = false;
        }
    };

    $scope.validateClone = function () {
        //$('#clonePackPopup').toggleClass('active');

        if ($scope.clonePart.category === true ||
                $scope.clonePart.description === true ||
                $scope.clonePart.photos === true ||
                $scope.clonePart.booking === true ||
                $scope.clonePart.pricing === true) {
            $scope.clonePart.all = false;
        }
    };

    $scope.getInfoPackage = function (packageID) {
        $scope.packageInfoID = packageID;
        $('#getInfoPopup').toggleClass('active');
    };
    $scope.stopPackage = function () {
        $scope.stopProcessing = true;
        var data = {"packageID": stopPackageID};
        $http.post(service.getContextPath() + "/Provider/Package/Stopping", data)
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        $scope.packages.listPackage[stopPackageIndex].isStopped = true;
                        var package = $scope.packages.listPackage[stopPackageIndex];
                        if (package.isPending === true) {
                            package.packageStatus = 'Pending Approval';
                            package.color = '#F7AC3B';
                        } else if (package.isEditing === true) {
                            package.packageStatus = 'Incomplete Submission';
                            package.color = '#FF514E';
                        } else if (package.isStopped === true) {
                            package.packageStatus = 'Not Operating';
                            package.color = '#FF514E';
                        } else {
                            package.packageStatus = 'Approved';
                            package.color = '#3FBDC5';
                        }
                    }
                    $('#stopPopup').removeClass('active');
                    $('#stopPopupWhenDelete').removeClass('active');
                    $scope.stopProcessing = false;
                });
    };
    var packageToDelete = 0;
    var indexPackage = -1;
    $scope.openDeleteBox = function (packageID, index) {
        var data = {"packageID": packageID};
        $http.post(service.getContextPath() + "/Provider/Package/CheckExistBooking", data)
                .then(function successCallback(response) {
                    if (response.data.result === "OK") {
                        packageToDelete = packageID;
                        $scope.deleteReason = '';
                        indexPackage = $scope.packages.listPackage.indexOf(index);
                        ;
                        $('#deletePopup').toggleClass('active');
                    } else {
                        $('#cannotDeletePopup').toggleClass('active');
                    }
                    $scope.loaded = true;
                });
    };

    $scope.openDeleteTemporaryBox = function (packageID, index) {
        console.log(packageID);
        packageToDelete = packageID;
        indexPackage = $scope.packages.listPackage.indexOf(index);
        $('#deleteTempPackage').toggleClass('active');
    };
    $scope.deleteTemporaryPackage = function () {
        $scope.deleteTempProcessing = true;
        var data = {"packageID": packageToDelete};
        console.log(data);
        $http.post(service.getContextPath() + "/Provider/Package/DeletingTempPackage", data)
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        $scope.packages.listPackage.splice(indexPackage, 1);
                    }
                    $scope.deleteTempProcessing = false;
                    $('#deleteTempPackage').toggleClass('active');
                });

    };
    $scope.deleteReasonValidate = true;
    $scope.deletePackage = function () {
        $scope.deleteReasonValidate = true;
        if ($scope.reasonDelete === undefined || $scope.reasonDelete === null) {
            $scope.deleteReasonValidate = false;
        }
        if ($scope.reasonDelete.isOther) {
            if ($scope.deleteReason === '' || !angular.isString($scope.deleteReason)) {
                $scope.deleteReasonValidate = false;
            }
        }

        if ($scope.deleteReasonValidate) {
            $scope.deleteProcessing = true;
            var data = {"packageID": packageToDelete, "deleteReason": $scope.deleteReason, "deleteReasonID": $scope.reasonDelete.deleteReasonID};
            $http.post(service.getContextPath() + "/Provider/Package/Deleting", data)
                    .then(function successCallback(response) {
                        if (response.data.result === "error") {
                            var pageError = service.getContextPath() + service.getErrorPageUrl();
                            $(location).attr('href', pageError);
                        } else {
                            $scope.packages.listPackage.splice(indexPackage, 1);
                        }
                        $scope.deleteProcessing = false;
                        $('#deletePopup').toggleClass('active');
                    });
        }
    };
    $scope.startPackage = function (packageID, index) {
        $scope.loaded = false;
        var data = {"packageID": packageID};
        $http.post(service.getContextPath() + "/Provider/Package/Starting", data)
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        var newIndex = $scope.packages.listPackage.indexOf(index);
                        $scope.packages.listPackage[newIndex].isStopped = false;
                        var package = $scope.packages.listPackage[newIndex];
                        if (package.isPending === true) {
                            package.packageStatus = 'Pending Approval';
                            package.color = '#F7AC3B';
                        } else if (package.isEditing === true) {
                            package.packageStatus = 'Incomplete Submission';
                            package.color = '#FF514E';
                        } else if (package.isStopped === true) {
                            package.packageStatus = 'Not Operating';
                            package.color = '#FF514E';
                        } else {
                            package.packageStatus = 'Approved';
                            package.color = '#3FBDC5';
                        }
                    }
                    $scope.loaded = true;
                });
    };
    $scope.toggleDeleteBox = function () {
        $('#deletePopup').toggleClass('active');
    };
    $scope.toggleStopBox = function () {
        $('#stopPopup').toggleClass('active');
    };
    $scope.toggleStopDeleteBox = function () {
        $('#stopPopupWhenDelete').toggleClass('active');
    };
    $scope.toggleCannotDeleteBox = function () {
        $('#cannotDeletePopup').toggleClass('active');
    };
    $scope.showPackageMenu = function () {
        $('.').toggleClass('active');
    };
    $scope.toggleGetInfoBox = function () {
        $('#getInfoPopup').toggleClass('active');
    };
    $scope.toggleDeleteTempBox = function () {
        $('#deleteTempPackage').toggleClass('active');
    };
    $(document).on('click', '.package-action-menu', function () {
        if (!$(this).children(".menu-package-click").hasClass('active')) {
            $(".menu-package-click.active").removeClass("active");
            $(this).children(".menu-package-click").addClass("active");
        } else {
            $(".menu-package-click.active").removeClass("active");
        }
    });
    $(document).click(function (event) {
        if (!$(event.target).closest('.package-action-menu').length && !$(event.target).is('.package-action-menu')
                ) {
            if ($(".menu-package-click.active").length > 0) {
                $(".menu-package-click.active").removeClass("active");
            }
        }
    });
    //delete reason

    $scope.changeReasonDelete = function () {
        if ($scope.reasonDelete.isOther) {
            $scope.showOtherReasonTextField = true;
        } else {
            $scope.showOtherReasonTextField = false;
        }
    };
    //sort filter 
    $scope.packages.sortPackageValue = "abc";
    $scope.packages.filterPackageValue = "all";
    $scope.keySort = 'packageName';
    $scope.reverse = false;
    $scope.sortPackage = function () {
        if ($scope.packages.sortPackageValue === 'abc') {
            $scope.keySort = 'packageName';
            $scope.reverse = false;
        }
        if ($scope.packages.sortPackageValue === 'oldest') {
            $scope.keySort = 'createdTime';
            $scope.reverse = false;
        }
        if ($scope.packages.sortPackageValue === 'youngest') {
            $scope.keySort = 'createdTime';
            $scope.reverse = true;
        }
        if ($scope.packages.sortPackageValue === 'expensive') {
            $scope.keySort = 'ordinaryPrice';
            $scope.reverse = true;
        }
        if ($scope.packages.sortPackageValue === 'cheap') {
            $scope.keySort = 'ordinaryPrice';
            $scope.reverse = false;
        }
    };
    $scope.balanceSquare = function () {
        var columnHeight = $(".package-item-block").width() - $(".package-item-status").height() - $(".package-item-description").height();
        $(".package-item-image").height(columnHeight);
    };
});
myApp.controller('ProviderCertificates', function ($scope, service, $http) {
    $scope.loaded = false;
    $scope.certificates = certificates;
    $scope.page = page;
    $scope.loaded = true;
    // $scope.package = temporaryPackage;
    $scope.certificateImage = "";
    $scope.certificateNameInit = "";
    $scope.certificateNameInit2 = [];
    $scope.certificateIDInit;
    $scope.certificateImage3;
    $scope.checkChangeName = false;
    var checkChangeImage = false;
    $scope.changeName = function (name, ID, image) {
        $scope.certificateNameInit = name;
        $scope.certificateIDInit = ID;
        $scope.certificateImage3 = image;
    }
    $scope.changeName2 = function (name, ID, image) {
        $scope.certificateNameInit = name;
        $scope.certificateIDInit = ID;
        $scope.certificateImage3 = image;
        $scope.activeCertificateEditBox();
    }

    $scope.changeName3 = function (name, ID, image) {
        $scope.certificateNameInit = name;
        $scope.certificateIDInit = ID;
        $scope.certificateImage3 = image;
        $scope.activeBigImageBox();
    }

    $scope.closeButtonClick = function () {
        $scope.checkChangeName = true;
    }

    $scope.closeModal = function () {
        $('#myModal2').modal('hide');
    }

    $scope.certificate = certificates;
    // $scope.page = page;
    $scope.currentTime = new Date().getTime();
    // upload temporary certificate
//    $scope.package.certificateID = ;
    $scope.$watch('certificateImageFile', function (newVal, oldVal) { // detect user select new image
        if (newVal !== oldVal) {
            if (newVal !== undefined && newVal !== null) {
                $scope.uploadCertificateImage(newVal);
            }
        }
    });
    $scope.uploadCertificateImageUrl = service.getContextPath() + "/Provider/Package/uploadCertificateImageProvider";
    $scope.uploadCertificateImage = function (certificateImage) {

        var oMyForm = new FormData();
        oMyForm.append("certificateImage", certificateImage);
        $.ajax({
            url: $scope.uploadCertificateImageUrl,
            data: oMyForm,
            dataType: 'text',
            processData: false,
            contentType: false,
            type: 'POST',
            beforeSend: function (jqXHR, settings) {
                $(".certificateUploadBox").css("background", '#fff url(' + service.getContextPath() + '/Images/Icon/loading.gif) no-repeat center');
//                $scope.package.coverImage = ;
            },
            success: function (data) {
                if (data.result !== "error") {
                    $scope.currentTime = new Date().getTime();
                    $(".certificateUploadBox").css("background", '#fff url(' + service.getContextPath() + '/Provider/TempCertificate?' + $scope.currentTime + ') no-repeat center');
                    $scope.$digest();
                } else {
                    alert("Wrong input!");
                }
            }, error: function (respone) {
                alert("Error");
            }
        });
    };
// activeBox
    $scope.activeCertificateUploadBox = function () {
        $("#certificateAddBox").toggleClass("active");
        $(".certificateUploadBox").css("background", '#dfdfdf');
        $scope.certificateImage = "";
    };
    $scope.activeCertificateEditBox = function () {
        $("#certificateEditBox").toggleClass("active");
    };
    $scope.activeBigImageBox = function () {
        $("#bigCertificateImage").toggleClass("active");
    };
    // store Certificate Image to server and database
    var saveCertificateUrl = service.getContextPath() + "/Provider/Package/InsertCertificateProvider";
    $scope.reload = function ()
    {
        if ($scope.checkChangeName === true)
            location.reload();
        else
            $scope.activeCertificateEditBox();
    }


    var workingUpload = false;
    $scope.saveCertificate = function () {
        if (workingUpload === false) {
            workingUpload = true;
            // clearTimeout($scope.timeout);

            // $scope.timeout = setTimeout(function () { // start a new timeout
            if ($scope.certificateImage !== "") {

                if ($scope.certificateImageFile != null) {
                    // construct Json
                    var data = {"providerID": userID, "name": $scope.certificateImage};
                    // send ajax to save data
                    $http.post(saveCertificateUrl, data)
                            .then(function successCallback(response) {

                                var result = response.data.result;
                                if (result === "error") {
                                    var pageError = service.getContextPath() + service.getErrorPageUrl();
                                    $(location).attr('href', pageError);
                                } else {
                                    if (result === 'fail') { // if file is not stored in session

                                        //alert("Please upload your certificate!");
                                    } else {
                                        // update certificates
                                        $scope.certificates = result;
                                        // initiate certificate upload box
                                        $scope.certificateImage = "";
                                        $scope.certificateImageFile = void 0;
                                        $(".certificateUploadBox").css("background", '');
                                        $("#certificateAddBox").removeClass("active");
                                    }
                                }
                                workingUpload = false;
                            });
                } else {
                    alert("Please upload your certificate!");
                    workingUpload = false;
                }
            } else {
                var showError = true;
                $scope.showError = showError;
                workingUpload = false;
                // alert("Please fill your certificate name!");
            }
            //  clearTimeout($scope.timeout); // clear time out just in case.
            //}, 100);
        }

    };
    //edit certificate image
    //edit certificate image
    $scope.certificateImage2 = [];
    $scope.CertificateUploadImage = function (index, certificateID) {
        checkChangeImage = true;
        $scope.uploadCertificateImage2($scope.certificateImage2[index], certificateID);
    };
    var i;
    $scope.uploadCertificateImage2 = function (certificateImage, certificateID) {
        var oMyForm = new FormData();
        oMyForm.append("certificateImage", certificateImage);
        oMyForm.append("providerID", userID);
        oMyForm.append("certificateID", certificateID);
        $.ajax({
            url: uploadUrl,
            data: oMyForm,
            dataType: 'text',
            processData: false,
            contentType: false,
            type: 'POST',
            beforeSend: function (jqXHR, settings) {
                $(".certificateUploadBox").css("background", '#fff url(' + service.getContextPath() + '/Images/Icon/loading.gif) no-repeat center');
                //                $scope.package.coverImage = ;
            },
            success: function (data) {
                //alert("dkm send ok " + data);
                if (data === "error") {
                    var pageError = service.getContextPath() + service.getErrorPageUrl();
                    // alert("dkm data tra ve loi");
                    $(location).attr('href', pageError);
                } else {

                    for (i = 0; i < $scope.certificates.length; i++) {

                        if ($scope.certificates[i].image === data) {
                            $scope.certificates[i].isApproved = false;
                        }
                    }
                    $scope.currentTime = new Date().getTime();
                    // $scope.certificates.image = data;
                    //alert("dkm eo co loi");
                    $("#dLabel img").attr("src", data + "?time=" + $scope.currentTime);
                    $scope.$digest();
                    $scope.$apply;
                }
            }, error: function (respone) {
                var pageError = service.getContextPath() + service.getErrorPageUrl();
                alert("Can not send data " + data);
                $(location).attr('href', pageError);
            }
        });
    };
});
myApp.controller('ProviderMenubar', function ($scope, $http, service) {
    $scope.toggleUnderConstructionBox = function () {
        $("#uconstruction").toggleClass("active");
    };

    $scope.maxReferral = function () {

        if (numberReferral >= 4)
            return false;
        else
            return true;
    };
    $scope.numberOfPackage = 0;
    $http.post(service.getContextPath() + "/Provider/CountPackage")
            .success(function (response) {
                $scope.countPackage = false;
                if (response === "error") {
                    var pageError = service.getContextPath() + service.getErrorPageUrl();
                    $(location).attr('href', pageError);
                } else {
                    $scope.numberOfPackage = response.result;
                    $scope.countPackage = false;
                }
            });
});
myApp.controller('TripperMenubar', function ($scope) {
    /* DEVELOPING BOX */
    $scope.toggleDevelopingBox = function () {
        $("#developingBox").toggleClass("active");
    };
    /* END DEVELOPING BOX */

});
myApp.controller('AdminMenubar', function ($scope) {
    /* DEVELOPING BOX */
    $scope.toggleDevelopingBox = function () {
        $("#developingBox").toggleClass("active");
    };
    /* END DEVELOPING BOX */

});
myApp.controller('FooterController', function ($scope) {
    /* DEVELOPING BOX */
    $scope.toggleDevelopingBox = function () {
        $("#developingBox").toggleClass("active");
    };
    /* END DEVELOPING BOX */

});
myApp.controller('AccountInfoController', function ($scope, service, $timeout, $http) {
    $scope.accountInfo = providerInfo;
    $scope.showError = false;
    $scope.page = page;
    $scope.currentTime = new Date().getTime();
    $scope.$watch('providerImage', function (newVal, oldVal) {
        if ($scope.providerImage !== undefined && $scope.providerImage !== null) {
            $scope.uploadProviderImage($scope.providerImage);
        }
    });
    $scope.uploadProviderImage = function (providerImage) {
        var oMyForm = new FormData();
        oMyForm.append("providerImage", providerImage);
        oMyForm.append("providerID", $scope.accountInfo.providerID);
        $.ajax({
            url: uploadUrl,
            data: oMyForm,
            dataType: 'text',
            processData: false,
            contentType: false,
            type: 'POST',
            beforeSend: function (jqXHR, settings) {
                $scope.accountInfo.image = '/Images/Icon/loading.gif';
                $scope.$digest();
            },
            success: function (data) {
                if (data === "error") {
                    var pageError = service.getContextPath() + service.getErrorPageUrl();
                    $(location).attr('href', pageError);
                } else {
                    $scope.currentTime = new Date().getTime();
                    $scope.accountInfo.image = data;
                    $("#dLabel img").attr("src", "/" + $scope.accountInfo.image + "?time=" + $scope.currentTime);
                    var imageLink = $('#avatarImage').attr('src');
                    $('#avatarImage').attr('src', imageLink + "?" + (+new Date()));
                    $scope.$digest();
                }
            }, error: function (respone) {
                var pageError = service.getContextPath() + service.getErrorPageUrl();
                $(location).attr('href', pageError);
            }
        });
    };
    $scope.validateForm = function (event) {
        if (!$scope["providerForm"].$valid || !$scope.accountInfo.firstName.length ||
                !$scope.accountInfo.name.length ||
                $scope.accountInfo.firstName.length > 15 || $scope.accountInfo.name.length > 15) {
            $scope.showError = true;
            event.preventDefault();
        } else {
            return true;
        }
    };
    $scope.toggleCroppingBox = function () {
        $("#croppingPopup").toggleClass("active");
        $("#providerImgBg").removeClass("hasImg");
        $("#providerImgBg img").attr("src", "");
        $("#slider-size").slider("value", 100);
        $scope.showMissingImage = false;
        $scope.avatarUploaded = false;
    };
    var UPLOAD_AVATAR_URL = service.getContextPath() + "/Provider/UploadAvatar";
    var TEMP_AVATAR_URL = service.getContextPath() + "/Provider/TemporaryAvatar";
    $scope.avatarUploaded = false;
    $scope.cropExecuting = false;
    var avatarWidth = 0, avatarHeight = 0;
    var _URL = window.URL || window.webkitURL;
    $scope.imageSizeError = false;
    $scope.imageBroken = false;
    $scope.newAvatar = function (croppingImage, errFiles) {
        if (croppingImage) {
            $scope.imageSizeError = false;
            $scope.imageBroken = false;
            $scope.cropExecuting = true;
            $scope.avatarUploaded = false;
            avatarWidth = 0, avatarHeight = 0;
            var oMyForm = new FormData();
            oMyForm.append("providerImage", croppingImage);
            $.ajax({
                url: UPLOAD_AVATAR_URL,
                data: oMyForm,
                dataType: 'text',
                processData: false,
                contentType: false,
                type: 'POST',
                beforeSend: function (jqXHR, settings) {
                    $("#providerImgBg img").attr("src", "");
                    $("#providerImgBg").removeClass("hasImg");
                    $("#providerImgBg").addClass("uploading");
//                    $("#providerImgBg img").attr("src", service.getContextPath() + '/Resources/Theme/image/loading.gif');
                },
                success: function (data) {
                    data = $.parseJSON(data);
                    if (data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else if (data.result === "image broken") {
                        $("#providerImgBg img").attr("src", "");
                        $("#providerImgBg").removeClass("uploading");
                        $scope.cropExecuting = false;
                        $scope.imageBroken = true;
                    } else {
                        var currentTime = new Date().getTime();
                        $("#providerImgBg img").attr("src", TEMP_AVATAR_URL + "?time=" + currentTime);
                        avatarWidth = data.result.width;
                        avatarHeight = data.result.height;
                    }
                }, error: function (respone) {
                    var pageError = service.getContextPath() + service.getErrorPageUrl();
                    $(location).attr('href', pageError);
                }
            });
        } else {
            $scope.imageSizeError = true;
        }
    };
    $("#providerImgBg img").load(function () {
        // then init avatar to default position
        $("#dragableAvatar").css("top", "0");
        $("#dragableAvatar").css("left", "0");
        resizeAvatar(100);
        $("#providerImgBg").addClass("hasImg");
        $("#providerImgBg").removeClass("uploading");
        $("#slider-size").slider("value", 100);
        $scope.avatarUploaded = true;
        $scope.cropExecuting = false;
        $scope.$digest();
    });
//
//    // Crop resize
//    var cropResizer = document.getElementById('resizer');
//    var cropSquare = document.getElementById('cropSquare');
//    cropResizer.addEventListener('mousedown', initResizeableCrop, false);
//
//    function initResizeableCrop(e) {
//        window.addEventListener('mousemove', cropResize, false);
//        window.addEventListener('mouseup', stopResize, false);
//    }
//
//    function cropResize(e) {
//        var width = e.clientX - $("#cropSquare").offset().left;
//        var height = e.clientY - $("#cropSquare").offset().top;
//        if (width > height) {
//            height = width;
//        } else {
//            width = height;
//        }
//
//        // check is inside image
//        var maxHeight = $("#providerImgBg").outerHeight(true);
//        var maxWidth = $("#providerImgBg").outerWidth(true);
//        if (height <= maxHeight && width <= maxWidth && height >= 50 && width >= 50) {
//            cropSquare.style.width = width + 'px';
//            cropSquare.style.height = height + 'px';
//        }
//    }
//
//    function stopResize(e) {
//        window.removeEventListener('mousemove', cropResize, false);
//        window.removeEventListener('mouseup', stopResize, false);
//    }
//
//    // Crop drag
//    var dragger = document.getElementById('drager');
//    dragger.addEventListener('mousedown', initDragger, false);
//
//    function initDragger(e) {
//        window.addEventListener('mousemove', drag, false);
//        window.addEventListener('mouseup', stopDragging, false);
//    }
//
//    function drag(e) {
//        var top = e.clientY - $("#providerImgBg").offset().top - $("#cropSquare").outerHeight(true) / 2;
//        var left = e.clientX - $("#providerImgBg").offset().left - $("#cropSquare").outerWidth(true) / 2;
//
//        var right = left + $("#cropSquare").outerWidth(true);
//        var bottom = top + $("#cropSquare").outerHeight(true);
//        var maxHeight = $("#providerImgBg").outerHeight(true);
//        var maxWidth = $("#providerImgBg").outerWidth(true);
//
//        // check is inside image
//        if (right > maxWidth) {
//            left = maxWidth - $("#cropSquare").outerWidth(true);
//        }
//
//        if (left < 0) {
//            left = 0;
//        }
//
//        if (top < 0) {
//            top = 0;
//        }
//
//        if (bottom > maxHeight) {
//            top = maxHeight - $("#cropSquare").outerHeight(true);
//        }
//        $("#cropSquare").css("top", top + "px");
//        $("#cropSquare").css("left", left + "px");
//    }
//
//    function stopDragging(e) {
//        window.removeEventListener('mousemove', drag, false);
//        window.removeEventListener('mouseup', stopDragging, false);
//    }
//
    $scope.showMissingImage = false;
    var AVATAR_CROP_URL = service.getContextPath() + "/Provider/Avatar/CropAndSave";
    $scope.cropAndSave = function () {
        if ($scope.avatarUploaded) {
            $scope.cropExecuting = true;
            var cropWidth = $("#providerImgBg").outerWidth(true);
            var cropHeight = $("#providerImgBg").outerHeight(true);
            var imageWidth = $("#dragableAvatar").outerWidth(true);
            var imageHeight = $("#dragableAvatar").outerHeight(true);
            var positionX = $("#providerImgBg").offset().left - $("#dragableAvatar").offset().left;
            var positionY = $("#providerImgBg").offset().top - $("#dragableAvatar").offset().top;
            // construct data
            if (positionX < 0) {
                positionX = 0;
            }

            if (positionY < 0) {
                positionY = 0;
            }
            var data = {"positionX": positionX, "positionY": positionY, "width": imageWidth, "height": imageHeight,
                "cropWidth": cropWidth, "cropHeight": cropHeight};
            // if avatar is uploaded then post to scrop and save
            $http.post(AVATAR_CROP_URL, data)
                    .then(function successCallback(response) {
                        if (response.data.result === "error") {
                            var pageError = service.getContextPath() + service.getErrorPageUrl();
                            $(location).attr('href', pageError);
                        } else {
                            $scope.currentTime = new Date().getTime();
                            $scope.accountInfo.image = response.data.result;
                            var imageLink = "/" + $scope.accountInfo.image;
                            $('#avatarImage').attr('src', imageLink + "?time=" + $scope.currentTime);
                            $("#avatarImage").load(function () {
                                // $scope.toggleCroppingBox();
                                $scope.cropExecuting = false;
                            });
                        }
                        $scope.toggleCroppingBox();
                    });
        } else {
            $scope.showMissingImage = true;
        }
    };
    // enable dragable avatar
    var avatar = document.getElementById('disabledDragBg');
    var initMouseX, initMouseY, initImageX, initImageY;
    var oldImageTop, oldImageLeft, oldImageHeight, oldImageWidth;
    avatar.addEventListener("mousedown", initDragableAvatar, false);
    function initDragableAvatar(e) {
        // get position of mouse
        initMouseX = e.clientX;
        initMouseY = e.clientY;
        // get init of image position
        initImageY = $("#dragableAvatar").offset().top - $("#providerImgBg").offset().top;
        initImageX = $("#dragableAvatar").offset().left - $("#providerImgBg").offset().left;
        window.addEventListener('mousemove', avatarDrag, false);
        window.addEventListener('mouseup', stopAvatarDragging, false);
    }

    function avatarDrag(e) {
        var imgBgWidth = $("#providerImgBg").outerWidth(true);
        var imgBgHeight = $("#providerImgBg").outerHeight(true);
        var imgBgPositionX = $("#providerImgBg").offset().left;
        var imgBgPositionY = $("#providerImgBg").offset().top;
        var currentMousePositionX = e.clientX;
        var currentMousePositionY = e.clientY;
        // check mouse inside background
        if (currentMousePositionX >= imgBgPositionX && currentMousePositionX <= (imgBgPositionX + imgBgWidth)
                && currentMousePositionY >= imgBgPositionY && currentMousePositionY <= (imgBgPositionY + imgBgHeight)) {

            var distanceWidth = currentMousePositionX - initMouseX;
            var distanceHeight = currentMousePositionY - initMouseY;
            var maxX = imgBgWidth - $("#dragableAvatar").outerWidth(true);
            var maxY = imgBgHeight - $("#dragableAvatar").outerHeight(true);
            var newPositionTop = initImageY + distanceHeight;
            var newPositionLeft = initImageX + distanceWidth;
            // if outside of range
            if (newPositionTop > 0) {
                newPositionTop = 0;
            }
            if (newPositionTop < maxY) {
                newPositionTop = maxY;
            }
            if (newPositionLeft > 0) {
                newPositionLeft = 0;
            }
            if (newPositionLeft < maxX) {
                newPositionLeft = maxX;
            }

            // assign new position
            $("#dragableAvatar").css("top", newPositionTop);
            $("#dragableAvatar").css("left", newPositionLeft);
        } else {
            stopAvatarDragging();
        }

    }

    function stopAvatarDragging(e) {
        getOldImageInformation();
        window.removeEventListener('mousemove', avatarDrag, false);
        window.removeEventListener('mouseup', stopAvatarDragging, false);
    }

    function resizeAvatar(percentSize) {
        var avatarRatio = avatarHeight / avatarWidth;
        var newWidth = avatarWidth * percentSize / 100;
        var newHeight = newWidth * avatarRatio;
        var bgWidth = $("#providerImgBg").outerWidth(true);
        var bgHeight = $("#providerImgBg").outerHeight(true);
        var bgTop = $("#providerImgBg").offset().top;
        var bgLeft = $("#providerImgBg").offset().left;
        if (newWidth >= bgWidth && newHeight >= bgHeight) {

            var distanceTop = (oldImageHeight - newHeight) / 2;
            var distanceLeft = (oldImageWidth - newWidth) / 2;
            var imgTop = oldImageTop + distanceTop;
            if ((imgTop + newHeight) < (bgTop + bgHeight)) {
                imgTop = oldImageTop + distanceTop * 2;
            }

            imgTop -= bgTop;
            if (imgTop > 0) {
                imgTop = 0;
            }

            var imgLeft = oldImageLeft + distanceLeft;
            if ((imgLeft + newWidth) < (bgLeft + bgWidth)) {
                imgLeft = oldImageLeft + distanceLeft * 2;
            }

            imgLeft -= bgLeft;
            if (imgLeft > 0) {
                imgLeft = 0;
            }

            $("#dragableAvatar").css("top", imgTop);
            $("#dragableAvatar").css("left", imgLeft);
            $("#dragableAvatar").css("width", newWidth + "px");
        }
    }

    function getOldImageInformation() {
        // get old position of image and size of image for resizing
        oldImageTop = $("#dragableAvatar").offset().top;
        oldImageLeft = $("#dragableAvatar").offset().left;
        oldImageHeight = $("#dragableAvatar").outerHeight(true);
        oldImageWidth = $("#dragableAvatar").outerWidth(true);
    }

    $("#slider-size").slider({
        range: "min",
        min: 0,
        max: 100,
        value: 100,
        slide: function (event, ui) {
            resizeAvatar(ui.value);
        },
        start: function (event, ui) {

        },
        stop: function (event, ui) {
            getOldImageInformation();
        }
    });
});
myApp.controller('ProviderPassport', function ($scope, service) {
    $scope.accountInfo = providerInfo;
    $scope.page = page;
    $scope.currentTime = new Date().getTime();
    $scope.reload = function ()
    {
        location.reload();
    };
    $scope.$watch('providerImage', function (newVal, oldVal) {
        if ($scope.providerImage !== undefined && $scope.providerImage !== null) {
            $scope.uploadProviderImage($scope.providerImage);
        }
    });
    $scope.uploadProviderImage = function (providerImage) {
        var oMyForm = new FormData();
        oMyForm.append("providerImage", providerImage);
        oMyForm.append("providerID", $scope.accountInfo.providerID);
        $.ajax({
            url: uploadUrl,
            data: oMyForm,
            dataType: 'text',
            processData: false,
            contentType: false,
            type: 'POST',
            beforeSend: function (jqXHR, settings) {
                $scope.accountInfo.image = '/Images/Icon/loading.gif';
                // $scope.$digest();
            },
            success: function (data) {
                if (data === "error") {
                    var pageError = service.getContextPath() + service.getErrorPageUrl();
                    $(location).attr('href', pageError);
                } else {
                    $scope.currentTime = new Date().getTime();
                    $scope.accountInfo.image = data;
                    $("#dLabel img").attr("src", "/" + $scope.accountInfo.image + "?time=" + $scope.currentTime);
                    $scope.$digest();
                }

            }, error: function (respone) {
                var pageError = service.getContextPath() + service.getErrorPageUrl();
                $(location).attr('href', pageError);
            }

        });
    };
    $scope.validateForm = function (event) {
        if (!$scope.accountInfo.firstName.length || !$scope.accountInfo.name.length) {
            event.preventDefault();
        } else {
            return true;
        }
    };
});
myApp.controller('TripperInfo', function ($scope, service, $timeout, $http) {
    $scope.accountInfo = tripperInfo;
    $scope.page = page;
    $scope.items = countryList;
    $scope.currentTime = new Date().getTime();
    for (var i = 0; i < $scope.items.length; i++) {
        if ($scope.accountInfo.countryName === $scope.items[i].name) {
            $scope.selected = $scope.items[i];
        }
    }
    $scope.$watch('tripperImage', function (newVal, oldVal) {
        if ($scope.tripperImage !== undefined && $scope.tripperImage !== null) {
            $scope.uploadTripperImage($scope.tripperImage);
        }
    });
    $scope.uploadTripperImage = function (providerImage) {
        var oMyForm = new FormData();
        oMyForm.append("providerImage", providerImage);
        oMyForm.append("providerID", $scope.accountInfo.providerID);
        $.ajax({
            url: uploadUrl,
            data: oMyForm,
            dataType: 'text',
            processData: false,
            contentType: false,
            type: 'POST',
            beforeSend: function (jqXHR, settings) {
                $scope.accountInfo.image = '/Images/Icon/loading.gif';
                $scope.$digest();
            },
            success: function (data) {
                if (data === "error") {
                    var pageError = service.getContextPath() + service.getErrorPageUrl();
                    $(location).attr('href', pageError);
                } else {
                    $scope.currentTime = new Date().getTime();
                    $scope.accountInfo.image = data;
                    $("#dLabel img").attr("src", "/" + $scope.accountInfo.image + "?time=" + $scope.currentTime);
                    var imageLink = $('#avatarImage').attr('src');
                    $('#avatarImage').attr('src', imageLink + "?" + (+new Date()));
                    $scope.$digest();
                }
            }, error: function (respone) {
                var pageError = service.getContextPath() + service.getErrorPageUrl();
                $(location).attr('href', pageError);
            }
        });
    };
    $scope.showError = false;
    $scope.validateForm = function (event) {
        if (!$scope["tripperForm"].$valid || !$scope.accountInfo.firstName.length || !$scope.accountInfo.name.length || $scope.accountInfo.firstName.length > 15 || $scope.accountInfo.name.length > 15) {
            $scope.showError = true;
            event.preventDefault();
        } else {
            return true;
        }
    }
//    $scope.uploadTripperImage = function (tripperImage) {
//        var oMyForm = new FormData();
//        oMyForm.append("tripperImage", tripperImage);
//        oMyForm.append("tripperID", $scope.accountInfo.tripperID);
//        $.ajax({
//            url: uploadUrl,
//            data: oMyForm,
//            dataType: 'text',
//            processData: false,
//            contentType: false,
//            type: 'POST',
//            beforeSend: function (jqXHR, settings) {
//                $scope.accountInfo.image = 'Resources/Theme/image/loading.gif';
//                $scope.$digest();
//            },
//            success: function (data) {
//                if (data === "error") {
//                    var pageError = service.getContextPath() + service.getErrorPageUrl();
//                    $(location).attr('href', pageError);
//                } else {
//                    $scope.currentTime = new Date().getTime();
//                    $scope.accountInfo.image = data;
//                    $("#dLabel img").attr("src", "/" + $scope.accountInfo.image + "?time=" + $scope.currentTime);
//                    $scope.$digest();
//                }
//            }, error: function (respone) {
//                var pageError = service.getContextPath() + service.getErrorPageUrl();
//                $(location).attr('href', pageError);
//            }
//        });
//    };
//        $("#tripperPhone").keydown(function (e) {
//        if (e.shiftKey || e.ctrlKey || e.altKey) { // if shift, ctrl or alt keys held down
//            e.preventDefault();         // Prevent character input
//        } else {
//            var n = e.keyCode;
//            if (!((n === 8)              // backspace
//                    || (n === 46)                // delete
//                    || (n >= 35 && n <= 40)     // arrow keys/home/end
//                    || (n >= 48 && n <= 57)     // numbers on keyboard
//                    || (n >= 96 && n <= 105))   // number on keypad
//                    ) {
//                e.preventDefault();
//                // alert("in if");
//                // Prevent character input
//            }
//        }
//    });
    $scope.toggleCroppingBox = function () {
        $("#croppingPopup").toggleClass("active");
        $("#providerImgBg").removeClass("hasImg");
        $("#providerImgBg img").attr("src", "");
        $("#slider-size").slider("value", 100);
        $scope.showMissingImage = false;
        $scope.avatarUploaded = false;
    };
    var UPLOAD_AVATAR_URL = service.getContextPath() + "/Tripper/UploadAvatar";
    var TEMP_AVATAR_URL = service.getContextPath() + "/Tripper/TemporaryAvatar";
    $scope.avatarUploaded = false;
    $scope.cropExecuting = false;
    var avatarWidth = 0, avatarHeight = 0;
    var _URL = window.URL || window.webkitURL;
    $scope.imageSizeError = false;
    $scope.newAvatar = function (croppingImage, errFiles) {
        if (croppingImage) {
            $scope.imageSizeError = false;
            $scope.imageBroken = false;
            $scope.cropExecuting = true;
            $scope.avatarUploaded = false;
            avatarWidth = 0, avatarHeight = 0;
            var oMyForm = new FormData();
            oMyForm.append("providerImage", croppingImage);
            $.ajax({
                url: UPLOAD_AVATAR_URL,
                data: oMyForm,
                dataType: 'text',
                processData: false,
                contentType: false,
                type: 'POST',
                beforeSend: function (jqXHR, settings) {
                    $("#providerImgBg img").attr("src", "");
                    $("#providerImgBg").removeClass("hasImg");
                    $("#providerImgBg").addClass("uploading");
//                    $("#providerImgBg img").attr("src", service.getContextPath() + '/Resources/Theme/image/loading.gif');
                },
                success: function (data) {
                    data = $.parseJSON(data);
                    if (data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else if (data.result === "image broken") {
                        $("#providerImgBg img").attr("src", "");
                        $("#providerImgBg").removeClass("uploading");
                        $scope.cropExecuting = false;
                        $scope.imageBroken = true;
                    } else {
                        var currentTime = new Date().getTime();
                        $("#providerImgBg img").attr("src", TEMP_AVATAR_URL + "?time=" + currentTime);
                        avatarWidth = data.result.width;
                        avatarHeight = data.result.height;
                    }
                }, error: function (respone) {
                    var pageError = service.getContextPath() + service.getErrorPageUrl();
                    $(location).attr('href', pageError);
                }
            });
        } else {
            $scope.imageSizeError = true;
        }
    };
    $("#providerImgBg img").load(function () {
        // then init avatar to default position
        $("#dragableAvatar").css("top", "0");
        $("#dragableAvatar").css("left", "0");
        resizeAvatar(100);
        $("#providerImgBg").addClass("hasImg");
        $("#providerImgBg").removeClass("uploading");
        $("#slider-size").slider("value", 100);
        $scope.avatarUploaded = true;
        $scope.cropExecuting = false;
        $scope.$digest();
    });
//
//    // Crop resize
//    var cropResizer = document.getElementById('resizer');
//    var cropSquare = document.getElementById('cropSquare');
//    cropResizer.addEventListener('mousedown', initResizeableCrop, false);
//
//    function initResizeableCrop(e) {
//        window.addEventListener('mousemove', cropResize, false);
//        window.addEventListener('mouseup', stopResize, false);
//    }
//
//    function cropResize(e) {
//        var width = e.clientX - $("#cropSquare").offset().left;
//        var height = e.clientY - $("#cropSquare").offset().top;
//        if (width > height) {
//            height = width;
//        } else {
//            width = height;
//        }
//
//        // check is inside image
//        var maxHeight = $("#providerImgBg").outerHeight(true);
//        var maxWidth = $("#providerImgBg").outerWidth(true);
//        if (height <= maxHeight && width <= maxWidth && height >= 50 && width >= 50) {
//            cropSquare.style.width = width + 'px';
//            cropSquare.style.height = height + 'px';
//        }
//    }
//
//    function stopResize(e) {
//        window.removeEventListener('mousemove', cropResize, false);
//        window.removeEventListener('mouseup', stopResize, false);
//    }
//
//    // Crop drag
//    var dragger = document.getElementById('drager');
//    dragger.addEventListener('mousedown', initDragger, false);
//
//    function initDragger(e) {
//        window.addEventListener('mousemove', drag, false);
//        window.addEventListener('mouseup', stopDragging, false);
//    }
//
//    function drag(e) {
//        var top = e.clientY - $("#providerImgBg").offset().top - $("#cropSquare").outerHeight(true) / 2;
//        var left = e.clientX - $("#providerImgBg").offset().left - $("#cropSquare").outerWidth(true) / 2;
//
//        var right = left + $("#cropSquare").outerWidth(true);
//        var bottom = top + $("#cropSquare").outerHeight(true);
//        var maxHeight = $("#providerImgBg").outerHeight(true);
//        var maxWidth = $("#providerImgBg").outerWidth(true);
//
//        // check is inside image
//        if (right > maxWidth) {
//            left = maxWidth - $("#cropSquare").outerWidth(true);
//        }
//
//        if (left < 0) {
//            left = 0;
//        }
//
//        if (top < 0) {
//            top = 0;
//        }
//
//        if (bottom > maxHeight) {
//            top = maxHeight - $("#cropSquare").outerHeight(true);
//        }
//        $("#cropSquare").css("top", top + "px");
//        $("#cropSquare").css("left", left + "px");
//    }
//
//    function stopDragging(e) {
//        window.removeEventListener('mousemove', drag, false);
//        window.removeEventListener('mouseup', stopDragging, false);
//    }
//
    $scope.showMissingImage = false;
    var AVATAR_CROP_URL = service.getContextPath() + "/Tripper/Avatar/CropAndSave";
    $scope.cropAndSave = function () {
        if ($scope.avatarUploaded) {
            $scope.cropExecuting = true;
            var cropWidth = $("#providerImgBg").outerWidth(true);
            var cropHeight = $("#providerImgBg").outerHeight(true);
            var imageWidth = $("#dragableAvatar").outerWidth(true);
            var imageHeight = $("#dragableAvatar").outerHeight(true);
            var positionX = $("#providerImgBg").offset().left - $("#dragableAvatar").offset().left;
            var positionY = $("#providerImgBg").offset().top - $("#dragableAvatar").offset().top;
            // construct data
            if (positionX < 0) {
                positionX = 0;
            }

            if (positionY < 0) {
                positionY = 0;
            }
            var data = {"positionX": positionX, "positionY": positionY, "width": imageWidth, "height": imageHeight,
                "cropWidth": cropWidth, "cropHeight": cropHeight};
            // if avatar is uploaded then post to scrop and save
            $http.post(AVATAR_CROP_URL, data)
                    .then(function successCallback(response) {
                        if (response.data.result === "error") {
                            var pageError = service.getContextPath() + service.getErrorPageUrl();
                            $(location).attr('href', pageError);
                        } else {
                            // alert("fuck");

                            $scope.currentTime = new Date().getTime();
                            $scope.accountInfo.image = response.data.result;
                            var imageLink = "/" + $scope.accountInfo.image;
                            $('#avatarImage').attr('src', imageLink + "?time=" + $scope.currentTime);
                            $("#avatarImage").load(function () {
                                // $scope.toggleCroppingBox();
                                $scope.cropExecuting = false;
                            });
                        }
                        $scope.toggleCroppingBox();
                    });
        } else {
            $scope.showMissingImage = true;
        }
    };
    // enable dragable avatar
    var avatar = document.getElementById('disabledDragBg');
    var initMouseX, initMouseY, initImageX, initImageY;
    var oldImageTop, oldImageLeft, oldImageHeight, oldImageWidth;
    avatar.addEventListener("mousedown", initDragableAvatar, false);
    function initDragableAvatar(e) {
        // get position of mouse
        initMouseX = e.clientX;
        initMouseY = e.clientY;
        // get init of image position
        initImageY = $("#dragableAvatar").offset().top - $("#providerImgBg").offset().top;
        initImageX = $("#dragableAvatar").offset().left - $("#providerImgBg").offset().left;
        window.addEventListener('mousemove', avatarDrag, false);
        window.addEventListener('mouseup', stopAvatarDragging, false);
    }

    function avatarDrag(e) {
        var imgBgWidth = $("#providerImgBg").outerWidth(true);
        var imgBgHeight = $("#providerImgBg").outerHeight(true);
        var imgBgPositionX = $("#providerImgBg").offset().left;
        var imgBgPositionY = $("#providerImgBg").offset().top;
        var currentMousePositionX = e.clientX;
        var currentMousePositionY = e.clientY;
        // check mouse inside background
        if (currentMousePositionX >= imgBgPositionX && currentMousePositionX <= (imgBgPositionX + imgBgWidth)
                && currentMousePositionY >= imgBgPositionY && currentMousePositionY <= (imgBgPositionY + imgBgHeight)) {

            var distanceWidth = currentMousePositionX - initMouseX;
            var distanceHeight = currentMousePositionY - initMouseY;
            var maxX = imgBgWidth - $("#dragableAvatar").outerWidth(true);
            var maxY = imgBgHeight - $("#dragableAvatar").outerHeight(true);
            var newPositionTop = initImageY + distanceHeight;
            var newPositionLeft = initImageX + distanceWidth;
            // if outside of range
            if (newPositionTop > 0) {
                newPositionTop = 0;
            }
            if (newPositionTop < maxY) {
                newPositionTop = maxY;
            }
            if (newPositionLeft > 0) {
                newPositionLeft = 0;
            }
            if (newPositionLeft < maxX) {
                newPositionLeft = maxX;
            }

            // assign new position
            $("#dragableAvatar").css("top", newPositionTop);
            $("#dragableAvatar").css("left", newPositionLeft);
        } else {
            stopAvatarDragging();
        }

    }

    function stopAvatarDragging(e) {
        getOldImageInformation();
        window.removeEventListener('mousemove', avatarDrag, false);
        window.removeEventListener('mouseup', stopAvatarDragging, false);
    }

    function resizeAvatar(percentSize) {
        var avatarRatio = avatarHeight / avatarWidth;
        var newWidth = avatarWidth * percentSize / 100;
        var newHeight = newWidth * avatarRatio;
        var bgWidth = $("#providerImgBg").outerWidth(true);
        var bgHeight = $("#providerImgBg").outerHeight(true);
        var bgTop = $("#providerImgBg").offset().top;
        var bgLeft = $("#providerImgBg").offset().left;
        if (newWidth >= bgWidth && newHeight >= bgHeight) {

            var distanceTop = (oldImageHeight - newHeight) / 2;
            var distanceLeft = (oldImageWidth - newWidth) / 2;
            var imgTop = oldImageTop + distanceTop;
            if ((imgTop + newHeight) < (bgTop + bgHeight)) {
                imgTop = oldImageTop + distanceTop * 2;
            }

            imgTop -= bgTop;
            if (imgTop > 0) {
                imgTop = 0;
            }

            var imgLeft = oldImageLeft + distanceLeft;
            if ((imgLeft + newWidth) < (bgLeft + bgWidth)) {
                imgLeft = oldImageLeft + distanceLeft * 2;
            }

            imgLeft -= bgLeft;
            if (imgLeft > 0) {
                imgLeft = 0;
            }

            $("#dragableAvatar").css("top", imgTop);
            $("#dragableAvatar").css("left", imgLeft);
            $("#dragableAvatar").css("width", newWidth + "px");
        }
    }

    function getOldImageInformation() {
        // get old position of image and size of image for resizing
        oldImageTop = $("#dragableAvatar").offset().top;
        oldImageLeft = $("#dragableAvatar").offset().left;
        oldImageHeight = $("#dragableAvatar").outerHeight(true);
        oldImageWidth = $("#dragableAvatar").outerWidth(true);
    }

    $("#slider-size").slider({
        range: "min",
        min: 0,
        max: 100,
        value: 100,
        slide: function (event, ui) {
            resizeAvatar(ui.value);
        },
        start: function (event, ui) {

        },
        stop: function (event, ui) {
            getOldImageInformation();
        }
    });
});
myApp.controller('RouteController', function ($scope, $location, service, $interval) {
    $scope.fromHomePage = fromHomePage;

    $scope.initHeader = function () {
        if ($("nav.navbar").hasClass("navbar-light")) {
            $("nav.navbar").removeClass("navbar-light");
            $("nav.navbar").addClass("navbar-dark");
        }
    };
    $scope.initHeader();

    var sliderWorking = true;
    var isEnableToClick = true;
    function nextRecommendSlider() {
        isEnableToClick = false;
        var left = parseInt($("#recommendSlider .slider-data").css("left"), 10);
        if (left < 0) {
            $("#recommendSlider .slider-data").removeClass("hasAnimation");
            $("#recommendSlider .slider-data li:nth-child(1),#recommendSlider .slider-data li:nth-child(2),#recommendSlider .slider-data li:nth-child(3), #recommendSlider .slider-data li:nth-child(4)")
                    .appendTo("#recommendSlider .slider-data");
            $("#recommendSlider .slider-data").css("left", 0);
        }
        setTimeout(function () {
            $("#recommendSlider .slider-data").addClass("hasAnimation");
            $("#recommendSlider .slider-data").css("left", -960);
            isEnableToClick = true;
        }, 100);
    }

    function backRecommendSlider() {
        isEnableToClick = false;
        var left = parseInt($("#recommendSlider .slider-data").css("left"), 10);
        if (left >= 0) {
            $("#recommendSlider .slider-data").removeClass("hasAnimation");
            $("#recommendSlider .slider-data li:nth-child(5),#recommendSlider .slider-data li:nth-child(6),#recommendSlider .slider-data li:nth-child(7), #recommendSlider .slider-data li:nth-child(8)")
                    .prependTo("#recommendSlider .slider-data");
            $("#recommendSlider .slider-data").css("left", -960);
        }
        setTimeout(function () {
            $("#recommendSlider .slider-data").addClass("hasAnimation");
            $("#recommendSlider .slider-data").css("left", 0);
            isEnableToClick = true;
        }, 100);
    }


    $scope.clickToNextRecommendSlider = function () {
        if (isEnableToClick) {
            nextRecommendSlider();
        }
    };

    $scope.clickToBackRecommendSlider = function () {
        if (isEnableToClick) {
            backRecommendSlider();
        }
    };

    $scope.stopRecommendSlider = function () {
        sliderWorking = false;
    };

    $scope.runRecommendSlider = function () {
        sliderWorking = true;
    };

    $interval(function () {
        if (sliderWorking) {
            nextRecommendSlider();
        }
    }, 5000);

    var newestSliderWorking = true;
    var isEnableToClickNewest = true;
    var $newestSlider = $("#latest-packages .slider .slider-data");
    function nextNewestSlider() {
        isEnableToClickNewest = false;
        var left = parseInt($newestSlider.css("left"), 10);
        if (left < 0) {
            $newestSlider.removeClass("hasAnimation");
            $("#latest-packages .slider .slider-data li:nth-child(1),#latest-packages .slider .slider-data li:nth-child(2),#latest-packages .slider .slider-data li:nth-child(3)")
                    .appendTo($newestSlider);
            $newestSlider.css("left", 0);
        }
        setTimeout(function () {
            $newestSlider.addClass("hasAnimation");
            $newestSlider.css("left", -715);
            isEnableToClickNewest = true;
        }, 100);
    }

    function backNewestSlider() {
        isEnableToClickNewest = false;
        var left = parseInt($newestSlider.css("left"), 10);
        if (left >= 0) {
            $newestSlider.removeClass("hasAnimation");
            $("#latest-packages .slider .slider-data li:nth-child(4),#latest-packages .slider .slider-data li:nth-child(5),#latest-packages .slider .slider-data li:nth-child(6)")
                    .prependTo($newestSlider);
            $newestSlider.css("left", -715);
        }
        setTimeout(function () {
            $newestSlider.addClass("hasAnimation");
            $newestSlider.css("left", 0);
            isEnableToClickNewest = true;
        }, 100);
    }

    $scope.clickToNextNewestSlider = function () {
        if (isEnableToClickNewest) {
            nextNewestSlider();
        }
    };

    $scope.clickToBackNewestSlider = function () {
        if (isEnableToClickNewest) {
            backNewestSlider();
        }
    };

    $scope.stopNewestSlider = function () {
        newestSliderWorking = false;
    };

    $scope.ruNewestSlider = function () {
        newestSliderWorking = true;
    };

    $interval(function () {
        if (newestSliderWorking) {
            nextNewestSlider();
        }
    }, 5000);

// regex only letters
    var regexInput = /^[a-zA-Z\s]+$/;

    $scope.temValue = "";
    $scope.changeInputTop = function (newVal) {
        $scope.temValue = newVal;
    };
});
myApp.controller('HomePageController', function ($scope, service) {
    this.name = "smart";
//    this.params = $routeParams;

    $scope.locationList = [
        {ID: '930011', Title: 'Thái Lan'},
        {ID: '930009', Title: 'Việt Nam'},
        {ID: '930019', Title: 'Philippin'}
    ];
    $scope.initSlider = function () {
        $('#top-activity-slider').lightSlider({
            auto: true,
            adaptiveHeight: true,
            item: 1,
            slideMargin: 0,
            loop: true
        });
    };
    if (window.innerWidth <= 500) {
        $scope.initSlider();
    }

//    $scope.initThnumnailScroller = function () {
//        $("#locations-1").length && $("#locations-1").mThumbnailScroller({theme: "hover-classic"});
//    };

//    $scope.initThnumnailScroller();
//    $scope.$watch('homeSearchTxt', function (newVal, oldVal) {
//        if (newVal !== oldVal) {
//            $location.path(service.getContextPath() + "/SmartSearch/" + newVal);
//        }
//    });


});
myApp.controller('SmartSearchController', function ($scope, $q, service, $http) {

    /* DEVELOPING BOX */
    $scope.toggleDevelopingBox = function () {
        $("#developingBox").toggleClass("active");
    };
    /* END DEVELOPING BOX */

    $scope.initPriceSlider = function () {
//        $("#priceRange").slider("destroy");

        $("#priceRange").slider({
            range: true,
            min: $scope.minPrice,
            max: $scope.maxPrice,
            values: [$scope.minPrice, $scope.maxPrice],
            slide: function (event, ui) {
                //                                                                $("#amount").val("$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ]);
                $("#priceRange").find(".ui-slider-handle").first().html("$" + ui.values[ 0 ]);
                $("#priceRange").find(".ui-slider-handle").last().html("$" + ui.values[ 1 ]);
            },
            create: function (event, ui) {
                $("#priceRange").find(".ui-slider-handle").first().html("$" + $scope.minPrice);
                $("#priceRange").find(".ui-slider-handle").last().html("$" + $scope.maxPrice);
            },
            stop: function (event, ui) {
                $scope.packagesLoaded = false;
                $scope.$digest();
                $scope.searchFunction();
            }
        });
//        $("#rateFilter").raty({
//            starOff: service.getContextPath() + '/Resources/Theme/image/greystar.svg',
//            starOn: service.getContextPath() + '/Resources/Theme/image/yelstar.svg',
//            click: function (score, evt) {
//                $scope.searchFunction();
//            }
//        });
    };
    // init calendar
    Date.prototype.MMddyyyy = function () {
        var yyyy = this.getFullYear().toString();
        var mm = (this.getMonth() + 1).toString(); // getMonth() is zero-based
        var dd = this.getDate().toString();
        return  (mm[1] ? mm : "0" + mm[0]) + "/" + (dd[1] ? dd : "0" + dd[0]) + "/" + yyyy; // padding
    };
    $scope.initBookingCalendar = function () {
        Calendar = new Date();
        $("#calendarFilter").datepicker({
            defaultDate: "+1w",
            minDate: Calendar.MMddyyyy(), onClose: function (selectedDate) {
                $scope.selectedDate = selectedDate;
                $scope.$digest();
            }
        });
    };

});
myApp.controller('MatrixSmartSearchController', function ($scope, $routeParams, $location, $q, service, $http) {
    $scope.subCate = subCate;
    $scope.location = locate;
    $scope.smartSearchText = "";
    $scope.updateSmartSearch = function (txtSearch) {
        $scope.smartSearchText = txtSearch;
    };
    $scope.updateHeader = function () {

        $("#routeDiv").addClass("pagesearch");
        if (!$(".search-input").hasClass("show-control-search")) {
            $(".search-input").addClass("show-control-search");
        }

        if ($("nav.navbar").hasClass("navbar-dark")) {
            $("nav.navbar").removeClass("navbar-dark");
            $("nav.navbar").addClass("navbar-light");
        }

    };
    $scope.updateButton = function () {
//        $('.more-fillter').click(function () {
//            if (!$('.fillter-hide').is(":visible")) {
//                $('.more-fillter').hide();
//                $('.search-step1').hide();
//                $('.fillter-hide').show();
//            }
//        });
        $('#filter-cancel').click(function () {
            if ($(".page-search").hasClass("filters-open")) {
                $(".page-search").removeClass("filters-open");
            }
            if ($('.fillter-hide').is(":visible")) {
                $('.more-fillter').show();
                $('.search-step1').show();
                $('.fillter-hide').hide();
            }
        });
    };
    $scope.initPriceSlider = function () {
//        $("#priceRange").slider("destroy");

        $("#priceRange").slider({
            range: true,
            min: $scope.minPrice,
            max: $scope.maxPrice,
            values: [$scope.minPrice, $scope.maxPrice],
            slide: function (event, ui) {
                //                                                                $("#amount").val("$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ]);
                $("#priceRange").find(".ui-slider-handle").first().html("$" + ui.values[ 0 ]);
                $("#priceRange").find(".ui-slider-handle").last().html("$" + ui.values[ 1 ]);
            },
            create: function (event, ui) {
                $("#priceRange").find(".ui-slider-handle").first().html("$" + $scope.minPrice);
                $("#priceRange").find(".ui-slider-handle").last().html("$" + $scope.maxPrice);
            },
            stop: function (event, ui) {
                $scope.packagesLoaded = false;
                $scope.$digest();
                $scope.searchFunction();
            }
        });
    };
    // init calendar
    Date.prototype.MMddyyyy = function () {
        var yyyy = this.getFullYear().toString();
        var mm = (this.getMonth() + 1).toString(); // getMonth() is zero-based
        var dd = this.getDate().toString();
        return  (mm[1] ? mm : "0" + mm[0]) + "/" + (dd[1] ? dd : "0" + dd[0]) + "/" + yyyy; // padding
    };
    $scope.initBookingCalendar = function () {
        Calendar = new Date();
        $("#calendarFilter").datepicker({
            defaultDate: "+1w",
            minDate: Calendar.MMddyyyy(), onClose: function (selectedDate) {
                $scope.selectedDate = selectedDate;
                $scope.$digest();
            }
        });
    };
    $scope.loadingScroll = false;
    $scope.isAll = false;
    $scope.detectScrollToBottom = function () {// load more package when scroll to bottom
        $(window).bind('scroll', function ()
        {
            // no load when all packages is loaded and when is loading
            if (($(window).scrollTop() + $(window).height() === $(document).height()) && !$scope.isAll) {
                $scope.loadingScroll = true;
                $scope.pageNumber++;
                $scope.$digest();
            }
//            if ($(this).scrollTop() + $(this).innerHeight() >= $(this)[0].scrollHeight && !$scope.loadingScroll) {
//
//            }

        });
    };
    $scope.detectScrollToBottom();
    $scope.updateHeader();
    $scope.updateButton();
    $scope.pageSize = $("#rowsPage").val();
    $scope.loading = false;
    $scope.currentPage = 1;
    $scope.total = 0;
    $scope.hideIfEmpty = true;
    $scope.ulClass = 'pagination';
    $scope.adjacent = 1;
    $scope.activeClass = 'active';
    $scope.disabledClass = 'disabled';
    $scope.showPrevNext = true;
//    $scope.DoCtrlPagingAct = function (text, page, pageSize, total) {
//        $('html, body').animate({
//            scrollTop: 0
//        }, 300);
//        $scope.currentPage = page;
//        $scope.searchFunction();
//    };

    $scope.$watch('packages', function (newVal, oldVal) {
        if (newVal !== oldVal) {
            if (newVal.length > 0) {
                $scope.total = newVal[0].totalRecords;
            } else {
                $scope.total = 0;
            }
        }
    });
    $scope.packagesLoaded = false;
    $scope.packages = [];
    $scope.suggestion;
    // detect for live search
    var searchUrl = service.getContextPath() + "/MatrixSmartSearch";
    $scope.initParam = function () {// initiate filter param
        $scope.sortType = 3;
        $scope.tripTypeIDs = [];
        $scope.groupTypeIDs = "";
        $scope.servingType = [];
        $scope.language = "";
        $scope.duration = [];
        $scope.selectedDate = "";
        $scope.numberTripper = 0;
        $scope.pageNumber = 1;
        $scope.minPrice = 0;
        $scope.maxPrice = 1000;
        $scope.initBookingCalendar();
        $scope.initPriceSlider();
        $("#priceRange").find(".ui-slider-handle").first().html("$" + $scope.minPrice);
        $("#priceRange").find(".ui-slider-handle").last().html("$" + $scope.maxPrice);
    };
    $scope.initParam();
    $scope.$watch('sortType', function (newVal, oldVal) {
        if (newVal !== oldVal) {
            $scope.packagesLoaded = false;
            $scope.searchFunction();
        }
    }, true);
    $scope.$watch('pageNumber', function (newVal, oldVal) {
        if (newVal !== oldVal) {
//            $scope.packagesLoaded = false;
            $scope.searchFunction();
        }
    }, true);
    $scope.$watch('numberTripper', function (newVal, oldVal) {
        if (newVal !== oldVal) {
            $scope.packagesLoaded = false;
            $scope.searchFunction();
        }
    }, true);
    $scope.$watch('selectedDate', function (newVal, oldVal) {
        if (newVal !== oldVal) {
            $scope.packagesLoaded = false;
            $scope.searchFunction();
        }
    }, true);
    $scope.$watch('tripTypeIDs', function (newVal, oldVal) {
        if (newVal !== oldVal) {
            $scope.packagesLoaded = false;
            $scope.searchFunction();
        }
    }, true);
    $scope.$watch('duration', function (newVal, oldVal) {
        if (newVal !== oldVal) {
            $scope.packagesLoaded = false;
            $scope.searchFunction();
        }
    }, true);
    $scope.$watch('groupTypeIDs', function (newVal, oldVal) {
        if (newVal !== oldVal) {
            $scope.packagesLoaded = false;
            $scope.searchFunction();
        }
    }, true);
    $scope.$watch('servingType', function (newVal, oldVal) {
        if (newVal !== oldVal) {
            $scope.packagesLoaded = false;
            $scope.searchFunction();
        }
    }, true);
    $scope.$watch('language', function (newVal, oldVal) {
        if (newVal !== oldVal) {
            $scope.packagesLoaded = false;
            $scope.searchFunction();
        }
    }, true);
    //
    var pending = false;
    var deferred = $q.defer();
    $scope.searchFunction = function () {
//            $scope.packagesLoaded = false;
        if (pending) {
            deferred.resolve();
            deferred = $q.defer();
        }
        pending = true;
        var minPrice = $("#priceRange").slider("values", 0);
        var maxPrice = $("#priceRange").slider("values", 1);
        var rate = $('#rateFilter').raty('score');
        if (rate === null || rate === undefined) {
            rate = 0;
        }

        var trips = "";
        $scope.tripTypeIDs.length > 0 ? trips += $scope.tripTypeIDs[0] : 0;
        for (var i = 1; i < $scope.tripTypeIDs.length; i++) {
            trips += "," + $scope.tripTypeIDs[i];
        }

        var servings = "";
        $scope.servingType.length > 0 ? servings += $scope.servingType[0] : 0;
        for (var i = 1; i < $scope.servingType.length; i++) {
            servings += "," + $scope.servingType[i];
        }

        var minDuration = "";
        var maxDuration = "";
        var durationType = "";
        if ($scope.duration.length > 0) {
            minDuration += $scope.duration[0].minDuration;
            maxDuration += $scope.duration[0].maxDuration;
            durationType += $scope.duration[0].durationType;
            for (var i = 1, max = $scope.duration.length; i < max; i++) {
                minDuration += "," + $scope.duration[i].minDuration;
                maxDuration += "," + $scope.duration[i].maxDuration;
                durationType += "," + $scope.duration[i].durationType;
            }
        }

        var searchText = $scope.smartSearchText.replace(/\s\s+/g, ' ');
        var data = {"searchText": searchText, "trips": trips, "groups": $scope.groupTypeIDs,
            "language": $scope.language, "minPrice": minPrice, "maxPrice": maxPrice, "pageNumber": $scope.pageNumber,
            "minDuration": minDuration, "maxDuration": maxDuration, "durationType": durationType, "servingType": servings,
            "date": $scope.selectedDate, "noTripper": $scope.numberTripper, "sortType": $scope.sortType, 'city': $scope.placeNearMe.City,
            'lat': $scope.placeNearMe.Lat, 'lng': $scope.placeNearMe.Lng, "location": $scope.location, "subCate": $scope.subCate};
        $http.post(searchUrl, data, {timeout: deferred.promise})
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        if (typeof response.data === "object" && response.data instanceof Array) {
                            if ($scope.packages.length === response.data.length) {
                                $scope.isAll = true;
                            }
                            $scope.packages = response.data;
                            $scope.suggestion = {};
                        } else {
                            // set new data
                            $scope.isAll = true;
                            $scope.packages = [];
                            $scope.suggestion = response.data;
                            $('html, body').animate({
                                scrollTop: 0
                            }, 300);
                        }
                        pending = false;
                        deferred = $q.defer();
                        // packagesLoaded
                        $scope.packagesLoaded = true;
                        // enable for ajax
                        $scope.loadingScroll = false;
                    }
                });
    };
    $scope.$watch('smartSearchText', function (newVal, oldVal) {
        if (newVal !== "") {
            $scope.isAll = false;
            $scope.packagesLoaded = false;
            $scope.searchFunction();
        }
    });
    $scope.placeNearMe = {'City': '', 'Lat': 0, 'Lng': 0}; // to pass the location paremeter to smart search.
    //detect place near me
    $scope.$watch('placeNearMe', function (newVal, oldVal) {
        if (newVal !== oldVal) {
            $scope.packagesLoaded = false;
            $scope.searchFunction();
        }
    }, true);
    //get Location
    $scope.myQueryResult;
    $scope.myCity;
    $scope.myIP;
    $scope.myLat;
    $scope.myLng;
    $scope.getCurrentCity = function () {
        $http.get("https://api.ipify.org")
                .success(function (response) {
                    $scope.myIP = response;
                    $http.get("https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20html%20where%20url%3D'http%3A%2F%2Fwhatismyipaddress.com%2Fip%2F" + $scope.myIP + "'%20and%20xpath%3D'%2Fhtml%2Fbody%2Fdiv%5B1%5D%2Fdiv%2Fdiv%2Fdiv%5B4%5D%2Fdiv%5B2%5D%2Fdiv%5B2%5D%2Ftable%2Ftbody%2Ftr'&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys")
                            .success(function (response) {
                                $scope.myQueryResult = response;
                                if ($scope.myQueryResult.query.results === null) {
                                    console.log('Network error please retry');
                                } else {
                                    for (var i = 0; i < $scope.myQueryResult.query.results.tr.length; i++) {
                                        if ($scope.myQueryResult.query.results.tr[i].th === 'State/Region:') {
                                            $scope.myCity = $scope.myQueryResult.query.results.tr[i].td;
                                        }
                                        if ($scope.myQueryResult.query.results.tr[i].th === 'Latitude:') {
                                            $scope.result = ($scope.myQueryResult.query.results.tr[i].td);
                                            $scope.myLat = $scope.result.split(/(\s+)/)[2].trim();
                                        }
                                        if ($scope.myQueryResult.query.results.tr[i].th === 'Longitude:') {
                                            $scope.result = ($scope.myQueryResult.query.results.tr[i].td);
                                            $scope.myLng = $scope.result.split(/(\s+)/)[2].trim();
                                        }
                                    }
                                    var data = {'City': $scope.myCity, 'Lat': $scope.myLat, 'Lng': $scope.myLng};
                                    $scope.placeNearMe = data;
                                }
                            });
                });
    };
    //detect place near me or not
    $scope.$watch('placeNearMeFlag', function (newVal, oldVal) {
        if (newVal !== oldVal) {
            //get new location if true
            if (newVal === true) {
                $scope.getCurrentCity();
            } else {
                //search without place near me
                $scope.placeNearMe = {'City': '', 'Lat': 0, 'Lng': 0};
            }
        }
    });
    $scope.sizeOfHashMap = function (obj) {
        return service.sizeOfHashMap(obj);
    };
    $scope.searchFunction();
});
myApp.controller('HomeController', function ($scope) {

    $scope.locationList = [
        {ID: '930011', Title: 'Thái Lan'},
        {ID: '930009', Title: 'Việt Nam'},
        {ID: '930019', Title: 'Philippin'}
    ];
    $scope.initSlider = function () {
        $('#top-activity-slider').lightSlider({
            auto: true,
            adaptiveHeight: true,
            item: 1,
            slideMargin: 0,
            loop: true
        });
    };
    if (window.innerWidth <= 500) {
        $scope.initSlider();
    }

});
myApp.controller('SpecificPackageController', function ($scope, $http, $timeout, service, $q, $window) {

    $scope.loaded = false;
    /* DEVELOPING BOX */
    $scope.toggleDevelopingBox = function () {
        $("#developingBox").toggleClass("active");
    };
    /* END DEVELOPING BOX */

    /* FIXED OPTIONS */
    function showFixedOptions() {
        var showPosition = $("#options").offset().top + $("#options").outerHeight(true);
        if (!$("#options-fixed").hasClass("active") && ($(window).scrollTop() + 65) >= showPosition) {
            $("#options-fixed").addClass("active");
            $("header").hide();
        }

        if ($("#options-fixed").hasClass("active") && ($(window).scrollTop() + 65) < showPosition) {
            $("#options-fixed").removeClass("active");
            $("header").show();
        }
    }

    $timeout(function () {
        showFixedOptions();
        $(window).bind('scroll', function () {
            showFixedOptions();
        });
    }, 100);
    /* END FIXED OPTIONS */

    $scope.fromSpecific = true;
    $scope.package = specificPackage;
    $scope.fbshare = function () {
        $window.open('https://www.facebook.com/sharer/sharer.php?u=' + $window.location.href, '_blank');
    };
    $scope.twshare = function () {
        $window.open('https://twitter.com/home?status=' + $window.location.href, '_blank');
    };
    $scope.loading = false;
    // convert json to object
    $scope.childrenDiscounts = $.parseJSON($scope.package.childrenDiscountJson);
    $scope.cancellationConditions = $.parseJSON($scope.package.cancellationPolicyJson);
    // Convert ready booking minutes
    $scope.readyBookingsHours = 0;
    $scope.readyBookingsMinutes = 0;
    $scope.readyBookingsDays = 0;
    if ($scope.package.readyBookingDurationType !== "days") {
        $scope.readyBookingsHours = Math.floor($scope.package.readyBookingDuration / 60);
        $scope.readyBookingsMinutes = $scope.package.readyBookingDuration - $scope.readyBookingsHours * 60;
    } else {
        $scope.readyBookingsDays = $scope.package.readyBookingDuration;
    }

    var listLanguageDescription = $scope.package.othersLanguageDescription;
//    $scope.package.unavailableDays = JSON.parse($scope.package.unavailableDays);
    if ($scope.package.cancellationConditions !== undefined) {
        $scope.package.cancellationConditions = JSON.parse($scope.package.cancellationConditions);
    }
    for (var i = 0, max = listLanguageDescription.length; i < max; i++) {
        var singleLanguage = listLanguageDescription[i];
        if (singleLanguage.language !== undefined) {
            singleLanguage.language = JSON.parse(singleLanguage.language);
        }
        singleLanguage.description = JSON.parse(singleLanguage.description);
        singleLanguage.advancedAddress = JSON.parse(singleLanguage.advancedAddress);
    }

    //    LANGUAGE DESCRIPTION
    $scope.selectedLanguageDescription = listLanguageDescription[0];
    $scope.setSelectedLanguage = function (index) {
        $scope.selectedLanguageDescription = listLanguageDescription[index];
        updateMarkerArray();
    };
    //END LANGUAGE DESCRIPTION
    //
    // default amenities

    $scope.currentTime = new Date().getTime();
    $scope.childPrice = 0;
    $scope.adultPrice = 0;
    $scope.Math = window.Math;
    $scope.ReportType = reportType;
//    $scope.numberOfAdults = 0;
//    $scope.numberOfChilds = 0;

    $scope.promotion = false;
    $scope.currentTime = new Date().getTime();
    $scope.package.rate = Math.round($scope.package.rate);
    if ($scope.package.reviews.length > 0) {
        $scope.totalReviews = $scope.package.reviews[0].totalRecords;
    } else {
        $scope.totalReviews = 0;
    }
    $scope.userID = userID;
    $scope.emailAddress = 0;
    $scope.message = $('#message').text();
    $scope.sendEmail = function () {
        var formData = new FormData();
        formData.append("email", EmailList);
        formData.append("message", $('#message').val());
        formData.append("packageID", $scope.package.id);
        formData.append("senderName", senderName);
        $.ajax({
            url: SendEmailURL,
            type: "POST",
            dataType: 'text',
            contentType: false,
            processData: false,
            cache: false,
            data: formData,
            success: function (response) {
                $('#myModal').modal('hide');
            },
            error: function (response) {
            }
        });
    };
    $scope.movetoMap = function () {
        var p = $("#map").position();
        $('html, body').animate({
            scrollTop: p.top - 190
        }, 300);
    };
    /* BOOKING CALENDAR */
    $scope.day_of_week = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];
    $scope.MONTHS_OF_YEAR = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
    Date.prototype.ddMMyyyy = function () {
        var yyyy = this.getFullYear().toString();
        var mm = (this.getMonth() + 1).toString(); // getMonth() is zero-based
        var dd = this.getDate().toString();
        return (dd[1] ? dd : "0" + dd[0]) + "/" + (mm[1] ? mm : "0" + mm[0]) + "/" + yyyy; // padding
    };
    Date.prototype.MMddyyyy = function () {
        var yyyy = this.getFullYear().toString();
        var mm = (this.getMonth() + 1).toString(); // getMonth() is zero-based
        var dd = this.getDate().toString();
        return (mm[1] ? mm : "0" + mm[0]) + "/" + (dd[1] ? dd : "0" + dd[0]) + "/" + yyyy; // padding
    };
    Date.prototype.formatAMPM = function () {
        var hours = this.getHours();
        var minutes = this.getMinutes();
        var ampm = hours >= 12 ? 'PM' : 'AM';
        hours = hours % 12;
        hours = hours ? hours : 12; // the hour '0' should be '12'
        minutes = minutes < 10 ? '0' + minutes : minutes;
        var strTime = hours + ':' + minutes + ' ' + ampm;
        return strTime;
    };
    Date.prototype.formatHHmm = function () {
        // convert minutes to mm
        var minutes = this.getMinutes();
        if (minutes < 10) {
            minutes = "0" + minutes;
        }

        // convert hours to HH
        var hours = this.getHours();
        if (hours < 10) {
            hours = "0" + hours;
        }
        return hours + ":" + minutes;
    };
    var END_HOUR = 23;
    var END_MINUTES = 59;
    var START_HOURS = 0;
    var START_MINUES = 0;
    var MINUTES_PER_HOUR = 60;
    var FREE_INTERVAL = 15;
    var ALL_PACKAGES_ID = 0;
    var SMALLET_INTERVAL = 5;
    var NO_STEPS_MONTH = 1;
    var NO_STEPS_DAY = 2;
    var NO_DAYS_OF_WEEK = 7; // "constant" for number of days in a week
    var NO_WEEKS_OF_MONTH = 6;
    var bookedDate = new Date(toDate);
    $scope.calendarTime = new Date(toDate);
    toDate = new Date(toDate);
    // toggle Calendar
    $scope.toggleCalendar = function () {
        $("#bookingCalendar").toggleClass("active");
    };
    var operationCycles = $scope.package.operationCycles;
    function checkDateIsAvailable(date) {
        // check after to Date first
        if (date >= toDate) {
            // check operaton cycle
            for (var i = 0, max = operationCycles.length; i < max; i++) {
                var cycle = operationCycles[i];
                var startDate = new Date(cycle.startDate);
                var endDate = new Date(cycle.endDate);
                if (date >= startDate && (isNaN(endDate.getTime()) || date <= endDate)) {
                    return true;
                }
            }
        }
        return false;
    }
    var checkInsideNondays = function (day) {
        for (var k = 0, max = $scope.package.unavailableDays.length; k < max; k++) {
            if (day === $scope.package.unavailableDays[k]) {
                return true;
            }
        }
        return false;
    };
    var ONE_DAY_MLSECONDS = 24 * 60 * 60 * 1000;
//    $scope.package.startDate = $scope.package

//    $scope.package.startDate = new Date($scope.package.operationCycles[0].startDate);
    var checkNotInsideSequential = function (secondDate) {
        $scope.package.sequentialOperation = parseInt($scope.package.sequentialOperation);
        if ($scope.package.sequentialOperation !== 0) {
            //$scope.package.startDate
            var firstDate = new Date($scope.package.startDate);
//            var secondDate = new Date(day);
            if (!isNaN(firstDate.getTime())) {
                var diffDays = Math.round(Math.abs((firstDate.getTime() - secondDate.getTime()) / (ONE_DAY_MLSECONDS)));
                if (diffDays % $scope.package.sequentialOperation === 0) {
                    return false;
                }
                return true;
            }
        }
        return false;
    };
//    function updateCalendar(calendarTime) {
//        // return to first sunday of month
//        var currentMonth = calendarTime.getMonth();
//        var currentDate = new Date(calendarTime);
//        currentDate.setDate(1);
//        var distance = currentDate.getDay();
//        if (distance === 0) {
//            distance = 7;
//        }
//        currentDate.setDate(currentDate.getDate() - distance);
//
//        // construct string html of month view
//        var html = "";
//        // loop 6 weeks
//        var isAvailable;
//        for (var i = 0; i < NO_WEEKS_OF_MONTH; i++) {
//            html += "<ul class='clearfix'>";
//            for (var j = 0; j < NO_DAYS_OF_WEEK; j++) { // loop 7 days
//                isAvailable = false;
//                if (checkDateIsAvailable(currentDate) && !checkNotInsideSequential(currentDate) && !checkInsideNondays(currentDate.getDay())) {
//                    isAvailable = true;
//                }
//                html += "<li class='" + (isAvailable ? "availableBooking " : "") + (currentMonth === currentDate.getMonth() ? "inMonth" : "outMonth") + "'>"
//                        + "<span dateValue='" + currentDate.MMddyyyy() + "'>"
//                        + currentDate.getDate() + "</span></li>";
//                currentDate.setDate(currentDate.getDate() + 1);
//            }
//            // plus week to month
//            html += "</ul>";
//        }
//        return html;
//    }
//
//    $scope.backAvailableMonth = function () {
//        $scope.calendarTime.setMonth($scope.calendarTime.getMonth() - 1);
//        $("#bookingCalendar .calendarDate").html(updateCalendar($scope.calendarTime));
//    };
//
//    $scope.nextAvailableMonth = function () {
//        $scope.calendarTime.setMonth($scope.calendarTime.getMonth() + 1);
//        $("#bookingCalendar .calendarDate").html(updateCalendar($scope.calendarTime));
//    };
//
//    $("#bookingCalendar .calendarDate").html(updateCalendar($scope.calendarTime));

    /* END BOOKING CALENDAR */

    $scope.reportYourOwn = function (currentID) {
        if (currentID !== $scope.package.providerID) {

            return true;
        } else {
            return false;
        }
    };
    $scope.parseInt = function (num) {
        if (isNaN(num)) {
            return 0;
        } else {
            return num;
        }
    };
//    $scope.initBookingCalendar();

    $scope.enableDates = function (day) {
        var d = day.getDay();
        if ($scope.package.unavailableDays.indexOf(d) !== -1) {
            return [false, ""];
        } else {
            return [true, ""];
        }
    };
    // Init Gallery
    var gallery = [];
    for (var i = 0; i < $scope.package.additionImages.length; i++) {
        var imageSrc = $scope.package.additionImages[i].image;
        var image = {
            "src": imageSrc,
            "thumb": imageSrc,
            "subHtml": '<h4>Image Name</h4><p>Image Description</p>'
        };
        gallery.push(image);
    }

    $scope.initGallery = function () {
        $("#gallery").lightGallery({
            dynamic: true,
            thumbnail: true,
            mode: 'lg-soft-zoom',
            dynamicEl: gallery
        });
    };
    // End Gallery

    /* PACKAGE MAP */
    $scope.selectedLocation = "";
    $scope.setSelectedLocation = function (locationType) {
        if (locationType !== $scope.selectedLocation) {
            $scope.selectedLocation = locationType;
            updateMarkerArray();
        }
    };
    var map;
    var initFinalMap = function () {
        map = new google.maps.Map(document.getElementById('map'), {
            center: new google.maps.LatLng(13.7649273, 100.5360824),
            zoom: 17,
            draggable: true,
            scrollwheel: false
        });
        updateMarkerArray();
    };
    var fillInforWindow = function (place, infowindow, map, marker) {
        infowindow.setContent('<div>' + place + '</div>');
        infowindow.open(map, marker);
    };
    var markers = [], windows = [], packagePath, departurePath, pickupPath, bounds;
    function updateMarkerArray() { // update marker arrays and change map view
        // first delete old markers
        if (markers.length > 0) {
            for (var i = 0, max = markers.length; i < max; i++) {
                markers[i].setMap(null);
                windows[i].close();
            }
            markers = [];
            windows = [];
            angular.isObject(packagePath) ? packagePath.setMap(null) : 0;
            angular.isObject(departurePath) ? departurePath.setMap(null) : 0;
            angular.isObject(pickupPath) ? pickupPath.setMap(null) : 0;
        }

        // init marker array
        if ($scope.selectedLocation === "" || $scope.selectedLocation === "action") {
            var actionLocations = $scope.selectedLanguageDescription.advancedAddress.action;
            var actionLength = actionLocations.length;
            if (actionLength > 0) { // if have addtional markers

                var path = [];
                for (var i = 0; i < actionLength; i++) { // loop addtional markers
                    var actionLocation = actionLocations[i];
                    if (angular.isObject(actionLocation)) {

                        // create new marker
                        var lat = actionLocation.lat;
                        var lng = actionLocation.lng;
                        if (lat !== "" && lng !== "") {
                            var latlng = new google.maps.LatLng(lat, lng);
                            var markerObj = new google.maps.Marker({
                                map: map,
                                position: latlng
                            });
                            markerObj.setIcon('http://youtripper.com/Images/Icon/packageLocation.svg');
                            markers.push(markerObj);
                            // create new window
                            var window = new google.maps.InfoWindow({
                                maxWidth: 200
                            });
                            windows.push(window);
                            fillInforWindow("<strong>Package location " + (i + 1) + ": </strong>" + actionLocation.addr,
                                    window, map, markerObj);
                            // add new point to path
                            path.push(latlng);
                        }
                    }
                }

                // draw line betweens package
                packagePath = new google.maps.Polyline({
                    path: path,
                    geodesic: true,
                    strokeColor: '#68BFAC',
                    strokeOpacity: 1.0,
                    strokeWeight: 2
                });
                packagePath.setMap(map);
            }
        }

        if ($scope.selectedLocation === "" || $scope.selectedLocation === "pickup") {
            var pickupLocations = $scope.selectedLanguageDescription.advancedAddress.pickup;
            var pickupLength = pickupLocations.length;
            if (pickupLength > 0) { // if have addtional markers
                var path = [];
                for (var i = 0; i < pickupLength; i++) { // loop addtional marrkers
                    var pickupLocation = pickupLocations[i];
                    if (angular.isObject(pickupLocation)) {

                        // crate new marker
                        var lat = pickupLocation.lat;
                        var lng = pickupLocation.lng;
                        if (lat !== "" && lng !== "") {
                            var latlng = new google.maps.LatLng(lat, lng);
                            var markerObj = new google.maps.Marker({
                                map: map,
                                position: latlng
                            });
                            markerObj.setIcon('http://youtripper.com/Images/Icon/pickupLocation.svg');
                            markers.push(markerObj);
                            // create new window
                            var window = new google.maps.InfoWindow({
                                maxWidth: 200
                            });
                            windows.push(window);
                            fillInforWindow("<strong>Pickup location " + (i + 1) + ": </strong>" + pickupLocation.addr,
                                    window, map, markerObj);
                            // add new point to path
                            path.push(latlng);
                        }
                    }
                }
                // draw line betweens package
                pickupPath = new google.maps.Polyline({
                    path: path,
                    geodesic: true,
                    strokeColor: '#FBB03B',
                    strokeOpacity: 1.0,
                    strokeWeight: 2
                });
                pickupPath.setMap(map);
            }
        }

        if ($scope.selectedLocation === "" || $scope.selectedLocation === "departure") {
            var departureLocations = $scope.selectedLanguageDescription.advancedAddress.departure;
            var departureLength = departureLocations.length;
            if (departureLength > 0) { // if have addtional markers
                var path = [];
                for (var i = 0; i < departureLength; i++) { // loop addtional marrkers
                    var departureLocation = departureLocations[i];
                    if (angular.isObject(departureLocation)) {

                        // crate new marker
                        var lat = departureLocation.lat;
                        var lng = departureLocation.lng;
                        if (lat !== "" && lng !== "") {
                            var latlng = new google.maps.LatLng(lat, lng);
                            var markerObj = new google.maps.Marker({
                                map: map,
                                position: latlng
                            });
                            markerObj.setIcon('http://youtripper.com/Images/Icon/departLocation.svg');
                            markers.push(markerObj);
                            // create new window
                            var window = new google.maps.InfoWindow({
                                maxWidth: 200
                            });
                            windows.push(window);
                            fillInforWindow("<strong>Departure location " + (i + 1) + ": </strong>" + departureLocation.addr,
                                    window, map, markerObj);
                            // add new point to path
                            path.push(latlng);
                        }
                    }
                }

                // draw line betweens package
                departurePath = new google.maps.Polyline({
                    path: path,
                    geodesic: true,
                    strokeColor: '#FF514E',
                    strokeOpacity: 1.0,
                    strokeWeight: 2
                });
                departurePath.setMap(map);
            }
        }

        // modify map view to see all markers
        bounds = new google.maps.LatLngBounds();
        for (var i = 0; i < markers.length; i++) {
            bounds.extend(markers[i].getPosition());
        }

        if (markers.length > 0) {
            map.fitBounds(bounds);
        }

    }

    initFinalMap();
    $scope.showError = false;
    $scope.error = {numberOfPeople: false};
    $scope.showChatBox = function () {
        if (userRole === 1) {
            $('#chatBoxContainer').css('display', '');
        } else {
            alert("This function is only for user!");
        }
    };
    $('#closeChatButton').click(function () {
        $('#chatBoxContainer').css('display', 'none');
    });
    $scope.blankMessage = '';
    $scope.sendMessageViaChatbox = function () {
        if ($('#textMessage').val() !== '') {
            $scope.package.id;
            $scope.userID;
            $scope.responseMessage;
            var data = {"packageID": $scope.package.id, "tripperID": $scope.userID, "providerID": $scope.package.providerID, "message": $('#textMessage').val()};
            var url = service.getContextPath() + "/Tripper/SendMessageViaChatbox";
            $http.post(url, data)
                    .then(function successCallback(response) {
                        if (response.data === "error") {
                            var pageError = service.getContextPath() + service.getErrorPageUrl();
                            $(location).attr('href', pageError);
                        } else {


                        }
                    });
            $('#textMessage').val('');
            $scope.blankMessage = 'Your message sent successfully';
        } else {
            $scope.blankMessage = 'Say something !';
        }
    };
    $('#textMessage').keypress(function (e) {
        var key = e.which;
        if (key === 13)  // the enter key code
        {
            $scope.sendMessageViaChatbox();
            return false;
        }
    });
    var url = service.getContextPath() + "/Common/updateSystemKeyWord";
    $scope.updateKeyword = function () {
        var data = {"packageID": $scope.package.id};
        $http.post(url, data)
                .then(function successCallback(response) {
                    if (response.data === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                    }
                });
    };
    $scope.reason = "";
    $scope.DisableValue = true;
    $scope.CheckOther = function () {
        $scope.DisableValue = false;
        $scope.reason = "Other Reason";
    };
    $scope.CheckReason = function (reason) {
        $scope.reason = reason;
        $scope.DisableValue = true;
    };
    $scope.validateReportForm = function (event) {
        if ($scope.reason === "") {
            $scope.errorFlag = true;
            event.preventDefault();
        } else {
            return true;
        }
    };
    $scope.updateKeyword();
    /* BOOKING TIME */

    // function for constructing list of operation times
    $scope.listFreeTimes = [];
    function constructListTimes(package) {
        var startOperationTime;
        var endOperationTime;
        var duration;
        var freeInterval;
        var durationType = package.durationType;
        if (durationType !== "days") {
            var startTime = package.startOperationTime;
            var endTime = package.endOperationTime;
            var isFreeBooking = package.isFreeBooking;
            var newDate = new Date();
            if (isFreeBooking) { // if the package is free to book
                freeInterval = package.freeInterval;
                startOperationTime = new Date(newDate.MMddyyyy() + " " + startTime);
                endOperationTime = new Date(newDate.MMddyyyy() + " " + endTime);
                duration = package.duration;
                durationType === "hours" ? duration *= MINUTES_PER_HOUR : 0;
            } else {
                if (durationType !== "days") {
                    var fixedHour = package.fixedHour;
                    var fixedMinute = package.fixedMinute;
                    freeInterval = fixedHour * 60 + fixedMinute;
                    startOperationTime = new Date(bookedDate.MMddyyyy() + " " + startTime);
                    endOperationTime = new Date(bookedDate.MMddyyyy() + " " + endTime);
                    duration = package.duration;
                    durationType === "hours" ? duration *= MINUTES_PER_HOUR : 0;
                }
            }

            // loop from start to end to construct list times
            $scope.listFreeTimes = [];
            var ending = new Date(endOperationTime);
            ending.setMinutes(ending.getMinutes() - duration);
            do {
                $scope.listFreeTimes.push(startOperationTime.formatHHmm());
                startOperationTime.setMinutes(startOperationTime.getMinutes() + freeInterval);
            } while (startOperationTime <= ending);
        }
    }
    constructListTimes($scope.package);
//    $scope.childPromotions = JSON.parse($scope.package.advancedChildPrice);

    // load availablity of the selected date
    var DATE_AVAILABILITY_URL = service.getContextPath() + "/Common/IsDateAvailable";
    var TIME_AVAILABILITY_URL = service.getContextPath() + "/Common/IsTimeAvailable";
    var JOINT_BOOKED_URL = service.getContextPath() + "/Common/IsJointBooked";
    var pending = false;
    var deferred = $q.defer();
    var promise;
    $scope.isAvailable = false;
    $scope.isCheckAvailability = false;
    var isJointBooked = false;
    function loadAvailability(selectedDate, selectedTime) {
        $timeout.cancel(promise);
        promise = $timeout(function () {
            if (pending) {
                deferred.resolve();
                deferred = $q.defer();
            }
            var packageID = $scope.package.id;
            var url, data;
            var packageType = $scope.package.packageType;
            if (packageType !== "Joint") {
                // if type is day just check availability of date
                var durationType = $scope.package.durationType;
                if (durationType !== "days") {
                    url = TIME_AVAILABILITY_URL;
                    data = {"packageID": packageID, "tripDate": selectedDate, "tripTime": selectedTime};
                } else {
                    url = DATE_AVAILABILITY_URL;
                    data = {"packageID": packageID, "tripDate": selectedDate};
                }
            } else {
                url = JOINT_BOOKED_URL;
                data = {"packageID": packageID, "tripDate": selectedDate, "tripTime": selectedTime};
            }
            $http.post(url, data, {timeout: deferred.promise})
                    .then(function successCallback(response) {
                        $scope.isCheckAvailability = true;
                        if (response.data.result === "error") {
                            var pageError = service.getContextPath() + service.getErrorPageUrl();
                            $(location).attr('href', pageError);
                        } else if (response.data.result !== true) { // if slot is available
                            if (packageType !== "Joint") {
                                $scope.isAvailable = false;
                            } else {
                                isJointBooked = true;
                                $scope.isAvailable = true;
                            }
                        } else {
                            if (packageType !== "Joint") {
                                $scope.isAvailable = true;
                            } else {
                                isJointBooked = false;
                                $scope.isAvailable = true;
                            }
                        }
                        pending = false;
                        deferred = $q.defer();
                    });
        }, 100);
    }

    // check input no people
    $scope.noChilds = [];
    var minTripper = $scope.package.minTripper;
    var maxTripper = $scope.package.maxTripper;
    $scope.checkInputPeople = function () {
        var noAdults = $scope.numberOfAdults;
        var totalPeople = 0;
        if (!angular.isNumber(noAdults)) {
            $("#adultsError").addClass("active");
            return false;
        } else {
            totalPeople += noAdults;
        }

        for (var i = 0, max = $scope.noChilds.length; i < max; i++) {
            var noChildElement = $scope.noChilds[i];
            // if no input then plus 0
            if (angular.isNumber(noChildElement)) {
                totalPeople += noChildElement;
            }
        }

        if (maxTripper > 0) { // check max
            $("#adultsError").removeClass("active");
            if (totalPeople > maxTripper) {
                $("#maximumError").addClass("active");
                return false;
            } else {
                $("#maximumError").removeClass("active");
            }
        }
        if (!isJointBooked) {
            if (totalPeople < minTripper) { // check Min
                $("#miniMumError").addClass("active");
                return false;
            } else {
                $("#miniMumError").removeClass("active");
            }
        }
        return true;
    };
    $scope.selectedTimeChange = function () {
        if (angular.isString($scope.selectedDate) && $scope.selectedDate !== "") {
            loadAvailability($scope.selectedDate, $scope.selectedTime);
        }
    };
    $scope.bookingErrorMsg = false;
    $scope.validateBookForm = function (event) {
        if (!$scope.checkInputPeople() || !$scope.isAvailable || !$scope.isCheckAvailability) {
            $scope.bookingErrorMsg = true;
            event.preventDefault();
        }
    };
    // calculate No Packages From no adults and no childs
    /*
     $scope.totalPrice = 0;
     $scope.noChilds = [];
     
     $scope.calculateNoPackages = function () {
     var packageType = $scope.package.packageType;
     var packagePrice = $scope.package.ordinaryPriceForAdult;
     var noAdults = $scope.numberOfAdults;
     !angular.isNumber(noAdults) ? noAdults = 0 : 0;
     
     // check selectedate has promotion or not
     var selectedDate = $scope.selectedDate;
     var dateDiscount = 0;
     if (angular.isString(selectedDate) && selectedDate !== "") {
     var dates = $scope.package.promotionJson;
     for (var i = 0, max = dates.length; i < max; i++) {
     var dateRange = dates[i].dateRange;
     if (!!dateRange[selectedDate]) {
     dateDiscount = dates[i].percent;
     break;
     }
     }
     }
     
     
     if (packageType !== "Joint") {
     var discountPercent = 0;
     var totalPeople = 0;
     // plus no adults
     angular.isNumber($scope.numberOfAdults) ? totalPeople += $scope.numberOfAdults : 0;
     
     for (var i = 0, max = $scope.noChilds.length; i < max; i++) {
     var noChildElement = $scope.noChilds[i];
     var percent = $scope.childPromotions[i].percent;
     // if no input then plus 0
     if (angular.isNumber(noChildElement)) {
     totalPeople += noChildElement;
     discountPercent += percent * noChildElement;
     }
     }
     
     // show error if noPeople is over max
     if (totalPeople > $scope.package.maxTripper) {
     $("#maximumError").addClass("active");
     $scope.totalPrice = 0;
     } else {
     $("#maximumError").removeClass("active");
     if (totalPeople <= 0) {
     $scope.totalPrice = 0;
     } else {
     $scope.totalPrice = packagePrice * (100 - discountPercent - dateDiscount) / 100;
     }
     }
     } else {
     var childPrice = 0;
     for (var i = 0, max = $scope.noChilds.length; i < max; i++) {
     var noChildElement = $scope.noChilds[i];
     var percent = $scope.childPromotions[i].percent;
     // if no input then plus 0
     if (angular.isNumber(noChildElement)) {
     childPrice += (noChildElement * packagePrice) * (100 - percent) / 100;
     }
     }
     $scope.totalPrice = (noAdults * packagePrice + childPrice) * (100 - dateDiscount) / 100;
     }
     
     
     };
     */


    $scope.selectedAmenities = $scope.package.amenitiesClassifiers[0];
    $scope.setSelectedAmenities = function (amenities) {
        $scope.selectedAmenities = amenities;
    };
    $scope.loaded = true;
});
myApp.controller('PreviewPackageController', function ($scope, $http, $timeout, service, $q, $window) {

    $scope.loaded = false;
    /* DEVELOPING BOX */
    $scope.toggleDevelopingBox = function () {
        $("#developingBox").toggleClass("active");
    };
    /* END DEVELOPING BOX */

    /* FIXED OPTIONS */
    function showFixedOptions() {
        var showPosition = $("#options").offset().top + $("#options").outerHeight(true);
        if (!$("#options-fixed").hasClass("active") && ($(window).scrollTop() + 65) >= showPosition) {
            $("#options-fixed").addClass("active");
            $("header").hide();
        }

        if ($("#options-fixed").hasClass("active") && ($(window).scrollTop() + 65) < showPosition) {
            $("#options-fixed").removeClass("active");
            $("header").show();
        }
    }

    $timeout(function () {
        showFixedOptions();
        $(window).bind('scroll', function () {
            showFixedOptions();
        });
    }, 100);
    /* END FIXED OPTIONS */

    $scope.fromSpecific = true;
    $scope.package = specificPackage;
    $scope.fbshare = function () {
        $window.open('https://www.facebook.com/sharer/sharer.php?u=' + $window.location.href, '_blank');
    };
    $scope.twshare = function () {
        $window.open('https://twitter.com/home?status=' + $window.location.href, '_blank');
    };
    $scope.loading = false;
    // convert json to object
    $scope.childrenDiscounts = $.parseJSON($scope.package.childrenDiscountJson);
    $scope.cancellationConditions = $.parseJSON($scope.package.cancellationPolicyJson);
    // Convert ready booking minutes
    $scope.readyBookingsHours = 0;
    $scope.readyBookingsMinutes = 0;
    $scope.readyBookingsDays = 0;
    if ($scope.package.readyBookingDurationType !== "days") {
        $scope.readyBookingsHours = Math.floor($scope.package.readyBookingDuration / 60);
        $scope.readyBookingsMinutes = $scope.package.readyBookingDuration - $scope.readyBookingsHours * 60;
    } else {
        $scope.readyBookingsDays = $scope.package.readyBookingDuration;
    }

    var listLanguageDescription = $scope.package.languageDescriptionList;
    if ($scope.package.cancellationConditions !== undefined) {
        $scope.package.cancellationConditions = JSON.parse($scope.package.cancellationConditions);
    }
    for (var i = 0, max = listLanguageDescription.length; i < max; i++) {
        var singleLanguage = listLanguageDescription[i];
        if (singleLanguage.language !== undefined) {
            singleLanguage.language = JSON.parse(singleLanguage.language);
        }
        singleLanguage.description = JSON.parse(singleLanguage.description);
        singleLanguage.advancedAddress = JSON.parse(singleLanguage.advancedAddress);
    }

    //    LANGUAGE DESCRIPTION
    $scope.selectedLanguageDescription = listLanguageDescription[0];
    $scope.setSelectedLanguage = function (index) {
        $scope.selectedLanguageDescription = listLanguageDescription[index];
        updateMarkerArray();
    };
    //END LANGUAGE DESCRIPTION
    //
    // default amenities

    $scope.currentTime = new Date().getTime();
    $scope.childPrice = 0;
    $scope.adultPrice = 0;
    $scope.Math = window.Math;
    $scope.ReportType = reportType;
//    $scope.numberOfAdults = 0;
//    $scope.numberOfChilds = 0;

    $scope.promotion = false;
    $scope.currentTime = new Date().getTime();
    $scope.package.rate = 0;
    $scope.totalReviews = 0;
    $scope.userID = userID;
    $scope.emailAddress = 0;
    $scope.message = $('#message').text();
    $scope.sendEmail = function () {
        var formData = new FormData();
        formData.append("email", EmailList);
        formData.append("message", $('#message').val());
        formData.append("packageID", $scope.package.id);
        formData.append("senderName", senderName);
        $.ajax({
            url: SendEmailURL,
            type: "POST",
            dataType: 'text',
            contentType: false,
            processData: false,
            cache: false,
            data: formData,
            success: function (response) {
                $('#myModal').modal('hide');
            },
            error: function (response) {
            }
        });
    };
    $scope.movetoMap = function () {
        var p = $("#map").position();
        $('html, body').animate({
            scrollTop: p.top - 190
        }, 300);
    };
    /* BOOKING CALENDAR */
    $scope.day_of_week = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];
    $scope.MONTHS_OF_YEAR = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
    Date.prototype.ddMMyyyy = function () {
        var yyyy = this.getFullYear().toString();
        var mm = (this.getMonth() + 1).toString(); // getMonth() is zero-based
        var dd = this.getDate().toString();
        return (dd[1] ? dd : "0" + dd[0]) + "/" + (mm[1] ? mm : "0" + mm[0]) + "/" + yyyy; // padding
    };
    Date.prototype.MMddyyyy = function () {
        var yyyy = this.getFullYear().toString();
        var mm = (this.getMonth() + 1).toString(); // getMonth() is zero-based
        var dd = this.getDate().toString();
        return (mm[1] ? mm : "0" + mm[0]) + "/" + (dd[1] ? dd : "0" + dd[0]) + "/" + yyyy; // padding
    };
    Date.prototype.formatAMPM = function () {
        var hours = this.getHours();
        var minutes = this.getMinutes();
        var ampm = hours >= 12 ? 'PM' : 'AM';
        hours = hours % 12;
        hours = hours ? hours : 12; // the hour '0' should be '12'
        minutes = minutes < 10 ? '0' + minutes : minutes;
        var strTime = hours + ':' + minutes + ' ' + ampm;
        return strTime;
    };
    Date.prototype.formatHHmm = function () {
        // convert minutes to mm
        var minutes = this.getMinutes();
        if (minutes < 10) {
            minutes = "0" + minutes;
        }

        // convert hours to HH
        var hours = this.getHours();
        if (hours < 10) {
            hours = "0" + hours;
        }
        return hours + ":" + minutes;
    };
    var END_HOUR = 23;
    var END_MINUTES = 59;
    var START_HOURS = 0;
    var START_MINUES = 0;
    var MINUTES_PER_HOUR = 60;
    var FREE_INTERVAL = 15;
    var ALL_PACKAGES_ID = 0;
    var SMALLET_INTERVAL = 5;
    var NO_STEPS_MONTH = 1;
    var NO_STEPS_DAY = 2;
    var NO_DAYS_OF_WEEK = 7; // "constant" for number of days in a week
    var NO_WEEKS_OF_MONTH = 6;
    var bookedDate = new Date(toDate);
    $scope.calendarTime = new Date(toDate);
    toDate = new Date(toDate);
    // toggle Calendar
    $scope.toggleCalendar = function () {
        $("#bookingCalendar").toggleClass("active");
    };
//    var operationCycles = $scope.package.operationCycles;
//    function checkDateIsAvailable(date) {
//        // check after to Date first
//        if (date >= toDate) {
//            // check operaton cycle
//            for (var i = 0, max = operationCycles.length; i < max; i++) {
//                var cycle = operationCycles[i];
//                var startDate = new Date(cycle.startDate);
//                var endDate = new Date(cycle.endDate);
//                if (date >= startDate && (isNaN(endDate.getTime()) || date <= endDate)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
    var checkInsideNondays = function (day) {
        for (var k = 0, max = $scope.package.unavailableDays.length; k < max; k++) {
            if (day === $scope.package.unavailableDays[k]) {
                return true;
            }
        }
        return false;
    };
    var ONE_DAY_MLSECONDS = 24 * 60 * 60 * 1000;
//    $scope.package.startDate = $scope.package

//    $scope.package.startDate = new Date($scope.package.operationCycles[0].startDate);
    var checkNotInsideSequential = function (secondDate) {
        $scope.package.sequentialOperation = parseInt($scope.package.sequentialOperation);
        if ($scope.package.sequentialOperation !== 0) {
            //$scope.package.startDate
            var firstDate = new Date($scope.package.startDate);
//            var secondDate = new Date(day);
            if (!isNaN(firstDate.getTime())) {
                var diffDays = Math.round(Math.abs((firstDate.getTime() - secondDate.getTime()) / (ONE_DAY_MLSECONDS)));
                if (diffDays % $scope.package.sequentialOperation === 0) {
                    return false;
                }
                return true;
            }
        }
        return false;
    };
//    function updateCalendar(calendarTime) {
//        // return to first sunday of month
//        var currentMonth = calendarTime.getMonth();
//        var currentDate = new Date(calendarTime);
//        currentDate.setDate(1);
//        var distance = currentDate.getDay();
//        if (distance === 0) {
//            distance = 7;
//        }
//        currentDate.setDate(currentDate.getDate() - distance);
//
//        // construct string html of month view
//        var html = "";
//        // loop 6 weeks
//        var isAvailable;
//        for (var i = 0; i < NO_WEEKS_OF_MONTH; i++) {
//            html += "<ul class='clearfix'>";
//            for (var j = 0; j < NO_DAYS_OF_WEEK; j++) { // loop 7 days
//                isAvailable = false;
//                if (checkDateIsAvailable(currentDate) && !checkNotInsideSequential(currentDate) && !checkInsideNondays(currentDate.getDay())) {
//                    isAvailable = true;
//                }
//                html += "<li class='" + (isAvailable ? "availableBooking " : "") + (currentMonth === currentDate.getMonth() ? "inMonth" : "outMonth") + "'>"
//                        + "<span dateValue='" + currentDate.MMddyyyy() + "'>"
//                        + currentDate.getDate() + "</span></li>";
//                currentDate.setDate(currentDate.getDate() + 1);
//            }
//            // plus week to month
//            html += "</ul>";
//        }
//        return html;
//    }

//    $scope.backAvailableMonth = function () {
//        $scope.calendarTime.setMonth($scope.calendarTime.getMonth() - 1);
//        $("#bookingCalendar .calendarDate").html(updateCalendar($scope.calendarTime));
//    };
//
//    $scope.nextAvailableMonth = function () {
//        $scope.calendarTime.setMonth($scope.calendarTime.getMonth() + 1);
//        $("#bookingCalendar .calendarDate").html(updateCalendar($scope.calendarTime));
//    };
//
//    $("#bookingCalendar .calendarDate").html(updateCalendar($scope.calendarTime));

    /* END BOOKING CALENDAR */

    $scope.reportYourOwn = function (currentID) {
        if (currentID !== $scope.package.providerID) {

            return true;
        } else {
            return false;
        }
    };
    $scope.parseInt = function (num) {
        if (isNaN(num)) {
            return 0;
        } else {
            return num;
        }
    };
//    $scope.initBookingCalendar();

    $scope.enableDates = function (day) {
        var d = day.getDay();
        if ($scope.package.unavailableDays.indexOf(d) !== -1) {
            return [false, ""];
        } else {
            return [true, ""];
        }
    };
    // Init Gallery
    var gallery = [];
    for (var i = 0; i < $scope.package.additionImages.length; i++) {
        var imageSrc = $scope.package.additionImages[i].image;
        var image = {
            "src": imageSrc,
            "thumb": imageSrc,
            "subHtml": '<h4>Image Name</h4><p>Image Description</p>'
        };
        gallery.push(image);
    }

    $scope.initGallery = function () {
        $("#gallery").lightGallery({
            dynamic: true,
            thumbnail: true,
            mode: 'lg-soft-zoom',
            dynamicEl: gallery
        });
    };
    // End Gallery

    /* PACKAGE MAP */
    $scope.selectedLocation = "";
    $scope.setSelectedLocation = function (locationType) {
        if (locationType !== $scope.selectedLocation) {
            $scope.selectedLocation = locationType;
            updateMarkerArray();
        }
    };
    var map;
    var initFinalMap = function () {
        map = new google.maps.Map(document.getElementById('map'), {
            center: new google.maps.LatLng(13.7649273, 100.5360824),
            zoom: 17,
            draggable: true,
            scrollwheel: false
        });
        updateMarkerArray();
    };
    var fillInforWindow = function (place, infowindow, map, marker) {
        infowindow.setContent('<div>' + place + '</div>');
        infowindow.open(map, marker);
    };
    var markers = [], windows = [], packagePath, departurePath, pickupPath, bounds;
    function updateMarkerArray() { // update marker arrays and change map view
        // first delete old markers
        if (markers.length > 0) {
            for (var i = 0, max = markers.length; i < max; i++) {
                markers[i].setMap(null);
                windows[i].close();
            }
            markers = [];
            windows = [];
            angular.isObject(packagePath) ? packagePath.setMap(null) : 0;
            angular.isObject(departurePath) ? departurePath.setMap(null) : 0;
            angular.isObject(pickupPath) ? pickupPath.setMap(null) : 0;
        }

        // init marker array
        if ($scope.selectedLocation === "" || $scope.selectedLocation === "action") {
            var actionLocations = $scope.selectedLanguageDescription.advancedAddress.action;
            var actionLength = actionLocations.length;
            if (actionLength > 0) { // if have addtional markers

                var path = [];
                for (var i = 0; i < actionLength; i++) { // loop addtional markers
                    var actionLocation = actionLocations[i];
                    if (angular.isObject(actionLocation)) {

                        // create new marker
                        var lat = actionLocation.lat;
                        var lng = actionLocation.lng;
                        if (lat !== "" && lng !== "") {
                            var latlng = new google.maps.LatLng(lat, lng);
                            var markerObj = new google.maps.Marker({
                                map: map,
                                position: latlng
                            });
                            markerObj.setIcon('http://youtripper.com/Images/Icon/packageLocation.svg');
                            markers.push(markerObj);
                            // create new window
                            var window = new google.maps.InfoWindow({
                                maxWidth: 200
                            });
                            windows.push(window);
                            fillInforWindow("<strong>Package location " + (i + 1) + ": </strong>" + actionLocation.addr,
                                    window, map, markerObj);
                            // add new point to path
                            path.push(latlng);
                        }
                    }
                }

                // draw line betweens package
                packagePath = new google.maps.Polyline({
                    path: path,
                    geodesic: true,
                    strokeColor: '#68BFAC',
                    strokeOpacity: 1.0,
                    strokeWeight: 2
                });
                packagePath.setMap(map);
            }
        }

        if ($scope.selectedLocation === "" || $scope.selectedLocation === "pickup") {
            var pickupLocations = $scope.selectedLanguageDescription.advancedAddress.pickup;
            var pickupLength = pickupLocations.length;
            if (pickupLength > 0) { // if have addtional markers
                var path = [];
                for (var i = 0; i < pickupLength; i++) { // loop addtional marrkers
                    var pickupLocation = pickupLocations[i];
                    if (angular.isObject(pickupLocation)) {

                        // crate new marker
                        var lat = pickupLocation.lat;
                        var lng = pickupLocation.lng;
                        if (lat !== "" && lng !== "") {
                            var latlng = new google.maps.LatLng(lat, lng);
                            var markerObj = new google.maps.Marker({
                                map: map,
                                position: latlng
                            });
                            markerObj.setIcon('http://youtripper.com/Images/Icon/pickupLocation.svg');
                            markers.push(markerObj);
                            // create new window
                            var window = new google.maps.InfoWindow({
                                maxWidth: 200
                            });
                            windows.push(window);
                            fillInforWindow("<strong>Pickup location " + (i + 1) + ": </strong>" + pickupLocation.addr,
                                    window, map, markerObj);
                            // add new point to path
                            path.push(latlng);
                        }
                    }
                }
                // draw line betweens package
                pickupPath = new google.maps.Polyline({
                    path: path,
                    geodesic: true,
                    strokeColor: '#FBB03B',
                    strokeOpacity: 1.0,
                    strokeWeight: 2
                });
                pickupPath.setMap(map);
            }
        }

        if ($scope.selectedLocation === "" || $scope.selectedLocation === "departure") {
            var departureLocations = $scope.selectedLanguageDescription.advancedAddress.departure;
            var departureLength = departureLocations.length;
            if (departureLength > 0) { // if have addtional markers
                var path = [];
                for (var i = 0; i < departureLength; i++) { // loop addtional marrkers
                    var departureLocation = departureLocations[i];
                    if (angular.isObject(departureLocation)) {

                        // crate new marker
                        var lat = departureLocation.lat;
                        var lng = departureLocation.lng;
                        if (lat !== "" && lng !== "") {
                            var latlng = new google.maps.LatLng(lat, lng);
                            var markerObj = new google.maps.Marker({
                                map: map,
                                position: latlng
                            });
                            markerObj.setIcon('http://youtripper.com/Images/Icon/departLocation.svg');
                            markers.push(markerObj);
                            // create new window
                            var window = new google.maps.InfoWindow({
                                maxWidth: 200
                            });
                            windows.push(window);
                            fillInforWindow("<strong>Departure location " + (i + 1) + ": </strong>" + departureLocation.addr,
                                    window, map, markerObj);
                            // add new point to path
                            path.push(latlng);
                        }
                    }
                }

                // draw line betweens package
                departurePath = new google.maps.Polyline({
                    path: path,
                    geodesic: true,
                    strokeColor: '#FF514E',
                    strokeOpacity: 1.0,
                    strokeWeight: 2
                });
                departurePath.setMap(map);
            }
        }

        // modify map view to see all markers
        bounds = new google.maps.LatLngBounds();
        for (var i = 0; i < markers.length; i++) {
            bounds.extend(markers[i].getPosition());
        }

        if (markers.length > 0) {
            map.fitBounds(bounds);
        }

    }

    initFinalMap();
    $scope.showError = false;
    $scope.error = {numberOfPeople: false};
    $scope.showChatBox = function () {
        if (userRole === 1) {
            $('#chatBoxContainer').css('display', '');
        } else {
            alert("This function is only for user!");
        }
    };
    $('#closeChatButton').click(function () {
        $('#chatBoxContainer').css('display', 'none');
    });
    $scope.blankMessage = '';
    $scope.sendMessageViaChatbox = function () {
        if ($('#textMessage').val() !== '') {
            $scope.package.id;
            $scope.userID;
            $scope.responseMessage;
            var data = {"packageID": $scope.package.id, "tripperID": $scope.userID, "providerID": $scope.package.providerID, "message": $('#textMessage').val()};
            var url = service.getContextPath() + "/Tripper/SendMessageViaChatbox";
            $http.post(url, data)
                    .then(function successCallback(response) {
                        if (response.data === "error") {
                            var pageError = service.getContextPath() + service.getErrorPageUrl();
                            $(location).attr('href', pageError);
                        } else {


                        }
                    });
            $('#textMessage').val('');
            $scope.blankMessage = 'Your message sent successfully';
        } else {
            $scope.blankMessage = 'Say something !';
        }
    };
    $('#textMessage').keypress(function (e) {
        var key = e.which;
        if (key === 13)  // the enter key code
        {
            $scope.sendMessageViaChatbox();
            return false;
        }
    });
    var url = service.getContextPath() + "/Common/updateSystemKeyWord";
    $scope.updateKeyword = function () {
        var data = {"packageID": $scope.package.id};
        $http.post(url, data)
                .then(function successCallback(response) {
                    if (response.data === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                    }
                });
    };
    $scope.reason = "";
    $scope.DisableValue = true;
    $scope.CheckOther = function () {
        $scope.DisableValue = false;
        $scope.reason = "Other Reason";
    };
    $scope.CheckReason = function (reason) {
        $scope.reason = reason;
        $scope.DisableValue = true;
    };
    $scope.validateReportForm = function (event) {
        if ($scope.reason === "") {
            $scope.errorFlag = true;
            event.preventDefault();
        } else {
            return true;
        }
    };
    $scope.updateKeyword();
    /* BOOKING TIME */

    // function for constructing list of operation times
    $scope.listFreeTimes = [];
    function constructListTimes(package) {
        var startOperationTime;
        var endOperationTime;
        var duration;
        var freeInterval;
        var durationType = package.durationType;
        if (durationType !== "days") {
            var startTime = package.startOperationTime;
            var endTime = package.endOperationTime;
            var isFreeBooking = package.isFreeBooking;
            var newDate = new Date();
            if (isFreeBooking) { // if the package is free to book
                freeInterval = package.freeInterval;
                startOperationTime = new Date(newDate.MMddyyyy() + " " + startTime);
                endOperationTime = new Date(newDate.MMddyyyy() + " " + endTime);
                duration = package.duration;
                durationType === "hours" ? duration *= MINUTES_PER_HOUR : 0;
            } else {
                if (durationType !== "days") {
                    var fixedHour = package.fixedHour;
                    var fixedMinute = package.fixedMinute;
                    freeInterval = fixedHour * 60 + fixedMinute;
                    startOperationTime = new Date(bookedDate.MMddyyyy() + " " + startTime);
                    endOperationTime = new Date(bookedDate.MMddyyyy() + " " + endTime);
                    duration = package.duration;
                    durationType === "hours" ? duration *= MINUTES_PER_HOUR : 0;
                }
            }

            // loop from start to end to construct list times
            $scope.listFreeTimes = [];
            var ending = new Date(endOperationTime);
            ending.setMinutes(ending.getMinutes() - duration);
            do {
                $scope.listFreeTimes.push(startOperationTime.formatHHmm());
                startOperationTime.setMinutes(startOperationTime.getMinutes() + freeInterval);
            } while (startOperationTime <= ending);
        }
    }
    constructListTimes($scope.package);
//    $scope.childPromotions = JSON.parse($scope.package.advancedChildPrice);

    // load availablity of the selected date
    var DATE_AVAILABILITY_URL = service.getContextPath() + "/Common/IsDateAvailable";
    var TIME_AVAILABILITY_URL = service.getContextPath() + "/Common/IsTimeAvailable";
    var JOINT_BOOKED_URL = service.getContextPath() + "/Common/IsJointBooked";
    var pending = false;
    var deferred = $q.defer();
    var promise;
    $scope.isAvailable = false;
    $scope.isCheckAvailability = false;
    var isJointBooked = false;
    function loadAvailability(selectedDate, selectedTime) {
        $timeout.cancel(promise);
        promise = $timeout(function () {
            if (pending) {
                deferred.resolve();
                deferred = $q.defer();
            }
            var packageID = $scope.package.id;
            var url, data;
            var packageType = $scope.package.packageType;
            if (packageType !== "Joint") {
                // if type is day just check availability of date
                var durationType = $scope.package.durationType;
                if (durationType !== "days") {
                    url = TIME_AVAILABILITY_URL;
                    data = {"packageID": packageID, "tripDate": selectedDate, "tripTime": selectedTime};
                } else {
                    url = DATE_AVAILABILITY_URL;
                    data = {"packageID": packageID, "tripDate": selectedDate};
                }
            } else {
                url = JOINT_BOOKED_URL;
                data = {"packageID": packageID, "tripDate": selectedDate, "tripTime": selectedTime};
            }
            $http.post(url, data, {timeout: deferred.promise})
                    .then(function successCallback(response) {
                        $scope.isCheckAvailability = true;
                        if (response.data.result === "error") {
                            var pageError = service.getContextPath() + service.getErrorPageUrl();
                            $(location).attr('href', pageError);
                        } else if (response.data.result !== true) { // if slot is available
                            if (packageType !== "Joint") {
                                $scope.isAvailable = false;
                            } else {
                                isJointBooked = true;
                                $scope.isAvailable = true;
                            }
                        } else {
                            if (packageType !== "Joint") {
                                $scope.isAvailable = true;
                            } else {
                                isJointBooked = false;
                                $scope.isAvailable = true;
                            }
                        }
                        pending = false;
                        deferred = $q.defer();
                    });
        }, 100);
    }

    // check input no people
    $scope.noChilds = [];
    var minTripper = $scope.package.minTripper;
    var maxTripper = $scope.package.maxTripper;
    $scope.checkInputPeople = function () {
        var noAdults = $scope.numberOfAdults;
        var totalPeople = 0;
        if (!angular.isNumber(noAdults)) {
            $("#adultsError").addClass("active");
            return false;
        } else {
            totalPeople += noAdults;
        }

        for (var i = 0, max = $scope.noChilds.length; i < max; i++) {
            var noChildElement = $scope.noChilds[i];
            // if no input then plus 0
            if (angular.isNumber(noChildElement)) {
                totalPeople += noChildElement;
            }
        }

        if (maxTripper > 0) { // check max
            $("#adultsError").removeClass("active");
            if (totalPeople > maxTripper) {
                $("#maximumError").addClass("active");
                return false;
            } else {
                $("#maximumError").removeClass("active");
            }
        }
        if (!isJointBooked) {
            if (totalPeople < minTripper) { // check Min
                $("#miniMumError").addClass("active");
                return false;
            } else {
                $("#miniMumError").removeClass("active");
            }
        }
        return true;
    };
    $scope.selectedTimeChange = function () {
        if (angular.isString($scope.selectedDate) && $scope.selectedDate !== "") {
            loadAvailability($scope.selectedDate, $scope.selectedTime);
        }
    };
    $scope.bookingErrorMsg = false;
    $scope.validateBookForm = function (event) {
        if (!$scope.checkInputPeople() || !$scope.isAvailable || !$scope.isCheckAvailability) {
            $scope.bookingErrorMsg = true;
            event.preventDefault();
        }
    };
    // calculate No Packages From no adults and no childs
    /*
     $scope.totalPrice = 0;
     $scope.noChilds = [];
     
     $scope.calculateNoPackages = function () {
     var packageType = $scope.package.packageType;
     var packagePrice = $scope.package.ordinaryPriceForAdult;
     var noAdults = $scope.numberOfAdults;
     !angular.isNumber(noAdults) ? noAdults = 0 : 0;
     
     // check selectedate has promotion or not
     var selectedDate = $scope.selectedDate;
     var dateDiscount = 0;
     if (angular.isString(selectedDate) && selectedDate !== "") {
     var dates = $scope.package.promotionJson;
     for (var i = 0, max = dates.length; i < max; i++) {
     var dateRange = dates[i].dateRange;
     if (!!dateRange[selectedDate]) {
     dateDiscount = dates[i].percent;
     break;
     }
     }
     }
     
     
     if (packageType !== "Joint") {
     var discountPercent = 0;
     var totalPeople = 0;
     // plus no adults
     angular.isNumber($scope.numberOfAdults) ? totalPeople += $scope.numberOfAdults : 0;
     
     for (var i = 0, max = $scope.noChilds.length; i < max; i++) {
     var noChildElement = $scope.noChilds[i];
     var percent = $scope.childPromotions[i].percent;
     // if no input then plus 0
     if (angular.isNumber(noChildElement)) {
     totalPeople += noChildElement;
     discountPercent += percent * noChildElement;
     }
     }
     
     // show error if noPeople is over max
     if (totalPeople > $scope.package.maxTripper) {
     $("#maximumError").addClass("active");
     $scope.totalPrice = 0;
     } else {
     $("#maximumError").removeClass("active");
     if (totalPeople <= 0) {
     $scope.totalPrice = 0;
     } else {
     $scope.totalPrice = packagePrice * (100 - discountPercent - dateDiscount) / 100;
     }
     }
     } else {
     var childPrice = 0;
     for (var i = 0, max = $scope.noChilds.length; i < max; i++) {
     var noChildElement = $scope.noChilds[i];
     var percent = $scope.childPromotions[i].percent;
     // if no input then plus 0
     if (angular.isNumber(noChildElement)) {
     childPrice += (noChildElement * packagePrice) * (100 - percent) / 100;
     }
     }
     $scope.totalPrice = (noAdults * packagePrice + childPrice) * (100 - dateDiscount) / 100;
     }
     
     
     };
     */


    $scope.selectedAmenities = $scope.package.amenitiesClassifiers[0];
    $scope.setSelectedAmenities = function (amenities) {
        $scope.selectedAmenities = amenities;
    };
    /*Validate Package Information To Show Submit Review Button*/
    $scope.validPackage = false;
    $scope.showMissingData = 0;
    var languageDescriptionList = $scope.package.languageDescriptionList;
    //Check Category
    if ($scope.package.activityName !== "" && angular.isDefined($scope.package.activityName) && $scope.package.colorID > 0 && $scope.package.suitabilities.length > 0 && $scope.package.targetCountryID > 0) {
        $scope.showMissingData = $scope.showMissingData + 1;
    }
    ;
    //Check Description
    var checkDescriptionFlag = false;
    angular.forEach(languageDescriptionList, function (languageDescription) {
        if (angular.isUndefined(languageDescription.packageName) || languageDescription.packageName === '' ||
                angular.isUndefined(languageDescription.googleDescription) || languageDescription.googleDescription === '' ||
                languageDescription.description[0].description === '' || languageDescription.description[0].header === '' ||
                languageDescription.advancedAddress.action.length === 0 || languageDescription.advancedAddress.action[0].content === "") {
            checkDescriptionFlag = true;
        }

    });
    if (!checkDescriptionFlag) {
        $scope.showMissingData = $scope.showMissingData + 1;
    }

    //Check Package Cover Image
    if (angular.isString($scope.package.coverImage) && $scope.package.coverImage !== "") {
        $scope.showMissingData = $scope.showMissingData + 1;
    }

    //Check Booking
    if (($scope.package.maxTripper > 0 || ($scope.package.packageType === 'Open' && $scope.package.minTripper > 0)) && ($scope.package.durationDay > 0 ||
            $scope.package.durationMonth > 0 || $scope.package.durationYear > 0 || $scope.package.durationHour > 0 || $scope.package.durationMinute > 0) &&
            (($scope.package.durationDay === 0 && $scope.package.servingPeriodID > 0) || $scope.package.durationDay > 0 || $scope.package.durationMonth > 0 || $scope.package.durationYear > 0)
            && ($scope.package.isFreeBooking || (!$scope.package.isFreeBooking && ($scope.package.fixedHour !== null || $scope.package.fixedMinute !== null)))
            && (!$scope.package.isUsingMaxQuota || ($scope.package.isUsingMaxQuota && $scope.package.maxQuota > 0))
            ) {
        $scope.showMissingData = $scope.showMissingData + 1;
    }

    //Checking Price
    var childrenMissingData = true;
    var cancellationMissingData = true;
    $scope.package.childrenDiscountJson = JSON.parse($scope.package.childrenDiscountJson);
    $scope.package.cancellationPolicyJson = JSON.parse($scope.package.cancellationPolicyJson);
    for (var i = 0; i < $scope.package.childrenDiscountJson.length; i++) {
        if ($scope.package.childrenDiscountJson[i].condition === '' || $scope.package.childrenDiscountJson[i].condition === null) {
            childrenMissingData = false;
        }
    }
    for (var i = 0; i < $scope.package.cancellationPolicyJson.length; i++) {
        if ($scope.package.cancellationPolicyJson[i].duration === '' || $scope.package.cancellationPolicyJson[i].duration === null) {
            cancellationMissingData = false;
        }
    }
//    if ($scope.package.ordinaryPriceForAdult !== '' && $scope.package.ordinaryPriceForAdult !== 0 && childrenMissingData && cancellationMissingData) {
//        $scope.showMissingData = $scope.showMissingData + 1;
//    }

    if (childrenMissingData && cancellationMissingData) {
        $scope.showMissingData = $scope.showMissingData + 1;
    }

    //Set valid Package Flag
    if ($scope.showMissingData === 5) {
        $scope.validPackage = true;
    }


    $scope.loaded = true;
});
myApp.controller('VerifyPhoneCtrl', function ($scope, $http, service) {
    $scope.items = countryList;
    $scope.phoneObject = phoneObject;
    $scope.phoneNumber = $scope.phoneObject.phoneNumber;
    for (var i = 0; i < $scope.items.length; i++) {
        if ($scope.phoneObject.countryCode === $scope.items[i].code) {
            $scope.selected = $scope.items[i];
        }
    }

    $scope.sendSMS = function () {
        var error = document.getElementById('errormess');
        error.style.diplay = 'none';
        $http.post(sendSMSUrl + "/" + $scope.selected.code + "/" + $scope.phoneNumber)
                .success(function (response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else if (response === 'You have exceeded the maximum number of request for today!') {
                        $scope.messexceeded = response;
                    } else {
                        $scope.messResult = response;
                    }
                    $('.phone-step1').hide('slide', {direction: 'left'}, 1400);
                    $('.phone-step2').show('slide', {direction: 'right'}, 1400);
                });
    };
    $scope.verifySMS = function () {
        $('#exceeded').hide();
        $http.post(verifySMSUrl + "/" + $scope.SMSCode)
                .success(function (response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else if (response === 'Your account is verified!') {

                        window.location.href = profilePage;
                    } else {
                        $scope.messResult = response;
                    }
                });
    };
    $scope.resendSMS = function () {
        $('.phone-step2').hide('slide', {direction: 'right'}, 1400);
        $('.phone-step1').show('slide', {direction: 'left'}, 1400);
    };
});
myApp.controller('SearchPageController', function ($scope, $http, $q, service) {
    $scope.loading = false;
    $scope.search = search;
    $scope.advancedSearch = advancedSearch;
    $scope.pageSize = pageSize;
    $scope.currentPage = 1;
    $scope.total = 0;
    $scope.hideIfEmpty = true;
    $scope.ulClass = 'pagination';
    $scope.adjacent = 1;
    $scope.activeClass = 'active';
    $scope.disabledClass = 'disabled';
    $scope.showPrevNext = true;
    $scope.loadingFunction = true;
    $scope.groupTypeIDs = [];
    $scope.tripTypeIDs = [];
    $scope.amenitiesIDs = [];
    $scope.filterOptions;
    $scope.sizeOfHashMap = function (obj) {
        var size = 0, key;
        for (key in obj) {
            if (obj.hasOwnProperty(key))
                size++;
        }
        return size;
    };
    $scope.$watch('advancedSearch.packages', function (newVal, oldVal) {
        $scope.total = 0;
        if (newVal !== null && newVal !== undefined && newVal.length > 0) {
            $scope.total = $scope.advancedSearch.packages[0].totalRecords;
        }
    });
    $scope.$watch('groupTypeIDs.length', function (newVal, oldVal) {
        if (newVal !== oldVal) {
            if (!$(".page-search").hasClass("filters-open")) {
                $scope.filterPackage();
            }
        }
    });
    $scope.$watch('tripTypeIDs.length', function (newVal, oldVal) {
        if (newVal !== oldVal) {
            if (!$(".page-search").hasClass("filters-open")) {
                $scope.filterPackage();
            }
        }
    });
    $scope.$watch('amenitiesIDs.length', function (newVal, oldVal) {
        if (newVal !== oldVal) {
            if (!$(".page-search").hasClass("filters-open")) {
                $scope.filterPackage();
            }
        }
    });
    $scope.filterLoading = false;
    var cancelerB;
    $scope.DoCtrlPagingAct = function (text, page, pageSize, total) {
        if (cancelerB) {
            $scope.filterLoading = false;
            cancelerB.resolve();
        }
        cancelerB = $q.defer();
        $scope.filterLoading = true;
        $('html, body').animate({
            scrollTop: 0
        }, 300);
        var minPrice = $("#priceRange").slider("values", 0);
        var maxPrice = $("#priceRange").slider("values", 1);
        var rate = $('#rateFilter').raty('score');
        if (rate === null || rate === undefined) {
            rate = 0;
        }
        var data = {"searchText": search, "rate": rate, "minPrice": minPrice, "maxPrice": maxPrice,
            "tripTypeIDs": $scope.tripTypeIDs, "groupTypeIDs": $scope.groupTypeIDs, "amenitiesIDs": $scope.amenitiesIDs, "pageNumber": page};
        $http.post(searchByPageNumberUrl, data, {timeout: cancelerB.promise})
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        $scope.advancedSearch.packages = response.data;
                        $scope.filterLoading = false;
                    }
                });
    };
    var canceler;
    $scope.filterPackage = function () {
        if (canceler) {
            $scope.filterLoading = false;
            canceler.resolve();
        }
        canceler = $q.defer();
        $scope.filterLoading = true;
        var minPrice = $("#priceRange").slider("values", 0);
        var maxPrice = $("#priceRange").slider("values", 1);
        var rate = $('#rateFilter').raty('score');
        if (rate === null || rate === undefined) {
            rate = 0;
        }
        var data = {"searchText": search, "rate": rate, "minPrice": minPrice, "maxPrice": maxPrice,
            "tripTypeIDs": $scope.tripTypeIDs, "groupTypeIDs": $scope.groupTypeIDs, "amenitiesIDs": $scope.amenitiesIDs, "pageNumber": $scope.currentPage};
        $http.post(searchWithFilterUrl, data, {timeout: canceler.promise})
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        $scope.advancedSearch.packages = response.data;
                        $scope.currentPage = 1;
                        $scope.filterLoading = false;
//                        $('html, body').animate({
//                            scrollTop: 0
                        //                        }, 300);
                    }
                });
        if ($(".page-search").hasClass("filters-open")) {
            $(".page-search").removeClass("filters-open");
        }
    };
    $scope.loadFilterOptions = function () {
        $scope.loadingFilter = true;
        var data = {"searchText": search};
        $http.post(getFilterUrl, data)
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        $scope.filterOptions = response.data;
                        $scope.loadingFilter = false;
                    }
                });
    };
    $scope.loadFilterOptions();
    $scope.closeQuickView = function ($event) {
        var selectedPackage = $(angular.element($event.currentTarget)).parents(".package-box");
        if (selectedPackage.children(".category-item-block").is(":hidden")) {
            selectedPackage.children(".category-item-block").slideDown("300");
        }
    };
    $scope.addKeyword = function () {
        var data = {"keyword": $scope.search};
        var insertKeywordUrl = service.getContextPath() + "/Common/NewKeyword";
        $http.post(insertKeywordUrl, data)
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    }
                });
    };
    $scope.addKeyword();
    $scope.initPriceSlider = function () {
        var minValue = 0;
        var maxValue = 1000;
        $("#priceRange").slider({
            range: true,
            min: 0,
            max: 1000,
            values: [0, 1000],
            slide: function (event, ui) {
                //                                                                $("#amount").val("$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ]);
                $("#priceRange").find(".ui-slider-handle").first().html("$" + ui.values[ 0 ]);
                $("#priceRange").find(".ui-slider-handle").last().html("$" + ui.values[ 1 ]);
            },
            create: function (event, ui) {
                $("#priceRange").find(".ui-slider-handle").first().html("$" + minValue);
                $("#priceRange").find(".ui-slider-handle").last().html("$" + maxValue);
            },
            stop: function (event, ui) {
                if (!$(".page-search").hasClass("filters-open")) {
                    $scope.filterPackage();
                }

            }
        });
//        $("#rateFilter").raty({
//            starOff: service.getContextPath() + '/Resources/Theme/image/greystar.png',
//            starOn: service.getContextPath() + '/Resources/Theme/image/yelstar.png',
//            click: function (score, evt) {
//                if (!$(".page-search").hasClass("filters-open")) {
//                    $scope.filterPackage();
//                }
//            }
//        });
    };
    $scope.initPriceSlider();
    $scope.openFilters = function () {
        if ($(".page-search").hasClass("filters-open")) {
            $(".page-search").removeClass("filters-open");
        } else {
            $(".page-search").addClass("filters-open");
        }
    };
});
myApp.controller('BookingController', function ($scope, $http, service) {
    $scope.loaded = false;
    $scope.packageList = packages;
    $scope.page = page;
    $scope.pageSize = 5;
    $scope.currentPage = 1;
    $scope.total = 0;
    $scope.hideIfEmpty = true;
    $scope.ulClass = 'pagination';
    $scope.adjacent = 1;
    $scope.activeClass = 'active';
    $scope.disabledClass = 'disabled';
    $scope.showPrevNext = true;
    $scope.DoCtrlPagingAct = function (text, page, pageSize, total) {
        $scope.currentPage = page;
    };
    $scope.detailList;
    $scope.sizeOfHashMap = function (obj) {
        var size = 0, key;
        for (key in obj) {
            if (obj.hasOwnProperty(key))
                size++;
        }
        return size;
    };
    $scope.ExportBooking = function (packageID) {
        var data = {"packageID": packageID};
        $http.post(ExportPackageStatictis, data)
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        $(location).attr('href', response.data);
                    }
                });
    };
    $scope.loadingBooking = false;
    $scope.viewDetail = function (packageID) {
        $scope.loadingBooking = true;
        var contentElemnt = "#package" + packageID + " .accodion-content";
        var captionElemnt = "#package" + packageID + " .accodion-caption";
        //        var tableBodyElement = $(contentElemnt).find(".table tbody");
        $http.get(bookingUrl + packageID)
                .success(function (response) {
                    if (response === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        $scope.detailList = response;
                        $scope.total = $scope.sizeOfHashMap($scope.detailList);
                        $scope.loadingBooking = false;
                    }
                });
        if ($(contentElemnt).is(":visible")) {
            $(contentElemnt).stop(true, true).slideUp(300, function () {
                $(".accodion-caption-active").removeClass("accodion-caption-active");
                $(".accodion-content-active").removeClass("accodion-content-active");
            });
        } else {
            $('.accodion-content').slideUp(300, function () {
                $(".accodion-caption-active").removeClass("accodion-caption-active");
                $(".accodion-content-active").removeClass("accodion-content-active");
            });
            $(contentElemnt).stop(true, true).slideDown(300, function () {
                $(contentElemnt).addClass("accodion-content-active");
                $(captionElemnt).addClass("accodion-caption-active");
            });
        }
    };
//    if ($scope.packageList.length > 0) {
//        alert("aaa");
//        alert($scope.packageList[0].id);
//        $scope.viewDetail($scope.packageList[0].id);
//    }
    $scope.loaded = true;
});
myApp.controller('SalesController', function ($scope, service, $http) {
    $scope.loaded = false;
    $scope.AccountOverview = bookingSale;
    $scope.PackagePayment = packageSale;
    $scope.currentMonth = service.getCurrentMonth();
    $scope.currentYear = service.getCurrentYear();
    $scope.page = page;
    $scope.pageSize = 5;
    $scope.currentPage = 1;
    $scope.startIndex = $scope.currentPage - 1;
    $scope.total = $scope.PackagePayment.length;
    $scope.hideIfEmpty = true;
    $scope.ulClass = 'pagination';
    $scope.adjacent = 1;
    $scope.activeClass = 'active';
    $scope.disabledClass = 'disabled';
    $scope.showPrevNext = true;
    $scope.providerID = providerID;
    $scope.ExportSale = function (ProviderID) {
        var data = {"ExportSales": $scope.PackagePayment, "ProviderID": $scope.providerID};
        $http.post(ExportSaleURL, data)
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    }
                    {
                        $(location).attr('href', response.data);
                    }
                });
    };
    $scope.DoCtrlPagingAct = function (text, page, pageSize, total) {
        $scope.currentPage = page;
        $scope.startIndex = ($scope.currentPage - 1) * $scope.pageSize;
    };
    $scope.loaded = true;
});
myApp.controller('NotificationController', function ($scope) {
    $scope.loaded = false;
    $scope.Notifications = notifications;
    $scope.providerSetting = providerSetting;
    $scope.page = page;
    $scope.loaded = true;
    $scope.default = 5;
});
myApp.controller('ChatController', function ($scope, $http, service) {
    $scope.page = page;
    $scope.userID = userID;
    $scope.userName = userName;
    $scope.userRole = userType;
    $scope.userImage = userImage;
    var stompClient = null;
    var subscribe = "/topic/long";
    var receive = "/app/hello/long";
    $scope.chatType = 'null';
    $scope.selectedConv = conversationID;
    $scope.selectedBook = bookingID;
    $scope.loadingConvDatail = false;
    $scope.loadingScroll = false;
    $scope.sending = false;
    $scope.default = 5;
    $scope.currentConversationID = 0;
    $scope.currentTripperID = 0;
    $scope.messageWatcher = [{'conversationID': 0, 'replyToTripperID': 0, 'chatTimes': 1, 'times': 1}];
    localStorage.setItem("localMessage", "");
    Date.prototype.customFormat = function (formatString) {
        var YYYY, YY, MMMM, MMM, MM, M, DDDD, DDD, DD, D, hhhh, hhh, hh, h, mm, m, ss, s, ampm, AMPM, dMod, th;
        YY = ((YYYY = this.getFullYear()) + "").slice(-2);
        MM = (M = this.getMonth() + 1) < 10 ? ('0' + M) : M;
        MMM = (MMMM = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"][M - 1]).substring(0, 3);
        DD = (D = this.getDate()) < 10 ? ('0' + D) : D;
        DDD = (DDDD = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"][this.getDay()]).substring(0, 3);
        th = (D >= 10 && D <= 20) ? 'th' : ((dMod = D % 10) === 1) ? 'st' : (dMod === 2) ? 'nd' : (dMod === 3) ? 'rd' : 'th';
        formatString = formatString.replace("#YYYY#", YYYY).replace("#YY#", YY).replace("#MMMM#", MMMM).replace("#MMM#", MMM).replace("#MM#", MM).replace("#M#", M).replace("#DDDD#", DDDD).replace("#DDD#", DDD).replace("#DD#", DD).replace("#D#", D).replace("#th#", th);
        h = (hhh = this.getHours());
        if (h == 0)
            h = 24;
        if (h > 12)
            h -= 12;
        hh = h < 10 ? ('0' + h) : h;
        hhhh = h < 10 ? ('0' + hhh) : hhh;
        AMPM = (ampm = hhh < 12 ? 'am' : 'pm').toUpperCase();
        mm = (m = this.getMinutes()) < 10 ? ('0' + m) : m;
        ss = (s = this.getSeconds()) < 10 ? ('0' + s) : s;
        return formatString.replace("#hhhh#", hhhh).replace("#hhh#", hhh).replace("#hh#", hh).replace("#h#", h).replace("#mm#", mm).replace("#m#", m).replace("#ss#", ss).replace("#s#", s).replace("#ampm#", ampm).replace("#AMPM#", AMPM);
    };
    $scope.$watch('messageList', function (newVal, oldVal) {
        for (var i = 0; i < $scope.messageList.length; i++) {
            var flag = 0;
            for (var j = 0; j < $scope.messageWatcher.length; j++) {
                if ($scope.messageWatcher[j].replyToTripperID === $scope.messageList[i].replyToTripperID && $scope.messageWatcher[j].conversationID === $scope.messageList[i].conversationID) {
                    flag = 1;
                }
            }
            if (flag === 0) {
                $scope.temp = {'conversationID': $scope.messageList[i].conversationID, 'replyToTripperID': $scope.messageList[i].replyToTripperID, 'chatTimes': 1, 'times': 1};
                $scope.messageWatcher.push($scope.temp);
            }

        }
        //format date
//        for (var i = 0; i < $scope.messageList.length; i++) {
//            $scope.messageList[i].time = $scope.formatToDate($scope.messageList[i].time);
//        }
    });
    $scope.loadMoreMessage = function (conversationID, tripperID) {
        $scope.loadTime = 0;
        for (var i = 0; i < $scope.messageWatcher.length; i++) {
            if ($scope.messageWatcher[i].conversationID === conversationID && $scope.messageWatcher[i].replyToTripperID === tripperID) {
                $scope.loadTime = $scope.messageWatcher[i].times * 5 + $scope.messageWatcher[i].chatTimes;
                $scope.messageWatcher[i].times++;
            }
        }

        var data = {"conversationID": conversationID, "replyToTripperID": tripperID, "numberOfRecord": $scope.loadTime};
        $http.post(service.getContextPath() + "/Message/loadMoreConvMessage", data)
                .then(function successCallback(response) {
                    if (response.data === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        for (var i = 0; i < response.data.length; i++) {
                            response.data[i].message = JSON.parse(response.data[i].message);
                            $scope.loadedMessage = response.data;
                        }
                        if (localStorage.getItem("localMessage") === "") {
                            localStorage.setItem("localMessage", JSON.stringify($scope.loadedMessage));
                        } else {
                            $scope.oldMess = JSON.parse(localStorage.getItem("localMessage"));
                            for (var i = 0; i < $scope.loadedMessage.length; i++) {
                                var flag = 0;
                                for (var j = 0; j < $scope.oldMess.length; j++) {
                                    if ($scope.loadedMessage[i].messageID === $scope.oldMess[j].messageID) {
                                        flag = 1;
                                    }
                                }
                                if (flag === 0) {
                                    $scope.loadedMessage[i].time = $scope.formatToDate($scope.loadedMessage[i].time);
                                    $scope.oldMess.push($scope.loadedMessage[i]);
                                }
                            }
                            localStorage.setItem("localMessage", JSON.stringify($scope.oldMess));
                        }
                        //load messageList again
                        $scope.newMess = JSON.parse(localStorage.getItem("localMessage"));
                        for (var i = 0; i < $scope.newMess.length; i++) {
                            var flag = 0;
                            for (var j = 0; j < $scope.messageList.length; j++) {
                                if ($scope.newMess[i].messageID === $scope.messageList[j].messageID) {
                                    flag = 1;
                                }
                            }
                            if (flag === 0) {
                                $scope.messageList.push($scope.newMess[i]);
                            }
                        }
                    }
                });
    };
    if ($scope.userRole === '1' || $scope.userRole === 1) {
        $scope.currentTripperID = $scope.userID;
    }

    $scope.setConnected = function (connected) {

    };
    $scope.$watch('selectedConv', function (newVal, oldVal) {
        if (newVal !== null && newVal > 0) {
            $scope.chatType = 'Conversation';
            $scope.loadingConvDatail = true;
            $scope.default = 5;
            localStorage.setItem("localMessage", "");
            $scope.viewConversationDetail(newVal, $scope.default);
            $('#textReply').focus();
            if (!$("#chatPage").hasClass("selected-conversation")) {
                $("#chatPage").addClass("selected-conversation");
                $("#chatPage").removeClass("selected-messages");
            }
        }

    });
    $scope.$watch('selectedBook', function (newVal, oldVal) {
        if (newVal !== null) {
            $scope.chatType = 'Booking';
            $scope.loadingConvDatail = true;
            $scope.viewDetail(newVal, $scope.default);
            $('#textReply').focus();
            if (!$("#chatPage").hasClass("selected-conversation")) {
                $("#chatPage").addClass("selected-conversation");
                $("#chatPage").removeClass("selected-messages");
            }
        }

    });
    $scope.conversationList = conversationList1;
    if ($scope.conversationList !== null) {
        for (var i = 0; i < $scope.conversationList.length; i++) {

            $scope.conversationList[i].latestMessage = JSON.parse($scope.conversationList[i].latestMessage);
        }
    }
    $scope.$watch('conversationList', function (newVal, oldVal) {
        if (newVal !== undefined && newVal !== null) {
            setTimeout(function () {
                if ($("#Messages .list-resulft li.active").length > 0) {
                    $('#Messages .message-left').animate({
                        scrollTop: $("#Messages .list-resulft li.active").offset().top
                    }, 300);
                }
                contentElement.scrollTop(contentElement[0].scrollHeight);
            }, 1);
        }

    });
    $scope.$watch('names', function (newVal, oldVal) {
        if (newVal !== undefined && newVal !== null) {
            setTimeout(function () {
                if ($("#Booking .list-resulft li.active").length > 0) {
                    $('#Booking .message-left').animate({
                        scrollTop: $("#Booking .list-resulft li.active").offset().top
                    }, 300);
                }
            }, 1);
        }

    });
    $scope.connect = function () {
        var socket = new SockJS(websocketURL);
        stompClient = Stomp.over(socket);
//        stompClient.debug = null;
        stompClient.connect({}, function (frame) {
            $scope.setConnected(true);
            stompClient.subscribe(subscribe, function (greeting) {
                $scope.showGreeting(JSON.parse(greeting.body).content);
            });
        });
    };
    $scope.disconnect = function () {
        if (stompClient !== null) {

        }
        $scope.setConnected(false);
    };
    var contentElement = $(".messConversation");
    var anotherContentElement = $("#chatBox");
    $('#textReply').keypress(function (event) {
        if (event.keyCode === 13 && !event.shiftKey) {
            event.preventDefault();
            $scope.sending = true;
            $scope.default++;
            $scope.$digest();
            contentElement.scrollTop(contentElement[0].scrollHeight);
            $scope.sendName();
            $('#textReply').val("");
        }
    });
    $scope.SelectedConversationChange = function (id) {
        $scope.selectedConv = id;
        $scope.selectedBook = null;
    };
    $scope.SelectedBookingChange = function (id) {
        $scope.selectedBook = id;
        $scope.selectedConv = -1;
        $scope.default = 5;
    };
    Date.prototype.HHmmddMMyyyy = function () {
        var yyyy = this.getFullYear().toString();
        var mm = (this.getMonth() + 1).toString(); // getMonth() is zero-based
        var dd = this.getDate().toString();
        var HH = this.getHours().toString();
        var MM = this.getMinutes().toString();
        return (HH[1] ? HH : "0" + HH[0]) + ":" + (MM[1] ? MM : "0" + MM[0]) + " " + (dd[1] ? dd : "0" + dd[0]) + "/" + (mm[1] ? mm : "0" + mm[0]) + "/" + yyyy; // padding
    };
    $scope.$watch('messageList', function (newVal, oldVal) {
        if ($scope.messageList !== 'undefined' && $scope.messageList !== null && $scope.messageList !== '' && $scope.messageList !== ' ' && $scope.messageList !== undefined) {
            for (var i = 0; i < $scope.messageList.length; i++) {
                if ($scope.messageList[i].message.content === '' || $scope.messageList[i].message.content === ' ') {
                    $scope.messageList.splice(i, 1);
                }
                if ($scope.chatType !== 'Conversation') {
                    if ($scope.userRole !== '2') {
                        $scope.messageList[i].message = JSON.parse($scope.messageList[i].message);
                    }
                } else {
                    $scope.messageList[i].message = JSON.parse($scope.messageList[i].message);
                }

            }
        }
    });
    $scope.sendName = function () {
        //        $scope.default = $scope.default + 1;

        var name = document.getElementById('textReply').value;
        name = name.replace(/\r\n|\r|\n/g, "\\n");
        var now = new Date();
        var type = "tripper";
        if ($scope.userRole !== '1') {
            type = "provider";
        }
        var newMessage = {"messageID": 9999999999999999, "userType": type,
            "time": now.HHmmddMMyyyy(), "message": {"content": name, "type": "text"},
            "userID": $scope.userID, "conversationID": $scope.currentConversationID, "name": $scope.userName,
            "avatar": $scope.userImage, "isRead": false, 'replyToTripperID': $scope.currentTripperID};
        if ($scope.chatType === 'Conversation') {
            if ($scope.userRole === '2') {

            } else {
                $scope.messageList.push(newMessage);
                $scope.$digest();
                contentElement.scrollTop(contentElement[0].scrollHeight);
            }
        } else {
            $scope.messageList.push(newMessage);
            $scope.$digest();
            contentElement.scrollTop(contentElement[0].scrollHeight);
        }

        stompClient.send(receive, {}, JSON.stringify({'content': name, 'userType': userType, 'userID': userID, 'name': userName, 'replyToTripperID': $scope.currentTripperID}));
//        if ($scope.chatType !== 'Booking') {
//            $scope.viewConversationList();
//        }
        //        $('#textReply').val('');
        $scope.loadLastestMessage($scope.currentConversationID, $scope.currentTripperID);
    };
    $scope.loadLastestMessage = function (conversationID, tripperID) {
        if ($scope.chatType !== 'Booking' && $scope.userRole === '2') {
            $scope.loadingTimes = 0;
            for (var i = 0; i < $scope.messageWatcher.length; i++) {
                if ($scope.messageWatcher[i].conversationID === conversationID && $scope.messageWatcher[i].replyToTripperID === tripperID) {
                    $scope.loadingTimes = $scope.messageWatcher[i].chatTimes;
                    $scope.messageWatcher[i].chatTimes++;
                }
            }
            if ($scope.loadingTimes === 0) {
                $scope.loadingTimes = 1;
            }
            var data = {"conversationID": conversationID, "replyToTripperID": tripperID, "numberOfRecord": $scope.loadingTimes};
            $http.post(service.getContextPath() + "/Message/loadMoreConvMessage", data)
                    .then(function successCallback(response) {
                        if (response.data === "error") {
                            var pageError = service.getContextPath() + service.getErrorPageUrl();
                            $(location).attr('href', pageError);
                        } else {
                            for (var i = 0; i < response.data.length; i++) {
                                response.data[i].message = JSON.parse(response.data[i].message);
                                $scope.loadedMessage = response.data;
                            }
                            if (localStorage.getItem("localMessage") === "" && localStorage.getItem("localMessage") !== 'undefined') {
//                                for (var j = 0; j < $scope.loadedMessage.length; j++) {
//                                    $scope.loadedMessage[j].time = $scope.formatToDate($scope.loadedMessage[j].time);
//                                }
                                localStorage.setItem("localMessage", JSON.stringify($scope.loadedMessage));
                            } else {
                                $scope.oldMess = JSON.parse(localStorage.getItem("localMessage"));
                                for (var i = 0; i < $scope.loadedMessage.length; i++) {
                                    var flag = 0;
                                    for (var j = 0; j < $scope.oldMess.length; j++) {
                                        if ($scope.loadedMessage[i].messageID === $scope.oldMess[j].messageID) {
                                            flag = 1;
                                        }
                                    }
                                    if (flag === 0) {
//                                        $scope.loadedMessage[i].time = $scope.formatToDate($scope.loadedMessage[i].time);
                                        $scope.oldMess.push($scope.loadedMessage[i]);
                                    }
                                }
                                localStorage.setItem("localMessage", JSON.stringify($scope.oldMess));
                            }
                            //load messageList again
                            $scope.newMess = JSON.parse(localStorage.getItem("localMessage"));
                            for (var i = 0; i < $scope.newMess.length; i++) {
                                var flag = 0;
                                for (var j = 0; j < $scope.messageList.length; j++) {
                                    if ($scope.newMess[i].messageID === $scope.messageList[j].messageID) {
                                        flag = 1;
                                        if ($scope.messageList[i].messageID === 9999999999999999) {
                                            $scope.messageList.splice(i, 1);
                                        }
                                    }
                                }
                                if (flag === 0) {
//                                    $scope.newMess[i].time = $scope.formatToDate($scope.newMess[i].time);
                                    $scope.messageList.push($scope.newMess[i]);
                                }
                            }
                        }
                    });
        }
    }
    $scope.formatToDate = function (time) {
        var date = new Date(time).customFormat("#hh#:#mm# #DD#/#MM#/#YYYY#");
        return date;
    }
    $scope.replyToConv = function (conversationID, tripperID) {
        $('#textReply').focus();
        $scope.currentConversationID = conversationID;
        $scope.currentTripperID = tripperID;
        $scope.replyToTripperName;
        for (var i = 0; i < $scope.messageList.length; i++) {
            if ($scope.currentTripperID === $scope.messageList[i].userID) {
                $scope.replyToTripperName = $scope.messageList[i].name;
            }
        }
        document.getElementById('textReply').placeholder = 'Replying to ' + $scope.replyToTripperName;
    }
    $scope.$watch('messageList.length', function (newVal, oldVal) {
//        alert($scope.messageList.length - 1);
//        alert($scope.messageList[$scope.messageList.length - 1 ].message.content);
    });
    $scope.showGreeting = function (message) {
        var result = JSON.parse(message);
        if (result.Type === 'booking') {
            $scope.viewDetail();
            if ($scope.chatType === 'Booking') {
                $scope.viewBooking();
            }
        } else {
            $scope.viewConversationDetail();
            if ($scope.chatType !== 'Booking') {
                $scope.viewConversationList();
            }
        }
        if ($scope.chatType === 'Conversation') {
            if ($scope.userRole === '2') {

            } else {
                contentElement.scrollTop(contentElement[0].scrollHeight);
            }
        } else {
            contentElement.scrollTop(contentElement[0].scrollHeight);
        }
        //        alert("bbbbb");
    };
    $scope.$watch('uploadImage', function () {
        if ($scope.uploadImage !== undefined && $scope.uploadImage !== null) {
            $scope.default = $scope.default + 1;
            if ($scope.chatType === 'Booking') {
                $scope.loadingConvDatail = true;
                $scope.sending = true;
                $scope.ImageUploader($scope.uploadImage);
            } else {
                $scope.loadingConvDatail = true;
                $scope.sending = true;
                $scope.ImageUploaderForConversation($scope.uploadImage);
            }
        }
    });
    $scope.$watch('uploadFile', function () {
        if ($scope.uploadFile !== undefined && $scope.uploadFile !== null) {
            $scope.default = $scope.default + 1;
            if ($scope.chatType === 'Booking') {
                $scope.loadingConvDatail = true;
                $scope.sending = true;
                $scope.FileUploader($scope.uploadFile);
            } else {
                $scope.loadingConvDatail = true;
                $scope.sending = true;
                $scope.FileUploaderForConversation($scope.uploadFile);
            }
        }
    });
    $scope.FileUploader = function (uploadFile) {
        var formData = new FormData();
        formData.append("uploadFile", uploadFile);
        formData.append("bookingID", $scope.chatname.bookingID);
        $.ajax({
            url: fileuploaderBooking,
            type: "POST",
            dataType: 'text',
            contentType: false,
            processData: false,
            cache: false,
            data: formData,
            success: function (response) {
                if (response !== "false") {
                } else {
                    alert("Wrong input!");
                }
            },
            error: function (response) {
            }
        });
    };
    $scope.FileUploaderForConversation = function (uploadFile) {
        var formData = new FormData();
        formData.append("uploadFile", uploadFile);
        formData.append("conversationID", $scope.chatname.bookingID);
        $.ajax({
            url: fileUploaderConversation,
            type: "POST",
            dataType: 'text',
            contentType: false,
            processData: false,
            cache: false,
            data: formData,
            success: function (response) {
                if (response !== "false") {
                } else {
                    alert("Wrong input!");
                }
            },
            error: function (response) {
                console.log(response);
            }
        });
    };
    $scope.ImageUploader = function (uploadImage) {
        var formData = new FormData();
        formData.append("uploadImage", uploadImage);
        formData.append("bookingID", $scope.chatname.bookingID);
        $.ajax({
            url: ImageUploaderBooking,
            type: "POST",
            dataType: 'text',
            contentType: false,
            processData: false,
            cache: false,
            data: formData,
            success: function (response) {
                if (response !== "false") {
                    console.log("success");
                } else {
                    alert("Wrong input!");
                }
            },
            error: function (response) {
                console.log(response);
            }
        });
    };
    $scope.ImageUploaderForConversation = function (uploadImage) {
        var formData = new FormData();
        formData.append("uploadImage", uploadImage);
        formData.append("conversationID", $scope.chatname.bookingID);
        $.ajax({
            url: ImageUploaderConversation,
            type: "POST",
            dataType: 'text',
            contentType: false,
            processData: false,
            cache: false,
            data: formData,
            success: function (response) {
                if (response !== "false") {
                    console.log("success");
                } else {
                    alert("Wrong input!");
                }
            },
            error: function (response) {
                console.log(response);
            }
        });
    };
    $scope.testFunc = function (x, y, z) {
        $scope.viewConversationList();
        $scope.viewConversationDetail();
    };
    $scope.viewBooking = function () {
        $http.get(viewBooking)
                .success(function (response) {
                    if (response === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        $scope.names = response;
                    }
                });
    };
    $scope.viewConversationList = function () {
        $http.get(viewConversation)
                .success(function (response) {
                    if (response === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        $scope.conversationList = response;
                        for (var i = 0; i < $scope.conversationList.length; i++) {
                            $scope.conversationList[i].latestMessage = JSON.parse($scope.conversationList[i].latestMessage);
                        }
                    }
                });
    };
    $scope.ReadBooking3 = function () {
        $(document).ready(function () {

            $('#textReply').blur(function () {
            })
                    .focus(function () {
                        if ($($('.tasleft-caption li')[1]).hasClass('active')) {
                            var receiveofUnread = "/app/hello/package/" + $scope.selectedBook;
                            if ($scope.userRole === 1 || $scope.userRole === '1') {
                                stompClient.send(receiveofUnread, {}, JSON.stringify({'content': 'SeenMessage', 'userType': 1, 'userID': 0, 'name': $scope.selectedBook}));
                            } else {
                                stompClient.send(receiveofUnread, {}, JSON.stringify({'content': 'SeenMessage', 'userType': 2, 'userID': 0, 'name': $scope.selectedBook}));
                            }
                        } else if ($($('.tasleft-caption li')[0]).hasClass('active')) {
                            var receiveofUnread = "/app/hello/chatting/" + $scope.selectedConv;
                            if ($scope.userRole === '1' || $scope.userRole === '1') {

                                stompClient.send(receiveofUnread, {}, JSON.stringify({'content': 'SeenMessage', 'userType': 1, 'userID': 0, 'name': $scope.selectedConv}));
                            } else {
                                stompClient.send(receiveofUnread, {}, JSON.stringify({'content': 'SeenMessage', 'userType': 2, 'userID': 0, 'name': $scope.selectedConv}));
                            }
                        }

                    });
        });
    }
    $scope.ReadBooking3();
    $scope.viewDetail = function () {
        subscribe = "/topic/package/" + $scope.selectedBook;
        receive = "/app/hello/package/" + $scope.selectedBook;
        $scope.chatType = 'Booking';
        $scope.disconnect();
        $scope.connect();
        $scope.chatname = {bookingID: $scope.selectedBook};
        $http.get(getBookingMessURL + "/" + $scope.default + "/" + $scope.selectedBook)
                .success(function (response) {
                    if (response === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        $scope.messageList = response;
                        for (var i = 0; i < $scope.messageList.length; i++) {
                            $scope.messageList[i].message = JSON.parse($scope.messageList[i].message);
                        }
                        $scope.loadingConvDatail = false;
                        $scope.sending = false;
                        if ($scope.chatType === 'Conversation') {
                            if ($scope.userRole === '2') {

                            } else {
                                contentElement.scrollTop(contentElement[0].scrollHeight);
                            }
                        } else {
                            if ($scope.loadingScroll === false) {
                                setTimeout(function () {
                                    contentElement.scrollTop(contentElement[0].scrollHeight);
                                    anotherContentElement.scrollTop(contentElement[0].scrollHeight);
                                }, 1);
                            } else {
                                $scope.loadingScroll = false;
                            }
                        }
                    }
                });
    };
    $scope.viewConversationDetail = function () {
        //        $scope.selectedConv = x;
        subscribe = "/topic/chatting/" + $scope.selectedConv;
        receive = "/app/hello/chatting/" + $scope.selectedConv;
        $scope.chatType = 'Conversation';
        //        alert($scope.chatType);
        $scope.disconnect();
        $scope.connect();
        $scope.chatname = {bookingID: $scope.selectedConv};
        var data = {"conversationID": $scope.selectedConv, "NumberOfRecords": $scope.default};
        $http.post(getConMessURL, data)
                .then(function (response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        for (var i = 0; i < response.length; i++) {
                            response[i].message = JSON.parse(response[i].message);
                        }
                        $scope.messageList = response.data;
                        if ($scope.chatType === 'Conversation' && $scope.userRole === '2') {
                            $scope.messageList[i].message = JSON.parse($scope.messageList[i].message);
                        }

                        $scope.loadingConvDatail = false;
                        $scope.sending = false;
                        if ($scope.chatType === 'Conversation') {
                            if ($scope.userRole === '2') {

                            } else {
                                contentElement.scrollTop(contentElement[0].scrollHeight);
                            }
                        } else {
                            if ($scope.loadingScroll === false) {
                                setTimeout(function () {
                                    contentElement.scrollTop(contentElement[0].scrollHeight);
                                    anotherContentElement.scrollTop(contentElement[0].scrollHeight);
                                }, 1);
                            } else {
                                $scope.loadingScroll = false;
                            }
                        }
                        if ($scope.chatType !== 'Booking' && $scope.userRole === '2' && localStorage.getItem("localMessage") !== '' && localStorage.getItem("localMessage") !== 'undefined') {
                            $scope.newMess = JSON.parse(localStorage.getItem("localMessage"));
                            for (var i = 0; i < $scope.newMess.length; i++) {
                                var flag = 0;
                                for (var j = 0; j < $scope.messageList.length; j++) {
                                    if ($scope.newMess[i].messageID === $scope.messageList[j].messageID) {
                                        flag = 1;
                                    }
                                }
                                if (flag === 0) {
                                    $scope.messageList.push($scope.newMess[i]);
                                }
                            }
                        }
                    }
                });
    };
    if ($scope.selectedBook !== null) {
        $('#BookingLI').click();
        $scope.viewBooking();
    }
    $scope.selectOrNot = function (selectedConversationID) {
        if (selectedConversationID === $scope.selectedConv) {
            return true;
        } else {
            return false;
        }
    };
    $scope.selectedBookingOrNot = function (selectedBookingID) {
        if (selectedBookingID === $scope.selectedBook) {
            return true;
        } else {
            return false;
        }
    };
    $scope.checkFile = function (mymessage) {
        if (mymessage.type == 'file' || mymessage.type == 'image') {
            return true;
        } else {
            return false;
        }
    };
    $scope.checkText = function (mymessage) {
        if (mymessage.type === 'text') {
            return true;
        } else {
            return false;
        }
    };
    $scope.detectScrollToTop = function () {
        $(function () {
            $('#messConversation').bind('scroll', function ()
            {
                if ($('#messConversation').scrollTop() === 0 && !$scope.loadingScroll) {
                    $scope.loadingScroll = true;
                    $scope.default += 5;
                    $scope.$digest();
                    if ($scope.chatType === 'Booking') {
                        $scope.viewDetail();
                    } else {
                        if ($scope.userRole === '1') {
                            $scope.viewConversationDetail();
                        }
                    }
                    $scope.loadingScroll = false;
                    //                    $scope.$digest();
                }

            });
        });
    };
    $scope.loadMoreConv = function () {
        $scope.default += 5;
        $scope.viewConversationDetail();
    };
    $scope.detectScrollToTop();
    $scope.backToMessages = function () {
        if (!$("#chatPage").hasClass("selected-messages")) {
            $("#chatPage").addClass("selected-messages");
            $("#chatPage").removeClass("selected-conversation");
        }
    };
    if ($scope.userRole === 1 || $scope.userRole === '1') {
        var stompClient1 = null;
        var stompClient2 = null;
        $scope.connectConvForUnread = function () {
            var subscribeofUnread = '/topic/getUnReadConvForTripper/' + $scope.userID;
            $(document).ready(function () {
                var socket = new SockJS(websocketURL);
                stompClient1 = Stomp.over(socket);
//                stompClient1.debug = null;
                stompClient1.connect({}, function (frame) {
                    $scope.setConnected(true);
                    console.log('Connected: ' + frame);
                    stompClient1.subscribe(subscribeofUnread, function (greeting) {
                        //reload Con
                        if ($($('.tasleft-caption li')[0]).hasClass('active')) {
                            $scope.viewConversationList();
                        }
                    });
                });
            });
        };
        $scope.connectBookingForUnread = function () {
            var receiveofUnread = '/hello/getUnReadBookingForTripper/' + $scope.userID;
            var subscribeofUnread = '/topic/getUnReadBookingForTripper/' + $scope.userID;
            $(document).ready(function () {
                var socket = new SockJS(websocketURL);
                stompClient2 = Stomp.over(socket);
//                stompClient2.debug = null;
                stompClient2.connect({}, function (frame) {
                    $scope.setConnected(true);
                    stompClient2.subscribe(subscribeofUnread, function (greeting) {
                        //reload Con
                        if (!$($('.tasleft-caption li')[0]).hasClass('active')) {
                            $scope.viewBooking();
                        }

                    });
                });
            });
        };
        $scope.connectConvForUnread();
        $scope.connectBookingForUnread();
    } else if ($scope.userRole === 2 || $scope.userRole === '2') {
        var stompClient1 = null;
        var stompClient2 = null;
        $scope.connectConvForUnread = function () {
            var receiveofUnread = '/hello/getUnReadConvForProvider/' + $scope.userID;
            var subscribeofUnread = '/topic/getUnReadConvForProvider/' + $scope.userID;
            $(document).ready(function () {
                var socket = new SockJS(websocketURL);
                stompClient1 = Stomp.over(socket);
//                stompClient1.debug = null;
                stompClient1.connect({}, function (frame) {
                    $scope.setConnected(true);
                    stompClient1.subscribe(subscribeofUnread, function (greeting) {
                        //reload Con
                        if ($($('.tasleft-caption li')[0]).hasClass('active')) {
                            $scope.viewConversationList();
                        }
                    });
                });
            });
        };
        $scope.connectBookingForUnread = function () {
            var receiveofUnread = '/hello/getUnReadBookingForProvider/' + $scope.userID;
            var subscribeofUnread = '/topic/getUnReadBookingForProvider/' + $scope.userID;
            $(document).ready(function () {
                var socket = new SockJS(websocketURL);
                stompClient2 = Stomp.over(socket);
//                stompClient2.debug = null;
                stompClient2.connect({}, function (frame) {
                    $scope.setConnected(true);
                    stompClient2.subscribe(subscribeofUnread, function (greeting) {
                        //reload Con
                        if (!$($('.tasleft-caption li')[0]).hasClass('active')) {
                            $scope.viewBooking();
                        }

                    });
                });
            });
        };
        $scope.connectConvForUnread();
        $scope.connectBookingForUnread();
    }

    $scope.ReadConv = function (convID) {
        var data = {"conversationID": convID, "userType": $scope.userRole};
        $http.post(readConvURL, data)
                .then(function successCallback(response) {
                    if (response.data === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        console.log(response.data);
                    }
                });
    };
    $scope.ReadBooking = function (convID) {
        var data = {"bookingID": convID, "userType": $scope.userRole};
        $http.post(readBookingURL, data)
                .then(function successCallback(response) {
                    if (response.data === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        console.log(response.data);
                    }
                });
    };
});
myApp.controller('TripperNotificationController', function ($scope) {
    $scope.loaded = false;
    $scope.Notifications = notifications;
    $scope.tripperSetting = tripperSetting;
    $scope.page = page;
    $scope.loaded = true;
});
myApp.controller('BucketList', function ($scope) {
    $scope.loaded = false;
    $scope.bucketList = bucketList;
    $scope.page = page;
    $scope.loaded = true;
});
myApp.controller('BookingList', function ($scope) {
    $scope.loaded = false;
    $scope.BookingList = BookingList;
    $scope.sortType = 'bookingDate';
    $scope.page = page;
    $scope.loaded = true;
    $scope.convertTime = function (time) {
        var date = new Date(time * 1).toLocaleString();
        return date;
    }
});
myApp.controller('OptionsController', function ($scope, $http, service) {
    $scope.saveWishlist = function (packageID) {
        var data = {"packageID": packageID};
        var saveWishListUrl = service.getContextPath() + "/Tripper/SaveWishList";
        $http.post(saveWishListUrl, data)
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        $("div.package-option.active .wishlist-option").notify("Save Success!", {
                            position: "right",
                            autoHideDelay: 2000,
                            className: 'success',
                            gap: 10
                        });
                    }
                });
        $scope.toggleDevelopingBox();
    };
    $scope.removeFromWishlist = function (packageID, $event) {
        var data = {"packageID": packageID};
        var saveWishListUrl = service.getContextPath() + "/Tripper/RemoveFromWishList";
        $http.post(saveWishListUrl, data)
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        $("div.package-option.active .wishlist-option").notify("Removing Success!", {
                            position: "right",
                            autoHideDelay: 2000,
                            className: 'success',
                            gap: 10
                        });
                    }
                });
    };
    $scope.postResult = {};
    $scope.quickView = function (packageID, $event) {
        var packageOption = $(angular.element($event.currentTarget)).parents(".package-option");
        if (packageOption.hasClass("active")) {
//            packageOption.hide();
            packageOption.removeClass("active");
        }
    };
    var addComparisonUrl = service.getContextPath() + "/Common/AddToComparisonList";
    $scope.addToComparisonList = function (packageID, packageName) {
        var data = {"packageID": packageID};
        $http.post(addComparisonUrl, data)
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        if (response.data.result === 'exist') {
                            alert("This package is exist in your list.");
                        } else if (response.data.result === 'full') {
                            alert("Your comparison list is full.");
                        } else {
                            $scope.pushToComparisonList(response.data);
                        }
                    }
                });
    };
    $scope.quickComparison = function (packageID) {
        $scope.QuickComparisonList = null;
        var data = {packageID: packageID};
        var url = service.getContextPath() + '/Common/getQuickComparison';
        $('#ComparisonPopUp').css('display', '');
        $scope.loadingComparison = true;
        $http.post(url, data)
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        $scope.QuickComparisonList = response.data;
                        $scope.loadingComparison = false;
                    }
                });
    };
    $scope.closeComparison = function () {
        $('#ComparisonPopUp').css('display', 'none');
    };
});
myApp.controller('ChangeProviderPasswordController', function ($scope) {
    $scope.page = page;
    $scope.change = {"currentPassword": "", "password": "", "rePassword": ""};
    $scope.showError = {matchPassword: false, blankPass: false, all: false};
    $scope.missing = {matchPassword: false};
    $scope.validateChangePassword = function (event) {
        if ($scope["ChangePassForm"].$valid && $scope.change.password.length >= 8 && $scope.change.rePassword.length >= 8 &&
                $scope.missing.matchPassword === true && $scope.change.currentPassword.length) {
            return true;
        } else {
            $scope.showError.all = true;
            event.preventDefault();
        }
    };
    $scope.validatePassword = function () {
        if (angular.isString($scope.change.rePassword) && $scope.change.rePassword !== ""
                && angular.isString($scope.change.password) && $scope.change.password !== "") {
            $scope.showError.matchPassword = true;
            if ($scope.change.rePassword !== $scope.change.password) {
                $scope.missing.matchPassword = false;
            } else {
                $scope.missing.matchPassword = true;
            }
        } else {
            $scope.showError.matchPassword = false;
        }
    };
});
myApp.controller('ChangeTripperPasswordController', function ($scope) {
    $scope.page = page;
    $scope.change = {"currentPassword": "", "password": "", "rePassword": ""};
    $scope.showError = {matchPassword: false, blankPass: false, all: false};
    $scope.missing = {matchPassword: false};
    $scope.validateChangePassword = function (event) {
        if ($scope["ChangePassForm"].$valid && $scope.change.password.length >= 8 && $scope.change.rePassword.length >= 8 &&
                $scope.missing.matchPassword === true && $scope.change.currentPassword.length) {
            return true;
        } else {
            $scope.showError.all = true;
            event.preventDefault();
        }
    };
    $scope.validatePassword = function () {
        if (angular.isString($scope.change.rePassword) && $scope.change.rePassword !== ""
                && angular.isString($scope.change.password) && $scope.change.password !== "") {
            $scope.showError.matchPassword = true;
            if ($scope.change.rePassword !== $scope.change.password) {
                $scope.missing.matchPassword = false;
            } else {
                $scope.missing.matchPassword = true;
            }
        } else {
            $scope.showError.matchPassword = false;
        }
    };
});
myApp.controller('ComparisonController', function ($scope) {
    $scope.ComparisonList = comparisonList;
    $scope.checkComparisonList = function () {
        if ($scope.ComparisonList !== null) {
            return true;
        } else if ($scope.ComparisonList === null) {
            return false;
        }
    };
});
myApp.controller('ProviderPageController', function ($scope, $http, service) {
    $scope.ProviderInfo = providerInfo;
    $scope.certificates = certificates;
    $scope.ReportType = reportType;
    $scope.DisableValue = true;
    $scope.reason = "";
    $scope.totalRating = 0;
    $scope.totalReviews = 0;
    $scope.loading = false;
    $scope.certificateNameInit;
    $scope.certificateIDInit;
    $scope.certificateImage3;
    /* DEVELOPING BOX */
    $scope.toggleDevelopingBox = function () {
        $("#developingBox").toggleClass("active");
    };
    /* END DEVELOPING BOX */

    $scope.closeModal = function () {
        $('#myModal2').modal('hide');
    }

    $scope.changeName = function (name, ID, image) {
        $scope.certificateNameInit = name;
        $scope.certificateIDInit = ID;
        $scope.certificateImage3 = image;
        $scope.activeBigImageBox();
    }
    $scope.activeBigImageBox = function () {
        $("#bigCertificateImage").toggleClass("active");
    };
    for (var i = 0; i < $scope.ProviderInfo.packageList.length; i++) {
        $scope.totalRating = $scope.totalRating + ($scope.ProviderInfo.packageList[i].rate * $scope.ProviderInfo.packageList[i].numberRates);
        $scope.totalReviews += $scope.ProviderInfo.packageList[i].numberRates;
    }
    if ($scope.totalReviews > 0) {
        $scope.totalRating = $scope.totalRating / $scope.totalReviews;
    }
//    for (var i = 0; i < $scope.ProviderInfo.reviewList.length; i++) {
//        $scope.totalRating = $scope.totalRating + $scope.ProviderInfo.reviewList[i].rate;
//    }
    //    $scope.totalRating = ($scope.totalRating / $scope.ProviderInfo.reviewList.length);
    $scope.reportYourOwn = function (currentID) {
        if (currentID !== $scope.ProviderInfo.providerID) {

            return true;
        } else {
            return false;
        }
    };
    $scope.CheckOther = function () {
        $scope.DisableValue = false;
        $scope.reason = "Other Reason";
    };
    $scope.CheckReason = function (reason) {
        $scope.reason = reason;
        $scope.DisableValue = true;
    };
    $scope.getReviewTime = 1;
    $scope.getMoreReview = function () {
        $scope.loading = true;
        $scope.getReviewTime++;
        var data = {"time": $scope.getReviewTime, "providerID": $scope.ProviderInfo.providerID};
        $http.post(getReviewUrl, data)
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        $scope.ProviderInfo.reviewList = response.data;
                        $scope.loading = false;
                    }
                });
    };
});
myApp.controller('TripperPageController', function ($scope, $http, service) {
    $scope.TripperInfo = tripperInfo;
    $scope.ReportType = reportType;
    $scope.DisableValue = true;
    $scope.reason = "";
    $scope.error = false;
    //    $scope.totalRating = 0;
    $scope.loading = false;
//    for (var i = 0; i < $scope.TripperInfo.reviewList.length; i++) {
//        $scope.totalRating = $scope.totalRating + $scope.TripperInfo.reviewList[i].rate;
    //    }

    $scope.totalBuckets = 0;
    if ($scope.TripperInfo.bucketList.length > 0) {
        $scope.totalBuckets = $scope.TripperInfo.bucketList[0].totalRecords;
    }
    $scope.totalBookings = 0;
    if ($scope.TripperInfo.bookingList.length > 0) {
        $scope.totalBookings = $scope.TripperInfo.bookingList[0].totalRecords;
    }

    $scope.reportYourOwn = function (currentID) {
        if (currentID !== $scope.TripperInfo.tripperID) {

            return true;
        } else {
            return false;
        }
    };
    $scope.DisableValue = true;
    $scope.CheckOther = function () {
        $scope.DisableValue = false;
        $scope.reason = "Other Reason";
    };
    $scope.CheckReason = function (reason) {
        $scope.reason = reason;
        $scope.DisableValue = true;
    };
    $scope.getReviewTime = 1;
    $scope.getMoreReview = function () {
        $scope.loading = true;
        $scope.getReviewTime++;
        var data = {"time": $scope.getReviewTime, "tripperID": $scope.TripperInfo.tripperID};
        $http.post(getReviewUrl, data)
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        $scope.TripperInfo.reviewList = response.data;
                        $scope.loading = false;
                    }
                });
    };
    $scope.validateReportForm = function (event) {
        if ($scope.reason === "") {
            $scope.error = true;
            event.preventDefault();
        } else {
            return true;
        }
    }
});
myApp.controller('ForgotPasswordController', function ($scope, $http, $q, service) {
    $scope.showError = {emailValid: false, all: false};
    $scope.missing = {emailValid: false, emailRegex: false};
    $scope.loading = false;
    $scope.onlyNumbers = /^\d+$/;
    $scope.emailRegex = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    $scope.register = {"email": email};
    $scope.validateForgotPasswordForm = function (event) {
        if ($scope.missing.emailValid) {
            $scope.showError.all = true;
            event.preventDefault();
        }
    };
    var pending = false;
    var deferred = $q.defer();
    $scope.$watch('register.email', function (newVal, oldVal) {
        $scope.loading = false;
        $scope.showError.emailValid = false;
        clearTimeout($scope.timeout);
        $scope.timeout = setTimeout(function () { // start a new timeout
            if (oldVal !== null && oldVal !== undefined && oldVal !== "") {

                if ($scope["forgetform"].email.$valid) {
                    if (pending) {
                        deferred.resolve();
                        deferred = $q.defer();
                    }
                    pending = true;
                    $scope.loading = true;
                    var data = {"email": $scope.register.email};
                    $http.post(checkEmailUrl, data, {timeout: deferred.promise})
                            .then(function successCallback(response) {
                                pending = false;
                                deferred = $q.defer();
                                if (response.data.result === "error") {
                                    var pageError = service.getContextPath() + service.getErrorPageUrl();
                                    $(location).attr('href', pageError);
                                } else {
                                    if (response.data.result !== "fail") {
                                        $scope.missing.emailValid = true;
                                        $scope.showError.emailValid = true;
                                    } else {
                                        $scope.missing.emailValid = false;
                                        $scope.showError.emailValid = true;
                                    }
                                    $scope.loading = false;
                                }
                            });
                    $scope.$digest();
                }
                $scope.$digest();
            }
            clearTimeout($scope.timeout); // clear time out just in case.
        }, 1000);
    });
});
myApp.controller('GuestChangePasswordController', function ($scope, $http) {
    $scope.change = {"password": "", "rePassword": ""};
    $scope.showError = {matchPassword: false, blankPass: false, all: false};
    $scope.missing = {matchPassword: false};
    $scope.validateChangPassword = function (event) {
        if (!$scope.missing.matchPassword) {
            $scope.showError.all = true;
            event.preventDefault();
        } else {
            $('#ChangePassForm').submit();
        }
    };
    $scope.$watch('change.rePassword', function (newVal, oldVal) {
        $scope.showError.matchPassword = false;
        clearTimeout($scope.timeout);
        $scope.timeout = setTimeout(function () {
            if (oldVal !== null && oldVal !== undefined && oldVal !== "") {
                $scope.showError.matchPassword = true;
                if (newVal !== $scope.change.password) {
                    $scope.missing.matchPassword = false;
                } else {
                    $scope.missing.matchPassword = true;
                }
            }
            $scope.$digest();
            clearTimeout($scope.timeout);
        }, 1000);
    });
});
myApp.controller('PaymentController', function ($scope, $http) {
    $scope.package = package;
    $scope.isPrivate = isPrivate;
    $scope.Math = window.Math;
    $scope.hideCreditCard = function () {
        $('#creditCard').hide();
    };
    $scope.showCreditCard = function () {
        $('#creditCard').show();
    };
});
myApp.controller('AllActivitiesController', function ($scope, $http, service) {
    $scope.activities = activitiesScope;
    $scope.selectedLocation = loc;
    $scope.pageSize = pageSize;
    $scope.currentPage = 1;
    $scope.total = 0;
    $scope.hideIfEmpty = true;
    $scope.ulClass = 'pagination';
    $scope.adjacent = 1;
    $scope.activeClass = 'active';
    $scope.disabledClass = 'disabled';
    $scope.showPrevNext = true;
    $scope.loading = false;
    $scope.pageLoading = false;
    $scope.$watch('activities', function (newVal, oldVal) {
        $scope.total = 0;
        if (newVal !== null && newVal !== undefined && newVal.length > 0) {
            $scope.total = $scope.activities[0].totalRecords;
        }
    });
    $scope.$watch('selectedLocation', function (newVal, oldVal) {
        if (newVal !== oldVal) {
            $scope.pageLoading = true;
            $scope.currentPage = 1;
            var data = {"pageNumber": $scope.currentPage, "location": newVal};
            $http.post(activitiesByPageNumberUrl, data)
                    .then(function successCallback(response) {
                        if (response.data.result === "error") {
                            var pageError = service.getContextPath() + service.getErrorPageUrl();
                            $(location).attr('href', pageError);
                        } else {
                            $scope.activities = response.data;
                            $scope.pageLoading = false;
                        }
                    });
        }
    });
    $scope.DoCtrlPagingAct = function (text, page, pageSize, total) {
        $scope.pageLoading = true;
        $('html, body').animate({
            scrollTop: 0
        }, 300);
        var data = {"pageNumber": page, "location": $scope.selectedLocation};
        $http.post(activitiesByPageNumberUrl, data)
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        $scope.activities = response.data;
                        $scope.pageLoading = false;
                    }
                });
    };
});
myApp.controller('AdvancedPackagesController', function ($scope, $http, service) {
    $scope.result = resultJson;
    $scope.selectedLocation = locationScope;
    $scope.pageSize = pageSize;
    $scope.currentPage = 1;
    $scope.total = 0;
    $scope.hideIfEmpty = true;
    $scope.ulClass = 'pagination';
    $scope.adjacent = 1;
    $scope.activeClass = 'active';
    $scope.disabledClass = 'disabled';
    $scope.showPrevNext = true;
    $scope.loading = true;
    $scope.$watch('result.packages', function (newVal, oldVal) {
        $scope.total = 0;
        if (newVal !== null && newVal !== undefined && newVal.length > 0) {
            $scope.total = $scope.result.packages[0].totalRecords;
        }
    });
    $scope.$watch('selectedLocation', function (newVal, oldVal) {
        if (newVal !== oldVal) {
            $scope.loading = true;
            $scope.currentPage = 1;
            //            alert(newVal);
            var data = {"pageNumber": $scope.currentPage, "location": newVal, "activityID": $scope.result.activityID};
            $http.post(advancedUrl, data)
                    .then(function successCallback(response) {
                        if (response.data.result === "error") {
                            var pageError = service.getContextPath() + service.getErrorPageUrl();
                            $(location).attr('href', pageError);
                        } else {
                            $scope.result.packages = response.data.packages;
                            $scope.loading = false;
                        }
                    });
        }
    });
    $scope.DoCtrlPagingAct = function (text, page, pageSize, total) {
        $scope.loading = true;
        $('html, body').animate({
            scrollTop: 0
        }, 300);
        var data = {"pageNumber": page, "location": $scope.selectedLocation, "activityID": $scope.result.activityID};
        $http.post(advancedUrl, data)
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        $scope.result.packages = response.data.packages;
                        $scope.loading = false;
                    }
                }, function errorCallback(response) {
                    alert("error");
                });
    };
    $scope.loading = false;
});
myApp.controller('reviewPackageController', function ($scope, $http, $filter) {
    $scope.totalStar = 0;
    $scope.covenient = 0;
    $scope.AmenityQuality = 0;
    $scope.Cleanliness = 0;
    $scope.Professionlism = 0;
    $scope.StaffAttitude = 0;
    $scope.Satisfaction = 0;
    $scope.flagError = false;
    $scope.validateReview = function (event) {
        if ($scope.covenient === 0 || $scope.AmenityQuality === 0 || $scope.Cleanliness === 0 || $scope.Professionlism === 0 || $scope.StaffAttitude === 0 || $scope.Satisfaction === 0) {
            event.preventDefault();
            $scope.flagError = true;
        } else {
            return true;
        }

    };
    $scope.calculationStar = function () {
        $scope.totalStar = $filter('number')(($scope.covenient + $scope.AmenityQuality + $scope.Cleanliness + $scope.Professionlism + $scope.StaffAttitude + $scope.Satisfaction) / 6, 2);
    };
    $scope.$watch('covenient', function (newVal, oldVal) {
        $scope.calculationStar();
    });
    $scope.$watch('AmenityQuality', function (newVal, oldVal) {
        $scope.calculationStar();
    });
    $scope.$watch('Cleanliness', function (newVal, oldVal) {
        $scope.calculationStar();
    });
    $scope.$watch('Professionlism', function (newVal, oldVal) {
        $scope.calculationStar();
    });
    $scope.$watch('StaffAttitude', function (newVal, oldVal) {
        $scope.calculationStar();
    });
    $scope.$watch('Satisfaction', function (newVal, oldVal) {
        $scope.calculationStar();
    });
});
myApp.controller('HeaderController', function ($scope, $http, service, $location, $q, $timeout, $interval) {
    $scope.headerLoading = true;
    $scope.toggleDevelopingBox = function () {
        $("#developingBoxHeader").toggleClass("active");
    };

    $scope.toggleCategoriesBox = function () {
        $("#categoriesBox").toggleClass("active");
    };

    $scope.toggleHowToWork = function () {
        $("#how-it-work").toggleClass("active");
    };
    var stompClient = null;
    var receive = '';
    var subscribe = '';
    $scope.notificationList = '';
    var websocketURL = service.getContextPath() + "/hello";
    var SeenNotiURL = service.getContextPath() + "/Noti/ProviderSeenNoti";
    var SeenNotiURL2 = service.getContextPath() + "/Noti/TripperSeenNoti";
    var liveSearchURL = service.getContextPath() + "/Common/LiveSearch";
    $scope.websocketURL = websocketURL;
    $scope.SeenNotiURL = SeenNotiURL;
    $scope.userID = userID;
    $scope.userRole = userRole;
    $scope.nearMeTable = tableHeader; // near me json

    if ($scope.userRole === 2) {
        receive = "/app/hello/Notifications/Provider/";
        subscribe = "/topic/Notifications/Provider/";
    } else if ($scope.userRole === 1) {
        receive = "/app/hello/Notifications/Tripper/";
        subscribe = "/topic/Notifications/Tripper/";
    }
    if ($scope.userRole !== 0) {
        var socket = new SockJS($scope.websocketURL);
        stompClient = Stomp.over(socket);
        stompClient.debug = null;
    }
    $scope.connect = function () {
        stompClient.connect({}, function (frame) {
            stompClient.subscribe(subscribe + $scope.userID, function (greeting) {
                $scope.loadNotification(JSON.parse(greeting.body));
            });
            $scope.sendInitMessage();
        });
    };
    $scope.sendInitMessage = function () {
        stompClient.send(receive + $scope.userID, {}, JSON.stringify({'content': 'init'}));
    };
    $scope.loadNotification = function (notificationList) {
        $scope.notificationList = JSON.parse(notificationList);
        $scope.count = 0;
        for (var i = 0; i < $scope.notificationList.length; i++) {
            $scope.count = $scope.count + 1;
            $scope.notificationList[i].content = JSON.parse($scope.notificationList[i].content);
        }
        if ($scope.userRole === 2 && $scope.count > 0) {
            document.getElementById('ProviderNumOfNoti').style.display = "";
            $("#ProviderNumOfNoti").text($scope.count);
            document.getElementById('ProviderNumOfNoti2').style.display = "";
            $("#ProviderNumOfNoti2").text('(' + $scope.count + ')');
        } else if ($scope.userRole === 1 && $scope.count > 0) {
            document.getElementById('TripperNumOfNoti').style.display = "";
            document.getElementById('TripperNumOfNoti2').style.display = "";
            $("#TripperNumOfNoti").text($scope.count);
            $("#TripperNumOfNoti2").text('(' + $scope.count + ')');
        }
    };
    $scope.decreaseNumForProvider = function (NoOfNoti, redirectURL) {
        $scope.count = $scope.count - 1;
        if ($scope.count > 0) {
            $("#ProviderNumOfNoti").text($scope.count);
        } else {
            document.getElementById('ProviderNumOfNoti').style.display = "none";
        }
        var formData = new FormData();
        formData.append("NotificationID", NoOfNoti);
        $.ajax({
            url: SeenNotiURL,
            type: "POST",
            dataType: 'text',
            contentType: false,
            processData: false,
            cache: false,
            data: formData,
            success: function (response) {
                $(location).attr('href', redirectURL);
            },
            error: function (response) {
                console.log(response);
            }
        });
    };
    $scope.decreaseNumForTripper = function (NoOfNoti, redirectURL) {
        $scope.count = $scope.count - 1;
        if ($scope.count > 0) {
            $("#TripperNumOfNoti").text($scope.count);
        } else {
            document.getElementById('TripperNumOfNoti').style.display = "none";
        }
        var formData = new FormData();
        formData.append("NotificationID", NoOfNoti);
        $.ajax({
            url: SeenNotiURL2,
            type: "POST",
            dataType: 'text',
            contentType: false,
            processData: false,
            cache: false,
            data: formData,
            success: function (response) {
                $(location).attr('href', redirectURL);
            },
            error: function (response) {
                console.log(response);
            }
        });
    };
    $('.navbar-toggle').click(function () {
        if (!$('#hamburgerContainer').hasClass('HamburgerMoveInRight')) {
            $('#hamburgerContainer').removeClass('HamburgerMoveOutRight');
            $('#hamburgerContainer').addClass('HamburgerMoveInRight');
            $('#btn-search-mini').css('visibility', 'hidden');
            $('.navbar-brand-mini').css('visibility', 'hidden');
            $('.navbar-header').css('height', '70px');
        } else {
            $('#hamburgerContainer').removeClass('HamburgerMoveInRight');
            $('#hamburgerContainer').addClass('HamburgerMoveOutRight');
            $('#btn-search-mini').css('visibility', '');
            $('.navbar-brand-mini').css('visibility', '');
            $('.navbar-header').css('height', '');
            $scope.timeout = setTimeout(function () {
                $('#hamburgerContainer').removeClass('HamburgerMoveOutRight');
            }, 500);
        }
        if (!$('.navbar').hasClass('NavMoveInRight')) {
            $('.navbar').removeClass('NavMoveOutRight');
            $('.navbar').addClass('NavMoveInRight');
        } else {
            $('.navbar').removeClass('NavMoveInRight');
            $('.navbar').addClass('NavMoveOutRight');
            $scope.timeout = setTimeout(function () {
                $('.navbar').removeClass('NavMoveOutRight');
            }, 500);
        }
    });
    var menuEl = $(".overview-menu");
    $scope.activeMenu = function () {
        if (menuEl.hasClass("active")) {
            menuEl.removeClass("active");
        } else {
            menuEl.addClass("active");
        }
    };

    $scope.resizeBanner = function () {

        var width = $("#nav-header div.banner").width();
        var height = width * 540 / 1350;
        $("#nav-header div.banner").height(height);
        var positionY = ($scope.package.coverPosition / 260) * height;
        $("#nav-header div.banner").css("background-position", "center " + positionY + "px");
    };
    // if page is package Detail
    if ($scope.fromSpecific) {
        $timeout(function () {
            $scope.resizeBanner();
        }, 100);
        // detect window resize to fit banner

        $(window).resize(function () {
            $scope.resizeBanner();
        });
    }

    $scope.updateHeaderAddSearch = function () {

        $("#routeDiv").addClass("pagesearch");
        if (!$(".search-input").hasClass("show-control-search")) {
            $(".search-input").addClass("show-control-search");
        }

        if ($("nav.navbar").hasClass("navbar-dark")) {
            $("nav.navbar").removeClass("navbar-dark");
            $("nav.navbar").addClass("navbar-light");
        }
    };
    $scope.updateHeaderRemoveSearch = function () {

        $("#routeDiv").removeClass("pagesearch");
        if ($(".search-input").hasClass("show-control-search")) {
            $(".search-input").removeClass("show-control-search");
        }

        if ($("nav.navbar").hasClass("navbar-light")) {
            $("nav.navbar").removeClass("navbar-light");
            $("nav.navbar").addClass("navbar-dark");
        }
    };
    $(window).scroll(function () {
        var $hearderSearch = $("#header-search");
        if ($hearderSearch.is(":visible") === true) {
            var window_offset = $hearderSearch.offset().top - $(window).scrollTop();
            if (window_offset < 0) {
                $scope.updateHeaderAddSearch();
            } else {
                $scope.updateHeaderRemoveSearch();
            }
        }
    });
    if ($scope.fromHomePage) {
        var bannerNumber = 1;
        $interval(function () {
            $(".bannerBackground.active").removeClass("active");
            bannerNumber++;
            if (bannerNumber > 10) {
                bannerNumber = 1;
            }
            $(".bannerBackground:nth-of-type(" + bannerNumber + ")").addClass("active");
        }, 4500);
    }

    $("#flags > a").click(function () {
        var $menu = $(this).parent().find(".dropdown-menu");
        if (!$menu.hasClass("active")) {
            $menu.addClass("active");
        } else {
            $menu.removeClass("active");
        }
    });

    var LANGUAGE_URL = service.getContextPath() + "/Common/LanguageSetting";
    $scope.setLanguage = function (language) {
//        $("#language").val(language);
//        document.getElementById("languageSetting").submit();
//        $http.post(LANGUAGE_URL, language)
//                .then(function successCallback(response) {
//                    if (response.data.result === "error") {
//                        var pageError = service.getContextPath() + service.getErrorPageUrl();
//                        $(location).attr('href', pageError);
//                    } else {
//                        location.reload();
//                    }
//                });
    };

    $(document).click(function (event) {
        if (!$(event.target).closest('#flags .dropdown-menu').length && !$(event.target).is('#flags .dropdown-menu')
                && !$(event.target).is('#flags > a')
                && !$(event.target).closest('#flags > a').length) {
            $("#flags .dropdown-menu").removeClass("active");
        }
    });

    //inputdropdown search

    $scope.searchFunction = function () {
        $("#searchDropdown").toggleClass("show");
    };

    $scope.getCity = function (city) {
        $scope.searchValue = city;
    };

    $scope.currentTimestamp = new Date();
    $scope.headerLoading = false;
});
myApp.controller('LoginController', function ($scope, $http, service) {
    $scope.fblogin = function () {
        FB.login(function (response) {
            if (response.authResponse) {
                var url = '/me?fields=name,email';
                FB.api(url, function (response) {
                    $scope.registerEmail(response);
                });
            } else {
//                console.log('User cancelled login or did not fully authorize.');
            }
        }, {scope: 'email'});
    };
    var registerFb = service.getContextPath() + "/Common/Tripper/RegisterFB";
    $scope.registerEmail = function (data) {
        $http.post(registerFb, data)
                .then(function successCallback(response) {
                    var data = response.data;
                    if (data.method === "login") {
                        window.location.replace("Home");
                    } else if (data.method === "signup") {
                        window.location.replace("Common/NewPassword/" + data.token);
                    }
                });
    };
    $scope.googlelogin = function () {

        var myParams = {
            'clientid': '897561243789-9d6c6q5163cd0s2stk60mpjflkd1qdqo.apps.googleusercontent.com', //You need to set client id
            'cookiepolicy': 'single_host_origin',
            'callback': $scope.loginCallback,
            'approvalprompt': 'force',
            'scope': 'https://www.googleapis.com/auth/plus.login https://www.googleapis.com/auth/plus.profile.emails.read https://www.googleapis.com/auth/userinfo.email'
        };
        gapi.auth.signIn(myParams);
    };
    $scope.loginCallback = function (result)
    {
        if (result['status']['signed_in'])
        {
//            console.log(result);
            $.ajax({
                type: "GET",
                url: "https://www.googleapis.com/oauth2/v2/userinfo?access_token=" + result['access_token']
            })
                    .done(function (data) {
                        console.log(data);
                        $scope.registerEmail(data);
                    });
        }
    };
});
myApp.controller('InsertNewPassword', function ($scope) {
    $scope.loaded = true;
    $scope.change = {"password": "", "rePassword": ""};
    $scope.showError = {matchPassword: false, blankPass: false, all: false};
    $scope.missing = {matchPassword: false};
    $scope.validateAddPassword = function (event) {
        if ($scope.change.password.length >= 10 && $scope.change.rePassword.length >= 10 && $scope.missing.matchPassword === true) {
            return true;
        } else {
            $scope.showError.all = true;
            event.preventDefault();
        }


    };
    $scope.$watch('change.rePassword', function (newVal, oldVal) {
        $scope.showError.matchPassword = false;
        clearTimeout($scope.timeout);
        $scope.timeout = setTimeout(function () {
            if (oldVal !== null && oldVal !== undefined && oldVal !== "") {
                $scope.showError.matchPassword = true;
                if (newVal !== $scope.change.password) {
                    $scope.missing.matchPassword = false;
                } else {
                    $scope.missing.matchPassword = true;
                }
            }
            $scope.$digest();
            clearTimeout($scope.timeout);
        }, 1000);
    });
});
myApp.controller('QuickViewController', function ($scope) {
    $scope.loaded = false;
    $scope.package = specificPackage;
    $scope.package.unavailableDays = JSON.parse($scope.package.unavailableDays);
    $scope.loaded = true;
});
myApp.controller('ManagePackageController', function ($scope) {
    $scope.loaded = false;
    $scope.page = page;
    $scope.packages = packages;
    $scope.loaded = true;
});
myApp.controller('ManagePassportController', function ($scope, $http, service) {
    $scope.loaded = false;
    $scope.page = page;
    $scope.passports = passports;
    $scope.loaded = true;
    $scope.sortType = 'passportUploadTime';
    var Myurl;
    var data = {};
    var keyObject = "";
    var i = 0;
    $scope.reload = function ()
    {
        location.reload();
    };
    $scope.convertTime = function (time) {
        var date = new Date(time * 1).toLocaleString();
        return date;
    }

    $scope.ApprovingPassport = function () {
        //if(document.getElementsByClassName("myCheck").checked == true){
        // url = "/Admin/ApprovePassport/" + $scope.passports.providerID;
        //}
        //$(".certificateBox").toggleClass("active");
        Myurl = service.getContextPath() + "/Admin/ApprovePassport";
        angular.forEach(document.getElementsByClassName("checkApprove"), function (value, key) {
            if (value.checked === true) {
                i++;
                keyObject = "providerID" + i;
                data[keyObject] = value.defaultValue;
                // console.log(value.defaultValue );
//                Myurl = service.getContextPath() + "/Admin/ApprovePassport/" + value.defaultValue;
//                $http.post(Myurl)
//                        .then(function successCallback(response) {
//                            var result = response.data.result;
//                            if (result === "error") {
//                                var pageError = service.getContextPath() + service.getErrorPageUrl();
//                                $(location).attr('href', pageError);
//                            } else {
//                                if (result === 'fail') { // if file is not stored in session
//                                    alert("Please upload your certificate!");
//                                } else {
//                                    //reload
//                                    $scope.reload();
//                                }
//                            }
//                        });
            }
        });
        //console.log(data);
        //console.log(data2);
        keyObject = "providerIDSize";
        data[keyObject] = i;
        $http.post(Myurl, data)
                .then(function successCallback(response) {
                    var result = response.data.result;
                    if (result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        if (result === 'fail') { // if file is not stored in session
                            alert("Please upload your certificate!");
                        } else {
                            //reload
                            $scope.reload();
                        }
                    }
                });
    };
});
myApp.controller('ManagePaymentController', function ($scope, $http, service) {
    $scope.page = page;
    $scope.paymentList = paymentList;
    $scope.paymentSize = 0;
    $scope.selectedProviderID = 0;
    $scope.loadingDetail = false;
    $scope.bookingDetailList = null;
    $scope.viewBookingDetailURL = viewBookingDetailURL;
    if ($scope.paymentList !== null && $scope.paymentList !== '') {
        $scope.paymentSize = $scope.paymentList.length;
    }
    $scope.Selectprovider = function (providerID) {
        $scope.selectedProviderID = providerID;
        $scope.loadingDetail = true;
        var data = {"providerID": providerID};
        $http.post(viewBookingDetailURL, data)
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        $scope.bookingDetailList = response.data;
                        $scope.loadingDetail = false;
                    }
                });
    };
    $scope.selectOrNot = function (providerID) {
        if (providerID === $scope.selectedProviderID) {
            return true;
        } else {
            return false;
        }
    };
});
myApp.controller('BeTripperController', function (vcRecaptchaService, $scope, $http, $q, service) {
    /**
     * Initiate
     */
    $scope.loading = true;
    $scope.register = {"firstName": firstName, "lastName": lastName,
        "email": email, "password": "", "rePassword": ""};
    // YouTripper
    $scope.publicKey = "6LcR5xUTAAAAAPbeJma29e1OeNBQGOznrhPvfZoM";
// Server
//    $scope.publicKey = "6LfkbRATAAAAAA2FgdG5jg26oZEYE1M0AzxPL8Iv";
    $scope.captcha = "true";
    /**
     * End Initiate
     */

    /**
     * Validate
     */

    $scope.showError = {matchPassword: false, emailValid: false, all: false};
    $scope.missing = {matchPassword: false, emailValid: false, emailRegex: false};
    $scope.loading = false;
    $scope.onlyNumbers = /^\d+$/;
    $scope.emailRegex = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    $scope.validateRegisterForm = function (event) {
        if (!$scope["signupForm"].$valid || !$scope.missing.matchPassword || !$scope.missing.emailValid || !$scope.missing.emailRegex) {
            $scope.showError.all = true;
            event.preventDefault();
        }
    };
    var pending = false;
    var deferred = $q.defer();
    $scope.emailLoading = false;
    $scope.$watch('register.email', function (newVal, oldVal) {
        $scope.emailLoading = false;
        $scope.showError.emailValid = false;
        clearTimeout($scope.timeout);
        $scope.timeout = setTimeout(function () { // start a new timeout
            if (oldVal !== null && oldVal !== undefined && oldVal !== "") {
                $scope.showError.emailValid = true;
                if ($scope["signupForm"].email.$valid && $scope.emailRegex.test(newVal)) {
                    $scope.missing.emailRegex = true;
                    if (pending) {
                        deferred.resolve();
                        deferred = $q.defer();
                    }
                    pending = true;
                    $scope.emailLoading = true;
                    var data = {"email": $scope.register.email};
                    $http.post(checkEmailUrl, data, {timeout: deferred.promise})
                            .then(function successCallback(response) {
                                if (response.data.result === "error") {
                                    var pageError = service.getContextPath() + service.getErrorPageUrl();
                                    $(location).attr('href', pageError);
                                } else {
                                    pending = false;
                                    deferred = $q.defer();
                                    if (response.data.result !== "fail") {
                                        $scope.missing.emailValid = true;
                                    } else {
                                        $scope.missing.emailValid = false;
                                    }
                                    $scope.emailLoading = false;
                                }
                            });
                    $scope.$digest();
                } else {
                    $scope.missing.emailRegex = false;
                }
                $scope.$digest();
            }
            clearTimeout($scope.timeout); // clear time out just in case.
        }, 1000);
    });
    $("input#email").on({
        keydown: function (e) {
            if (e.which === 32)
                return false;
        },
        change: function () {
            this.value = this.value.replace(/\s/g, "");
        }
    });
    $scope.validatePassword = function () {
        if (angular.isString($scope.register.rePassword) && $scope.register.rePassword !== ""
                && angular.isString($scope.register.password) && $scope.register.password !== "") {
            $scope.showError.matchPassword = true;
            if ($scope.register.rePassword !== $scope.register.password) {
                $scope.missing.matchPassword = false;
            } else {
                $scope.missing.matchPassword = true;
            }
        } else {
            $scope.showError.matchPassword = false;
        }
    };
    $scope.setResponse = function (response) {
        $scope.captcha = vcRecaptchaService.getResponse();
        $scope.$digest();
    };
    /**
     * End Validate
     */
    $scope.loading = false;
});
myApp.controller('ManageKeywordController', function ($scope) {
    $scope.keywordList = keywordList;
    $scope.page = page;
    $scope.keywordNum = $scope.keywordList.length;
    $scope.DeleteKeywordURL = deleteKeywordURL;
    $scope.AddeKeywordURL = addeKeywordURL;
    $scope.message = message;
    $scope.deleteKeyword = function (keyword) {
        $(location).attr('href', $scope.DeleteKeywordURL + keyword);
    };
    $scope.addKeyword = function (keyword, times) {
        $(location).attr('href', $scope.AddeKeywordURL + keyword + "/" + times);
    };
});
myApp.controller('PolicyController', function ($scope) {
    $scope.page = page;
});
myApp.controller('CareerController', function ($scope) {
    $($('.padding-header').find("div.JobDetail")[0]).slideUp();
    $($('.padding-header').find("div.JobDetail")[1]).slideUp();
    $($('.padding-header').find("div.JobDetail")[2]).slideUp();
    $($('.padding-header').find("div.JobDetail")[3]).slideUp();
    $($('.padding-header').find("div.JobDetail")[4]).slideUp();
    $scope.ViewDes = function (e) {
        var job = $('.padding-header').find("div.JobDetail")[e];
        if ($(job).hasClass('showing')) {
            $(job).slideUp();
            $(job).removeClass('showing');
        } else {
            $(job).slideDown();
            $(job).addClass('showing');
        }
    };
});
myApp.controller('FixedComparisonController', function ($scope, $http, $q, service) {
//    $scope.comparisonList = $("#comparisonList").val();
//    alert($scope.comparisonList);
//    if ($scope.comparisonList === '') {
//        alert("vao sao");
//        $scope.comparisonList = [];
//    }

    /* DEVELOPING BOX */
    $scope.toggleDevelopingBox = function () {
        $("#developingBox").toggleClass("active");
    };
    /* END DEVELOPING BOX */

    $scope.checkComparisonItem = function (packageID) {
        for (var i = 0; i < $scope.comparisonList.length; i++) {
            if (packageID === $scope.comparisonList[i].packageID) {
                return true;
            }
        }
        return false;
    };
    $scope.pushToComparisonList = function (data) {
        $scope.comparisonList.push(data[data.length - 1]);
        if ($(".comprison-header").hasClass("active")) {
            $(".fixed-comparison").toggleClass("active");
            $(".comprison-header").toggleClass("active");
        }
    };
    var removeComparisonUrl = service.getContextPath() + "/Common/RemoveFromComparisonList";
    $scope.initCompareTable = function () {
        $(".comprison-header a, .comparison-arrow").click(function () {
            $(".fixed-comparison").toggleClass("active");
            $(".comprison-header").toggleClass("active");
            return false;
        });
    };
    $scope.initCompareTable();
    $scope.removeFromComparisonList = function (packagePosition) {
//        alert("aaa");
        var data = {"position": packagePosition};
        $http.post(removeComparisonUrl, data)
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                    }
                });
        $scope.comparisonList.splice(packagePosition, 1);
    };
});
myApp.controller('ComparisonPageController', function ($scope, $http, service) {
    $scope.comparisonPakages = comparisonPakages;
    $scope.parseToText = function (val) {
        if (val === 1) {
            return 'Below Expectation';
        } else if (val === 2) {
            return 'Could have been better';
        } else if (val === 3) {
            return 'Well done';
        } else if (val === 4) {
            return  'Great Experience';
        } else if (val === 5) {
            return 'Absolutely Awesome';
        } else if (val === 0) {
            return 'N/A';
        }
    };
});
myApp.controller('BookingManagementController', function ($scope, $http, service) {
    $scope.loaded = false;
    $scope.contextPath = service.getContextPath();
    $scope.page = 'providerBookings';
    $scope.bookingOverview = bookingOverview;
    $scope.packages = packages;
    $scope.selectedPackage = 0;
    $scope.sizeOfHashMap = function (obj) {
        var size = 0, key;
        for (key in obj) {
            if (obj.hasOwnProperty(key))
                size++;
        }
        return size;
    };
    $scope.day_of_week = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];
    $scope.month_of_year = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
    Date.prototype.ddMMyyyy = function () {
        var yyyy = this.getFullYear().toString();
        var mm = (this.getMonth() + 1).toString(); // getMonth() is zero-based
        var dd = this.getDate().toString();
        return (dd[1] ? dd : "0" + dd[0]) + "/" + (mm[1] ? mm : "0" + mm[0]) + "/" + yyyy; // padding
    };
    Date.prototype.MMddyyyy = function () {
        var yyyy = this.getFullYear().toString();
        var mm = (this.getMonth() + 1).toString(); // getMonth() is zero-based
        var dd = this.getDate().toString();
        return  (mm[1] ? mm : "0" + mm[0]) + "/" + (dd[1] ? dd : "0" + dd[0]) + "/" + yyyy; // padding
    };
    //  DECLARE AND INITIALIZE VARIABLES
    var Calendar;
    $scope.setCalendar = function () {
        Calendar = new Date();
        $scope.selectedDate = Calendar.MMddyyyy();
        $scope.year = Calendar.getFullYear(); // Retucope.bookingOverview[Calendar.ddMMyyyy()]);rns year
        $scope.month = Calendar.getMonth(); // Returns month (0-11)
        $scope.today = Calendar.getDate(); // Returns day (1-31)
        $scope.weekday = Calendar.getDay(); // Returns day (0 - 6)
    };
    $scope.DAYS_OF_WEEK = 7; // "constant" for number of days in a week
    $scope.DAYS_OF_MONTH = 31; // "constant" for number of days in a month

    $scope.setCalendar();
    var cal; // Used for printing



    /* VARIABLES FOR FORMATTING
     NOTE: You can format the 'BORDER', 'BGCOLOR', 'CELLPADDING', 'BORDERCOLOR'
     tags to customize your caledanr's look. */

    var TR_start = '<TR>';
    var TR_end = '</TR>';
    var highlight_start = '<TD WIDTH="30"><TABLE CELLSPACING=0 BORDER=1 BGCOLOR=DEDEFF BORDERCOLOR=CCCCCC><TR><TD WIDTH=20><B><CENTER>';
    var highlight_end = '</CENTER></TD></TR></TABLE></B>';
    var TD_start = '<TD WIDTH="30">';
    var TD_Day_start = '<TD class="dayCol" WIDTH="30">';
    var TR_DAY_WEEK_START = '<TR CLASS="WeekDay">';
    var TD_end = '</TD>';
    var prvCtr = "<span class='cldCtr prvCtr'></span>";
    var nxtCtr = "<span class='cldCtr nxtCtr'></span>";
    $scope.changeColorToday = function () {
        $(".dayCol a").removeClass("selected");
        $(".dayCol a[datevalue='" + $scope.selectedDate + "']").toggleClass("selected");
    };
    $scope.specificDateBooking;
    $scope.updateCalendar = function () {
        Calendar.setDate(1); // Start the calendar day at '1'
        Calendar.setMonth($scope.month); // Start the calendar month at now
        Calendar.setFullYear($scope.year);
        cal = '<TABLE CELLSPACING=0 CELLPADDING=0 BORDERCOLOR=BBBBBB><TR><TD>';
        cal += '<TABLE BORDER=0 CELLSPACING=0 CELLPADDING=2>' + TR_start;
        cal += '<TD class="cldHeader" COLSPAN="' + $scope.DAYS_OF_WEEK + '" BGCOLOR="#EFEFEF">' + prvCtr + '<CENTER>';
        cal += $scope.month_of_year[$scope.month] + '   ' + $scope.year + nxtCtr + '</CENTER>' + TD_end + TR_end;
        cal += TR_DAY_WEEK_START;
        //   DO NOT EDIT BELOW THIS POINT  //

        // LOOPS FOR EACH DAY OF WEEK
        for (var index = 0; index < $scope.DAYS_OF_WEEK; index++)
        {
            cal += TD_start + $scope.day_of_week[index] + TD_end;
        }

        cal += TD_end + TR_end;
        cal += TR_start;
        // FILL IN BLANK GAPS UNTIL TODAY'S DAY
        for (var index = 0; index < Calendar.getDay(); index++) {

            cal += TD_Day_start + '  ' + TD_end;
        }

        // LOOPS FOR EACH DAY IN CALENDAR
        for (var index = 0; index < $scope.DAYS_OF_MONTH; index++)
        {

            if (Calendar.getDate() > index)
            {
                // RETURNS THE NEXT DAY TO PRINT
                $scope.week_day = Calendar.getDay();
                // START NEW ROW FOR FIRST DAY OF WEEK
                if ($scope.week_day === 0)
                    cal += TR_start;
                if ($scope.week_day !== $scope.DAYS_OF_WEEK)
                {

                    // SET VARIABLE INSIDE LOOP FOR INCREMENTING PURPOSES
                    var day = Calendar.getDate();
                    $scope.specificDateBooking = $scope.bookingOverview[Calendar.ddMMyyyy()];
                    var noBooking = 0;
                    var noTripper = 0;
                    if ($scope.specificDateBooking !== undefined) {
                        noBooking = $scope.specificDateBooking.noBookings;
                        noTripper = $scope.specificDateBooking.noTrippers;
                    }
//                    var noBooking = $scope.bookingOverview[Calendar.ddMMyyyy()].
                    //                        // HIGHLIGHT TODAY'S DATE
                    //                        if (today == Calendar.getDate())
                    //                            cal += highlight_start + day + highlight_end + TD_end; //
                    //                        // PRINTS DAY
                    //                        else                             cal += TD_start + day + TD_end;
                    cal += TD_Day_start;
                    if (noBooking > 0) {
                        cal += "<a style='color: #ec683c; font-weight:bold; background-color: #ccc' dateValue='" + Calendar.MMddyyyy() + "'>"
                                + "<span class='NoBooking'>" + noBooking + "</span>";
                    } else {
                        cal += "<a dateValue='" + Calendar.MMddyyyy() + "'>";
                    }
                    cal += day;
                    if (noTripper > 0) {
                        cal += "<span class='NoTripper'>" + noTripper + "</span>";
                    }
                    cal += "</a>"
                            + TD_end;
                }

                // END ROW FOR LAST DAY OF WEEK
                if ($scope.week_day === ($scope.DAYS_OF_WEEK - 1)) {
                    cal += TR_end;
                }
            }

            // INCREMENTS UNTIL END OF THE MONTH
            Calendar.setDate(Calendar.getDate() + 1);
        }// end for loop

        cal += '</TD></TR></TABLE></TABLE>';
        //  PRINT CALENDAR
        $("#bookingManagementCalendar").html(cal);
        $scope.changeColorToday();
    };
    $scope.initCalendarCtr = function () {
        $(function () {
            $(document).on('click', '.prvCtr', function () {
                if ($scope.month === 0) {
                    $scope.month = 11;
                    $scope.year -= 1;
                } else {
                    $scope.month -= 1;
                }
                $scope.updateCalendar();
            });
            $(document).on('click', '.nxtCtr', function () {
                if ($scope.month === 11) {
                    $scope.month = 0;
                    $scope.year += 1;
                } else {
                    $scope.month += 1;
                }
                $scope.updateCalendar();
            });
            $(document).on('click', '.dayCol a', function () {
                $scope.changeSelectedDate($(this).attr("dateValue"));
                return false;
            });
        });
    };
    $scope.updateCalendar();
    $scope.initCalendarCtr();
    var data = {"position": 1};
    $scope.$watch('selectedPackage', function (newVal, oldVal) {
        var getPackageBookingOverview = $scope.contextPath + "/Provider/BookingManagement/" + $scope.selectedPackage;
        if (newVal !== oldVal) {
            $http.post(getPackageBookingOverview, data)
                    .then(function successCallback(response) {
                        if (response.data.result === "error") {
                            var pageError = service.getContextPath() + service.getErrorPageUrl();
                            $(location).attr('href', pageError);
                        } else {
                            $scope.bookingOverview = response.data;
                            $scope.setCalendar();
                            $scope.updateCalendar();
                        }
                    });
        }
    });
    $scope.changeSelectedDate = function (value) {
        $scope.selectedDate = value;
        $scope.$digest();
        $scope.changeColorToday();
    };
    $scope.trippers = [];
    $scope.$watch('selectedDate', function (newVal, oldVal) {
        var newDate = new Date(newVal);
        $scope.specificDateBooking = $scope.bookingOverview[newDate.ddMMyyyy()];
        $scope.updateListDetail();
    });
    $scope.selectedDetail;
    $scope.detailLoaded = false;
    var dateBooking = $scope.contextPath + "/Provider/BookingManagement/Detail/" + $scope.selectedPackage;
    $scope.updateListDetail = function () {
        $scope.detailLoaded = false;
        var data = {"selectedDate": $scope.selectedDate};
        $http.post(dateBooking, data)
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        $scope.trippers = response.data;
                        for (key in $scope.trippers.packages) {
                            if ($scope.trippers.packages.hasOwnProperty(key)) {
                                $scope.selectedDetail = key;
                                break;
                            }
                        }
//                        alert("fuck");
//                        if (!$(".detail-list > li:first-of-type .detail-table").hasClass("active")) {
//                            alert($(".detail-list > li:first-of-type .detail-table").length);
//                            $(".detail-list > li:first-of-type .detail-table").addClass("active");
//                        }
                        $scope.detailLoaded = true;
                    }
                });
    };
    $scope.selectPackageToDetail = function (newKey) {
        $scope.selectedDetail = newKey;
    };
    var loadBokingCodeUrl = $scope.contextPath + "/Provider/BookingCode";
    $scope.bookingCodeloaded = false;
    $scope.bookingDetail;
    $scope.initTable = function () {
        $(".bookingDetail").toggleClass("active");
        $(".detail-list > li:first-of-type .detail-table").toggleClass("active");
    };
    $scope.loadBookingCode = function (bookingCode) {
        $scope.bookingCodeloaded = false;
        $scope.initTable();
        var data = {"bookingCode": bookingCode};
        $http.post(loadBokingCodeUrl, data)
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        $scope.bookingDetail = response.data;
                        $scope.bookingCodeloaded = true;
//                        alert("okay");
                    }
                });
    };
    $scope.loaded = true;
});
myApp.controller('SaleManagementController', function ($scope, $http, service, $filter) {
    $scope.loaded = false;
    $scope.loadingSale = false;
    $scope.currentPackage;
    $scope.page = 'providerSale';
    $scope.packages = packages;
    $scope.sales = sales;
    $scope.currentPackage = 0;
    $scope.providerID = providerID;
    $scope.totalType = 'complete';
    var d = new Date();
    var n = d.getMonth() + 1;
    if (n < 10) {
        n = '0' + n;
    }


    var numOfDays = new Date((d.getYear() + 1900), n, 0).getDate();
    var startDate1 = n + "/01/" + (d.getYear() + 1900);
    var endDate1 = n + "/" + numOfDays + "/" + (d.getYear() + 1900);
    $('#from').val(startDate1);
    $('#to').val(endDate1);
    $scope.$watch('currentPackage', function (newVal, oldVal) {
        if (newVal !== oldVal) {
            $scope.loadPackage();
        }

    });
    $('#from').change(function () {
        $scope.loadPackage();
    });
    $('#to').change(function () {
        $scope.loadPackage();
    });
    $scope.getThumbnail = function (packageID) {
        for (var i = 0; i < $scope.packages.length; i++) {
            if ($scope.packages[i].id === packageID || $scope.packages[i].id === "'" + packageID + "'") {
                return $scope.packages[i].coverImage;
            }
        }
    };
    $scope.loadPackage = function () {
        $scope.loadingSale = true;
        var data = {"packageID": $scope.currentPackage, "fromDate": $('#from').val(), "toDate": $('#to').val(), "providerID": $scope.providerID};
        $http.post(updateSaleURL, data)
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        $scope.sales = response.data;
                    }
                    $scope.loadingSale = false;
                });
    };
    $scope.$watch('totalType', function (newVal, oldVal) {
        $scope.calTotal();
    });
    $scope.$watch('sales', function (newVal, oldVal) {
        $scope.calTotal();
    });
    $scope.calTotal = function () {
        if ($scope.totalType === 'complete') {
            $scope.totalRevenue = 0;
            for (var i = 0; i < $scope.sales.length; i++) {
                if ($scope.sales[i].status === 1) {
                    $scope.totalRevenue = $scope.totalRevenue + $scope.sales[i].revenue;
                }
            }
            $scope.totalRevenue = $filter('number')($scope.totalRevenue, 3);
            $('#totalRevenue').text($scope.totalRevenue);
            $('#totalBooked').text('');
            $('#mainTotal').text('');
            $scope.filterCondition = 1;
        } else if ($scope.totalType === 'booked') {
            $scope.totalBooked = 0;
            for (var i = 0; i < $scope.sales.length; i++) {
                if ($scope.sales[i].status === 4) {
                    $scope.totalBooked = $scope.totalBooked + $scope.sales[i].revenue;
                }
            }
            $scope.totalBooked = $filter('number')($scope.totalBooked, 3);
            $('#totalBooked').text($scope.totalBooked);
            $('#totalRevenue').text('');
            $('#mainTotal').text('');
            $scope.filterCondition = 4;
        } else if ($scope.totalType === 'total') {
            $scope.mainTotal = 0;
            for (var i = 0; i < $scope.sales.length; i++) {
                $scope.mainTotal = $scope.mainTotal + $scope.sales[i].revenue;
            }
            $scope.mainTotal = $filter('number')($scope.mainTotal, 3);
            $('#mainTotal').text($scope.mainTotal);
            $('#totalRevenue').text('');
            $('#totalBooked').text('');
            $scope.filterCondition = '';
        }
    };
    $scope.loaded = true;
});
myApp.controller('AllCategoryController', function ($scope, $http, service) {
    $scope.allCate = categories;
    $scope.allSubCate = subCategories;
    $scope.selectedCateID = selectedCate;
    $scope.movePreviousCate = function () {
        if ($scope.selectedCateID <= -1) {
            $scope.selectedCateID = $scope.allCate.length - 1;
        } else {
            $scope.selectedCateID--;
        }
    };
    $scope.moveNextCate = function () {
        if ($scope.selectedCateID >= $scope.allCate.length - 1) {
            $scope.selectedCateID = -1;
        } else {
            $scope.selectedCateID++;
        }
    };
    $scope.selectedLocation = selectedLocation;
    $scope.loading = false;
    $scope.subCategoryLoading = false;
    var urlGetNewSubCate = service.getContextPath() + "/Common/SubCategoriesWithinLocation";
    $scope.loadSubCategories = function () {
        $scope.subCategoryLoading = true;
        if ($scope.selectedLocation === 'All') {
            if ($scope.selectedCateID === 0) {
                $scope.selectedSubCategories = $scope.allSubCate;
            } else {
                $scope.selectedSubCategories = [];
                for (var j = 0; j < $scope.allSubCate.length; j++) {
                    if ($scope.selectedCateID === $scope.allSubCate[j].categoryID) {
                        $scope.selectedSubCategories.push($scope.allSubCate[j]);
                    }
                }
            }
            $scope.subCategoryLoading = false;
        } else {
            var data;
            data = {"location": $scope.selectedLocation, "categoryID": $scope.selectedCateID};
            $http.post(urlGetNewSubCate, data)
                    .then(function successCallback(response) {
                        if (response.data.result === "error") {
                            var pageError = service.getContextPath() + service.getErrorPageUrl();
                            $(location).attr('href', pageError);
                        } else {
                            $scope.selectedSubCategories = response.data;
                        }
                        $scope.subCategoryLoading = false;
                    });
        }
    };
    $scope.$watch('selectedCateID', function (newVal, oldVal) {
        $scope.loadSubCategories();
    });
    $scope.$watch('selectedLocation', function (newVal, oldVal) {
        $scope.loadSubCategories();
    });
    $scope.viewPackage = function (subCateName) {
        var url = service.getContextPath() + "/" + subCateName.replace("/", "-") + "/" + $scope.selectedLocation + "/SmartSearch";
        $(location).attr('href', url);
    };
});
myApp.controller('SubCategoryController', function ($scope, $http, $q, service) {
    $scope.loading = false;
    $scope.search = search;
    $scope.advancedSearch = advancedSearch;
    $scope.pageSize = pageSize;
    $scope.currentPage = 1;
    $scope.total = 0;
    $scope.hideIfEmpty = true;
    $scope.ulClass = 'pagination';
    $scope.adjacent = 1;
    $scope.activeClass = 'active';
    $scope.disabledClass = 'disabled';
    $scope.showPrevNext = true;
    $scope.loadingFunction = true;
    $scope.groupTypeIDs = [];
    $scope.tripTypeIDs = [];
    $scope.amenitiesIDs = [];
    $scope.filterOptions;
    $scope.sizeOfHashMap = function (obj) {
        var size = 0, key;
        for (key in obj) {
            if (obj.hasOwnProperty(key))
                size++;
        }
        return size;
    };
    $scope.$watch('advancedSearch.packages', function (newVal, oldVal) {
        $scope.total = 0;
        if (newVal !== null && newVal !== undefined && newVal.length > 0) {
            $scope.total = $scope.advancedSearch.packages[0].totalRecords;
        }
    });
    $scope.$watch('groupTypeIDs.length', function (newVal, oldVal) {
        if (newVal !== oldVal) {
            if (!$(".page-search").hasClass("filters-open")) {
                $scope.filterPackage();
            }
        }
    });
    $scope.$watch('tripTypeIDs.length', function (newVal, oldVal) {
        if (newVal !== oldVal) {
            if (!$(".page-search").hasClass("filters-open")) {
                $scope.filterPackage();
            }
        }
    });
    $scope.$watch('amenitiesIDs.length', function (newVal, oldVal) {
        if (newVal !== oldVal) {
            if (!$(".page-search").hasClass("filters-open")) {
                $scope.filterPackage();
            }
        }
    });
    $scope.filterLoading = false;
    var cancelerB;
    $scope.DoCtrlPagingAct = function (text, page, pageSize, total) {
        if (cancelerB) {
            $scope.filterLoading = false;
            cancelerB.resolve();
        }
        cancelerB = $q.defer();
        $scope.filterLoading = true;
        $('html, body').animate({
            scrollTop: 0
        }, 300);
        var minPrice = $("#priceRange").slider("values", 0);
        var maxPrice = $("#priceRange").slider("values", 1);
        var rate = $('#rateFilter').raty('score');
        if (rate === null || rate === undefined) {
            rate = 0;
        }
        var data = {"searchText": search, "rate": rate, "minPrice": minPrice, "maxPrice": maxPrice,
            "tripTypeIDs": $scope.tripTypeIDs, "groupTypeIDs": $scope.groupTypeIDs, "amenitiesIDs": $scope.amenitiesIDs, "pageNumber": page};
        $http.post(searchByPageNumberUrl, data, {timeout: cancelerB.promise})
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        $scope.advancedSearch.packages = response.data;
                        $scope.filterLoading = false;
                    }
                });
    };
    var canceler;
    $scope.filterPackage = function () {
        if (canceler) {
            $scope.filterLoading = false;
            canceler.resolve();
        }
        canceler = $q.defer();
        $scope.filterLoading = true;
        var minPrice = $("#priceRange").slider("values", 0);
        var maxPrice = $("#priceRange").slider("values", 1);
        var rate = $('#rateFilter').raty('score');
        if (rate === null || rate === undefined) {
            rate = 0;
        }
        var data = {"searchText": search, "rate": rate, "minPrice": minPrice, "maxPrice": maxPrice,
            "tripTypeIDs": $scope.tripTypeIDs, "groupTypeIDs": $scope.groupTypeIDs, "amenitiesIDs": $scope.amenitiesIDs, "pageNumber": $scope.currentPage};
        $http.post(searchWithFilterUrl, data, {timeout: canceler.promise})
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        $scope.advancedSearch.packages = response.data;
                        $scope.currentPage = 1;
                        $scope.filterLoading = false;
//                        $('html, body').animate({
//                            scrollTop: 0
                        //                        }, 300);
                    }
                });
        if ($(".page-search").hasClass("filters-open")) {
            $(".page-search").removeClass("filters-open");
        }
    };
    $scope.loadFilterOptions = function () {
        $scope.loadingFilter = true;
        var data = {"searchText": search};
        $http.post(getFilterUrl, data)
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        $scope.filterOptions = response.data;
                        $scope.loadingFilter = false;
                    }
                });
    };
    $scope.loadFilterOptions();
    $scope.closeQuickView = function ($event) {
        var selectedPackage = $(angular.element($event.currentTarget)).parents(".package-box");
        if (selectedPackage.children(".category-item-block").is(":hidden")) {
            selectedPackage.children(".category-item-block").slideDown("300");
        }
    };
    $scope.addKeyword = function () {
        var data = {"keyword": $scope.search};
        var insertKeywordUrl = service.getContextPath() + "/Common/NewKeyword";
        $http.post(insertKeywordUrl, data)
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    }
                });
    };
    $scope.addKeyword();
    $scope.initPriceSlider = function () {
        var minValue = 0;
        var maxValue = 1000;
        $("#priceRange").slider({
            range: true,
            min: 0,
            max: 1000,
            values: [0, 1000],
            slide: function (event, ui) {
                //                                                                $("#amount").val("$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ]);
                $("#priceRange").find(".ui-slider-handle").first().html("$" + ui.values[ 0 ]);
                $("#priceRange").find(".ui-slider-handle").last().html("$" + ui.values[ 1 ]);
            },
            create: function (event, ui) {
                $("#priceRange").find(".ui-slider-handle").first().html("$" + minValue);
                $("#priceRange").find(".ui-slider-handle").last().html("$" + maxValue);
            },
            stop: function (event, ui) {
                if (!$(".page-search").hasClass("filters-open")) {
                    $scope.filterPackage();
                }

            }
        });
        $("#rateFilter").raty({
            starOff: service.getContextPath() + '/Resources/Theme/image/star-off.png',
            starOn: service.getContextPath() + '/Resources/Theme/image/star-on.png',
            click: function (score, evt) {
                if (!$(".page-search").hasClass("filters-open")) {
                    $scope.filterPackage();
                }
            }
        });
    };
    $scope.initPriceSlider();
    $scope.openFilters = function () {
        if ($(".page-search").hasClass("filters-open")) {
            $(".page-search").removeClass("filters-open");
        } else {
            $(".page-search").addClass("filters-open");
        }
    };
});
myApp.controller('MainCtrl', function ($scope, $http) {
    $scope.tags = [
        {text: 'Tag1'},
        {text: 'Tag2'},
        {text: 'Tag3'}
    ];
});
myApp.controller('NewBookingEngine', function ($scope, $http, $timeout, service, $interval, $filter) {
    /* COMMON INITIATION */
    $scope.viewSale = false;
    $scope.loading = true;
    $scope.day_of_week = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];
    $scope.month_of_year = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
    Date.prototype.ddMMyyyy = function () {
        var yyyy = this.getFullYear().toString();
        var mm = (this.getMonth() + 1).toString(); // getMonth() is zero-based
        var dd = this.getDate().toString();
        return (dd[1] ? dd : "0" + dd[0]) + "/" + (mm[1] ? mm : "0" + mm[0]) + "/" + yyyy; // padding
    };
    Date.prototype.MMddyyyy = function () {
        var yyyy = this.getFullYear().toString();
        var mm = (this.getMonth() + 1).toString(); // getMonth() is zero-based
        var dd = this.getDate().toString();
        return (mm[1] ? mm : "0" + mm[0]) + "/" + (dd[1] ? dd : "0" + dd[0]) + "/" + yyyy; // padding
    };
    Date.prototype.formatAMPM = function () {
        var hours = this.getHours();
        var minutes = this.getMinutes();
        var ampm = hours >= 12 ? 'PM' : 'AM';
        hours = hours % 12;
        hours = hours ? hours : 12; // the hour '0' should be '12'
        minutes = minutes < 10 ? '0' + minutes : minutes;
        var strTime = hours + ':' + minutes + ' ' + ampm;
        return strTime;
    };
    Date.prototype.formatHHmm = function () {
        // convert minutes to mm
        var minutes = this.getMinutes();
        if (minutes < 10) {
            minutes = "0" + minutes;
        }

        // convert hours to HH
        var hours = this.getHours();
        if (hours < 10) {
            hours = "0" + hours;
        }
        return hours + ":" + minutes;
    };
    $scope.dataJson = dataJson;
    var END_HOUR = 23;
    var END_MINUTES = 59;
    var START_HOURS = 0;
    var START_MINUES = 0;
    var MINUTES_PER_HOUR = 60;
    var FREE_INTERVAL = 15;
    var ALL_PACKAGES_ID = 0;
    var SMALLET_INTERVAL = 5;
    var NO_STEPS_MONTH = 1;
    var NO_STEPS_DAY = 2;
    // construct onlineBookings Hashmap
    var onlinePackagesHashmap = {};
    function constructOnlineHashmap() {
        var newVal = $scope.dataJson.data.onlinePackages;
        onlinePackagesHashmap = {};
        for (var i = 0; i < newVal.length; i++) {
            var package = newVal[i];
            onlinePackagesHashmap[package.packageID] = package;
        }
    }
    constructOnlineHashmap();
    // construct onlineBookings Hashmap
    var offlinePackagesHashmap = {};
    function constructOfflineHashmap() {
        offlinePackagesHashmap = {};
//        var newVal = $scope.dataJson.data.offlinePackages;
//        for (var i = 0; i < newVal.length; i++) {
//            var package = newVal[i];
//            offlinePackagesHashmap[package.packageID] = package;
//        }
    }
    constructOfflineHashmap();
    // combine offline bookings and online bookings, construct noBookings List
    var OFFLINE_COLOR = "54,79,107";
    var bookings = [];
    $scope.noPackageBookings = {};
    $scope.noYearPackageBookings = {};
    function combineBookings() {
        bookings = [];
        $scope.noPackageBookings = {};
        $scope.noYearPackageBookings = {};
        var onlineBookings = $scope.dataJson.data.onlineBookings;
        for (var i = 0; i < onlineBookings.length; i++) {
            var booking = onlineBookings[i];
            //            booking["type"] = "online";
            bookings.push(booking);
            var durationType = booking.durationType;
            var selectedDate = booking.selectedDate;
            var packageID = booking.packageID;
            var travelDate = new Date(selectedDate);
            var endTravelDate;
            if (durationType !== 'days') {
                endTravelDate = new Date(travelDate);
            } else {
                var duration = booking.duration;
                endTravelDate = new Date(travelDate);
                endTravelDate.setDate(endTravelDate.getDate() + duration);
            }

            var dt = new Date(travelDate);
            do {
                // specific package
                var packageR = $scope.noPackageBookings[dt.MMddyyyy()];
                if (!angular.isObject(packageR)) {
                    packageR = {};
                    packageR[packageID] = 0;
                    $scope.noPackageBookings[dt.MMddyyyy()] = packageR;
                }
                var noBookings = packageR[packageID];
                if (!angular.isNumber(noBookings)) {
                    noBookings = 0;
                }
                noBookings++;
                packageR[packageID] = noBookings;
                // add to all packages
                noBookings = packageR[ALL_PACKAGES_ID];
                if (!angular.isNumber(noBookings)) {
                    noBookings = 0;
                }
                noBookings++;
                packageR[ALL_PACKAGES_ID] = noBookings;
                // for year
                var yearR = $scope.noYearPackageBookings[dt.getMonth() + "/" + dt.getFullYear()];
                if (!angular.isObject(yearR)) { // if not exist create new
                    yearR = {};
                    yearR[packageID] = 0;
                    $scope.noYearPackageBookings[dt.getMonth() + "/" + dt.getFullYear()] = yearR;
                }
                noBookings = yearR[packageID];
                if (!angular.isNumber(noBookings)) {
                    noBookings = 0;
                }
                noBookings++;
                yearR[packageID] = noBookings;
                // add to all packages
                noBookings = yearR[ALL_PACKAGES_ID];
                if (!angular.isNumber(noBookings)) {
                    noBookings = 0;
                }
                noBookings++;
                yearR[ALL_PACKAGES_ID] = noBookings;
                dt.setDate(dt.getDate() + 1);
            } while (dt < endTravelDate);
        }

        var offlineBookings = $scope.dataJson.data.offlineBookings;
        for (var i = 0; i < offlineBookings.length; i++) {
            var booking = offlineBookings[i];
            booking["packageName"] = "Offline Booking";
            booking["color"] = OFFLINE_COLOR;
            //            booking["type"] = "offline";
            bookings.push(booking);
            var days = booking.days;
            var selectedDate = booking.dateStr;
            var packageID = -1;
            var travelDate = new Date(selectedDate);
            var endTravelDate = new Date(selectedDate);
            endTravelDate.setDate(endTravelDate.getDate() + days);
            var dt = new Date(travelDate);
            do {
                // specific package
                var packageR = $scope.noPackageBookings[dt.MMddyyyy()];
                if (!angular.isObject(packageR)) {
                    packageR = {};
                    packageR[packageID] = 0;
                    $scope.noPackageBookings[dt.MMddyyyy()] = packageR;
                }

                var noBookings = packageR[packageID];
                if (!angular.isNumber(noBookings)) {
                    noBookings = 0;
                }
                noBookings++;
                packageR[packageID] = noBookings;
                // add to all packages
                noBookings = packageR[ALL_PACKAGES_ID];
                if (!angular.isNumber(noBookings)) {
                    noBookings = 0;
                }
                noBookings++;
                packageR[ALL_PACKAGES_ID] = noBookings;
                dt.setDate(dt.getDate() + 1);
            } while (dt < endTravelDate);
            // for year view
            var yearR = $scope.noYearPackageBookings[dt.getMonth() + "/" + dt.getFullYear()];
            if (!angular.isObject(yearR)) { // if not exist create new
                yearR = {};
                yearR[packageID] = 0;
                $scope.noYearPackageBookings[dt.getMonth() + "/" + dt.getFullYear()] = yearR;
            }
            var noBookings = yearR[packageID];
            if (!angular.isNumber(noBookings)) {
                noBookings = 0;
            }
            noBookings++;
            yearR[packageID] = noBookings;
            // add to all packages
            noBookings = yearR[ALL_PACKAGES_ID];
            if (!angular.isNumber(noBookings)) {
                noBookings = 0;
            }
            noBookings++;
            yearR[ALL_PACKAGES_ID] = noBookings;
        }
    }
    combineBookings();
    // construct hash map json for resources
    var resources = {};
    for (var i = 0, max = $scope.dataJson.data.resources.length; i < max; i++) {
        var resource = $scope.dataJson.data.resources[i];
        resources[resource.resourceID] = resource;
    }

    var remainingResources = {};
    var constructResourceLeftHashMap = function () {
        remainingResources = {};
        var usedResources = $scope.dataJson.data.usedResources;
        var length = usedResources.length;
        for (var i = 0; i < length; i++) {
            var usedResource = usedResources[i];
            var resourceID = usedResource.resourceID;
            var capacity = resources[resourceID].noPeople;
            var dates = remainingResources[resourceID];
            if (!angular.isObject(dates)) {
                remainingResources[resourceID] = {};
                dates = remainingResources[resourceID];
            }

            var tripDate = usedResource.tripDate;
            var times = dates[tripDate];
            if (!angular.isObject(times)) {
                dates[tripDate] = {};
                times = dates[tripDate];
            }

            var tripTime = usedResource.tripTime;
            var noRemainingResources = capacity - usedResource.noUsedResources;
            times[tripTime] = noRemainingResources;
        }
    };
    constructResourceLeftHashMap();
    /* DAY VIEW */

    // function for constructing list of operation times
    var listFreeTimes = [];
    var freeInterval;
    function modifyListTime(packageID) {
        var startOperationTime;
        var endOperationTime;
        var duration;
        if (packageID > 0) {
            var package = onlinePackagesHashmap[packageID];
            var durationType = package.durationType;
            var startTime = package.startOperationTime;
            var endTime = package.endOperationTime;
            var isFreeBooking = package.isFreeBooking;
            if (isFreeBooking) { // if the package is free to book
                freeInterval = package.freeInterval;
                startOperationTime = new Date($scope.selectedDate.MMddyyyy() + " " + startTime);
                endOperationTime = new Date($scope.selectedDate.MMddyyyy() + " " + endTime);
                duration = package.duration;
                durationType === "hours" ? duration *= MINUTES_PER_HOUR : 0;
            } else {
                if (durationType !== "days") {
                    var fixedHour = package.fixedHour;
                    var fixedMinute = package.fixedMinute;
                    freeInterval = fixedHour * 60 + fixedMinute;
                    startOperationTime = new Date($scope.selectedDate.MMddyyyy() + " " + startTime);
                    endOperationTime = new Date($scope.selectedDate.MMddyyyy() + " " + endTime);
                    duration = package.duration;
                    durationType === "hours" ? duration *= MINUTES_PER_HOUR : 0;
                } else {
                    freeInterval = 60;
                    startOperationTime = new Date($scope.selectedDate);
                    endOperationTime = new Date($scope.selectedDate);
                    endOperationTime.setHours(END_HOUR);
                    endOperationTime.setMinutes(60 - freeInterval);
                    endOperationTime.setSeconds(END_MINUTES);
                    duration = 0;
                }
            }
        } else { // if all packages
            freeInterval = FREE_INTERVAL;
//            duration = 0;
//            if (packageID < 0) {
//                var package = offlinePackagesHashmap[-packageID];
//                duration = package.duration;
//                if (package.durationType !== "minutes") {
//                    duration *= 60;
//                }
//            }
            startOperationTime = new Date($scope.selectedDate);
            endOperationTime = new Date($scope.selectedDate);
            endOperationTime.setHours(END_HOUR);
//            endOperationTime.setMinutes(60 - freeInterval);
            endOperationTime.setMinutes(END_MINUTES);
            endOperationTime.setSeconds(END_MINUTES);
        }

        // loop from start to end to construct list times
        listFreeTimes = [];
//        var ending = new Date(endOperationTime);
//        ending.setMinutes(ending.getMinutes() - duration);
//        ending.setMinutes(ending.getMinutes() - duration);
        do {
            var freeTime = {};
            if (startOperationTime.getMinutes() === 0 || (packageID !== 0 && freeInterval > 15)) {
                freeTime["show"] = true;
            } else {
                freeTime["show"] = false;
            }
            freeTime["name"] = startOperationTime.formatHHmm();
            freeTime["time"] = startOperationTime.formatHHmm();
//            startOperationTime <= ending ? freeTime["adding"] = true : freeTime["adding"] = false;
            listFreeTimes.push(freeTime);
            startOperationTime.setMinutes(startOperationTime.getMinutes() + freeInterval);
        } while (startOperationTime <= endOperationTime);
    }

    // construct list booking under td type
    var listBookings = [];
    var MIN_TD_BOOKINGS = 7;
    function constructListBookings(sltDate, packageID) {
        var dateStr = sltDate.MMddyyyy();
//        $scope.listRemainingResources = $scope.dataJson.remainingResources[dateStr];

        listBookings = [];
        // list out bookings on this days
        var fitBookings = [];
        var startOperationTime = new Date(dateStr + " " + listFreeTimes[0].time);
        for (var i = 0; i < bookings.length; i++) {
            // get specific booking
            var booking = bookings[i];
            if ((booking.packageID === packageID && packageID > 0) || packageID <= 0) {
                // get information for each booking
//                var durationType = booking.durationType;
//                var duration = booking.duration;
                var interval;
                if (packageID <= 0) {
                    interval = FREE_INTERVAL;
                } else {
                    interval = onlinePackagesHashmap[packageID].freeInterval;
                }

                var days = booking.days;
                var hours = booking.hours;
                var minutes = booking.minutes;
                var slTime = booking.timeStr;
                var slDate = booking.dateStr;
                var packageName = booking.packageName;
                var color = booking.color;
                var travelTime;
                var tdTime; // time belonging to travel
                var endTravelTime;
                var rowsSpan;
                var startRow;
                var isInside = false; // Is this bookings relating to this date
                var thisDate = new Date(sltDate);
                // calculate travelTime and endTravelTime and rowsSpan
                if (days > 0) {
                    // get start time and end time to check isInside and get affected times
                    travelTime = new Date(slDate + " 00:00:00");
                    endTravelTime = new Date(travelTime);
                    var duration = days * 24 - 1;
                    endTravelTime.setHours(endTravelTime.getHours() + duration);
                    // not to new day
                    endTravelTime.setMinutes(60 - interval);
                    rowsSpan = 24 * (Math.ceil(60 / interval));
                    startRow = "00:00";
                    if (thisDate <= endTravelTime && thisDate >= travelTime) {
                        isInside = true;
                        // tdTime would be date
                        tdTime = slDate;
                        travelTime = new Date(dateStr + " 00:00:00");
                        endTravelTime = new Date(travelTime);
                        var endRange = 24 * 60 - interval;
                        endTravelTime.setMinutes(endRange);
//                        endTravelTime = new Date(newVal.MMddyyyy() + " 23:45:00");
                    }
                } else {
                    if (thisDate.MMddyyyy() === slDate) { // if this book date is this date
                        var duration = hours * 60 + minutes;
                        isInside = true;
                        // tdTime would be date
                        tdTime = slTime;
                        // then start time and end time of affected duration
                        travelTime = new Date(slDate + " " + slTime);
                        endTravelTime = new Date(travelTime);
                        endTravelTime.setMinutes(endTravelTime.getMinutes() + duration);
                        // modify to fit travelTime
                        var difference = travelTime.getTime() - startOperationTime.getTime(); // This will give difference in milliseconds
                        var correctFactor = Math.floor(Math.round(difference / 60000) / interval);
                        travelTime = new Date(startOperationTime);
                        travelTime.setMinutes(travelTime.getMinutes() + correctFactor * interval);
                        travelTime.setSeconds(0);
                        difference = endTravelTime.getTime() - startOperationTime.getTime(); // This will give difference in milliseconds
                        correctFactor = Math.round(difference / 60000) / interval;
                        // if end time is exactly then minus one step
                        var addMinutes;
                        if (correctFactor % 1 !== 0) {
                            correctFactor = Math.floor(correctFactor);
                            addMinutes = 0;
                        } else {
                            addMinutes = (-interval);
                        }

                        addMinutes += (correctFactor * interval);
                        endTravelTime = new Date(startOperationTime);
                        endTravelTime.setMinutes(endTravelTime.getMinutes() + addMinutes);
                        endTravelTime.setSeconds(0);
                        // caculate rowspan from correct time
                        difference = endTravelTime.getTime() - travelTime.getTime(); // This will give difference in milliseconds
                        rowsSpan = (Math.round(difference / 60000) / interval) + 1;
                    }
                }

                if (isInside) { // if is inside

                    var fitBooking = {"travelTime": travelTime, "endTravelTime": endTravelTime, "rowsSpan": rowsSpan,
                        "packageName": packageName, "tdTime": tdTime, "color": color};
                    // order fitBookings
                    var position;
                    for (position = 0; position < fitBookings.length; position++) {
//                    var bookingTravelTime = fitBookings[position]["travelTime"];
                        var bookingRowSpan = fitBookings[position]["rowsSpan"];
                        if (rowsSpan > bookingRowSpan) {
                            break;
                        } else if (rowsSpan === bookingRowSpan) {
//                    } else if (travelTime.getTime() === bookingTravelTime.getTime()) {
//                        console.log("------------haha----------" + travelTime);
//                        console.log(travelTime);
//                        console.log(bookingTravelTime);
//                        do {
//                        var bookingRowSpan = fitBookings[position]["rowsSpan"];
//                            if (rowsSpan >= bookingRowSpan || travelTime.getTime() !== bookingTravelTime.getTime()) {
//                                break;
//                            }
//                            position++;
//                            bookingTravelTime = fitBookings[position]["travelTime"];
//                        } while (position < fitBookings.length);
//                        break;
//                        console.log("---End--");
                            do {
                                var bookingTravelTime = fitBookings[position]["travelTime"];
                                bookingRowSpan = fitBookings[position]["rowsSpan"];
                                if (travelTime < bookingTravelTime || rowsSpan !== bookingRowSpan) {
                                    break;
                                }
                                position++;
                            } while (position < fitBookings.length);
                            break;
                        }
                    }
                    fitBookings.splice(position, 0, fitBooking);
                }
            }
        }

        // calculate list td from bookings
        for (var i = 0; i < fitBookings.length; i++) {
            // define times
            var travelTime = fitBookings[i].travelTime;
            var endTravelTime = fitBookings[i].endTravelTime;
            var packageName = fitBookings[i].packageName;
            var rowsSpan = fitBookings[i].rowsSpan;
            var tdTime = fitBookings[i].tdTime;
            var color = fitBookings[i].color;
            var rangeTime = {};
            // define creating new range or modify old range
            var isExist = true;
            for (var k = 0; k < listBookings.length; k++) {
                isExist = false;
                var listBooking = listBookings[k];
                var rangeTimes = listBooking.rangeTimes;
                for (var l = 0; l < rangeTimes.length; l++) {
                    var range = rangeTimes[l];
                    var minRange = range.travelTime;
                    var maxRange = range.endTravelTime;
                    if ((travelTime >= minRange && travelTime <= maxRange) ||
                            (endTravelTime >= minRange && endTravelTime <= maxRange)
                            || (travelTime <= minRange && endTravelTime >= maxRange)) { // if is in old range
                        // then break move to new booking
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) { // if not is in old range
                    // get old range to modify
                    var newRange = {};
                    newRange["travelTime"] = new Date(travelTime);
                    newRange["endTravelTime"] = new Date(endTravelTime);
                    rangeTimes.push(newRange);
                    rangeTime = listBooking;
                    break;
                }
            }

            if (isExist) { // if new Range
                var newRange = {};
                newRange["travelTime"] = new Date(travelTime);
                newRange["endTravelTime"] = new Date(endTravelTime);
                var rangeTimes = [];
                rangeTimes.push(newRange);
                rangeTime["rangeTimes"] = rangeTimes;
                // add the range to list range
                listBookings.push(rangeTime);
            }

            var time = new Date(travelTime);
            do {
                // convert minutes to mm
                var minutes = time.getMinutes();
                if (minutes < 10) {
                    minutes = "0" + minutes;
                }

                // convert hours to HH
                var hours = time.getHours();
                if (hours < 10) {
                    hours = "0" + hours;
                }

                // add to list times
                rangeTime[hours + ":" + minutes] = {"rowspan": rowsSpan, "packageName": packageName, "tdTime": tdTime, "color": color};
                rowsSpan = 0;
                // next 15 minutes
                time.setMinutes(time.getMinutes() + freeInterval);
            } while (time <= endTravelTime);
        }

        // gaps
        for (var i = listBookings.length; i < MIN_TD_BOOKINGS; i++) {
            listBookings.push({});
        }
    }

    function constructDayViewTable() {
        // loop times
        var timeLenght = listFreeTimes.length;
        var bookingLegth = listBookings.length;
        var tableHtml = "<tbody>";
        for (var i = 0; i < timeLenght; i++) {
            var freeTime = listFreeTimes[i];
            tableHtml += "<tr " + (freeTime.show ? "class='seperateRow'" : "") + ">";
//            tableHtml += "<td class='singleTime " + (freeTime.adding ? "addingActive" : "") + "' time='" + freeTime.time + "'>"
            tableHtml += "<td class='singleTime addingActive' time='" + freeTime.time + "'>"
                    + "<span>" + freeTime.name + "</span>"
                    + "</td>";
            // loop bookings per row
            for (var j = 0; j < bookingLegth; j++) {
                var booking = listBookings[j];
                var bookingAtTime = booking[freeTime.time];
                if (!bookingAtTime || (!!bookingAtTime && bookingAtTime.rowspan > 0)) {
                    if (!!bookingAtTime) {
                        tableHtml += "<td rowspan='" + bookingAtTime.rowspan + "'>"
                                + "<div   class='engineBookingBox' style='border-top: solid 5px rgb(" + bookingAtTime.color + ");"
                                + " background-color: rgba(" + bookingAtTime.color + ", 0.3);'>"
                                + "<div style='white-space: nowrap'>"
                                + "<span class='bookingBoxNameAlt' style='background-color: rgb(" + bookingAtTime.color + ");'></span>"
                                + "<span class='bookingBoxName'>" + bookingAtTime.packageName + "</span>"
                                + "</div>"
                                + "<span class='bookingBoxTime'>" + bookingAtTime.tdTime + "</span>"
                                + "</div>";
                    } else {
                        tableHtml += "<td>";
                    }
                    tableHtml += "</td>";
                }
            }
            tableHtml += "</tr>";
        }
        tableHtml += "</tbody>";
        return tableHtml;
    }

    var dateDetails = {};
    function calculateResourcesLeftForSpecificDate(date) {
        var listResourcesLeft = {};
        var resources = $scope.dataJson.data.resources;
        var resourcesLength = resources.length;
        var usedResources = $scope.dataJson.data.usedResources;
        var dateStr = date.MMddyyyy();
        for (var i = 0, max = usedResources.length; i < max; i++) {
            var usedResource = usedResources[i];
            var tripDate = usedResource.tripDate;
            var tripTime = usedResource.tripTime;
            var resourceID = usedResource.resourceID;
            var noUsedResources = usedResource.noUsedResources;
            if (tripDate === dateStr) { // get data for selected date
                var remainingResources = listResourcesLeft[tripTime];
                // if remaining is not exist yet then get default no resources
                if (!angular.isObject(remainingResources)) {
                    remainingResources = {};
                    listResourcesLeft[tripTime] = remainingResources;
                    for (var j = 0; j < resourcesLength; j++) {
                        var resource = resources[j];
                        var newR = {"name": resource.name, "noPeople": resource.noPeople};
                        remainingResources[resource.resourceID] = newR;
                    }
                }

                // minus no used 
                var noPeople = remainingResources[resourceID].noPeople;
                remainingResources[resourceID].noPeople = noPeople - noUsedResources;
            }
        }

        return listResourcesLeft;
    }

    // get resources left when specific time is hovered
    function calculateResourcesLeft(time, dateDetails) {
        // iniate remaining resources for this time
        var resources = $scope.dataJson.data.resources;
        var length = resources.length;
        var remainingResources = dateDetails[time];
        if (!angular.isObject(remainingResources)) {
            remainingResources = {};
            for (var i = 0; i < length; i++) {
                var resource = resources[i];
                var newR = {"name": resource.name, "noPeople": resource.noPeople};
                remainingResources[resource.resourceID] = newR;
            }
        }
        return remainingResources;
    }

    // show detail for time is hovered
    var promiseForR;
    $scope.remainingResources = {};
    $(document).on('mouseenter', '#bookingEngineContent table.table>tbody>tr .singleTime', function () { // when tr is hover
        $timeout.cancel(promiseForR);
        $(this).addClass("hovered");
        var left = $(this).offset().left - $("#dayViewContent").offset().left;
        var top = $(this).offset().top - $("#dayViewContent").offset().top;
        var width = $(this).outerWidth();
        $(".remainingResourceBox").css("top", top + 20);
        $(".remainingResourceBox").css("left", left + width - 10);
        !$(".remainingResourceBox").hasClass("active") ? $(".remainingResourceBox").addClass("active") : 0;
        !$(".remainingResourceBox").hasClass("loading") ? $(".remainingResourceBox").addClass("loading") : 0;
        var time = $(this).attr("time");
        //        $scope.hoveredTime = time;
        promiseForR = $timeout(function () {
            $scope.remainingResources = {};
            $scope.remainingResources = calculateResourcesLeft(time, dateDetails);
            $scope.$digest();
            $(".remainingResourceBox").hasClass("loading") ? $(".remainingResourceBox").removeClass("loading") : 0;
        }, 100);
    }).on('mouseleave', '#bookingEngineContent table.table>tbody>tr .singleTime', function () { // when tr is no longer hovered
        $timeout.cancel(promiseForR);
        $(this).removeClass("hovered");
        $(".remainingResourceBox").hasClass("active") ? $(".remainingResourceBox").removeClass("active") : 0;
        $(".remainingResourceBox").hasClass("loading") ? $(".remainingResourceBox").removeClass("loading") : 0;
    });
    $scope.viewChanging = false;
    $scope.spinnerTop = 0;
    $scope.nextDate = function () {
        $timeout.cancel(promiseForDate);
        $scope.spinnerTop = $("#tableScroll").scrollTop();
        $scope.viewChanging = true;
        $scope.selectedDate.setDate($scope.selectedDate.getDate() + 1);
        promiseForDate = $timeout(function () {
            constructListBookings($scope.selectedDate, $scope.selectedPackageID);
            dateDetails = calculateResourcesLeftForSpecificDate($scope.selectedDate);
            $("table.dayTable").html(constructDayViewTable());
            $scope.viewChanging = false;
        }, 300);
    };
    $scope.previousDate = function () {
        $timeout.cancel(promiseForDate);
        $scope.spinnerTop = $("#tableScroll").scrollTop();
        $scope.viewChanging = true;
        $scope.selectedDate.setDate($scope.selectedDate.getDate() - 1);
        promiseForDate = $timeout(function () {
            constructListBookings($scope.selectedDate, $scope.selectedPackageID);
            dateDetails = calculateResourcesLeftForSpecificDate($scope.selectedDate);
            $("table.dayTable").html(constructDayViewTable());
            $scope.viewChanging = false;
        }, 300);
    };
    var timeNow = new Date(timeNowVar);
    $scope.nowResourcesLeft = {};
    function calculateTimeNow() {
        timeNow.setMinutes(timeNow.getMinutes() + 1);
        var newTime = new Date(timeNow);
        var minutes = newTime.getMinutes();
        var factor = minutes % freeInterval;
        newTime.setMinutes(timeNow.getMinutes() - factor);
        var timeHHmm = newTime.formatHHmm();
        if ($(".singleTime[time='" + timeHHmm + "']").length > 0) {
            var timeTop = $(".singleTime[time='" + timeHHmm + "']").offset().top;
            var minusTop = timeTop - $("#dayViewContent").offset().top;
            $("#nowTimeLine").css("top", minusTop + 25);
            $("#nowTimeLine").show();
        } else {

            $("#nowTimeLine").hide();
        }
        $scope.nowResourcesLeft = calculateResourcesLeft(timeHHmm, dateDetails);
    }

    $interval(function () {
        calculateTimeNow();
    }, 60000);
    $scope.nowResourceIndex = 0;
    $scope.upNowResource = function () {
        var keys = Object.keys($scope.nowResourcesLeft);
        var len = keys.length;
        if ($scope.nowResourceIndex === (len - 1)) {
            $scope.nowResourceIndex = 0;
        } else {
            $scope.nowResourceIndex++;
        }
    };
    $scope.downNowResource = function () {
        var keys = Object.keys($scope.nowResourcesLeft);
        var len = keys.length;
        if ($scope.nowResourceIndex === 0) {
            $scope.nowResourceIndex = len - 1;
        } else {
            $scope.nowResourceIndex--;
        }
    };
    /* WEEK VIEW */
    var weekViewPromise;
    $scope.nextWeek = function () {
        $timeout.cancel(weekViewPromise);
        $scope.spinnerTop = $("#tableScroll").scrollTop();
        $scope.viewChanging = true;
        $scope.selectedDate.setDate($scope.selectedDate.getDate() + 7);
        updateFromAndToWeek($scope.selectedDate);
        weekViewPromise = $timeout(function () {
            $("#datepicker").datepicker("setDate", $scope.selectedDate.MMddyyyy());
            var htmlJson = constructWeekViewTable($scope.selectedPackageID, $scope.fromWeekDate, $scope.toWeekDate);
            $("table.weekTable tbody").html(htmlJson.headerHtml);
            $("table#weekBookings").html(htmlJson.bookingHtml);
            $scope.viewChanging = false;
        }, 350);
    };
    $scope.previousWeek = function () {
        $timeout.cancel(weekViewPromise);
        $scope.spinnerTop = $("#tableScroll").scrollTop();
        $scope.viewChanging = true;
        $scope.selectedDate.setDate($scope.selectedDate.getDate() - 7);
        updateFromAndToWeek($scope.selectedDate);
        weekViewPromise = $timeout(function () {
            $("#datepicker").datepicker("setDate", $scope.selectedDate.MMddyyyy());
            var htmlJson = constructWeekViewTable($scope.selectedPackageID, $scope.fromWeekDate, $scope.toWeekDate);
            $("table.weekTable tbody").html(htmlJson.headerHtml);
            $("table#weekBookings").html(htmlJson.bookingHtml);
            $scope.viewChanging = false;
        }, 250);
    };
    // get range from sunday to saturday
    $scope.fromWeekDate;
    $scope.toWeekDate;
    function updateFromAndToWeek(slDate) {
        // sunday
        $scope.fromWeekDate = new Date(slDate);
        $scope.fromWeekDate.setHours(0);
        $scope.fromWeekDate.setMinutes(0);
        $scope.fromWeekDate.setSeconds(0);
        var distance = $scope.fromWeekDate.getDay();
        $scope.fromWeekDate.setDate($scope.fromWeekDate.getDate() - distance);
        // saturday
        $scope.toWeekDate = new Date(slDate);
        var distance = $scope.toWeekDate.getDay();
        $scope.toWeekDate.setDate($scope.toWeekDate.getDate() + (6 - distance));
        $scope.toWeekDate.setHours(23);
        $scope.toWeekDate.setMinutes(59);
        $scope.toWeekDate.setSeconds(59);
    }

    var ONE_DAY = 24 * 60 * 60 * 1000;
    var MINIMUM_ROWS = 20;
    function constructWeekViewTable(packageID, fromDate, toDate) {
        // list out dates of week
        var weekTimes = [];
        var i = new Date(fromDate);
        do {
            weekTimes.push(new Date(i));
            // next Date
            i.setDate(i.getDate() + 1);
        } while (i <= toDate);
        // list out bookings belong to this week
        var weekBookings = []; // check each booking
        var orderedBookings = [];
        for (var i = 0; i < bookings.length; i++) {
            // get specific booking
            var booking = bookings[i];
            // filter bookings
            if ((booking.packageID === packageID && packageID > 0) || packageID <= 0) {
                // get information for each booking
//                var durationType = booking.durationType;
//                var duration = booking.duration;
                var days = booking.days;
                var hours = booking.hours;
                var minutes = booking.minutes;
                var slTime = booking.timeStr;
                var slDate = booking.dateStr;
                var color = booking.color;
                var travelTime;
                var endTravelTime;
                var colspan;
                var startCol;
                var time;
                var isInside = false; // Is this bookings relating to this date

                if (hours > 0 || minutes > 0) {
                    travelTime = new Date(slDate);
                    endTravelTime = new Date(travelTime);
                    if (travelTime >= fromDate && endTravelTime <= toDate) {
                        isInside = true;
                        colspan = 1;
                        startCol = travelTime.MMddyyyy();
                        time = slTime;
                    }
                } else {
                    travelTime = new Date(slDate);
                    endTravelTime = new Date(travelTime);
                    endTravelTime.setDate(endTravelTime.getDate() + days);
                    // check is inside or not and calculate colspan
                    var isStartInside = false;
                    var isEndInside = false;
                    if (travelTime >= fromDate && travelTime <= toDate) {
                        // check start time is inside or not 
                        isStartInside = true;
                    }
                    if (endTravelTime >= fromDate && endTravelTime <= toDate) {
                        // check start time is inside or not 
                        isEndInside = true;
                    }
                    if (isStartInside && !isEndInside) {
                        isInside = true;
                        colspan = Math.round(Math.abs((toDate.getTime() - travelTime.getTime()) / (ONE_DAY)));
                        startCol = travelTime.MMddyyyy();
                    } else if (!isStartInside && isEndInside) {
                        isInside = true;
                        colspan = Math.round(Math.abs((fromDate.getTime() - endTravelTime.getTime()) / (ONE_DAY)));
                        startCol = endTravelTime.MMddyyyy();
                    } else if (isStartInside && isEndInside) {
                        isInside = true;
                        colspan = Math.round(Math.abs((endTravelTime.getTime() - travelTime.getTime()) / (ONE_DAY)));
                        startCol = travelTime.MMddyyyy();
                    }
                    time = slDate;
                }
                // order new Booking 
                if (isInside) {
                    var newB = {
                        "startCol": startCol,
                        "colspan": colspan,
                        "time": time,
                        "travelTime": travelTime,
                        "endTravelTime": endTravelTime,
                        "packageName": booking.packageName,
                        "color": color
                    };
                    var position = 0;
                    for (; position < orderedBookings.length; position++) {
                        var bookingColspan = orderedBookings[position].colspan;
                        if (colspan >= bookingColspan) {
                            break;
                        }
                    }
                    orderedBookings.splice(position, 0, newB);
                }
            }
        }

        // construct listBookings for table from ordered bookings
        var max = orderedBookings.length;
        for (var m = 0; m < max; m++) {
            var rangeTimes = [];
            var bookingsRow = {};
            var orderBooking = orderedBookings[m];
            var travelTime = orderBooking.travelTime;
            var endTravelTime = orderBooking.endTravelTime;
            var colspan = orderBooking.colspan;
            var time = orderBooking.time;
            var startCol = orderBooking.startCol;
            var weekBookingsLength = weekBookings.length;
            var isInRange = true;
            for (var k = 0; k < weekBookingsLength; k++) {
                isInRange = false;
                bookingsRow = weekBookings[k];
                rangeTimes = bookingsRow.rangeTimes;
                var rangeLength = rangeTimes.length;
                for (var j = 0; j < rangeLength; j++) {
                    var startRange = rangeTimes[j].start;
                    var endRange = rangeTimes[j].end;
                    // check is inrange then break
                    if ((travelTime >= startRange && travelTime <= endRange) ||
                            (endTravelTime >= startRange && endTravelTime <= endRange) ||
                            (travelTime <= startRange && endTravelTime >= endRange)) { // if is in old range
                        isInRange = true;
                        break;
                    }
                }
                // if not inrange break and get old booking row
                if (!isInRange) {
                    break;
                }
            }

            if (isInRange) { // if is in old range
                // then new array
                rangeTimes = [];
                bookingsRow = {};
                bookingsRow["rangeTimes"] = rangeTimes;
                weekBookings.push(bookingsRow);
            }

            var newRange = {
                "start": travelTime,
                "end": endTravelTime
            };
            rangeTimes.push(newRange);
            // loop each date in duration of bookings
            var dt = new Date(travelTime);
            var color = orderBooking.color;
            do {
                bookingsRow[dt.MMddyyyy()] = {
                    "colspan": colspan,
                    "time": time,
                    "packageName": orderBooking.packageName,
                    "color": color
                };
                colspan = 0;
                dt.setDate(dt.getDate() + 1);
            } while (dt < endTravelTime);
        }

        // gaps remaining row
        var rowLength = weekBookings.length;
        for (var i = rowLength; i < MINIMUM_ROWS; i++) {
            weekBookings[i] = {};
        }
        // construct string html for header
        var headerHtml = "<tr>";
        for (var j = 0, timeMax = weekTimes.length; j < timeMax; j++) {
            var weekTime = weekTimes[j];
            var listBookings = $scope.noPackageBookings[weekTime.MMddyyyy()];
            var noBookings = 0;
            if (!!listBookings) {
                if (listBookings[packageID] > 0) {
                    noBookings = $scope.noPackageBookings[weekTime.MMddyyyy()][packageID];
                }
            }
            headerHtml += "<td time='" + weekTime.MMddyyyy() + "'>"
                    + "<div class='weekHeaderDetail " + (noBookings > 0 ? "hasBookings" : "") + "'>"
                    + "<div class='weekDate'><span>"
                    + weekTime.getDate()
                    + "</span></div>";
            headerHtml += "<div class='weekNoBookings'>"
                    + "No. bookings: "
                    + "<span>" + noBookings + "</span>"
                    + "</div>"
                    + "</div>"
                    + "</td>";
        }
        headerHtml += "</tr>";
        // construct string html bookings and header
        var html = "";
        for (var i = 0, max = weekBookings.length; i < max; i++) {
            var booking = weekBookings[i];
            html += "<tr>";
            for (var j = 0, timeMax = weekTimes.length; j < timeMax; j++) {
                var weekTime = weekTimes[j];
                if (!booking[weekTime.MMddyyyy()]) {
                    html += "<td></td>";
                } else {
                    var singleWeekBooking = booking[weekTime.MMddyyyy()];
                    var colspan = singleWeekBooking.colspan;
                    if (colspan > 0) {
                        var color = singleWeekBooking.color;
                        html += "<td colspan='" + colspan + "'>"
                                + "<div class='singleWeekBooking' style='border-top: solid 5px rgb(" + color + "); background-color: rgba(" + color + ",0.3)'>"
                                + "<div class='weekBookingName'>"
                                + "<span class='weekBookingDot'  style='background-color: rgb(" + color + ")'></span>"
                                + singleWeekBooking.packageName
                                + "</div>"
                                + "<span class='weekBuyerName'>Long</span>"
                                + "</div>";
                        +"</td>";
                    }
                }
            }
            html += "</tr>";
        }
        var htmlResult = {"headerHtml": headerHtml, "bookingHtml": html};
        return htmlResult;
    }

    /* MONTH VIEW */
    var monthViewPromise;
    var FIRST_DATE_OF_MONTH = 1;
    $scope.nextMonth = function () {
        $timeout.cancel(monthViewPromise);
        $scope.spinnerTop = $("#tableScroll").scrollTop();
        $scope.viewChanging = true;
        $scope.selectedDate.setDate(FIRST_DATE_OF_MONTH);
        $scope.selectedDate.setMonth($scope.selectedDate.getMonth() + NO_STEPS_MONTH);
        monthViewPromise = $timeout(function () {
            $("#datepicker").datepicker("setDate", $scope.selectedDate.MMddyyyy());
            var monthHtml = updateBookingData($scope.selectedDate, $scope.selectedPackageID);
            $("table.monthTable tbody").html(monthHtml);
            $scope.viewChanging = false;
        }, 200);
    };
    $scope.previousMonth = function () {
        $timeout.cancel(monthViewPromise);
        $scope.spinnerTop = $("#tableScroll").scrollTop();
        $scope.viewChanging = true;
        $scope.selectedDate.setDate(FIRST_DATE_OF_MONTH);
        $scope.selectedDate.setMonth($scope.selectedDate.getMonth() - NO_STEPS_MONTH);
        monthViewPromise = $timeout(function () {
            $("#datepicker").datepicker("setDate", $scope.selectedDate.MMddyyyy());
            var monthHtml = updateBookingData($scope.selectedDate, $scope.selectedPackageID);
            $("table.monthTable tbody").html(monthHtml);
            $scope.viewChanging = false;
        }, 200);
    };
    var NO_WEEKS_OF_MONTH = 6;
    var NO_DAYS_OF_WEEK = 7;
    function updateBookingData(slDate, packageID) {
        var monthBookingData = [];
        // return to first sunday of month
        var currentMonth = slDate.getMonth();
        var currentDate = new Date(slDate);
        currentDate.setDate(1);
        var distance = currentDate.getDay();
        currentDate.setDate(currentDate.getDate() - distance);
        // loop 6 weeks
        for (var i = 0; i < NO_WEEKS_OF_MONTH; i++) {
            var singleWeek = [];
            for (var j = 0; j < NO_DAYS_OF_WEEK; j++) { // loop 7 days
                var singleDate = {"date": currentDate.getDate(), "fulldate": currentDate.MMddyyyy()};
                if (currentMonth === currentDate.getMonth()) {
                    singleDate["inMonth"] = true;
                } else {
                    singleDate["inMonth"] = false;
                }
                // plus date to week
                singleWeek.push(singleDate);
                currentDate.setDate(currentDate.getDate() + 1);
            }
            // plus week to month
            monthBookingData.push(singleWeek);
        }

        // construct string html of month view
        var html = "";
        for (var i = 0, max = monthBookingData.length; i < max; i++) {
            var week = monthBookingData[i];
            html += "<tr>";
            for (var j = 0, weekMax = week.length; j < weekMax; j++) {
                var day = week[j];
                var bookingsForDate = $scope.noPackageBookings[day.fulldate];
                var hasBookings = "";
                var bookingsContent = "";
                if (!!bookingsForDate) {
                    var noBookings = bookingsForDate[packageID];
                    if (!!noBookings) {

                        // date detail
                        hasBookings = "hasBookings";
                        bookingsContent = "<div class='monthPackageBookings'><ul>";
                        if (packageID > 0) {
                            var package = onlinePackagesHashmap[packageID];
                            bookingsContent += "<li>"
                                    + "<span style='background-color: rgb(" + package.color + ")'></span> "
                                    + package.packageName + ": "
                                    + noBookings
                                    + "</li>";
                        } else if (packageID < 0) {
//                            var package = offlinePackagesHashmap[-packageID];
                            bookingsContent += "<li>"
                                    + "<span style='background-color: rgb(" + OFFLINE_COLOR + ")'></span> "
                                    + "Offline Bookings: "
                                    + noBookings
                                    + "</li>";
                        } else {
                            // if select all
                            angular.forEach(bookingsForDate, function (noPackageBookings, specificPackageID) {
                                var color;
                                var packageName;
                                if (parseInt(specificPackageID) !== 0) {
                                    if (specificPackageID > 0) {
                                        var package = onlinePackagesHashmap[specificPackageID];
                                        color = package.color;
                                        packageName = package.packageName;
                                    } else if (specificPackageID < 0) {
                                        color = OFFLINE_COLOR;
                                        packageName = "Offline Bookings";
                                    }

                                    bookingsContent += "<li>"
                                            + "<span style='background-color: rgb(" + color + ")'></span> "
                                            + packageName + ": "
                                            + noPackageBookings
                                            + "</li>";
                                }
                            });
                        }
                        bookingsContent += "</ul></div>";
                    }
                }
                html += "<td time='" + day.fulldate + "' class='" + (!day.inMonth ? "outsideCln" : "") + (day.fulldate === slDate.MMddyyyy() ? " selected" : "") + "'>"
                        + "<div class='dateDetail " + hasBookings + "'>"
                        + "<div class='dateNumber'><span>"
                        + day.date
                        + "</span></div>"
                        + bookingsContent
                        + "</div>"
                        + "</td>";
            }
            html += "</tr>";
        }
        return html;
    }

    /* YEAR VIEW */

    $scope.previousYear = function () {
        $scope.selectedDate.setFullYear($scope.selectedDate.getFullYear() - 1);
    };
    $scope.nextYear = function () {
        $scope.selectedDate.setFullYear($scope.selectedDate.getFullYear() + 1);
    };
    $scope.moveToMonthView = function (month) {
        $scope.selectedDate.setMonth(month);
        $scope.viewType = "month";
        $scope.viewChange();
    };
    /* CALENDAR */
    var promiseForDate;
    function initiateCalendar(defaultDate) {
        // initate Calendar
        $("#datepicker").datepicker({
            defaultDate: defaultDate,
            numberOfMonths: NO_STEPS_DAY,
            stepMonths: 1,
            onSelect: function (selectedDate, inst) {
                if (selectedDate !== $scope.selectedDate.MMddyyyy()) {
                    $timeout.cancel(promiseForDate);
                    $scope.viewType !== "day" ? $scope.viewType = "day" : 0;
                    var date = new Date(selectedDate);
                    $("#dayViewTime").html(date.getDate() + " " + $scope.month_of_year[date.getMonth()] + "," + date.getFullYear());
                    $("table.dayTable").hasClass("active") ? $("table.dayTable").removeClass("active") : 0;
                    promiseForDate = $timeout(function () {
                        $scope.selectedDate = new Date(selectedDate);
                        constructListBookings($scope.selectedDate, $scope.selectedPackageID);
                        dateDetails = calculateResourcesLeftForSpecificDate($scope.selectedDate);
                        $("table.dayTable").html(constructDayViewTable());
                        !$("table.dayTable").hasClass("active") ? $("table.dayTable").addClass("active") : 0;
                    }, 100);
                }
            }
        });
    }

    $scope.nextMonthOfCalendar = function () {
        $(".bookingQuickCalendar .ui-datepicker.ui-datepicker-multi .ui-datepicker-next").trigger("click");
    };
    $scope.previousMonthOfCalendar = function () {
        $(".bookingQuickCalendar .ui-datepicker.ui-datepicker-multi .ui-datepicker-prev").trigger("click");
    };
    /* PACKAGES DROPDOWN LIST AND VIEW TYPE*/
    // dropdown list, when select is clicked
    $scope.showDDlMenu = function () {
        $(".packagesDdl .packageDdlMenu").toggleClass("active");
    };
    var DEFAULT_COLOR = "";
    var DEFAULT_PACKAGE_NAME = "All packages";
    $scope.ddpSelectedPackage = {color: DEFAULT_COLOR, packageName: DEFAULT_PACKAGE_NAME};
    $scope.changeSelectedPackage = function (packageID) {
        if ($scope.selectedPackageID !== packageID) {
            $scope.spinnerTop = $("#tableScroll").scrollTop();
            $scope.viewChanging = true;
            if (packageID === 0) {
                $scope.ddpSelectedPackage.color = DEFAULT_COLOR;
                $scope.ddpSelectedPackage.packageName = DEFAULT_PACKAGE_NAME;
            } else if (packageID > 0) {
                var package = onlinePackagesHashmap[packageID];
                $scope.ddpSelectedPackage.color = package.color;
                $scope.ddpSelectedPackage.packageName = package.packageName;
            } else {
//                var package = offlinePackagesHashmap[-packageID];
                $scope.ddpSelectedPackage.color = OFFLINE_COLOR;
                $scope.ddpSelectedPackage.packageName = "Offline Bookings";
            }
            $scope.selectedPackageID = packageID;
            $scope.viewChange();
        }
    };
    // this function is called when selecting other packages
    var packageChangePromise;
    $scope.viewChange = function () {
        $scope.spinnerTop = $("#tableScroll").scrollTop();
        $scope.viewChanging = true;
        if ($scope.viewType === "day") {
            $timeout.cancel(packageChangePromise);
            packageChangePromise = $timeout(function () {
                modifyListTime($scope.selectedPackageID);
                constructListBookings($scope.selectedDate, $scope.selectedPackageID);
                dateDetails = calculateResourcesLeftForSpecificDate($scope.selectedDate);
                $("table.dayTable").html(constructDayViewTable());
                calculateTimeNow();
                $scope.viewChanging = false;
            }, 100);
        } else if ($scope.viewType === "week") {
            $timeout.cancel(weekViewPromise);
            updateFromAndToWeek($scope.selectedDate);
            weekViewPromise = $timeout(function () {
                var htmlJson = constructWeekViewTable($scope.selectedPackageID, $scope.fromWeekDate, $scope.toWeekDate);
                $("table.weekTable tbody").html(htmlJson.headerHtml);
                $("table#weekBookings").html(htmlJson.bookingHtml);
                $scope.viewChanging = false;
            }, 100);
        } else if ($scope.viewType === "month") {
            $timeout.cancel(monthViewPromise);
            monthViewPromise = $timeout(function () {
                var monthHtml = updateBookingData($scope.selectedDate, $scope.selectedPackageID);
                $("table.monthTable tbody").html(monthHtml);
                $scope.viewChanging = false;
            }, 100);
        } else {
            $scope.viewChanging = false;
        }
    };
    // select date on weekview, monthview to change to day view
    $(document).on('click', "table.weekTable tbody tr td, table.monthTable tbody tr td", function () {
        $timeout.cancel(promiseForDate);
        $scope.spinnerTop = $("#tableScroll").scrollTop();
        $scope.viewChanging = true;
        var timeStr = $(this).attr("time");
        $("#datepicker").datepicker("setDate", timeStr);
        $scope.viewType = "day";
        var date = new Date(timeStr);
        $("#dayViewTime").html(date.getDate() + " " + $scope.month_of_year[date.getMonth()] + "," + date.getFullYear());
        promiseForDate = $timeout(function () {
            $scope.selectedDate = new Date(timeStr);
            constructListBookings($scope.selectedDate, $scope.selectedPackageID);
            dateDetails = calculateResourcesLeftForSpecificDate($scope.selectedDate);
            $("table.dayTable").html(constructDayViewTable());
            $scope.viewChanging = false;
        }, 100);
    });
    // ADDING BOOKINGS

    $scope.packageDropdownlistShown = true;
    $scope.addingPackageName = "";
    $scope.chosenOnlinePackageID;
    $scope.chosenOfflinePackageID;
    $scope.chosenTime = {};
    $scope.addingProcessing = false;
    $scope.customerName;
    $scope.customerPhone;
    $scope.customerEmail;
    // triggered when click on time
    $(document).on('click', '#bookingEngineContent table.table>tbody>tr .singleTime', function () {
        $scope.addingProcessing = true;
        var tripTimeStr = $(this).attr("time");
        var addingActive = ($(this).hasClass("addingActive") ? true : false);
        showAddingBox($scope.selectedPackageID, tripTimeStr, addingActive, $scope.selectedDate);
        $scope.addingProcessing = false;
        $scope.$digest();
    });
    $scope.toggleAddingBox = function () {
        // calcuatel max height for popup
//        var maxHeight = $(window).outerHeight(true) - 50;
//        $("#offlineBookingBox .popupContent .popup-scroll").css("max-height", maxHeight);
        $scope.informationStep = true;
        $("#offlineBookingBox").toggleClass("active");
    };
    var ENGINE_INSERTING_URL = service.getContextPath() + "/Provider/BookingEngine/Insert";
    function validateBookingInsertBox(packageID, tripTime, customerName, customerPhone, numberOfPackages, selectedPackageDurationType) {
        var hasError = true;
        // check no Package is number and > 0
        var noPkg = parseInt(numberOfPackages);
        if (isNaN(noPkg) || noPkg <= 0) {
            $("#noPackagesInput").addClass("hasError");
            hasError = false;
        } else {
            $("#noPackagesInput").removeClass("hasError");
        }

        // check package is selected already
        if (packageID <= 0) {
            $("#packageIDInput select").addClass("hasError");
            hasError = false;
        } else {
            $("#packageIDInput select").removeClass("hasError");
        }

        if (!angular.isString(customerName) || customerName === "") {
            $("#packageNameInput").addClass("hasError");
            hasError = false;
        } else {
            $("#packageNameInput").removeClass("hasError");
        }

        if (!angular.isString(customerPhone) || customerPhone === "") {
            $("#packagePhoneInput").addClass("hasError");
            hasError = false;
        } else {
            $("#packagePhoneInput").removeClass("hasError");
        }

        if (selectedPackageDurationType !== "days") {
            if (!angular.isString(tripTime) || tripTime === "") {
                $("#timeInput select").addClass("hasError");
                hasError = false;
            } else {
                $("#timeInput select").removeClass("hasError");
            }
        } else {
            $("#timeInput select").removeClass("hasError");
        }
        return hasError;
    }

    $scope.addEngineBooking = function () {
        $scope.addingProcessing = true;
        // if duration type is day then no time
        var packageID, selectedPackageDurationType, tripTime, resourceID, minimumR;
        packageID = $scope.addingPackageID;
        if (validateBookingInsertBox(packageID, $scope.tripTime, $scope.customerName, $scope.customerPhone, $scope.noChosenPackages, selectedPackageDurationType)) {
            var package = offlinePackagesHashmap[packageID];
            selectedPackageDurationType = package.durationType;
            resourceID = package.resourceID;
            minimumR = package.minimumNoResources;
            // validate before add
            var noPackages = $scope.noChosenPackages;
            var tripDate = $scope.selectedDate.MMddyyyy();
            var totalR = noPackages * minimumR;
            var currentR;
            if (selectedPackageDurationType === "days") {
                // if duration days, we have to get minimum R to check
                currentR = dateDetails[Object.keys(dateDetails)[0]][resourceID].noPeople;
                angular.forEach(dateDetails, function (resources, time) {
                    var resourcePeople = resources[resourceID].noPeople;
                    if (resourcePeople < currentR) {
                        currentR = resourcePeople;
                    }
                });
                tripTime = null;
            } else {
                // if not days, get at tripTime to check
                tripTime = $scope.tripTime;
//            currentR = $scope.listRemainingResources[tripTime][resourceID].noPeople;
                var listR = calculateResourcesLeft(tripTime, dateDetails);
                currentR = listR[resourceID].noPeople;
                if (!angular.isNumber(currentR)) { // if not in list remain get from original R
                    currentR = resources[resourceID].noPeople;
                }
            }

            if (currentR >= totalR) {
                // construct data to add
                // data json

                var data = {"bookingDate": (new Date()).MMddyyyy(), "tripDate": tripDate, "tripTime": tripTime, "resourceNote": $scope.resourceNote,
                    "noPackages": noPackages, "packageID": packageID, "customerName": $scope.customerName, "customerPhone": $scope.customerPhone
                    , "customerEmail": $scope.customerEmail};
                $http.post(ENGINE_INSERTING_URL, data)
                        .then(function successCallback(response) {
                            if (response.data.result === "error") {
                                var pageError = service.getContextPath() + service.getErrorPageUrl();
                                $(location).attr('href', pageError);
                            } else {
                                // get data
                                $scope.dataJson = response.data;
                                // calculate again
                                constructOnlineHashmap();
                                constructOfflineHashmap();
                                combineBookings();
                                calculateResourcesLeftForSpecificDate($scope.selectedDate);
                                $scope.viewChange();
                                $scope.addingProcessing = false;
                                $(".certificateBox#addingBookingBox").toggleClass("active");
                                $scope.customerName = "";
                                $scope.customerPhone = "";
                                $scope.customerEmail = "";
                                $scope.resourceNote = "";
                            }
                        });
            } else {
                alert("Resources " + resources[resourceID].name + " is not enough!");
                $scope.addingProcessing = false;
            }
        } else {
            $scope.addingProcessing = false;
        }
    };
    // get list times for this package
    function updateListAvailableTimesWithOnline(packageID, date) {
        var listOfAvailableTimes = [];
        if (packageID !== 0) {
            var package = onlinePackagesHashmap[packageID];
            var durationType = package.durationType;
            if (durationType !== "days") { // if duration type not days then get list times
                var duration = package.duration;
                if (durationType === "hours") {
                    duration *= 60;
                }

                // show dropdown list of available times
                var isFree = package.isFreeBooking;
                var interval;
                if (isFree) {
                    interval = package.freeInterval;
                } else {
                    interval = package.fixedHour * 60 + package.fixedMinute;
                }
                var startTime = new Date(date.MMddyyyy() + " " + package.startOperationTime);
                var endTime = new Date(date.MMddyyyy() + " " + package.endOperationTime);
                endTime.setMinutes(endTime.getMinutes() - duration);
                // add available time to list time
                do {
                    listOfAvailableTimes.push(startTime.formatHHmm());
                    startTime.setMinutes(startTime.getMinutes() + interval);
                } while (startTime <= endTime);
            }
        } else {
            var startTime = new Date(date.MMddyyyy() + " " + "00:00:00");
            var endTime = new Date(date.MMddyyyy());
            endTime.setHours(END_HOUR);
            endTime.setMinutes(60 - FREE_INTERVAL);
            endTime.setSeconds(END_MINUTES);
            // add available time to list time
            do {
                listOfAvailableTimes.push(startTime.formatHHmm());
                startTime.setMinutes(startTime.getMinutes() + FREE_INTERVAL);
            } while (startTime <= endTime);
        }
        return listOfAvailableTimes;
    }

    function updateTimeAvailableWithOffline(packageID, date) {
        var listOfAvailableTimes = [];
        var startTime = new Date(date.MMddyyyy() + " " + "00:00:00");
        var endTime = new Date(date.MMddyyyy());
        if (packageID !== 0) {
            var package = offlinePackagesHashmap[packageID];
            var durationType = package.durationType;
            if (durationType !== "days") { // if 
                endTime.setHours(END_HOUR);
                endTime.setMinutes(END_MINUTES);
                endTime.setSeconds(END_MINUTES);
            }
        } else {
            endTime.setHours(END_HOUR);
            endTime.setMinutes(END_MINUTES);
            endTime.setSeconds(END_MINUTES);
        }
//        endTime.setMinutes(endTime.getMinutes() - duration);
//        endTime.setMinutes(endTime.getMinutes() - duration);

        // add available time to list time
        while (startTime < endTime) {
            listOfAvailableTimes.push(startTime.formatHHmm());
            startTime.setMinutes(startTime.getMinutes() + FREE_INTERVAL);
        }
        return listOfAvailableTimes;
    }

    $scope.addingPackageID;
    $scope.listOfAvailableTimes;
    $scope.availablePackages;
    $scope.noChosenPackages;
    $scope.resourceNote;
    $scope.addingPackageName;
    $scope.tripTime;
    $scope.isParticularPackage;
    $scope.offlineDurationType;
    $scope.offlineDays;
    $scope.offlineHours = 0;
    $scope.offlineMinutes = 0;
    $scope.informationStep = true;
    var DATE_REGEX = /^\d{2}\/\d{2}\/\d{4}$/;
    var TIME_REGEX = /^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$/;
    $scope.addingBookingErrorMsgs = {"durationType": false, "hours": false, "minutes": false, "days": false,
        "customerName": false, "customerPhone": false, "packageDate": false, "packageTime": false};
    $scope.nextToTrippSource = function () {
        $scope.addingBookingErrorMsgs = {"durationType": false, "hours": false, "minutes": false, "days": false,
            "customerName": false, "customerPhone": false, "packageDate": false, "packageTime": false};
        // validate current step first
        $scope.packageDate = $("#package-date-input").val();
        var packageDate = new Date($scope.packageDate);
        var isCorrectForm = true;
        // check durtionType
        if (($scope.offlineDurationType !== "days" && $scope.offlineDurationType !== "hours")) {
            $scope.addingBookingErrorMsgs["durationType"] = true;
            isCorrectForm = false;
        }

        // check tripDate
        if (isNaN(packageDate.getTime())) {
            $scope.addingBookingErrorMsgs["packageDate"] = true;
            isCorrectForm = false;
        }

        // check days
        if ($scope.offlineDurationType === "days") {
            var days = parseInt($scope.offlineDays);
            if (isNaN(days)) {
                $scope.addingBookingErrorMsgs["days"] = true;
                isCorrectForm = false;
            } else if (days <= 0) {
                $scope.addingBookingErrorMsgs["days"] = true;
                isCorrectForm = false;
            }

            var tripTime = new Date($scope.packageDate + " 00:00:00");
            if (tripTime < timeNow) {
                $scope.addingBookingErrorMsgs["packageDate"] = true;
                isCorrectForm = false;
            }
        }

        // check hours and minutes
        if ($scope.offlineDurationType === "hours") {
            if ($scope.offlineHours <= 0 && $scope.offlineMinutes <= 0) {
                $scope.addingBookingErrorMsgs["hours"] = true;
                $scope.addingBookingErrorMsgs["minutes"] = true;
                isCorrectForm = false;
            }


            var tripTime = new Date($scope.packageDate + " " + $scope.packageTime + ":00");
            if (isNaN(tripTime.getTime())) {
                $scope.addingBookingErrorMsgs["packageTime"] = true;
                isCorrectForm = false;
            } else if (tripTime < timeNow) {
                $scope.addingBookingErrorMsgs["packageTime"] = true;
                isCorrectForm = false;
            }

        }

        // check customer name
        if ($scope.customerName === "") {
            $scope.addingBookingErrorMsgs["customerName"] = true;
            isCorrectForm = false;
        }

        // check customer name
        if ($scope.customerPhone === "") {
            $scope.addingBookingErrorMsgs["customerPhone"] = true;
            isCorrectForm = false;
        }

        if (isCorrectForm) {
            $scope.informationStep = false;
        }
    };
    $scope.backToInformation = function () {
        $scope.informationStep = true;
    };
    function addingBoxChange(isParticularPackage, tripTimeStr, packageID, date) {
        $scope.availablePackages = [];
        // get list available times
        $scope.listOfAvailableTimes = updateTimeAvailableWithOffline(packageID, date);
        // get available packages
        if (packageID > 0) {
            // check each online package
            var offlinePackages = $scope.dataJson.data.offlinePackages;
            var length = offlinePackages.length;
            for (var i = 0; i < length; i++) {
                var package = offlinePackages[i];
                var durationType = package.durationType;
                // time only for package has duration type is hour and minute
                if (durationType !== 'days') {
                    // check this trip is in range or not
                    var startTime = new Date(date.MMddyyyy());
                    startTime.setHours(START_HOURS);
                    startTime.setMinutes(START_MINUES);
                    startTime.setSeconds(START_MINUES);
                    var endTime = new Date(date.MMddyyyy());
                    endTime.setHours(END_HOUR);
                    endTime.setMinutes(END_MINUTES);
                    endTime.setSeconds(END_MINUTES);
                    var tripStartTime = new Date(date.MMddyyyy() + " " + tripTimeStr);
                    var tripEndTime = new Date(tripStartTime);
                    var duration = package.duration;
                    durationType === "hours" ? duration *= 60 : 0;
                    tripEndTime.setMinutes(tripEndTime.getMinutes() + duration);
                    var interval = FREE_INTERVAL;
                    if (tripStartTime >= startTime && tripEndTime <= endTime) {
                        // check package interval is fit to this time
                        var difference = tripStartTime.getTime() - startTime.getTime(); // This will give difference in milliseconds
                        var minutes = Math.round(difference / 60000);
                        if (minutes % interval === 0) {
                            var availablePackage = {"id": package.packageID, "packageName": package.packageName,
                                "resourceID": package.resourceID, "minimumResources": package.minimumResources};
                            $scope.availablePackages.push(availablePackage);
                        }
                    }
                } else {
                    // check this trip is in range or not
                    var availablePackage = {"id": package.packageID, "packageName": package.packageName,
                        "resourceID": package.resourceID, "minimumResources": package.minimumResources};
                    $scope.availablePackages.push(availablePackage);
                }
            }
        } else {
            // get all offline packages
            var offlinePackages = $scope.dataJson.data.offlinePackages;
            var length = offlinePackages.length;
            for (var i = 0; i < length; i++) {
                var package = offlinePackages[i];
                var availablePackage = {"id": package.packageID, "packageName": package.packageName,
                    "resourceID": package.resourceID, "minimumResources": package.minimumResources};
                $scope.availablePackages.push(availablePackage);
            }
        }
    }

    $scope.durationTypeChanged = function () {
        $scope.offlineDays = null;
        $scope.offlineHours = 0;
        $scope.offlineMinutes = 0;
    };
    $(".dateMaskInput").inputmask("mm/dd/yyyy", {
        onKeyValidation: function (key, result) {
            angular.element($(this)).triggerHandler('input');
        }
    });
//    $(".timeMaskInput").inputmask('Regex', {
//        regex: "^[0-9]{2}:[0-5][0-9]:[0-5][0-9]$"
//    });

    $scope.packageTime = "__:__";
    var timeInput = document.getElementById("package-time-input");
    $scope.checkTimeRegex = function (event) {
        var keyCode = event.keyCode;
        var ceretPosition = $("#package-time-input").caret();
        if (ceretPosition <= 5) {
            if (keyCode < 37 || keyCode > 40) { // not arrow
                var oldString = $("#package-time-input").val();
                if (keyCode !== 8) { // not backspace
                    // first index only 0 1 2
                    var isCorrect = false;
                    if (ceretPosition === 2) {
                        ceretPosition++;
                    }
                    if (ceretPosition === 0) {
                        var secondChar = oldString.substr(1, 1);
                        var numberSecond = parseInt(secondChar);
                        if (isNaN(numberSecond)) {
                            if (keyCode === 48 || keyCode === 49 || keyCode === 50) {
                                isCorrect = true;
                            }
                        } else {
                            if (numberSecond > 3) {
                                if (keyCode === 48 || keyCode === 49) {
                                    isCorrect = true;
                                }
                            } else {
                                if (keyCode === 48 || keyCode === 49 || keyCode === 50) {
                                    isCorrect = true;
                                }
                            }
                        }

                    } else if (ceretPosition === 1) {
                        // get first character
                        var firstCharacter = oldString.substr(0, 1);
                        if (firstCharacter === "2") {
                            if ((keyCode === 48 || keyCode === 49 || keyCode === 50 || keyCode === 51)) {
                                isCorrect = true;
                            }
                        } else if (keyCode >= 48 && keyCode <= 57) {
                            isCorrect = true;
                        }
                    } else if (ceretPosition === 3) { // only from 0 to 5
                        if (keyCode > 47 && keyCode < 54) {
                            isCorrect = true;
                        }
                    } else if (ceretPosition === 4) { // only 0 or 5
                        if (keyCode === 48 || keyCode === 53) {
                            isCorrect = true;
                        }
                    }

                    // then replace to the string
                    if (isCorrect) {
                        var newCharacter = String.fromCharCode(keyCode);
                        $("#package-time-input").val(oldString.substr(0, ceretPosition) + newCharacter + oldString.substr(ceretPosition + 1));
                        if (ceretPosition === 1) {
                            ceretPosition++;
                        }
                        ceretPosition++;
                        $("#package-time-input").caret(ceretPosition);
                    }
                } else {
                    var start = timeInput.selectionStart;
                    var end = timeInput.selectionEnd;
                    if (start !== end) { // selected
                        for (var i = start; i < end; i++) {
                            var replacedCharacter = "_";
                            if (i === 2) {
                                replacedCharacter = ":";
                            }
                            oldString = oldString.substr(0, i) + replacedCharacter + oldString.substr(i + 1);
                        }

                        $("#package-time-input").val(oldString);
                        $("#package-time-input").caret(start);
                    } else {
                        if (ceretPosition > 0) {
                            if (ceretPosition === 3) {
                                ceretPosition--;
                            }
                            ceretPosition--;
                            $("#package-time-input").val(oldString.substr(0, ceretPosition) + "_" + oldString.substr(ceretPosition + 1));
                            $("#package-time-input").caret(ceretPosition);
                        }
                    }
                }
                angular.element($('#package-time-input')).triggerHandler('input');
                event.preventDefault();
            }
        }
    };
    $scope.checkTimePosition = function () {
        var oldString = $("#package-time-input").val();
        var position = 0;
        for (position = 0, max = oldString.length; position < max; position++) {
            var character = oldString.substr(position, 1);
            if (character !== ":") {
                var number = parseInt(character);
                if (isNaN(number)) {
                    break;
                }
            }
        }
        $("#package-time-input").caret(position);
    };
    $scope.detectWhenResourceDurationTypeChange = function (resourceIndex) {
        var selectedResource = $scope.trippSources[resourceIndex];
        selectedResource["days"] = null;
        selectedResource["hours"] = 0;
        selectedResource["minutes"] = 0;
    };
    $scope.detectWhenCheckedResourcechange = function (resourceIndex) {
        var selectedResource = $scope.trippSources[resourceIndex];
        selectedResource["days"] = null;
        selectedResource["hours"] = 0;
        selectedResource["minutes"] = 0;
        selectedResource["durationType"] = null;
        selectedResource["noUnits"] = null;
    };
    $scope.newBookingBox = function () {
        $scope.offlineDurationType = "days";
        $scope.offlineDays = null;
        $scope.offlineHours = 0;
        $scope.offlineMinutes = 0;
        $scope.trippSources = [];
        $scope.packageDate = $scope.selectedDate.MMddyyyy();
        $scope.packageTime = "__:__";
        $scope.customerName = "";
        $scope.customerPhone = "";
        $scope.addingBookingErrorMsgs = {"durationType": false, "hours": false, "minutes": false, "days": false,
            "customerName": false, "customerPhone": false, "packageDate": false, "packageTime": false};
        // construct new list of resources
        angular.forEach(resources, function (resource, resourceID) {
            var newTripSource = {"id": resourceID, "name": resource.name,
                "durationType": "", "hours": 0, "minutes": 0, "selected": false};
            $scope.trippSources.push(newTripSource);
        });
        $scope.toggleAddingBox();
    };
    function showAddingBox(selectedPackageID, tripTimeStr, addingActive, date) {
        $scope.offlineDurationType = null;
        $scope.offlineDays = null;
        $scope.offlineHours = 0;
        $scope.offlineMinutes = 0;
        $scope.trippSources = [];
        $scope.packageDate = date.MMddyyyy();
        $scope.packageTime = tripTimeStr;
        $scope.customerName = "";
        $scope.customerPhone = "";
        $scope.addingBookingErrorMsgs = {"durationType": false, "hours": false, "minutes": false, "days": false,
            "customerName": false, "customerPhone": false, "packageDate": false, "packageTime": false};
        // construct new list of resources
        angular.forEach(resources, function (resource, resourceID) {
            var newTripSource = {"id": resourceID, "name": resource.name,
                "durationType": "", "hours": 0, "minutes": 0, "selected": false};
            $scope.trippSources.push(newTripSource);
        });
        $scope.toggleAddingBox();
//        if (addingActive) {
//            if (!$(".certificateBox#addingBookingBox").hasClass("active")) {
//                $scope.toggleAddingBox();
//                $scope.isParticularPackage = false;
//                // initiate default adding box
//                if (selectedPackageID < 0) {
//                    selectedPackageID = -selectedPackageID;
//                    $scope.isParticularPackage = true;
//                    $scope.addingPackageName = offlinePackagesHashmap[selectedPackageID].packageName;
//                } else {
//                    selectedPackageID = 0;
//                    $scope.addingPackageName = "";
//                }
//
//                // not affected by selectedPackageID
//                $scope.addingPackageID = selectedPackageID;
//                $scope.noChosenPackages = null;
//                $scope.resourceNote = null;
//
//                addingBoxChange($scope.isParticularPackage, tripTimeStr, selectedPackageID, date);
//                if ($scope.listOfAvailableTimes.length > 0) {
//                    $scope.tripTime = tripTimeStr;
//                }
//            }
//        }
    }

    var OFFLINE_INSERTING_URL = service.getContextPath() + "/Provider/BookingEngine/OfflineInserting";
    var MINIMUM_MINUTES = 5;
    $scope.addOfflineBooking = function () {
        $scope.savingProcess = true;
        var resourceCorrect = true;
        var resources = [];
        var max = $scope.trippSources.length;
        for (var i = 0; i < max && resourceCorrect; i++) {
            var tripSource = $scope.trippSources[i];
            if (tripSource.selected) {
                if (tripSource.noUnits > 0) {
                    resources.push(tripSource);
                    // loop time to check resource
                    var startTime, endTime;
                    if ($scope.offlineDays > 0) {
                        startTime = new Date($scope.packageDate + " 00:00:00");
                        endTime = new Date(startTime);
                        endTime.setDate(endTime.getDate() + $scope.offlineDays);
                    } else {
                        startTime = new Date($scope.packageDate + " " + $scope.packageTime + ":00");
                        var duration = $scope.offlineHours * 60 + $scope.offlineMinutes;
                        endTime = new Date(startTime);
                        endTime.setMinutes(endTime.getMinutes() + duration);
                    }

                    // get min resource to check
                    var noUnits = tripSource.noUnits;
                    var eachTime = new Date(startTime);
                    while (eachTime < endTime) {
                        var tripSourceID = tripSource.id;
                        var tripDate = eachTime.MMddyyyy();
                        var tripTime = eachTime.formatHHmm();
                        var resourceLeft;
                        var dates = remainingResources[tripSourceID];
                        if (angular.isObject(dates)) {
                            var times = dates[tripDate];
                            if (angular.isObject(times)) {
                                resourceLeft = dates[tripTime];
                            }
                        }

                        if (!angular.isNumber(resourceLeft)) {
                            resourceLeft = resources[tripSourceID];
                        }

                        if (noUnits > resourceLeft) {
                            tripSource["unitsError"] = true;
                            resourceCorrect = false;
                            break;
                        }
                        eachTime.setMinutes(eachTime.getMinutes() + MINIMUM_MINUTES);
                    }
                } else {
                    // get error
                    if (tripSource["noUnits"] <= 0) {
                        tripSource["unitsError"] = true;
                    } else {
                        tripSource["unitsError"] = false;
                    }

                    resourceCorrect = false;
                }
            }
        }

        if (resourceCorrect) {
            var data = {"hours": $scope.offlineHours, "minutes": $scope.offlineMinutes, "days": $scope.offlineDays,
                "dateStr": $scope.packageDate, "timeStr": $scope.packageTime,
                "customerName": $scope.customerName, "customerPhone": $scope.customerPhone,
                "email": $scope.customerEmail, "resources": resources};
            $http.post(OFFLINE_INSERTING_URL, data)
                    .then(function successCallback(response) {
                        if (response.data.result === "error") {
                            var pageError = service.getContextPath() + service.getErrorPageUrl();
                            $(location).attr('href', pageError);
                        } else {
//                            // get data
//                            $scope.dataJson = response.data;
//                            // calculate again
//                            constructOnlineHashmap();
//                            constructOfflineHashmap();
//                            combineBookings();
//                            constructResourceLeftHashMap();
//                            calculateResourcesLeftForSpecificDate($scope.selectedDate);
//                            $scope.viewChange();
                            $scope.savingProcess = false;
                            $scope.toggleAddingBox();
                        }
                    });
        } else {
            $scope.savingProcess = false;
        }
    };
    $scope.detectAddingChange = function () {
        $scope.addingProcessing = true;
        addingBoxChange($scope.chosenPackageType, $scope.tripTime, $scope.addingPackageID, $scope.selectedDate);
        $scope.addingProcessing = false;
    };
    $scope.packageTypeChange = function () {
        $scope.addingProcessing = true;
        $scope.addingPackageID = 0;
        addingBoxChange($scope.chosenPackageType, $scope.tripTime, $scope.addingPackageID, $scope.selectedDate);
        $scope.addingProcessing = false;
    };
    /* NEW OFFLINE PACKAGE */
    $scope.newPackageName;
    $scope.newPackageResource = 0;
    $scope.newPackageMinimumResource;
    $scope.newPackageDurationType;
    $scope.newPackageDuration;
    $scope.newPackageProcessing = false;
    $scope.toggleNewOfflineBox = function () {
        $("#newOfflineBox").toggleClass("active");
    };
    var NEW_OFFLINE_URL = service.getContextPath() + "/Provider/BookingEngine/OfflinePackage/Insert";
    function validateNewPackageBox(newPackageName, newPackageMinimumResource, newPackageResource, newPackageDurationType, newPackageDuration) {
        var hasError = true;
        if (!angular.isString(newPackageName) || newPackageName === "") {
            $("#newPkgNameInput").addClass("hasError");
            hasError = false;
        } else {
            $("#newPkgNameInput").removeClass("hasError");
        }

        if (newPackageResource <= 0) {
            $("#newReIDInput").addClass("hasError");
            hasError = false;
        } else {
            $("#newReIDInput").removeClass("hasError");
        }


        var newPkgMinRes = parseInt(newPackageMinimumResource);
        if (isNaN(newPkgMinRes) || newPkgMinRes <= 0) {
            $("#noMinReInput").addClass("hasError");
            hasError = false;
        } else {
            $("#noMinReInput").removeClass("hasError");
        }

        if (newPackageDurationType !== "minutes" && newPackageDurationType !== "days" && newPackageDurationType !== "hours") {
            $("#newPackageDuTypeInput").addClass("hasError");
            hasError = false;
        } else {
            $("#newPackageDuTypeInput").removeClass("hasError");
        }

        var newPkgDuraion = parseInt(newPackageDuration);
        if (isNaN(newPkgDuraion) || newPkgDuraion <= 0) {
            $("#newDurationInput").addClass("hasError");
            hasError = false;
        } else {
            $("#newDurationInput").removeClass("hasError");
        }
        return hasError;
    }

    $scope.addNewOfflinePackage = function () {
        $scope.newPackageProcessing = true;
        if (validateNewPackageBox($scope.newPackageName, $scope.newPackageMinimumResource,
                $scope.newPackageResource, $scope.newPackageDurationType, $scope.newPackageDuration)) {
            var data = {"packageName": $scope.newPackageName, "newPackageResource": $scope.newPackageResource,
                "newPackageMinimumResource": $scope.newPackageMinimumResource, "newPackageDurationType": $scope.newPackageDurationType,
                "newPackageDuration": $scope.newPackageDuration};
            $http.post(NEW_OFFLINE_URL, data)
                    .then(function successCallback(response) {
                        if (response.data.result === "error") {
                            var pageError = service.getContextPath() + service.getErrorPageUrl();
                            $(location).attr('href', pageError);
                        } else {
                            // get data of list offlines
                            $scope.dataJson.data.offlinePackages = response.data;
                            // calculate again
                            constructOfflineHashmap();
                            $scope.newPackageProcessing = false;
                            $(".certificateBox#newOfflineBox").toggleClass("active");
                        }
                    });
        } else {
            $scope.newPackageProcessing = false;
        }
    };
    /* SOCKET */
    // connect to socket for live update
    var stompClient = null;
    var socketUrl = service.getContextPath() + "/hello";
    var subcriber = "/topic/bookingEngine/" + providerID;
    var loadBookingUrl = service.getContextPath() + "/Provider/BookingEngine";
    function connectToSocket() {
        var socket = new SockJS(socketUrl);
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            stompClient.subscribe(subcriber, function (data) {
                console.log("vao roi");
                // new changes
                var result = JSON.parse(data.body).result;
                if (result === "error") {
                    var pageError = service.getContextPath() + service.getErrorPageUrl();
                    $(location).attr('href', pageError);
                } else {
                    // if changes load new daata
                    $scope.loading = true;
                    $http.post(loadBookingUrl, data)
                            .then(function successCallback(response) {
                                if (response.data.result === "error") {
                                    var pageError = service.getContextPath() + service.getErrorPageUrl();
                                    $(location).attr('href', pageError);
                                } else {
                                    // get new data and initate again
                                    $scope.dataJson = response.data;
                                    // calculate again
                                    constructOnlineHashmap();
                                    constructOfflineHashmap();
                                    combineBookings();
                                    constructResourceLeftHashMap();
                                    calculateResourcesLeftForSpecificDate($scope.selectedDate);
                                    $scope.viewChange();
                                    $scope.loading = false;
                                }
                            });
                }
            });
        });
    }
    connectToSocket();
    /* INITATE BEGINING VIEW */
    $scope.selectedDate = new Date(timeNowVar);
    $scope.selectedDate.setHours(START_HOURS);
    $scope.selectedDate.setMinutes(START_MINUES);
    $scope.selectedDate.setSeconds(START_MINUES);
    $scope.viewType = "day";
    $scope.selectedPackageID = 0;
    initiateCalendar($scope.selectedDate);
    $scope.viewChange();
    /*Merge Sale Tab to Booking Engine*/

    $scope.packages = packages;
    $scope.sales = sales;
    $scope.currentPackage = 0;
    $scope.viewSaleFlag = 'View Sale';
    $scope.viewSaleFunc = function () {
        if ($scope.viewSale === false) {
            $scope.viewSale = true;
            $('#bookingEngineCtrs').addClass('hidden');
            $('#tablePadding').addClass('hidden');
            $('.calendar-ctrs').addClass('hidden');
            $('#datepicker').addClass('hidden');
            $scope.viewSaleFlag = "View Booking Engine";
        } else {
            $scope.viewSale = false;
            $('#bookingEngineCtrs').removeClass('hidden');
            $('#tablePadding').removeClass('hidden');
            $('.calendar-ctrs').removeClass('hidden');
            $('#datepicker').removeClass('hidden');
            $scope.viewSaleFlag = "View Sale";
        }


    };
    $scope.initCalendarForSale = function () {
        $("#from").datepicker();
        $("#to").datepicker();
        var d = new Date();
        var n = d.getMonth() + 1;
        if (n < 10) {
            n = '0' + n;
        }


        var numOfDays = new Date((d.getYear() + 1900), n, 0).getDate();
        var startDate1 = n + "/01/" + (d.getYear() + 1900);
        var endDate1 = n + "/" + numOfDays + "/" + (d.getYear() + 1900);
        $('#from').val(startDate1);
        $('#to').val(endDate1);
    };
    $scope.loading = false;
});
myApp.controller('QuickComparisonController', function ($scope, $http) {
    $scope.allResult = comparisonList;
    $scope.comparisonList = $scope.allResult.comparisonList;
    $scope.topRatedList = [];
    $scope.mostPopularList = [];
    $scope.cheapestList = [];
    angular.forEach($scope.comparisonList, function (child) {
        $scope.topRatedList.push(child);
        $scope.mostPopularList.push(child);
        $scope.cheapestList.push(child);
    });
    $scope.currentPackageID = packageID;
    $scope.loading = true;
    $scope.noresult = false;
    if ($scope.comparisonList.length > 1) {
        $scope.noresult = true;
    }
    $scope.nextTopRated = function () {
        if (!$('.arrow-down-compare.top-rated').hasClass('disabled-next-comparison')) {
            $('.current-top-rated').removeClass('current-top-rated').next().addClass('current-top-rated');
            if ($('.current-top-rated').hasClass('last-top-rated')) {
                $('.arrow-down-compare.top-rated').addClass('disabled-next-comparison');
            }
            $('.arrow-up-compare.top-rated').removeClass('disabled-prev-comparison');
        }
    };
    $scope.prevTopRated = function () {
        if (!$('.arrow-up-compare.top-rated').hasClass('disabled-prev-comparison')) {
            $('.current-top-rated').removeClass('current-top-rated').prev().addClass('current-top-rated');
            if ($('.current-top-rated').hasClass('first')) {
                $('.arrow-up-compare.top-rated').addClass('disabled-prev-comparison');
            }
            $('.arrow-down-compare.top-rated').removeClass('disabled-next-comparison');
        }
    };
    $scope.nextMostPopular = function () {
        if (!$('.arrow-down-compare.most-popular').hasClass('disabled-next-comparison')) {
            $('.current-most-popular').removeClass('current-most-popular').next().addClass('current-most-popular');
            if ($('.current-most-popular').hasClass('last-most-popular')) {
                $('.arrow-down-compare.most-popular').addClass('disabled-next-comparison');
            }
            $('.arrow-up-compare.most-popular').removeClass('disabled-prev-comparison');
        }
    };
    $scope.prevMostPopular = function () {
        if (!$('.arrow-up-compare.most-popular').hasClass('disabled-prev-comparison')) {
            $('.current-most-popular').removeClass('current-most-popular').prev().addClass('current-most-popular');
            if ($('.current-most-popular').hasClass('first')) {
                $('.arrow-up-compare.most-popular').addClass('disabled-prev-comparison');
            }
            $('.arrow-down-compare.most-popular').removeClass('disabled-next-comparison');
        }
    };
    $scope.nextCheapest = function () {
        if (!$('.arrow-down-compare.cheapest').hasClass('disabled-next-comparison')) {
            $('.current-cheapest').removeClass('current-cheapest').next().addClass('current-cheapest');
            if ($('.current-cheapest').hasClass('last-cheapest')) {
                $('.arrow-down-compare.cheapest').addClass('disabled-next-comparison');
            }
            $('.arrow-up-compare.cheapest').removeClass('disabled-prev-comparison');
        }
    };
    $scope.prevCheapest = function () {
        if (!$('.arrow-up-compare.cheapest').hasClass('disabled-prev-comparison')) {
            $('.current-cheapest').removeClass('current-cheapest').prev().addClass('current-cheapest');
            if ($('.current-cheapest').hasClass('first')) {
                $('.arrow-up-compare.cheapest').addClass('disabled-prev-comparison');
            }
            $('.arrow-down-compare.cheapest').removeClass('disabled-next-comparison');
        }
    };
    $scope.closeTopRated = function () {
        var position = $('.current-top-rated').attr('elementPosition');
        if (($scope.topRatedList.length - 1) === Number(position)) {
            $scope.prevTopRated();
        }
        ;
        $scope.topRatedList.splice(position, 1);
    };
    $scope.closeMostPopular = function () {
        var position = $('.current-most-popular').attr('elementPosition');
        if (($scope.mostPopularList.length - 1) === Number(position)) {
            $scope.prevMostPopular();
        }
        ;
        $scope.mostPopularList.splice(position, 1);
    };
    $scope.closeCheapest = function () {
        var position = $('.current-cheapest').attr('elementPosition');
        if (($scope.cheapestList.length - 1) === Number(position)) {
            $scope.prevCheapest();
        }
        ;
        $scope.cheapestList.splice(position, 1);
    };
    $scope.$watch('comparisonList', function (newVal, oldVal) {
        $scope.topRatedList = [];
        $scope.mostPopularList = [];
        $scope.cheapestList = [];
        angular.forEach($scope.comparisonList, function (child) {
            $scope.topRatedList.push(child);
            $scope.mostPopularList.push(child);
            $scope.cheapestList.push(child);
        });
    });
    $scope.checkLocation = false;
    $scope.selectSameLocation = function () {
        if ($scope.checkLocation) {
            $scope.checkLocation = false;
            $scope.comparisonList = $scope.allResult.comparisonList;
            for (var i = 0; i < $scope.allResult.comparisonListSameLocation.length; i++) {
                $scope.prevCheapest();
                $scope.prevMostPopular();
                $scope.prevTopRated();
            }
        } else {
            $scope.checkLocation = true;
            $scope.comparisonList = $scope.allResult.comparisonListSameLocation;
            for (var i = 0; i < $scope.allResult.comparisonList.length; i++) {
                $scope.prevCheapest();
                $scope.prevMostPopular();
                $scope.prevTopRated();
            }
        }
        $scope.$digest();
    };
    $scope.loading = false;
});
myApp.controller('PackageRegistrationController', function ($scope, $http, $timeout, service, $interval) {
    $scope.loaded = false;
    /* COMMON */
    $scope.wizards = {"category": false, "description": false, "photos": false, "price": false, "booking": false};
    $scope.selectedWizard = "category";
    $scope.allStepDones = false;
    $scope.contentStep = ["Let's start, only 5 steps to go!", "One down, 4 steps to go!", "Yor are doing great, 3 steps to go!",
        "Nearly there, just 2 steps to go!", "One last step and you are ready for the world!", "All done!"];
    $scope.noSuccessStep = 0;
//    $scope.showCountryTarget = function () {
//        $(".CountryTarget").toggleClass("active");
//    };
//    
//    $scope.chooseTargetCountry = function (name, ID) {
//        $(".CountryTarget").removeClass("active");
//        var getValue = document.getElementsByClassName("businessTypeSelect")[0];
//        getValue.innerHTML = name;
//        $scope.package.targetCountryID = ID;
//    };

    $scope.package = temporaryPackage;
    $scope.packageForm = packageForm;

    //init data for booking 
    if ($scope.package.readyBookingDurationType === "mins") {
        if ($scope.package.readyBookingDuration >= 60) {
            $scope.package.readyBookingDurationHour = Math.floor($scope.package.readyBookingDuration / 60);
            if (!($scope.package.readyBookingDurationHour > 0)) {
                $scope.package.readyBookingDurationHour = 0;
            }
            $scope.package.readyBookingDurationMinutes = $scope.package.readyBookingDuration - $scope.package.readyBookingDurationHour * 60;
        } else {
            $scope.package.readyBookingDurationMinutes = $scope.package.readyBookingDuration;
            $scope.package.readyBookingDurationHour = 0;
        }
    } else {
        $scope.package.readyBookingDurationHour = 0;
        $scope.package.readyBookingDurationMinutes = 0;
    }

    // when click in the sections menu
    $scope.setSelectedWizard = function (wizard) {
        // check selected wizard is done yet, if not do not move
//        if ($scope.wizards[wizard]) {
        // else call save
        saveWizard($scope.selectedWizard, wizard, "set");
//        }
    };
    // when click button next to save
    $scope.moveNextWizard = function () {
        // get next Step
        var nextStep, nextStepIndex;
        var keys = Object.keys($scope.wizards);
        for (var i = 0, max = keys.length; i < max; i++) {
            var wizard = keys[i];
            if (wizard === $scope.selectedWizard) {
                if (i === (max - 1)) {
                    nextStepIndex = 0;
                } else {
                    nextStepIndex = (i + 1);
                }
            }
        }
        nextStep = keys[nextStepIndex];
        // call save funciton to validate and save
        saveWizard($scope.selectedWizard, nextStep, "next");
    };
    // click finish after all sections done
    $scope.finishToPreview = function () {
        saveWizard($scope.selectedWizard, null, "finish");
    };
    // function to check array of sections done yet
    function checkAllStepDoneYet() {
        $scope.noSuccessStep = 0;
        var done = true;
        angular.forEach($scope.wizards, function (isDone, wizardName) {
            if (!isDone) {
                done = false;
            } else {
                $scope.noSuccessStep++;
            }
        });
        return done;
    }

    var CATEGORY_URL = service.getContextPath() + "/Provider/Package/saveActivities";
    var DESCRIPTION_URL = service.getContextPath() + "/Provider/Package/saveDescription";
    var PHOTOS_URL = service.getContextPath() + "/Provider/Package/savePhotos";
    var BOOKING_URL = service.getContextPath() + "/Provider/Package/saveBookingRegistration";
    var PRICE_URL = service.getContextPath() + "/Provider/Package/saveOrdinaryPrice";
//    var FINISH_PAGE = service.getContextPath() + "/Provider/Package/PreView/" + $scope.package.id;
    var FINISH_PAGE = service.getContextPath() + "/Provider/Package/Apply/" + $scope.package.id;
    var ERROR_PAGE = service.getContextPath() + service.getErrorPageUrl();
    $scope.saving = false;
    // check and save wizard, return true or false
    function saveWizard(currentWizard, moveStep, saveType) {
        $scope.saving = true;
        // validate input
        var validateFlag = false;
        var url = "", data = {};
        if (currentWizard === "category") {
//            validateFlag = validateCategoryInput();
            validateFlag = true; // Allow save information with missing detail
            url = CATEGORY_URL;
            validateFlag ? data = getCategoryData() : 0;
        } else if (currentWizard === "photos") {
//            validateFlag = validatePhotosInput();
            validateFlag = true; // Allow save information with missing detail
            url = PHOTOS_URL;
            validateFlag ? data = getPhotoForm() : 0;
        } else if (currentWizard === "description") {
//            validateFlag = validateDescriptionInput();
            validateFlag = true; // Allow save information with missing detail
            url = DESCRIPTION_URL;
            validateFlag ? data = getDescriptionData() : 0;
        } else if (currentWizard === "price") {
//            validateFlag = validatePriceInput();
            validateFlag = true; // Allow save information with missing detail
            url = PRICE_URL;
            validateFlag ? data = getPriceData() : 0;
        } else if (currentWizard === "booking") {
//            validateFlag = validateBookingInput();
            validateFlag = true; // Allow save information with missing detail
            url = BOOKING_URL;
            validateFlag ? data = getBookingInput() : 0;
        }

        // if correct, ajax to save and check all sections done yet to show finish button, and move to selected step
        if (validateFlag) {
            $http.post(url, data)
                    .then(function successCallback(response) {
                        if (response.data.result === "error") {
                            $(location).attr('href', ERROR_PAGE);
                        } else {
                            if (saveType !== "finish") { // if not finish button is click
                                if ($scope.saveWithCompleteDetail === true) {
                                    $scope.wizards[$scope.selectedWizard] = true;
                                    $scope.saveWithCompleteDetail = false;
                                }

                                $scope.selectedWizard = moveStep;
                                // check all step done or not
                                $scope.allStepDones = checkAllStepDoneYet();
                                $scope.saving = false;
                                resetInitInActiveTime();
                                $('html, body').animate({
                                    scrollTop: 0
                                }, 300);
                            } else {
                                $(location).attr('href', FINISH_PAGE);
                            }
                        }
                    });
        } else {
            if (saveType === "set") {
                $scope.selectedWizard = moveStep;
            }
            // if not, false
            $scope.saving = false;
        }
    }

    var PREVIEW_PAGE = service.getContextPath() + "/Provider/PreView/" + $scope.package.id;
    $scope.goToPreviewPage = function () {
        window.open(PREVIEW_PAGE, '_blank');
    };
    /* END COMMON */

    /* CATEGORY SECTION */
    $scope.checkSuitabilty = function () {
        var result = false;
        angular.forEach($scope.package.temporarySuitabiltyClassifiers, function (suitability) {
            if (suitability.selected) {
                result = true;
            }
        });
        return result;
    };
    $scope.packageForm.targetCountry.unshift({"targetCountryID": 0, "name": "Choose a location cluster"});
    function validateCategoryInput() {
        if ($scope.selectSubCategory.id > 0 && $scope.package.colorID > 0 && $scope.checkSuitabilty() && $scope.package.targetCountryID > 0) {
            return true;
        }
        return false;
    }
    /*Get Data From Category*/
    $scope.selectSubCategory = {'id': 0, 'content': '', 'isNotListed': false};
    $scope.selectedAtivites = [];
    function getCategoryData() {
        /*Prepair content of Other Sub Category*/

        var data = {"packageID": $scope.package.id, "subCategoryID": $scope.selectSubCategory.id,
            "suitability": $scope.package.temporarySuitabiltyClassifiers,
            "subCategoryContent": $scope.selectSubCategory.content,
            "categoryID": $scope.selectSubCategory.id, "targetCountryID": $scope.package.targetCountryID, "packageColor": $scope.package.colorID, "adventureLevel": $scope.package.adventureLevel,
            "challengeLevel": $scope.package.challengeLevel, "friendshipLevel": $scope.package.friendshipLevel, "happinessLevel": $scope.package.happinessLevel,
            "healthinessLevel": $scope.package.healthinessLevel, "knowledgeLevel": $scope.package.knowledgeLevel, "peacefulnessLevel": $scope.package.peacefulnessLevel,
            "romanceLevel": $scope.package.romanceLevel, "sophisticationLevel": $scope.package.sophisticationLevel, "unexpectedLevel": $scope.package.unexpectedLevel};
        console.log(data);
        console.log($scope.selectSubCategory);
        return data;
    }
    /*Search ACtivity*/

//    for (var i = 0; i < $scope.package.temporaryClassifiers.length; i++) { // find category selected and sub selected
//        var selectdSubCategoryID = $scope.package.temporaryClassifiers[i].subCategoryID;
//        var activityName = $scope.package.temporaryClassifiers[i].activityName;
//        var activityID = $scope.package.temporaryClassifiers[i].activityID;
//        var content = $scope.package.temporaryClassifiers[i].content;
//        angular.forEach($scope.packageForm.categoryRelation, function (category, categoryID) {
//
//            angular.forEach(category.subCategories, function (subCategory, subID) {
//                if (subCategory.subCategoryID === selectdSubCategoryID) {
//                    $scope.selectSubCategory.id = Number(subCategory.subCategoryID);
//                    $scope.selectedCategoryID = Number(subCategory.categoryID);
//                    if (subCategory.name === "Not Listed") {
//
//                        $scope.selectSubCategory.id = Number(subCategory.subCategoryID);
//                        $scope.selectSubCategory.content = $scope.package.otherSubCategoryName;
//                        $scope.selectSubCategory.isNotListed = true;
//                    }
//                }
//            });
//        });
//    }
    $scope.selectSubCategory.id = Number($scope.package.subCategoryID);
    $scope.selectSubCategory.content = $scope.package.otherSubCategoryName;
    console.log($scope.package.otherSubCategoryContent);
    if ($scope.selectSubCategory.content !== '' && !angular.isUndefined($scope.selectSubCategory.content)) {
        console.log('true' + $scope.selectSubCategory.content);
        $scope.selectSubCategory.isNotListed = true;
    }
    angular.forEach($scope.packageForm.categoryRelation, function (category, categoryID) {
        angular.forEach(category.subCategories, function (subCategory, subID) {
            if (subCategory.subCategoryID === $scope.selectSubCategory.id) {

                $scope.selectedCategoryID = Number(subCategory.categoryID);
            }
        });
    });

    console.log($scope.selectSubCategory.id);
    $scope.searchActivityFlag = false;
    $scope.searchActivityResult = {"activityList": [], "subCategoryList": [], "categoryList": []};
    $scope.checkSearchActivityFocus = function () {
        $(document).on('focus', '#searchActivity', function () { // when tr is hover
            $('#search-activity-result').addClass("showResult");
        }).on('focusout', '#searchActivity', function () { // when tr is no longer hovered
            setTimeout(function () {
                $('#search-activity-result').removeClass("showResult");
            }, 400);
        });
    };

    /*Load Not listed Sub Category From Database*/
    $scope.getOtherSubCateContent = function (categoryID, subCategoryID) {
        $scope.selectedSubCategoryID = Number(subCategoryID);
        $scope.selectedCategoryID = Number(categoryID);
        angular.forEach($scope.packageForm.categoryRelation, function (category, cateID) {
            if (category.categoryID === Number($scope.package.categoryID)) {
                angular.forEach(category.subCategories, function (subCategory, subID) {
                    if (subCategory.subCategoryID === $scope.selectedSubCategoryID) {
                        subCategory.content = $scope.package.otherSubCategoryName;
                    }
                });
            }

        });
        return true;
    };
    /*Set normal value for Category and SubCategory*/
    $scope.selectNormalSubCategory = function (categoryID, subCategoryID) {
        $scope.selectedSubCategoryID = Number(subCategoryID);
        $scope.selectedCategoryID = Number(categoryID);
    };
    /*New Category Select Start*/

    $scope.selectSubCategoryActivity = function (cateID, SubCateID) {
        angular.forEach($scope.packageForm.categoryRelation, function (category, catesID) {
            if (category.categoryID === Number(cateID)) {
                angular.forEach(category.subCategories, function (subCategory, subID) {
                    if (subCategory.subCategoryID === SubCateID && subCategory.name !== "Not Listed") {
                        console.log('ss');
                        $scope.selectSubCategory.id = subCategory.subCategoryID;
                        $scope.selectSubCategory.isNotListed = false;
                    } else if (subCategory.subCategoryID === SubCateID && subCategory.name === "Not Listed") {
                        console.log('nn');
                        $scope.selectSubCategory.id = subCategory.subCategoryID;
                        $scope.selectSubCategory.isNotListed = true;
                    }
                });
            }

        });
    };

    $scope.selectNewCategory = function (id) {
        if ($scope.selectedCategoryID !== id) {
            $scope.selectedCategoryID = id;
            $scope.selectSubCategory = {'id': 0, 'content': '', 'isNotListed': false};
        }
    };

    //Load new category data of package

    /*New Category Select End*/

    /*Init color palette for package color*/
    $scope.packageColorInit = function () {
        $('#ColorValue').val($scope.package.colorID);
        $('.packageColorInput').val($scope.package.colorID);
        $('[name="PackageColorSelection"]').paletteColorPicker();
    };
    $scope.showColorPalette = function () {
        $('.PackageColorMenu').addClass('active');
    };
    /*Get Color Code by ColorID*/
    $scope.getColorCode = function (id) {
        var result = "";
        angular.forEach($scope.packageForm.packageColor, function (child) {
            if (Number(child.colorID) === Number(id)) {
                result = child.colorCode;
            }
        });
        return result;
    };
    /*Change selected package color*/
    $scope.changeSelectedColor = function (id) {
        $scope.package.colorID = id;
    };
    /*Init function for category*/
    $scope.initCategory = function () {
        //Init for slider
        $('.adventureSlider').slider({
            range: "min",
            value: 0,
            step: 25,
            slide: function (event, ui) {
                if (ui.value === 0) {
                    $scope.package.adventureLevel = 0;
                    $('.adventureSlider .ui-slider-handle').addClass("level1");
                    $('.adventureSlider .ui-slider-handle').removeClass("level2");
                    $('.adventureSlider .ui-slider-handle').removeClass("level3");
                    $('.adventureSlider .ui-slider-handle').removeClass("level4");
                    $('.adventureSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 25) {
                    $scope.package.adventureLevel = 1;
                    $('.adventureSlider .ui-slider-handle').addClass("level2");
                    $('.adventureSlider .ui-slider-handle').removeClass("level1");
                    $('.adventureSlider .ui-slider-handle').removeClass("level3");
                    $('.adventureSlider .ui-slider-handle').removeClass("level4");
                    $('.adventureSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 50) {
                    $scope.package.adventureLevel = 2;
                    $('.adventureSlider .ui-slider-handle').addClass("level3");
                    $('.adventureSlider .ui-slider-handle').removeClass("level1");
                    $('.adventureSlider .ui-slider-handle').removeClass("level2");
                    $('.adventureSlider .ui-slider-handle').removeClass("level4");
                    $('.adventureSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 75) {
                    $scope.package.adventureLevel = 3;
                    $('.adventureSlider .ui-slider-handle').addClass("level4");
                    $('.adventureSlider .ui-slider-handle').removeClass("level1");
                    $('.adventureSlider .ui-slider-handle').removeClass("level2");
                    $('.adventureSlider .ui-slider-handle').removeClass("level3");
                    $('.adventureSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 100) {
                    $scope.package.adventureLevel = 4;
                    $('.adventureSlider .ui-slider-handle').addClass("level5");
                    $('.adventureSlider .ui-slider-handle').removeClass("level1");
                    $('.adventureSlider .ui-slider-handle').removeClass("level2");
                    $('.adventureSlider .ui-slider-handle').removeClass("level3");
                    $('.adventureSlider .ui-slider-handle').removeClass("level4");
                }
            }
        });
        //Set init value for slider       
        $(".adventureSlider").slider('value', $scope.package.adventureLevel * 25);
        if ($(".adventureSlider").slider('value') === 0) {
            $('.adventureSlider .ui-slider-handle').addClass("level1");
        } else if ($(".adventureSlider").slider('value') === 25) {
            $('.adventureSlider .ui-slider-handle').addClass("level2");
        } else if ($(".adventureSlider").slider('value') === 50) {
            $('.adventureSlider .ui-slider-handle').addClass("level3");
        } else if ($(".adventureSlider").slider('value') === 75) {
            $('.adventureSlider .ui-slider-handle').addClass("level4");
        } else if ($(".adventureSlider").slider('value') === 100) {
            $('.adventureSlider .ui-slider-handle').addClass("level5");
        }


        $('.challengeSlider').slider({
            range: "min",
            value: 0,
            step: 25,
            slide: function (event, ui) {
                if (ui.value === 0) {
                    $scope.package.challengeLevel = 0;
                    $('.challengeSlider .ui-slider-handle').addClass("level1");
                    $('.challengeSlider .ui-slider-handle').removeClass("level2");
                    $('.challengeSlider .ui-slider-handle').removeClass("level3");
                    $('.challengeSlider .ui-slider-handle').removeClass("level4");
                    $('.challengeSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 25) {
                    $scope.package.challengeLevel = 1;
                    $('.challengeSlider .ui-slider-handle').addClass("level2");
                    $('.challengeSlider .ui-slider-handle').removeClass("level1");
                    $('.challengeSlider .ui-slider-handle').removeClass("level3");
                    $('.challengeSlider .ui-slider-handle').removeClass("level4");
                    $('.challengeSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 50) {
                    $scope.package.challengeLevel = 2;
                    $('.challengeSlider .ui-slider-handle').addClass("level3");
                    $('.challengeSlider .ui-slider-handle').removeClass("level1");
                    $('.challengeSlider .ui-slider-handle').removeClass("level2");
                    $('.challengeSlider .ui-slider-handle').removeClass("level4");
                    $('.challengeSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 75) {
                    $scope.package.challengeLevel = 3;
                    $('.challengeSlider .ui-slider-handle').addClass("level4");
                    $('.challengeSlider .ui-slider-handle').removeClass("level1");
                    $('.challengeSlider .ui-slider-handle').removeClass("level2");
                    $('.challengeSlider .ui-slider-handle').removeClass("level3");
                    $('.challengeSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 100) {
                    $scope.package.challengeLevel = 4;
                    $('.challengeSlider .ui-slider-handle').addClass("level5");
                    $('.challengeSlider .ui-slider-handle').removeClass("level1");
                    $('.challengeSlider .ui-slider-handle').removeClass("level2");
                    $('.challengeSlider .ui-slider-handle').removeClass("level3");
                    $('.challengeSlider .ui-slider-handle').removeClass("level4");
                }
            }
        });
        //Set init value for slider       
        $(".challengeSlider").slider('value', $scope.package.challengeLevel * 25);
        if ($(".challengeSlider").slider('value') === 0) {
            $('.challengeSlider .ui-slider-handle').addClass("level1");
        } else if ($(".challengeSlider").slider('value') === 25) {
            $('.challengeSlider .ui-slider-handle').addClass("level2");
        } else if ($(".challengeSlider").slider('value') === 50) {
            $('.challengeSlider .ui-slider-handle').addClass("level3");
        } else if ($(".challengeSlider").slider('value') === 75) {
            $('.challengeSlider .ui-slider-handle').addClass("level4");
        } else if ($(".challengeSlider").slider('value') === 100) {
            $('.challengeSlider .ui-slider-handle').addClass("level5");
        }

        $('.friendshipSlider').slider({
            range: "min",
            value: 0,
            step: 25,
            slide: function (event, ui) {
                if (ui.value === 0) {
                    $scope.package.friendshipLevel = 0;
                    $('.friendshipSlider .ui-slider-handle').addClass("level1");
                    $('.friendshipSlider .ui-slider-handle').removeClass("level2");
                    $('.friendshipSlider .ui-slider-handle').removeClass("level3");
                    $('.friendshipSlider .ui-slider-handle').removeClass("level4");
                    $('.friendshipSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 25) {
                    $scope.package.friendshipLevel = 1;
                    $('.friendshipSlider .ui-slider-handle').addClass("level2");
                    $('.friendshipSlider .ui-slider-handle').removeClass("level1");
                    $('.friendshipSlider .ui-slider-handle').removeClass("level3");
                    $('.friendshipSlider .ui-slider-handle').removeClass("level4");
                    $('.friendshipSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 50) {
                    $scope.package.friendshipLevel = 2;
                    $('.friendshipSlider .ui-slider-handle').addClass("level3");
                    $('.friendshipSlider .ui-slider-handle').removeClass("level1");
                    $('.friendshipSlider .ui-slider-handle').removeClass("level2");
                    $('.friendshipSlider .ui-slider-handle').removeClass("level4");
                    $('.friendshipSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 75) {
                    $scope.package.friendshipLevel = 3;
                    $('.friendshipSlider .ui-slider-handle').addClass("level4");
                    $('.friendshipSlider .ui-slider-handle').removeClass("level1");
                    $('.friendshipSlider .ui-slider-handle').removeClass("level2");
                    $('.friendshipSlider .ui-slider-handle').removeClass("level3");
                    $('.friendshipSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 100) {
                    $scope.package.friendshipLevel = 4;
                    $('.friendshipSlider .ui-slider-handle').addClass("level5");
                    $('.friendshipSlider .ui-slider-handle').removeClass("level1");
                    $('.friendshipSlider .ui-slider-handle').removeClass("level2");
                    $('.friendshipSlider .ui-slider-handle').removeClass("level3");
                    $('.friendshipSlider .ui-slider-handle').removeClass("level4");
                }
            }
        });
        //Set init value for slider       
        $(".friendshipSlider").slider('value', $scope.package.friendshipLevel * 25);
        if ($(".friendshipSlider").slider('value') === 0) {
            $('.friendshipSlider .ui-slider-handle').addClass("level1");
        } else if ($(".friendshipSlider").slider('value') === 25) {
            $('.friendshipSlider .ui-slider-handle').addClass("level2");
        } else if ($(".friendshipSlider").slider('value') === 50) {
            $('.friendshipSlider .ui-slider-handle').addClass("level3");
        } else if ($(".friendshipSlider").slider('value') === 75) {
            $('.friendshipSlider .ui-slider-handle').addClass("level4");
        } else if ($(".friendshipSlider").slider('value') === 100) {
            $('.friendshipSlider .ui-slider-handle').addClass("level5");
        }

        $('.happinessSlider').slider({
            range: "min",
            value: 0,
            step: 25,
            slide: function (event, ui) {
                if (ui.value === 0) {
                    $scope.package.happinessLevel = 0;
                    $('.happinessSlider .ui-slider-handle').addClass("level1");
                    $('.happinessSlider .ui-slider-handle').removeClass("level2");
                    $('.happinessSlider .ui-slider-handle').removeClass("level3");
                    $('.happinessSlider .ui-slider-handle').removeClass("level4");
                    $('.happinessSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 25) {
                    $scope.package.happinessLevel = 1;
                    $('.happinessSlider .ui-slider-handle').addClass("level2");
                    $('.happinessSlider .ui-slider-handle').removeClass("level1");
                    $('.happinessSlider .ui-slider-handle').removeClass("level3");
                    $('.happinessSlider .ui-slider-handle').removeClass("level4");
                    $('.happinessSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 50) {
                    $scope.package.happinessLevel = 2;
                    $('.happinessSlider .ui-slider-handle').addClass("level3");
                    $('.happinessSlider .ui-slider-handle').removeClass("level1");
                    $('.happinessSlider .ui-slider-handle').removeClass("level2");
                    $('.happinessSlider .ui-slider-handle').removeClass("level4");
                    $('.happinessSlider .happinessSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 75) {
                    $scope.package.happinessLevel = 3;
                    $('.happinessSlider .ui-slider-handle').addClass("level4");
                    $('.happinessSlider .ui-slider-handle').removeClass("level1");
                    $('.happinessSlider .ui-slider-handle').removeClass("level2");
                    $('.happinessSlider .ui-slider-handle').removeClass("level3");
                    $('.happinessSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 100) {
                    $scope.package.happinessLevel = 4;
                    $('.happinessSlider .ui-slider-handle').addClass("level5");
                    $('.happinessSlider .ui-slider-handle').removeClass("level1");
                    $('.happinessSlider .ui-slider-handle').removeClass("level2");
                    $('.happinessSlider .ui-slider-handle').removeClass("level3");
                    $('.happinessSlider .ui-slider-handle').removeClass("level4");
                }
            }
        });
        //Set init value for slider       
        $(".happinessSlider").slider('value', $scope.package.happinessLevel * 25);
        if ($(".happinessSlider").slider('value') === 0) {
            $('.happinessSlider .ui-slider-handle').addClass("level1");
        } else if ($(".happinessSlider").slider('value') === 25) {
            $('.happinessSlider .ui-slider-handle').addClass("level2");
        } else if ($(".happinessSlider").slider('value') === 50) {
            $('.happinessSlider .ui-slider-handle').addClass("level3");
        } else if ($(".happinessSlider").slider('value') === 75) {
            $('.happinessSlider .ui-slider-handle').addClass("level4");
        } else if ($(".happinessSlider").slider('value') === 100) {
            $('.happinessSlider .ui-slider-handle').addClass("level5");
        }
        $('.heathinessSlider').slider({
            range: "min",
            value: 0,
            step: 25,
            slide: function (event, ui) {
                if (ui.value === 0) {
                    $scope.package.healthinessLevel = 0;
                    $('.heathinessSlider .ui-slider-handle').addClass("level1");
                    $('.heathinessSlider .ui-slider-handle').removeClass("level2");
                    $('.heathinessSlider .ui-slider-handle').removeClass("level3");
                    $('.heathinessSlider .ui-slider-handle').removeClass("level4");
                    $('.heathinessSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 25) {
                    $scope.package.healthinessLevel = 1;
                    $('.heathinessSlider .ui-slider-handle').addClass("level2");
                    $('.heathinessSlider .ui-slider-handle').removeClass("level1");
                    $('.heathinessSlider .ui-slider-handle').removeClass("level3");
                    $('.heathinessSlider .ui-slider-handle').removeClass("level4");
                    $('.heathinessSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 50) {
                    $scope.package.healthinessLevel = 2;
                    $('.heathinessSlider .ui-slider-handle').addClass("level3");
                    $('.heathinessSlider .ui-slider-handle').removeClass("level1");
                    $('.heathinessSlider .ui-slider-handle').removeClass("level2");
                    $('.heathinessSlider .ui-slider-handle').removeClass("level4");
                    $('.heathinessSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 75) {
                    $scope.package.healthinessLevel = 3;
                    $('.heathinessSlider .ui-slider-handle').addClass("level4");
                    $('.heathinessSlider .ui-slider-handle').removeClass("level1");
                    $('.heathinessSlider .ui-slider-handle').removeClass("level2");
                    $('.heathinessSlider .ui-slider-handle').removeClass("level3");
                    $('.heathinessSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 100) {
                    $scope.package.healthinessLevel = 4;
                    $('.heathinessSlider .ui-slider-handle').addClass("level5");
                    $('.heathinessSlider .ui-slider-handle').removeClass("level1");
                    $('.heathinessSlider .ui-slider-handle').removeClass("level2");
                    $('.heathinessSlider .ui-slider-handle').removeClass("level3");
                    $('.heathinessSlider .ui-slider-handle').removeClass("level4");
                }
            }
        });
        //Set init value for slider       
        $(".heathinessSlider").slider('value', $scope.package.healthinessLevel * 25);
        if ($(".heathinessSlider").slider('value') === 0) {
            $('.heathinessSlider .ui-slider-handle').addClass("level1");
        } else if ($(".heathinessSlider").slider('value') === 25) {
            $('.heathinessSlider .ui-slider-handle').addClass("level2");
        } else if ($(".heathinessSlider").slider('value') === 50) {
            $('.heathinessSlider .ui-slider-handle').addClass("level3");
        } else if ($(".heathinessSlider").slider('value') === 75) {
            $('.heathinessSlider .ui-slider-handle').addClass("level4");
        } else if ($(".heathinessSlider").slider('value') === 100) {
            $('.heathinessSlider .ui-slider-handle').addClass("level5");
        }


        $('.knowledgeSlider').slider({
            range: "min",
            value: 0,
            step: 25,
            slide: function (event, ui) {
                if (ui.value === 0) {
                    $scope.package.knowledgeLevel = 0;
                    $('.knowledgeSlider .ui-slider-handle').addClass("level1");
                    $('.knowledgeSlider .ui-slider-handle').removeClass("level2");
                    $('.knowledgeSlider .ui-slider-handle').removeClass("level3");
                    $('.knowledgeSlider .ui-slider-handle').removeClass("level4");
                    $('.knowledgeSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 25) {
                    $scope.package.knowledgeLevel = 1;
                    $('.knowledgeSlider .ui-slider-handle').addClass("level2");
                    $('.knowledgeSlider .ui-slider-handle').removeClass("level1");
                    $('.knowledgeSlider .ui-slider-handle').removeClass("level3");
                    $('.knowledgeSlider .ui-slider-handle').removeClass("level4");
                    $('.knowledgeSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 50) {
                    $scope.package.knowledgeLevel = 2;
                    $('.knowledgeSlider .ui-slider-handle').addClass("level3");
                    $('.knowledgeSlider .ui-slider-handle').removeClass("level1");
                    $('.knowledgeSlider .ui-slider-handle').removeClass("level2");
                    $('.knowledgeSlider .ui-slider-handle').removeClass("level4");
                    $('.knowledgeSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 75) {
                    $scope.package.knowledgeLevel = 3;
                    $('.knowledgeSlider .ui-slider-handle').addClass("level4");
                    $('.knowledgeSlider .ui-slider-handle').removeClass("level1");
                    $('.knowledgeSlider .ui-slider-handle').removeClass("level2");
                    $('.knowledgeSlider .ui-slider-handle').removeClass("level3");
                    $('.knowledgeSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 100) {
                    $scope.package.knowledgeLevel = 4;
                    $('.knowledgeSlider .ui-slider-handle').addClass("level5");
                    $('.knowledgeSlider .ui-slider-handle').removeClass("level1");
                    $('.knowledgeSlider .ui-slider-handle').removeClass("level2");
                    $('.knowledgeSlider .ui-slider-handle').removeClass("level3");
                    $('.knowledgeSlider .ui-slider-handle').removeClass("level4");
                }
            }
        });
        //Set init value for slider       
        $(".knowledgeSlider").slider('value', $scope.package.knowledgeLevel * 25);
        if ($(".knowledgeSlider").slider('value') === 0) {
            $('.knowledgeSlider .ui-slider-handle').addClass("level1");
        } else if ($(".knowledgeSlider").slider('value') === 25) {
            $('.knowledgeSlider .ui-slider-handle').addClass("level2");
        } else if ($(".knowledgeSlider").slider('value') === 50) {
            $('.knowledgeSlider .ui-slider-handle').addClass("level3");
        } else if ($(".knowledgeSlider").slider('value') === 75) {
            $('.knowledgeSlider .ui-slider-handle').addClass("level4");
        } else if ($(".knowledgeSlider").slider('value') === 100) {
            $('.knowledgeSlider .ui-slider-handle').addClass("level5");
        }

        $('.peacefulnessSlider').slider({
            range: "min",
            value: 0,
            step: 25,
            slide: function (event, ui) {
                if (ui.value === 0) {
                    $scope.package.peacefulnessLevel = 0;
                    $('.peacefulnessSlider .ui-slider-handle').addClass("level1");
                    $('.peacefulnessSlider .ui-slider-handle').removeClass("level2");
                    $('.peacefulnessSlider .ui-slider-handle').removeClass("level3");
                    $('.peacefulnessSlider .ui-slider-handle').removeClass("level4");
                    $('.peacefulnessSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 25) {
                    $scope.package.peacefulnessLevel = 1;
                    $('.peacefulnessSlider .ui-slider-handle').addClass("level2");
                    $('.peacefulnessSlider .ui-slider-handle').removeClass("level1");
                    $('.peacefulnessSlider .ui-slider-handle').removeClass("level3");
                    $('.peacefulnessSlider .ui-slider-handle').removeClass("level4");
                    $('.peacefulnessSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 50) {
                    $scope.package.peacefulnessLevel = 2;
                    $('.peacefulnessSlider .ui-slider-handle').addClass("level3");
                    $('.peacefulnessSlider .ui-slider-handle').removeClass("level1");
                    $('.peacefulnessSlider .ui-slider-handle').removeClass("level2");
                    $('.peacefulnessSlider .ui-slider-handle').removeClass("level4");
                    $('.peacefulnessSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 75) {
                    $scope.package.peacefulnessLevel = 3;
                    $('.peacefulnessSlider .ui-slider-handle').addClass("level4");
                    $('.peacefulnessSlider .ui-slider-handle').removeClass("level1");
                    $('.peacefulnessSlider .ui-slider-handle').removeClass("level2");
                    $('.peacefulnessSlider .ui-slider-handle').removeClass("level3");
                    $('.peacefulnessSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 100) {
                    $scope.package.peacefulnessLevel = 4;
                    $('.peacefulnessSlider .ui-slider-handle').addClass("level5");
                    $('.peacefulnessSlider .ui-slider-handle').removeClass("level1");
                    $('.peacefulnessSlider .ui-slider-handle').removeClass("level2");
                    $('.peacefulnessSlider .ui-slider-handle').removeClass("level3");
                    $('.peacefulnessSlider .ui-slider-handle').removeClass("level4");
                }
            }
        });
        //Set init value for slider       
        $(".peacefulnessSlider").slider('value', $scope.package.peacefulnessLevel * 25);
        if ($(".peacefulnessSlider").slider('value') === 0) {
            $('.peacefulnessSlider .ui-slider-handle').addClass("level1");
        } else if ($(".peacefulnessSlider").slider('value') === 25) {
            $('.peacefulnessSlider .ui-slider-handle').addClass("level2");
        } else if ($(".peacefulnessSlider").slider('value') === 50) {
            $('.peacefulnessSlider .ui-slider-handle').addClass("level3");
        } else if ($(".peacefulnessSlider").slider('value') === 75) {
            $('.peacefulnessSlider .ui-slider-handle').addClass("level4");
        } else if ($(".peacefulnessSlider").slider('value') === 100) {
            $('.peacefulnessSlider .ui-slider-handle').addClass("level5");
        }

        $('.romanceSlider').slider({
            range: "min",
            value: 0,
            step: 25,
            slide: function (event, ui) {
                if (ui.value === 0) {
                    $scope.package.romanceLevel = 0;
                    $('.romanceSlider .ui-slider-handle').addClass("level1");
                    $('.romanceSlider .ui-slider-handle').removeClass("level2");
                    $('.romanceSlider .ui-slider-handle').removeClass("level3");
                    $('.romanceSlider .ui-slider-handle').removeClass("level4");
                    $('.romanceSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 25) {
                    $scope.package.romanceLevel = 1;
                    $('.romanceSlider .ui-slider-handle').addClass("level2");
                    $('.romanceSlider .ui-slider-handle').removeClass("level1");
                    $('.romanceSlider .ui-slider-handle').removeClass("level3");
                    $('.romanceSlider .ui-slider-handle').removeClass("level4");
                    $('.romanceSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 50) {
                    $scope.package.romanceLevel = 2;
                    $('.romanceSlider .ui-slider-handle').addClass("level3");
                    $('.romanceSlider .ui-slider-handle').removeClass("level1");
                    $('.romanceSlider .ui-slider-handle').removeClass("level2");
                    $('.romanceSlider .ui-slider-handle').removeClass("level4");
                    $('.romanceSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 75) {
                    $scope.package.romanceLevel = 3;
                    $('.romanceSlider .ui-slider-handle').addClass("level4");
                    $('.romanceSlider .ui-slider-handle').removeClass("level1");
                    $('.romanceSlider .ui-slider-handle').removeClass("level2");
                    $('.romanceSlider .ui-slider-handle').removeClass("level3");
                    $('.romanceSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 100) {
                    $scope.package.romanceLevel = 4;
                    $('.romanceSlider .ui-slider-handle').addClass("level5");
                    $('.romanceSlider .ui-slider-handle').removeClass("level1");
                    $('.romanceSlider .ui-slider-handle').removeClass("level2");
                    $('.romanceSlider .ui-slider-handle').removeClass("level3");
                    $('.romanceSlider .ui-slider-handle').removeClass("level4");
                }
            }
        });
        //Set init value for slider       
        $(".romanceSlider").slider('value', $scope.package.romanceLevel * 25);
        if ($(".romanceSlider").slider('value') === 0) {
            $('.romanceSlider .ui-slider-handle').addClass("level1");
        } else if ($(".romanceSlider").slider('value') === 25) {
            $('.romanceSlider .ui-slider-handle').addClass("level2");
        } else if ($(".romanceSlider").slider('value') === 50) {
            $('.romanceSlider .ui-slider-handle').addClass("level3");
        } else if ($(".romanceSlider").slider('value') === 75) {
            $('.romanceSlider .ui-slider-handle').addClass("level4");
        } else if ($(".romanceSlider").slider('value') === 100) {
            $('.romanceSlider .ui-slider-handle').addClass("level5");
        }


        $('.sophisticationSlider').slider({
            range: "min",
            value: 0,
            step: 25,
            slide: function (event, ui) {
                if (ui.value === 0) {
                    $scope.package.sophisticationLevel = 0;
                    $('.sophisticationSlider .ui-slider-handle').addClass("level1");
                    $('.sophisticationSlider .ui-slider-handle').removeClass("level2");
                    $('.sophisticationSlider .ui-slider-handle').removeClass("level3");
                    $('.sophisticationSlider .ui-slider-handle').removeClass("level4");
                    $('.sophisticationSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 25) {
                    $scope.package.sophisticationLevel = 1;
                    $('.sophisticationSlider .ui-slider-handle').addClass("level2");
                    $('.sophisticationSlider .ui-slider-handle').removeClass("level1");
                    $('.sophisticationSlider .ui-slider-handle').removeClass("level3");
                    $('.sophisticationSlider .ui-slider-handle').removeClass("level4");
                    $('.sophisticationSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 50) {
                    $scope.package.sophisticationLevel = 2;
                    $('.sophisticationSlider .ui-slider-handle').addClass("level3");
                    $('.sophisticationSlider .ui-slider-handle').removeClass("level1");
                    $('.sophisticationSlider .ui-slider-handle').removeClass("level2");
                    $('.sophisticationSlider .ui-slider-handle').removeClass("level4");
                    $('.sophisticationSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 75) {
                    $scope.package.sophisticationLevel = 3;
                    $('.sophisticationSlider .ui-slider-handle').addClass("level4");
                    $('.sophisticationSlider .ui-slider-handle').removeClass("level1");
                    $('.sophisticationSlider .ui-slider-handle').removeClass("level2");
                    $('.sophisticationSlider .ui-slider-handle').removeClass("level3");
                    $('.sophisticationSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 100) {
                    $scope.package.sophisticationLevel = 4;
                    $('.sophisticationSlider .ui-slider-handle').addClass("level5");
                    $('.sophisticationSlider .ui-slider-handle').removeClass("level1");
                    $('.sophisticationSlider .ui-slider-handle').removeClass("level2");
                    $('.sophisticationSlider .ui-slider-handle').removeClass("level3");
                    $('.sophisticationSlider .ui-slider-handle').removeClass("level4");
                }
            }
        });
        //Set init value for slider       
        $(".sophisticationSlider").slider('value', $scope.package.sophisticationLevel * 25);
        if ($(".sophisticationSlider").slider('value') === 0) {
            $('.sophisticationSlider .ui-slider-handle').addClass("level1");
        } else if ($(".sophisticationSlider").slider('value') === 25) {
            $('.sophisticationSlider .ui-slider-handle').addClass("level2");
        } else if ($(".sophisticationSlider").slider('value') === 50) {
            $('.sophisticationSlider .ui-slider-handle').addClass("level3");
        } else if ($(".sophisticationSlider").slider('value') === 75) {
            $('.sophisticationSlider .ui-slider-handle').addClass("level4");
        } else if ($(".sophisticationSlider").slider('value') === 100) {
            $('.sophisticationSlider .ui-slider-handle').addClass("level5");
        }

        $('.unexpectedSlider').slider({
            range: "min",
            value: 0,
            step: 25,
            slide: function (event, ui) {
                if (ui.value === 0) {
                    $scope.package.unexpectedLevel = 0;
                    $('.unexpectedSlider .ui-slider-handle').addClass("level1");
                    $('.unexpectedSlider .ui-slider-handle').removeClass("level2");
                    $('.unexpectedSlider .ui-slider-handle').removeClass("level3");
                    $('.unexpectedSlider .ui-slider-handle').removeClass("level4");
                    $('.unexpectedSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 25) {
                    $scope.package.unexpectedLevel = 1;
                    $('.unexpectedSlider .ui-slider-handle').addClass("level2");
                    $('.unexpectedSlider .ui-slider-handle').removeClass("level1");
                    $('.unexpectedSlider .ui-slider-handle').removeClass("level3");
                    $('.unexpectedSlider .ui-slider-handle').removeClass("level4");
                    $('.unexpectedSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 50) {
                    $scope.package.unexpectedLevel = 2;
                    $('.unexpectedSlider .ui-slider-handle').addClass("level3");
                    $('.unexpectedSlider .ui-slider-handle').removeClass("level1");
                    $('.unexpectedSlider .ui-slider-handle').removeClass("level2");
                    $('.unexpectedSlider .ui-slider-handle').removeClass("level4");
                    $('.unexpectedSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 75) {
                    $scope.package.unexpectedLevel = 3;
                    $('.unexpectedSlider .ui-slider-handle').addClass("level4");
                    $('.unexpectedSlider .ui-slider-handle').removeClass("level1");
                    $('.unexpectedSlider .ui-slider-handle').removeClass("level2");
                    $('.unexpectedSlider .ui-slider-handle').removeClass("level3");
                    $('.unexpectedSlider .ui-slider-handle').removeClass("level5");
                } else if (ui.value === 100) {
                    $scope.package.unexpectedLevel = 4;
                    $('.unexpectedSlider .ui-slider-handle').addClass("level5");
                    $('.unexpectedSlider .ui-slider-handle').removeClass("level1");
                    $('.unexpectedSlider .ui-slider-handle').removeClass("level2");
                    $('.unexpectedSlider .ui-slider-handle').removeClass("level3");
                    $('.unexpectedSlider .ui-slider-handle').removeClass("level4");
                }
            }
        });
        //Set init value for slider       
        $(".unexpectedSlider").slider('value', $scope.package.unexpectedLevel * 25);
        if ($(".unexpectedSlider").slider('value') === 0) {
            $('.unexpectedSlider .ui-slider-handle').addClass("level1");
        } else if ($(".unexpectedSlider").slider('value') === 25) {
            $('.unexpectedSlider .ui-slider-handle').addClass("level2");
        } else if ($(".unexpectedSlider").slider('value') === 50) {
            $('.unexpectedSlider .ui-slider-handle').addClass("level3");
        } else if ($(".unexpectedSlider").slider('value') === 75) {
            $('.unexpectedSlider .ui-slider-handle').addClass("level4");
        } else if ($(".unexpectedSlider").slider('value') === 100) {
            $('.unexpectedSlider .ui-slider-handle').addClass("level5");
        }
    };
    $scope.selectSuitabilityUniversal = function (val) {
        if (val === "Universal") {
            angular.forEach($scope.package.temporarySuitabiltyClassifiers, function (child) {
                if (child.suitabilityName !== 'Universal') {
                    child.selected = false;
                }
            });
        } else {
            angular.forEach($scope.package.temporarySuitabiltyClassifiers, function (child) {
                if (child.suitabilityName === 'Universal') {
                    child.selected = false;
                }
            });
        }
    };
    /* END CATEGORY SECTION */

    /* DESCRIPTION SECTION */

    // convert all to json
    var languageDescriptionList = $scope.package.languageDescriptionList;
    function convertAdvancedDescriptionToJson() {
        for (var i = 0, max = languageDescriptionList.length; i < max; i++) {
            var languageDescription = languageDescriptionList[i];
            languageDescription.description = JSON.parse(languageDescription.description);
            languageDescription.advancedAddress = JSON.parse(languageDescription.advancedAddress);
            if (angular.isString(languageDescription.keywords)) {
                languageDescription.keywords = JSON.parse(languageDescription.keywords);
            }
            if (angular.isString(languageDescription.language)) {
                languageDescription.language = JSON.parse(languageDescription.language);
            }
        }
    }
    convertAdvancedDescriptionToJson();
    // function change languge description
    $scope.selectedLanguageDescription;
    $scope.showLanguageDescription = function (languageID) {
        if ($scope.selectedLanguageDescription === undefined || languageID !== $scope.selectedLanguageDescription.languageID) {
            for (var i = 0, max = languageDescriptionList.length; i < max; i++) {
                var languageDescription = languageDescriptionList[i];
                if (languageID === languageDescription.languageID) {
                    $scope.selectedLanguageDescription = languageDescription;
                    // update mask input
                    $timeout(function () {
                        $(".timeMaskInput").inputmask("h:s", {
                            onKeyValidation: function (key, result) {
                                angular.element($(this)).triggerHandler('input');
                            }
                        });
                    }, 100);
                }
            }
        }
    };
//    change language list to hash map and get english ID
    var englishDescription;
    $scope.languages = {};
    function convertLanguageListToHash() {
        var languageList = $scope.packageForm.languageList;
        for (var i = 0, max = languageList.length; i < max; i++) {
            var language = languageList[i];
            var languageID = language.languageID;
            $scope.languages[languageID] = language;
            if (language.languageName === "English") {
                $scope.showLanguageDescription(languageID);
                englishDescription = $scope.selectedLanguageDescription;
            }
        }
    }
    convertLanguageListToHash();
    $scope.addNewAdvancedDescription = function () {
        // add new description for all exsiting language
        for (var i = 0, max = languageDescriptionList.length; i < max; i++) {
            var signleDescription = {"header": "", "description": ""};
            languageDescriptionList[i]["description"].push(signleDescription);
        }
    };
    $scope.deleteAdvancedDescription = function (index) {
        // delete from all exsiting language
        for (var i = 0, max = languageDescriptionList.length; i < max; i++) {
            var advancedDescription = languageDescriptionList[i]["description"];
            if (advancedDescription.length > 1) {
                advancedDescription.splice(index, 1);
            }
        }
    };
    $scope.moveDescriptionUp = function (index) {
        // move in all existing language
        if (index !== 0) {
            for (var i = 0, max = languageDescriptionList.length; i < max; i++) {
                var advancedDescription = languageDescriptionList[i]["description"];
                var tempDescription = advancedDescription[index];
                advancedDescription[index] = advancedDescription[index - 1];
                advancedDescription[index - 1] = tempDescription;
            }
        }
    };
    $scope.moveDescriptionDown = function (index) {
        // move in all existing language
        var max = languageDescriptionList.length;
        if (index !== (max - 1)) {
            for (var i = 0; i < max; i++) {
                var advancedDescription = languageDescriptionList[i]["description"];
                var tempDescription = advancedDescription[index];
                advancedDescription[index] = advancedDescription[index + 1];
                advancedDescription[index + 1] = tempDescription;
            }
        }
    };
    // amenities
    $scope.amenitiesClassifiers = $scope.package.amenitiesClassifiers;
    $scope.selectedListAmenities = [];
    // find out selected amenities from data
    for (var i = 0, max = $scope.amenitiesClassifiers.length; i < max; i++) { // loop selected amenties classfier

        // get an amenties from classifier
        var amenitiesClassifier = $scope.amenitiesClassifiers[i];
        var amenities = {"amenitiesID": amenitiesClassifier.amenitiesID, "amenitiesType": amenitiesClassifier.amenitiesName, "icon": amenitiesClassifier.amenitiesIcon};
        // add to list
        $scope.selectedListAmenities.push(amenities);
    }

    //conver list certificates to hash
    $scope.providerCertificates = {};
    function convertProviderCertificatesToHashMap() {
        $scope.providerCertificates = {};
        for (var i = 0, max = $scope.packageForm.certificates.length; i < max; i++) {
            var certificate = $scope.packageForm.certificates[i];
            $scope.providerCertificates[certificate.certificateID] = certificate;
        }
    }
    convertProviderCertificatesToHashMap();
    // find out selected certificate from data
    for (var i = 0, max = $scope.package.certificates.length; i < max; i++) {

    }

    // get length before list change to check list is inserted or deleted
    var oldAmenitiesLen = $scope.selectedListAmenities.length;
    $scope.amenitiesListChange = function () {
        oldAmenitiesLen = $scope.selectedListAmenities.length;
    };
    // add new amenities description to all language or delete
    $scope.validateListAmenities = function (newAmenity) {
        var newLength = $scope.selectedListAmenities.length;
        if (newLength > oldAmenitiesLen) { // add

            for (var i = 0, max = languageDescriptionList.length; i < max; i++) {
                var languageID = languageDescriptionList[i].languageID;
                var amenitiesClassifier = {"temporaryPackageID": $scope.package.id, "amenitiesID": newAmenity.amenitiesID, "amenitiesName": newAmenity.amenitiesType,
                    "amenitiesIcon": newAmenity.icon, "description": "", "languageID": languageID};
                $scope.amenitiesClassifiers.push(amenitiesClassifier);
            }

        } else if (newLength < oldAmenitiesLen) { // remove
            var removeID = newAmenity.amenitiesID;
            for (var i = ($scope.amenitiesClassifiers.length - 1); i >= 0; i--) {
                var amenitiesID = $scope.amenitiesClassifiers[i].amenitiesID;
                if (amenitiesID === removeID) {
                    $scope.amenitiesClassifiers.splice(i, 1);
                }
            }
        }
    };
    // construct list of selected certificate ids
    $scope.listSelectedCertificateIDs = [];
    $scope.toggleCertificateBox = function () {
        if (!$("#certificatePopup.ytPopup").hasClass("active")) { //before opening popup, con struct list of certficiate ids
            $scope.listSelectedCertificateIDs = [];
            for (var i = 0, max = $scope.package.certificates.length; i < max; i++) {
                var certificateID = $scope.package.certificates[i].certificateID;
                $scope.listSelectedCertificateIDs.push(certificateID);
            }

            var windownHeight = $(window).height(); // returns height of browser viewport
            $("#certificatePopup.ytPopup .popupScroll").css("max-height", (windownHeight - 50) + "px");
        }

        $("#certificatePopup.ytPopup").toggleClass("active");
    };
    // when click choose from popup
    $scope.chooseCertficates = function () {
        if ($scope.listSelectedCertificateIDs.length <= 4) {
            $scope.package.certificates = [];
            for (var i = 0, max = $scope.listSelectedCertificateIDs.length; i < max; i++) {
                var certificateID = $scope.listSelectedCertificateIDs[i];
                var providerCertificate = $scope.providerCertificates[certificateID];
                var newCertficiate = {"certificateID": providerCertificate.certificateID, "temporaryPackageID": $scope.package.id,
                    "imageLink": providerCertificate.image};
                $scope.package.certificates.push(newCertficiate);
            }

            $scope.toggleCertificateBox();
        } else {
            alert("Sorry, you can choose only four certificates for this package!");
        }
    };
    var certificateUploadingUrl = service.getContextPath() + "/Provider/Package/CertificateUploading";
    $scope.certificateImageFile;
    var ERROR_PAGE = service.getContextPath() + service.getErrorPageUrl();
    $scope.certificateUploading = false;
    $scope.uploadCertificateImage = function () {
        if ($scope.certificateImageFile) {
            $scope.certificateUploading = true;
            var oMyForm = new FormData();
            oMyForm.append("certificateImage", $scope.certificateImageFile);
            var data = "{'packageID': " + $scope.package.id + ", 'name': ''}";
            oMyForm.append("dataJson", data);
            $.ajax({
                url: certificateUploadingUrl,
                data: oMyForm,
                dataType: 'text',
                processData: false,
                contentType: false,
                type: 'POST',
                success: function (data) {
                    data = JSON.parse(data);
                    if (data.result !== "error") {
                        $scope.packageForm.certificates = data.result;
                        convertProviderCertificatesToHashMap();
                        $scope.certificateUploading = false;
                        $scope.$digest();
                    } else {
                        $(location).attr('href', ERROR_PAGE);
                    }
                }, error: function (respone) {
                    $(location).attr('href', ERROR_PAGE);
                }
            });
        }
    };
    // Location
    $scope.locationTypes = [
        {"locationType": "action", "text": "Add an action location", "color": "#3FC1C9",
            "title": "Activity Location (Mandatory) - Show us where your activity will happen. Add one location or createa journey with multiple stops.*"},
        {"locationType": "departure", "text": "Add a departure location", "color": "#FF514E",
            "title": "Departure Location - Show us if you’re meeting somewhere to depart from a peer or a station for example."},
        {"locationType": "pickup", "text": "Add a pickup location", "color": "#FBB03B",
            "title": "Pick Up Location - Are you offering a pick up service from local stations, hotels or other landmarks? You can register them here."}
    ];
    $scope.selectedLocationType = 'action';
    $scope.changeLocationType = function (type) {
        $scope.selectedLocationType = type;
        // update mask input
        $timeout(function () {
            $(".timeMaskInput").inputmask("h:s", {
                onKeyValidation: function (key, result) {
                    angular.element($(this)).triggerHandler('input');
                }
            });
        }, 100);
    };
    var addMode;
    $scope.addLocation = function (type) {
        $("#location-popup").toggleClass("active");
        setTimeout(function () {
            initPopUpMap();
            addMode = true;
            locationTypeTemp = type;
        }, 100);
    };
    $scope.closeLocationPopUp = function () {
        $("#location-popup").toggleClass("active");
    };
    // remove from all language
    $scope.addExplaination = function (index, selectedLocationType) {
        for (var i = 0, max = languageDescriptionList.length; i < max; i++) {
            var advancedAddress = languageDescriptionList[i].advancedAddress;
            var addressDetail = advancedAddress[selectedLocationType][index];
            addressDetail["accessDescription"] = "";
        }
    };
    $scope.removeExplaination = function (index, selectedLocationType) {
        for (var i = 0, max = languageDescriptionList.length; i < max; i++) {
            var advancedAddress = languageDescriptionList[i].advancedAddress;
            var addressDetail = advancedAddress[selectedLocationType][index];
            addressDetail["accessDescription"] = undefined;
        }
    };
    $scope.addExplainationTemp = function () {
        $scope.addressDetailTemp["accessDescription"] = "";
    };
    $scope.removeExplainationTemp = function () {
        $scope.addressDetailTemp["accessDescription"] = undefined;
    };
    // for language pop up
    $scope.selectedLanguageID = 0;
    $scope.toggleLanguageBox = function () {
        $scope.selectedLanguageID = 0;
        $("#languagePopup.certificateBox").toggleClass("active");
    };
    $scope.toggleLocationBox = function () {
        $("#location-popup").toggleClass("active");
        searchBoxPopUp.value = "";
        $scope.addressDetailTemp = {"lat": "", "lng": "",
            "addr": "", "startTime": "", "endTime": "",
            "content": "", "country": "", "city": "", "accessDescription": ""};
    };
    var map, searchBox, additionalAutocomplete, currentLocation = {}, newPlace;
    $scope.selectedMarker;
    var initMap = function () {

        map = new google.maps.Map(document.getElementById('map'), {
            center: new google.maps.LatLng(currentLocation.lat, currentLocation.lng),
            zoom: 17,
            draggable: true
        });
        // enable autocomplete for first additional input
        searchBox = (document.getElementById('additionalAutocomplete'));
        additionalAutocomplete = new google.maps.places.SearchBox(searchBox);
        // search result depends on map bound
        map.addListener('bounds_changed', function () {
            additionalAutocomplete.setBounds(map.getBounds());
        });
        additionalAutocomplete.addListener('places_changed', function () {
            newPlace = additionalAutocomplete.getPlaces()[0];
            if (!newPlace.geometry) {
                window.alert("Autocomplete's returned place contains no geometry");
                return;
            }
        });
        google.maps.event.addListener(map, 'click', function (event) {

            // get the location from click
            var location = event.latLng;
            // parse selected Marker to object
            var markerObj = $.parseJSON($scope.selectedMarker);
            changeLatLngOffAllLanguage(location.lat(), location.lng(), markerObj.kindOfMarker, markerObj.position);
//            $scope.$digest();

            // update markers on map again
            updateMarkerArray();
        });
        updateMarkerArray();
        $(".timeMaskInput").inputmask("h:s", {
            onKeyValidation: function (key, result) {
                angular.element($(this)).triggerHandler('input');
            }
        });
        $scope.mapLoaded = true;
    };
    var marker, mapPopUp, searchBoxPopUp, newPlacePopUp, additionalAutocompletePopUp;
    var infowindow = new google.maps.InfoWindow({
        content: ''
    });
    $scope.addressDetailTemp = {"lat": "", "lng": "",
        "addr": "", "startTime": "", "endTime": "",
        "content": "", "country": "", "city": "", "accessDescription": ""};
    var initPopUpMap = function () {

        mapPopUp = new google.maps.Map(document.getElementById('map-pop-up'), {
            center: new google.maps.LatLng(currentLocation.lat, currentLocation.lng),
            zoom: 17,
            draggable: true
        });
        // enable autocomplete for first additional input
        searchBoxPopUp = (document.getElementById('additionalAutocompletePopUp'));
        additionalAutocompletePopUp = new google.maps.places.SearchBox(searchBoxPopUp);
        // search result depends on map bound
        mapPopUp.addListener('bounds_changed', function () {
            additionalAutocompletePopUp.setBounds(mapPopUp.getBounds());
        });
        additionalAutocompletePopUp.addListener('places_changed', function () {
            newPlacePopUp = additionalAutocompletePopUp.getPlaces()[0];
            if (!newPlacePopUp.geometry) {
                window.alert("Autocomplete's returned place contains no geometry");
                return;
            } else {
                window.setTimeout(function () {
                    if (marker !== undefined && marker !== null) {
                        marker.setMap(null);
                    }

                    marker = new google.maps.Marker({
                        position: newPlacePopUp.geometry.location,
                        map: mapPopUp,
                        title: newPlacePopUp.name
                    });
                    infowindow = new google.maps.InfoWindow({
                        content: $scope.addressDetailTemp.addr
                    });
                    infowindow.open(mapPopUp, marker);
                    mapPopUp.panTo(marker.getPosition());
                }, 300);
                //get address
                $scope.addressDetailTemp.addr = newPlacePopUp.formatted_address;
                $scope.addressDetailTemp.lat = newPlacePopUp.geometry.location.lat();
                $scope.addressDetailTemp.lng = newPlacePopUp.geometry.location.lng();
                //get city and country
                var addressComponents = newPlacePopUp.address_components;
                for (var j = 0, len = addressComponents.length; j < len; j++) {
                    var searchAdd = addressComponents[j];
                    if (searchAdd.types[0] === "locality") {
                        $scope.addressDetailTemp.city = searchAdd["long_name"];
                    } else if (searchAdd.types[0] === "country") {
                        $scope.addressDetailTemp.country = searchAdd["long_name"];
                    }
                }

                $scope.$digest();
            }
        });
        google.maps.event.addListener(mapPopUp, 'click', function (event) {
            if (marker !== undefined && marker !== null) {
                marker.setMap(null);
            }

            marker = new google.maps.Marker({
                position: event.latLng,
                map: mapPopUp,
                title: $scope.addressDetailTemp.addr
            });
            infowindow = new google.maps.InfoWindow({
                content: $scope.addressDetailTemp.addr
            });
            infowindow.open(mapPopUp, marker);
            mapPopUp.panTo(marker.getPosition());
            $scope.addressDetailTemp.lat = event.latLng.lat();
            $scope.addressDetailTemp.lng = event.latLng.lng();
        });
        loaded = true;
        $timeout(function () {
            $(".timeMaskInput").inputmask("h:s", {
                onKeyValidation: function (key, result) {
                    angular.element($(this)).triggerHandler('input');
                }
            });
        }, 100);
    };
    var editMapPopUp = function (lat, lng) {
        mapPopUp = new google.maps.Map(document.getElementById('map-pop-up'), {
            center: new google.maps.LatLng(lat, lng),
            zoom: 17,
            draggable: true
        });
        marker = new google.maps.Marker({
            position: new google.maps.LatLng(lat, lng),
            map: mapPopUp,
            title: $scope.addressDetailTemp.addr
        });
        infowindow = new google.maps.InfoWindow({
            content: $scope.addressDetailTemp.addr
        });
        infowindow.open(mapPopUp, marker);
        mapPopUp.panTo(marker.getPosition());
        // enable autocomplete for first additional input

        searchBoxPopUp = (document.getElementById('additionalAutocompletePopUp'));
        additionalAutocompletePopUp = new google.maps.places.SearchBox(searchBoxPopUp);
        // search result depends on map bound
        mapPopUp.addListener('bounds_changed', function () {
            additionalAutocompletePopUp.setBounds(mapPopUp.getBounds());
        });
        additionalAutocompletePopUp.addListener('places_changed', function () {
            newPlacePopUp = additionalAutocompletePopUp.getPlaces()[0];
            if (!newPlacePopUp.geometry) {
                window.alert("Autocomplete's returned place contains no geometry");
                return;
            } else {
                window.setTimeout(function () {
                    marker.setMap(null);
                    marker = new google.maps.Marker({
                        position: newPlacePopUp.geometry.location,
                        map: mapPopUp,
                        title: newPlacePopUp.name
                    });
                    var infowindow = new google.maps.InfoWindow({
                        content: newPlacePopUp.formatted_address
                    });
                    infowindow.open(mapPopUp, marker);
                    mapPopUp.panTo(marker.getPosition());
                }, 300);
                //get address
                $scope.addressDetailTemp.addr = newPlacePopUp.formatted_address;
                $scope.addressDetailTemp.lat = newPlacePopUp.geometry.location.lat();
                $scope.addressDetailTemp.lng = newPlacePopUp.geometry.location.lng();
                //get city and country
                var addressComponents = newPlacePopUp.address_components;
                for (var j = 0, len = addressComponents.length; j < len; j++) {
                    var searchAdd = addressComponents[j];
                    if (searchAdd.types[0] === "locality") {
                        $scope.addressDetailTemp.city = searchAdd["long_name"];
                    } else if (searchAdd.types[0] === "country") {
                        $scope.addressDetailTemp.country = searchAdd["long_name"];
                    }
                }

                $scope.$digest();
            }
        });
        google.maps.event.addListener(mapPopUp, 'click', function (event) {
            marker.setMap(null);
            marker = new google.maps.Marker({
                position: event.latLng,
                map: mapPopUp,
                title: $scope.addressDetailTemp.addr
            });
            var infowindow = new google.maps.InfoWindow({
                content: $scope.addressDetailTemp.addr
            });
            infowindow.open(mapPopUp, marker);
            mapPopUp.panTo(marker.getPosition());
            $scope.addressDetailTemp.lat = event.latLng.lat();
            $scope.addressDetailTemp.lng = event.latLng.lng();
        });
        loaded = true;
        $timeout(function () {
            $(".timeMaskInput").inputmask("h:s", {
                onKeyValidation: function (key, result) {
                    angular.element($(this)).triggerHandler('input');
                }
            });
        }, 100);
    };
    var promise;
    var loaded = false;
    $scope.$watch('addressDetailTemp.addr', function (newVal, oldVal) {
        $timeout.cancel(promise);
        promise = $timeout(function () {
            if (newVal !== oldVal && loaded) {
                infowindow.close();
                infowindow.setContent($scope.addressDetailTemp.addr);
                infowindow.open(mapPopUp, marker);
            }
        }, 1000);
    }, true);
    $scope.showMissingDataPopUpLocation = false;
    $scope.saveLocationTemp = function () {
        if ($scope.addressDetailTemp.addr !== "" && $scope.addressDetailTemp.content !== "") {
            if (addMode) {
                if (angular.isString($scope.addressDetailTemp.addr) && $scope.addressDetailTemp.addr !== "") {
                    // add to all language
                    for (var i = 0, max = languageDescriptionList.length; i < max; i++) {
                        // get data 
                        var advancedAddress = languageDescriptionList[i].advancedAddress;
                        var newAddr = {"lat": $scope.addressDetailTemp.lat, "lng": $scope.addressDetailTemp.lng,
                            "addr": $scope.addressDetailTemp.addr, "startTime": $scope.addressDetailTemp.startTime, "endTime": $scope.addressDetailTemp.endTime,
                            "content": $scope.addressDetailTemp.content, "country": $scope.addressDetailTemp.country, "city": $scope.addressDetailTemp.city, "accessDescription": $scope.addressDetailTemp.accessDescription};
                        advancedAddress[locationTypeTemp].push(newAddr);
                    }

                    updateMarkerArray();
                    $scope.addressDetailTemp = {"lat": "", "lng": "",
                        "addr": "", "startTime": "", "endTime": "",
                        "content": "", "country": "", "city": "", "accessDescription": ""};
                    searchBoxPopUp.value = "";
                    $("#location-popup").toggleClass("active");
                }
            } else {
                for (var i = 0, max = languageDescriptionList.length; i < max; i++) {
                    var currentAddress = languageDescriptionList[i].advancedAddress[locationTypeTemp][indexTemp];
                    currentAddress.lat = $scope.addressDetailTemp.lat;
                    currentAddress.lng = $scope.addressDetailTemp.lng;
                    currentAddress.startTime = $scope.addressDetailTemp.startTime;
                    currentAddress.endTime = $scope.addressDetailTemp.endTime;
                }
                var currentAddress = $scope.selectedLanguageDescription.advancedAddress[locationTypeTemp][indexTemp];
                currentAddress.addr = $scope.addressDetailTemp.addr;
                currentAddress.content = $scope.addressDetailTemp.content;
                currentAddress.country = $scope.addressDetailTemp.country;
                currentAddress.city = $scope.addressDetailTemp.city;
                currentAddress.accessDescription = $scope.addressDetailTemp.accessDescription;
                updateMarkerArray();
                $scope.addressDetailTemp = {"lat": "", "lng": "",
                    "addr": "", "startTime": "", "endTime": "",
                    "content": "", "country": "", "city": "", "accessDescription": ""};
                searchBoxPopUp.value = "";
                $("#location-popup").toggleClass("active");
            }
        } else {
            $scope.showMissingDataPopUpLocation = true;
        }

    };
    var locationTypeTemp, indexTemp;
    $scope.editLocation = function (index, locationType) {
        var currentAddress = $scope.selectedLanguageDescription.advancedAddress[locationType][index];
        $scope.addressDetailTemp.lat = currentAddress.lat;
        $scope.addressDetailTemp.lng = currentAddress.lng;
        $scope.addressDetailTemp.addr = currentAddress.addr;
        $scope.addressDetailTemp.startTime = currentAddress.startTime;
        $scope.addressDetailTemp.endTime = currentAddress.endTime;
        $scope.addressDetailTemp.content = currentAddress.content;
        $scope.addressDetailTemp.country = currentAddress.country;
        $scope.addressDetailTemp.city = currentAddress.city;
        $scope.addressDetailTemp.accessDescription = currentAddress.accessDescription;
        $("#location-popup").toggleClass("active");
        setTimeout(function () {
            editMapPopUp(currentAddress.lat, currentAddress.lng);
            addMode = false;
            locationTypeTemp = locationType;
            indexTemp = index;
        }, 100);
    };
    $scope.deleteLocation = function (index, locationType) {
        for (var i = 0, max = languageDescriptionList.length; i < max; i++) {
            languageDescriptionList[i].advancedAddress[locationType].splice(index, 1);
        }

    };
    function changeLatLngOffAllLanguage(lat, lng, type, index) {
        if (lat !== "" && lng !== "") {
            for (var i = 0, max = languageDescriptionList.length; i < max; i++) {
                var advancedAddress = languageDescriptionList[i].advancedAddress;
                advancedAddress[type][index].lat = lat;
                advancedAddress[type][index].lng = lng;
            }
        }
    }

    // get geolocation for map
    $scope.mapLoaded = false;
    $scope.getGeolocation = function () {
        $scope.mapLoaded = false;
        var data = '{"wifiAccessPoints":[{"macAddress": "' + macAddress + '","signalStrength": -65,"age": 0,"channel": 11,"signalToNoiseRatio": 40}]}';
        $http.post("https://www.googleapis.com/geolocation/v1/geolocate?key=AIzaSyAuVQ5-7Rvuw8JCLTLoSOCQvow11BAdEZg", JSON.parse(data))
                .then(function successCallback(response) {
                    currentLocation = response.data.location;
                    initMap();
                }, function errorCallback(response) {
                    $(location).attr('href', ERROR_PAGE);
                });
    };
    // when adding new location from search
    $scope.addNewLocation = function (selectedLocationType) {
        var searchAddr = searchBox.value;
        if (angular.isString(searchAddr) && searchAddr !== "") {
            // add to all language
            for (var i = 0, max = languageDescriptionList.length; i < max; i++) {
                // get data 
                var advancedAddress = languageDescriptionList[i].advancedAddress;
                var searchLat = newPlace.geometry.location.lat();
                var searchLng = newPlace.geometry.location.lng();
                var country = "", city = "";
                // get country and city from search result
                var addressComponents = newPlace.address_components;
                for (var j = 0, len = addressComponents.length; j < len; j++) {
                    var searchAdd = addressComponents[j];
                    if (searchAdd.types[0] === "locality") {
                        city = searchAdd["long_name"];
                    } else if (searchAdd.types[0] === "country") {
                        country = searchAdd["long_name"];
                    }
                }

                // construct new Address json
                var newAddr = {"lat": searchLat, "lng": searchLng,
                    "addr": searchAddr, "startTime": "", "endTime": "",
                    "content": "", country: country, city: city};
                advancedAddress[selectedLocationType].push(newAddr);
            }
//            searchBox.value = "";
//            updateMarkerArray();

            // update mask input
            $timeout(function () {
                $(".timeMaskInput").inputmask("h:s", {
                    onKeyValidation: function (key, result) {
                        angular.element($(this)).triggerHandler('input');
                    }
                });
            }, 100);
        }
    };
    $scope.removeLocation = function (index, selectedLocationType) {
        if (angular.isString($scope.selectedMarker)) {
            var markerObj = $.parseJSON($scope.selectedMarker);
            if (index === markerObj["position"] && selectedLocationType === markerObj["kindOfMarker"]) {
                $scope.selectedMarker = null;
            }
        }

        // remove from all language
        for (var i = 0, max = languageDescriptionList.length; i < max; i++) {
            var advancedAddress = languageDescriptionList[i].advancedAddress;
            advancedAddress[selectedLocationType].splice(index, 1);
        }
        updateMarkerArray();
    };
    var fillInforWindow = function (place, infowindow, map, marker) {
        infowindow.setContent('<div>' + place + '</div>');
        infowindow.open(map, marker);
    };
    var markers = [], windows = [], packagePath, departurePath, pickupPath, bounds;
    function updateMarkerArray() { // update marker arrays and change map view
        // first delete old markers
        if (markers.length > 0) {
            for (var i = 0, max = markers.length; i < max; i++) {
                markers[i].setMap(null);
                windows[i].close();
            }
            markers = [];
            windows = [];
            angular.isObject(packagePath) ? packagePath.setMap(null) : 0;
            angular.isObject(departurePath) ? departurePath.setMap(null) : 0;
            angular.isObject(pickupPath) ? pickupPath.setMap(null) : 0;
        }

        // init marker array
        var actionLocations = $scope.selectedLanguageDescription.advancedAddress.action;
        var actionLength = actionLocations.length;
        if (actionLength > 0) { // if have addtional markers

            var path = [];
            for (var i = 0; i < actionLength; i++) { // loop addtional markers
                var actionLocation = actionLocations[i];
                if (angular.isObject(actionLocation)) {

                    // create new marker
                    var lat = actionLocation.lat;
                    var lng = actionLocation.lng;
                    if (lat !== "" && lng !== "") {
                        var latlng = new google.maps.LatLng(lat, lng);
                        var markerObj = new google.maps.Marker({
                            map: map,
                            position: latlng
                        });
                        markerObj.setIcon('http://youtripper.com/Images/Icon/blue-marker.svg');
                        markers.push(markerObj);
                        // create new window
                        var window = new google.maps.InfoWindow({
                            maxWidth: 200
                        });
                        windows.push(window);
                        fillInforWindow("<strong>Package location " + (i + 1) + ": </strong>" + actionLocation.addr,
                                window, map, markerObj);
                        // add new point to path
                        path.push(latlng);
                    }
                }
            }

            // draw line betweens package
            packagePath = new google.maps.Polyline({
                path: path,
                geodesic: true,
                strokeColor: '#3FC1C9',
                strokeOpacity: 1.0,
                strokeWeight: 2
            });
            packagePath.setMap(map);
        }

        var pickupLocations = $scope.selectedLanguageDescription.advancedAddress.pickup;
        var pickupLength = pickupLocations.length;
        if (pickupLength > 0) { // if have addtional markers
            var path = [];
            for (var i = 0; i < pickupLength; i++) { // loop addtional marrkers
                var pickupLocation = pickupLocations[i];
                if (angular.isObject(pickupLocation)) {

                    // crate new marker
                    var lat = pickupLocation.lat;
                    var lng = pickupLocation.lng;
                    if (lat !== "" && lng !== "") {
                        var latlng = new google.maps.LatLng(lat, lng);
                        var markerObj = new google.maps.Marker({
                            map: map,
                            position: latlng
                        });
                        markerObj.setIcon('http://youtripper.com/Images/Icon/orange-marker.svg');
                        markers.push(markerObj);
                        // create new window
                        var window = new google.maps.InfoWindow({
                            maxWidth: 200
                        });
                        windows.push(window);
                        fillInforWindow("<strong>Pickup location " + (i + 1) + ": </strong>" + pickupLocation.addr,
                                window, map, markerObj);
                        // add new point to path
                        path.push(latlng);
                    }
                }
            }
            // draw line betweens package
            pickupPath = new google.maps.Polyline({
                path: path,
                geodesic: true,
                strokeColor: '#FBB03B',
                strokeOpacity: 1.0,
                strokeWeight: 2
            });
            pickupPath.setMap(map);
        }

        var departureLocations = $scope.selectedLanguageDescription.advancedAddress.departure;
        var departureLength = departureLocations.length;
        if (departureLength > 0) { // if have addtional markers
            var path = [];
            for (var i = 0; i < departureLength; i++) { // loop addtional marrkers
                var departureLocation = departureLocations[i];
                if (angular.isObject(departureLocation)) {

                    // crate new marker
                    var lat = departureLocation.lat;
                    var lng = departureLocation.lng;
                    if (lat !== "" && lng !== "") {
                        var latlng = new google.maps.LatLng(lat, lng);
                        var markerObj = new google.maps.Marker({
                            map: map,
                            position: latlng
                        });
                        markerObj.setIcon('http://youtripper.com/Images/Icon/red-marker.svg');
                        markers.push(markerObj);
                        // create new window
                        var window = new google.maps.InfoWindow({
                            maxWidth: 200
                        });
                        windows.push(window);
                        fillInforWindow("<strong>Departure location " + (i + 1) + ": </strong>" + departureLocation.addr,
                                window, map, markerObj);
                        // add new point to path
                        path.push(latlng);
                    }
                }
            }

            // draw line betweens package
            departurePath = new google.maps.Polyline({
                path: path,
                geodesic: true,
                strokeColor: '#FF514E',
                strokeOpacity: 1.0,
                strokeWeight: 2
            });
            departurePath.setMap(map);
        }


        // modify map view to see all markers
        bounds = new google.maps.LatLngBounds();
        for (var i = 0; i < markers.length; i++) {
            bounds.extend(markers[i].getPosition());
        }
//        $scope.bounds.extend($scope.mainMarker.getPosition());
        if (markers.length > 0) {
            map.fitBounds(bounds);
        }

        // add window for main location
//        $scope.mainInfowindow.close();
//        $scope.fillInforWindow("<strong>Main Package Location</strong>", $scope.mainInfowindow, $scope.map, $scope.mainMarker);
    }

    // TAGS

    $scope.paramLanguageID;
    function checkSelectedLanguage() {
        if (paramLanguage === '') {
            paramLanguage = 'en';
        }

        // get  language code
        var languageList = $scope.packageForm.languageList;
        var selectedLanguageID;
        for (var i = 0, max = languageList.length; i < max; i++) {
            var language = languageList[i];
            if (language.languageCode === paramLanguage) {
                selectedLanguageID = language.languageID;
                break;
            }
        }

        $scope.paramLanguageID = selectedLanguageID;

        // check th language is exist in list or not
        // add new description for all exsiting language
        var languageDescription;
        for (var i = 0, max = languageDescriptionList.length; i < max; i++) {
            var singleLanguageDescription = languageDescriptionList[i];
            var languageID = singleLanguageDescription.languageID;
            if (languageID === selectedLanguageID) {
                languageDescription = singleLanguageDescription;
                languageDescriptionList.splice(i, 1);
                break;
            }
        }

        // new language if not exist
        if (!angular.isObject(languageDescription)) {
            // new language
            languageDescription = {"packageID": $scope.package.id, "languageID": selectedLanguageID};

            languageDescription["description"] = [];
            var advancedDescriptionLen = englishDescription.description.length;
            for (var i = 0; i < advancedDescriptionLen; i++) {
                var signleDescription = {"header": "", "description": ""};
                languageDescription["description"].push(signleDescription);
            }

            // get list amenities of current version and then clone to new language
            var englishLanguageID = englishDescription.languageID;
            for (var i = 0, max = $scope.amenitiesClassifiers.length; i < max; i++) {
                var amenities = $scope.amenitiesClassifiers[i];
                if (amenities.languageID === englishLanguageID) {
                    var amenitiesClassifier = {"temporaryPackageID": $scope.package.id, "amenitiesID": amenities.amenitiesID, "amenitiesName": amenities.amenitiesName,
                        "amenitiesIcon": amenities.amenitiesName, "description": "", "languageID": selectedLanguageID};
                    $scope.amenitiesClassifiers.push(amenitiesClassifier);
                }
            }

            // get all address of current version and then clone to new language
            var newAdvancedAdresses = {"action": [], "departure": [], "pickup": []};
            languageDescription["advancedAddress"] = newAdvancedAdresses;
            var advancedAddress = englishDescription["advancedAddress"];
            // clone action address
            var actionAddresses = advancedAddress["action"];
            for (var j = 0, len = actionAddresses.length; j < len; j++) {
                //get
                var actionAddress = actionAddresses[j];
                var newAddr = {"lat": actionAddress.lat, "lng": actionAddress.lng,
                    "addr": actionAddress.addr, "startTime": actionAddress.startTime, "endTime": actionAddress.endTime,
                    "content": "", "country": actionAddress.country, "city": actionAddress.city};
                if (actionAddress["accessDescription"] !== undefined) {
                    newAddr["accessDescription"] = "";
                }
                // add
                newAdvancedAdresses["action"].push(newAddr);
            }

            // clone departure address
            var departureAddresses = advancedAddress["departure"];
            for (var j = 0, len = departureAddresses.length; j < len; j++) {
                //get
                var departureAddress = departureAddresses[j];
                var newAddr = {"lat": departureAddress.lat, "lng": departureAddress.lng,
                    "addr": departureAddress.addr, "startTime": departureAddress.startTime, "endTime": departureAddress.endTime,
                    "content": "", "country": departureAddress.country, "city": departureAddress.city};
                if (departureAddress["accessDescription"] !== undefined) {
                    newAddr["accessDescription"] = "";
                }
                // add
                newAdvancedAdresses["departure"].push(newAddr);
            }

            // clone pcickup adress
            var pickupAddresses = advancedAddress["pickup"];
            for (var j = 0, len = pickupAddresses.length; j < len; j++) {
                //get
                var pickupAddress = pickupAddresses[j];
                var newAddr = {"lat": pickupAddress.lat, "lng": pickupAddress.lng,
                    "addr": pickupAddress.addr, "startTime": pickupAddress.startTime, "endTime": pickupAddress.endTime,
                    "content": "", "country": pickupAddress.country, "city": pickupAddress.city};
                if (pickupAddress["accessDescription"] !== undefined) {
                    newAddr["accessDescription"] = "";
                }
                // add
                newAdvancedAdresses["pickup"].push(newAddr);
            }

        }

        // add to begining of array
        languageDescriptionList.unshift(languageDescription);

        $scope.showLanguageDescription(selectedLanguageID);
    }

    checkSelectedLanguage();

    // when a new language is added
    $scope.addNewLanguage = function () {
        if ($scope.selectedLanguageID !== 0) {
            var newLanguageDescription = {"packageID": $scope.package.id, "languageID": $scope.selectedLanguageID};
            languageDescriptionList.push(newLanguageDescription);
            // construct list of description
            newLanguageDescription["description"] = [];
            var advancedDescriptionLen = englishDescription.description.length;
            for (var i = 0; i < advancedDescriptionLen; i++) {
                var signleDescription = {"header": "", "description": ""};
                newLanguageDescription["description"].push(signleDescription);
            }

            // get list amenities of current version and then clone to new language
            var languageID = $scope.selectedLanguageDescription.languageID;
            for (var i = 0, max = $scope.amenitiesClassifiers.length; i < max; i++) {
                var amenities = $scope.amenitiesClassifiers[i];
                if (amenities.languageID === languageID) {
                    var amenitiesClassifier = {"temporaryPackageID": $scope.package.id, "amenitiesID": amenities.amenitiesID, "amenitiesName": amenities.amenitiesName,
                        "amenitiesIcon": amenities.amenitiesName, "description": "", "languageID": $scope.selectedLanguageID};
                    $scope.amenitiesClassifiers.push(amenitiesClassifier);
                }
            }

            // get all address of current version and then clone to new language
            var newAdvancedAdresses = {"action": [], "departure": [], "pickup": []};
            newLanguageDescription["advancedAddress"] = newAdvancedAdresses;
            var advancedAddress = $scope.selectedLanguageDescription["advancedAddress"];
            // clone action address
            var actionAddresses = advancedAddress["action"];
            for (var j = 0, len = actionAddresses.length; j < len; j++) {
                //get
                var actionAddress = actionAddresses[j];
                var newAddr = {"lat": actionAddress.lat, "lng": actionAddress.lng,
                    "addr": actionAddress.addr, "startTime": actionAddress.startTime, "endTime": actionAddress.endTime,
                    "content": "", "country": actionAddress.country, "city": actionAddress.city};
                if (actionAddress["accessDescription"] !== undefined) {
                    newAddr["accessDescription"] = "";
                }
                // add
                newAdvancedAdresses["action"].push(newAddr);
            }

            // clone departure address
            var departureAddresses = advancedAddress["departure"];
            for (var j = 0, len = departureAddresses.length; j < len; j++) {
                //get
                var departureAddress = departureAddresses[j];
                var newAddr = {"lat": departureAddress.lat, "lng": departureAddress.lng,
                    "addr": departureAddress.addr, "startTime": departureAddress.startTime, "endTime": departureAddress.endTime,
                    "content": "", "country": departureAddress.country, "city": departureAddress.city};
                if (departureAddress["accessDescription"] !== undefined) {
                    newAddr["accessDescription"] = "";
                }
                // add
                newAdvancedAdresses["departure"].push(newAddr);
            }

            // clone pcickup adress
            var pickupAddresses = advancedAddress["pickup"];
            for (var j = 0, len = pickupAddresses.length; j < len; j++) {
                //get
                var pickupAddress = pickupAddresses[j];
                var newAddr = {"lat": pickupAddress.lat, "lng": pickupAddress.lng,
                    "addr": pickupAddress.addr, "startTime": pickupAddress.startTime, "endTime": pickupAddress.endTime,
                    "content": "", "country": pickupAddress.country, "city": pickupAddress.city};
                if (pickupAddress["accessDescription"] !== undefined) {
                    newAddr["accessDescription"] = "";
                }
                // add
                newAdvancedAdresses["pickup"].push(newAddr);
            }


            // change to new language description
            $scope.selectedLanguageDescription = newLanguageDescription;
            $scope.toggleLanguageBox();
        }
    };
    function validateDescriptionInput() {
        var checkDescriptionFlag = false;
        angular.forEach(languageDescriptionList, function (languageDescription) {
            if (angular.isUndefined(languageDescription.packageName) || languageDescription.packageName === '' ||
                    angular.isUndefined(languageDescription.googleDescription) || languageDescription.googleDescription === '' ||
                    languageDescription.description[0].description === '' || languageDescription.description[0].header === '' ||
                    languageDescription.advancedAddress.action.length === 0 || languageDescription.advancedAddress.action[0].content === "") {
                checkDescriptionFlag = true;
            }

        });
        if (!checkDescriptionFlag) {
            return true;
        }
        return false;
    }

    function getDescriptionData() {
        var country = "";
        var city = "";
        if (languageDescriptionList[0].advancedAddress["action"].length > 0) {
            country = languageDescriptionList[0].advancedAddress["action"][0]["country"];
            city = languageDescriptionList[0].advancedAddress["action"][0]["city"];
        }

        var languageDescriptionsData = [];
        for (var i = 0, max = languageDescriptionList.length; i < max; i++) {
            var languageDescription = languageDescriptionList[i];
            var languageDescriptionData = {"languageID": languageDescription.languageID, "packageName": languageDescription.packageName,
                "googleDescription": languageDescription.googleDescription, "language": JSON.stringify(languageDescription.language),
                "description": JSON.stringify(languageDescription.description),
                "advancedAddress": JSON.stringify(languageDescription.advancedAddress), "keywords": JSON.stringify(languageDescription.keywords)};
            languageDescriptionsData.push(languageDescriptionData);
        }
        console.log(languageDescriptionsData);
        var data = {"packageID": $scope.package.id, "descriptions": languageDescriptionsData, "amenitiesClassifier": $scope.amenitiesClassifiers,
            "certificates": $scope.package.certificates, "country": country, "city": city};
        return data;
    }

    $scope.removeLanguage = function (langID) {
        angular.forEach(languageDescriptionList, function (lang, langIndex) {
            if (lang.languageID === langID) {
                languageDescriptionList.splice(langIndex, 1);
                if (langIndex === 0) {
                    $scope.selectedLanguageDescription = languageDescriptionList[1];
                } else if (langIndex > 0 && langIndex <= languageDescriptionList.length) {
                    $scope.selectedLanguageDescription = languageDescriptionList[languageDescriptionList.length - 1];
                }

//                $scope.selectedLanguageDescription.languageID = 40;
            }
        });
    };
    $scope.$watch('selectedLanguageDescription.keywords', function (newVal, oldVal) {
        if (angular.isDefined($scope.selectedLanguageDescription.keywords)) {
            if ($scope.selectedLanguageDescription.keywords.length > 9) {
                $scope.selectedLanguageDescription.keywords.splice(9, 1);
            }
        }
    }, true);
    $scope.$watch('selectedLanguageDescription.language', function (newVal, oldVal) {
        if (angular.isDefined($scope.selectedLanguageDescription.language)) {
            if ($scope.selectedLanguageDescription.language.length > 9) {
                $scope.selectedLanguageDescription.language.splice(9, 1);
            }
        }
    }, true);
    /* END DESCRIPTION SECTION */

    /* PHOTOS SECTION */
    function validatePhotosInput() {
        if (angular.isString($scope.package.coverImage) && $scope.package.coverImage !== "" && $scope.coverImageSuccess === true) {
            return true;
        } else {
            return false;
        }
    }

    var TEMP_COVER_URL = service.getContextPath() + "/Provider/TemporaryCoverImage";
    function getPhotoForm() {
        return {"packageID": $scope.package.id, "coverImage": $scope.package.coverImage,
            "additionalImages": JSON.stringify($scope.package.images), "coverPosition": $scope.package.coverPosition};
    }

    $scope.currentTime = new Date().getTime();
    $scope.coverImageSuccess = true;
    $scope.package.images = $.parseJSON($scope.package.images);
    $scope.$watch('addingImage', function () {
        if ($scope.addingImage !== undefined && $scope.addingImage !== null) {
            if ($scope.additionalImages) {
                $scope.uploadAddiionImages($scope.addingImage);
            } else {
                alert("Your addition images are uploading!");
            }
        }
    });
    $scope.additionalImages = true;
    $scope.$watch('coverImage', function (newVal, oldVal) {
        if (newVal !== oldVal) {
            if ($scope.coverImage !== undefined && $scope.coverImage !== null) {
                $scope.uploadCoverImage($scope.coverImage);
            }
        }
    });
    $scope.uploadCoverImage = function (coverImage) {
        $scope.coverImageSuccess = false;
        $scope.package.coverImage = "";
        var oMyForm = new FormData();
        oMyForm.append("coverImage", coverImage);
        oMyForm.append("temporaryPackageID", $scope.package.id);
        $.ajax({
            url: uploadCoverImageUrl,
            data: oMyForm,
            dataType: 'text',
            processData: false,
            contentType: false,
            type: 'POST',
            beforeSend: function (jqXHR, settings) {
                $("#coverImage").css("background", '#fff url(' + service.getContextPath() + '/Images/Icon/loading.gif) no-repeat center');
            },
            success: function (data) {
                if (data.result !== "error") {

                    $scope.currentTime = new Date().getTime();
                    $("#coverImage img").attr("src", TEMP_COVER_URL + "?time=" + $scope.currentTime);
                    $scope.package.coverImage = TEMP_COVER_URL + "?time=" + $scope.currentTime;
                    $scope.package.coverPosition = 0;
                    $scope.coverImageSuccess = true;
                    $scope.$digest();
                } else {
                    alert("Wrong input!");
                }


            }, error: function (respone) {
                alert("Error");
            }
        });
    };
    $scope.uploading = false;
    $scope.uploadAddiionImages = function (additionalImages) {
        $scope.additionalImages = false;
        $scope.uploading = true;
        $scope.uploadValue = 0;
        var percent = 100 / additionalImages.length;
        var count = 0;
        for (var i = 0; i < additionalImages.length; i++) {

            var oMyForm = new FormData();
            oMyForm.append("additionalImages[]", additionalImages[i]);
            oMyForm.append("imagesJson", JSON.stringify($scope.package.images));
            oMyForm.append("temporaryPackageID", $scope.package.id);
            $.ajax({
                url: uploadAdditionalImagesUrl,
                data: oMyForm,
                dataType: 'text',
                processData: false,
                contentType: false,
                type: 'POST',
                beforeSend: function (jqXHR, settings) {
                },
                success: function (data) {
                    if (data.result !== "error") {
                        count = count + 1;
                        $scope.currentTime = new Date().getTime();
                        $scope.package.images.push(JSON.parse(data)[0]);
                        $scope.uploadValue = percent * count;
                    } else {
                        alert("Wrong input!");
                    }
                    $scope.additionalImages = true;
                    if (count === additionalImages.length) {
                        $scope.uploading = false;
                    }
                    $scope.$digest();
                }, error: function (respone) {
                    alert("Error");
                }
            });
        }
        ;
    };
    $scope.imagedeleting = false;
    $scope.deleteAdditionalImage = function (name, position) {
        $scope.package.images.splice(position, 1);
        var data = {"deletedImage": name.image, "images": $scope.package.images, "packageID": $scope.package.id, "deletedPosition": position};
        $http.post(deleteAdditionalImageUrl, data)
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                    }
                });
    };
    // detect window resize to fit banner
    $(window).resize(function () {
        $scope.resizeBanner();
    });
    // function to resize banner
    $scope.resizeBanner = function () {
        var width = $("#coverImage").width();
        var height = width * 540 / 1350;
        $("#coverImage").height(height);
    };
    $scope.isEditing = false;
    $scope.initiatePhotoForm = function () {
        $timeout(function () {
            // resize banner
            $scope.resizeBanner();
            // enable dragable image inside cover
            // define range to drag
            $scope.initiateDrag(true);
            // then disable, just enable drag when edit opion is selected
            $(".packageCoverImage").draggable("disable");
            // set position from database
            $("img.packageCoverImage").css("top", $scope.package.coverPosition);
        }, 300);
    };
    $scope.initiateDrag = function (initiate) {
        // get containment for draggable
        var left = $("#coverImage").offset().left;
        var top = $("#coverImage").offset().top;
        var parentHeight = $("#coverImage").outerHeight();
        var coverHeight = $(".packageCoverImage").height();
        var containmentY1 = parentHeight - coverHeight + top;
        if (initiate) { // if initate not change opption
            // create grabble for the first time
            $(".packageCoverImage").draggable({
                containment: [left, containmentY1, left, top],
                cursor: "all-scroll",
                refreshPositions: true,
                scroll: false,
                snap: false});
        } else {
            $(".packageCoverImage").draggable("option", {
                containment: [left, containmentY1, left, top]
            });
        }
    };
    // enable Dragable
    $scope.turnOnDrag = function () {
        // change option
        $scope.initiateDrag(false);
        // enable dragable
        $(".packageCoverImage").draggable("enable");
        $scope.isEditing = true;
    };
    // disable Draggable
    $scope.disableDrag = function () {
        $scope.isEditing = false;
        // then disable, just enable drag when edit opion is selected
        $(".packageCoverImage").draggable("disable");
        // get position of vertical
//        alert($(".packageCoverImage").offset().top - $("#coverImage").offset().top);
        $scope.package.coverPosition = $(".packageCoverImage").offset().top - $("#coverImage").offset().top;
    };
    $scope.$watch("package.coverPosition", function (newVal, oldVal) {
        if (newVal !== oldVal) {
            $("img.packageCoverImage").css("top", newVal);
        }
    });
    $scope.checkImageUploaded = function () {
        if ($scope.package.coverImage !== null && $scope.package.coverImage !== undefined && $scope.package.coverImage !== '' && $scope.coverImageSuccess) {
            return true;
        }
        return false;
    };
    $scope.showEditImageText = function () {
        var result;
        if ($scope.package.coverImage !== null && $scope.package.coverImage !== undefined && $scope.package.coverImage !== '') {
            result = 'Move';
        } else {
            result = 'Edit';
        }
        return result;
    };
    /* END PHOTOS SECTION */

    /* BOOKING SECTION */
    if ($scope.package.maxQuota <= 0) {
        $scope.package.maxQuota = null;
    }

    // convert to json
//    $scope.package.unavailableDays = JSON.parse($scope.package.unavailableDays);
    // for show place holder
    $scope.package.minTripper === 0 ? $scope.package.minTripper = null : 0;
    $scope.package.maxTripper === 0 ? $scope.package.maxTripper = null : 0;
    $scope.package.minimumResources === 0 ? $scope.package.minimumResources = null : 0;
    $scope.package.duration === 0 ? $scope.package.duration = null : 0;
    $scope.package.resourceID === 0 ? $scope.package.resourceID = null : 0;
    $scope.package.servingPeriodID === 0 ? $scope.package.servingPeriodID = null : 0;
    $scope.fixedType = 'hours';
    $scope.package.fixedType = 'hours';
    if ($scope.package.fixedMinute > 0) {
        $scope.fixedType = 'minutes';
    } else {
        $scope.package.fixedMinute = null;
    }

//    if ($scope.package.fixedHour <= 0) {
//        $scope.package.fixedHour = null;
//    }

    // convert providerresoucres to hash map
    $scope.providerResourceHashmap = {};

    // duration Type
    $scope.changeDurationType = function (durationType) {
        tempPackageType = durationType;
        $('#bookingSaveBox').toggleClass('active');
    };

    $scope.isWorkingEveryday = function () {
        $scope.package.isWorkingEveryday = true;
        $scope.package.isMonthlyDays = false;
        $scope.package.isSpecificSlots = false;

    };
    $scope.isMonthlyDays = function () {
        $scope.package.isWorkingEveryday = false;
        $scope.package.isMonthlyDays = true;
        $scope.package.isSpecificSlots = false;
    };
    $scope.isSpecificSlots = function () {
        $scope.package.isWorkingEveryday = false;
        $scope.package.isMonthlyDays = false;
        $scope.package.isSpecificSlots = true;
        if ($scope.package.tempSpecificDateSlots.length === 0) {
            var newSlot = {"dateStr": "", "dateInMilliseconds": 0, "maxQuota": "", "tempPackageID": $scope.package.id};
            $scope.package.tempSpecificDateSlots.push(newSlot);
        }

    };

    $scope.providerServingPeriods = {};
    function changeServingPeriodsToHashmap() {
        $scope.providerServingPeriods = {};
        for (var i = 0, max = $scope.packageForm.servingPeriods.length; i < max; i++) {
            var period = $scope.packageForm.servingPeriods[i];
            $scope.providerServingPeriods[period.id] = period;
        }
    }


    changeServingPeriodsToHashmap();
    $scope.setIsFreeBooking = function () {
        if ($scope.package.isFreeBooking !== isFreeBookingValue && isFreeBookingValue === true) {
            $scope.package.isFreeBooking = isFreeBookingValue;
            $scope.package.fixedMinute = $scope.package.durationHour;
            $scope.package.fixedHour = $scope.package.durationMinute;
            $scope.package.freeInterval = 15;
            $scope.package.maxQuota = 1;
            $scope.package.noLimit = 1;
        } else if ($scope.package.isFreeBooking !== isFreeBookingValue && isFreeBookingValue === false && $scope.package.durationHour > 0) {
            $scope.package.isFreeBooking = isFreeBookingValue;
            $scope.package.fixedMinute = $scope.package.durationHour;
            $scope.package.fixedHour = $scope.package.durationMinute;
            $scope.package.tempSpecificTimeSlots = [];
        }
        $('#changeScheduleBox').toggleClass('active');
    };

    var isFreeBookingValue = false;
    $scope.showChangeScheduleBox = function (isFree) {
        if ($scope.package.isFreeBooking !== isFree && isFree === true) {
            $('#changeScheduleBox').toggleClass('active');
            isFreeBookingValue = true;
        } else if ($scope.package.isFreeBooking !== isFree && isFree === false && $scope.package.durationHour > 0) {
            $('#changeScheduleBox').toggleClass('active');
            isFreeBookingValue = false;
        }
    };

    $scope.closeChangeScheduleBox = function () {
        $('#changeScheduleBox').toggleClass('active');
    };

    $scope.changePackageType = function (packageType) {
        if (packageType !== $scope.package.packageType) {
            $scope.package.packageType = packageType;
            if (packageType === "Personal") {
                $scope.package.minTripper = 1;
            } else if (packageType === "Group") {
                $scope.package.minTripper = 5;
            } else {
                $scope.package.minTripper = null;
            }
            $scope.package.maxTripper = null;
        }
        if ($scope.package.minTripper < 1) {
            $scope.package.minTripper = 1;
        }
        if ($scope.package.maxTripper < 5) {
            $scope.package.maxTripper = 5;
        }
    };

    if ($scope.package.minTripper < 1) {
        $scope.package.minTripper = 1;
    }


    Date.prototype.ddMMyyyy = function () {
        var yyyy = this.getFullYear().toString();
        var mm = (this.getMonth() + 1).toString(); // getMonth() is zero-based
        var dd = this.getDate().toString();
        return (dd[1] ? dd : "0" + dd[0]) + "/" + (mm[1] ? mm : "0" + mm[0]) + "/" + yyyy; // padding
    };

    Date.prototype.MMddyyyy = function () {
        var yyyy = this.getFullYear().toString();
        var mm = (this.getMonth() + 1).toString(); // getMonth() is zero-based
        var dd = this.getDate().toString();
        return  (mm[1] ? mm : "0" + mm[0]) + "/" + (dd[1] ? dd : "0" + dd[0]) + "/" + yyyy; // padding
    };
    $scope.package.operationsCycles = [];
    var newCycle = {"cycleID": 0, "packageID": 0, "startDate": "", "endDate": ""};
    $scope.package.operationsCycles.push(newCycle);
    Date.prototype.HHmm = function () {
        var HH = this.getHours().toString();
        var MM = this.getMinutes().toString();
        return (HH[1] ? HH : "0" + HH[0]) + ":" + (MM[1] ? MM : "0" + MM[0]); // padding
    };

    Date.prototype.HH = function () {
        var HH = this.getHours().toString();
        return (HH[1] ? HH : "0" + HH[0]);
    }

    // construct time schedule table
    var MAX_NO_SLOTS = 6;
    var currentSlot = 0;
    var noShownSlots;
    $scope.initTimeScheduleTable = function (isWorking) {
        var totalNoSlots = 0;
        noShownSlots = MAX_NO_SLOTS;
        currentSlot = 0;

        var selectedOperatingTime = $scope.providerServingPeriods[$scope.package.servingPeriodID];
        // get time in string
        var startTimeStr = selectedOperatingTime.startOperationTime;
        var endTimeStr = selectedOperatingTime.endOperationTime;

        // convert to Date object
        var startTime = new Date("10/07/1993 " + startTimeStr);
        var startTimeInMinutes = startTime.getHours() * 60;

        startTime.setMinutes(0);
        startTime.setSeconds(0);
        var endTime = new Date("10/07/1993 " + endTimeStr);
        endTime.setMinutes(0);
        endTime.setSeconds(0);

        // construct column and header
        var timeColHtml = "";
        var timeHeaderHtml = "";
        while (startTime <= endTime) {
            timeColHtml += "<li></li>";
            timeHeaderHtml += "<li>" + startTime.HHmm() + "<span  class='grey-plus-btn inline-btn' hourData='" + startTime.HH() + "' columnNo='" + totalNoSlots + "'></span></li>";
            totalNoSlots++;
            startTime.setHours(startTime.getHours() + 1);
        }

        // insert to table
        $("#time-schedule-tb .time-col").html(timeColHtml);
        $("#time-schedule-tb .time-header").html(timeHeaderHtml);

        // calculate width of column
        if (totalNoSlots < MAX_NO_SLOTS) {
            noShownSlots = totalNoSlots;
        }
        var timeColWidth = $("#time-schedule-tb .tb-container")[0].getBoundingClientRect().width / noShownSlots;
        $("#time-schedule-tb .time-col > li, #time-schedule-tb .time-header > li").css("width", timeColWidth);

        var widthPerMinute = timeColWidth / 60;
        var slotWidth = ($scope.package.durationHour * 60 + $scope.package.durationMinute) * widthPerMinute - 2;

        // construct html of time slots
        var advancedSlotRows = [];
        var specificTimeSlots = $scope.package.tempSpecificTimeSlots;
        var timeSlotsLen = specificTimeSlots.length;
        for (var i = 0; i < timeSlotsLen; i++) {
            var timeSlot = specificTimeSlots[i];
            var timeSlotInMinutes = timeSlot.timeInMinutes;

            var slotLeftPosition = (timeSlotInMinutes - startTimeInMinutes) * widthPerMinute;
            var slotRightPosition = slotLeftPosition + slotWidth;

            var enableRowNo = -1;
            var noAdvSlotRows = advancedSlotRows.length;
            for (var j = 0; j < noAdvSlotRows; j++) {
                var isEnable = true;
                var advancedSlots = advancedSlotRows[j];
                var noAdvancedSlots = advancedSlots.length;
                for (var k = 0; k < noAdvancedSlots; k++) {
                    var advancedSlot = advancedSlots[k];
                    var advancedSlotLeftPosition = advancedSlot.leftPosition;
                    var advancedSlotRightPosition = advancedSlot.rightPosition;

                    if ((slotLeftPosition >= advancedSlotLeftPosition && slotLeftPosition <= advancedSlotRightPosition) ||
                            (slotRightPosition >= advancedSlotLeftPosition && slotRightPosition <= advancedSlotRightPosition)) {
                        isEnable = false;
                        break;
                    }
                }

                if (isEnable) {
                    enableRowNo = j;
                    break;
                }
            }

            // get enable row to insert
            var enableAvancedRow;
            if (enableRowNo < 0) {
                enableAvancedRow = [];
                advancedSlotRows.push(enableAvancedRow);
            } else {
                enableAvancedRow = advancedSlotRows[enableRowNo];
            }

            // insert new slot
            var newAdvancedSlot = {};
            newAdvancedSlot["leftPosition"] = slotLeftPosition;
            newAdvancedSlot["rightPosition"] = slotRightPosition;
            newAdvancedSlot["mainIndex"] = i;
            newAdvancedSlot["timeStr"] = timeSlot.timeStr;
            newAdvancedSlot["maxQuota"] = timeSlot.maxQuota;
            enableAvancedRow.push(newAdvancedSlot);
        }

        var slotsHtml = "";
        var max = advancedSlotRows.length;
        for (var i = 0; i < max; i++) {
            slotsHtml += "<li>";
            var advancedSlots = advancedSlotRows[i];
            var noSlots = advancedSlots.length;
            for (var j = 0; j < noSlots; j++) {
                var slot = advancedSlots[j];
                slotsHtml += "<div class='specific-slot'  style='left: " + slot.leftPosition + "px'>"
                        + "<a href='' class='info' leftPosition='" + slot.leftPosition + "' rowIndex='" + i + "' slotIndex='" + slot.mainIndex + "'>"
                        + " <span class='time'>Time " + slot.timeStr + "</span>"
                        + " <span class='quota'>Quota " + slot.maxQuota + "</span></a>"
                        + "</div>";
            }
            slotsHtml += "</li>";
        }

        // insert html
        $("#time-schedule-tb  .specific-slots").html(slotsHtml);
        $("#time-schedule-tb .specific-slots > li > .specific-slot").css("width", slotWidth);
        if (!isWorking) {
            setPositionScrollOfTimeSchedule(currentSlot);
        }
    };


    $scope.prvTimeCol = function () {
        if (currentSlot > 0) {
            currentSlot--;
        }
        setPositionScrollOfTimeSchedule(currentSlot);
    };

    $scope.nxtTimeCol = function () {
        var maxCol = $("#time-schedule-tb .time-col > li").length - noShownSlots;
        if (currentSlot < maxCol) {
            currentSlot++;
        }
        setPositionScrollOfTimeSchedule(currentSlot);
    };

    // click to edit
    $scope.editingForm = {};
    $(document).on("click", "#time-schedule-tb .specific-slots > li > .specific-slot > a.info", function () {
        $("#time-schedule-tb .specific-slots > li.editing").removeClass("editing").find(".specific-slot.editing").removeClass("editing");
        // get data first
        var rowIndex = $(this).attr("rowindex");
        var topPosition = rowIndex * $("#time-schedule-tb .specific-slots > li")[0].getBoundingClientRect().height +
                $("#time-schedule-tb .time-header").height() + 2;
        var slotIndex = $(this).attr("slotindex");
        var leftPosition = $(this).attr("leftposition");
        console.log(leftPosition);
        var specificSlot = $scope.package.tempSpecificTimeSlots[slotIndex];

        $scope.editingForm["hours"] = specificSlot.hour;
        $scope.editingForm["minutes"] = specificSlot.numberOfMinutes;
        $scope.editingForm["quota"] = specificSlot.maxQuota;
        $scope.editingForm["slotIndex"] = slotIndex;

        var colWidth = $("#time-schedule-tb .time-col > li")[0].getBoundingClientRect().width - 2;
        $(this).parent(".specific-slot").addClass("editing").parent("li").addClass("editing");
        $("#time-schedule-tb #time-editSchedule-form").addClass("active")
                .css({"width": colWidth, "left": leftPosition + "px", "top": topPosition + "px"});
    });

    $scope.closeTimeEditingForm = function () {
        // remove old editing
        $("#time-schedule-tb .specific-slots > li.editing").removeClass("editing").find(".specific-slot.editing").removeClass("editing");
        $("#time-schedule-tb #time-editSchedule-form.active").removeClass("active");
    };

    $scope.deleteSpecificSlot = function (slotIndex) {
        $scope.package.tempSpecificTimeSlots.splice(slotIndex, 1);
        $scope.initTimeScheduleTable(true);
        $scope.closeTimeEditingForm();
    };

    $scope.editSpecificSlot = function (slotIndex) {
        var specificSlot = $scope.package.tempSpecificTimeSlots[slotIndex];
        var newHourInStr = $scope.editingForm["hours"];
        var noOfHour = parseInt(newHourInStr);
        var noOfMinute = $scope.editingForm["minutes"];
        var timeInMinutes = noOfHour * 60 + noOfMinute;

        var newMinuteInStr = noOfMinute.toString();
        newMinuteInStr = newMinuteInStr[1] ? newMinuteInStr : "0" + newMinuteInStr[0];
        var timeStr = newHourInStr + ":" + newMinuteInStr;

        var existTimeSLot = false;
        for (var i = 0; i < $scope.package.tempSpecificTimeSlots.length; i++) {
            if ($scope.package.tempSpecificTimeSlots[i].timeInMinutes === timeInMinutes) {
                existTimeSLot = true;
            }
        }
        ;
         if (existTimeSLot === false) {
        specificSlot["maxQuota"] = $scope.editingForm["quota"];
        specificSlot["timeInMinutes"] = timeInMinutes;
        specificSlot["numberOfMinutes"] = noOfMinute;
        specificSlot["numberOfHours"] = noOfHour;
        specificSlot["hour"] = newHourInStr;
        specificSlot["minute"] = newMinuteInStr;
        specificSlot["timeStr"] = timeStr;

        $scope.initTimeScheduleTable(true);
        $scope.closeTimeEditingForm();
    }else {
          $('#duplicateTimeSlotBox').toggleClass('active');
    }
    };

    // click to open adding form
    $scope.addingForm = {};
    $(document).on("click", "#time-schedule-tb .time-header > li > span.grey-plus-btn", function () {
        var hour = $(this).attr("hourdata");
        var columnNo = $(this).attr("columnno");
        var colWidth = $("#time-schedule-tb .time-col > li")[0].getBoundingClientRect().width;
        var leftPosition = columnNo * colWidth;

        $scope.addingForm["hours"] = hour;
        $scope.addingForm["minutes"] = 0;
        $scope.addingForm["quota"] = null;

        $("#time-schedule-tb #time-addingSchedule-form.time-slot-form").css({"left": leftPosition + "px"}).addClass("active");
    });

    $scope.closeAddingForm = function () {
        $("#time-schedule-tb #time-addingSchedule-form.time-slot-form.active").removeClass("active");
    };

    $scope.addNewSpecificTimeSlot = function () {
        var newHourInStr = $scope.addingForm["hours"];
        var noOfHour = parseInt(newHourInStr);
        var noOfMinute = $scope.addingForm["minutes"];
        var timeInMinutes = noOfHour * 60 + noOfMinute;

        var newMinuteInStr = noOfMinute.toString();
        newMinuteInStr = newMinuteInStr[1] ? newMinuteInStr : "0" + newMinuteInStr[0];
        var timeStr = newHourInStr + ":" + newMinuteInStr;

        var existTimeSLot = false;
        for (var i = 0; i < $scope.package.tempSpecificTimeSlots.length; i++) {
            if ($scope.package.tempSpecificTimeSlots[i].timeInMinutes === timeInMinutes) {
                existTimeSLot = true;
            }
        }
        ;
        // construct new Slot
        if (existTimeSLot === false) {
            var newSlot = {};
            newSlot["maxQuota"] = $scope.addingForm["quota"];
            newSlot["timeInMinutes"] = timeInMinutes;
            newSlot["numberOfMinutes"] = noOfMinute;
            newSlot["numberOfHours"] = noOfHour;
            newSlot["hour"] = newHourInStr;
            newSlot["minute"] = newMinuteInStr;
            newSlot["timeStr"] = timeStr;
            newSlot["id"] = 0;
            newSlot["tempPackageID"] = 0;
            $scope.package.tempSpecificTimeSlots.push(newSlot);
            $scope.initTimeScheduleTable(true);
            $scope.closeAddingForm();
            console.log($scope.package.tempSpecificTimeSlots);
        } else {
            $('#duplicateTimeSlotBox').toggleClass('active');
        }
    };

    $scope.closeDuplicateTimeSlot = function () {
        $('#duplicateTimeSlotBox').toggleClass('active');
    };

    function setPositionScrollOfTimeSchedule(col) {
        var position = $("#time-schedule-tb .time-col > li")[0].getBoundingClientRect().width * col;
        $('#time-schedule-tb .tb-container').animate({
            scrollLeft: position
        }, 200);
    }

    var checkInsideNondays = function (day) {
        if ($scope.package.isExceptSunday) {
            if (day === 0) {
                return true;
            }

        }
        if ($scope.package.isExceptMonday) {
            if (day === 1) {
                return true;
            }
        }
        if ($scope.package.isExceptTuesday) {
            if (day === 2) {
                return true;
            }
        }
        if ($scope.package.isExceptWednesday) {
            if (day === 3) {
                return true;
            }
        }
        if ($scope.package.isExceptThursday) {
            if (day === 4) {
                return true;
            }
        }
        if ($scope.package.isExceptFriday) {
            if (day === 5) {
                return true;
            }
        }
        if ($scope.package.isExceptSaturday) {
            if (day === 6) {
                return true;
            }
        }
        return false;
    };

    function reInitCalendar(calendarTime) {
        var data = updateCalendar($scope.calendarTime);
        $("#calendar .left-calendar .calendarDate").html(data["left"]);
        $("#calendar .right-calendar .calendarDate").html(data["right"]);
        $("#calendar .left-calendar .calendarYearMonth h2").html(data["leftTitle"]);
        $("#calendar .right-calendar .calendarYearMonth h2").html(data["rightTitle"]);
    }

    // select date on weekview, monthview to change to day view
    $(document).on('click', "#calendar.active .calendarDate ul li.enable-selection span", function () {
        var slDate = $(this).attr("datevalue");
        $scope.package.startDate = slDate;
        reInitCalendar($scope.calendarTime);
        $scope.$digest();
    });

    var checkInsideSequential = function (secondDate, toDate) {
        $scope.package.sequentialOperation = parseInt($scope.package.sequentialOperation);
        if ($scope.package.sequentialOperation !== 0) {
            //$scope.package.startDate
            var oneDay = 24 * 60 * 60 * 1000;
//            var secondDate = new Date(day);
            var diffDays = Math.round(Math.abs((toDate.getTime() - secondDate.getTime()) / (oneDay)));
            if (diffDays % $scope.package.sequentialOperation === 0) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    };
    var checkInsideOperationCycles = function (date, packageStartDate) {
//        for (var i = 0, max = $scope.package.operationsCycles.length; i < max; i++) {
//            var operationCycle = $scope.package.operationsCycles[i];
//            var startDate = new Date(operationCycle.startDate);
//            var endDate = new Date(operationCycle.endDate);
//            if (date >= startDate && (!(angular.isString(operationCycle.endDate) && operationCycle.endDate !== "") || date <= endDate)) {
//                return true;
//            }

        if (date >= packageStartDate) {
            return true;
        }
//        }
        return false;
    };
    var TR_start = '<TR>';
    var TR_end = '</TR>';
    var TD_start = '<TD WIDTH="30">';
    var TD_Day_start = '<TD class="dayCol" WIDTH="30">';
    var TR_DAY_WEEK_START = '<TR CLASS="WeekDay">';
    var TD_end = '</TD>';
    var prvCtr = "<span class='cldCtr prvCtr' ng-click='prevMonth()'></span>";
    var nxtCtr = "<span class='cldCtr nxtCtr' ng-click='nextMonth()'></span>";
    var DAYS_OF_WEEK = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];
    $scope.MONTHS_OF_YEAR = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
    var NO_DAYS_OF_WEEK = 7; // "constant" for number of days in a week
    var NO_WEEKS_OF_MONTH = 6;
    var NO_DAYS_OF_MONTH = 31; // "constant" for number of days in a month

    function updateCalendar(calendarTime) {
        var data = {};
        // return to first sunday of month
        var currentMonth = calendarTime.getMonth();
        var currentDate = new Date(calendarTime);

        data["leftTitle"] = $scope.MONTHS_OF_YEAR[currentMonth] + " " + currentDate.getFullYear();

        currentDate.setDate(1);
        var distance = currentDate.getDay();
        if (distance === 0) {
            distance = 7;
        }
        currentDate.setDate(currentDate.getDate() - distance);
        var toDate;
        if ($scope.package.startDate !== undefined) {
            toDate = new Date($scope.package.startDate);
        } else {
            toDate = new Date(timeNowVar);
        }

        var now = new Date(timeNowVar);
        // construct string html of month view
        var html = "";
        // loop 6 weeks
        var isAvailable;
        for (var i = 0; i < NO_WEEKS_OF_MONTH; i++) {
            html += "<ul class='clearfix'>";
            for (var j = 0; j < NO_DAYS_OF_WEEK; j++) { // loop 7 days
                isAvailable = false;
                if (!checkInsideNondays(currentDate.getDay()) && !checkInsideSequential(currentDate, toDate) &&
                        checkInsideOperationCycles(currentDate, toDate)) {
                    isAvailable = true;
                }

                var timeDiff = currentDate.getTime() - now.getTime();
                var diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24));

                html += "<li class='" + (isAvailable ? "availableDate" : "") +
                        (currentMonth === currentDate.getMonth() ? " inMonth" : " outMonth") +
                        ((diffDays >= 0) ? " enable-selection" : "") +
                        (currentDate.MMddyyyy() === timeNowVar ? " toDate" : "") + "'>"
                        + "<span dateValue='" + currentDate.MMddyyyy() + "'>"
                        + currentDate.getDate() + "</span></li>";
                currentDate.setDate(currentDate.getDate() + 1);
            }
            // plus week to month
            html += "</ul>";
        }

        data["left"] = html;

        var rightHtml = "";
        currentDate = new Date(calendarTime);
        currentDate.setMonth(currentDate.getMonth() + 1);
        currentMonth = currentDate.getMonth();

        data["rightTitle"] = $scope.MONTHS_OF_YEAR[currentMonth] + " " + currentDate.getFullYear();
        currentDate.setDate(1);
        distance = currentDate.getDay();
        if (distance === 0) {
            distance = 7;
        }
        currentDate.setDate(currentDate.getDate() - distance);

        for (var i = 0; i < NO_WEEKS_OF_MONTH; i++) {
            rightHtml += "<ul class='clearfix'>";
            for (var j = 0; j < NO_DAYS_OF_WEEK; j++) { // loop 7 days
                isAvailable = false;
                if (!checkInsideNondays(currentDate.getDay()) && !checkInsideSequential(currentDate, toDate) &&
                        checkInsideOperationCycles(currentDate, toDate)) {
                    isAvailable = true;
                }

                var timeDiff = currentDate.getTime() - now.getTime();
                var diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24));

                rightHtml += "<li class='" + (isAvailable ? "availableDate" : "") +
                        (currentMonth === currentDate.getMonth() ? " inMonth" : " outMonth") +
                        ((diffDays >= 0) ? " enable-selection" : "") +
                        (currentDate.MMddyyyy() === timeNowVar ? " toDate" : "") + "'>"
                        + "<span dateValue='" + currentDate.MMddyyyy() + "'>"
                        + currentDate.getDate() + "</span></li>";
                currentDate.setDate(currentDate.getDate() + 1);
            }
            rightHtml += "</ul>";
        }


        data["right"] = rightHtml;
        return data;
    }

    function updateSmallCalendar(calendarTime) {


        // return to first sunday of month
        var currentMonth = calendarTime.getMonth();
        var currentDate = new Date(calendarTime);


        currentDate.setDate(1);
        var distance = currentDate.getDay();
        if (distance === 0) {
            distance = 7;
        }
        currentDate.setDate(currentDate.getDate() - distance);


        var now = new Date(calendarTime);
        // construct string html of month view
        var html = "";
        // loop 6 weeks
        var isAvailable;
        for (var i = 0; i < NO_WEEKS_OF_MONTH; i++) {
            html += "<ul class='clearfix'>";
            for (var j = 0; j < NO_DAYS_OF_WEEK; j++) { // loop 7 days



                var timeDiff = currentDate.getTime() - now.getTime();
                var diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24));

                html += "<li class='" + (isAvailable ? "availableDate" : "") +
                        (currentMonth === currentDate.getMonth() ? " inMonth" : " outMonth") +
                        ((diffDays >= 0 && diffDays < 31) ? " enable-selection" : "") +
                        (currentDate.MMddyyyy() === calendarTime ? " toDate" : "") + "'>"
                        + "<span dateValue='" + currentDate.MMddyyyy() + "'>"
                        + currentDate.getDate() + "</span></li>";
                currentDate.setDate(currentDate.getDate() + 1);
            }
            // plus week to month
            html += "</ul>";
        }

        return html;
    }

    $scope.calendarTime = new Date(timeNowVar);
    $scope.calendarTime.setHours(0, 0, 0, 0, 0);
    $scope.popupTripSourceShowing = false;
    $scope.nextMonth = function () {
        $scope.calendarTime.setMonth($scope.calendarTime.getMonth() + 2);
        reInitCalendar($scope.calendarTime);
    };
    $scope.previousMonth = function () {
        $scope.calendarTime.setMonth($scope.calendarTime.getMonth() - 2);
        reInitCalendar($scope.calendarTime);
    };

    $scope.$watch("package.sequentialOperation", function (newVal, oldVal) {
        if (newVal !== oldVal) {
            reInitCalendar($scope.calendarTime);
        }
    });

    $scope.showResourcePopup = function () {
//        $('#newTripSourceBtn').ScrollTo({
//            duration: 100,
//            callback: function () {
//                $scope.popupTripSourceShowing = true;
//                $scope.$digest();
//            }
//        });
        //       Scroll screen to target element
//        $scope.popupTripSourceShowing = true;
//        var position = $("#newTripSourceBtn").offset().top;
//        alert(position);
        $scope.popupTripSourceShowing = true;
        $timeout(function () {
            var newTripSourceBtnPosition = $("#resourcePopup").offset().top + ($("#resourcePopup").outerHeight(true) / 2);
            var scrollHeight = $('#package-section-content .content').outerHeight(true) / 2;
            var position = $('#package-section-content .content').scrollTop() + newTripSourceBtnPosition - $('#package-section-content .content').offset().top - scrollHeight;
            $('#package-section-content .content').animate({
                scrollTop: position
            }, 100);
        }, 100);
    };
    $scope.closeResourcePopup = function () {
        $scope.popupTripSourceShowing = false;
    };

    $scope.popupServingShowing = false;
    $scope.openServingPopup = function () {
        editSelectedResourceMode = false;
        $scope.wrongTimeServingPeriod = false;
        $scope.showMissingServingPeriod = false;
        $scope.popupServingShowing = true;
        $scope.newServing = {"name": '', "startTime": '', "endtime": ''};
        $timeout(function () {
            var newTripSourceBtnPosition = $("#servingPopup").offset().top + ($("#servingPopup").outerHeight(true) / 2);
            var scrollHeight = $('#package-section-content .content').outerHeight(true) / 2;
            var position = $('#package-section-content .content').scrollTop() + newTripSourceBtnPosition - $('#package-section-content .content').offset().top - scrollHeight;
            position += 100;
            $('#package-section-content .content').animate({
                scrollTop: position
            }, 100);
        }, 100);
    };

    $scope.closeServingPopup = function () {
        $scope.popupServingShowing = false;
        $scope.popupServingShowingEdit = false;
    };


    $scope.addMoreCycle = function () {
        var newCycle = {"cycleID": 0, "packageID": 0, "startDate": "", "endDate": ""};
        $scope.package.operationsCycles.push(newCycle);
        $timeout(function () {

        }, 100);
    };
    $scope.removeCycle = function () {
        $scope.package.operationsCycles.splice($scope.package.operationsCycles.length - 1, 1);
    };

    $scope.initCalendar = function () {
        $scope.calendarTime = new Date(timeNowVar);
        $scope.calendarTime.setHours(0, 0, 0, 0, 0);
        reInitCalendar($scope.calendarTime);
        $(".timeMaskInput").inputmask("h:s", {
            onKeyValidation: function (key, result) {
                angular.element($(this)).triggerHandler('input');
            }
        });
    };
    var inputElement;
    $scope.inputDate;
    $scope.showAvailableCalendar = function ($event) {
        // move to that input
        inputElement = $(angular.element($event.currentTarget));
        var inputPosition = inputElement.offset().top;
        var containerTop = $('#package-section-content .content').offset().top;
        var position = $('#package-section-content .content').scrollTop() + (inputPosition - containerTop);
        $('#package-section-content .content').animate({
            scrollTop: position
        }, 100);
        // place calendar bottom of input
        var inputHeight = inputElement.outerHeight(true);
        $("#availableCalendar").css("top", (position + inputHeight));
        var inputLeft = inputElement.offset().left;
        $("#availableCalendar").css("left", inputLeft);
        var inputValue = inputElement.val();
        if (inputValue !== "") {
            $scope.inputDate = new Date(inputValue);
        } else {
            $scope.inputDate = new Date();
        }
        $("#availableCalendar .calendarDate").html(updateCalendar($scope.inputDate));
        // show calendar
        $timeout(function () {
            $("#availableCalendar").addClass("active");
        }, 100);
    };
    var currentDateSlot = -1;
    $scope.isUsingSameQuota = false;
    $scope.tempReadyBookingType = 'day';
    if ($scope.package.readyBookingWeeks > 0) {
        $scope.tempReadyBookingType = 'week';
    } else if ($scope.package.readyBookingMonths > 0) {
        $scope.tempReadyBookingType = 'month';
    }
    $scope.showSmallAvailableCalendar = function ($event, slotIndex, calendarType) {
        console.log(calendarType);
        console.log(slotIndex);
        if (calendarType === 'dateSlot') {
            currentDateSlot = slotIndex;
        } else {
            currentDateSlot = -1;
        }
        // move to that input
        inputElement = $(angular.element($event.currentTarget));
        var inputPosition = inputElement.offset().top;
        var containerTop = $('#package-section-content .content').offset().top;
        var position = $('#package-section-content .content').scrollTop() + (inputPosition - containerTop);
        $('#package-section-content .content').animate({
            scrollTop: position
        }, 100);
        // place calendar bottom of input
        var inputHeight = inputElement.outerHeight(true);
        var inputWidth = inputElement.outerWidth(true);
        var inputLeft = inputElement.offset().left;
        //set calendar nearby
        if (currentDateSlot === -1) {
            $("#availableCalendar").css("left", inputLeft + inputWidth);
            $("#availableCalendar").css("top", (position));
        } else {
            $("#availableCalendar").css("left", inputLeft);
            $("#availableCalendar").css("top", (position - (inputHeight * 11)));
        }

        var inputValue = inputElement.val();
        if (inputValue !== "") {
            $scope.inputDate = new Date(inputValue);
        } else {
            $scope.inputDate = new Date(timeNowVar);
        }
        $("#availableCalendar .calendarDate").html(updateSmallCalendar($scope.inputDate));
        // show calendar
        $timeout(function () {
            $("#availableCalendar").addClass("active");
        }, 100);
    };

    // select 
    $(document).on('click', '#availableCalendar .smallCalendar .calendarDate ul li span', function () {
        var newValue = $(this).attr("dateValue");
        if (currentDateSlot > -1) {
            $scope.package.tempSpecificDateSlots[currentDateSlot].dateStr = newValue;
            var tempDate = new Date(newValue);
            var milliseconds = tempDate.getTime();
            $scope.package.tempSpecificDateSlots[currentDateSlot].dateInMilliseconds = milliseconds;
        } else {
            $scope.package.startDate = newValue;
        }

        reInitCalendar($scope.calendarTime);
        $timeout(function () {
            $("#availableCalendar").removeClass("active");
        }, 100);
        $scope.$digest();
    });

    $scope.descreaseDateSlot = function () {
        if ($scope.package.tempSpecificDateSlots.length > 1) {
            $scope.package.tempSpecificDateSlots.splice(-1, 1);
        }
    };
    $scope.increaseDateSlot = function () {
        if ($scope.sameQuota.value > 0) {
            var newSlot = {"dateStr": "", "dateInMilliseconds": 0, "maxQuota": $scope.sameQuota.value, "tempPackageID": $scope.package.id};
        } else {
            var newSlot = {"dateStr": "", "dateInMilliseconds": 0, "maxQuota": "", "tempPackageID": $scope.package.id};
        }

        $scope.package.tempSpecificDateSlots.push(newSlot);
    };
    $scope.isUsingSameQuota = false;
    $scope.setUsingSameQuota = function (value) {
        $scope.isUsingSameQuota = value;
        if (value === false) {
            $scope.sameQuota.value = 0;
        }
    };
    $scope.sameQuota = {"value": 0};

//load is using quota or not
    for (var i = 1; i < $scope.package.tempSpecificDateSlots.length; i++) {
        $scope.sameQuota.value = $scope.package.tempSpecificDateSlots[0].maxQuota;
        $scope.isUsingSameQuota = true;
        if ($scope.package.tempSpecificDateSlots[0].maxQuota !== $scope.package.tempSpecificDateSlots[i].maxQuota) {
            $scope.sameQuota.value = 0;
            $scope.isUsingSameQuota = false;
        }
    }
    $scope.$watch('sameQuota.value', function (newVal, oldVal) {
        if (newVal !== oldVal && newVal === true) {
            for (var i = 0; i < $scope.package.tempSpecificDateSlots.length; i++) {
                $scope.package.tempSpecificDateSlots[i].maxQuota = $scope.sameQuota.value;
            }
        }
    });

    $scope.$watch('package.tempSpecificDateSlots.length', function (newVal, oldVal) {
        if (newVal === 1 && newVal !== oldVal) {
            $scope.sameQuota.value = 0;
            $scope.isUsingSameQuota = false;
        }
    });

// move and next of small calendar
    $scope.backAvailableMonth = function () {
        $scope.inputDate.setMonth($scope.inputDate.getMonth() - 1);
        $("#availableCalendar .calendarDate").html(updateCalendar($scope.inputDate));
    };
    $scope.nextAvailableMonth = function () {
        $scope.inputDate.setMonth($scope.inputDate.getMonth() + 1);
        $("#availableCalendar .calendarDate").html(updateCalendar($scope.inputDate));
    };

    $scope.backSmallAvailableMonth = function () {
        $scope.inputDate.setMonth($scope.inputDate.getMonth() - 1);
        $("#availableCalendar .calendarDate").html(updateSmallCalendar($scope.inputDate));
    };
    $scope.nexSmalltAvailableMonth = function () {
        $scope.inputDate.setMonth($scope.inputDate.getMonth() + 1);
        $("#availableCalendar .calendarDate").html(updateSmallCalendar($scope.inputDate));
    };

    $scope.$watch("package.sequentialOperation", function (newVal, oldVal) {
        if (newVal !== oldVal) {
            reInitCalendar($scope.calendarTime);
        }
    });

    $scope.isNonDaysChanged = function () {
        reInitCalendar($scope.calendarTime);
    };

    // insert New Trip Source
    var RESOURCE_INSERTING_URL = service.getContextPath() + "/Provider/Resource/Insert";
    $scope.newResource = {"name": ""};
    $scope.insertNewTripSource = function () {
        $scope.addingProcessing = true;
        var data = {"resourceID": 0, "providerID": 0, "name": $scope.newResource["name"], "noPeople": $scope.newResource["capacity"],
            "note": $scope.newResource["note"]};
        if (angular.isNumber(data.noPeople) && angular.isString(data.name)
                ) {
            $http.post(RESOURCE_INSERTING_URL, data)
                    .then(function successCallback(response) {
                        if (response.data.result === "error") {
                            $(location).attr('href', ERROR_PAGE);
                        } else {
                            // get id and insert to old list
                            var newResourceID = response.data["resourceID"];
                            data.resourceID = newResourceID;
                            $scope.providerResourceHashmap[newResourceID] = data;
                            $timeout(function () {
                                $scope.package.resourceID = newResourceID;
                                $scope.closeResourcePopup();
                            }, 100);
                            $scope.addingProcessing = false;
                        }
                    });
        } else {
            event.preventDefault();
            $scope.addingProcessing = false;
        }


    };
    $scope.popupServingShowingEdit = false;
    var editSelectedResourceMode = false;
    $scope.editSelectedResource = function () {
        editSelectedResourceMode = true;
        $scope.editResource = {"startTime": $scope.providerServingPeriods[$scope.package.servingPeriodID].startOperationTime,
            "endTime": $scope.providerServingPeriods[$scope.package.servingPeriodID].endOperationTime,
            "name": $scope.providerServingPeriods[$scope.package.servingPeriodID].name};
        if ($scope.package.servingPeriodID > 0) {
            $scope.popupServingShowingEdit = true;
            $timeout(function () {
                var newTripSourceBtnPosition = $("#servingPopup").offset().top + ($("#servingPopup").outerHeight(true) / 2);
                var scrollHeight = $('#package-section-content .content').outerHeight(true) / 2;
                var position = $('#package-section-content .content').scrollTop() + newTripSourceBtnPosition - $('#package-section-content .content').offset().top - scrollHeight;
                position += 100;
                $('#package-section-content .content').animate({
                    scrollTop: position
                }, 100);
            }, 100);
        }
    };
    // insert New Trip Source
    var SERVING_INSERTING_URL = service.getContextPath() + "/Provider/Serving/Insert";
    var SERVING_EDITING_URL = service.getContextPath() + "/Provider/Serving/Update";
    $scope.newServing = {"name": ""};
    $scope.updateServing = function () {
        var validate = true;
        if ($scope.editResource.name === '' || !angular.isString($scope.editResource.name)) {
            $scope.showMissingServingPeriod = true;
            validate = false;
        } else {
            $scope.showMissingServingPeriod = false;
        }
        if ($scope.editResource.startTime === undefined || $scope.editResource.endTime === undefined) {
            $scope.wrongTimeServingPeriod = true;
            validate = false;
        }
        var startTime = new Date("October 13, 2014 " + $scope.editResource.startTime + ":00");
        var endTime = new Date("October 13, 2014 " + $scope.editResource.endTime + ":00");
        if (startTime >= endTime) {
            $scope.wrongTimeServingPeriod = true;
            validate = false;
        }
        if (!validate) {
            return;
        }
        $scope.wrongTimeServingPeriod = false;
        $scope.addingProcessing = true;
        var data = {"servingID": $scope.package.servingPeriodID, "startOperationTime": $scope.editResource.startTime,
            "endOperationTime": $scope.editResource.endTime, "name": $scope.editResource.name};
        $http.post(SERVING_EDITING_URL, data)
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        $(location).attr('href', ERROR_PAGE);
                    } else {
                        $timeout(function () {
                            $scope.closeServingPopup();
                        }, 100);
                        $scope.providerServingPeriods[$scope.package.servingPeriodID].startOperationTime = $scope.editResource.startTime;
                        $scope.providerServingPeriods[$scope.package.servingPeriodID].endOperationTime = $scope.editResource.endTime;
                        $scope.providerServingPeriods[$scope.package.servingPeriodID].name = $scope.editResource.name;
                        $scope.addingProcessing = false;
                    }
                });
    };
    $scope.insertNewServing = function () {

        var validate = true;
        if ($scope.newServing["name"] === '' || !angular.isString($scope.newServing["name"])) {
            $scope.showMissingServingPeriod = true;
            validate = false;
        } else {
            $scope.showMissingServingPeriod = false;
        }
        if ($scope.newServing["startTime"] === undefined || $scope.newServing["endTime"] === undefined) {
            $scope.wrongTimeServingPeriod = true;
            validate = false;
        }
        var startTime = new Date("October 13, 2014 " + $scope.newServing["startTime"] + ":00");
        var endTime = new Date("October 13, 2014 " + $scope.newServing["endTime"] + ":00");
        if (startTime >= endTime) {
            $scope.wrongTimeServingPeriod = true;
            validate = false;
        }
        if (!validate) {
            return;
        }

        $scope.wrongTimeServingPeriod = false;
        $scope.addingProcessing = true;
        var data = {"id": 0, "providerID": 0, "startOperationTime": $scope.newServing["startTime"],
            "endOperationTime": $scope.newServing["endTime"], "name": $scope.newServing["name"]};
        $http.post(SERVING_INSERTING_URL, data)
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        $(location).attr('href', ERROR_PAGE);
                    } else {
                        // get id and insert to old list
                        var servingID = response.data["servingID"];
                        data.id = servingID;
                        $scope.providerServingPeriods[servingID] = data;
                        $timeout(function () {
                            $scope.package.servingPeriodID = servingID;
                            $scope.closeServingPopup();
                        }, 100);
                        $scope.addingProcessing = false;
                    }
                });
    };
    function getBookingInput() {
        if ($scope.package.durationDay > 0) {
            $scope.package.isFreeBooking = true;
            $scope.package.servingPeriodID = null;
        }

        var totalMinute = $scope.package.durationHour * 60 + $scope.package.durationMinute;
        totalMinute = totalMinute + $scope.package.restingtimeHour * 60 + $scope.package.restingtimeMinute;
        $scope.package.fixedHour = Math.floor(totalMinute / 60);
        $scope.package.fixedMinute = totalMinute - $scope.package.fixedHour * 60;
        var data = {"packageID": $scope.package.id, "packageType": $scope.package.packageType, "minTripper": $scope.package.minTripper,
            "maxTripper": $scope.package.maxTripper, "resourceID": $scope.package.resourceID, "minimumResources": $scope.package.minimumResources,
            "servingID": $scope.package.servingPeriodID, "isFreeBooking": $scope.package.isFreeBooking,
            "freeInterval": $scope.package.freeInterval, "fixedHour": $scope.package.fixedHour,
            "fixedMinute": $scope.package.fixedMinute, "unavailableDays": JSON.stringify($scope.package.unavailableDays), "isRunning": $scope.package.isRunning,
            "sequentialOperation": $scope.package.sequentialOperation, "operationCycles": $scope.package.operationsCycles, "readyBookingDuration":
                    $scope.package.readyBookingDuration, "readyBookingDurationType": $scope.package.readyBookingDurationType,
            "durationDay": $scope.package.durationDay, "durationMonth": $scope.package.durationMonth, "durationYear": $scope.package.durationYear,
            "durationHour": $scope.package.durationHour, "durationMinute": $scope.package.durationMinute,
            "restingtimeDay": $scope.package.restingtimeDay, "restingtimeHour": $scope.package.restingtimeHour,
            "restingtimeMinute": $scope.package.restingtimeMinute, "startDate": $scope.package.startDate,
            "isUsingMaxQuota": $scope.package.isUsingMaxQuota, "maxQuota": $scope.package.maxQuota,
            "isSpecificLaunchDate": $scope.package.isSpecificLaunchDate, "quotaType": $scope.package.quotaType};
        return data;
    }

    function validateBookingInput() {
        if (($scope.package.maxTripper > 0 || ($scope.package.packageType === 'Open' && $scope.package.minTripper > 0)) && ($scope.package.durationDay > 0 ||
                $scope.package.durationMonth > 0 || $scope.package.durationYear > 0 || $scope.package.durationHour > 0 || $scope.package.durationMinute > 0) &&
                (($scope.package.durationDay === 0 && $scope.package.servingPeriodID > 0) || $scope.package.durationDay > 0 || $scope.package.durationMonth > 0 || $scope.package.durationYear > 0)
                && ($scope.package.isFreeBooking || (!$scope.package.isFreeBooking && ($scope.package.fixedHour !== null || $scope.package.fixedMinute !== null)))
                && (!$scope.package.isUsingMaxQuota || ($scope.package.isUsingMaxQuota && $scope.package.maxQuota > 0))
                ) {
            return true;
        }
        return false;
    }

    $scope.showHourBookingDuration = false;
    $scope.chooseHourBookingDuration = function () {
        if ($scope.package.readyBookingDurationType === 'hours') {
            $scope.showHourBookingDuration = true;
            $scope.showHourDuration = false;
        }
    };
    $scope.showHourDuration = false;
    $scope.showMinutesDuration = false;
    $scope.chooseHourDuration = function () {
        if ($scope.package.durationType === 'hours') {
            $scope.showHourDuration = true;
            $scope.showHourBookingDuration = false;
        } else if ($scope.package.durationType === 'minutes') {
            $scope.showMinutesDuration = true;
            $scope.showHourBookingDuration = false;
        }
    };
    $scope.showHourFixed = false;
    $scope.showMinutesFixed = false;
    $scope.chooseFixedTime = function () {
        if ($scope.package.fixedType === 'hours') {
            $scope.showHourFixed = true;
        } else {
            $scope.showMinutesFixed = true;
        }
    };
    $scope.changeTypeInputTime = function (type) {
        if (type === 'BookingDurationType') {
            if ($scope.package.readyBookingDurationType !== 'hours') {
                $scope.package.readyBookingDuration = 1;
                $scope.showHourBookingDuration = false;
                $('.bookingDurationInput').attr('readonly', false);
            } else {
                $scope.package.readyBookingDuration = 1;
                $('.bookingDurationInput').attr('readonly', true);
            }
        }
        if (type === 'DurationType') {
            if ($scope.package.durationType === 'hours') {
                $scope.package.duration = 1;
                $scope.showMinutesDuration = false;
                $('#durationInput').attr('readonly', true);
            } else if ($scope.package.durationType === 'minutes') {
                $scope.showHourDuration = false;
                $scope.package.duration = 05;
                $('#durationInput').attr('readonly', true);
            } else {
                $scope.package.duration = 1;
                $scope.showHourDuration = false;
                $scope.showMinutesDuration = false;
                $('#durationInput').attr('readonly', false);
            }
        }

        if (type === 'fixedType') {
            if ($scope.package.fixedType === 'hours') {
                $scope.showHourFixed = false;
                $scope.showMinutesFixed = false;
            }
        }
    };
    $scope.setHour = function (hour, type) {
        if (type === 'BookingDurationType') {
            $scope.package.readyBookingDuration = hour;
            $scope.showHourBookingDuration = false;
        }
        ;
        if (type === 'DurationType') {
            $scope.package.duration = hour;
            $scope.showHourDuration = false;
        }
        ;
        if (type === 'fixedType') {
            $scope.package.fixedHour = hour;
            $scope.showHourFixed = false;
        }
        ;
    };
    $scope.setMinutes = function (minute, type) {
        if (type === 'DurationType') {
            $scope.package.duration = minute;
            $scope.showMinutesDuration = false;
        }
        if (type === 'fixedType') {
            $scope.package.fixedMinute = minute;
            $scope.showMinutesFixed = false;
        }
        ;
    };
    if ($scope.package.fixedType === 'hours&minutes') {
        $scope.showPickHoursFixedHour = true;
        $scope.showPickMinutesFixedMinute = false;
    } else {
        $scope.showPickHoursFixedHour = false;
        $scope.showPickMinutesFixedMinute = true;
    }

    $scope.changeTypeInputTime = function () {
        if ($scope.package.fixedType === 'hours&minutes') {
            $scope.showPickHoursFixedHour = true;
            $scope.showPickMinutesFixedMinute = false;
        } else {
            $scope.showPickHoursFixedHour = false;
            $scope.showPickMinutesFixedMinute = true;
        }
    };
    $scope.toogleResourceInstruction = function () {
        $(".instruction-alt.hasAltLink").toggleClass("active");
        $("#resourceInstruction").toggleClass("active");
    };
    $(document).click(function (event) {
        if (!$(event.target).closest('.clockpicker-popover').length && !$(event.target).is('.clockpicker-popover') && !$(event.target).is('.clock-input')) {
            $scope.showHourFixed = false;
            $scope.showHourDuration = false;
            $scope.showHourBookingDuration = false;
            $scope.$digest();
        }
    });

    $scope.clockInputTypeOpen = true;
    var typeClockPicker;

    var resetClock = function () {
        $scope.hourArray = ['00', '01', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23'];
        $scope.minuteArray = ['00', '05', '10', '15', '20', '25', '30', '35', '40', '45', '50', '55'];
    };

    var resetMinute = function () {
        $scope.minuteArray = ['00', '05', '10', '15', '20', '25', '30', '35', '40', '45', '50', '55'];
    };

    resetClock();
    $scope.openTimeClock = function (type) {
        typeClockPicker = type;
        resetClock();

        if (type === 'openTime') {
            $scope.clockInputTypeOpen = true;
            if (angular.isString($scope.newServing.endTime)) {
                var tempPickhour = $scope.newServing.endTime.split(':')[0];
                for (var i = 0; i < $scope.hourArray.length; i++) {
                    if ($scope.hourArray[i] === tempPickhour) {
                        if ($scope.newServing.endTime.split(':')[1] === '00') {
                            $scope.hourArray.splice(i, $scope.hourArray.length - i + 1);
                        } else {
                            $scope.hourArray.splice(i + 1, $scope.hourArray.length - i);
                        }
                        break;
                    }
                }
                if (angular.isString($scope.newServing.startTime)) {
                    if ($scope.newServing.startTime.split(':')[0] === $scope.newServing.endTime.split(':')[0]) {
                        for (var i = 0; i < $scope.minuteArray.length; i++) {
                            if ($scope.minuteArray[i] === $scope.newServing.endTime.split(':')[1]) {
                                $scope.minuteArray.splice(i, $scope.minuteArray.length - i + 1);
                                break;
                            }
                        }
                        if ($scope.newServing.startTime.split(':')[1] >= $scope.newServing.endTime.split(':')[1]) {
                            $scope.package.servingPickMinute = '';
                        }
                    }
                }

            }
            if (angular.isString($scope.newServing.startTime)) {
                var res = $scope.newServing.startTime.split(':');
                $scope.package.servingPickerHour = res[0];
                $scope.package.servingPickMinute = res[1];
            } else {
                $scope.package.servingPickerHour = '';
                $scope.package.servingPickMinute = '';

            }
            $(".popover").css("right", "150px");
        } else {
            $scope.clockInputTypeOpen = false;
            if (angular.isString($scope.newServing.startTime)) {
                var tempPickhour = $scope.newServing.startTime.split(':')[0];
                for (var i = 0; i < $scope.hourArray.length; i++) {
                    if ($scope.hourArray[i] === tempPickhour) {
                        if ($scope.newServing.startTime.split(':')[1] === 55) {
                            $scope.hourArray.splice(0, i + 1);
                        } else {
                            $scope.hourArray.splice(0, i);
                        }

                        break;
                    }
                }
                if (angular.isString($scope.newServing.endTime)) {
                    if ($scope.newServing.endTime.split(':')[0] === $scope.newServing.startTime.split(':')[0]) {
                        for (var i = 0; i < $scope.minuteArray.length; i++) {
                            if ($scope.minuteArray[i] === $scope.newServing.startTime.split(':')[1]) {
                                $scope.minuteArray.splice(0, i + 1);
                                break;
                            }
                        }
                        if ($scope.newServing.endTime.split(':')[1] === '--') {
                            $scope.package.servingPickMinute = '';
                        } else if ($scope.newServing.endTime.split(':')[1] <= $scope.newServing.startTime.split(':')[1]) {
                            $scope.package.servingPickMinute = '';
                        }
                    }
                }
            }
            if (angular.isString($scope.newServing.endTime)) {
                var res = $scope.newServing.endTime.split(':');
                $scope.package.servingPickerHour = res[0];
                $scope.package.servingPickMinute = res[1];
            } else {
                $scope.package.servingPickerHour = '';
                $scope.package.servingPickMinute = '';

            }
            $(".popover").css("right", "10px");
        }
        $(".popover").addClass("active");
    };

    $scope.package.servingPickerHour = '';
    $scope.package.servingPickMinute = '';

    $scope.choosenHour = function () {
        if ($scope.clockInputTypeOpen) {
            if (!($scope.package.servingPickMinute >= '00')) {
                $scope.newServing.startTime = $scope.package.servingPickerHour + ":" + '--';
            } else {
                $scope.newServing.startTime = $scope.package.servingPickerHour + ":" + $scope.package.servingPickMinute;
            }

            if (angular.isString($scope.newServing.endTime)) {
                if ($scope.package.servingPickerHour === $scope.newServing.endTime.split(':')[0]) {
                    for (var i = 0; i < $scope.minuteArray.length; i++) {
                        if ($scope.minuteArray[i] === $scope.newServing.endTime.split(':')[1]) {
                            $scope.minuteArray.splice(i, $scope.minuteArray.length - i + 1);
                            break;
                        }
                    }
                    if ($scope.newServing.startTime.split(':')[1] >= $scope.newServing.endTime.split(':')[1]) {
                        $scope.package.servingPickMinute = '';
                        $scope.newServing.startTime = $scope.package.servingPickerHour + ":" + '--';
                    }
                } else {
                    resetMinute();
                }
            }
        } else {
            if (!($scope.package.servingPickMinute >= '00')) {
                $scope.newServing.endTime = $scope.package.servingPickerHour + ":" + '--';
            } else {
                $scope.newServing.endTime = $scope.package.servingPickerHour + ":" + $scope.package.servingPickMinute;
            }
            if (angular.isString($scope.newServing.startTime)) {
                if ($scope.package.servingPickerHour === $scope.newServing.startTime.split(':')[0]) {
                    for (var i = 0; i < $scope.minuteArray.length; i++) {
                        if ($scope.minuteArray[i] === $scope.newServing.startTime.split(':')[1]) {
                            $scope.minuteArray.splice(0, i + 1);
                            break;
                        }
                    }
                    if ($scope.newServing.endTime.split(':')[1] <= $scope.newServing.startTime.split(':')[1]) {
                        $scope.package.servingPickMinute = '';
                        $scope.newServing.endTime = $scope.package.servingPickerHour + ":" + '--';
                    }
                } else {
                    resetMinute();
                }
            }
        }

    };

    $scope.choosenMinute = function () {
        if ($scope.clockInputTypeOpen) {
            if (!($scope.package.servingPickerHour >= '00')) {
                $scope.newServing.startTime = '--' + ":" + $scope.package.servingPickMinute;
            } else {
                $scope.newServing.startTime = $scope.package.servingPickerHour + ":" + $scope.package.servingPickMinute;
            }
        } else {
            if (!($scope.package.servingPickerHour >= '00')) {
                $scope.newServing.endTime = '--' + ":" + $scope.package.servingPickMinute;
            } else {
                $scope.newServing.endTime = $scope.package.servingPickerHour + ":" + $scope.package.servingPickMinute;
            }
        }

    };

    $scope.openTimeClockEdit = function (type) {
        typeClockPicker = type;
        resetClock();

        if (type === 'openTime') {
            $scope.clockInputTypeOpen = true;
            if (angular.isString($scope.editResource.endTime)) {
                var tempPickhour = $scope.editResource.endTime.split(':')[0];
                for (var i = 0; i < $scope.hourArray.length; i++) {
                    if ($scope.hourArray[i] === tempPickhour) {
                        if ($scope.editResource.endTime.split(':')[1] === '00') {
                            $scope.hourArray.splice(i, $scope.hourArray.length - i + 1);
                        } else {
                            $scope.hourArray.splice(i + 1, $scope.hourArray.length - i);
                        }
                        break;
                    }
                }
                if (angular.isString($scope.editResource.startTime)) {
                    if ($scope.editResource.startTime.split(':')[0] === $scope.editResource.endTime.split(':')[0]) {
                        for (var i = 0; i < $scope.minuteArray.length; i++) {
                            if ($scope.minuteArray[i] === $scope.editResource.endTime.split(':')[1]) {
                                $scope.minuteArray.splice(i, $scope.minuteArray.length - i + 1);
                                break;
                            }
                        }
                        if ($scope.editResource.startTime.split(':')[1] >= $scope.editResource.endTime.split(':')[1]) {
                            $scope.package.servingPickMinute = '';
                        }
                    }
                }

            }
            if (angular.isString($scope.editResource.startTime)) {
                var res = $scope.editResource.startTime.split(':');
                $scope.package.servingPickerHour = res[0];
                $scope.package.servingPickMinute = res[1];
            } else {
                $scope.package.servingPickerHour = '';
                $scope.package.servingPickMinute = '';

            }
            $(".popover").css("right", "150px");
        } else {
            $scope.clockInputTypeOpen = false;
            if (angular.isString($scope.editResource.startTime)) {
                var tempPickhour = $scope.editResource.startTime.split(':')[0];
                for (var i = 0; i < $scope.hourArray.length; i++) {
                    if ($scope.hourArray[i] === tempPickhour) {
                        if ($scope.editResource.startTime.split(':')[1] === 55) {
                            $scope.hourArray.splice(0, i + 1);
                        } else {
                            $scope.hourArray.splice(0, i);
                        }

                        break;
                    }
                }
                if (angular.isString($scope.editResource.endTime)) {
                    if ($scope.editResource.endTime.split(':')[0] === $scope.editResource.startTime.split(':')[0]) {
                        for (var i = 0; i < $scope.minuteArray.length; i++) {
                            if ($scope.minuteArray[i] === $scope.editResource.startTime.split(':')[1]) {
                                $scope.minuteArray.splice(0, i + 1);
                                break;
                            }
                        }
                        if ($scope.editResource.endTime.split(':')[1] === '--') {
                            $scope.package.servingPickMinute = '';
                        } else if ($scope.editResource.endTime.split(':')[1] <= $scope.editResource.startTime.split(':')[1]) {
                            $scope.package.servingPickMinute = '';
                        }
                    }
                }
            }
            if (angular.isString($scope.editResource.endTime)) {
                var res = $scope.editResource.endTime.split(':');
                $scope.package.servingPickerHour = res[0];
                $scope.package.servingPickMinute = res[1];
            } else {
                $scope.package.servingPickerHour = '';
                $scope.package.servingPickMinute = '';

            }
            $(".popover").css("right", "10px");
        }
        $(".popover").addClass("active");
    };

    $scope.package.servingPickerHour = '';
    $scope.package.servingPickMinute = '';

    $scope.choosenHourEdit = function () {
        if ($scope.clockInputTypeOpen) {
            if (!($scope.package.servingPickMinute >= '00')) {
                $scope.editResource.startTime = $scope.package.servingPickerHour + ":" + '--';
            } else {
                $scope.editResource.startTime = $scope.package.servingPickerHour + ":" + $scope.package.servingPickMinute;
            }
            if (angular.isString($scope.editResource.endTime)) {
                if ($scope.package.servingPickerHour === $scope.editResource.endTime.split(':')[0]) {
                    for (var i = 0; i < $scope.minuteArray.length; i++) {
                        if ($scope.minuteArray[i] === $scope.editResource.endTime.split(':')[1]) {
                            $scope.minuteArray.splice(i, $scope.minuteArray.length - i + 1);
                            break;
                        }
                    }
                    if ($scope.editResource.startTime.split(':')[1] >= $scope.editResource.endTime.split(':')[1]) {
                        $scope.package.servingPickMinute = '';
                        $scope.editResource.startTime = $scope.package.servingPickerHour + ":" + '--';
                    }
                } else {
                    resetMinute();
                }
            }
        } else {
            if (!($scope.package.servingPickMinute >= '00')) {
                $scope.editResource.endTime = $scope.package.servingPickerHour + ":" + '--';
            } else {
                $scope.editResource.endTime = $scope.package.servingPickerHour + ":" + $scope.package.servingPickMinute;
            }
            if (angular.isString($scope.editResource.startTime)) {
                if ($scope.package.servingPickerHour === $scope.editResource.startTime.split(':')[0]) {
                    for (var i = 0; i < $scope.minuteArray.length; i++) {
                        if ($scope.minuteArray[i] === $scope.editResource.startTime.split(':')[1]) {
                            $scope.minuteArray.splice(0, i + 1);
                            break;
                        }
                    }
                    if ($scope.editResource.endTime.split(':')[1] <= $scope.editResource.startTime.split(':')[1]) {
                        $scope.package.servingPickMinute = '';
                        $scope.editResource.endTime = $scope.package.servingPickerHour + ":" + '--';
                    }
                } else {
                    resetMinute();
                }
            }
        }

    };

    $scope.choosenMinuteEdit = function () {
        if ($scope.clockInputTypeOpen) {
            if (!($scope.package.servingPickerHour >= '00')) {
                $scope.editResource.startTime = '--' + ":" + $scope.package.servingPickMinute;
            } else {
                $scope.editResource.startTime = $scope.package.servingPickerHour + ":" + $scope.package.servingPickMinute;
            }
        } else {
            if (!($scope.package.servingPickerHour >= '00')) {
                $scope.editResource.endTime = '--' + ":" + $scope.package.servingPickMinute;
            } else {
                $scope.editResource.endTime = $scope.package.servingPickerHour + ":" + $scope.package.servingPickMinute;
            }
        }

    };


    $scope.setHourSlot = function (hour) {
        $scope.hourSlot = hour;
        $(".clockpicker-hours").removeClass("active");
        $(".clockpicker-minutes").addClass("active");
    };
    $scope.setMinuteSlot = function (minute) {
        $scope.minuteSlot = minute;
        if ($scope.clockInputTypeOpen) {
            if (editSelectedResourceMode) {
                $scope.editResource.startTime = $scope.hourSlot + $scope.minuteSlot;
            } else {
                $scope.newServing.startTime = $scope.hourSlot + $scope.minuteSlot;
            }
            $scope.hourSlot = '';
            $scope.minuteSlot = '';
            $(".clockpicker-hours").addClass("active");
            $(".clockpicker-minutes").removeClass("active");
            $(".popover").removeClass("active");
        } else {
            if (editSelectedResourceMode) {
                $scope.editResource.endTime = $scope.hourSlot + $scope.minuteSlot;
            } else {
                $scope.newServing.endTime = $scope.hourSlot + $scope.minuteSlot;
            }
            $scope.hourSlot = '';
            $scope.minuteSlot = '';
            $(".clockpicker-hours").addClass("active");
            $(".clockpicker-minutes").removeClass("active");
            $(".popover").removeClass("active");
        }
    };
    if ($scope.package.durationType === 'days') {
        $scope.package.isFreeBooking = true;
    }
    $scope.$watch('package.durationType', function (newVal, oldVal) {
        if (newVal === 'days') {
            $scope.package.isFreeBooking = true;
        }
    });
    if ($scope.package.durationType === 'days') {
        $scope.package.isFreeBooking = true;
    }
    $scope.$watch('package.durationType', function (newVal, oldVal) {
        if (newVal === 'days') {
            $scope.package.isFreeBooking = true;
        }
    });
    $scope.tempDurationType = "hours&minutes";
    if ($scope.package.durationHour > 0 || $scope.package.durationMinute > 0) {
        $scope.tempDurationType = "hours&minutes";
    } else if ($scope.package.durationDay > 0) {
        $scope.tempDurationType = "days";
    } else if ($scope.package.durationMonth > 0) {
        $scope.tempDurationType = "month";
    } else if ($scope.package.durationYear > 0) {
        $scope.tempDurationType = "years";
    }

    $scope.changeTempDurationType = function (type) {
        $scope.tempDurationType = type;
        if ($scope.tempDurationType === "days") {
            $scope.package.durationHour = 0;
            $scope.package.durationMinute = 0;
            $scope.package.restingtimeDay = 0;
            $scope.package.durationMonth = 0;
            $scope.package.durationYear = 0;
            $scope.package.readyBookingDurationType = "days";
            $scope.package.readyBookingDuration = 0;
            $scope.package.readyBookingDurationHour = 0;
            $scope.package.readyBookingDurationMinutes = 0;
        } else if ($scope.tempDurationType === "month") {
            $scope.package.durationHour = 0;
            $scope.package.durationMinute = 0;
            $scope.package.restingtimeDay = 0;
            $scope.package.durationDay = 0;
            $scope.package.durationYear = 0;
            $scope.package.readyBookingDurationType = "days";
            $scope.package.readyBookingDuration = 0;
            $scope.package.readyBookingDurationHour = 0;
            $scope.package.readyBookingDurationMinutes = 0;
        } else if ($scope.tempDurationType === "years") {
            $scope.package.durationHour = 0;
            $scope.package.durationMinute = 0;
            $scope.package.restingtimeDay = 0;
            $scope.package.durationDay = 0;
            $scope.package.durationYear = 0;
            $scope.package.durationDay = 0;
            $scope.package.durationMonth = 0;
            $scope.package.readyBookingDurationType = "days";
            $scope.package.readyBookingDuration = 0;
            $scope.package.readyBookingDurationHour = 0;
            $scope.package.readyBookingDurationMinutes = 0;
        } else {
            $scope.package.durationDay = 0;
            $scope.package.durationMonth = 0;
            $scope.package.durationYear = 0;
            $scope.package.restingtimeHour = 0;
            $scope.package.restingtimeMinute = 0;
            $scope.package.readyBookingDuration = 0;
            $scope.package.readyBookingDurationHour = 0;
            $scope.package.readyBookingDurationMinutes = 0;
        }
    };
    $scope.changeReadyBookingDurationType = function () {
        $scope.package.readyBookingDuration = 0;
        $scope.package.readyBookingDurationHour = 0;
        $scope.package.readyBookingDurationMinutes = 0;
    };
    /* END BOOKING SECTION */

    /* PRICE SECTION */
    $scope.selectingPolicy;
    $scope.pricingType = 'standard';
    $scope.isHaveCancellation = false;
    $scope.package.cancellationPolicyJson = $.parseJSON($scope.package.cancellationPolicyJson);
    if ($scope.package.cancellationPolicyJson.length > 0) {
        $scope.isHaveCancellation = true;
    }
    //Check cancellation Policy select or not
    $scope.$watch('isHaveCancellation', function (newVal, oldVal) {
        if (newVal === false) {
            $scope.package.cancellationPolicyJson = [];
        }
    }, true);
    $scope.removeCancellationPolicy = function (id) {
        $scope.package.cancellationPolicyJson.splice(id, 1);
    };
    angular.forEach($scope.packageForm.cancellations, function (child) {
        child.condition = $.parseJSON(child.condition);
    });
    function validatePriceInput() {
        var childrenMissingData = true;
        for (var i = 0; i < $scope.package.childrenDiscountJson.length; i++) {
            if ($scope.package.childrenDiscountJson[i].condition === '' || $scope.package.childrenDiscountJson[i].condition === null) {
                childrenMissingData = false;
            }
        }
        if ($scope.package.youtripperPrice !== '' && $scope.package.youtripperPrice !== 0 && childrenMissingData &&
                (($scope.package.packageType === 'Open' && $scope.package.minTripper > 0) || ($scope.package.packageType !== 'Open' && $scope.package.maxTripper > 0))
                ) {
            return true;
        }
        return false;
    }

    $scope.descreaseYTPercentage = function () {
        if ($('#minusYTPercentage').hasClass('active')) {
            $scope.package.youtripperPercentage = $scope.package.youtripperPercentage - 1;
        }
    };
    $scope.increaseYTPercentage = function () {
        if ($('#plusYTPercentage').hasClass('active')) {
            $scope.package.youtripperPercentage = $scope.package.youtripperPercentage + 1;
        }
    };
    $scope.formatPercentage = function (number) {
        var result = number + "%";
        return result;
    };
    /*Create a new Policy*/
    $scope.popupPolicyShowing = false;
    $scope.popupEditPolicyShowing = false;
    $scope.editingPolicyID = 0;
    $scope.offerPolicy = function (condition) {
        if (condition === false) {
            $scope.isHaveCancellation = false;
        } else {
            $scope.isHaveCancellation = true;
            $scope.package.cancellationPolicyJson = [{"duration": null, "percent": 5}];
        }

    };
    $scope.addNewPolicy = function () {
        if ($scope.package.cancellationPolicyJson.length < 5) {
            var newPolicy = {"duration": null, "percent": 5};
            $scope.package.cancellationPolicyJson.push(newPolicy);
        }
    };
    /*Children Discount Start*/
    $scope.isHaveChildrenDiscount = false;
//    $scope.newChildrenDiscountItem = {"condition": "", "discountPercent": ""};
    $scope.popupCreateChildrenDiscountShowing = false;
    $scope.package.childrenDiscountJson = $.parseJSON($scope.package.childrenDiscountJson);
    if ($scope.package.childrenDiscountJson.length > 0) {
        $scope.isHaveChildrenDiscount = true;
    }

    $scope.isOfferChildrenCount = function () {
        if ($scope.isHaveChildrenDiscount) {
            $scope.isHaveChildrenDiscount = false;
            $scope.package.childrenDiscountJson = [];
        } else {
            $scope.isHaveChildrenDiscount = true;
            $scope.package.childrenDiscountJson = [];
            var newChildrenDiscountItem = {"condition": "", "discountType": "age", "ageType": "years", "discountPercent": 5};
            $scope.package.childrenDiscountJson.push(newChildrenDiscountItem);
        }

    };
    $scope.addNewDiscount = function () {
        if ($scope.package.childrenDiscountJson.length < 4) {
            var newChildrenDiscountItem = {"condition": "", "discountType": "age", "ageType": "years", "discountPercent": 5};
            $scope.package.childrenDiscountJson.push(newChildrenDiscountItem);
        }
    };
    /*Children Discount End*/

    function getPriceData() {
        if (angular.isUndefined($scope.package.freeCondition)) {
            $scope.package.freeCondition = "";
        }
        var data = {"ordinaryPriceForAdult": $scope.package.ordinaryPriceForAdult,
            "youtripperPrice": $scope.package.youtripperPrice, "priceCurrency": $scope.package.priceCurrency,
            "cancellationID": $scope.package.cancellationID, "noCancellationPercent": $scope.package.noCancellationPercent,
            "childrenDiscounts": JSON.stringify($scope.package.childrenDiscountJson), "cancellationPolicy": JSON.stringify($scope.package.cancellationPolicyJson),
            "packageID": $scope.package.id, "providerID": $scope.package.providerID, "freeCondition": $scope.package.freeCondition, "packageType": $scope.package.packageType,
            "minTripper": $scope.package.minTripper, "maxTripper": $scope.package.maxTripper};
        return data;
    }

    //Increase and descrease button
    $scope.descrease = function (valueField) {
        if (valueField === 'package.maxTripper') {
            if ($scope.package.maxTripper > 1)
                $scope.package.maxTripper--;
        }
        if (valueField === 'package.minTripper') {
            if ($scope.package.minTripper > 1)
                $scope.package.minTripper--;
        }
        if (valueField === 'package.minimumResources') {
            if ($scope.package.minimumResources > 1)
                $scope.package.minimumResources--;
        }
    };
    $scope.increase = function (valueField) {

        if (valueField === 'package.maxTripper') {
            if ($scope.package.packageType === 'Personal' && ($scope.package.maxTripper === 5 || $scope.package.maxTripper === '5')) {

            } else {
                $scope.package.maxTripper++;
            }

        }
        if (valueField === 'package.minTripper') {
            if (3 < 4)
                $scope.package.minTripper++;
        }
        if (valueField === 'package.minimumResources') {
            $scope.package.minimumResources++;
        }
    };

    $scope.increaseMaximumPrivate = function () {
        if ($scope.package.packageType === 'Personal') {
            $scope.package.maxTripper++;

        }
    };

    $scope.descreaseMaximumPrivate = function () {
        if ($scope.package.maxTripper > 1)
            $scope.package.maxTripper--;
    };


    $scope.descreaseMinimumGroup = function () {
        if ($scope.package.minTripper > 5)
            $scope.package.minTripper--;
    };

    $scope.descreaseMaximumGroup = function () {
        if ($scope.package.maxTripper > 5) {
            $scope.package.maxTripper--;
        }
    };

    $scope.increaseMaximumGroup = function () {
        if (($scope.package.maxTripper < $scope.package.minTripper) && ($scope.package.minTripper >= 5)) {
            $scope.package.maxTripper = $scope.package.minTripper + 1;
        } else if (($scope.package.maxTripper < $scope.package.minTripper) && ($scope.package.minTripper < 5)) {
            $scope.package.maxTripper = 5;
        } else
            $scope.package.maxTripper++;
    };

    $scope.increaseMinimumGroup = function () {
        if ($scope.package.minTripper < 5) {
            $scope.package.minTripper = 5;
        } else if (3 < 4) {
            $scope.package.minTripper++;
        }
        if ($scope.package.maxTripper < $scope.package.minTripper) {
            $scope.package.maxTripper = $scope.package.minTripper;
        }
        ;
    };


    $scope.descreasePublicMinimum = function () {
        $scope.package.minTripper--;
        if ($scope.package.minTripper < 1) {
            $scope.package.minTripper = 1;
        }
    };

    $scope.increasePublicMinimum = function () {
        $scope.package.minTripper++;
    };

    $scope.removeChildrenDiscount = function (discountID) {
        $scope.package.childrenDiscountJson.splice(discountID, 1);
    };

    $scope.removeDisabledDiscount = function (discountID) {
        angular.forEach($scope.package.disabledDiscounts, function (disabled, disabledIndex) {
            if (disabled.disabledDiscountID === discountID) {
                $scope.package.disabledDiscounts.splice(disabledIndex, 1);
            }
        });
    };

    $scope.getStandardPriceWithSC = function () {
        return Math.ceil(parseInt($scope.package.youtripperPrice) + parseInt($scope.package.youtripperPrice) * ($scope.package.profitPercentage / 100));
    };
    $scope.getStandardPriceOfPayout = function () {
        var result = $scope.package.youtripperPrice * (100 - $scope.package.ytComission) / 100;
        return Math.ceil(result);
    };

    $scope.getNoCancellationPrice = function () {
        return Math.ceil($scope.package.youtripperPrice * ((100 - $scope.package.noCancellationPercent) / 100));
    };

    $scope.calculateCancellationPriceWithSC = function () {
        var standardCancellationPrice = $scope.package.youtripperPrice * ((100 - $scope.package.noCancellationPercent) / 100);
        return Math.ceil(standardCancellationPrice * (100 + $scope.package.profitPercentage) / 100);
    };

    $scope.calculatePayoutOfNoCancellation = function () {
        var result = $scope.package.youtripperPrice * ((100 - $scope.package.noCancellationPercent) / 100);
        return Math.ceil(result * (100 - $scope.package.ytComission) / 100);
    };

    $scope.getChildrenDiscountPrice = function (discountPercent) {
        var result = $scope.package.youtripperPrice * (100 - discountPercent) / 100;
        return Math.ceil(result);
    };

    $scope.getChildrenDiscountPriceWithSC = function (discountPercent) {
        var result = $scope.package.youtripperPrice * (100 - discountPercent) / 100;
        result = result * (100 + $scope.package.profitPercentage) / 100;
        return Math.ceil(result);
    };

    $scope.getChildrenDiscountPriceOfPayout = function (discountPercent) {
        var result = $scope.package.youtripperPrice * (100 - discountPercent) / 100;
        result = result * (100 - $scope.package.ytComission) / 100;
        return Math.ceil(result);
    };
    /* END PRICE SECTION */
    // check which section is done
    function initiateWizards() {
        validateCategoryInput() ? $scope.wizards.category = true : 0;
        validateDescriptionInput() ? $scope.wizards.description = true : 0;
        validatePhotosInput() ? $scope.wizards.photos = true : 0;
        validateBookingInput() ? $scope.wizards.booking = true : 0;
        validatePriceInput() ? $scope.wizards.price = true : 0;
        $scope.allStepDones = checkAllStepDoneYet();
    }
    initiateWizards();
    /*Open confirm message box*/
    $scope.showMissingData = true;
    $scope.nextStep = 'finish';
    $scope.conflictCycleDate = false;
    $scope.saveWithCompleteDetail = false;
    $scope.openConfirmBox = function (section) {
        $scope.nextStep = section;
        if ($scope.uploading) {
            alert("Please wait until image upload complete!");
        } else {

            $scope.showMissingData = false;
            if ($scope.selectedWizard === 'category') {
                if ($scope.selectSubCategory.id > 0 && $scope.package.colorID > 0 && $scope.checkSuitabilty() && $scope.package.targetCountryID > 0) {
                    $scope.showMissingData = true;
                    $scope.saveWithCompleteDetail = true;
                }
                ;
            } else if ($scope.selectedWizard === 'description') {
                var checkDescriptionFlag = false;
                angular.forEach(languageDescriptionList, function (languageDescription) {

                    for (i = 0; i < languageDescription.description.length; i++) {
                        if (angular.isUndefined(languageDescription.packageName) || languageDescription.packageName === '' ||
                                angular.isUndefined(languageDescription.googleDescription) || languageDescription.googleDescription === '' ||
                                languageDescription.description[i].description.length < 200 || languageDescription.description[i].header.length < 10 ||
                                languageDescription.advancedAddress.action.length === 0 || languageDescription.advancedAddress.action[0].content === "") {
                            checkDescriptionFlag = true;
                        }
                    }
                });
                // check ameniti
                for (i = 0; i < $scope.amenitiesClassifiers.length; i++)
                    if (angular.isUndefined($scope.amenitiesClassifiers[i].description) || $scope.amenitiesClassifiers[i].description.length < 100) {
                        checkDescriptionFlag = true;
                    }

                if (!checkDescriptionFlag) {
                    $scope.showMissingData = true;
                    $scope.saveWithCompleteDetail = true;
                }
            } else if ($scope.selectedWizard === 'photos') {
                if (angular.isString($scope.package.coverImage) && $scope.package.coverImage !== "" && $scope.coverImageSuccess === true) {
                    $scope.showMissingData = true;
                    $scope.saveWithCompleteDetail = true;
                }

            } else if ($scope.selectedWizard === 'booking') {
                if ($scope.package.readyBookingDurationType === "mins") {
                    $scope.package.readyBookingDuration = $scope.package.readyBookingDurationMinutes + $scope.package.readyBookingDurationHour * 60;
                }
                if (($scope.package.durationDay > 0 || $scope.package.durationMonth > 0 || $scope.package.durationYear > 0 || $scope.package.durationHour > 0 || $scope.package.durationMinute > 0) &&
                        (($scope.package.durationDay === 0 && $scope.package.servingPeriodID > 0) || $scope.package.durationDay > 0 || $scope.package.durationMonth > 0 || $scope.package.durationYear > 0)
                        && ($scope.package.isFreeBooking || (!$scope.package.isFreeBooking && ($scope.package.fixedHour !== null || $scope.package.fixedMinute !== null)))
                        && (!$scope.package.isUsingMaxQuota || ($scope.package.isUsingMaxQuota && $scope.package.maxQuota > 0))
                        ) {
                    $scope.showMissingData = true;
                    $scope.saveWithCompleteDetail = true;
                }

            } else if ($scope.selectedWizard === 'price') {
                var childrenMissingData = true;
                for (var i = 0; i < $scope.package.childrenDiscountJson.length; i++) {
                    if ($scope.package.childrenDiscountJson[i].condition === '' || $scope.package.childrenDiscountJson[i].condition === null) {
                        childrenMissingData = false;
                    }
                }

                if ($scope.package.youtripperPrice !== '' && $scope.package.youtripperPrice !== 0 && childrenMissingData &&
                        (($scope.package.packageType === 'Open' && $scope.package.minTripper > 0) || ($scope.package.packageType !== 'Open' && $scope.package.maxTripper > 0))
                        ) {
                    $scope.showMissingData = true;
                    $scope.saveWithCompleteDetail = true;
                }
            }
            if ($scope.showMissingData) {
                $scope.confirmContinue($scope.nextStep);
            } else {
                $('#ConfirmBox').toggleClass('active');
            }
        }
    };
    $scope.checkisUndefined = function (text) {
        if (angular.isUndefined(text) || text === '' || text === null) {
            return true;
        }
        return false;
    };
    $scope.checkMinName = function (text, number) {
        if (text.length < number) {
            return true;
        }
        return false;
    };
    /*Provider edit information before continue*/
    $scope.confirmEdit = function () {
        $('#ConfirmBox').removeClass('active');
    };
    /*Provider want to leave some info and go to next step*/
    $scope.confirmContinue = function (section) {
        $scope.showMissingData = true;
        $('#ConfirmBox').removeClass('active');
        $('#warningSaveBox').removeClass('active');
        if (section === 'finish') {
            $scope.moveNextWizard();
        } else {
            $scope.setSelectedWizard(section);
        }
    };
    $scope.showPickMinutes = false;
    $scope.showPickHours = false;
    $scope.pickMinuteHours = function () {
        if ($scope.package.durationType === 'minutes') {
            $scope.showPickMinutes = true;
            $scope.showPickHours = false;
        } else if ($scope.package.durationType === 'hours') {
            $scope.showPickHours = true;
            $scope.showPickMinutes = false;
        } else {
            $scope.showPickHours = false;
            $scope.showPickMinutes = false;
        }

    };
    $scope.pickMinuteHours();
    $scope.chooseNoCancellationPrice = function () {
        if ($scope.package.noCancellationPercent !== 0) {
            $scope.package.noCancellationPercent = 0;
        } else {
            $scope.package.noCancellationPercent = 1;
        }
    };
    $scope.increaseNoCancellationPercentage = function () {
        if ($scope.package.noCancellationPercent < 100) {
            $scope.package.noCancellationPercent++;
        }

    };
    $scope.descreaseNoCancellationPercentage = function () {
        if ($scope.package.noCancellationPercent > 1) {
            $scope.package.noCancellationPercent--;
        }
    };

    $scope.viewNoCancellationPrice = function (price) {
        var result = price + "%";
        return result;
    };

    //Warning on leaving
    window.onbeforeunload = function (event) {
        event.returnValue = "Don't forget to save your data before leaving!";
    };

    //Warning on inactive
    var inActiveTime = 0;
    var showingPopupInActive = false;
    function resetInitInActiveTime() {
        showingPopupInActive = false;
        var initDate = new Date();
        inActiveTime = initDate.getTime();
    }
    ;
    resetInitInActiveTime();

    function checkInActiveTime() {
        var newDate = new Date();
        var currentTime = newDate.getTime();
        if (!showingPopupInActive) {
            if (currentTime - inActiveTime > 1800000) {
                showingPopupInActive = true;
                $('#warningSaveBox').toggleClass('active');
            }
        }
    }
    ;
    $interval(checkInActiveTime, 1000);

    $scope.closeWaringSave = function () {
        resetInitInActiveTime();
        $('#warningSaveBox').toggleClass('active');
    };

    $scope.closeBookingSave = function () {
        resetInitInActiveTime();
        $('#bookingSaveBox').toggleClass('active');
    };
    var tempPackageType = 'hourly';
    $scope.changePackageTypeInBooking = function () {
        $('#bookingSaveBox').toggleClass('active');
        $scope.package.durationType = tempPackageType;

        //Reset Data
        $scope.package.durationHour = 0;
        $scope.package.durationMinute = 0;
        $scope.package.durationDay = 0;
        $scope.package.durationWeek = 0;
        $scope.package.restingtimeHour = 0;
        $scope.package.restingtimeMinute = 0;
        $scope.package.readyBookingDurationHour = 0;
        $scope.package.readyBookingDurationMinutes = 0;
        $scope.package.readyBookingDays = 0;
        $scope.package.isFreeBooking = true;
        $scope.package.freeInterval = 15;
        $scope.package.isUsingMaxQuota = true;
        $scope.package.maxQuota = 1;
        $scope.package.noLimit = 1;
        $scope.package.isSpecificLaunchDate = true;
        $scope.package.sequentialOperation = 0;
        $scope.package.isExceptSunday = false;
        $scope.package.isExceptMonday = false;
        $scope.package.isExceptTuesday = false;
        $scope.package.isExceptWednesday = false;
        $scope.package.isExceptThursday = false;
        $scope.package.isExceptFriday = false;
        $scope.package.isExceptSaturday = false;
        $scope.package.isWorkingEveryday = true;
        $scope.package.tempSpecificDateSlots = [];
    };
    var oldDurationHour = 0;
    $scope.$watch('package.durationHour', function (newVal, oldVal) {
        oldDurationHour = oldVal;
        console.log(newVal);
        if (newVal !== oldVal && newVal === 0 && $scope.package.isFreeBooking === false) {
            //show warning
            $('#lowDurationBox').toggleClass('active');
        }
    });

    $scope.closelowDurationBox = function () {
        $scope.package.durationHour = oldDurationHour;
        $('#lowDurationBox').toggleClass('active');
    };

    $scope.selectLowDurationHour = function () {
        $scope.setIsFreeBooking(true);
        $('#lowDurationBox').toggleClass('active');
    };

    $scope.loaded = true;
});
myApp.controller('PackageEdittingController', function ($scope, $http, $timeout, service, $interval) {
    $scope.loaded = false;
    /* COMMON */
    $scope.wizards = {"category": false, "description": false, "photos": false, "booking": false, "price": false};
    $scope.selectedWizard = "category";
    $scope.allStepDones = false;
    $scope.contentStep = ["Let's start, only 5 steps to go!", "One down, 4 steps to go!", "Yor are doing great, 3 steps to go!",
        "Nearly there, just 2 steps to go!", "One last step and you are ready for the world!", "All done!"];
    $scope.noSuccessStep = 0;
//    $scope.showCountryTarget = function () {
//        $(".CountryTarget").toggleClass("active");
//    };
//    
//    $scope.chooseTargetCountry = function (name, ID) {
//        $(".CountryTarget").removeClass("active");
//        var getValue = document.getElementsByClassName("businessTypeSelect")[0];
//        getValue.innerHTML = name;
//        $scope.package.targetCountryID = ID;
//};
    $scope.package = packageEdit;
    $scope.package.isSpecificLaunchDate = true;

    $scope.packageForm = packageForm;
    //assign to hour + minute ready booking 
    if ($scope.package.readyBookingDurationType === "mins") {
        if ($scope.package.readyBookingDuration >= 60) {
            $scope.package.readyBookingDurationHour = Math.floor($scope.package.readyBookingDuration / 60);
            if (!($scope.package.readyBookingDurationHour > 0)) {
                $scope.package.readyBookingDurationHour = 0;
            }
            $scope.package.readyBookingDurationMinutes = $scope.package.readyBookingDuration - $scope.package.readyBookingDurationHour * 60;
        } else {
            $scope.package.readyBookingDurationMinutes = $scope.package.readyBookingDuration;
            $scope.package.readyBookingDurationHour = 0;
        }
    } else {
        $scope.package.readyBookingDurationHour = 0;
        $scope.package.readyBookingDurationMinutes = 0;
    }

    // when click in the sections menu
    $scope.setSelectedWizard = function (wizard) {
        // check selected wizard is done yet, if not do not move
        //        if ($scope.wizards[wizard]) {
        // else call save
        saveWizard($scope.selectedWizard, wizard, "set");
        //        }
    };
    // when click button next to save
    $scope.moveNextWizard = function () {
        // get next Step
        var nextStep, nextStepIndex;
        var keys = Object.keys($scope.wizards);
        for (var i = 0, max = keys.length; i < max; i++) {
            var wizard = keys[i];
            if (wizard === $scope.selectedWizard) {
                if (i === (max - 1)) {
                    nextStepIndex = 0;
                } else {
                    nextStepIndex = (i + 1);
                }
            }
        }
        nextStep = keys[nextStepIndex];
        // call save funciton to validate and save
        saveWizard($scope.selectedWizard, nextStep, "next");
    };
    // click finish after all sections done
    $scope.finishToPreview = function () {
        saveWizard($scope.selectedWizard, null, "finish");
    };
    // function to check array of sections done yet
    function checkAllStepDoneYet() {
        $scope.noSuccessStep = 0;
        var done = true;
        angular.forEach($scope.wizards, function (isDone, wizardName) {
            if (!isDone) {
                done = false;
            } else {
                $scope.noSuccessStep++;
            }
        });
        return done;
    }

    var CATEGORY_URL = service.getContextPath() + "/Provider/Package/editActivities";
    var DESCRIPTION_URL = service.getContextPath() + "/Provider/Package/editDescription";
    var PHOTOS_URL = service.getContextPath() + "/Provider/Package/editPhotos";
    var BOOKING_URL = service.getContextPath() + "/Provider/Package/editBookingRegistration";
    var PRICE_URL = service.getContextPath() + "/Provider/Package/editPrice";
    //    var FINISH_PAGE = service.getContextPath() + "/Provider/Package/PreView/" + $scope.package.id;
    var FINISH_PAGE = service.getContextPath() + "/Provider/Package/Apply/" + $scope.package.id;
    var ERROR_PAGE = service.getContextPath() + service.getErrorPageUrl();
    $scope.saving = false;
    // check and save wizard, return true or false
    function saveWizard(currentWizard, moveStep, saveType) {
        $scope.saving = true;
        // validate input
        var validateFlag = false;
        var url = "", data = {};
        if (currentWizard === "category") {
            //            validateFlag = validateCategoryInput();
            validateFlag = true; // Allow save information with missing detail
            url = CATEGORY_URL;
            validateFlag ? data = getCategoryData() : 0;
        } else if (currentWizard === "photos") {
            //            validateFlag = validatePhotosInput();
            validateFlag = true; // Allow save information with missing detail
            url = PHOTOS_URL;
            validateFlag ? data = getPhotoForm() : 0;
        } else if (currentWizard === "description") {
            //            validateFlag = validateDescriptionInput();
            validateFlag = true; // Allow save information with missing detail
            url = DESCRIPTION_URL;
            validateFlag ? data = getDescriptionData() : 0;
        } else if (currentWizard === "price") {
            //            validateFlag = validatePriceInput();
            validateFlag = true; // Allow save information with missing detail
            url = PRICE_URL;
            validateFlag ? data = getPriceData() : 0;
        } else if (currentWizard === "booking") {
            //            validateFlag = validateBookingInput();
            validateFlag = true; // Allow save information with missing detail
            url = BOOKING_URL;
            validateFlag ? data = getBookingInput() : 0;
        }

        // if correct, ajax to save and check all sections done yet to show finish button, and move to selected step
        if (validateFlag) {
            $http.post(url, data)
                    .then(function successCallback(response) {
                        if (response.data.result === "error") {
                            $(location).attr('href', ERROR_PAGE);
                        } else {
                            if (saveType !== "finish") { // if not finish button is click
                                if ($scope.saveWithCompleteDetail === true) {
                                    $scope.wizards[$scope.selectedWizard] = true;
                                    $scope.saveWithCompleteDetail = false;
                                }

                                $scope.selectedWizard = moveStep;
                                // check all step done or not
                                $scope.allStepDones = checkAllStepDoneYet();
                                $scope.saving = false;
                                resetInitInActiveTime();
                                $('html, body').animate({
                                    scrollTop: 0
                                }, 300);
                            } else {
                                $(location).attr('href', FINISH_PAGE);
                            }
                        }
                    });
        } else {
            if (saveType === "set") {
                $scope.selectedWizard = moveStep;
            }
            // if not, false
            $scope.saving = false;
        }
    }

    var PREVIEW_PAGE = service.getContextPath() + "/Provider/PreView/" + $scope.package.id;
    $scope.goToPreviewPage = function () {
        window.open(PREVIEW_PAGE, '_blank');
    };
    /* END COMMON */

    /* CATEGORY SECTION */
    $scope.checkSuitabilty = function () {
        var result = false;
        angular.forEach($scope.package.suitabilityClassifiers, function (suitability) {
            if (suitability.selected) {
                result = true;
            }
        });
        return result;
    };
    $scope.packageForm.targetCountry.unshift({"targetCountryID": 0, "name": "Choose a location cluster"});
    function validateCategoryInput() {
        if ($scope.selectedAtivites.length > 0 && $scope.package.colorID > 0 && $scope.checkSuitabilty() && $scope.package.targetCountryID > 0) {
            return true;
        }
        return false;
    }
    /*Get Data From Category*/
    /*Get Data From Category*/
    $scope.selectNotListedSubID = 0;
    $scope.notListedContent = {'value': ''};
    $scope.selectedAtivites = [];
    function getCategoryData() {
        /*Prepair content of Other Sub Category*/

        var data = {"packageID": $scope.package.id, "activities": $scope.selectedAtivites,
            "tripID": 1, "groupID": 0,
            "suitability": $scope.package.suitabilityClassifiers,
            "subCategoryContent": $scope.notListedContent.value,
            "categoryID": $scope.selectNotListedSubID, "targetCountryID": $scope.package.targetCountryID, "packageColor": $scope.package.colorID, "adventureLevel": $scope.package.adventureLevel,
            "challengeLevel": $scope.package.challengeLevel, "friendshipLevel": $scope.package.friendshipLevel, "happinessLevel": $scope.package.happinessLevel,
            "healthinessLevel": $scope.package.healthinessLevel, "knowledgeLevel": $scope.package.knowledgeLevel, "peacefulnessLevel": $scope.package.peacefulnessLevel,
            "romanceLevel": $scope.package.romanceLevel, "sophisticationLevel": $scope.package.sophisticationLevel, "unexpectedLevel": $scope.package.unexpectedLevel};
        return data;
    }
    /*Search ACtivity*/

    for (var i = 0; i < $scope.package.classifiers.length; i++) { // find category selected and sub selected
        var selectdSubCategoryID = $scope.package.classifiers[i].subCategoryID;
        var activityName = $scope.package.classifiers[i].activityName;
        var activityID = $scope.package.classifiers[i].activityID;
        var content = $scope.package.classifiers[i].content;
        angular.forEach($scope.packageForm.categoryRelation, function (category, categoryID) {

            angular.forEach(category.subCategories, function (subCategory, subID) {
                if (subCategory.subCategoryID === selectdSubCategoryID) {
                    $scope.selectedSubCategoryID = Number(selectdSubCategoryID);
                    $scope.selectedCategoryID = Number(subCategory.categoryID);
                    subCategory.selected = true;
                    category.selected = true;
                    angular.forEach(subCategory.activites, function (activity, actID) {
                        if (activity.activityID === activityID) {
                            activity.content = content;
                            var newActivity = {"activityID": activityID, "name": activityName, "subCategoryID": selectdSubCategoryID, "totalRecords": 0, "content": content};
                            $scope.selectedAtivites.push(newActivity);
                        }
                    });
                    if (subCategory.name === "Not Listed") {

                        $scope.selectNotListedSubID = Number(subCategory.subCategoryID);
                        $scope.notListedContent.value = $scope.package.otherSubCategoryName;
                    }
                }
            });
        });
    }
    $scope.searchActivityFlag = false;
    $scope.searchActivityResult = {"activityList": [], "subCategoryList": [], "categoryList": []};
    $scope.checkSearchActivityFocus = function () {
        $(document).on('focus', '#searchActivity', function () { // when tr is hover
            $('#search-activity-result').addClass("showResult");
        }).on('focusout', '#searchActivity', function () { // when tr is no longer hovered
            setTimeout(function () {
                $('#search-activity-result').removeClass("showResult");
            }, 400);
        });
    };

    /*Load Not listed Sub Category From Database*/
    $scope.getOtherSubCateContent = function (categoryID, subCategoryID) {
        $scope.selectedSubCategoryID = Number(subCategoryID);
        $scope.selectedCategoryID = Number(categoryID);
        angular.forEach($scope.packageForm.categoryRelation, function (category, cateID) {
            if (category.categoryID === Number($scope.package.categoryID)) {
                angular.forEach(category.subCategories, function (subCategory, subID) {
                    if (subCategory.subCategoryID === $scope.selectedSubCategoryID) {
                        subCategory.content = $scope.package.otherSubCategoryName;
                    }
                });
            }

        });
        return true;
    };
    /*Set normal value for Category and SubCategory*/
    $scope.selectNormalSubCategory = function (categoryID, subCategoryID) {
        $scope.selectedSubCategoryID = Number(subCategoryID);
        $scope.selectedCategoryID = Number(categoryID);
    };

    /*New Category Select Start*/

    console.log($scope.selectedSubCategoryID);

    $scope.selectSubCategoryActivity = function (cateID, SubCateID) {
        if ($scope.selectedAtivites.length > 0) {
            $scope.selectedAtivites = [];
        }
        angular.forEach($scope.packageForm.categoryRelation, function (category, catesID) {
            if (category.categoryID === Number(cateID)) {
                angular.forEach(category.subCategories, function (subCategory, subID) {
                    if (subCategory.subCategoryID === SubCateID && subCategory.name !== "Not Listed") {
                        $scope.selectNotListedSubID = 0;
                        var newActivity = {"activityID": subCategory.activites[0].activityID, "name": subCategory.activites[0].name, "subCategoryID": subCategory.subCategoryID, "totalRecords": 0, "content": ""};
                        $scope.selectedAtivites.push(newActivity);
                    } else if (subCategory.subCategoryID === SubCateID && subCategory.name === "Not Listed") {
                        $scope.selectedCategoryID = Number(category.categoryID);
                        $scope.selectNotListedSubID = subCategory.subCategoryID;
                        var newActivity = {"activityID": subCategory.activites[0].activityID, "name": subCategory.activites[0].name, "subCategoryID": subCategory.subCategoryID, "totalRecords": 0, "content": "newTemActivity"};
                        $scope.selectedAtivites.push(newActivity);
                    }
                });
            }

        });
    };

    $scope.selectNewCategory = function (id) {
        if ($scope.selectedCategoryID !== id) {
            $scope.selectedCategoryID = id;
            $scope.selectedSubCategoryID = 0;
            $scope.selectNotListedSubID = 0;
            $scope.notListedContent = {'value': ''};
            $scope.selectedAtivites = [];
        }

    };

    //Load new category data of package

    /*New Category Select End*/

    /*Init color palette for package color*/
    $scope.packageColorInit = function () {
        $('#ColorValue').val($scope.package.colorID);
        $('.packageColorInput').val($scope.package.colorID);
        $('[name="PackageColorSelection"]').paletteColorPicker();
    };
    $scope.showColorPalette = function () {
        $('.PackageColorMenu').addClass('active');
    };
    /*Get Color Code by ColorID*/
    $scope.getColorCode = function (id) {
        var result = "";
        angular.forEach($scope.packageForm.packageColor, function (child) {
            if (Number(child.colorID) === Number(id)) {
                result = child.colorCode;
            }
        });
        return result;
    };
    /*Change selected package color*/
    $scope.changeSelectedColor = function (id) {
        $scope.package.colorID = id;
    };
    /*Init function for category*/
    $scope.initCategory = function () {
        //Init for slider

    };
    $scope.selectSuitabilityUniversal = function (val) {
        if (val === "Universal") {
            angular.forEach($scope.package.suitabilityClassifiers, function (child) {
                if (child.suitabilityName !== 'Universal') {
                    child.selected = false;
                }
            });
        } else {
            angular.forEach($scope.package.suitabilityClassifiers, function (child) {
                if (child.suitabilityName === 'Universal') {
                    child.selected = false;
                }
            });
        }
    };
    /* END CATEGORY SECTION */

    /* DESCRIPTION SECTION */

    // convert all to json
    var languageDescriptionList = $scope.package.languageDescriptionList;
    function convertAdvancedDescriptionToJson() {
        for (var i = 0, max = languageDescriptionList.length; i < max; i++) {
            var languageDescription = languageDescriptionList[i];
            languageDescription.description = JSON.parse(languageDescription.description);
            languageDescription.advancedAddress = JSON.parse(languageDescription.advancedAddress);
            if (angular.isString(languageDescription.keywords)) {
                languageDescription.keywords = JSON.parse(languageDescription.keywords);
            }
            if (angular.isString(languageDescription.language)) {
                languageDescription.language = JSON.parse(languageDescription.language);
            }
        }
    }
    convertAdvancedDescriptionToJson();
    // function change languge description
    $scope.selectedLanguageDescription;
    $scope.showLanguageDescription = function (languageID) {
        if ($scope.selectedLanguageDescription === undefined || languageID !== $scope.selectedLanguageDescription.languageID) {
            for (var i = 0, max = languageDescriptionList.length; i < max; i++) {
                var languageDescription = languageDescriptionList[i];
                if (languageID === languageDescription.languageID) {
                    $scope.selectedLanguageDescription = languageDescription;
                    // update mask input
                    $timeout(function () {
                        $(".timeMaskInput").inputmask("h:s", {
                            onKeyValidation: function (key, result) {
                                angular.element($(this)).triggerHandler('input');
                            }
                        });
                    }, 100);
                }
            }
        }
    };
    //    change language list to hash map and get english ID
    var englishDescription;
    $scope.languages = {};
    function convertLanguageListToHash() {
        var languageList = $scope.packageForm.languageList;
        for (var i = 0, max = languageList.length; i < max; i++) {
            var language = languageList[i];
            var languageID = language.languageID;
            $scope.languages[languageID] = language;
            if (language.languageName === "English") {
                $scope.showLanguageDescription(languageID);
                englishDescription = $scope.selectedLanguageDescription;
            }
        }
    }
    convertLanguageListToHash();
    $scope.addNewAdvancedDescription = function () {
        // add new description for all exsiting language
        for (var i = 0, max = languageDescriptionList.length; i < max; i++) {
            var signleDescription = {"header": "", "description": ""};
            languageDescriptionList[i]["description"].push(signleDescription);
        }
    };
    $scope.deleteAdvancedDescription = function (index) {
        // delete from all exsiting language
        for (var i = 0, max = languageDescriptionList.length; i < max; i++) {
            var advancedDescription = languageDescriptionList[i]["description"];
            if (advancedDescription.length > 1) {
                advancedDescription.splice(index, 1);
            }
        }
    };
    $scope.moveDescriptionUp = function (index) {
        // move in all existing language
        if (index !== 0) {
            for (var i = 0, max = languageDescriptionList.length; i < max; i++) {
                var advancedDescription = languageDescriptionList[i]["description"];
                var tempDescription = advancedDescription[index];
                advancedDescription[index] = advancedDescription[index - 1];
                advancedDescription[index - 1] = tempDescription;
            }
        }
    };
    $scope.moveDescriptionDown = function (index) {
        // move in all existing language
        var max = languageDescriptionList.length;
        if (index !== (max - 1)) {
            for (var i = 0; i < max; i++) {
                var advancedDescription = languageDescriptionList[i]["description"];
                var tempDescription = advancedDescription[index];
                advancedDescription[index] = advancedDescription[index + 1];
                advancedDescription[index + 1] = tempDescription;
            }
        }
    };
    // amenities
    $scope.amenitiesClassifiers = $scope.package.amenitiesClassifiers;
    $scope.selectedListAmenities = [];
    // find out selected amenities from data
    for (var i = 0, max = $scope.amenitiesClassifiers.length; i < max; i++) { // loop selected amenties classfier

        // get an amenties from classifier
        var amenitiesClassifier = $scope.amenitiesClassifiers[i];
        var amenities = {"amenitiesID": amenitiesClassifier.amenitiesID, "amenitiesType": amenitiesClassifier.amenitiesName, "icon": amenitiesClassifier.amenitiesIcon};
        // add to list
        $scope.selectedListAmenities.push(amenities);
    }

    //conver list certificates to hash
    $scope.providerCertificates = {};
    function convertProviderCertificatesToHashMap() {
        $scope.providerCertificates = {};
        for (var i = 0, max = $scope.packageForm.certificates.length; i < max; i++) {
            var certificate = $scope.packageForm.certificates[i];
            $scope.providerCertificates[certificate.certificateID] = certificate;
        }
    }
    convertProviderCertificatesToHashMap();
    // find out selected certificate from data
    for (var i = 0, max = $scope.package.certificates.length; i < max; i++) {

    }

    // get length before list change to check list is inserted or deleted
    var oldAmenitiesLen = $scope.selectedListAmenities.length;
    $scope.amenitiesListChange = function () {
        oldAmenitiesLen = $scope.selectedListAmenities.length;
    };
    // add new amenities description to all language or delete
    $scope.validateListAmenities = function (newAmenity) {
        var newLength = $scope.selectedListAmenities.length;
        if (newLength > oldAmenitiesLen) { // add

            for (var i = 0, max = languageDescriptionList.length; i < max; i++) {
                var languageID = languageDescriptionList[i].languageID;
                var amenitiesClassifier = {"packageID": $scope.package.id, "amenitiesID": newAmenity.amenitiesID, "amenitiesName": newAmenity.amenitiesType,
                    "amenitiesIcon": newAmenity.icon, "description": "", "languageID": languageID};
                $scope.amenitiesClassifiers.push(amenitiesClassifier);
            }

        } else if (newLength < oldAmenitiesLen) { // remove
            var removeID = newAmenity.amenitiesID;
            for (var i = ($scope.amenitiesClassifiers.length - 1); i >= 0; i--) {
                var amenitiesID = $scope.amenitiesClassifiers[i].amenitiesID;
                if (amenitiesID === removeID) {
                    $scope.amenitiesClassifiers.splice(i, 1);
                }
            }
        }
    };
    // construct list of selected certificate ids
    $scope.listSelectedCertificateIDs = [];
    $scope.toggleCertificateBox = function () {
        if (!$("#certificatePopup.ytPopup").hasClass("active")) { //before opening popup, con struct list of certficiate ids
            $scope.listSelectedCertificateIDs = [];
            for (var i = 0, max = $scope.package.certificates.length; i < max; i++) {
                var certificateID = $scope.package.certificates[i].certificateID;
                $scope.listSelectedCertificateIDs.push(certificateID);
            }

            var windownHeight = $(window).height(); // returns height of browser viewport
            $("#certificatePopup.ytPopup .popupScroll").css("max-height", (windownHeight - 50) + "px");
        }

        $("#certificatePopup.ytPopup").toggleClass("active");
    };
    // when click choose from popup
    $scope.chooseCertficates = function () {
        if ($scope.listSelectedCertificateIDs.length <= 4) {
            $scope.package.certificates = [];
            for (var i = 0, max = $scope.listSelectedCertificateIDs.length; i < max; i++) {
                var certificateID = $scope.listSelectedCertificateIDs[i];
                var providerCertificate = $scope.providerCertificates[certificateID];
                var newCertficiate = {"certificateID": providerCertificate.certificateID, "packageID": $scope.package.id,
                    "imageLink": providerCertificate.image};
                $scope.package.certificates.push(newCertficiate);
            }

            $scope.toggleCertificateBox();
        } else {
            alert("Sorry, you can choose only four certificates for this package!");
        }
    };
    var certificateUploadingUrl = service.getContextPath() + "/Provider/Package/CertificateUploading";
    $scope.certificateImageFile;
    var ERROR_PAGE = service.getContextPath() + service.getErrorPageUrl();
    $scope.certificateUploading = false;
    $scope.uploadCertificateImage = function () {
        if ($scope.certificateImageFile) {
            $scope.certificateUploading = true;
            var oMyForm = new FormData();
            oMyForm.append("certificateImage", $scope.certificateImageFile);
            var data = "{'packageID': " + $scope.package.id + ", 'name': ''}";
            oMyForm.append("dataJson", data);
            $.ajax({
                url: certificateUploadingUrl,
                data: oMyForm,
                dataType: 'text',
                processData: false,
                contentType: false,
                type: 'POST',
                success: function (data) {
                    data = JSON.parse(data);
                    if (data.result !== "error") {
                        $scope.packageForm.certificates = data.result;
                        convertProviderCertificatesToHashMap();
                        $scope.certificateUploading = false;
                        $scope.$digest();
                    } else {
                        $(location).attr('href', ERROR_PAGE);
                    }
                }, error: function (respone) {
                    $(location).attr('href', ERROR_PAGE);
                }
            });
        }
    };
    // Location
    $scope.locationTypes = [
        {"locationType": "action", "text": "Add an action location", "title": "Action Location"},
        {"locationType": "departure", "text": "Add an departure location", "title": "Departure Location"},
        {"locationType": "pickup", "text": "Add an pickup location", "title": "Pickup Location"}
    ];
    $scope.selectedLocationType = 'action';
    $scope.changeLocationType = function (type) {
        $scope.selectedLocationType = type;
        // update mask input
        $timeout(function () {
            $(".timeMaskInput").inputmask("h:s", {
                onKeyValidation: function (key, result) {
                    angular.element($(this)).triggerHandler('input');
                }
            });
        }, 100);
    };
    var addMode;
    $scope.addLocation = function (type) {
        $("#location-popup").toggleClass("active");
        setTimeout(function () {
            initPopUpMap();
            addMode = true;
            locationTypeTemp = type;
        }, 100);
    };
    $scope.closeLocationPopUp = function () {
        $("#location-popup").toggleClass("active");
    };
    // remove from all language
    $scope.addExplaination = function (index, selectedLocationType) {
        for (var i = 0, max = languageDescriptionList.length; i < max; i++) {
            var advancedAddress = languageDescriptionList[i].advancedAddress;
            var addressDetail = advancedAddress[selectedLocationType][index];
            addressDetail["accessDescription"] = "";
        }
    };
    $scope.removeExplaination = function (index, selectedLocationType) {
        for (var i = 0, max = languageDescriptionList.length; i < max; i++) {
            var advancedAddress = languageDescriptionList[i].advancedAddress;
            var addressDetail = advancedAddress[selectedLocationType][index];
            addressDetail["accessDescription"] = undefined;
        }
    };
    $scope.addExplainationTemp = function () {
        $scope.addressDetailTemp["accessDescription"] = "";
    };
    $scope.removeExplainationTemp = function () {
        $scope.addressDetailTemp["accessDescription"] = undefined;
    };
    // for language pop up
    $scope.selectedLanguageID = 0;
    $scope.toggleLanguageBox = function () {
        $scope.selectedLanguageID = 0;
        $("#languagePopup.certificateBox").toggleClass("active");
    };
    $scope.toggleLocationBox = function () {
        $("#location-popup").toggleClass("active");
        searchBoxPopUp.value = "";
        $scope.addressDetailTemp = {"lat": "", "lng": "",
            "addr": "", "startTime": "", "endTime": "",
            "content": "", "country": "", "city": "", "accessDescription": ""};
    };
    var map, searchBox, additionalAutocomplete, currentLocation = {}, newPlace;
    $scope.selectedMarker;
    var initMap = function () {
        map = new google.maps.Map(document.getElementById('map'), {
            center: new google.maps.LatLng(currentLocation.lat, currentLocation.lng),
            zoom: 17,
            draggable: true
        });
        updateMarkerArray();
        $(".timeMaskInput").inputmask("h:s", {
            onKeyValidation: function (key, result) {
                angular.element($(this)).triggerHandler('input');
            }
        });
        $scope.mapLoaded = true;
    };
    var marker, mapPopUp, searchBoxPopUp, newPlacePopUp, additionalAutocompletePopUp;
    var infowindow = new google.maps.InfoWindow({
        content: ''
    });
    $scope.addressDetailTemp = {"lat": "", "lng": "",
        "addr": "", "startTime": "", "endTime": "",
        "content": "", "country": "", "city": "", "accessDescription": ""};
    var initPopUpMap = function () {

        mapPopUp = new google.maps.Map(document.getElementById('map-pop-up'), {
            center: new google.maps.LatLng(currentLocation.lat, currentLocation.lng),
            zoom: 17,
            draggable: true
        });
        // enable autocomplete for first additional input

        searchBoxPopUp = (document.getElementById('additionalAutocompletePopUp'));
        additionalAutocompletePopUp = new google.maps.places.SearchBox(searchBoxPopUp);
        // search result depends on map bound
        mapPopUp.addListener('bounds_changed', function () {
            additionalAutocompletePopUp.setBounds(mapPopUp.getBounds());
        });
        additionalAutocompletePopUp.addListener('places_changed', function () {
            newPlacePopUp = additionalAutocompletePopUp.getPlaces()[0];
            if (!newPlacePopUp.geometry) {
                window.alert("Autocomplete's returned place contains no geometry");
                return;
            } else {
                window.setTimeout(function () {
                    if (marker !== undefined) {
                        marker.setMap(null);
                    }
                    marker = new google.maps.Marker({
                        position: newPlacePopUp.geometry.location,
                        map: mapPopUp,
                        title: newPlacePopUp.name
                    });
                    infowindow = new google.maps.InfoWindow({
                        content: $scope.addressDetailTemp.addr
                    });
                    infowindow.open(mapPopUp, marker);
                    mapPopUp.panTo(marker.getPosition());
                }, 300);
                //get address
                $scope.addressDetailTemp.addr = newPlacePopUp.formatted_address;
                $scope.addressDetailTemp.lat = newPlacePopUp.geometry.location.lat();
                $scope.addressDetailTemp.lng = newPlacePopUp.geometry.location.lng();
                //get city and country
                var addressComponents = newPlacePopUp.address_components;
                for (var j = 0, len = addressComponents.length; j < len; j++) {
                    var searchAdd = addressComponents[j];
                    if (searchAdd.types[0] === "locality") {
                        $scope.addressDetailTemp.city = searchAdd["long_name"];
                    } else if (searchAdd.types[0] === "country") {
                        $scope.addressDetailTemp.country = searchAdd["long_name"];
                    }
                }

                $scope.$digest();
            }
        });
        google.maps.event.addListener(mapPopUp, 'click', function (event) {
            if (marker.map !== null) {
                marker.setMap(null);
            }
            ;
            marker = new google.maps.Marker({
                position: event.latLng,
                map: mapPopUp,
                title: $scope.addressDetailTemp.addr
            });
            infowindow = new google.maps.InfoWindow({
                content: $scope.addressDetailTemp.addr
            });
            infowindow.open(mapPopUp, marker);
            mapPopUp.panTo(marker.getPosition());
            $scope.addressDetailTemp.lat = event.latLng.lat();
            $scope.addressDetailTemp.lng = event.latLng.lng();
        });
        loaded = true;
        $timeout(function () {
            $(".timeMaskInput").inputmask("h:s", {
                onKeyValidation: function (key, result) {
                    angular.element($(this)).triggerHandler('input');
                }
            });
        }, 100);
    };
    var editMapPopUp = function (lat, lng) {
        mapPopUp = new google.maps.Map(document.getElementById('map-pop-up'), {
            center: new google.maps.LatLng(lat, lng),
            zoom: 17,
            draggable: true
        });
        marker = new google.maps.Marker({
            position: new google.maps.LatLng(lat, lng),
            map: mapPopUp,
            title: $scope.addressDetailTemp.addr
        });
        infowindow = new google.maps.InfoWindow({
            content: $scope.addressDetailTemp.addr
        });
        infowindow.open(mapPopUp, marker);
        mapPopUp.panTo(marker.getPosition());
        // enable autocomplete for first additional input

        searchBoxPopUp = (document.getElementById('additionalAutocompletePopUp'));
        additionalAutocompletePopUp = new google.maps.places.SearchBox(searchBoxPopUp);
        // search result depends on map bound
        mapPopUp.addListener('bounds_changed', function () {
            additionalAutocompletePopUp.setBounds(mapPopUp.getBounds());
        });
        additionalAutocompletePopUp.addListener('places_changed', function () {
            newPlacePopUp = additionalAutocompletePopUp.getPlaces()[0];
            if (!newPlacePopUp.geometry) {
                window.alert("Autocomplete's returned place contains no geometry");
                return;
            } else {
                window.setTimeout(function () {
                    marker.setMap(null);
                    marker = new google.maps.Marker({
                        position: newPlacePopUp.geometry.location,
                        map: mapPopUp,
                        title: newPlacePopUp.name
                    });
                    var infowindow = new google.maps.InfoWindow({
                        content: newPlacePopUp.formatted_address
                    });
                    infowindow.open(mapPopUp, marker);
                    mapPopUp.panTo(marker.getPosition());
                }, 300);
                //get address
                $scope.addressDetailTemp.addr = newPlacePopUp.formatted_address;
                $scope.addressDetailTemp.lat = newPlacePopUp.geometry.location.lat();
                $scope.addressDetailTemp.lng = newPlacePopUp.geometry.location.lng();
                //get city and country
                var addressComponents = newPlacePopUp.address_components;
                for (var j = 0, len = addressComponents.length; j < len; j++) {
                    var searchAdd = addressComponents[j];
                    if (searchAdd.types[0] === "locality") {
                        $scope.addressDetailTemp.city = searchAdd["long_name"];
                    } else if (searchAdd.types[0] === "country") {
                        $scope.addressDetailTemp.country = searchAdd["long_name"];
                    }
                }

                $scope.$digest();
            }
        });
        google.maps.event.addListener(mapPopUp, 'click', function (event) {
            marker.setMap(null);
            marker = new google.maps.Marker({
                position: event.latLng,
                map: mapPopUp,
                title: $scope.addressDetailTemp.addr
            });
            var infowindow = new google.maps.InfoWindow({
                content: $scope.addressDetailTemp.addr
            });
            infowindow.open(mapPopUp, marker);
            mapPopUp.panTo(marker.getPosition());
            $scope.addressDetailTemp.lat = event.latLng.lat();
            $scope.addressDetailTemp.lng = event.latLng.lng();
        });
        loaded = true;
        $timeout(function () {
            $(".timeMaskInput").inputmask("h:s", {
                onKeyValidation: function (key, result) {
                    angular.element($(this)).triggerHandler('input');
                }
            });
        }, 100);
    };
    var promise;
    var loaded = false;
    $scope.$watch('addressDetailTemp.addr', function (newVal, oldVal) {
        $timeout.cancel(promise);
        promise = $timeout(function () {
            if (newVal !== oldVal && loaded) {
                infowindow.close();
                infowindow.setContent($scope.addressDetailTemp.addr);
                infowindow.open(mapPopUp, marker);
            }
        }, 1000);
    }, true);
    $scope.showMissingDataPopUpLocation = false;
    $scope.saveLocationTemp = function () {
        if ($scope.addressDetailTemp.addr !== "" && $scope.addressDetailTemp.content !== "") {
            if (addMode) {
                if (angular.isString($scope.addressDetailTemp.addr) && $scope.addressDetailTemp.addr !== "") {
                    // add to all language
                    for (var i = 0, max = languageDescriptionList.length; i < max; i++) {
                        // get data 
                        var advancedAddress = languageDescriptionList[i].advancedAddress;
                        var newAddr = {"lat": $scope.addressDetailTemp.lat, "lng": $scope.addressDetailTemp.lng,
                            "addr": $scope.addressDetailTemp.addr, "startTime": $scope.addressDetailTemp.startTime, "endTime": $scope.addressDetailTemp.endTime,
                            "content": $scope.addressDetailTemp.content, "country": $scope.addressDetailTemp.country, "city": $scope.addressDetailTemp.city, "accessDescription": $scope.addressDetailTemp.accessDescription};
                        advancedAddress[locationTypeTemp].push(newAddr);
                    }

                    updateMarkerArray();
                    $scope.addressDetailTemp = {"lat": "", "lng": "",
                        "addr": "", "startTime": "", "endTime": "",
                        "content": "", "country": "", "city": "", "accessDescription": ""};
                    searchBoxPopUp.value = "";
                    $("#location-popup").toggleClass("active");
                }
            } else {
                for (var i = 0, max = languageDescriptionList.length; i < max; i++) {
                    var currentAddress = languageDescriptionList[i].advancedAddress[locationTypeTemp][indexTemp];
                    currentAddress.lat = $scope.addressDetailTemp.lat;
                    currentAddress.lng = $scope.addressDetailTemp.lng;
                    currentAddress.startTime = $scope.addressDetailTemp.startTime;
                    currentAddress.endTime = $scope.addressDetailTemp.endTime;
                }
                var currentAddress = $scope.selectedLanguageDescription.advancedAddress[locationTypeTemp][indexTemp];
                currentAddress.addr = $scope.addressDetailTemp.addr;
                currentAddress.content = $scope.addressDetailTemp.content;
                currentAddress.country = $scope.addressDetailTemp.country;
                currentAddress.city = $scope.addressDetailTemp.city;
                currentAddress.accessDescription = $scope.addressDetailTemp.accessDescription;
                updateMarkerArray();
                $scope.addressDetailTemp = {"lat": "", "lng": "",
                    "addr": "", "startTime": "", "endTime": "",
                    "content": "", "country": "", "city": "", "accessDescription": ""};
                searchBoxPopUp.value = "";
                $("#location-popup").toggleClass("active");
            }
        } else {
            $scope.showMissingDataPopUpLocation = true;
        }

    };
    var locationTypeTemp, indexTemp;
    $scope.editLocation = function (index, locationType) {
        var currentAddress = $scope.selectedLanguageDescription.advancedAddress[locationType][index];
        $scope.addressDetailTemp.lat = currentAddress.lat;
        $scope.addressDetailTemp.lng = currentAddress.lng;
        $scope.addressDetailTemp.addr = currentAddress.addr;
        $scope.addressDetailTemp.startTime = currentAddress.startTime;
        $scope.addressDetailTemp.endTime = currentAddress.endTime;
        $scope.addressDetailTemp.content = currentAddress.content;
        $scope.addressDetailTemp.country = currentAddress.country;
        $scope.addressDetailTemp.city = currentAddress.city;
        $scope.addressDetailTemp.accessDescription = currentAddress.accessDescription;
        $("#location-popup").toggleClass("active");
        setTimeout(function () {
            editMapPopUp(currentAddress.lat, currentAddress.lng);
            addMode = false;
            locationTypeTemp = locationType;
            indexTemp = index;
        }, 100);
    };
    $scope.deleteLocation = function (index, locationType) {
        for (var i = 0, max = languageDescriptionList.length; i < max; i++) {
            languageDescriptionList[i].advancedAddress[locationType].splice(index, 1);
        }

    };
    function changeLatLngOffAllLanguage(lat, lng, type, index) {
        if (lat !== "" && lng !== "") {
            for (var i = 0, max = languageDescriptionList.length; i < max; i++) {
                var advancedAddress = languageDescriptionList[i].advancedAddress;
                advancedAddress[type][index].lat = lat;
                advancedAddress[type][index].lng = lng;
            }
        }
    }

    // get geolocation for map
    $scope.mapLoaded = false;
    $scope.getGeolocation = function () {
        $scope.mapLoaded = false;
        var data = '{"wifiAccessPoints":[{"macAddress": "' + macAddress + '","signalStrength": -65,"age": 0,"channel": 11,"signalToNoiseRatio": 40}]}';
        $http.post("https://www.googleapis.com/geolocation/v1/geolocate?key=AIzaSyAuVQ5-7Rvuw8JCLTLoSOCQvow11BAdEZg", JSON.parse(data))
                .then(function successCallback(response) {
                    currentLocation = response.data.location;
                    initMap();
                }, function errorCallback(response) {
                    $(location).attr('href', ERROR_PAGE);
                });
    };
    // when adding new location from search
    $scope.addNewLocation = function (selectedLocationType) {
        var searchAddr = searchBox.value;
        if (angular.isString(searchAddr) && searchAddr !== "") {
            // add to all language
            for (var i = 0, max = languageDescriptionList.length; i < max; i++) {
                // get data 
                var advancedAddress = languageDescriptionList[i].advancedAddress;
                var searchLat = newPlace.geometry.location.lat();
                var searchLng = newPlace.geometry.location.lng();
                var country = "", city = "";
                // get country and city from search result
                var addressComponents = newPlace.address_components;
                for (var j = 0, len = addressComponents.length; j < len; j++) {
                    var searchAdd = addressComponents[j];
                    if (searchAdd.types[0] === "locality") {
                        city = searchAdd["long_name"];
                    } else if (searchAdd.types[0] === "country") {
                        country = searchAdd["long_name"];
                    }
                }

                // construct new Address json
                var newAddr = {"lat": searchLat, "lng": searchLng,
                    "addr": searchAddr, "startTime": "", "endTime": "",
                    "content": "", country: country, city: city};
                advancedAddress[selectedLocationType].push(newAddr);
            }
//            searchBox.value = "";
            //            updateMarkerArray();

            // update mask input
            $timeout(function () {
                $(".timeMaskInput").inputmask("h:s", {
                    onKeyValidation: function (key, result) {
                        angular.element($(this)).triggerHandler('input');
                    }
                });
            }, 100);
        }
    };
    $scope.removeLocation = function (index, selectedLocationType) {
        if (angular.isString($scope.selectedMarker)) {
            var markerObj = $.parseJSON($scope.selectedMarker);
            if (index === markerObj["position"] && selectedLocationType === markerObj["kindOfMarker"]) {
                $scope.selectedMarker = null;
            }
        }

        // remove from all language
        for (var i = 0, max = languageDescriptionList.length; i < max; i++) {
            var advancedAddress = languageDescriptionList[i].advancedAddress;
            advancedAddress[selectedLocationType].splice(index, 1);
        }
        updateMarkerArray();
    };
    var fillInforWindow = function (place, infowindow, map, marker) {
        infowindow.setContent('<div>' + place + '</div>');
        infowindow.open(map, marker);
    };
    var markers = [], windows = [], packagePath, departurePath, pickupPath, bounds;
    function updateMarkerArray() { // update marker arrays and change map view
        // first delete old markers
        if (markers.length > 0) {
            for (var i = 0, max = markers.length; i < max; i++) {
                markers[i].setMap(null);
                windows[i].close();
            }
            markers = [];
            windows = [];
            angular.isObject(packagePath) ? packagePath.setMap(null) : 0;
            angular.isObject(departurePath) ? departurePath.setMap(null) : 0;
            angular.isObject(pickupPath) ? pickupPath.setMap(null) : 0;
        }

        // init marker array
        var actionLocations = $scope.selectedLanguageDescription.advancedAddress.action;
        var actionLength = actionLocations.length;
        if (actionLength > 0) { // if have addtional markers

            var path = [];
            for (var i = 0; i < actionLength; i++) { // loop addtional markers
                var actionLocation = actionLocations[i];
                if (angular.isObject(actionLocation)) {

                    // create new marker
                    var lat = actionLocation.lat;
                    var lng = actionLocation.lng;
                    if (lat !== "" && lng !== "") {
                        var latlng = new google.maps.LatLng(lat, lng);
                        var markerObj = new google.maps.Marker({
                            map: map,
                            position: latlng
                        });
                        markerObj.setIcon('http://youtripper.com/Images/Icon/packageLocation.svg');
                        markers.push(markerObj);
                        // create new window
                        var window = new google.maps.InfoWindow({
                            maxWidth: 200
                        });
                        windows.push(window);
                        fillInforWindow("<strong>Package location " + (i + 1) + ": </strong>" + actionLocation.addr,
                                window, map, markerObj);
                        // add new point to path
                        path.push(latlng);
                    }
                }
            }

            // draw line betweens package
            packagePath = new google.maps.Polyline({
                path: path,
                geodesic: true,
                strokeColor: '#3FC1C9',
                strokeOpacity: 1.0,
                strokeWeight: 2
            });
            packagePath.setMap(map);
        }

        var pickupLocations = $scope.selectedLanguageDescription.advancedAddress.pickup;
        var pickupLength = pickupLocations.length;
        if (pickupLength > 0) { // if have addtional markers
            var path = [];
            for (var i = 0; i < pickupLength; i++) { // loop addtional marrkers
                var pickupLocation = pickupLocations[i];
                if (angular.isObject(pickupLocation)) {

                    // crate new marker
                    var lat = pickupLocation.lat;
                    var lng = pickupLocation.lng;
                    if (lat !== "" && lng !== "") {
                        var latlng = new google.maps.LatLng(lat, lng);
                        var markerObj = new google.maps.Marker({
                            map: map,
                            position: latlng
                        });
                        markerObj.setIcon('http://youtripper.com/Images/Icon/pickupLocation.svg');
                        markers.push(markerObj);
                        // create new window
                        var window = new google.maps.InfoWindow({
                            maxWidth: 200
                        });
                        windows.push(window);
                        fillInforWindow("<strong>Pickup location " + (i + 1) + ": </strong>" + pickupLocation.addr,
                                window, map, markerObj);
                        // add new point to path
                        path.push(latlng);
                    }
                }
            }
            // draw line betweens package
            pickupPath = new google.maps.Polyline({
                path: path,
                geodesic: true,
                strokeColor: '#FBB03B',
                strokeOpacity: 1.0,
                strokeWeight: 2
            });
            pickupPath.setMap(map);
        }

        var departureLocations = $scope.selectedLanguageDescription.advancedAddress.departure;
        var departureLength = departureLocations.length;
        if (departureLength > 0) { // if have addtional markers
            var path = [];
            for (var i = 0; i < departureLength; i++) { // loop addtional marrkers
                var departureLocation = departureLocations[i];
                if (angular.isObject(departureLocation)) {

                    // crate new marker
                    var lat = departureLocation.lat;
                    var lng = departureLocation.lng;
                    if (lat !== "" && lng !== "") {
                        var latlng = new google.maps.LatLng(lat, lng);
                        var markerObj = new google.maps.Marker({
                            map: map,
                            position: latlng
                        });
                        markerObj.setIcon('http://youtripper.com/Images/Icon/departLocation.svg');
                        markers.push(markerObj);
                        // create new window
                        var window = new google.maps.InfoWindow({
                            maxWidth: 200
                        });
                        windows.push(window);
                        fillInforWindow("<strong>Departure location " + (i + 1) + ": </strong>" + departureLocation.addr,
                                window, map, markerObj);
                        // add new point to path
                        path.push(latlng);
                    }
                }
            }

            // draw line betweens package
            departurePath = new google.maps.Polyline({
                path: path,
                geodesic: true,
                strokeColor: '#FF514E',
                strokeOpacity: 1.0,
                strokeWeight: 2
            });
            departurePath.setMap(map);
        }


        // modify map view to see all markers
        bounds = new google.maps.LatLngBounds();
        for (var i = 0; i < markers.length; i++) {
            bounds.extend(markers[i].getPosition());
        }
        //        $scope.bounds.extend($scope.mainMarker.getPosition());
        if (markers.length > 0) {
            map.fitBounds(bounds);
        }

        // add window for main location
//        $scope.mainInfowindow.close();
        //        $scope.fillInforWindow("<strong>Main Package Location</strong>", $scope.mainInfowindow, $scope.map, $scope.mainMarker);
    }

    // TAGS



    // when a new language is added
    $scope.addNewLanguage = function () {
        if ($scope.selectedLanguageID !== 0) {
            var newLanguageDescription = {"packageID": $scope.package.id, "languageID": $scope.selectedLanguageID};
            languageDescriptionList.push(newLanguageDescription);
            // construct list of description
            newLanguageDescription["description"] = [];
            var advancedDescriptionLen = englishDescription.description.length;
            for (var i = 0; i < advancedDescriptionLen; i++) {
                var signleDescription = {"header": "", "description": ""};
                newLanguageDescription["description"].push(signleDescription);
            }

            // get list amenities of current version and then clone to new language
            var languageID = $scope.selectedLanguageDescription.languageID;
            for (var i = 0, max = $scope.amenitiesClassifiers.length; i < max; i++) {
                var amenities = $scope.amenitiesClassifiers[i];
                if (amenities.languageID === languageID) {
                    var amenitiesClassifier = {"packageID": $scope.package.id, "amenitiesID": amenities.amenitiesID, "amenitiesName": amenities.amenitiesName,
                        "amenitiesIcon": amenities.amenitiesName, "description": "", "languageID": $scope.selectedLanguageID};
                    $scope.amenitiesClassifiers.push(amenitiesClassifier);
                }
            }

            // get all address of current version and then clone to new language
            var newAdvancedAdresses = {"action": [], "departure": [], "pickup": []};
            newLanguageDescription["advancedAddress"] = newAdvancedAdresses;
            var advancedAddress = $scope.selectedLanguageDescription["advancedAddress"];
            // clone action address
            var actionAddresses = advancedAddress["action"];
            for (var j = 0, len = actionAddresses.length; j < len; j++) {
                //get
                var actionAddress = actionAddresses[j];
                var newAddr = {"lat": actionAddress.lat, "lng": actionAddress.lng,
                    "addr": actionAddress.addr, "startTime": actionAddress.startTime, "endTime": actionAddress.endTime,
                    "content": "", "country": actionAddress.country, "city": actionAddress.city};
                if (actionAddress["accessDescription"] !== undefined) {
                    newAddr["accessDescription"] = "";
                }
                // add
                newAdvancedAdresses["action"].push(newAddr);
            }

            // clone departure address
            var departureAddresses = advancedAddress["departure"];
            for (var j = 0, len = departureAddresses.length; j < len; j++) {
                //get
                var departureAddress = departureAddresses[j];
                var newAddr = {"lat": departureAddress.lat, "lng": departureAddress.lng,
                    "addr": departureAddress.addr, "startTime": departureAddress.startTime, "endTime": departureAddress.endTime,
                    "content": "", "country": departureAddress.country, "city": departureAddress.city};
                if (departureAddress["accessDescription"] !== undefined) {
                    newAddr["accessDescription"] = "";
                }
                // add
                newAdvancedAdresses["departure"].push(newAddr);
            }

            // clone pcickup adress
            var pickupAddresses = advancedAddress["pickup"];
            for (var j = 0, len = pickupAddresses.length; j < len; j++) {
                //get
                var pickupAddress = pickupAddresses[j];
                var newAddr = {"lat": pickupAddress.lat, "lng": pickupAddress.lng,
                    "addr": pickupAddress.addr, "startTime": pickupAddress.startTime, "endTime": pickupAddress.endTime,
                    "content": "", "country": pickupAddress.country, "city": pickupAddress.city};
                if (pickupAddress["accessDescription"] !== undefined) {
                    newAddr["accessDescription"] = "";
                }
                // add
                newAdvancedAdresses["pickup"].push(newAddr);
            }


            // change to new language description
            $scope.selectedLanguageDescription = newLanguageDescription;
            $scope.toggleLanguageBox();
        }
    };
    function validateDescriptionInput() {
        var checkDescriptionFlag = false;
        angular.forEach(languageDescriptionList, function (languageDescription) {
            if (angular.isUndefined(languageDescription.packageName) || languageDescription.packageName === '' ||
                    angular.isUndefined(languageDescription.googleDescription) || languageDescription.googleDescription === '' ||
                    languageDescription.description[0].description === '' || languageDescription.description[0].header === '' ||
                    languageDescription.advancedAddress.action.length === 0 || languageDescription.advancedAddress.action[0].content === "") {
                checkDescriptionFlag = true;
            }

        });
        if (!checkDescriptionFlag) {
            return true;
        }
        return false;
    }

    function getDescriptionData() {
        var country = "";
        var city = "";
        if (languageDescriptionList[0].advancedAddress["action"].length > 0) {
            country = languageDescriptionList[0].advancedAddress["action"][0]["country"];
            city = languageDescriptionList[0].advancedAddress["action"][0]["city"];
        }

        var languageDescriptionsData = [];
        for (var i = 0, max = languageDescriptionList.length; i < max; i++) {
            var languageDescription = languageDescriptionList[i];
            var languageDescriptionData = {"languageID": languageDescription.languageID, "packageName": languageDescription.packageName,
                "googleDescription": languageDescription.googleDescription, "language": JSON.stringify(languageDescription.language),
                "description": JSON.stringify(languageDescription.description),
                "advancedAddress": JSON.stringify(languageDescription.advancedAddress), "keywords": JSON.stringify(languageDescription.keywords)};
            languageDescriptionsData.push(languageDescriptionData);
        }

        var data = {"packageID": $scope.package.id, "descriptions": languageDescriptionsData, "amenitiesClassifier": $scope.amenitiesClassifiers,
            "certificates": $scope.package.certificates, "country": country, "city": city};
        return data;
    }

    $scope.removeLanguage = function (langID) {
        angular.forEach(languageDescriptionList, function (lang, langIndex) {
            if (lang.languageID === langID) {
                languageDescriptionList.splice(langIndex, 1);
                if (langIndex === 0) {
                    $scope.selectedLanguageDescription = languageDescriptionList[1];
                } else if (langIndex > 0 && langIndex <= languageDescriptionList.length) {
                    $scope.selectedLanguageDescription = languageDescriptionList[languageDescriptionList.length - 1];
                }

                //                $scope.selectedLanguageDescription.languageID = 40;
            }
        });
    };
    $scope.$watch('selectedLanguageDescription.keywords', function (newVal, oldVal) {
        if (angular.isDefined($scope.selectedLanguageDescription.keywords)) {
            if ($scope.selectedLanguageDescription.keywords.length > 9) {
                $scope.selectedLanguageDescription.keywords.splice(9, 1);
            }
        }
    }, true);
    $scope.$watch('selectedLanguageDescription.language', function (newVal, oldVal) {
        if (angular.isDefined($scope.selectedLanguageDescription.language)) {
            if ($scope.selectedLanguageDescription.language.length > 9) {
                $scope.selectedLanguageDescription.language.splice(9, 1);
            }
        }
    }, true);
    /* END DESCRIPTION SECTION */

    /* PHOTOS SECTION */
    function validatePhotosInput() {
        if (angular.isString($scope.package.coverImage) && $scope.package.coverImage !== "" && $scope.coverImageSuccess === true) {
            return true;
        } else {
            return false;
        }
    }

    function getPhotoForm() {
        return {"packageID": $scope.package.id, "coverImage": $scope.package.coverImage,
            "additionalImages": JSON.stringify($scope.package.images), "coverPosition": $scope.package.coverPosition};
    }

    $scope.currentTime = new Date().getTime();
    $scope.coverImageSuccess = true;
    $scope.package.images = $.parseJSON($scope.package.images);
    $scope.$watch('addingImage', function () {
        if ($scope.addingImage !== undefined && $scope.addingImage !== null) {
            if ($scope.additionalImages) {
                $scope.uploadAddiionImages($scope.addingImage);
            } else {
                alert("Your addition images are uploading!");
            }
        }
    });
    $scope.additionalImages = true;
    $scope.$watch('coverImage', function (newVal, oldVal) {
        if (newVal !== oldVal) {
            if ($scope.coverImage !== undefined && $scope.coverImage !== null) {
                $scope.uploadCoverImage($scope.coverImage);
            }
        }
    });
    var TEMP_COVER_URL = service.getContextPath() + "/Provider/TemporaryEditCoverImage";
    $scope.uploadCoverImage = function (coverImage) {
        $scope.coverImageSuccess = false;
        $scope.package.coverImage = "";
        var oMyForm = new FormData();
        oMyForm.append("coverImage", coverImage);
        oMyForm.append("packageID", $scope.package.id);
        $.ajax({
            url: uploadCoverImageUrl,
            data: oMyForm,
            dataType: 'text',
            processData: false,
            contentType: false,
            type: 'POST',
            beforeSend: function (jqXHR, settings) {
                $("#coverImage").css("background", '#fff url(' + service.getContextPath() + '/Images/Icon/loading.gif) no-repeat center');
            },
            success: function (data) {
                if (data.result !== "error") {


                    $scope.currentTime = new Date().getTime();
                    $("#coverImage img").attr("src", TEMP_COVER_URL + "?time=" + $scope.currentTime);
                    $scope.package.coverImage = TEMP_COVER_URL + "?time=" + $scope.currentTime;
                    $scope.package.coverPosition = 0;
                    $scope.coverImageSuccess = true;
                    $scope.$digest();
                } else {
                    alert("Wrong input!");
                }
            }, error: function (respone) {
                alert("Error");
            }
        });
    };
    $scope.uploading = false;
    $scope.uploadAddiionImages = function (additionalImages) {
        $scope.additionalImages = false;
        $scope.uploading = true;
        $scope.uploadValue = 0;
        var percent = 100 / additionalImages.length;
        var count = 0;
        for (var i = 0; i < additionalImages.length; i++) {

            var oMyForm = new FormData();
            oMyForm.append("additionalImages[]", additionalImages[i]);
            oMyForm.append("imagesJson", JSON.stringify($scope.package.images));
            oMyForm.append("packageID", $scope.package.id);
            $.ajax({
                url: uploadAdditionalImagesUrl,
                data: oMyForm,
                dataType: 'text',
                processData: false,
                contentType: false,
                type: 'POST',
                beforeSend: function (jqXHR, settings) {
                },
                success: function (data) {
                    console.log(data);
                    if (data.result !== "error") {
                        count = count + 1;
                        $scope.currentTime = new Date().getTime();
                        $scope.package.images.push(JSON.parse(data)[0]);
                        $scope.uploadValue = percent * count;
                    } else {
                        alert("Wrong input!");
                    }
                    $scope.additionalImages = true;
                    if (count === additionalImages.length) {
                        $scope.uploading = false;
                    }
                    $scope.$digest();
                }, error: function (respone) {
                    alert("Error");
                }
            });
        }
        ;
    };
    $scope.imagedeleting = false;
    $scope.deleteAdditionalImage = function (name, position) {
        $scope.package.images.splice(position, 1);
        var data = {"deletedImage": name.image, "images": $scope.package.images, "packageID": $scope.package.id, "deletedPosition": position};
        $http.post(deleteAdditionalImageUrl, data)
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                    }
                });
    };
    // detect window resize to fit banner
    $(window).resize(function () {
        $scope.resizeBanner();
    });
    // function to resize banner
    $scope.resizeBanner = function () {
        var width = $("#coverImage").width();
        var height = width * 540 / 1350;
        $("#coverImage").height(height);
    };
    $scope.isEditing = false;
    $scope.initiatePhotoForm = function () {
        $timeout(function () {
            // resize banner
            $scope.resizeBanner();
            // enable dragable image inside cover
            // define range to drag
            $scope.initiateDrag(true);
            // then disable, just enable drag when edit opion is selected
            $(".packageCoverImage").draggable("disable");
            // set position from database
            $("img.packageCoverImage").css("top", $scope.package.coverPosition);
        }, 300);
    };
    $scope.initiateDrag = function (initiate) {
        // get containment for draggable
        var left = $("#coverImage").offset().left;
        var top = $("#coverImage").offset().top;
        var parentHeight = $("#coverImage").outerHeight();
        var coverHeight = $(".packageCoverImage").height();
        var containmentY1 = parentHeight - coverHeight + top;
        if (initiate) { // if initate not change opption
            // create grabble for the first time
            $(".packageCoverImage").draggable({
                containment: [left, containmentY1, left, top],
                cursor: "all-scroll",
                refreshPositions: true,
                scroll: false,
                snap: false});
        } else {
            $(".packageCoverImage").draggable("option", {
                containment: [left, containmentY1, left, top]
            });
        }
    };
    // enable Dragable
    $scope.turnOnDrag = function () {
        // change option
        $scope.initiateDrag(false);
        // enable dragable
        $(".packageCoverImage").draggable("enable");
        $scope.isEditing = true;
    };
    // disable Draggable
    $scope.disableDrag = function () {
        $scope.isEditing = false;
        // then disable, just enable drag when edit opion is selected
        $(".packageCoverImage").draggable("disable");
        // get position of vertical
        //        alert($(".packageCoverImage").offset().top - $("#coverImage").offset().top);
        $scope.package.coverPosition = $(".packageCoverImage").offset().top - $("#coverImage").offset().top;
    };
    $scope.$watch("package.coverPosition", function (newVal, oldVal) {
        if (newVal !== oldVal) {
            $("img.packageCoverImage").css("top", newVal);
        }
    });
    $scope.checkImageUploaded = function () {
        if ($scope.package.coverImage !== null && $scope.package.coverImage !== undefined && $scope.package.coverImage !== '' && $scope.coverImageSuccess) {
            return true;
        }
        return false;
    };
    $scope.showEditImageText = function () {
        var result;
        if ($scope.package.coverImage !== null && $scope.package.coverImage !== undefined && $scope.package.coverImage !== '') {
            result = 'Move';
        } else {
            result = 'Edit';
        }
        return result;
    };
    /* END PHOTOS SECTION */

    /* BOOKING SECTION */
    if ($scope.package.maxQuota <= 0) {
        $scope.package.maxQuota = null;
    }

    // convert to json
    $scope.package.unavailableDays = JSON.parse($scope.package.unavailableDays);
    // for show place holder
    $scope.package.minTripper === 0 ? $scope.package.minTripper = null : 0;
    $scope.package.maxTripper === 0 ? $scope.package.maxTripper = null : 0;
    $scope.package.minimumResources === 0 ? $scope.package.minimumResources = null : 0;
    $scope.package.duration === 0 ? $scope.package.duration = null : 0;
    $scope.package.resourceID === 0 ? $scope.package.resourceID = null : 0;
    $scope.package.servingPeriodID === 0 ? $scope.package.servingPeriodID = null : 0;
    $scope.fixedType = 'hours';
    $scope.package.fixedType = 'hours';
    if ($scope.package.fixedMinute > 0) {
        $scope.fixedType = 'minutes';
    } else {
        $scope.package.fixedMinute = null;
    }

    if ($scope.package.fixedHour <= 0) {
        $scope.package.fixedHour = null;
    }

    // convert providerresoucres to hash map
    $scope.providerResourceHashmap = {};
    $scope.providerServingPeriods = {};
    function changeServingPeriodsToHashmap() {
        $scope.providerServingPeriods = {};
        for (var i = 0, max = $scope.packageForm.servingPeriods.length; i < max; i++) {
            var period = $scope.packageForm.servingPeriods[i];
            $scope.providerServingPeriods[period.id] = period;
        }
    }
    changeServingPeriodsToHashmap();
    $scope.setIsFreeBooking = function (isFree) {
        if ($scope.package.isFreeBooking !== isFree) {
            $scope.package.isFreeBooking = isFree;
            $scope.package.fixedMinute = 0;
            $scope.package.fixedHour = 0;
        }
    };
    $scope.changePackageType = function (packageType) {
        if (packageType !== $scope.package.packageType) {
            $scope.package.packageType = packageType;
            if (packageType === "Personal") {
                $scope.package.minTripper = 1;
            } else if (packageType === "Group") {
                $scope.package.minTripper = 5;
            } else {
                $scope.package.minTripper = null;
            }
            $scope.package.maxTripper = null;
        }
    };

    $scope.setUsingMaxQuota = function (isUsing) {
        $scope.package.isUsingMaxQuota = isUsing;
    };

    $scope.setIsSpecificLaunchDate = function (isUsing) {
        $scope.package.isSpecificLaunchDate = isUsing;
        $scope.package.sequentialOperation = 0;
        $scope.package.startDate = new Date(timeNowVar);
        var data = updateCalendar($scope.calendarTime);
        $("#calendar .left-calendar .calendarDate").html(data["left"]);
        $("#calendar .right-calendar .calendarDate").html(data["right"]);
        $("#calendar .left-calendar .calendarYearMonth h2").html(data["leftTitle"]);
        $("#calendar .right-calendar .calendarYearMonth h2").html(data["rightTitle"]);
    };

    var checkInsideNondays = function (day) {
        for (var k = 0, max = $scope.package.unavailableDays.length; k < max; k++) {
            if (day === $scope.package.unavailableDays[k]) {
                return true;
            }
        }
        return false;
    };
    $(document).on('click', "#calendar.active .calendarDate ul li.enable-selection span", function () {
        var slDate = $(this).attr("datevalue");
        $scope.package.startDate = slDate;
        var data = updateCalendar($scope.calendarTime);
        $("#calendar .left-calendar .calendarDate").html(data["left"]);
        $("#calendar .right-calendar .calendarDate").html(data["right"]);
        $("#calendar .left-calendar .calendarYearMonth h2").html(data["leftTitle"]);
        $("#calendar .right-calendar .calendarYearMonth h2").html(data["rightTitle"]);
        $scope.$digest();
    });

    var checkInsideSequential = function (secondDate, toDate) {
        $scope.package.sequentialOperation = parseInt($scope.package.sequentialOperation);
        if ($scope.package.sequentialOperation !== 0) {
            //$scope.package.startDate
            var oneDay = 24 * 60 * 60 * 1000;
            //            var secondDate = new Date(day);
            var diffDays = Math.round(Math.abs((toDate.getTime() - secondDate.getTime()) / (oneDay)));
            if (diffDays % $scope.package.sequentialOperation === 0) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    };
    var checkInsideOperationCycles = function (date, packageStartDate) {
//        for (var i = 0, max = $scope.package.operationsCycles.length; i < max; i++) {
//            var operationCycle = $scope.package.operationsCycles[i];
//            var startDate = new Date(operationCycle.startDate);
//            var endDate = new Date(operationCycle.endDate);
//            if (date >= startDate && (!(angular.isString(operationCycle.endDate) && operationCycle.endDate !== "") || date <= endDate)) {
//                return true;
        //            }

        if (date >= packageStartDate) {
            return true;
        }
        //        }
        return false;
    };
    var TR_start = '<TR>';
    var TR_end = '</TR>';
    var TD_start = '<TD WIDTH="30">';
    var TD_Day_start = '<TD class="dayCol" WIDTH="30">';
    var TR_DAY_WEEK_START = '<TR CLASS="WeekDay">';
    var TD_end = '</TD>';
    var prvCtr = "<span class='cldCtr prvCtr' ng-click='prevMonth()'></span>";
    var nxtCtr = "<span class='cldCtr nxtCtr' ng-click='nextMonth()'></span>";
    var DAYS_OF_WEEK = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];
    $scope.MONTHS_OF_YEAR = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
    var NO_DAYS_OF_WEEK = 7; // "constant" for number of days in a week
    var NO_WEEKS_OF_MONTH = 6;
    var NO_DAYS_OF_MONTH = 31; // "constant" for number of days in a month
    Date.prototype.ddMMyyyy = function () {
        var yyyy = this.getFullYear().toString();
        var mm = (this.getMonth() + 1).toString(); // getMonth() is zero-based
        var dd = this.getDate().toString();
        return (dd[1] ? dd : "0" + dd[0]) + "/" + (mm[1] ? mm : "0" + mm[0]) + "/" + yyyy; // padding
    };
    Date.prototype.MMddyyyy = function () {
        var yyyy = this.getFullYear().toString();
        var mm = (this.getMonth() + 1).toString(); // getMonth() is zero-based
        var dd = this.getDate().toString();
        return  (mm[1] ? mm : "0" + mm[0]) + "/" + (dd[1] ? dd : "0" + dd[0]) + "/" + yyyy; // padding
    };
    function updateCalendar(calendarTime) {
        var data = {};

        // return to first sunday of month
        var currentMonth = calendarTime.getMonth();
        var currentDate = new Date(calendarTime);

        data["leftTitle"] = $scope.MONTHS_OF_YEAR[currentMonth] + " " + currentDate.getFullYear();

        currentDate.setDate(1);
        var distance = currentDate.getDay();
        if (distance === 0) {
            distance = 7;
        }
        currentDate.setDate(currentDate.getDate() - distance);
        var toDate;
        if ($scope.package.startDate !== undefined) {
            toDate = new Date($scope.package.startDate);
        } else {
            toDate = new Date(timeNowVar);
        }

        var now = new Date(timeNowVar);
        // construct string html of month view
        var html = "";
        // loop 6 weeks
        var isAvailable;
        for (var i = 0; i < NO_WEEKS_OF_MONTH; i++) {
            html += "<ul class='clearfix'>";
            for (var j = 0; j < NO_DAYS_OF_WEEK; j++) { // loop 7 days
                isAvailable = false;
                if ($scope.package.isRunning && !checkInsideNondays(currentDate.getDay()) && !checkInsideSequential(currentDate, toDate) &&
                        checkInsideOperationCycles(currentDate, toDate)) {
                    isAvailable = true;
                }

                var timeDiff = currentDate.getTime() - now.getTime();
                var diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24));

                html += "<li class='" + (isAvailable ? "availableDate" : "") +
                        (currentMonth === currentDate.getMonth() ? " inMonth" : " outMonth") +
                        ((diffDays >= 0 && diffDays < 31) ? " enable-selection" : "") +
                        (currentDate.MMddyyyy() === timeNowVar ? " toDate" : "") + "'>"
                        + "<span dateValue='" + currentDate.MMddyyyy() + "'>"
                        + currentDate.getDate() + "</span></li>";
                currentDate.setDate(currentDate.getDate() + 1);
            }
            // plus week to month
            html += "</ul>";
        }

        data["left"] = html;

        var rightHtml = "";
        currentDate = new Date(calendarTime);
        currentDate.setMonth(currentDate.getMonth() + 1);
        currentMonth = currentDate.getMonth();

        data["rightTitle"] = $scope.MONTHS_OF_YEAR[currentMonth] + " " + currentDate.getFullYear();
        currentDate.setDate(1);
        distance = currentDate.getDay();
        if (distance === 0) {
            distance = 7;
        }
        currentDate.setDate(currentDate.getDate() - distance);

        for (var i = 0; i < NO_WEEKS_OF_MONTH; i++) {
            rightHtml += "<ul class='clearfix'>";
            for (var j = 0; j < NO_DAYS_OF_WEEK; j++) { // loop 7 days
                isAvailable = false;
                if ($scope.package.isRunning && !checkInsideNondays(currentDate.getDay()) && !checkInsideSequential(currentDate, toDate) &&
                        checkInsideOperationCycles(currentDate, toDate)) {
                    isAvailable = true;
                }

                var timeDiff = currentDate.getTime() - now.getTime();
                var diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24));

                rightHtml += "<li class='" + (isAvailable ? "availableDate" : "") +
                        (currentMonth === currentDate.getMonth() ? " inMonth" : " outMonth") +
                        ((diffDays >= 0 && diffDays < 31) ? " enable-selection" : "") +
                        (currentDate.MMddyyyy() === timeNowVar ? " toDate" : "") + "'>"
                        + "<span dateValue='" + currentDate.MMddyyyy() + "'>"
                        + currentDate.getDate() + "</span></li>";
                currentDate.setDate(currentDate.getDate() + 1);
            }
            rightHtml += "</ul>";
        }

        data["right"] = rightHtml;
        return data;
    }

    $scope.calendarTime = new Date(timeNowVar);
    $scope.calendarTime.setHours(0, 0, 0, 0, 0);
    $scope.popupTripSourceShowing = false;
    $scope.nextMonth = function () {
        $scope.calendarTime.setMonth($scope.calendarTime.getMonth() + 2);
        var data = updateCalendar($scope.calendarTime);
        $("#calendar .left-calendar .calendarDate").html(data["left"]);
        $("#calendar .right-calendar .calendarDate").html(data["right"]);
        $("#calendar .left-calendar .calendarYearMonth h2").html(data["leftTitle"]);
        $("#calendar .right-calendar .calendarYearMonth h2").html(data["rightTitle"]);
    };
    $scope.previousMonth = function () {
        $scope.calendarTime.setMonth($scope.calendarTime.getMonth() - 2);
        var data = updateCalendar($scope.calendarTime);
        $("#calendar .left-calendar .calendarDate").html(data["left"]);
        $("#calendar .right-calendar .calendarDate").html(data["right"]);
        $("#calendar .left-calendar .calendarYearMonth h2").html(data["leftTitle"]);
        $("#calendar .right-calendar .calendarYearMonth h2").html(data["rightTitle"]);
    };
    $scope.$watch("package.sequentialOperation", function (newVal, oldVal) {
        if (newVal !== oldVal) {
            var data = updateCalendar($scope.calendarTime);
            $("#calendar .left-calendar .calendarDate").html(data["left"]);
            $("#calendar .right-calendar .calendarDate").html(data["right"]);
            $("#calendar .left-calendar .calendarYearMonth h2").html(data["leftTitle"]);
            $("#calendar .right-calendar .calendarYearMonth h2").html(data["rightTitle"]);
        }
    });
    $scope.changeStatusOfPackage = function (status) {
        $scope.package.isRunning = status;
        // update calendar
        var data = updateCalendar($scope.calendarTime);
        $("#calendar .left-calendar .calendarDate").html(data["left"]);
        $("#calendar .right-calendar .calendarDate").html(data["right"]);
        $("#calendar .left-calendar .calendarYearMonth h2").html(data["leftTitle"]);
        $("#calendar .right-calendar .calendarYearMonth h2").html(data["rightTitle"]);
    };
    $scope.showResourcePopup = function () {
//        $('#newTripSourceBtn').ScrollTo({
//            duration: 100,
//            callback: function () {
//                $scope.popupTripSourceShowing = true;
//                $scope.$digest();
//            }
        //        });
        //       Scroll screen to target element
//        $scope.popupTripSourceShowing = true;
//        var position = $("#newTripSourceBtn").offset().top;
        //        alert(position);
        $scope.popupTripSourceShowing = true;
        $timeout(function () {
            var newTripSourceBtnPosition = $("#resourcePopup").offset().top + ($("#resourcePopup").outerHeight(true) / 2);
            var scrollHeight = $('#package-section-content .content').outerHeight(true) / 2;
            var position = $('#package-section-content .content').scrollTop() + newTripSourceBtnPosition - $('#package-section-content .content').offset().top - scrollHeight;
            $('#package-section-content .content').animate({
                scrollTop: position
            }, 100);
        }, 100);
    };
    $scope.closeResourcePopup = function () {
        $scope.popupTripSourceShowing = false;
    };
    $scope.popupServingShowing = false;
    $scope.openServingPopup = function () {
        $scope.popupServingShowing = true;
        $scope.showMissingServingPeriod = false;
        editSelectedResourceMode = false;
        $scope.newServing = {"name": '', "startTime": '', "endtime": ''};
        $timeout(function () {
            var newTripSourceBtnPosition = $("#servingPopup").offset().top + ($("#servingPopup").outerHeight(true) / 2);
            var scrollHeight = $('#package-section-content .content').outerHeight(true) / 2;
            var position = $('#package-section-content .content').scrollTop() + newTripSourceBtnPosition - $('#package-section-content .content').offset().top - scrollHeight;
            position += 100;
            $('#package-section-content .content').animate({
                scrollTop: position
            }, 100);
        }, 100);
    };
    $scope.closeServingPopup = function () {
        $scope.popupServingShowing = false;
        $scope.popupServingShowingEdit = false;
    };
    function initBookingCalendar() {
        var startDateStr = $scope.package.startDate;
        if (startDateStr === undefined) {
            startDateStr = (new Date()).MMddyyyy();
        }
    }

    $scope.addMoreCycle = function () {
        var newCycle = {"cycleID": 0, "packageID": 0, "startDate": "", "endDate": ""};
        $scope.package.operationsCycles.push(newCycle);
        $timeout(function () {

        }, 100);
    };
    $scope.removeCycle = function () {
        $scope.package.operationsCycles.splice($scope.package.operationsCycles.length - 1, 1);
    };
    $scope.initCalendar = function () {
        $scope.calendarTime = new Date(timeNowVar);
        $scope.calendarTime.setHours(0, 0, 0, 0, 0);
        var data = updateCalendar($scope.calendarTime);
        $("#calendar .left-calendar .calendarDate").html(data["left"]);
        $("#calendar .right-calendar .calendarDate").html(data["right"]);
        $("#calendar .left-calendar .calendarYearMonth h2").html(data["leftTitle"]);
        $("#calendar .right-calendar .calendarYearMonth h2").html(data["rightTitle"]);
        initBookingCalendar();
        $(".timeMaskInput").inputmask("h:s", {
            onKeyValidation: function (key, result) {
                angular.element($(this)).triggerHandler('input');
            }
        });
    };
    var inputElement;
    $scope.inputDate;
    $scope.showAvailableCalendar = function ($event) {
        // move to that input
        inputElement = $(angular.element($event.currentTarget));
        var inputPosition = inputElement.offset().top;
        var containerTop = $('#package-section-content .content').offset().top;
        var position = $('#package-section-content .content').scrollTop() + (inputPosition - containerTop);
        $('#package-section-content .content').animate({
            scrollTop: position
        }, 100);
        // place calendar bottom of input
        var inputHeight = inputElement.outerHeight(true);
        $("#availableCalendar").css("top", (position + inputHeight));
        var inputLeft = inputElement.offset().left;
        $("#availableCalendar").css("left", inputLeft);
        var inputValue = inputElement.val();
        if (inputValue !== "") {
            $scope.inputDate = new Date(inputValue);
        } else {
            $scope.inputDate = new Date();
        }
        $("#availableCalendar .calendarDate").html(updateCalendar($scope.inputDate));
        // show calendar
        $timeout(function () {
            $("#availableCalendar").addClass("active");
        }, 100);
    };
    // select start date or end date
    $(document).on('click', '#availableCalendar .smallCalendar .calendarDate ul li span', function () {
        var index = inputElement.attr("position");
        var inputModel = inputElement.attr("inputModel");
        var newValue = $(this).attr("dateValue");
        $scope.package.operationsCycles[index][inputModel] = newValue;
        //
        if (!!$scope.package.operationsCycles[0]) {
            $scope.package.startDate = $scope.package.operationsCycles[0]["startDate"];
        }


        $("#calendar .calendarDate").html(updateCalendar($scope.calendarTime));
        $timeout(function () {
            $("#availableCalendar").removeClass("active");
        }, 100);
        $scope.$digest();
    });
    // move and next of small calendar
    $scope.backAvailableMonth = function () {
        $scope.inputDate.setMonth($scope.inputDate.getMonth() - 1);
        $("#availableCalendar .calendarDate").html(updateCalendar($scope.inputDate));
    };
    $scope.nextAvailableMonth = function () {
        $scope.inputDate.setMonth($scope.inputDate.getMonth() + 1);
        $("#availableCalendar .calendarDate").html(updateCalendar($scope.inputDate));
    };
    $scope.$watch("package.sequentialOperation", function (newVal, oldVal) {
        if (newVal !== oldVal) {
            var data = updateCalendar($scope.calendarTime);
            $("#calendar .left-calendar .calendarDate").html(data["left"]);
            $("#calendar .right-calendar .calendarDate").html(data["right"]);
            $("#calendar .left-calendar .calendarYearMonth h2").html(data["leftTitle"]);
            $("#calendar .right-calendar .calendarYearMonth h2").html(data["rightTitle"]);
        }
    });
    $scope.$watch("package.unavailableDays.length", function (newVal, oldVal) {
        if (newVal !== oldVal) {
            var data = updateCalendar($scope.calendarTime);
            $("#calendar .left-calendar .calendarDate").html(data["left"]);
            $("#calendar .right-calendar .calendarDate").html(data["right"]);
            $("#calendar .left-calendar .calendarYearMonth h2").html(data["leftTitle"]);
            $("#calendar .right-calendar .calendarYearMonth h2").html(data["rightTitle"]);
        }
    });
    // insert New Trip Source
    var RESOURCE_INSERTING_URL = service.getContextPath() + "/Provider/Resource/Insert";
    $scope.newResource = {"name": ""};
    $scope.insertNewTripSource = function () {

        $scope.addingProcessing = true;
        var data = {"resourceID": 0, "providerID": 0, "name": $scope.newResource["name"], "noPeople": $scope.newResource["capacity"],
            "note": $scope.newResource["note"]};
        if (angular.isNumber(data.noPeople) && angular.isString(data.name)
                ) {
            $http.post(RESOURCE_INSERTING_URL, data)
                    .then(function successCallback(response) {
                        if (response.data.result === "error") {
                            $(location).attr('href', ERROR_PAGE);
                        } else {
                            // get id and insert to old list
                            var newResourceID = response.data["resourceID"];
                            data.resourceID = newResourceID;
                            $scope.providerResourceHashmap[newResourceID] = data;
                            $timeout(function () {
                                $scope.package.resourceID = newResourceID;
                                $scope.closeResourcePopup();
                            }, 100);
                            $scope.addingProcessing = false;
                        }
                    });
        } else {
            event.preventDefault();
            $scope.addingProcessing = false;
        }

    };
    $scope.popupServingShowingEdit = false;
    var editSelectedResourceMode = false;
    $scope.editSelectedResource = function () {
        editSelectedResourceMode = true;
        $scope.editResource = {"startTime": $scope.providerServingPeriods[$scope.package.servingPeriodID].startOperationTime,
            "endTime": $scope.providerServingPeriods[$scope.package.servingPeriodID].endOperationTime,
            "name": $scope.providerServingPeriods[$scope.package.servingPeriodID].name};
        if ($scope.package.servingPeriodID > 0) {
            $scope.popupServingShowingEdit = true;
            $timeout(function () {
                var newTripSourceBtnPosition = $("#servingPopup").offset().top + ($("#servingPopup").outerHeight(true) / 2);
                var scrollHeight = $('#package-section-content .content').outerHeight(true) / 2;
                var position = $('#package-section-content .content').scrollTop() + newTripSourceBtnPosition - $('#package-section-content .content').offset().top - scrollHeight;
                position += 100;
                $('#package-section-content .content').animate({
                    scrollTop: position
                }, 100);
            }, 100);
        }
    };
    // insert New Trip Source
    var SERVING_INSERTING_URL = service.getContextPath() + "/Provider/Serving/Insert";
    var SERVING_EDITING_URL = service.getContextPath() + "/Provider/Serving/Update";
    $scope.newServing = {"name": ""};
    $scope.updateServing = function () {
        var validate = true;
        $scope.wrongTimeServingPeriod = false;
        if ($scope.editResource.name === '' || !angular.isString($scope.editResource.name)) {
            $scope.showMissingServingPeriod = true;
            validate = false;
        } else {
            $scope.showMissingServingPeriod = false;
        }
        if ($scope.editResource.startTime === undefined || $scope.editResource.endTime === undefined) {
            $scope.wrongTimeServingPeriod = true;
            validate = false;
        }
        var startTime = new Date("October 13, 2014 " + $scope.editResource.startTime + ":00");
        var endTime = new Date("October 13, 2014 " + $scope.editResource.endTime + ":00");
        if (startTime >= endTime) {
            $scope.wrongTimeServingPeriod = true;
            validate = false;
        }
        if (!validate) {
            return;
        }

        $scope.addingProcessing = true;
        var data = {"servingID": $scope.package.servingPeriodID, "startOperationTime": $scope.editResource.startTime,
            "endOperationTime": $scope.editResource.endTime, "name": $scope.editResource.name};
        $http.post(SERVING_EDITING_URL, data)
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        $(location).attr('href', ERROR_PAGE);
                    } else {
                        $timeout(function () {
                            $scope.closeServingPopup();
                        }, 100);
                        $scope.providerServingPeriods[$scope.package.servingPeriodID].startOperationTime = $scope.editResource.startTime;
                        $scope.providerServingPeriods[$scope.package.servingPeriodID].endOperationTime = $scope.editResource.endTime;
                        $scope.providerServingPeriods[$scope.package.servingPeriodID].name = $scope.editResource.name;
                        $scope.addingProcessing = false;
                    }
                });
    };
    $scope.insertNewServing = function () {
        var validate = true;
        if ($scope.newServing["name"] === '' || !angular.isString($scope.newServing["name"])) {
            $scope.showMissingServingPeriod = true;
            validate = false;
        } else {
            $scope.showMissingServingPeriod = false;
        }
        if ($scope.newServing["startTime"] === undefined || $scope.newServing["endTime"] === undefined) {
            $scope.wrongTimeServingPeriod = true;
            validate = false;
        }
        var startTime = new Date("October 13, 2014 " + $scope.newServing["startTime"] + ":00");
        var endTime = new Date("October 13, 2014 " + $scope.newServing["endTime"] + ":00");
        if (startTime >= endTime) {
            $scope.wrongTimeServingPeriod = true;
            validate = false;
        }
        if (!validate) {
            return;
        }
        $scope.wrongTimeServingPeriod = false;
        $scope.addingProcessing = true;
        var data = {"id": 0, "providerID": 0, "startOperationTime": $scope.newServing["startTime"],
            "endOperationTime": $scope.newServing["endTime"], "name": $scope.newServing["name"]};
        $http.post(SERVING_INSERTING_URL, data)
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        $(location).attr('href', ERROR_PAGE);
                    } else {
                        // get id and insert to old list
                        var servingID = response.data["servingID"];
                        data.id = servingID;
                        $scope.providerServingPeriods[servingID] = data;
                        $timeout(function () {
                            $scope.package.servingPeriodID = servingID;
                            $scope.closeServingPopup();
                        }, 100);
                        $scope.addingProcessing = false;
                    }
                });
    };
    function getBookingInput() {
        if ($scope.package.durationDay > 0) {
            $scope.package.isFreeBooking = true;
            $scope.package.servingPeriodID = null;
        }

        var totalMinute = $scope.package.durationHour * 60 + $scope.package.durationMinute;
        totalMinute = totalMinute + $scope.package.restingtimeHour * 60 + $scope.package.restingtimeMinute;
        $scope.package.fixedHour = Math.floor(totalMinute / 60);
        $scope.package.fixedMinute = totalMinute - $scope.package.fixedHour * 60;
        var data = {"packageID": $scope.package.id, "packageType": $scope.package.packageType, "minTripper": $scope.package.minTripper,
            "maxTripper": $scope.package.maxTripper, "resourceID": $scope.package.resourceID, "minimumResources": $scope.package.minimumResources,
            "servingID": $scope.package.servingPeriodID,
            "isFreeBooking": $scope.package.isFreeBooking, "freeInterval": $scope.package.freeInterval, "fixedHour": $scope.package.fixedHour,
            "fixedMinute": $scope.package.fixedMinute, "unavailableDays": JSON.stringify($scope.package.unavailableDays), "isRunning": $scope.package.isRunning,
            "sequentialOperation": $scope.package.sequentialOperation, "operationCycles": $scope.package.operationsCycles, "readyBookingDuration":
                    $scope.package.readyBookingDuration, "readyBookingDurationType": $scope.package.readyBookingDurationType, "durationDay": $scope.package.durationDay,
            "durationMonth": $scope.package.durationMonth, "durationYear": $scope.package.durationYear,
            "durationHour": $scope.package.durationHour, "durationMinute": $scope.package.durationMinute,
            "restingtimeDay": $scope.package.restingtimeDay, "restingtimeHour": $scope.package.restingtimeHour,
            "restingtimeMinute": $scope.package.restingtimeMinute, "startDate": $scope.package.startDate,
            "isUsingMaxQuota": $scope.package.isUsingMaxQuota, "maxQuota": $scope.package.maxQuota, "quotaType": $scope.package.quotaType};
        return data;
    }

    function validateBookingInput() {
        if (($scope.package.maxTripper > 0 || ($scope.package.packageType === 'Open' && $scope.package.minTripper > 0)) && ($scope.package.durationDay > 0 ||
                $scope.package.durationMonth > 0 || $scope.package.durationYear > 0 || $scope.package.durationHour > 0 || $scope.package.durationMinute > 0) &&
                (($scope.package.durationDay === 0 && $scope.package.servingPeriodID > 0) || $scope.package.durationDay > 0 || $scope.package.durationMonth > 0 || $scope.package.durationYear > 0)
                && ($scope.package.isFreeBooking || (!$scope.package.isFreeBooking && ($scope.package.fixedHour !== null || $scope.package.fixedMinute !== null)))
                && (!$scope.package.isUsingMaxQuota || ($scope.package.isUsingMaxQuota && $scope.package.maxQuota > 0))
                ) {
            return true;
        }
        return false;
    }

    $scope.showHourBookingDuration = false;
    $scope.chooseHourBookingDuration = function () {
        if ($scope.package.readyBookingDurationType === 'hours') {
            $scope.showHourBookingDuration = true;
            $scope.showHourDuration = false;
        }
    };
    $scope.showHourDuration = false;
    $scope.showMinutesDuration = false;
    $scope.chooseHourDuration = function () {
        if ($scope.package.durationType === 'hours') {
            $scope.showHourDuration = true;
            $scope.showHourBookingDuration = false;
        } else if ($scope.package.durationType === 'minutes') {
            $scope.showMinutesDuration = true;
            $scope.showHourBookingDuration = false;
        }
    };
    $scope.showHourFixed = false;
    $scope.showMinutesFixed = false;
    $scope.chooseFixedTime = function () {
        if ($scope.package.fixedType === 'hours') {
            $scope.showHourFixed = true;
        } else {
            $scope.showMinutesFixed = true;
        }
    };
    $scope.changeTypeInputTime = function (type) {
        if (type === 'BookingDurationType') {
            if ($scope.package.readyBookingDurationType !== 'hours') {
                $scope.package.readyBookingDuration = 1;
                $scope.showHourBookingDuration = false;
                $('.bookingDurationInput').attr('readonly', false);
            } else {
                $scope.package.readyBookingDuration = 1;
                $('.bookingDurationInput').attr('readonly', true);
            }
        }
        if (type === 'DurationType') {
            if ($scope.package.durationType === 'hours') {
                $scope.package.duration = 1;
                $scope.showMinutesDuration = false;
                $('#durationInput').attr('readonly', true);
            } else if ($scope.package.durationType === 'minutes') {
                $scope.showHourDuration = false;
                $scope.package.duration = 05;
                $('#durationInput').attr('readonly', true);
            } else {
                $scope.package.duration = 1;
                $scope.showHourDuration = false;
                $scope.showMinutesDuration = false;
                $('#durationInput').attr('readonly', false);
            }
        }

        if (type === 'fixedType') {
            if ($scope.package.fixedType === 'hours') {
                $scope.showHourFixed = false;
                $scope.showMinutesFixed = false;
            }
        }
    };
    $scope.setHour = function (hour, type) {
        if (type === 'BookingDurationType') {
            $scope.package.readyBookingDuration = hour;
            $scope.showHourBookingDuration = false;
        }
        ;
        if (type === 'DurationType') {
            $scope.package.duration = hour;
            $scope.showHourDuration = false;
        }
        ;
        if (type === 'fixedType') {
            $scope.package.fixedHour = hour;
            $scope.showHourFixed = false;
        }
        ;
    };
    $scope.setMinutes = function (minute, type) {
        if (type === 'DurationType') {
            $scope.package.duration = minute;
            $scope.showMinutesDuration = false;
        }
        if (type === 'fixedType') {
            $scope.package.fixedMinute = minute;
            $scope.showMinutesFixed = false;
        }
        ;
    };
    if ($scope.package.fixedType === 'hours') {
        $scope.showPickHoursFixedHour = true;
        $scope.showPickMinutesFixedMinute = false;
    } else {
        $scope.showPickHoursFixedHour = false;
        $scope.showPickMinutesFixedMinute = true;
    }

    $scope.changeTypeInputTime = function () {
        if ($scope.package.fixedType === 'hours') {
            $scope.showPickHoursFixedHour = true;
            $scope.showPickMinutesFixedMinute = false;
        } else {
            $scope.showPickHoursFixedHour = false;
            $scope.showPickMinutesFixedMinute = true;
        }
    };
    $scope.toogleResourceInstruction = function () {
        $(".instruction-alt.hasAltLink").toggleClass("active");
        $("#resourceInstruction").toggleClass("active");
    };
    $(document).click(function (event) {
        if (!$(event.target).closest('.clockpicker-popover').length && !$(event.target).is('.clockpicker-popover') && !$(event.target).is('.clock-input')) {
            $scope.showHourFixed = false;
            $scope.showHourDuration = false;
            $scope.showHourBookingDuration = false;
            $scope.$digest();
        }
    });
    $scope.clockInputTypeOpen = true;
    $scope.openTimeClock = function (type) {
        if (type !== 'openTime') {
            $scope.clockInputTypeOpen = false;
            $(".popover").css("right", "0px");
        } else {
            $scope.clockInputTypeOpen = true;
            $(".popover").css("right", "150px");
        }
        $(".popover").addClass("active");
    };
    $scope.setHourSlot = function (hour) {
        $scope.hourSlot = hour;
        $(".clockpicker-hours").removeClass("active");
        $(".clockpicker-minutes").addClass("active");
    };
    $scope.setMinuteSlot = function (minute) {
        $scope.minuteSlot = minute;
        if ($scope.clockInputTypeOpen) {
            if (editSelectedResourceMode) {
                $scope.editResource.startTime = $scope.hourSlot + $scope.minuteSlot;
            } else {
                $scope.newServing.startTime = $scope.hourSlot + $scope.minuteSlot;
            }

            $scope.hourSlot = '';
            $scope.minuteSlot = '';
            $(".clockpicker-hours").addClass("active");
            $(".clockpicker-minutes").removeClass("active");
            $(".popover").removeClass("active");
        } else {
            if (editSelectedResourceMode) {
                $scope.editResource.endTime = $scope.hourSlot + $scope.minuteSlot;
            } else {
                $scope.newServing.endTime = $scope.hourSlot + $scope.minuteSlot;
            }
            $scope.hourSlot = '';
            $scope.minuteSlot = '';
            $(".clockpicker-hours").addClass("active");
            $(".clockpicker-minutes").removeClass("active");
            $(".popover").removeClass("active");
        }
    };
    if ($scope.package.durationType === 'days') {
        $scope.package.isFreeBooking = true;
    }
    $scope.$watch('package.durationType', function (newVal, oldVal) {
        if (newVal === 'days') {
            $scope.package.isFreeBooking = true;
        }
    });
    $scope.tempDurationType = "hours&minutes";
    if ($scope.package.durationHour > 0 || $scope.package.durationMinute > 0) {
        $scope.tempDurationType = "hours&minutes";
    } else if ($scope.package.durationDay > 0) {
        $scope.tempDurationType = "days";
    } else if ($scope.package.durationMonth > 0) {
        $scope.tempDurationType = "month";
    } else if ($scope.package.durationYear > 0) {
        $scope.tempDurationType = "years";
    }

    $scope.changeTempDurationType = function (type) {
        $scope.tempDurationType = type;
        if ($scope.tempDurationType === "days") {
            $scope.package.durationHour = 0;
            $scope.package.durationMinute = 0;
            $scope.package.restingtimeDay = 0;
            $scope.package.isFreeBooking = true;
            $scope.package.durationMonth = 0;
            $scope.package.durationYear = 0;
            $scope.package.readyBookingDurationType = "days";
            $scope.package.readyBookingDuration = 0;
            $scope.package.readyBookingDurationHour = 0;
            $scope.package.readyBookingDurationMinutes = 0;
        } else if ($scope.tempDurationType === "month") {
            $scope.package.durationHour = 0;
            $scope.package.durationMinute = 0;
            $scope.package.restingtimeDay = 0;
            $scope.package.durationDay = 0;
            $scope.package.durationYear = 0;
            $scope.package.isFreeBooking = true;
            $scope.package.readyBookingDurationType = "days";
            $scope.package.readyBookingDuration = 0;
            $scope.package.readyBookingDurationHour = 0;
            $scope.package.readyBookingDurationMinutes = 0;
        } else if ($scope.tempDurationType === "years") {
            $scope.package.durationHour = 0;
            $scope.package.durationMinute = 0;
            $scope.package.restingtimeDay = 0;
            $scope.package.durationDay = 0;
            $scope.package.durationYear = 0;
            $scope.package.durationDay = 0;
            $scope.package.durationMonth = 0;
            $scope.package.isFreeBooking = true;
            $scope.package.readyBookingDurationType = "days";
            $scope.package.readyBookingDuration = 0;
            $scope.package.readyBookingDurationHour = 0;
            $scope.package.readyBookingDurationMinutes = 0;
        } else {
            $scope.package.durationDay = 0;
            $scope.package.durationMonth = 0;
            $scope.package.durationYear = 0;
            $scope.package.restingtimeHour = 0;
            $scope.package.restingtimeMinute = 0;
            $scope.package.readyBookingDuration = 0;
            $scope.package.readyBookingDurationHour = 0;
            $scope.package.readyBookingDurationMinutes = 0;
        }
    };
    $scope.changeReadyBookingDurationType = function () {
        $scope.package.readyBookingDuration = 0;
        $scope.package.readyBookingDurationHour = 0;
        $scope.package.readyBookingDurationMinutes = 0;
    };
    /* END BOOKING SECTION */

    /* PRICE SECTION */
    $scope.selectingPolicy;
    $scope.pricingType = 'standard';
    $scope.isHaveCancellation = false;
    $scope.package.cancellationPolicyJson = $.parseJSON($scope.package.cancellationPolicyJson);
    if ($scope.package.cancellationPolicyJson.length > 0) {
        $scope.isHaveCancellation = true;
    }
    //Check cancellation Policy select or not
    $scope.$watch('isHaveCancellation', function (newVal, oldVal) {
        if (newVal === false) {
            $scope.package.cancellationPolicyJson = [];
        }
    }, true);
    $scope.removeCancellationPolicy = function (id) {
        $scope.package.cancellationPolicyJson.splice(id, 1);
    };
    angular.forEach($scope.packageForm.cancellations, function (child) {
        child.condition = $.parseJSON(child.condition);
    });
    function validatePriceInput() {
        var childrenMissingData = true;
        for (var i = 0; i < $scope.package.childrenDiscountJson.length; i++) {
            if ($scope.package.childrenDiscountJson[i].condition === '' || $scope.package.childrenDiscountJson[i].condition === null) {
                childrenMissingData = false;
            }
        }
        if ($scope.package.youtripperPrice !== '' && $scope.package.youtripperPrice !== 0 && childrenMissingData &&
                ($scope.package.packageType === 'Open' || ($scope.package.packageType !== 'Open' && $scope.package.maxTripper > 0))
                ) {
            return true;
        }
        return false;
    }

    $scope.descreaseYTPercentage = function () {
        if ($('#minusYTPercentage').hasClass('active')) {
            $scope.package.youtripperPercentage = $scope.package.youtripperPercentage - 1;
        }
    };
    $scope.increaseYTPercentage = function () {
        if ($('#plusYTPercentage').hasClass('active')) {
            $scope.package.youtripperPercentage = $scope.package.youtripperPercentage + 1;
        }
    };
    $scope.formatPercentage = function (number) {
        var result = number + "%";
        return result;
    };
    /*Create a new Policy*/
    /*Create a new Policy*/
    $scope.popupPolicyShowing = false;
    $scope.popupEditPolicyShowing = false;
    $scope.editingPolicyID = 0;
    $scope.offerPolicy = function (condition) {
        if (condition === false) {
            $scope.isHaveCancellation = false;
        } else {
            $scope.isHaveCancellation = true;
            $scope.package.cancellationPolicyJson = [{"duration": null, "percent": 5}];
        }

    };
    $scope.addNewPolicy = function () {
        if ($scope.package.cancellationPolicyJson.length < 5) {
            var newPolicy = {"duration": null, "percent": 5};
            $scope.package.cancellationPolicyJson.push(newPolicy);
        }
    };
    /*Children Discount Start*/
    $scope.isHaveChildrenDiscount = false;
//    $scope.newChildrenDiscountItem = {"condition": "", "discountPercent": ""};
    $scope.popupCreateChildrenDiscountShowing = false;
    $scope.package.childrenDiscountJson = $.parseJSON($scope.package.childrenDiscountJson);
    if ($scope.package.childrenDiscountJson.length > 0) {
        $scope.isHaveChildrenDiscount = true;
    }

    $scope.isOfferChildrenCount = function () {
        if ($scope.isHaveChildrenDiscount) {
            $scope.isHaveChildrenDiscount = false;
            $scope.package.childrenDiscountJson = [];
        } else {
            $scope.isHaveChildrenDiscount = true;
            $scope.package.childrenDiscountJson = [];
            var newChildrenDiscountItem = {"condition": "", "discountType": "age", "ageType": "years", "discountPercent": 5};
            $scope.package.childrenDiscountJson.push(newChildrenDiscountItem);
        }

    };
    $scope.addNewDiscount = function () {
        if ($scope.package.childrenDiscountJson.length < 4) {
            var newChildrenDiscountItem = {"condition": "", "discountType": "age", "ageType": "years", "discountPercent": 5};
            $scope.package.childrenDiscountJson.push(newChildrenDiscountItem);
        }
    };
    /*Children Discount End*/

    function getPriceData() {
        var data = {"ordinaryPriceForAdult": $scope.package.ordinaryPriceForAdult,
            "youtripperPrice": $scope.package.youtripperPrice, "priceCurrency": $scope.package.priceCurrency,
            "youtripperPercentage": $scope.package.youtripperPercentage,
            "cancellationID": $scope.package.cancellationID, "noCancellationPercent": $scope.package.noCancellationPercent,
            "childrenDiscounts": JSON.stringify($scope.package.childrenDiscountJson), "cancellationPolicy": JSON.stringify($scope.package.cancellationPolicyJson),
            "packageID": $scope.package.id, "providerID": $scope.package.providerID};
        return data;
    }

    //Increase and descrease button
    $scope.descrease = function (valueField) {
        if (valueField === 'package.maxTripper') {
            if ($scope.package.maxTripper > 1)
                $scope.package.maxTripper--;
        }
        if (valueField === 'package.minTripper') {
            if ($scope.package.minTripper > 1)
                $scope.package.minTripper--;
        }
        if (valueField === 'package.minimumResources') {
            if ($scope.package.minimumResources > 1)
                $scope.package.minimumResources--;
        }
    };
    $scope.increase = function (valueField) {
        if (valueField === 'package.maxTripper') {
            if ($scope.package.packageType === 'Personal' && ($scope.package.maxTripper === 5 || $scope.package.maxTripper === '5')) {

            } else {
                $scope.package.maxTripper++;
            }

        }
        if (valueField === 'package.minTripper') {
            if (3 < 4)
                $scope.package.minTripper++;
        }
        if (valueField === 'package.minimumResources') {
            $scope.package.minimumResources++;
        }
    };
    $scope.descreaseGroup = function (valueField) {

        if (valueField === 'package.minTripper') {
            if ($scope.package.minTripper > 3)
                $scope.package.minTripper--;
        }
        if (valueField === 'package.maxTripper') {
            if ($scope.package.maxTripper > 3) {
                $scope.package.maxTripper--;
            } else {

            }
        }


    };
    $scope.increaseGroup = function (valueField) {

        if (valueField === 'package.minTripper') {
            if ($scope.package.minTripper < 3) {
                $scope.package.minTripper = 3;
            } else if (3 < 4) {
                $scope.package.minTripper++;
            }

        }

        if (valueField === 'package.maxTripper') {
            if (($scope.package.maxTripper < $scope.package.minTripper) && ($scope.package.minTripper >= 3)) {
                $scope.package.maxTripper = $scope.package.minTripper + 1;
            } else if (($scope.package.maxTripper < $scope.package.minTripper) && ($scope.package.minTripper < 3)) {
                $scope.package.maxTripper = 4;
            } else
                $scope.package.maxTripper++;
        }

    };
    $scope.removeChildrenDiscount = function (discountID) {
        $scope.package.childrenDiscountJson.splice(discountID, 1);
    };
    $scope.removeDisabledDiscount = function (discountID) {
        angular.forEach($scope.package.disabledDiscounts, function (disabled, disabledIndex) {
            if (disabled.disabledDiscountID === discountID) {
                $scope.package.disabledDiscounts.splice(disabledIndex, 1);
            }
        });
    };
    /* END PRICE SECTION */
    // check which section is done
    function initiateWizards() {
        validateCategoryInput() ? $scope.wizards.category = true : 0;
        validateDescriptionInput() ? $scope.wizards.description = true : 0;
        validatePhotosInput() ? $scope.wizards.photos = true : 0;
        validateBookingInput() ? $scope.wizards.booking = true : 0;
        validatePriceInput() ? $scope.wizards.price = true : 0;
        $scope.allStepDones = checkAllStepDoneYet();
    }
    initiateWizards();
    /*Open confirm message box*/
    $scope.showMissingData = true;
    $scope.nextStep = 'finish';
    $scope.conflictCycleDate = false;
    $scope.saveWithCompleteDetail = false;
    $scope.nextSectionAfterAddReason = '';
    $scope.warningBoxShowing = false;
    $scope.showWarning = false;
    $scope.openConfirmBox = function (section) {
        $scope.nextStep = section;
        if ($scope.uploading) {
            alert("Please wait until image upload complete!");
        } else if (($scope.nextStep === 'category' || $scope.nextStep === 'description') && $scope.showWarning === false) {
            $('#warningBox').toggleClass('active');
            $scope.showWarning = true;
        } else if (($scope.selectedWizard === 'category' && $scope.package.isEditing === false) || ($scope.selectedWizard === 'description' && $scope.package.isEditing === false)) {
            $scope.nextSectionAfterAddReason = section;
            $('#reasonBox').toggleClass('active');
        } else {

            $scope.showMissingData = false;
            if ($scope.selectedWizard === 'category') {
                if ($scope.selectedAtivites.length > 0 && $scope.package.colorID > 0 && $scope.checkSuitabilty() && $scope.package.targetCountryID > 0) {
                    $scope.showMissingData = true;
                    $scope.saveWithCompleteDetail = true;
                }
                ;
            } else if ($scope.selectedWizard === 'description') {
                var checkDescriptionFlag = false;
                angular.forEach(languageDescriptionList, function (languageDescription) {

                    for (i = 0; i < languageDescription.description.length; i++) {
                        if (angular.isUndefined(languageDescription.packageName) || languageDescription.packageName === '' ||
                                angular.isUndefined(languageDescription.googleDescription) || languageDescription.googleDescription === '' ||
                                languageDescription.description[i].description.length < 200 || languageDescription.description[i].header.length < 10 ||
                                languageDescription.advancedAddress.action.length === 0 || languageDescription.advancedAddress.action[0].content === "") {
                            checkDescriptionFlag = true;
                        }
                    }

                });
                // check ameniti               
                for (i = 0; i < $scope.amenitiesClassifiers.length; i++)
                    if (angular.isUndefined($scope.amenitiesClassifiers[i].description) || $scope.amenitiesClassifiers[i].description.length < 100) {
                        checkDescriptionFlag = true;
                    }



                if (!checkDescriptionFlag) {
                    $scope.showMissingData = true;
                    $scope.saveWithCompleteDetail = true;
                }


            } else if ($scope.selectedWizard === 'photos') {
                if (angular.isString($scope.package.coverImage) && $scope.package.coverImage !== "" && $scope.coverImageSuccess === true) {
                    $scope.showMissingData = true;
                    $scope.saveWithCompleteDetail = true;
                }

            } else if ($scope.selectedWizard === 'booking') {
                if ($scope.package.readyBookingDurationType === "mins") {
                    $scope.package.readyBookingDuration = $scope.package.readyBookingDurationMinutes + $scope.package.readyBookingDurationHour * 60;
                }
                if (($scope.package.maxTripper > 0 || ($scope.package.packageType === 'Open' && $scope.package.minTripper > 0)) && ($scope.package.durationDay > 0 ||
                        $scope.package.durationMonth > 0 || $scope.package.durationYear > 0 || $scope.package.durationHour > 0 || $scope.package.durationMinute > 0) &&
                        (($scope.package.durationDay === 0 && $scope.package.servingPeriodID > 0) || $scope.package.durationDay > 0 || $scope.package.durationMonth > 0 || $scope.package.durationYear > 0)
                        && ($scope.package.isFreeBooking || (!$scope.package.isFreeBooking && ($scope.package.fixedHour !== null || $scope.package.fixedMinute !== null)))
                        && (!$scope.package.isUsingMaxQuota || ($scope.package.isUsingMaxQuota && $scope.package.maxQuota > 0))
                        ) {
                    $scope.showMissingData = true;
                    $scope.saveWithCompleteDetail = true;
                }

            } else if ($scope.selectedWizard === 'price') {
                var childrenMissingData = true;
                var cancellationMissingData = true;
                for (var i = 0; i < $scope.package.childrenDiscountJson.length; i++) {
                    if ($scope.package.childrenDiscountJson[i].condition === '' || $scope.package.childrenDiscountJson[i].condition === null) {
                        childrenMissingData = false;
                    }
                }
                for (var i = 0; i < $scope.package.cancellationPolicyJson.length; i++) {
                    if ($scope.package.cancellationPolicyJson[i].duration === '' || $scope.package.cancellationPolicyJson[i].duration === null) {
                        cancellationMissingData = false;
                    }
                }
                if ($scope.package.youtripperPrice !== '' && $scope.package.youtripperPrice !== 0
                        && childrenMissingData && cancellationMissingData) {
                    $scope.showMissingData = true;
                    $scope.saveWithCompleteDetail = true;
                }
            }
            if ($scope.showMissingData) {
                $scope.confirmContinue($scope.nextStep);
            } else {
                $('#ConfirmBox').toggleClass('active');
            }
        }
    };
    $scope.closeWarningBox = function () {
        $('#warningBox').toggleClass('active');
    };
    $scope.closeReasonBox = function () {
        $('#reasonBox').toggleClass('active');
    };
    $scope.reasonModel = '';
    $scope.showMissingReason = false;
    $scope.addingEditingReason = false;
    $scope.insertEditReason = function () {
        if ($scope.reasonModel === '') {
            $scope.showMissingReason = true;
        } else {
            //Submit reason
            $scope.addingEditingReason = true;
            var data = {"packageID": $scope.package.id, "providerID": $scope.package.providerID, "editingReason": $scope.reasonModel};
            $http.post(service.getContextPath() + "/Provider/Package/InsertEditingReason", data)
                    .then(function successCallback(response) {
                        if (response.data.result === "error") {
                            var pageError = service.getContextPath() + service.getErrorPageUrl();
                            $(location).attr('href', pageError);
                        } else {
                            $scope.addingEditingReason = false;
                            $('#reasonBox').toggleClass('active');
                            $scope.package.isEditing = true;
                            $scope.openConfirmBox($scope.nextSectionAfterAddReason);
                        }
                    });
        }
    };
    $scope.checkisUndefined = function (text) {
        if (angular.isUndefined(text) || text === '' || text === null) {
            return true;
        }
        return false;
    };
    $scope.checkMinName = function (text, number) {
        if (text.length < number) {
            return true;
        }
        return false;
    };
    /*Provider edit information before continue*/
    $scope.confirmEdit = function () {
        $('#ConfirmBox').removeClass('active');
    };
    /*Provider want to leave some info and go to next step*/
    $scope.confirmContinue = function (section) {
        $scope.showMissingData = true;
        $('#ConfirmBox').removeClass('active');
        if (section === 'finish') {
            $scope.moveNextWizard();
        } else {
            $scope.setSelectedWizard(section);
        }
    };
    $scope.showPickMinutes = false;
    $scope.showPickHours = false;
    $scope.pickMinuteHours = function () {
        if ($scope.package.durationType === 'minutes') {
            $scope.showPickMinutes = true;
            $scope.showPickHours = false;
        } else if ($scope.package.durationType === 'hours') {
            $scope.showPickHours = true;
            $scope.showPickMinutes = false;
        } else {
            $scope.showPickHours = false;
            $scope.showPickMinutes = false;
        }

    };
    $scope.pickMinuteHours();
    $scope.chooseNoCancellationPrice = function () {
        if ($scope.package.noCancellationPercent !== 0) {
            $scope.package.noCancellationPercent = 0;
        } else {
            $scope.package.noCancellationPercent = 1;
        }
    };
    $scope.increaseNoCancellationPercentage = function () {
        if ($('#plusInNoCancellation').hasClass('active')) {
            $scope.package.noCancellationPercent = $scope.package.noCancellationPercent + 1;
        }
    };
    $scope.descreaseNoCancellationPercentage = function () {
        ge
        if ($('#minusInNoCancellation').hasClass('active')) {
            $scope.package.noCancellationPercent = $scope.package.noCancellationPercent - 1;
        }
    };
    $scope.viewNoCancellationPrice = function (price) {
        var result = price + "%";
        return result;
    };

    //Warning on leaving
    window.onbeforeunload = function (event) {
        event.returnValue = "Don't forget to save your data before leaving!";
    };

    //Warning on inactive
    var inActiveTime = 0;
    var showingPopupInActive = false;
    function resetInitInActiveTime() {
        showingPopupInActive = false;
        var initDate = new Date();
        inActiveTime = initDate.getTime();
    }
    ;
    resetInitInActiveTime();

    function checkInActiveTime() {
        var newDate = new Date();
        var currentTime = newDate.getTime();
        if (!showingPopupInActive) {
            if (currentTime - inActiveTime > 1800000) {
                showingPopupInActive = true;
                $('#warningSaveBox').toggleClass('active');
            }
        }
    }
    ;
    $interval(checkInActiveTime, 1000);

    $scope.closeWaringSave = function () {
        resetInitInActiveTime();
        $('#warningSaveBox').toggleClass('active');
    };

    $scope.loaded = true;
});
myApp.controller('CreateSalesController', function ($scope, $q, $http, service) {
    $scope.loaded = false;
    /* COMMON */

    $scope.page = page;
    $scope.showError = {phoneNumber: false, all: false};
    $scope.missing = {phoneNumber: false};
    $scope.validateRegisterForm = function (event) {
        if (!$scope["signupForm"].$valid || $scope.missing.phoneNumber) {
            $scope.showError.all = true;
            event.preventDefault();
        }
    };
    $scope.onlyNumbers = /^\d+$/;
    var pending = false;
    var deferred = $q.defer();
    $scope.phoneNumberLoading = false;
    $scope.$watch('register.phoneNumber', function (newVal, oldVal) {
        $scope.phoneNumberLoading = false;
        $scope.showError.phoneNumber = false;
        clearTimeout($scope.timeout);
        $scope.timeout = setTimeout(function () { // start a new timeout
            if (oldVal !== null && oldVal !== undefined && oldVal !== "") {
                $scope.showError.phoneNumber = true;
                if ($scope["signupForm"].phoneNumber.$valid) {
                    if (pending) {
                        deferred.resolve();
                        deferred = $q.defer();
                    }
                    pending = true;
                    $scope.phoneNumberLoading = true;
                    var data = {"phoneNumber": $scope.register.phoneNumber};
                    $http.post(checkMobileNumber, data, {timeout: deferred.promise})
                            .then(function successCallback(response) {
                                pending = false;
                                deferred = $q.defer();
                                if (response.data.result === "error") {
                                    var pageError = service.getContextPath() + service.getErrorPageUrl();
                                    $(location).attr('href', pageError);
                                } else if (response.data.result === "fail") {
                                    $scope.missing.phoneNumber = true;
                                } else {
                                    $scope.missing.phoneNumber = false;
                                }
                                $scope.phoneNumberLoading = false;
                            });
                    $scope.$digest();
                } else {
                    $scope.missing.phoneNumber = false;
                }
                $scope.$digest();
            }
            clearTimeout($scope.timeout); // clear time out just in case.
        }, 1000);
    });
    $scope.loaded = true;
});
myApp.controller('ManagerSales', function ($scope) {
    $scope.loaded = false;
    /* COMMON */
    $scope.providerList = providerInfo;
    $scope.activatePackage = {"1": "Yes", "0": "No"};
    $scope.page = page;
    $scope.loaded = true;
});
myApp.controller('ManageCertificateController', function ($scope) {
    $scope.loaded = false;
    /* COMMON */
    $scope.certificates = certificates;
    $scope.certificatesGroup = [];
    for (i = 0; i < $scope.certificates.length; i++) {
        var provider = $scope.certificates[i];
        var addNew = true;
        for (j = 0; j < $scope.certificatesGroup.length; j++) {
            var certificateById = $scope.certificatesGroup[j];
            if (provider.providerID === certificateById.id) {
                certificateById.certificate.push($scope.certificates[i]);
                addNew = false;
            }
        }
        if (addNew) {
            var providerCertificates = {"id": provider.providerID, "certificate": []};
            providerCertificates.certificate.push($scope.certificates[i]);
            $scope.certificatesGroup.push(providerCertificates);
        }
    }

    console.log($scope.certificatesGroup);
    console.log($scope.certificatesGroup[0].certificate);
    $scope.page = page;
    $scope.loaded = true;
});
myApp.controller('ManageSalesmanController', function ($scope, $http) {
    $scope.loaded = false;
    /* COMMON */
    $scope.register = {"phone": ""};
    $scope.salesmans = salesmans;
    $scope.page = page;
    $scope.changeCurrentSalesman = function (salesmanId) {
        $scope.loaded = false;
        $scope.currentId = salesmanId;
        var data = {"salesmanId": salesmanId};
        $http.post(loadProviderList, data)
                .then(function successCallback(response) {
                    $scope.providers = response.data;
                    $scope.loaded = true;
                });
    };
    if ($scope.salesmans.length > 0) {
        $scope.currentId = salesmans[0].salesmanId;
        $scope.changeCurrentSalesman($scope.currentId);
    } else {
        $scope.loaded = true;
    }

});
myApp.controller('ResourceManagementController', function ($scope, $http, $timeout, service, $interval) {
    $scope.resourceManagementData = resourceManagementData;
    var RESOURCES_WIDTH = 170, CAPACITY_WIDTH = 190, ACTION_WIDTH = 60;
    var MAXIMUM_RESOURCES_ROW = 4;
    $scope.sizeOfHashMap = function (obj) {
        return service.sizeOfHashMap(obj);
    };
    $scope.calculateWidthOfSkills = function () {
        var windowWidth = $("#provider-resource-tbl .tbl-body").outerWidth(true);
        var skillWidth = windowWidth - RESOURCES_WIDTH - CAPACITY_WIDTH - ACTION_WIDTH;
        // set width of column skills
        $("table.resourceManage > tbody > tr > td:nth-of-type(2)").width(skillWidth);
        // set width of each skill
        var noSkills = $scope.resourceManagementData.resourceSkills.length;
        var indeedWidth = noSkills > 0 ? skillWidth / noSkills : skillWidth;
        $(".skills-tbl tr td").width(indeedWidth);
        // calculate height of resource
//        var bodyHeight = $("#provider-resource-tbl .tbl-body")[0].getBoundingClientRect().height;
//
//        var eachResourceHeight;
//        var noResources = $scope.resourceManagementData.providerResources.length;
//        if (noResources < 2) {
//            eachResourceHeight = bodyHeight;
//        } else if (noResources < 4) {
//            eachResourceHeight = bodyHeight / noResources;
//        } else {
//            eachResourceHeight = bodyHeight / MAXIMUM_RESOURCES_ROW;
//        }
//
        //        $("#provider-resource-tbl .tbl-body > table > tbody > tr").height(eachResourceHeight);

        // calculate top of table body
        var resourceTop = $("#provider-resource-tbl .tbl-header").outerHeight(true);
        $("#provider-resource-tbl .tbl-body").css("top", resourceTop);
        var resourceTop = $("#trip-resource-tbl .tbl-header").outerHeight(true);
        $("#trip-resource-tbl .tbl-body").css("top", resourceTop);
    };
    $(function () {
        $(window).resize(function () {
            $scope.calculateWidthOfSkills();
        });
    });
    // construct business resource list
    $scope.providerResources = {};
    function constructProviderResources() {
        $scope.providerResources = {};
        var providerResources = $scope.resourceManagementData.providerResources;
        for (var i = 0, max = providerResources.length; i < max; i++) {
            var providerResource = providerResources[i];
            var resourceID = providerResource.businessResourceID;
            // check resourceID is exist or not
            var newProviderR = $scope.providerResources[resourceID];
            if (!angular.isObject(newProviderR)) { // if not create new default resource
                newProviderR = {};
                $scope.providerResources[resourceID] = newProviderR;
                newProviderR["providerResourceID"] = resourceID;
                newProviderR["name"] = providerResource.resourceName;
                newProviderR["capacity"] = providerResource.capacity;
                newProviderR["noSkills"] = providerResource.noSkills;
                newProviderR["skillIDs"] = [];
            }
            // add skill to provider R
            var skillID = providerResource["skillID"];
            if (skillID > 0) {
                newProviderR["skillIDs"].push(skillID);
            }
        }
    }

    $scope.checkResourceSkillIsChecked = function (skillID, skillIDs) {
        for (var i = 0, max = skillIDs.length; i < max; i++) {
            if (skillID === skillIDs[i]) {
                return true;
            }
        }
        return false;
    };
    // construct TrippSorce
    $scope.trippResources = {"Temporary": {}, "Primary": {}};
    function constructTrippSources() {
        $scope.trippResources = {"Temporary": {}, "Primary": {}};
        var trippSources = $scope.resourceManagementData.trippSources;
        for (var i = 0, max = trippSources.length; i < max; i++) {
            var trippSource = trippSources[i];
            var packageType = trippSource.type;
            var packages = $scope.trippResources[packageType];
            var packageID = trippSource.packageID;
            var package = packages[packageID];
            if (!angular.isObject(package)) { // if package is not exist in list
                // then create this package into list
                package = {};
                packages[packageID] = package;
                package["packageID"] = packageID;
                package["packageName"] = trippSource.packageName;
                package["trippSources"] = {};
            }

            // add resource in list
            var newTrippSources = package["trippSources"];
            var newTripsourceID = trippSource.trippSourceID;
            if (newTripsourceID > 0) {
                var oldTripSouce = newTrippSources[newTripsourceID];
                // check new resource is inside list yet or not
                if (!angular.isObject(oldTripSouce)) {
                    // if not then create default
                    oldTripSouce = {};
                    newTrippSources[newTripsourceID] = oldTripSouce;
                    oldTripSouce["trippSourceID"] = newTripsourceID;
                    oldTripSouce["hours"] = trippSource.hours;
                    oldTripSouce["minutes"] = trippSource.minutes;
                    oldTripSouce["days"] = trippSource.days;
                    oldTripSouce["noUnits"] = trippSource.noUnits;
                    oldTripSouce["skills"] = [];
                }

                // then add new skill to this resource
                var skillID = trippSource.skillID;
                if (skillID > 0) {
                    oldTripSouce["skills"].push(skillID);
                }
            }
        }
    }

    /* SKILL */
    var INSERT_RESOURCE_SKILL_URL = service.getContextPath() + "/Provider/InsertResourceSkill";
    $scope.skillSaving = false;
    $scope.saveNewResourceSkill = function () {
        // validate before insert
        if ($scope.newSkillName !== "") {
            $scope.skillSaving = true;
            var data = {"resourceName": $scope.newSkillName};
            $http.post(INSERT_RESOURCE_SKILL_URL, data)
                    .then(function successCallback(response) {
                        if (response.data.result === "error") {
                            var pageError = service.getContextPath() + service.getErrorPageUrl();
                            $(location).attr('href', pageError);
                        } else {
                            $scope.resourceManagementData = response.data;
                            // calculate everything again
                            initiateDefault();
                            // close popup
                            $scope.toggleSkillBox();
                            $scope.skillSaving = false;
                        }
                    });
        }
    };
    $scope.newSkillName = "";
    $scope.toggleSkillBox = function () {
        $scope.newSkillName = "";
        $("#skillPopup").toggleClass("active");
    };
    $scope.selectedSkillName;
    $scope.selectedSkillID;
    $scope.openSkillEditingPopup = function (skillID, skillName) {
        $scope.selectedSkillName = skillName;
        $scope.selectedSkillID = skillID;
        !$("#skillEditingPopup").hasClass("active") ? $("#skillEditingPopup").addClass("active") : 0;
    };
    $scope.closeSkillEditingPopup = function () {
        $("#skillEditingPopup").hasClass("active") ? $("#skillEditingPopup").removeClass("active") : 0;
    };
    var SKILL_DELETING_URL = service.getContextPath() + "/Provider/DeleteResourceSkill";
    $scope.skillEditing = false;
    $scope.deleteSkill = function (selectedSkillID) {
        $scope.skillEditing = true;
        var data = {"skillID": selectedSkillID};
        $http.post(SKILL_DELETING_URL, data)
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        $scope.resourceManagementData = response.data;
                        // calculate everything again
                        initiateDefault();
                        // close popup
                        $scope.closeSkillEditingPopup();
                        $scope.skillEditing = false;
                    }
                });
    };
    var SKILL_EDITING_URL = service.getContextPath() + "/Provider/EditResourceSkill";
    $scope.editSkill = function (selectedSkillID, selectedSkillName) {
        // validate first 
        console.log(selectedSkillName);
        if (selectedSkillName !== "") {
            $scope.skillEditing = true;
            var data = {"skillID": selectedSkillID, "skillName": selectedSkillName};
            $http.post(SKILL_EDITING_URL, data)
                    .then(function successCallback(response) {
                        if (response.data.result === "error") {
                            var pageError = service.getContextPath() + service.getErrorPageUrl();
                            $(location).attr('href', pageError);
                        } else {
                            $scope.resourceManagementData = response.data;
                            // calculate everything again
                            initiateDefault();
                            // close popup
                            $scope.closeSkillEditingPopup();
                            $scope.skillEditing = false;
                        }
                    });
        }
    };
    /* END SKILL */

    /* PROVIDER RESOURCE */
    $scope.providerResourceSaving = false;
    var INSERT_PROVIDER_RESOURCE_URL = service.getContextPath() + "/Provider/InsertProviderResource";
    $scope.insertNewProviderResource = function () {
        // valdiate first
        if ($scope.newResourceName !== "" && angular.isNumber($scope.newResourceCapacity) && $scope.newResourceCapacity > 0) {
            $scope.providerResourceSaving = true;
            var data = {"resourceName": $scope.newResourceName, "capacity": $scope.newResourceCapacity};
            $http.post(INSERT_PROVIDER_RESOURCE_URL, data)
                    .then(function successCallback(response) {
                        if (response.data.result === "error") {
                            var pageError = service.getContextPath() + service.getErrorPageUrl();
                            $(location).attr('href', pageError);
                        } else {
                            $scope.resourceManagementData = response.data;
                            // calculate everything again
                            initiateDefault();
                            // close popup
                            $scope.toggleProviderResourceBox();
                            $scope.providerResourceSaving = false;
                            // scroll to bottom
                            var topPosition = $('#provider-resource-tbl .tbl-body')[0].scrollHeight;
                            $('#provider-resource-tbl .tbl-body').animate({
                                scrollTop: topPosition
                            }, 500);
                        }
                    });
        }
    };
    $scope.newResourceName = "";
    $scope.newResourceCapacity;
    $scope.toggleProviderResourceBox = function () {
        $scope.newResourceName = "";
        $scope.newResourceCapacity = null;
        $("#providerResourcePopup").toggleClass("active");
    };
    $scope.changeProviderResourceToEditMode = function (providerResourceID) {
        var selectorName = "#provider-resource-tbl .provider-resource-row[providerResourceID=" + providerResourceID + "]";
        !$(selectorName).hasClass("edit-mode") ? $(selectorName).addClass("edit-mode") : 0;
    };
    var PROVIDER_RESOURCE_EDITING_URL = service.getContextPath() + "/Provider/EditProviderResource";
    $scope.editing = false;
    $scope.saveProviderResource = function (providerResourceID) {
        // validate first
        var currentProviderResource = $scope.providerResources[providerResourceID];
        var name = currentProviderResource.name;
        var capacity = currentProviderResource.capacity;
        if (name !== "" && angular.isNumber(capacity) && capacity > 0) {
            // check skill is not existed in list
            var isExist = false;
            if ($scope.resourceManagementData.resourceSkills.length > 0) {
                var skillIDs = currentProviderResource.skillIDs;
                angular.forEach($scope.providerResources, function (providerResource, eachResourceID) {
                    if (eachResourceID !== providerResourceID && !isExist) {
                        var eachSkillIDs = providerResource.skillIDs;
                        var eachLength = eachSkillIDs.length;
                        if (eachLength === skillIDs.length && !isExist) {
                            isExist = true;
                            for (var i = 0; i < eachLength && isExist; i++) {
                                var skillID = eachSkillIDs[i];
                                if (skillIDs.indexOf(skillID) < 0) {
                                    isExist = false;
                                }
                            }
                        }
                    }
                });
            }

            if (!isExist) {
                // then edit
                $scope.editing = true;
                var data = {"name": name, "capacity": capacity, "resourceID": providerResourceID, "skills": skillIDs};
                $http.post(PROVIDER_RESOURCE_EDITING_URL, data)
                        .then(function successCallback(response) {
                            if (response.data.result === "error") {
                                var pageError = service.getContextPath() + service.getErrorPageUrl();
                                $(location).attr('href', pageError);
                            } else {

                                var selectorName = "#provider-resource-tbl .provider-resource-row[providerResourceID=" + providerResourceID + "]";
                                $(selectorName).hasClass("edit-mode") ? $(selectorName).removeClass("edit-mode") : 0;
                                $scope.editing = false;
                            }
                        });
            }
        }
    };
    var PROVIDER_RESOURCE_DELETING_URL = service.getContextPath() + "/Provider/DeleteProviderResource";
    $scope.editing = false;
    $scope.deleteProviderResource = function (providerResourceID) {
        // then edit
        $scope.editing = true;
        var data = {"resourceID": providerResourceID};
        $http.post(PROVIDER_RESOURCE_DELETING_URL, data)
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        delete $scope.providerResources[providerResourceID];
                        $scope.editing = false;
                    }
                });
    };
    $scope.isEditMode = function (providerResourceID) {
        var selectorName = "#provider-resource-tbl .provider-resource-row[providerResourceID=" + providerResourceID + "]";
        return $(selectorName).hasClass("edit-mode");
    };
    /* END PROVIDER RESOURCE */

    /* TRIPPSOURCE */
    $scope.selectedPackageID = null;
    $scope.selectedTemporaryPackageID = null;
    $scope.setTrippSourceDataForPopup = function (packageID, packageType) {
        if (packageType === 'Primary') {
            $scope.selectedPackageID = packageID;
            $scope.selectedTemporaryPackageID = null;
        } else {
            $scope.selectedPackageID = null;
            $scope.selectedTemporaryPackageID = packageID;
        }
        $scope.toggleTrippSourcePopup();
    };
    $scope.toggleTrippSourcePopup = function () {
        $scope.newDurationType = "days";
        $scope.newNoUnits = null;
        $scope.setDefaultForTime();
        $("#trippSourcePopup").toggleClass("active");
    };
    $scope.setDefaultForTime = function () {
        $scope.newHours = null;
        $scope.newMinutes = null;
        $scope.newNoDays = null;
    };
    $scope.trippSourceAssigning = false;
    var ASSIGN_TRIPP_RESOURCE_URL = service.getContextPath() + "/Provider/AssignNewTrippSourceToPackage";
    $scope.assignNewTrippSource = function () {
        // valdiate first
        if (angular.isNumber($scope.newNoUnits) && $scope.newNoUnits > 0) {

            $scope.trippSourceAssigning = true;
            var data = {"packageID": $scope.selectedPackageID,
                "temporaryPackageID": $scope.selectedTemporaryPackageID,
                "noUnits": $scope.newNoUnits, "hours": $scope.newHours,
                "minutes": $scope.newMinutes, "days": $scope.newNoDays};
            $http.post(ASSIGN_TRIPP_RESOURCE_URL, data)
                    .then(function successCallback(response) {
                        if (response.data.result === "error") {
                            var pageError = service.getContextPath() + service.getErrorPageUrl();
                            $(location).attr('href', pageError);
                        } else {
                            $scope.resourceManagementData = response.data;
                            // calculate everything again
                            initiateDefault();
                            // close popup
                            $scope.toggleTrippSourcePopup();
                            $scope.trippSourceAssigning = false;
                        }
                    });
        }
    };
    $scope.isTrippSourceInEdit = function (trippSourceID) {
        var selector = "#trip-resource-tbl .tbl-body tr.trippSource-row[trippSourceID=" + trippSourceID + "]";
        return $(selector).hasClass("edit-mode");
    };
    $scope.changeTrippSourceToEdit = function (trippSourceID) {
        var selector = "#trip-resource-tbl .tbl-body tr.trippSource-row[trippSourceID=" + trippSourceID + "]";
        !$(selector).hasClass("edit-mode") ? $(selector).addClass("edit-mode") : 0;
    };
    $(document).click(function (event) {

        if ($(event.target).is('a.active-time-link')) {
            if ($(event.target).next(".edit-time-popup").hasClass("active")) {
                $(".edit-time-popup.active").removeClass("active");
            } else {
                $(".edit-time-popup.active").removeClass("active");
                $(event.target).next(".edit-time-popup").addClass("active");
            }
        } else if (!$(event.target).closest('.edit-time-popup').length && !$(event.target).is('.edit-time-popup')) {
            if ($(".edit-time-popup.active").length > 0) {
                $(".edit-time-popup.active").removeClass("active");
            }
        }

    });
    $scope.changeDayOfTrippSource = function (trippSource) {
        trippSource.hours = 0;
        trippSource.minutes = 0;
    };
    $scope.changeTimeOfTrippSource = function (trippSource) {
        trippSource.days = 0;
    };
    var TRIPP_RESOURCE_DELETING_URL = service.getContextPath() + "/Provider/DeleteTrippSource";
    $scope.trippSourceEditing = false;
    $scope.deleteTrippSource = function (packageType, packageID, trippSourceID) {
        // then edit
        $scope.trippSourceEditing = true;
        var data;
        if (packageType === "Primary") {
            data = {"trippSourceID": trippSourceID, "packageID": packageID};
        } else {
            data = {"trippSourceID": trippSourceID, "temporaryPackageID": packageID};
        }
        $http.post(TRIPP_RESOURCE_DELETING_URL, data)
                .then(function successCallback(response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        delete $scope.trippResources[packageType][packageID].trippSources[trippSourceID];
                        $scope.trippSourceEditing = false;
                    }
                });
    };
    var TRIPP_RESOURCE_EDITING_URL = service.getContextPath() + "/Provider/EditTrippSource";
    $scope.trippSourceEditing = false;
    $scope.editTrippSource = function (packageType, packageID, trippSourceID) {
        // construct json
        var data;
        if (packageType === "Primary") {
            data = {"trippSourceID": trippSourceID, "packageID": packageID};
        } else {
            data = {"trippSourceID": trippSourceID, "temporaryPackageID": packageID};
        }

        var newTrippSource = $scope.trippResources[packageType][packageID].trippSources[trippSourceID];
        data["noUnits"] = newTrippSource.noUnits;
        data["hours"] = newTrippSource.hours > 0 ? newTrippSource.hours : null;
        data["minutes"] = newTrippSource.minutes > 0 ? newTrippSource.minutes : null;
        data["days"] = newTrippSource.days > 0 ? newTrippSource.days : null;
        data["skills"] = newTrippSource.skills;
        // validate first
        if (data["noUnits"] > 0) {
            $scope.trippSourceEditing = true;
            // ajax to edit
            $http.post(TRIPP_RESOURCE_EDITING_URL, data)
                    .then(function successCallback(response) {
                        if (response.data.result === "error") {
                            var pageError = service.getContextPath() + service.getErrorPageUrl();
                            $(location).attr('href', pageError);
                        } else {
                            var selector = "#trip-resource-tbl .tbl-body tr.trippSource-row[trippSourceID=" + trippSourceID + "]";
                            $(selector).hasClass("edit-mode") ? $(selector).removeClass("edit-mode") : 0;
                            $scope.trippSourceEditing = false;
                        }
                    });
        }
    };
    /* END TRIPPSOURCE */

    function initiateDefault() {
        constructProviderResources();
        constructTrippSources();
        $scope.calculateWidthOfSkills();
    }

    initiateDefault();
});
myApp.controller('ProviderMessageController', function ($scope, $http, service) {
    $scope.loaded = false;
    var stompClient = null;
    var conversationSocket = null;
    $scope.currentConversationID = 0;
    $scope.conversationDetail = [];
    $scope.loadingConvDetail = false;
    $scope.default = 5;
    var subscribe = "/topic/long";
    var receive = "/app/hello/long";
    /* COMMON */
    $scope.packageList = packageList;
    $scope.conversationList = conversationList;
    var contentElement = $(".messConversation");
    //Format date for conversation message
    Date.prototype.HHmmddMMyyyy = function () {
        var yyyy = this.getFullYear().toString();
        var mm = (this.getMonth() + 1).toString(); // getMonth() is zero-based
        var dd = this.getDate().toString();
        var HH = this.getHours().toString();
        var MM = this.getMinutes().toString();
        return (HH[1] ? HH : "0" + HH[0]) + ":" + (MM[1] ? MM : "0" + MM[0]) + " " + (dd[1] ? dd : "0" + dd[0]) + "/" + (mm[1] ? mm : "0" + mm[0]) + "/" + yyyy; // padding
    };
    $scope.selectPackageForView = function () {
        $(".packgeDropdownMenu").addClass("active");
    };
    $scope.changeSelectedPackage = function (packageID) {

    };
    //Websock to check new conversation,unread message
    $scope.websocketForConversationList = function () {
        subscribe = "/topic/providerCheckListConversation/" + providerID;
        //for tripper to send notify new mess
        //    receive = "/app/hello/checkListConversation/"+providerID;
        var socket = new SockJS(service.getContextPath() + "/hello/");
        stompClient = Stomp.over(socket);
        //        stompClient.debug = null;
        stompClient.connect({}, function (frame) {
            stompClient.subscribe(subscribe, function (message) {
                //                    $scope.conversationDetail.push(message);
            });
        });
    };
    $scope.websocketForConversationList();
    //Web socket to send conversation message
    $scope.viewConversationDetail = function (conversationID) {
        if (conversationSocket !== null) {
            conversationSocket = null;
        }
        $scope.currentConversationID = conversationID;
        $scope.loadingConvDetail = true;
        //Load message of conversation
        var data = {"conversationID": $scope.currentConversationID, "NumberOfRecords": $scope.default, "time": "0"};
        $http.post(service.getContextPath() + "/Message/getConversationMessage", data)
                .then(function (response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        for (var i = 0; i < response.length; i++) {
                            response[i].message = JSON.parse(response[i].message);
                        }
                        $scope.conversationDetail = response.data;
                        $scope.loadingConvDetail = false;
                    }
                });
        subscribe = "/topic/sendChatMessage/" + conversationID;
        //for tripper to send notify new mess

        var socket = new SockJS(service.getContextPath() + "/hello/");
        conversationSocket = Stomp.over(socket);
        //        stompClient.debug = null;
        conversationSocket.connect({}, function (frame) {
            conversationSocket.subscribe(subscribe, function (greeting) {
                //Provider add new message to current conversation
                console.log('ready to chat');
            });
        });
    };
    $scope.sendmessage = function () {
        var myMess = document.getElementById('textReply').value;
        myMess = myMess.replace(/\r\n|\r|\n/g, "<br>");
        var now = new Date();
        var newMessage = {"messageID": 9999999999999999, "userType": "provider",
            "time": now, "message": myMess,
            "userID": providerID, "conversationID": $scope.currentConversationID, "lastName": userName,
            "image": userImage, "isRead": false};
        $scope.conversationDetail.push(newMessage);
        $scope.$digest();
        contentElement.scrollTop(contentElement[0].scrollHeight);
        receive = "/app/hello/sendChatMessage/" + $scope.currentConversationID;
        stompClient.send(receive, {}, JSON.stringify({'content': myMess, 'userType': 2, 'userID': Number(providerID), 'name': userName, 'isRead': 0}));
    };
    $('#textReply').keypress(function (event) {
        if (event.keyCode === 13 && !event.shiftKey) {
            event.preventDefault();
            $scope.$digest();
            if ($('#textReply').val() !== "") {
                $scope.sendmessage();
                $('#textReply').val("");
            }
        }
    });
    $scope.formatMessageTime = function (time) {
        var milliseconds = Number(time);
        var myDate = new Date(milliseconds);
        return myDate.HHmmddMMyyyy();
    };
    $scope.detectScrollToTop = function () {
        $(function () {
            $('#messConversation').bind('scroll', function ()
            {
                if ($('#messConversation').scrollTop() === 0) {
                    console.log('Top');
                    $scope.loadingScroll = false;
                }

            });
        });
    };
    $scope.detectScrollToTop();
    $scope.loaded = true;
});
myApp.controller('TripperMessageController', function ($scope, $http, service) {
    $scope.loaded = false;
    var stompClient = null;
    var conversationSocket = null;
    $scope.currentConversationID = 0;
    $scope.conversationDetail = [];
    $scope.loadingConvDetail = false;
    $scope.default = 5;
    var subscribe = "/topic/long";
    var receive = "/app/hello/long";
    /* COMMON */
    $scope.conversationList = conversationList;
    var contentElement = $(".messConversation");
    //Format date for conversation message
    Date.prototype.HHmmddMMyyyy = function () {
        var yyyy = this.getFullYear().toString();
        var mm = (this.getMonth() + 1).toString(); // getMonth() is zero-based
        var dd = this.getDate().toString();
        var HH = this.getHours().toString();
        var MM = this.getMinutes().toString();
        return (HH[1] ? HH : "0" + HH[0]) + ":" + (MM[1] ? MM : "0" + MM[0]) + " " + (dd[1] ? dd : "0" + dd[0]) + "/" + (mm[1] ? mm : "0" + mm[0]) + "/" + yyyy; // padding
    };
    $scope.selectPackageForView = function () {
        $(".packgeDropdownMenu").addClass("active");
    };
    $scope.changeSelectedPackage = function (packageID) {

    };
    //Websock to check new conversation,unread message
    $scope.websocketForConversationList = function () {
        subscribe = "/topic/providerCheckListConversation/" + providerID;
        //for tripper to send notify new mess
        //    receive = "/app/hello/checkListConversation/"+providerID;
        var socket = new SockJS(service.getContextPath() + "/hello/");
        stompClient = Stomp.over(socket);
        //        stompClient.debug = null;
        stompClient.connect({}, function (frame) {
            stompClient.subscribe(subscribe, function (message) {
                //                    $scope.conversationDetail.push(message);
            });
        });
    };
    $scope.websocketForConversationList();
    //Web socket to send conversation message
    $scope.viewConversationDetail = function (conversationID) {
        if (conversationSocket !== null) {
            conversationSocket = null;
        }
        $scope.currentConversationID = conversationID;
        $scope.loadingConvDetail = true;
        //Load message of conversation
        var data = {"conversationID": $scope.currentConversationID, "NumberOfRecords": $scope.default, "time": "0"};
        $http.post(service.getContextPath() + "/Message/getConversationMessage", data)
                .then(function (response) {
                    if (response.data.result === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        for (var i = 0; i < response.length; i++) {
                            response[i].message = JSON.parse(response[i].message);
                        }
                        $scope.conversationDetail = response.data;
                        $scope.loadingConvDetail = false;
                    }
                });
        subscribe = "/topic/sendChatMessage/" + conversationID;
        //for tripper to send notify new mess

        var socket = new SockJS(service.getContextPath() + "/hello/");
        conversationSocket = Stomp.over(socket);
        //        stompClient.debug = null;
        conversationSocket.connect({}, function (frame) {
            conversationSocket.subscribe(subscribe, function (greeting) {
                //Provider add new message to current conversation
                console.log('ready to chat');
            });
        });
    };
    $scope.sendmessage = function () {
        var myMess = document.getElementById('textReply').value;
        myMess = myMess.replace(/\r\n|\r|\n/g, "<br>");
        var now = new Date();
        var newMessage = {"messageID": 9999999999999999, "userType": "provider",
            "time": now, "message": myMess,
            "userID": providerID, "conversationID": $scope.currentConversationID, "lastName": userName,
            "image": userImage, "isRead": false};
        $scope.conversationDetail.push(newMessage);
        $scope.$digest();
        contentElement.scrollTop(contentElement[0].scrollHeight);
        receive = "/app/hello/sendChatMessage/" + $scope.currentConversationID;
        stompClient.send(receive, {}, JSON.stringify({'content': myMess, 'userType': 2, 'userID': Number(providerID), 'name': userName, 'isRead': 0}));
    };
    $('#textReply').keypress(function (event) {
        if (event.keyCode === 13 && !event.shiftKey) {
            event.preventDefault();
            $scope.$digest();
            if ($('#textReply').val() !== "") {
                $scope.sendmessage();
                $('#textReply').val("");
            }
        }
    });
    $scope.formatMessageTime = function (time) {
        var milliseconds = Number(time);
        var myDate = new Date(milliseconds);
        return myDate.HHmmddMMyyyy();
    };
    $scope.detectScrollToTop = function () {
        $(function () {
            $('#messConversation').bind('scroll', function ()
            {
                if ($('#messConversation').scrollTop() === 0) {
                    console.log('Top');
                    $scope.loadingScroll = false;
                }

            });
        });
    };
    $scope.detectScrollToTop();
    $scope.loaded = true;
});
myApp.controller('PreviewPackageEditingController', function ($scope, $http, $timeout, service, $q, $window) {

    $scope.loaded = false;
    /* DEVELOPING BOX */
    $scope.toggleDevelopingBox = function () {
        $("#developingBox").toggleClass("active");
    };
    /* END DEVELOPING BOX */

    /* FIXED OPTIONS */
    function showFixedOptions() {
        console.log("vao day");
        var showPosition = $("#options").offset().top + $("#options").outerHeight(true);
        if (!$("#options-fixed").hasClass("active") && ($(window).scrollTop() + 65) >= showPosition) {
            $("#options-fixed").addClass("active");
            $("header").hide();
        }

        if ($("#options-fixed").hasClass("active") && ($(window).scrollTop() + 65) < showPosition) {
            $("#options-fixed").removeClass("active");
            $("header").show();
        }
    }

    $timeout(function () {
        showFixedOptions();
        $(window).bind('scroll', function () {
            showFixedOptions();
        });
    }, 100);
    /* END FIXED OPTIONS */

    $scope.fromSpecific = true;
    $scope.package = specificPackage;
    $scope.fbshare = function () {
        $window.open('https://www.facebook.com/sharer/sharer.php?u=' + $window.location.href, '_blank');
    };
    $scope.twshare = function () {
        $window.open('https://twitter.com/home?status=' + $window.location.href, '_blank');
    };
    $scope.loading = false;
    $scope.childrenDiscounts = $.parseJSON($scope.package.childrenDiscountJson);
    $scope.cancellationConditions = $.parseJSON($scope.package.cancellationPolicyJson);
    var listLanguageDescription = $scope.package.othersLanguageDescription;
    $scope.package.unavailableDays = JSON.parse($scope.package.unavailableDays);
    if ($scope.package.cancellationConditions !== undefined) {
        $scope.package.cancellationConditions = JSON.parse($scope.package.cancellationConditions);
    }
    for (var i = 0, max = listLanguageDescription.length; i < max; i++) {
        var singleLanguage = listLanguageDescription[i];
        if (singleLanguage.language !== undefined) {
            singleLanguage.language = JSON.parse(singleLanguage.language);
        }
        singleLanguage.description = JSON.parse(singleLanguage.description);
        singleLanguage.advancedAddress = JSON.parse(singleLanguage.advancedAddress);
    }

    //    LANGUAGE DESCRIPTION
    $scope.selectedLanguageDescription = listLanguageDescription[0];
    $scope.setSelectedLanguage = function (index) {
        $scope.selectedLanguageDescription = listLanguageDescription[index];
        updateMarkerArray();
    };
    //END LANGUAGE DESCRIPTION
    //
    // default amenities

    $scope.currentTime = new Date().getTime();
    $scope.childPrice = 0;
    $scope.adultPrice = 0;
    $scope.Math = window.Math;
    $scope.ReportType = reportType;
//    $scope.numberOfAdults = 0;
//    $scope.numberOfChilds = 0;

    $scope.promotion = false;
    $scope.currentTime = new Date().getTime();
    $scope.package.rate = Math.round($scope.package.rate);
    if ($scope.package.reviews.length > 0) {
        $scope.totalReviews = $scope.package.reviews[0].totalRecords;
    } else {
        $scope.totalReviews = 0;
    }
    $scope.userID = userID;
    $scope.emailAddress = 0;
    $scope.message = $('#message').text();
    $scope.sendEmail = function () {
        var formData = new FormData();
        formData.append("email", EmailList);
        formData.append("message", $('#message').val());
        formData.append("packageID", $scope.package.id);
        formData.append("senderName", senderName);
        $.ajax({
            url: SendEmailURL,
            type: "POST",
            dataType: 'text',
            contentType: false,
            processData: false,
            cache: false,
            data: formData,
            success: function (response) {
                $('#myModal').modal('hide');
            },
            error: function (response) {
            }
        });
    };
    $scope.movetoMap = function () {
        var p = $("#map").position();
        $('html, body').animate({
            scrollTop: p.top - 190
        }, 300);
    };
    /* BOOKING CALENDAR */
    $scope.day_of_week = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];
    $scope.MONTHS_OF_YEAR = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
    Date.prototype.ddMMyyyy = function () {
        var yyyy = this.getFullYear().toString();
        var mm = (this.getMonth() + 1).toString(); // getMonth() is zero-based
        var dd = this.getDate().toString();
        return (dd[1] ? dd : "0" + dd[0]) + "/" + (mm[1] ? mm : "0" + mm[0]) + "/" + yyyy; // padding
    };
    Date.prototype.MMddyyyy = function () {
        var yyyy = this.getFullYear().toString();
        var mm = (this.getMonth() + 1).toString(); // getMonth() is zero-based
        var dd = this.getDate().toString();
        return (mm[1] ? mm : "0" + mm[0]) + "/" + (dd[1] ? dd : "0" + dd[0]) + "/" + yyyy; // padding
    };
    Date.prototype.formatAMPM = function () {
        var hours = this.getHours();
        var minutes = this.getMinutes();
        var ampm = hours >= 12 ? 'PM' : 'AM';
        hours = hours % 12;
        hours = hours ? hours : 12; // the hour '0' should be '12'
        minutes = minutes < 10 ? '0' + minutes : minutes;
        var strTime = hours + ':' + minutes + ' ' + ampm;
        return strTime;
    };
    Date.prototype.formatHHmm = function () {
        // convert minutes to mm
        var minutes = this.getMinutes();
        if (minutes < 10) {
            minutes = "0" + minutes;
        }

        // convert hours to HH
        var hours = this.getHours();
        if (hours < 10) {
            hours = "0" + hours;
        }
        return hours + ":" + minutes;
    };
    var END_HOUR = 23;
    var END_MINUTES = 59;
    var START_HOURS = 0;
    var START_MINUES = 0;
    var MINUTES_PER_HOUR = 60;
    var FREE_INTERVAL = 15;
    var ALL_PACKAGES_ID = 0;
    var SMALLET_INTERVAL = 5;
    var NO_STEPS_MONTH = 1;
    var NO_STEPS_DAY = 2;
    var NO_DAYS_OF_WEEK = 7; // "constant" for number of days in a week
    var NO_WEEKS_OF_MONTH = 6;
    var bookedDate = new Date(toDate);
    $scope.calendarTime = new Date(toDate);
    toDate = new Date(toDate);
    // toggle Calendar
    $scope.toggleCalendar = function () {
        $("#bookingCalendar").toggleClass("active");
    };
    var operationCycles = $scope.package.operationCycles;
    function checkDateIsAvailable(date) {
        // check after to Date first
        if (date >= toDate) {
            // check operaton cycle
            for (var i = 0, max = operationCycles.length; i < max; i++) {
                var cycle = operationCycles[i];
                var startDate = new Date(cycle.startDate);
                var endDate = new Date(cycle.endDate);
                if (date >= startDate && (isNaN(endDate.getTime()) || date <= endDate)) {
                    return true;
                }
            }
        }
        return false;
    }
    var checkInsideNondays = function (day) {
        for (var k = 0, max = $scope.package.unavailableDays.length; k < max; k++) {
            if (day === $scope.package.unavailableDays[k]) {
                return true;
            }
        }
        return false;
    };
    var ONE_DAY_MLSECONDS = 24 * 60 * 60 * 1000;
//    $scope.package.startDate = $scope.package

//    $scope.package.startDate = new Date($scope.package.operationCycles[0].startDate);
    var checkNotInsideSequential = function (secondDate) {
        $scope.package.sequentialOperation = parseInt($scope.package.sequentialOperation);
        if ($scope.package.sequentialOperation !== 0) {
            //$scope.package.startDate
            var firstDate = new Date($scope.package.startDate);
//            var secondDate = new Date(day);
            if (!isNaN(firstDate.getTime())) {
                var diffDays = Math.round(Math.abs((firstDate.getTime() - secondDate.getTime()) / (ONE_DAY_MLSECONDS)));
                if (diffDays % $scope.package.sequentialOperation === 0) {
                    return false;
                }
                return true;
            }
        }
        return false;
    };
    function updateCalendar(calendarTime) {
        // return to first sunday of month
        var currentMonth = calendarTime.getMonth();
        var currentDate = new Date(calendarTime);
        currentDate.setDate(1);
        var distance = currentDate.getDay();
        if (distance === 0) {
            distance = 7;
        }
        currentDate.setDate(currentDate.getDate() - distance);
        // construct string html of month view
        var html = "";
        // loop 6 weeks
        var isAvailable;
        for (var i = 0; i < NO_WEEKS_OF_MONTH; i++) {
            html += "<ul class='clearfix'>";
            for (var j = 0; j < NO_DAYS_OF_WEEK; j++) { // loop 7 days
                isAvailable = false;
                if (checkDateIsAvailable(currentDate) && !checkNotInsideSequential(currentDate) && !checkInsideNondays(currentDate.getDay())) {
                    isAvailable = true;
                }
                html += "<li class='" + (isAvailable ? "availableBooking " : "") + (currentMonth === currentDate.getMonth() ? "inMonth" : "outMonth") + "'>"
                        + "<span dateValue='" + currentDate.MMddyyyy() + "'>"
                        + currentDate.getDate() + "</span></li>";
                currentDate.setDate(currentDate.getDate() + 1);
            }
            // plus week to month
            html += "</ul>";
        }
        return html;
    }

    $scope.backAvailableMonth = function () {
        $scope.calendarTime.setMonth($scope.calendarTime.getMonth() - 1);
        $("#bookingCalendar .calendarDate").html(updateCalendar($scope.calendarTime));
    };
    $scope.nextAvailableMonth = function () {
        $scope.calendarTime.setMonth($scope.calendarTime.getMonth() + 1);
        $("#bookingCalendar .calendarDate").html(updateCalendar($scope.calendarTime));
    };
//    $("#bookingCalendar .calendarDate").html(updateCalendar($scope.calendarTime));

    /* END BOOKING CALENDAR */

    $scope.reportYourOwn = function (currentID) {
        if (currentID !== $scope.package.providerID) {

            return true;
        } else {
            return false;
        }
    };
    $scope.parseInt = function (num) {
        if (isNaN(num)) {
            return 0;
        } else {
            return num;
        }
    };
//    $scope.initBookingCalendar();

    $scope.enableDates = function (day) {
        var d = day.getDay();
        if ($scope.package.unavailableDays.indexOf(d) !== -1) {
            return [false, ""];
        } else {
            return [true, ""];
        }
    };
    // Init Gallery
    var gallery = [];
    for (var i = 0; i < $scope.package.additionImages.length; i++) {
        var imageSrc = $scope.package.additionImages[i].image;
        var image = {
            "src": imageSrc,
            "thumb": imageSrc,
            "subHtml": '<h4>Image Name</h4><p>Image Description</p>'
        };
        gallery.push(image);
    }

    $scope.initGallery = function () {
        $("#gallery").lightGallery({
            dynamic: true,
            thumbnail: true,
            mode: 'lg-soft-zoom',
            dynamicEl: gallery
        });
    };
    // End Gallery

    /* PACKAGE MAP */
    $scope.selectedLocation = "";
    $scope.setSelectedLocation = function (locationType) {
        if (locationType !== $scope.selectedLocation) {
            $scope.selectedLocation = locationType;
            updateMarkerArray();
        }
    };
    var map;
    var initFinalMap = function () {
        map = new google.maps.Map(document.getElementById('map'), {
            center: new google.maps.LatLng(13.7649273, 100.5360824),
            zoom: 17,
            draggable: true,
            scrollwheel: false
        });
        updateMarkerArray();
    };
    var fillInforWindow = function (place, infowindow, map, marker) {
        infowindow.setContent('<div>' + place + '</div>');
        infowindow.open(map, marker);
    };
    var markers = [], windows = [], packagePath, departurePath, pickupPath, bounds;
    function updateMarkerArray() { // update marker arrays and change map view
        // first delete old markers
        if (markers.length > 0) {
            for (var i = 0, max = markers.length; i < max; i++) {
                markers[i].setMap(null);
                windows[i].close();
            }
            markers = [];
            windows = [];
            angular.isObject(packagePath) ? packagePath.setMap(null) : 0;
            angular.isObject(departurePath) ? departurePath.setMap(null) : 0;
            angular.isObject(pickupPath) ? pickupPath.setMap(null) : 0;
        }

        // init marker array
        if ($scope.selectedLocation === "" || $scope.selectedLocation === "action") {
            var actionLocations = $scope.selectedLanguageDescription.advancedAddress.action;
            var actionLength = actionLocations.length;
            if (actionLength > 0) { // if have addtional markers

                var path = [];
                for (var i = 0; i < actionLength; i++) { // loop addtional markers
                    var actionLocation = actionLocations[i];
                    if (angular.isObject(actionLocation)) {

                        // create new marker
                        var lat = actionLocation.lat;
                        var lng = actionLocation.lng;
                        if (lat !== "" && lng !== "") {
                            var latlng = new google.maps.LatLng(lat, lng);
                            var markerObj = new google.maps.Marker({
                                map: map,
                                position: latlng
                            });
                            markerObj.setIcon('http://youtripper.com/Images/Icon/packageLocation.svg');
                            markers.push(markerObj);
                            // create new window
                            var window = new google.maps.InfoWindow({
                                maxWidth: 200
                            });
                            windows.push(window);
                            fillInforWindow("<strong>Package location " + (i + 1) + ": </strong>" + actionLocation.addr,
                                    window, map, markerObj);
                            // add new point to path
                            path.push(latlng);
                        }
                    }
                }

                // draw line betweens package
                packagePath = new google.maps.Polyline({
                    path: path,
                    geodesic: true,
                    strokeColor: '#68BFAC',
                    strokeOpacity: 1.0,
                    strokeWeight: 2
                });
                packagePath.setMap(map);
            }
        }

        if ($scope.selectedLocation === "" || $scope.selectedLocation === "pickup") {
            var pickupLocations = $scope.selectedLanguageDescription.advancedAddress.pickup;
            var pickupLength = pickupLocations.length;
            if (pickupLength > 0) { // if have addtional markers
                var path = [];
                for (var i = 0; i < pickupLength; i++) { // loop addtional marrkers
                    var pickupLocation = pickupLocations[i];
                    if (angular.isObject(pickupLocation)) {

                        // crate new marker
                        var lat = pickupLocation.lat;
                        var lng = pickupLocation.lng;
                        if (lat !== "" && lng !== "") {
                            var latlng = new google.maps.LatLng(lat, lng);
                            var markerObj = new google.maps.Marker({
                                map: map,
                                position: latlng
                            });
                            markerObj.setIcon('http://youtripper.com/Images/Icon/pickupLocation.svg');
                            markers.push(markerObj);
                            // create new window
                            var window = new google.maps.InfoWindow({
                                maxWidth: 200
                            });
                            windows.push(window);
                            fillInforWindow("<strong>Pickup location " + (i + 1) + ": </strong>" + pickupLocation.addr,
                                    window, map, markerObj);
                            // add new point to path
                            path.push(latlng);
                        }
                    }
                }
                // draw line betweens package
                pickupPath = new google.maps.Polyline({
                    path: path,
                    geodesic: true,
                    strokeColor: '#FBB03B',
                    strokeOpacity: 1.0,
                    strokeWeight: 2
                });
                pickupPath.setMap(map);
            }
        }

        if ($scope.selectedLocation === "" || $scope.selectedLocation === "departure") {
            var departureLocations = $scope.selectedLanguageDescription.advancedAddress.departure;
            var departureLength = departureLocations.length;
            if (departureLength > 0) { // if have addtional markers
                var path = [];
                for (var i = 0; i < departureLength; i++) { // loop addtional marrkers
                    var departureLocation = departureLocations[i];
                    if (angular.isObject(departureLocation)) {

                        // crate new marker
                        var lat = departureLocation.lat;
                        var lng = departureLocation.lng;
                        if (lat !== "" && lng !== "") {
                            var latlng = new google.maps.LatLng(lat, lng);
                            var markerObj = new google.maps.Marker({
                                map: map,
                                position: latlng
                            });
                            markerObj.setIcon('http://youtripper.com/Images/Icon/departLocation.svg');
                            markers.push(markerObj);
                            // create new window
                            var window = new google.maps.InfoWindow({
                                maxWidth: 200
                            });
                            windows.push(window);
                            fillInforWindow("<strong>Departure location " + (i + 1) + ": </strong>" + departureLocation.addr,
                                    window, map, markerObj);
                            // add new point to path
                            path.push(latlng);
                        }
                    }
                }

                // draw line betweens package
                departurePath = new google.maps.Polyline({
                    path: path,
                    geodesic: true,
                    strokeColor: '#FF514E',
                    strokeOpacity: 1.0,
                    strokeWeight: 2
                });
                departurePath.setMap(map);
            }
        }

        // modify map view to see all markers
        bounds = new google.maps.LatLngBounds();
        for (var i = 0; i < markers.length; i++) {
            bounds.extend(markers[i].getPosition());
        }

        if (markers.length > 0) {
            map.fitBounds(bounds);
        }

    }

    initFinalMap();
    $scope.showError = false;
    $scope.error = {numberOfPeople: false};
    $scope.showChatBox = function () {
        if (userRole === 1) {
            $('#chatBoxContainer').css('display', '');
        } else {
            alert("This function is only for user!");
        }
    };
    $('#closeChatButton').click(function () {
        $('#chatBoxContainer').css('display', 'none');
    });
    $scope.blankMessage = '';
    $scope.sendMessageViaChatbox = function () {
        if ($('#textMessage').val() !== '') {
            $scope.package.id;
            $scope.userID;
            $scope.responseMessage;
            var data = {"packageID": $scope.package.id, "tripperID": $scope.userID, "providerID": $scope.package.providerID, "message": $('#textMessage').val()};
            var url = service.getContextPath() + "/Tripper/SendMessageViaChatbox";
            $http.post(url, data)
                    .then(function successCallback(response) {
                        if (response.data === "error") {
                            var pageError = service.getContextPath() + service.getErrorPageUrl();
                            $(location).attr('href', pageError);
                        } else {


                        }
                    });
            $('#textMessage').val('');
            $scope.blankMessage = 'Your message sent successfully';
        } else {
            $scope.blankMessage = 'Say something !';
        }
    };
    $('#textMessage').keypress(function (e) {
        var key = e.which;
        if (key === 13)  // the enter key code
        {
            $scope.sendMessageViaChatbox();
            return false;
        }
    });
    var url = service.getContextPath() + "/Common/updateSystemKeyWord";
    $scope.updateKeyword = function () {
        var data = {"packageID": $scope.package.id};
        $http.post(url, data)
                .then(function successCallback(response) {
                    if (response.data === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                    }
                });
    };
    $scope.reason = "";
    $scope.DisableValue = true;
    $scope.CheckOther = function () {
        $scope.DisableValue = false;
        $scope.reason = "Other Reason";
    };
    $scope.CheckReason = function (reason) {
        $scope.reason = reason;
        $scope.DisableValue = true;
    };
    $scope.validateReportForm = function (event) {
        if ($scope.reason === "") {
            $scope.errorFlag = true;
            event.preventDefault();
        } else {
            return true;
        }
    };
    $scope.updateKeyword();
    /* BOOKING TIME */

    // function for constructing list of operation times
    $scope.listFreeTimes = [];
    function constructListTimes(package) {
        var startOperationTime;
        var endOperationTime;
        var duration;
        var freeInterval;
        var durationType = package.durationType;
        if (durationType !== "days") {
            var startTime = package.startOperationTime;
            var endTime = package.endOperationTime;
            var isFreeBooking = package.isFreeBooking;
            var newDate = new Date();
            if (isFreeBooking) { // if the package is free to book
                freeInterval = package.freeInterval;
                startOperationTime = new Date(newDate.MMddyyyy() + " " + startTime);
                endOperationTime = new Date(newDate.MMddyyyy() + " " + endTime);
                duration = package.duration;
                durationType === "hours" ? duration *= MINUTES_PER_HOUR : 0;
            } else {
                if (durationType !== "days") {
                    var fixedHour = package.fixedHour;
                    var fixedMinute = package.fixedMinute;
                    freeInterval = fixedHour * 60 + fixedMinute;
                    startOperationTime = new Date(bookedDate.MMddyyyy() + " " + startTime);
                    endOperationTime = new Date(bookedDate.MMddyyyy() + " " + endTime);
                    duration = package.duration;
                    durationType === "hours" ? duration *= MINUTES_PER_HOUR : 0;
                }
            }

            // loop from start to end to construct list times
            $scope.listFreeTimes = [];
            var ending = new Date(endOperationTime);
            ending.setMinutes(ending.getMinutes() - duration);
            do {
                $scope.listFreeTimes.push(startOperationTime.formatHHmm());
                startOperationTime.setMinutes(startOperationTime.getMinutes() + freeInterval);
            } while (startOperationTime <= ending);
        }
    }
    constructListTimes($scope.package);
//    $scope.childPromotions = JSON.parse($scope.package.advancedChildPrice);

    // load availablity of the selected date
    var DATE_AVAILABILITY_URL = service.getContextPath() + "/Common/IsDateAvailable";
    var TIME_AVAILABILITY_URL = service.getContextPath() + "/Common/IsTimeAvailable";
    var JOINT_BOOKED_URL = service.getContextPath() + "/Common/IsJointBooked";
    var pending = false;
    var deferred = $q.defer();
    var promise;
    $scope.isAvailable = false;
    $scope.isCheckAvailability = false;
    var isJointBooked = false;
    function loadAvailability(selectedDate, selectedTime) {
        $timeout.cancel(promise);
        promise = $timeout(function () {
            if (pending) {
                deferred.resolve();
                deferred = $q.defer();
            }
            var packageID = $scope.package.id;
            var url, data;
            var packageType = $scope.package.packageType;
            if (packageType !== "Joint") {
                // if type is day just check availability of date
                var durationType = $scope.package.durationType;
                if (durationType !== "days") {
                    url = TIME_AVAILABILITY_URL;
                    data = {"packageID": packageID, "tripDate": selectedDate, "tripTime": selectedTime};
                } else {
                    url = DATE_AVAILABILITY_URL;
                    data = {"packageID": packageID, "tripDate": selectedDate};
                }
            } else {
                url = JOINT_BOOKED_URL;
                data = {"packageID": packageID, "tripDate": selectedDate, "tripTime": selectedTime};
            }
            $http.post(url, data, {timeout: deferred.promise})
                    .then(function successCallback(response) {
                        $scope.isCheckAvailability = true;
                        if (response.data.result === "error") {
                            var pageError = service.getContextPath() + service.getErrorPageUrl();
                            $(location).attr('href', pageError);
                        } else if (response.data.result !== true) { // if slot is available
                            if (packageType !== "Joint") {
                                $scope.isAvailable = false;
                            } else {
                                isJointBooked = true;
                                $scope.isAvailable = true;
                            }
                        } else {
                            if (packageType !== "Joint") {
                                $scope.isAvailable = true;
                            } else {
                                isJointBooked = false;
                                $scope.isAvailable = true;
                            }
                        }
                        pending = false;
                        deferred = $q.defer();
                    });
        }, 100);
    }

    // check input no people
    $scope.noChilds = [];
    var minTripper = $scope.package.minTripper;
    var maxTripper = $scope.package.maxTripper;
    $scope.checkInputPeople = function () {
        var noAdults = $scope.numberOfAdults;
        var totalPeople = 0;
        if (!angular.isNumber(noAdults)) {
            $("#adultsError").addClass("active");
            return false;
        } else {
            totalPeople += noAdults;
        }

        for (var i = 0, max = $scope.noChilds.length; i < max; i++) {
            var noChildElement = $scope.noChilds[i];
            // if no input then plus 0
            if (angular.isNumber(noChildElement)) {
                totalPeople += noChildElement;
            }
        }

        if (maxTripper > 0) { // check max
            $("#adultsError").removeClass("active");
            if (totalPeople > maxTripper) {
                $("#maximumError").addClass("active");
                return false;
            } else {
                $("#maximumError").removeClass("active");
            }
        }
        if (!isJointBooked) {
            if (totalPeople < minTripper) { // check Min
                $("#miniMumError").addClass("active");
                return false;
            } else {
                $("#miniMumError").removeClass("active");
            }
        }
        return true;
    };
    $scope.selectedTimeChange = function () {
        if (angular.isString($scope.selectedDate) && $scope.selectedDate !== "") {
            loadAvailability($scope.selectedDate, $scope.selectedTime);
        }
    };
    $scope.bookingErrorMsg = false;
    $scope.validateBookForm = function (event) {
        if (!$scope.checkInputPeople() || !$scope.isAvailable || !$scope.isCheckAvailability) {
            $scope.bookingErrorMsg = true;
            event.preventDefault();
        }
    };
    // calculate No Packages From no adults and no childs
    /*
     $scope.totalPrice = 0;
     $scope.noChilds = [];
     
     $scope.calculateNoPackages = function () {
     var packageType = $scope.package.packageType;
     var packagePrice = $scope.package.ordinaryPriceForAdult;
     var noAdults = $scope.numberOfAdults;
     !angular.isNumber(noAdults) ? noAdults = 0 : 0;
     
     // check selectedate has promotion or not
     var selectedDate = $scope.selectedDate;
     var dateDiscount = 0;
     if (angular.isString(selectedDate) && selectedDate !== "") {
     var dates = $scope.package.promotionJson;
     for (var i = 0, max = dates.length; i < max; i++) {
     var dateRange = dates[i].dateRange;
     if (!!dateRange[selectedDate]) {
     dateDiscount = dates[i].percent;
     break;
     }
     }
     }
     
     
     if (packageType !== "Joint") {
     var discountPercent = 0;
     var totalPeople = 0;
     // plus no adults
     angular.isNumber($scope.numberOfAdults) ? totalPeople += $scope.numberOfAdults : 0;
     
     for (var i = 0, max = $scope.noChilds.length; i < max; i++) {
     var noChildElement = $scope.noChilds[i];
     var percent = $scope.childPromotions[i].percent;
     // if no input then plus 0
     if (angular.isNumber(noChildElement)) {
     totalPeople += noChildElement;
     discountPercent += percent * noChildElement;
     }
     }
     
     // show error if noPeople is over max
     if (totalPeople > $scope.package.maxTripper) {
     $("#maximumError").addClass("active");
     $scope.totalPrice = 0;
     } else {
     $("#maximumError").removeClass("active");
     if (totalPeople <= 0) {
     $scope.totalPrice = 0;
     } else {
     $scope.totalPrice = packagePrice * (100 - discountPercent - dateDiscount) / 100;
     }
     }
     } else {
     var childPrice = 0;
     for (var i = 0, max = $scope.noChilds.length; i < max; i++) {
     var noChildElement = $scope.noChilds[i];
     var percent = $scope.childPromotions[i].percent;
     // if no input then plus 0
     if (angular.isNumber(noChildElement)) {
     childPrice += (noChildElement * packagePrice) * (100 - percent) / 100;
     }
     }
     $scope.totalPrice = (noAdults * packagePrice + childPrice) * (100 - dateDiscount) / 100;
     }
     
     
     };
     */


    $scope.selectedAmenities = $scope.package.amenitiesClassifiers[0];
    $scope.setSelectedAmenities = function (amenities) {
        $scope.selectedAmenities = amenities;
    };
    /*Validate Package Information To Show Submit Review Button*/
    $scope.validPackage = false;
    $scope.showMissingData = 0;
    var languageDescriptionList = $scope.package.languageDescriptionList;
    //Check Category
    if ($scope.package.activityName !== "" && angular.isDefined($scope.package.activityName) && $scope.package.colorID > 0 && $scope.package.suitabilities.length > 0 && $scope.package.targetCountryID > 0) {
        $scope.showMissingData = $scope.showMissingData + 1;
    }
    ;
    //Check Description
    var checkDescriptionFlag = false;
    angular.forEach(languageDescriptionList, function (languageDescription) {
        if (angular.isUndefined(languageDescription.packageName) || languageDescription.packageName === '' ||
                angular.isUndefined(languageDescription.googleDescription) || languageDescription.googleDescription === '' ||
                languageDescription.description[0].description === '' || languageDescription.description[0].header === '' ||
                languageDescription.advancedAddress.action.length === 0 || languageDescription.advancedAddress.action[0].content === "") {
            checkDescriptionFlag = true;
        }

    });
    if (!checkDescriptionFlag) {
        $scope.showMissingData = $scope.showMissingData + 1;
    }

    //Check Package Cover Image
    if (angular.isString($scope.package.coverImage) && $scope.package.coverImage !== "") {
        $scope.showMissingData = $scope.showMissingData + 1;
    }

    //Check Booking
    if (($scope.package.maxTripper > 0 || ($scope.package.packageType === 'Open' && $scope.package.minTripper > 0)) && ($scope.package.durationDay > 0 ||
            $scope.package.durationMonth > 0 || $scope.package.durationYear > 0 || $scope.package.durationHour > 0 || $scope.package.durationMinute > 0) &&
            (($scope.package.durationDay === 0 && $scope.package.servingPeriodID > 0) || $scope.package.durationDay > 0 || $scope.package.durationMonth > 0 || $scope.package.durationYear > 0)
            && ($scope.package.isFreeBooking || (!$scope.package.isFreeBooking && ($scope.package.fixedHour !== null || $scope.package.fixedMinute !== null)))
            && (!$scope.package.isUsingMaxQuota || ($scope.package.isUsingMaxQuota && $scope.package.maxQuota > 0))
            ) {
        $scope.showMissingData = $scope.showMissingData + 1;
    }

    //Checking Price
    var childrenMissingData = true;
    var cancellationMissingData = true;
    $scope.package.childrenDiscountJson = JSON.parse($scope.package.childrenDiscountJson);
    $scope.package.cancellationPolicyJson = JSON.parse($scope.package.cancellationPolicyJson);
    for (var i = 0; i < $scope.package.childrenDiscountJson.length; i++) {
        if ($scope.package.childrenDiscountJson[i].condition === '' || $scope.package.childrenDiscountJson[i].condition === null) {
            childrenMissingData = false;
        }
    }
    for (var i = 0; i < $scope.package.cancellationPolicyJson.length; i++) {
        if ($scope.package.cancellationPolicyJson[i].duration === '' || $scope.package.cancellationPolicyJson[i].duration === null) {
            cancellationMissingData = false;
        }
    }
//    if ($scope.package.ordinaryPriceForAdult !== '' && $scope.package.ordinaryPriceForAdult !== 0 && childrenMissingData && cancellationMissingData) {
//        $scope.showMissingData = $scope.showMissingData + 1;
//    }
    if (childrenMissingData && cancellationMissingData) {
        $scope.showMissingData = $scope.showMissingData + 1;
    }

    //Check package isEditing
    if ($scope.package.isEditing === true) {
        $scope.showMissingData = $scope.showMissingData + 1;
    }

    //Set valid Package Flag
    if ($scope.showMissingData === 6) {
        $scope.validPackage = true;
    }
    $scope.loaded = true;
});
myApp.controller('TrippDashController', function ($scope, $http, $q, service) {
    $scope.loaded = false;
    $scope.tripDash = tripDash;
    $scope.selectedTotal = 'booking';
    $scope.selectResourceOrQuota = 'resource';
    $scope.todayInMillisecond = dateInMillisecond;
    $scope.lastDateOfHighestPackage = dateInMillisecond - 2592000000;
    $scope.lastDateOfLowestPackage = dateInMillisecond - 2592000000;
    $scope.highestPackageType = 'grossing';
    $scope.lowestPackageType = 'converting';
    $scope.freeResource = 0;
    $scope.remainQuotas = 0;
    $scope.freeResourceOrRemainQuota = 'resource';
    $scope.todayBookingOrUpcoming = 'today';
    $scope.freeResource = $scope.tripDash.maxDataResource - $scope.tripDash.totalBookingInTripDash.noBookedResources;
    $scope.calculateResourceandQuota = function () {
        var totalQuotas = 0;
        $scope.freeResource = 0;
        $scope.remainQuotas = 0;
        angular.forEach($scope.tripDash.bookingDetailInTripDash, function (child) {
            if (child.durationDay === 0) {
                var tempStartTime = "2016/01/01 " + child.startOperationTime;
                var tempEndTime = "2016/01/01 " + child.endOperationTime;
                var d1 = new Date(tempEndTime);
                var d2 = new Date(tempStartTime);
                var totalOperationTimeInMilli = Math.abs(d1 - d2);
                var maxQuotaInMill = (child.durationMinute * 60000) + (child.durationHour * 60 * 60000);
                totalQuotas = totalQuotas + (Math.floor(totalOperationTimeInMilli / maxQuotaInMill) * child.maxQuota);
            } else {
                totalQuotas = totalQuotas + child.maxQuota;
            }
        });
        $scope.remainQuotas = totalQuotas - $scope.tripDash.totalBookingInTripDash.noFilledQuotas;
        $scope.freeResource = $scope.tripDash.maxDataResource - $scope.tripDash.totalBookingInTripDash.noBookedResources;
    };
    $scope.calculateResourceandQuota();
    $scope.selectBookingType = function () {
        $('#bookingDropdown').toggleClass('active');
    };
    $scope.resourceSelectType = function () {
        $('#resourceSelect').toggleClass('active');
    };
    $scope.freeResourceSelectType = function () {
        $('#freeResourceSelect').toggleClass('active');
    };
    $scope.todayBookingSelectType = function () {
        $('#todayBookingSelect').toggleClass('active');
    };
    $scope.highestPackageSelectType = function () {
        $('#highestPackageSelect').toggleClass('active');
    };
    $scope.highestPackageDateSelectType = function () {
        $('#highestPackageDateSelect').toggleClass('active');
    };
    $scope.lowestPackageTypeSelect = function () {
        $('#lowestPackageSelect').toggleClass('active');
    };
    $scope.lowestPackageDateSelectType = function () {
        $('#lowestPackageDateSelect').toggleClass('active');
    };
    $scope.selectPackageType = function () {
        $('#packageTypeSelect').toggleClass('active');
    };
    $scope.selectStatisticType = function () {
        $('#statisticTypeSelect').toggleClass('active');
    };
    $scope.selectStatisticDate = function () {
        $('#statisticDateSelect').toggleClass('active');
    };

    /*Top Booking*/
    //Initial Calendar
    var today = new Date(todayServer);
    var weekday = new Array(7);
    weekday[0] = "Sunday";
    weekday[1] = "Monday";
    weekday[2] = "Tuesday";
    weekday[3] = "Wednesday";
    weekday[4] = "Thursday";
    weekday[5] = "Friday";
    weekday[6] = "Saturday";
    var month = new Array();
    month[0] = "JAN";
    month[1] = "FEB";
    month[2] = "MAR";
    month[3] = "APR";
    month[4] = "MAY";
    month[5] = "JUN";
    month[6] = "JUL";
    month[7] = "AUG";
    month[8] = "SEP";
    month[9] = "OCT";
    month[10] = "NOV";
    month[11] = "DEC";
    $scope.getDay = function () {
        return weekday[today.getDay()];
    };
    $scope.getDate = function () {
        return today.getDate();
    };
    $scope.getMonth = function () {
        return month[today.getMonth()];
    };
    $scope.nextDay = function () {
        today.setDate(today.getDate() + 1);
        dateInMillisecond = Number(dateInMillisecond) + 86400000;
        $scope.loadBookingWithDate(dateInMillisecond);
    };
    $scope.previousDay = function () {
        today.setDate(today.getDate() - 1);
        dateInMillisecond = Number(dateInMillisecond) - 86400000;
        $scope.loadBookingWithDate(dateInMillisecond);
    };
    //Load new Booking Detail with Date
    $scope.loadBookingWithDate = function (dateTime) {
        $scope.loadingResouceWithDate = true;
        var data = {"providerID": providerID, "dateTime": dateTime};
        var url = service.getContextPath() + "/Provider/LoadTopLeftBooking";
        $http.post(url, data)
                .then(function successCallback(response) {
                    if (response.data === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        $scope.loadingResouceWithDate = false;
                        var newResult = response.data;
                        $scope.tripDash.bookingDetailInTripDash = newResult.bookingDetailInTripDash;
                        $scope.tripDash.totalBookingInTripDash = newResult.totalBookingInTripDash;
                        $scope.tripDash.maxDataResource = newResult.maxDataResource;
                        $scope.freeResource = $scope.tripDash.maxDataResource - $scope.tripDash.totalBookingInTripDash.noBookedResources;
                        $scope.calculateResourceandQuota();
                    }
                });
    };
    $scope.showHighestPackageType = function () {
        if ($scope.highestPackageType === 'grossing') {
            return "Highest Grossing Package";
        } else if ($scope.highestPackageType === 'selling') {
            return "Highest Selling Package";
        } else if ($scope.highestPackageType === 'converting') {
            return "Highest Converting Package/per View";
        }
    };
    $scope.showLowestPackageType = function () {
        if ($scope.lowestPackageType === 'grossing') {
            return "Lowest Grossing Package";
        } else if ($scope.lowestPackageType === 'selling') {
            return "Lowest Selling Package";
        } else if ($scope.lowestPackageType === 'converting') {
            return "Lowest Converting Package/per View";
        }
    };
    //Reload highest Package
    $scope.loadHighestPackage = function () {
        $scope.loadingHighestPack = true;
        var data = {"providerID": providerID, "dateTime": $scope.todayInMillisecond, "lastDate": $scope.lastDateOfHighestPackage, "highestPackageType": $scope.highestPackageType};
        var url = service.getContextPath() + "/Provider/LoadHighestPackage";
        $http.post(url, data)
                .then(function successCallback(response) {
                    if (response.data === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        $scope.loadingHighestPack = false;
                        var newResult = response.data;
                        console.log(newResult);
                        $scope.tripDash.bookingDetailInTripDash.highestPackageInTripDash = newResult;
                    }
                });
    };
    //Watch Highest Package Type
    $scope.$watch('highestPackageType', function (newVal, oldVal) {
        if (newVal !== oldVal) {
            $scope.loadHighestPackage();
        }
    }, true);
    //Watch Last Date of Highest Package
    $scope.$watch('lastDateOfHighestPackage', function (newVal, oldVal) {
        if (newVal !== oldVal) {
            $scope.loadHighestPackage();
        }
    });
    //Reload Lowest Package
    $scope.loadLowestPackage = function () {
        $scope.loadingLowestPack = true;
        var data = {"providerID": providerID, "dateTime": $scope.todayInMillisecond, "lastDate": $scope.lastDateOfLowestPackage, "lowestPackageType": $scope.lowestPackageType};
        var url = service.getContextPath() + "/Provider/LoadLowestPackage";
        $http.post(url, data)
                .then(function successCallback(response) {
                    if (response.data === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {
                        $scope.loadingLowestPack = false;
                        var newResult = response.data;
                        $scope.tripDash.bookingDetailInTripDash.lowestPackageInTripDash = newResult;
                    }
                });
    };
    //Watch Highest Package Type
    $scope.$watch('lowestPackageType', function (newVal, oldVal) {
        if (newVal !== oldVal) {
            $scope.loadLowestPackage();
        }
    }, true);
    //Watch Last Date of Highest Package
    $scope.$watch('lastDateOfLowestPackage', function (newVal, oldVal) {
        if (newVal !== oldVal) {
            $scope.loadLowestPackage();
        }
    });

    /*Today's Booking & Upcoming Booking*/
    $scope.showBookingData = function () {
        var result = [];
        if ($scope.todayBookingOrUpcoming === 'today') {
            angular.forEach($scope.tripDash.listBookingInTripDash, function (child) {
                if (Number($scope.todayInMillisecond) === child.selectedDateMilliseconds) {
                    result.push(child);
                }
            });
        } else {
            angular.forEach($scope.tripDash.listBookingInTripDash, function (child) {
                if (Number($scope.todayInMillisecond) < child.selectedDateMilliseconds) {
                    result.push(child);
                }
            });
        }
        return result;
    };

    /*Init variable in Statistic*/
    $scope.selectedPackageIDInStat = -1;
    $scope.selectedPackageNameInStat = "All packages";
    $scope.revenueOrBookingInStat = 'revenue';
    $scope.lastDateInStat = $scope.todayInMillisecond - 2592000000;

    // init calendar
    Date.prototype.MMddyyyy = function () {
        var yyyy = this.getFullYear().toString();
        var mm = (this.getMonth() + 1).toString(); // getMonth() is zero-based
        var dd = this.getDate().toString();
        return  (mm[1] ? mm : "0" + mm[0]) + "/" + (dd[1] ? dd : "0" + dd[0]) + "/" + yyyy; // padding
    };
    Date.prototype.ddMM = function () {
        var yyyy = this.getFullYear().toString();
        var mm = (this.getMonth() + 1).toString(); // getMonth() is zero-based
        var dd = this.getDate().toString();
        return (dd[1] ? dd : "0" + dd[0]) + "." + (mm[1] ? mm : "0" + mm[0]); // padding
    };

    var revenueList = [];
    if (angular.isArray($scope.tripDash.revenueStatisticsInTrippDash)) {
        revenueList = $scope.tripDash.revenueStatisticsInTrippDash;
    } else {
        revenueList.push($scope.tripDash.revenueStatisticsInTrippDash);
    }
    var bookingsList = [];


    $scope.$watch('selectedPackageIDInStat', function (newVal, oldVal) {
        if (newVal !== oldVal) {
            $scope.reloadStatistics();
        }
    });

    $scope.$watch('revenueOrBookingInStat', function (newVal, oldVal) {
        if (newVal !== oldVal) {
            $scope.reloadStatistics();
        }
    });

    $scope.$watch('lastDateInStat', function (newVal, oldVal) {
        if (newVal !== oldVal) {
            $scope.reloadStatistics();
        }
    });

    //Reload Statistics
    $scope.reloadStatistics = function () {
        $scope.loadedStaticstic = true;
        var data = {"packageID": $scope.selectedPackageIDInStat, "date": $scope.todayInMillisecond, "statisticsType": $scope.revenueOrBookingInStat, "lastDate": $scope.lastDateInStat};
        var url = service.getContextPath() + "/Provider/LoadStatisticsInTripDash";
        $http.post(url, data)
                .then(function successCallback(response) {
                    if (response.data === "error") {
                        var pageError = service.getContextPath() + service.getErrorPageUrl();
                        $(location).attr('href', pageError);
                    } else {

                        var newResult = response.data;
                        console.log(newResult);
                        if ($scope.revenueOrBookingInStat === 'revenue') {

                            if (angular.isArray(newResult)) {
                                revenueList = newResult;
                            } else {
                                revenueList.push(newResult);
                            }
                            var days = ($scope.todayInMillisecond - $scope.lastDateInStat) / 86400000;
                            var canvas = document.querySelector('#booking-line-chart');
                            var graph = $('#booking-line-chart');
                            var context = graph[0].getContext('2d');
                            context.clearRect(0, 0, canvas.width, canvas.height);
                            drawRevenueStatistics(days);
                        } else {
                            if (angular.isArray(newResult)) {
                                bookingsList = newResult;
                            } else {
                                bookingsList.push(newResult);
                            }
                            var days = ($scope.todayInMillisecond - $scope.lastDateInStat) / 86400000;
                            var canvas = document.querySelector('#booking-line-chart');
                            var graph = $('#booking-line-chart');
                            var context = graph[0].getContext('2d');
                            context.clearRect(0, 0, canvas.width, canvas.height);
                            drawBookingStatistics(days);
                        }
                        $scope.loadedStaticstic = false;
                    }
                });
    };

    $scope.changePackageInStatistics = function (packageID, name) {
        $scope.selectedPackageIDInStat = packageID;
        $scope.selectedPackageNameInStat = name;
    };

    function getMaxRevenue(revenueList) {
        var maxRevenue = 0;
        // get Max
        var max = revenueList.length;
        for (var i = 0; i < max; i++) {
            var currentRevenue = revenueList[i].revenue;
            if (maxRevenue < currentRevenue) {
                maxRevenue = currentRevenue;
            }
        }
        return maxRevenue;
    }

    function getMaxNoBookings(bookingsList) {
        var maxBooking = 0;
        // get Max
        var max = bookingsList.length;
        for (var i = 0; i < max; i++) {
            var currentNumber = bookingsList[i].noBookings;
            if (maxBooking < currentNumber) {
                maxBooking = currentNumber;
            }
        }
        return maxBooking;
    }

    var toDate = new Date(todayServer);
    function getStartDateInStatistics(noDays) {
        var startDate = new Date(toDate);
        startDate.setDate(startDate.getDate() - noDays);
        return startDate;
    }

    var NO_DATES_LINE = 15;
    var NO_REVENUE_LINE = 10;
    var GAP_FOR_DATE_TEXT = 25;
    var GAP_FOR_REVENUE_TEXT = 50;
    var LEFT_PADDING = 20;
    var TOP_PADDING = 5;
    function drawRevenueStatistics(noDays) {
        // get Gap and Start Date
        var noGapDays, noDateLine;
        if (noDays < NO_DATES_LINE) {
            noGapDays = 1;
            noDateLine = noDays;
        } else {
            noGapDays = Math.floor(noDays / NO_DATES_LINE);
            noDateLine = NO_DATES_LINE;
        }
        var distanceFromStartDate = noGapDays * (noDateLine - 1);
        var startDate = getStartDateInStatistics(distanceFromStartDate);
        // get Gap And Max Revenue
        var maxRevenue = getMaxRevenue(revenueList);
        if (maxRevenue % 100 !== 0) {
            // adjust max Revenue
            var tempMax = 0;
            while (tempMax < maxRevenue) {
                tempMax += 100;
            }
            maxRevenue = tempMax;
        }

        // draw
        var canvas = document.querySelector('#booking-line-chart');
        // Make it visually fill the positioned parent
        canvas.style.width = '100%';
        canvas.style.height = '100%';
        // ...then set the internal size to match
        canvas.width = canvas.offsetWidth;
        canvas.height = canvas.offsetHeight;
        var graph = $('#booking-line-chart');
        var context = graph[0].getContext('2d');

//        context.lineWidth  = 2;
//        context.fillStyle = "#FFFFFF";
        // calculate height and width of chart
        var startLeftPoint = GAP_FOR_REVENUE_TEXT;
        var endLeftPoint = graph.width() - LEFT_PADDING;
        var startTopPoint = TOP_PADDING;
        var endTopPoint = graph.height() - GAP_FOR_DATE_TEXT;
        var chartWidth = endLeftPoint - startLeftPoint;
        var charHeight = endTopPoint - startTopPoint;
        var gapRevenue = maxRevenue / NO_REVENUE_LINE;
        var revenuePadding = charHeight / NO_REVENUE_LINE;
        var datePadding = chartWidth / noDateLine;
        context.beginPath();
        // draw chart rectangle first
        context.rect(startLeftPoint + 0.5, startTopPoint + 0.5, chartWidth, charHeight);
        context.strokeStyle = '#DAE1E8';
        context.stroke();
        context.fillStyle = "#FFFFFF";
        context.fill();
        // drawn horizontal line for revenue first
        context.beginPath();
        context.textAlign = "right";
        context.textBaseline = "middle";
        context.strokeStyle = '#DAE1E8';
        for (var i = 0; i <= NO_REVENUE_LINE; i++) {
            context.beginPath();
            // drawn text first
            var positionY = (NO_REVENUE_LINE - i) * revenuePadding + startTopPoint;
            context.fillText(i * gapRevenue, startLeftPoint - 5, positionY);
            if (i > 0 && i < NO_REVENUE_LINE) {
                context.beginPath();
                // then drawn line
                context.moveTo(startLeftPoint, positionY + 0.5);
                context.lineTo(endLeftPoint, positionY + 0.5);
                context.stroke();
            }
        }

        // drawn vertical line for date
        context.beginPath();
        context.textAlign = "center";
        context.textBaseline = "top";
        var eachDate = new Date(startDate);
        var dateList = {};
        var dateIndex = 1;
        while (eachDate <= toDate) {
            var line = dateIndex - 1;
            var positionX = (line / noGapDays + 1) * datePadding + startLeftPoint;
            var newPositionX = Math.floor(positionX) + 0.5;
            var eachDateTxt = eachDate.MMddyyyy();
            dateList[eachDateTxt] = {};
            dateList[eachDateTxt]["positionX"] = newPositionX;
            if (line % noGapDays === 0) {
                dateList[eachDateTxt]["isCircle"] = true;
                context.beginPath();
                // draw text
                var dateTxt = eachDate.ddMM();
                context.fillText(dateTxt, positionX, endTopPoint + 5);
                context.beginPath();
                // draw vertical line for date
                if (i < noDateLine) {
                    context.moveTo(newPositionX, endTopPoint);
                    context.lineTo(newPositionX, startTopPoint);
                    context.stroke();
                }
            } else {
                dateList[eachDateTxt]["isCircle"] = false;
            }

            eachDate.setDate(eachDate.getDate() + 1);
            dateIndex++;
        }

        // draw revenue Data
        var revenueLenght = revenueList.length;
        context.beginPath();
        context.fillStyle = '#3C3F54';
        context.lineWidth = 2;
        context.strokeStyle = '#FF514E';
//        var oldPositionX = 0;
//        var oldPositionY = 0;
        for (var i = 0; i < revenueLenght; i++) {
            var revenueObject = revenueList[i];
            var selectedDate = revenueObject.selectedDate;
            var positionObject = dateList[selectedDate];
            if (angular.isObject(positionObject)) {
                // get revenue to calculate position Y
                var revenue = revenueObject.revenue;
                var positionY = (1 - revenue / maxRevenue) * charHeight + startTopPoint;
                positionObject["positionY"] = positionY;
            }
        }

        // draw data line first
        var oldPositionX = -1;
        var oldPositionY = -1;
        angular.forEach(dateList, function (position, selectedDate) {
            var positionX = position.positionX;
            var positionY = position.positionY;
            if (angular.isNumber(positionY)) {
                context.beginPath();
                if (oldPositionX >= 0 && oldPositionY >= 0) {
                    context.moveTo(oldPositionX, oldPositionY);
                    context.lineTo(positionX, positionY);
                    context.stroke();
                }

                oldPositionX = positionX;
                oldPositionY = positionY;
            } else {

                // draw line down
                context.beginPath();
                if (oldPositionX >= 0 && oldPositionY >= 0) {
                    context.moveTo(oldPositionX - 0.5, oldPositionY);
                    context.lineTo(positionX, endTopPoint);
                    context.stroke();
                }

                oldPositionX = positionX;
                oldPositionY = endTopPoint;
            }
        });
        // drawn circle point data
        angular.forEach(dateList, function (position, selectedDate) {
            if (position.isCircle) {
                var positionX = position.positionX;
                var positionY = position.positionY;
                if (angular.isNumber(positionY)) {
                    context.beginPath();
                    context.arc(positionX, positionY, 4, 0, Math.PI * 2, true);
                    context.fill();
                }
            }
        });
    }

    function drawBookingStatistics(noDays) {
        // get Gap and Start Date
        var noGapDays, noDateLine;
        if (noDays < NO_DATES_LINE) {
            noGapDays = 1;
            noDateLine = noDays;
        } else {
            noGapDays = Math.floor(noDays / NO_DATES_LINE);
            noDateLine = NO_DATES_LINE;
        }
        var distanceFromStartDate = noGapDays * (noDateLine - 1);
        var startDate = getStartDateInStatistics(distanceFromStartDate);
        // get Gap And Max Revenue
        var maxBooking = getMaxNoBookings(bookingsList);
        if (maxBooking % 100 !== 0) {
            // adjust max Revenue
            var tempMax = 0;
            while (tempMax < maxBooking) {
                tempMax += 100;
            }
            maxBooking = tempMax;
        }

        // draw
        var canvas = document.querySelector('#booking-line-chart');
        // Make it visually fill the positioned parent
        canvas.style.width = '100%';
        canvas.style.height = '100%';
        // ...then set the internal size to match
        canvas.width = canvas.offsetWidth;
        canvas.height = canvas.offsetHeight;
        var graph = $('#booking-line-chart');
        var context = graph[0].getContext('2d');
//        context.lineWidth  = 2;
//        context.fillStyle = "#FFFFFF";
        // calculate height and width of chart
        var startLeftPoint = GAP_FOR_REVENUE_TEXT;
        var endLeftPoint = graph.width() - LEFT_PADDING;
        var startTopPoint = TOP_PADDING;
        var endTopPoint = graph.height() - GAP_FOR_DATE_TEXT;
        var chartWidth = endLeftPoint - startLeftPoint;
        var charHeight = endTopPoint - startTopPoint;
        var gapRevenue = maxBooking / NO_REVENUE_LINE;
        var revenuePadding = charHeight / NO_REVENUE_LINE;
        var datePadding = chartWidth / noDateLine;
        context.beginPath();
        // draw chart rectangle first
        context.rect(startLeftPoint + 0.5, startTopPoint + 0.5, chartWidth, charHeight);
        context.strokeStyle = '#DAE1E8';
        context.stroke();
        context.fillStyle = "#FFFFFF";
        context.fill();
        // drawn horizontal line for revenue first
        context.beginPath();
        context.textAlign = "right";
        context.textBaseline = "middle";
        context.strokeStyle = '#DAE1E8';
        for (var i = 0; i <= NO_REVENUE_LINE; i++) {
            context.beginPath();
            // drawn text first
            var positionY = (NO_REVENUE_LINE - i) * revenuePadding + startTopPoint;
            context.fillText(i * gapRevenue, startLeftPoint - 5, positionY);
            if (i > 0 && i < NO_REVENUE_LINE) {
                context.beginPath();
                // then drawn line
                context.moveTo(startLeftPoint, positionY + 0.5);
                context.lineTo(endLeftPoint, positionY + 0.5);
                context.stroke();
            }
        }

        // drawn vertical line for date
        context.beginPath();
        context.textAlign = "center";
        context.textBaseline = "top";
        var eachDate = new Date(startDate);
        var dateList = {};
        var dateIndex = 1;
        while (eachDate <= toDate) {
            var line = dateIndex - 1;
            var positionX = (line / noGapDays + 1) * datePadding + startLeftPoint;
            var newPositionX = Math.floor(positionX) + 0.5;
            var eachDateTxt = eachDate.MMddyyyy();
            dateList[eachDateTxt] = {};
            dateList[eachDateTxt]["positionX"] = newPositionX;
            if (line % noGapDays === 0) {
                dateList[eachDateTxt]["isCircle"] = true;
                context.beginPath();
                // draw text
                var dateTxt = eachDate.ddMM();
                context.fillText(dateTxt, positionX, endTopPoint + 5);
                context.beginPath();
                // draw vertical line for date
                if (i < noDateLine) {
                    context.moveTo(newPositionX, endTopPoint);
                    context.lineTo(newPositionX, startTopPoint);
                    context.stroke();
                }
            } else {
                dateList[eachDateTxt]["isCircle"] = false;
            }

            eachDate.setDate(eachDate.getDate() + 1);
            dateIndex++;
        }

        // draw booking Data
        var listBookingLength = bookingsList.length;
        context.beginPath();
        context.fillStyle = '#3C3F54';
        context.lineWidth = 2;
        context.strokeStyle = '#FF514E';
//        var oldPositionX = 0;
//        var oldPositionY = 0;
        for (var i = 0; i < listBookingLength; i++) {
            var bookingObject = bookingsList[i];
            var selectedDate = bookingObject.selectedDate;
            var positionObject = dateList[selectedDate];
            if (angular.isObject(positionObject)) {
                // get revenue to calculate position Y
                var noBookings = bookingObject.noBookings;
                var positionY = (1 - noBookings / maxBooking) * charHeight + startTopPoint;
                positionObject["positionY"] = positionY;
            }
        }

        // draw data line first
        var oldPositionX = -1;
        var oldPositionY = -1;
        angular.forEach(dateList, function (position, selectedDate) {
            var positionX = position.positionX;
            var positionY = position.positionY;
            if (angular.isNumber(positionY)) {
                context.beginPath();
                if (oldPositionX >= 0 && oldPositionY >= 0) {
                    context.moveTo(oldPositionX, oldPositionY);
                    context.lineTo(positionX, positionY);
                    context.stroke();
                }

                oldPositionX = positionX;
                oldPositionY = positionY;
            } else {

                // draw line down
                context.beginPath();
                if (oldPositionX >= 0 && oldPositionY >= 0) {
                    context.moveTo(oldPositionX - 0.5, oldPositionY);
                    context.lineTo(positionX, endTopPoint);
                    context.stroke();
                }

                oldPositionX = positionX;
                oldPositionY = endTopPoint;
            }
        });
        // drawn circle point data
        angular.forEach(dateList, function (position, selectedDate) {
            if (position.isCircle) {
                var positionX = position.positionX;
                var positionY = position.positionY;
                if (angular.isNumber(positionY)) {
                    context.beginPath();
                    context.arc(positionX, positionY, 4, 0, Math.PI * 2, true);
                    context.fill();
                }
            }
        });
    }
    if (!angular.isUndefined(revenueList[0])) {
        drawRevenueStatistics(30);
    }
    ;


    $(document).ready(function () {
        // calculate height scroll-bar thumb
        var scrollBox = $("#bookings-overview .overview-content").height();
        var scrollContent = $("#bookings-overview .overview-content ul").height();
        var thumbHeight = scrollBox / scrollContent * scrollBox;
        var maxDistance = scrollContent - scrollBox;
        var scrollSpeed = 10;
        var currentPosition = 0;
        $("#booking-scrollbar .scrollbar-thumb").height(thumbHeight);
        /* Custom Scrollbar */
        //Firefox
        $('#bookings-overview .overview-content').bind('DOMMouseScroll', function (e) {
            if (e.originalEvent.detail > 0) {
                //scroll down
                console.log('Down');
            } else {
                //scroll up
                console.log('Up');
            }

            //prevent page fom scrolling
            return false;
        });
        //IE, Opera, Safari
        $('#bookings-overview .overview-content').bind('mousewheel', function (e) {
            if (e.originalEvent.wheelDelta < 0) {
                currentPosition += scrollSpeed;
                //scroll down
            } else {
                currentPosition -= scrollSpeed;
                //scroll up
            }

            // check position
            if (currentPosition < 0) {
                currentPosition = 0;
            } else if (currentPosition > maxDistance) {
                currentPosition = maxDistance;
            }

            var thumbPosition = currentPosition / scrollContent * scrollBox;
            $(this).animate({
                scrollTop: currentPosition
            }, 10, function () {
                // Animation complete.
                $("#booking-scrollbar .scrollbar-thumb").css("top", thumbPosition);
            });
            //prevent page fom scrolling
            return false;
        });
    });
    $scope.loaded = true;
});


myApp.controller('BookingEngineController', function ($scope, $http, $timeout, service, $interval) {
    $scope.loaded = false;
    /* COMMON */
    var NUMBER_OF_DATES_PER_MONTH = 42;
    $scope.now = new Date(now);
    $scope.selectedDate = new Date(now);
    var day_of_week = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thurday', 'Friday', 'Saturday'];
    var month_of_year = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
    var $BIG_DATE = $("#bkk-calendar .calendar-common .big-date ul");
    var $CALENDAR = $("#bkk-calendar .calendar-body .calendar-dates ul");

    var HEADER_HEIGHT = 65;
    var TABLE_PADDING = 20;
    var $LEFT_MENU = $("#booking-left-menu");
    var $ENGINE_TABLE = $("#engine-table");

    // get height of window to set minimum height
    function setMinHeight() {
        var windowHeight = $(window).height();
        var minHeight = windowHeight - HEADER_HEIGHT;
        $LEFT_MENU.css("min-height", minHeight);

        var engineCtrlHeight = $("#engine-ctrs").outerHeight(true);
        var tableMinHeight = minHeight - 2 * TABLE_PADDING - engineCtrlHeight;
        $ENGINE_TABLE.css("min-height", tableMinHeight);
    }

    $(document).ready(function () {
        setMinHeight();
    });

    $(window).resize(function () {
        setMinHeight();
    });
    /* END COMMON */

    /* CALENDAR */
    // init calendar
    Date.prototype.MMddyyyy = function () {
        var yyyy = this.getFullYear().toString();
        var mm = (this.getMonth() + 1).toString(); // getMonth() is zero-based
        var dd = this.getDate().toString();
        return  (mm[1] ? mm : "0" + mm[0]) + "/" + (dd[1] ? dd : "0" + dd[0]) + "/" + yyyy; // padding
    };

    Date.prototype.ddMM = function () {
        var yyyy = this.getFullYear().toString();
        var mm = (this.getMonth() + 1).toString(); // getMonth() is zero-based
        var dd = this.getDate().toString();
        return (dd[1] ? dd : "0" + dd[0]) + "." + (mm[1] ? mm : "0" + mm[0]); // padding
    };

    Date.prototype.HHmm = function () {
        var HH = this.getHours().toString();
        var MM = this.getMinutes().toString();
        return (HH[1] ? HH : "0" + HH[0]) + ":" + (MM[1] ? MM : "0" + MM[0]); // padding
    };

    Date.prototype.FullDay = function () {
        return day_of_week[this.getDay()]; // padding
    };

    Date.prototype.MonthYear = function () {
        return month_of_year[this.getMonth()] + " " + this.getFullYear().toString();
    };

    function updateCalendar(selectedDate) {

        // for big date
        var previousDate = new Date(selectedDate);
        previousDate.setDate(previousDate.getDate() - 1);
        var nextDate = new Date(selectedDate);
        nextDate.setDate(nextDate.getDate() + 1);
        var bigDateTxt = "<li class='date'><div class='date-txt'>" + previousDate.getDate() + "</div></li>"
                + "<li class='date'><div class='date-txt'>" + selectedDate.getDate() + "</div></li>"
                + "<li class='date'><div class='date-txt'>" + nextDate.getDate() + "</div></li>";
        $BIG_DATE.html(bigDateTxt);

        // for caledar body
        // move to the first day
        var firstDate = new Date(selectedDate);
        var lastDate = new Date(firstDate.getFullYear(), firstDate.getMonth() + 1, 0);
        var totalDays = lastDate.getDate();

        firstDate.setDate(1);
        var distance = firstDate.getDay();
        firstDate.setDate(firstDate.getDate() - distance);

        var calendarBodyTxt = "";
        for (var i = 0; i < distance; i++) {
            var date = firstDate.getDate();
            var dateMMddyyyy = firstDate.MMddyyyy();

            calendarBodyTxt += "<li class='out-date'><a href='' data-date='" + dateMMddyyyy + "'>" + date + "</a></li>";

            firstDate.setDate(firstDate.getDate() + 1);
        }

        for (var i = 0; i < totalDays; i++) {
            var date = firstDate.getDate();
            var dateMMddyyyy = firstDate.MMddyyyy();
            if (firstDate.getTime() !== selectedDate.getTime()) {
                calendarBodyTxt += "<li><a href='' data-date='" + dateMMddyyyy + "'>" + date + "</a></li>";
            } else {
                calendarBodyTxt += "<li class='active'><a href='' data-date='" + dateMMddyyyy + "'>" + date + "</a></li>";
            }
            firstDate.setDate(firstDate.getDate() + 1);
        }

        distance = NUMBER_OF_DATES_PER_MONTH - totalDays - distance;
        for (var i = 0; i < distance; i++) {
            var date = firstDate.getDate();
            var dateMMddyyyy = firstDate.MMddyyyy();
            calendarBodyTxt += "<li class='out-date'><a href='' data-date='" + dateMMddyyyy + "'>" + date + "</a></li>";

            firstDate.setDate(firstDate.getDate() + 1);
        }

        $CALENDAR.html(calendarBodyTxt);
    }

    $(document).on("click", "#bkk-calendar .calendar-body .calendar-dates ul li a", function () {
        var newDate = $(this).attr("data-date");
        $scope.selectedDate = new Date(newDate);
        updateCalendar($scope.selectedDate);
        $scope.$digest();
    });

    $scope.nextDate = function () {
        $scope.selectedDate.setDate($scope.selectedDate.getDate() + 1);
        updateCalendar($scope.selectedDate);
    };

    $scope.previousDate = function () {
        $scope.selectedDate.setDate($scope.selectedDate.getDate() - 1);
        updateCalendar($scope.selectedDate);
    };

    $scope.previousMonth = function () {
        $scope.selectedDate.setMonth($scope.selectedDate.getMonth() - 1);
        updateCalendar($scope.selectedDate);
    };

    $scope.nextMonth = function () {
        $scope.selectedDate.setMonth($scope.selectedDate.getMonth() + 1);
        updateCalendar($scope.selectedDate);
    };

    // update time by minutes
    function calculateTimeNow() {
        $scope.now.setSeconds($scope.now.getSeconds() + 1);
    }
    $interval(function () {
        calculateTimeNow();
    }, 1000);

    /* END CALENDAR */

    updateCalendar($scope.selectedDate);
    $scope.loaded = true;
});

myApp.controller('RefferalProgram', function ($scope, $http, $timeout, service, $interval) {

    var emailRegex = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    $scope.emailArray = [];
    $scope.listReferral = referralList;
    $scope.officialID = officialID;

    $scope.activeReferralCount = 0;
    for (var i = 0; i < $scope.listReferral.length; i++) {
        if ($scope.listReferral[i].activatePackage > 0) {
            $scope.activeReferralCount++;
            $scope.listReferral[i].status = 'Successful';
        } else {
            $scope.listReferral[i].status = 'Pending';
        }
    }

    $(".email-addresses").keypress(function (e) {
        if (e.which === 13) {
            $scope.inviteSuccess = false;
            if (emailRegex.test($(".email-addresses").val())) {
                var email = $(".email-addresses").val();
                var existEmail = false;
                for (var i = 0; i < $scope.emailArray.length; i++) {
                    if ($scope.emailArray[i] === email) {
                        existEmail = true;
                        break;
                    }

                }
                if (!existEmail) {
                    $scope.emailArray.push($(".email-addresses").val());
                }

                $(".email-addresses").val('');
            }
            $scope.$digest();
        }
    });

    $(document).click(function (event) {
        if (!$(event.target).closest('.email-addresses').length && !$(event.target).is('.email-addresses')
                ) {
            if (emailRegex.test($(".email-addresses").val())) {
                $scope.inviteSuccess = false;
                var email = $(".email-addresses").val();
                var existEmail = false;
                for (var i = 0; i < $scope.emailArray.length; i++) {
                    if ($scope.emailArray[i] === email) {
                        existEmail = true;
                        break;
                    }

                }
                if (!existEmail) {
                    $scope.emailArray.push($(".email-addresses").val());
                }

                $(".email-addresses").val('');
            }
            $scope.$digest();
        }
    });

    $scope.removeEmail = function (index) {
        $scope.emailArray.splice(index, 1);
    };

    $scope.inviteSuccess = false;
    var inviteUrl = service.getContextPath() + "/Provider/SendEmailReferral";
    $scope.isSendEmail = false;
    $scope.inviteEmails = function () {
        if (emailRegex.test($(".email-addresses").val())) {
            var email = $(".email-addresses").val();
            var existEmail = false;
            for (var i = 0; i < $scope.emailArray.length; i++) {
                if ($scope.emailArray[i] === email) {
                    existEmail = true;
                    break;
                }

            }
            if (!existEmail) {
                $scope.emailArray.push($(".email-addresses").val());
            }

            $(".email-addresses").val('');
        }
        var content = $(".email-content").val();
        content = " Hello,<br/><br/>I hope this email finds you well. I wanted to reach out because I’ve been using this new website called youtripper that helps me manage and sell all of my activities online.<br/><br/> They have this platform that makes listing my activities easy, flexible and informative. It’s also great because I get to use a free booking engine that automatically manages my resources to maximize online sales and synchronize with my regular walk-ins.<br/><br/> If you register as a new provider now and create your first activity package, they will thank you with a starting bonus of 300THB in commission credit. <br/><br/> Signing up is completely free. You can use this link to visit their registration now.<br/> https://www.youtripper.com/ProviderSignup?ref=" + $scope.officialID + " <br/><br/>Cheers,";
        var data = {"emails": $scope.emailArray, "content": content};
        if ($scope.emailArray.length > 0) {
            $scope.isSendEmail = true;
            $scope.isProcessing = true;
            $scope.inviteSuccess = false;
            $http.post(inviteUrl, data)
                    .then(function successCallback(response) {
                        if (response.data.result === "error") {
                            var pageError = service.getContextPath() + service.getErrorPageUrl();
                            $(location).attr('href', pageError);
                        } else if (response.data.result !== "fail") {
                            $scope.isProcessing = false;
                            $scope.inviteSuccess = true;
                            $scope.isSendEmail = false;
                        } else {
                        }
                        $scope.emailArray = [];
                    });
        }
    };

    $scope.importGoogle = function () {
        if (($scope.googleContactArray.length === 0)) {
            var config = {
                'client_id': '897561243789-9d6c6q5163cd0s2stk60mpjflkd1qdqo.apps.googleusercontent.com',
                'scope': 'https://www.google.com/m8/feeds'
            };
            gapi.auth.authorize(config, function () {
                fetch(gapi.auth.getToken());
            });
        } else {
            adjustPopup();
        }
    };

    $scope.googleContactArray = [];
    $scope.socialContactArray = [];
    $scope.pickedEmail = [];

    function fetch(token) {
        $.ajax({
            url: 'https://www.google.com/m8/feeds/contacts/default/full?alt=json',
            dataType: 'jsonp',
            data: token
        }).done(function (data) {
            for (var i = 0; i < data.feed.entry.length; i++) {
                var name = data.feed.entry[i].title.$t;
                var email = data.feed.entry[i].gd$email[0].address;
                var contact = {"name": name, "email": email};
                $scope.googleContactArray.push(contact);
//                for (var i=0;i < $scope.socialContactArray.length;i++){
//                    if ($scope.socialContactArray[i].email !== email){
//                         
//                    }
//                }
            }
            $scope.socialContactArray = $scope.socialContactArray.concat($scope.googleContactArray);
            $scope.$digest();
            adjustPopup();
        });
    }

    $scope.importOutlook = function () {
        WL.login({
            scope: ["wl.basic", "wl.contacts_emails"]
        }).then(function (response)
        {
            WL.api({
                path: "me/contacts",
                method: "GET"
            }).then(
                    function (response) {
                        //your response data with contacts 
                        console.log(response.data);
                    },
                    function (responseFailed) {
                        //console.log(responseFailed);
                    }
            );

        },
                function (responseFailed)
                {
                    //console.log("Error signing in: " + responseFailed.error_description);
                });
    };

    var adjustPopup = function () {
        $('#contactPopup').toggleClass('active');
        $('.popupContent').height($(window).height() - 300);
        $('.popupScroll').height($('.popupContent').height() - 100);
    };
    $scope.sendInvitationPopup = function () {
        var content = " Hello,<br/><br/>I hope this email finds you well. I wanted to reach out because I’ve been using this new website called youtripper that helps me manage and sell all of my activities online.<br/><br/> They have this platform that makes listing my activities easy, flexible and informative. It’s also great because I get to use a free booking engine that automatically manages my resources to maximize online sales and synchronize with my regular walk-ins.<br/><br/> If you register as a new provider now and create your first activity package, they will thank you with a starting bonus of 300THB in commission credit. <br/><br/> Signing up is completely free. You can use this link to visit their registration now.<br/> https://www.youtripper.com/ProviderSignup?ref=" + $scope.officialID + " <br/><br/>Cheers,";
        console.log($scope.pickedEmail);
        var data = {"emails": $scope.pickedEmail, "content": content};
        if ($scope.pickedEmail.length > 0) {
            $scope.isSendEmail = true;
            $scope.sendingEmailPopup = true;
            $scope.inviteSuccess = false;
            $http.post(inviteUrl, data)
                    .then(function successCallback(response) {
                        if (response.data.result === "error") {
                            var pageError = service.getContextPath() + service.getErrorPageUrl();
                            $(location).attr('href', pageError);
                        } else if (response.data.result !== "fail") {
                            $scope.sendingEmailPopup = false;
                            $scope.inviteSuccess = true;
                            $scope.isSendEmail = false;
                        } else {
                        }
                        $scope.pickedEmail = [];
                        $('#contactPopup').toggleClass('active');
                    });
        }
    };

    $scope.addToEmailList = function () {
        console.log($scope.pickedEmail);
        $scope.emailArray = $scope.emailArray.concat($scope.pickedEmail);
        $scope.pickedEmail = [];
        console.log($scope.emailArray);
        $('#contactPopup').toggleClass('active');
    };

    $scope.toggleContactBox = function () {
        $('#contactPopup').toggleClass('active');
    };



});

