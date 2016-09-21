<%-- 
    Document   : calendar
    Created on : Oct 2, 2015, 11:18:54 AM
    Author     : Nick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=1366">
        <title>JSP Page</title>
        <!-- Bootstrap -->
        <link href="<c:url value="/Resources/Theme/css/bootstrap-theme.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/bootstrap.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/pepper-ginder-custom.css"/>" rel="stylesheet">
        <script src="<c:url value="/Resources/Theme/js/jquery-1.11.1.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.multidatespicker.js"/>"></script>
        <style>
            /* begin: jQuery UI Datepicker moving pixels fix */
            table.ui-datepicker-calendar {border-collapse: separate;}
            .ui-datepicker-calendar td {border: 1px solid transparent;}
            /* end: jQuery UI Datepicker moving pixels fix */

            /* begin: jQuery UI Datepicker emphasis on selected dates */
            .ui-datepicker .ui-datepicker-calendar .ui-state-highlight a {
                background: #743620 none; /* a color that fits the widget theme */
                color: white; /* a color that is readeable with the color above */
            }
            /* end: jQuery UI Datepicker emphasis on selected dates */

            #promotion-form {
                padding: 100px;
                position: fixed;
                top: 10%;
                left: 20%;
                z-index: 999;
                background-color: rgba(0,0,0,0.8);
            }

            .edit-promotion a {
                float: left;
                margin-right: 50px;
                padding: 3px 10px;
                border-radius: 10px;
                text-decoration: none;
                color: #fff;
            }

            .ui-state-highlight.first-promotion a, .edit-promotion#promotion-1 a {
                background: #743620 !important;
            }

            .ui-state-highlight.second-promotion a, .edit-promotion#promotion-2 a {
                background: green !important;
            }

            .ui-state-highlight.third-promotion a, .edit-promotion#promotion-3 a {
                background: yellow !important;
            }

            .ui-state-highlight.fourth-promotion a, .edit-promotion#promotion-4 a {
                background: orange !important;
            }

            .ui-state-highlight.fifth-promotion a, .edit-promotion#promotion-5 a {
                background: red !important;
            }

            ul.promotions li {
                margin: 5px;
                display: none;
            }

            .preview-calendar {
                position: relative;
            }

            #protect {
                position: absolute;
                width: 100%;
                height: 100%;
                z-index: 1;
                top: 30px;
            }
        </style>
    </head>
    <body>
        <h1>Test Calendar!</h1>
        <strong>From Date</strong>
        <input type="text" id="from" name="from">
        <strong>To Date</strong>
        <input type="text" id="to" name="to">
        <br/>
        <h1>Price</h1>
        <input type="text" id="price" name="common-price">
        <br/>
        <h1>Unavailable Day</h1>
        <ul>
            <li><input type="checkbox" name="unavailableDays" value="1" />Monday</li>
            <li><input type="checkbox" name="unavailableDays" value="2" />Tuesday</li>
            <li><input type="checkbox" name="unavailableDays" value="3" />Wednesday</li>
            <li><input type="checkbox" name="unavailableDays" value="4" />Thursday</li>
            <li><input type="checkbox" name="unavailableDays" value="5" />Friday</li>
            <li><input type="checkbox" name="unavailableDays" value="6" />Saturday</li>
            <li><input type="checkbox" name="unavailableDays" value="0" />Sunday</li>
        </ul>
        <h1>Preview Calendar</h1>
        <a id="add-promotion" class="boxer" href="#full-year">Add Promotion</a>
        <ul class="promotions">
            <h3>Promotions</h3>
            <li class="edit-promotion" id="promotion-1">
                <a ofPromotion="0" href="#full-year">Edit</a> Price: <input type="text" name="promotion-price-1"/> 
            </li>
            <li class="edit-promotion" id="promotion-2">
                <a ofPromotion="1" href="#full-year">Edit</a> Price: <input type="text" name="promotion-price-2"/>
            </li>
            <li class="edit-promotion" id="promotion-3">
                <a ofPromotion="2" href="#full-year">Edit</a> Price: <input type="text" name="promotion-price-3"/>
            </li>
            <li class="edit-promotion" id="promotion-4">
                <a ofPromotion="3" href="#full-year">Edit</a> Price: <input type="text" name="promotion-price-4"/>
            </li>
            <li class="edit-promotion" id="promotion-5">
                <a ofPromotion="4" href="#full-year">Edit</a> Price: <input type="text" name="promotion-price-5"/>
            </li>
        </ul>
        <div id="promotion-form" style="display: none;">
            <div class="content" style="width: 600px">
                <h2>Promotion</h2>
                <strong style="color: white;">Price</strong>
                <input type="text" name="promotion-price" id="promotion-price" placeholder="Promotion price"/><br/><br/>
                <strong style="color: white;">Select promotion dates:</strong>
                <div id="promotion-calendar" class="box" ></div><br/>
                <a href="#full-year" id="apply-promotion" style="color: white;">Apply</a><br/>
                <a href="#full-year" id="cancel-promotion" style="color: white;">Cancel</a>
            </div>
        </div>
        <div class="preview-calendar">
            <div id="protect"></div>
            <div id="full-year" class="box" ></div>
        </div>
        <script>
            $(function () {
                $.datepicker._updateDatepicker_original = $.datepicker._updateDatepicker;
                $.datepicker._updateDatepicker = function (inst) {
                    $.datepicker._updateDatepicker_original(inst);
                    var afterShow = this._get(inst, 'afterShow');
                    if (afterShow)
                        afterShow.apply((inst.input ? inst.input[0] : null));  // trigger custom callback
                };

                var promotionTimes = 0;
                var editPromotion = false;
                var editingNumber = -1;
                var promotion = [
                    {'color': 'first-promotion',
                        'dates': [],
                        'price': '0'},
                    {'color': 'second-promotion',
                        'dates': [],
                        'price': '0'},
                    {'color': 'third-promotion',
                        'dates': [],
                        'price': '0'},
                    {'color': 'fourth-promotion',
                        'dates': [],
                        'price': '0'},
                    {'color': 'fifth-promotion',
                        'dates': [],
                        'price': '0'}];

                var unavailableDates = [];
                var minimumDate = "";
                var maximumDate = "";
                var commonPrice = $("input#price");
                var promotionPrice = $("input#promotion-price");

                $("#from").datepicker({
                    defaultDate: "+1w",
                    minDate: 0,
                    changeMonth: true,
                    onClose: function (selectedDate) {
                        $("#to").datepicker("option", "minDate", selectedDate);
                        minimumDate = selectedDate;
                        updateFullCalendar();
                    }
                });

                $("#to").datepicker({
                    defaultDate: "+1w",
                    changeMonth: true,
                    onClose: function (selectedDate) {
                        $("#from").datepicker("option", "maxDate", selectedDate);
                        maximumDate = selectedDate;
                        updateFullCalendar();
                    }
                });

                $('#full-year').multiDatesPicker({
                    numberOfMonths: [2, 3],
                    minDate: 0
                });

                $('input[type=checkbox][name=unavailableDays]').change(function () {
                    unavailableDates = $('input[type=checkbox][name=unavailableDays]:checked').map(function () {
                        return this.value;
                    }).get();
                    updateFullCalendar();
                });

                $('.edit-promotion a').click(function () {
                    if (minimumDate !== "" && maximumDate !== "") {
                        if (commonPrice.val() !== "") {
                            editingNumber = $(this).attr("ofPromotion");
                            var price = promotion[editingNumber].price;
                            $('#promotion-calendar').multiDatesPicker('destroy');
                            $('#promotion-calendar').multiDatesPicker({
                                numberOfMonths: [1, 2],
                                minDate: minimumDate,
                                maxDate: maximumDate,
                                beforeShowDay: function (day) {
                                    return enableDates(day);
                                }
                            });
                            var dates;
                            for (var i = 0; i < promotion.length; i++) {
                                dates = promotion[i].dates;
                                if (dates.length > 0) {
                                    if (i.toString() !== editingNumber) {
                                        $('#promotion-calendar').multiDatesPicker('addDates', dates, 'disabled');
                                    } else {
                                        $('#promotion-calendar').multiDatesPicker('addDates', dates);
                                    }
                                }
                            }
                            promotionPrice.val(price);
                            editPromotion = true;
                            $("#promotion-form").show();
                        } else {
                            alert("Please fill common price first!");
                        }
                    } else {
                        alert("Please select your duration!");
                    }
                    return false;
                });

                $('#add-promotion').click(function () {
                    if (minimumDate !== "" && maximumDate !== "") {
                        if (commonPrice.val() !== "") {
                            if (promotionTimes > -1) {
                                $('#promotion-calendar').multiDatesPicker('destroy');
                                var selectedDates = $('#full-year').multiDatesPicker('getDates');
                                $('#promotion-calendar').multiDatesPicker({
                                    numberOfMonths: [1, 2],
                                    minDate: minimumDate,
                                    maxDate: maximumDate,
                                    beforeShowDay: function (day) {
                                        return enableDates(day);
                                    }
                                });
                                if (selectedDates.length > 0) {
                                    $('#promotion-calendar').multiDatesPicker('addDates', selectedDates, 'disabled');
                                }
                                promotionPrice.val(commonPrice.val());
                                $("#promotion-form").show();
                            } else {
                                alert("Your promotion is full");
                            }
                        } else {
                            alert("Please fill common price first!");
                        }
                    } else {
                        alert("Please select your duration!");
                    }
                    return false;
                });

                $('#apply-promotion').click(function () {
                    if (!editPromotion) {
                        var price = promotionPrice.val();
                        var selectedDates = $('#promotion-calendar').multiDatesPicker('getDates');
                        if (selectedDates.length > 0) {
                            promotion[promotionTimes].dates = selectedDates;
                            promotion[promotionTimes].price = price;
                            $('#promotion-' + (promotionTimes + 1).toString() + ' input').val(price);
                            $('#promotion-' + (promotionTimes + 1).toString()).show();
                            promotionTimes = -1;
                            updateDates();
                            $('#promotion-calendar').multiDatesPicker('resetDates', 'picked');
                            $("#promotion-form").hide();
//                            promotionTimes++;

                        } else {
                            alert("Please select dates!");
                        }
                    } else {
                        var price = promotionPrice.val();
                        var selectedDates = $('#promotion-calendar').multiDatesPicker('getDates');
                        promotion[editingNumber].dates = selectedDates;
                        promotion[editingNumber].price = price;
                        updateDates();
                        $('#promotion-' + (parseInt(editingNumber) + 1).toString() + ' input').val(price);
                        $('#promotion-calendar').multiDatesPicker('resetDates', 'picked');
                        $("#promotion-form").hide();
                        editPromotion = false;
                        editingNumber = -1;
                    }
                });

                $('#cancel-promotion').click(function () {
                    editPromotion = false;
                    editingNumber = -1;
                    $("#promotion-form").hide();
                    $('#promotion-calendar').multiDatesPicker('resetDates', 'picked');
                });

                function enableDates(day) {
                    var d = day.getDay();
                    if (unavailableDates.indexOf(d.toString()) !== -1) {
                        return [false, ""];
                    } else {
                        return [true, ""];
                    }
                }

                function updateDates() {
                    var minDate = new Date(minimumDate);
                    var maxDate = new Date(maximumDate);
                    if (minDate !== null && maxDate !== null) {
                        $('#full-year').multiDatesPicker('resetDates', 'picked');
                        var dates;
                        for (var i = 0; i < promotion.length; i++) {
                            dates = promotion[i].dates;
                            for (var j = (dates.length - 1); j >= 0; j--) {
                                var date = new Date(dates[j]);
                                if (date >= minDate && date <= maxDate && (unavailableDates.indexOf(date.getDay().toString()) < 0)) {
                                    $('#full-year').multiDatesPicker('addDates', dates[j]);
                                } else {
                                    promotion[i].dates.splice(j, 1);
                                }
                            }
                        }
                    }

                    for (var i = 0; i < promotion.length; i++) {
                        if (promotion[i].dates.length === 0) {
                            promotion[i].price = 0;
                            $('#promotion-' + (i + 1).toString() + ' input').val(0);
                            $('#promotion-' + (i + 1).toString()).hide();
                            if (promotionTimes < 0) {
                                promotionTimes = i;
                            }
                        }
                    }
                }

                function higlighDates() {
                    var color, dateComponents, elementStr, dateElement;
                    for (var i = 0; i < promotion.length; i++) {
                        var dates = promotion[i].dates;
                        color = promotion[i].color;
                        for (var j = 0; j < dates.length; j++) {
                            dateComponents = dates[j].split('/');
                            elementStr = '#full-year td[data-month=' + (parseInt(dateComponents[0]) - 1).toString() + '][data-year=' + dateComponents[2] + ']';
                            dateElement = $(elementStr)
                                    .filter(function (index) {
                                        return $(this).text() === parseInt(dateComponents[1]).toString();
                                    });
                            dateElement.addClass(color);
                        }
                    }
                }

                function updateFullCalendar() {
                    $('#full-year').multiDatesPicker('destroy');
                    $('#full-year').multiDatesPicker({
                        numberOfMonths: [2, 3],
                        minDate: minimumDate,
                        maxDate: maximumDate,
                        beforeShowDay: function (day) {
                            return enableDates(day);
                        }, afterShow: function (month, year, inst) {
                            higlighDates();
                        }
                    });
                    updateDates();
                }

//                $(document).mouseup(function (e)
//                {
//                    var container = $("#promotion-form");
//
//                    if (!container.is(e.target) // if the target of the click isn't the container...
//                            && container.has(e.target).length === 0) // ... nor a descendant of the container
//                    {
//                        container.hide();
//                    }
//                });
            });
        </script>
    </body>
</html>
