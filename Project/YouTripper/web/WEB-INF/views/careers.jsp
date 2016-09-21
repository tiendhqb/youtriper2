<!DOCTYPE html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
    <head>
        <meta name="description" content="">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=1366">
<!--        <meta name="viewport" content="width=device-width, initial-scale=1">-->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <link rel="icon" href="<c:url value="/Images/Icon/favicon.png"/>" >

        <!-- Bootstrap -->
        <link href="<c:url value="/Resources/Theme/css/bootstrap-theme.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/bootstrap.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/jquery.mThumbnailScroller.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/lightgallery.css"/>" rel="stylesheet">
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style-login.css"/>" >

        <%@ include file="angular.jsp" %>

        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>
        <link rel="icon" href="<c:url value="/Images/Icon/favicon.png"/>" >
        <title>Youtripper - Careers</title>
    </head>
    <body class="pagesearch" ng-app="YouTripper" ng-controller="CareerController">
        <!-- Google Tag Manager -->
        <noscript><iframe src="//www.googletagmanager.com/ns.html?id=GTM-MZRL8C"
                          height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
        <script>(function (w, d, s, l, i) {
                w[l] = w[l] || [];
                w[l].push({'gtm.start':
                            new Date().getTime(), event: 'gtm.js'});
                var f = d.getElementsByTagName(s)[0],
                        j = d.createElement(s), dl = l != 'dataLayer' ? '&l=' + l : '';
                j.async = true;
                j.src =
                        '//www.googletagmanager.com/gtm.js?id=' + i + dl;
                f.parentNode.insertBefore(j, f);
            })(window, document, 'script', 'dataLayer', 'GTM-MZRL8C');</script>
        <!-- End Google Tag Manager -->
        <%@ include file="header.jsp" %>
        <!--CONTENT-->
        <div class="padding-header" ng-controller="FixedComparisonController">
            <!--Selector-->
            <div class="banner-carrers">
                <div class="container">
                    <h1>
                        Join Our Team
                    </h1>
                </div>

            </div>
            <div class="carrers">
                <div class="carrers-item">
                    <div class="carrers-item-header">
                        <div class="row">
                            <div class="col-md-7 col-sm-12">
                                <h1>CONTENT COPYWRITER</h1><p>Bangkok, Thailand</p>

                            </div>
                            <div class="col-md-3 col-sm-6"><h3>02 Opening</h3></div>
                            <div class="col-md-2 col-sm-6"><a href="#"><img alt="" src="<c:url value="/Images/Icon/facebook.png"/>" /> </a><a href="#"><img alt="" src="<c:url value="/Resources/Theme/image/twitter.png"/>"/> </a></div>
                        </div>

                    </div>

                    <div class="carrers-item-content">
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam eget mi fermentum, euismod ex vel, pretium tortor.
                            Quisque tempor neque lorem, eget convallis mauris sagittis sit amet. Nam venenatis viverra arcu vitae tempor.
                            Vestibulum congue lectus sed nisl lacinia consequat. Vestibulum fermentum nulla non turpis faucibus porttitor.
                            Maecenas lobortis vel eros eget cursus. Praesent rhoncus enim quam, id aliquet ligula dignissim sit amet.</p>

                        <a class="Job" ng-click="ViewDes(0)">JOB DESCRIPTION</a>
                        <div class="JobDetail">

                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris semper aliquam consectetur. Sed volutpat dolor quis tincidunt commodo. Morbi scelerisque ante vel diam ornare, sit amet facilisis dui tristique. Integer non eros ut augue aliquam tristique et sit amet metus. Cras malesuada ultrices erat, mattis tristique sapien volutpat eget. Nullam sagittis purus ut posuere tempor. Curabitur vel est ac ligula tempor molestie et nec lectus.

                            Donec condimentum eget lorem sit amet maximus. Donec facilisis eleifend nulla a sagittis. Vestibulum risus est, condimentum a mi at, commodo finibus sem. Integer vel elit sit amet tellus feugiat porta. Proin sagittis orci augue. Quisque imperdiet faucibus gravida. Praesent rutrum mattis turpis, vitae pretium nisl laoreet quis. Nam convallis justo nec sem rutrum fringilla. Vestibulum semper nibh eget enim sollicitudin commodo. Ut blandit urna et dolor facilisis accumsan. Nunc congue purus a odio luctus ullamcorper. Curabitur sodales tortor purus, in tempus velit varius non. Quisque vel mauris placerat, molestie sem sit amet, malesuada enim.

                            Ut pellentesque porttitor leo, malesuada dictum lectus hendrerit a. Proin massa nulla, dignissim nec enim non, aliquet rutrum nulla. Sed viverra nunc in lorem lobortis, quis laoreet arcu gravida. Nullam a porta ligula. Sed fringilla posuere elit, quis molestie nulla. Aliquam magna ante, efficitur non tristique eget, efficitur quis ex. Pellentesque libero sem, ornare et malesuada sit amet, bibendum sed felis. Curabitur dignissim justo a quam porta sollicitudin. Ut ultrices rutrum nibh a ornare. Cras nec aliquam elit. Aenean tincidunt dolor et vulputate congue. Mauris sed neque dui. Aenean rhoncus, ex ut sodales cursus, nulla odio interdum augue, ac pulvinar metus velit a neque.

                            Donec congue odio sed ante rutrum, ut aliquet orci porta. Interdum et malesuada fames ac ante ipsum primis in faucibus. Integer ultrices ante urna, sit amet elementum dui rhoncus ac. Morbi at odio sodales, porttitor urna quis, blandit elit. Nam fringilla tellus vitae luctus egestas. Phasellus vulputate elit ipsum, non aliquet neque finibus ac. Fusce tristique lobortis enim et dapibus. Nam non enim nisl. Aenean malesuada fermentum laoreet. Vestibulum id lacus eget lorem elementum laoreet in vitae mi. Sed luctus, leo nec tempus ultricies, velit lectus auctor neque, facilisis pretium tortor enim non quam. Curabitur lobortis justo sit amet dui facilisis cursus. Phasellus viverra molestie justo eu sollicitudin. Aenean tincidunt nunc a est venenatis volutpat.

                            In elementum eget lectus a porttitor. Donec tempor pretium justo, ac sodales eros elementum eget. Nunc a risus id ante facilisis gravida. Sed feugiat diam in sapien auctor fringilla. Fusce et sodales neque. Aenean urna dui, semper nec eros in, aliquet pulvinar nibh. Mauris quis pulvinar libero. Sed at enim tellus. 
                        </div>

                    </div>
                </div>
                <div class="carrers-item">
                    <div class="carrers-item-header">
                        <div class="row">
                            <div class="col-md-7 col-sm-12">
                                <h1>CONTENT COPYWRITER</h1><p>Bangkok, Thailand</p>

                            </div>
                            <div class="col-md-3 col-sm-6"><h3>02 Opening</h3></div>
                            <div class="col-md-2 col-sm-6"><a href="#"><img alt="" src="<c:url value="/Images/Icon/facebook.png"/>" /> </a><a href="#"><img alt="" src="<c:url value="/Resources/Theme/image/twitter.png"/>"/> </a></div>
                        </div>

                    </div>

                    <div class="carrers-item-content">
                        <p>
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam eget mi fermentum, euismod ex vel, pretium tortor.
                            Quisque tempor neque lorem, eget convallis mauris sagittis sit amet. Nam venenatis viverra arcu vitae tempor.
                            Vestibulum congue lectus sed nisl lacinia consequat. Vestibulum fermentum nulla non turpis faucibus porttitor.
                            Maecenas lobortis vel eros eget cursus. Praesent rhoncus enim quam, id aliquet ligula dignissim sit amet.
                        </p>

                        <a class="Job" ng-click="ViewDes(1)">JOB DESCRIPTION</a>
                        <div class="JobDetail">

                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris semper aliquam consectetur. Sed volutpat dolor quis tincidunt commodo. Morbi scelerisque ante vel diam ornare, sit amet facilisis dui tristique. Integer non eros ut augue aliquam tristique et sit amet metus. Cras malesuada ultrices erat, mattis tristique sapien volutpat eget. Nullam sagittis purus ut posuere tempor. Curabitur vel est ac ligula tempor molestie et nec lectus.

                            Donec condimentum eget lorem sit amet maximus. Donec facilisis eleifend nulla a sagittis. Vestibulum risus est, condimentum a mi at, commodo finibus sem. Integer vel elit sit amet tellus feugiat porta. Proin sagittis orci augue. Quisque imperdiet faucibus gravida. Praesent rutrum mattis turpis, vitae pretium nisl laoreet quis. Nam convallis justo nec sem rutrum fringilla. Vestibulum semper nibh eget enim sollicitudin commodo. Ut blandit urna et dolor facilisis accumsan. Nunc congue purus a odio luctus ullamcorper. Curabitur sodales tortor purus, in tempus velit varius non. Quisque vel mauris placerat, molestie sem sit amet, malesuada enim.

                            Ut pellentesque porttitor leo, malesuada dictum lectus hendrerit a. Proin massa nulla, dignissim nec enim non, aliquet rutrum nulla. Sed viverra nunc in lorem lobortis, quis laoreet arcu gravida. Nullam a porta ligula. Sed fringilla posuere elit, quis molestie nulla. Aliquam magna ante, efficitur non tristique eget, efficitur quis ex. Pellentesque libero sem, ornare et malesuada sit amet, bibendum sed felis. Curabitur dignissim justo a quam porta sollicitudin. Ut ultrices rutrum nibh a ornare. Cras nec aliquam elit. Aenean tincidunt dolor et vulputate congue. Mauris sed neque dui. Aenean rhoncus, ex ut sodales cursus, nulla odio interdum augue, ac pulvinar metus velit a neque.

                            Donec congue odio sed ante rutrum, ut aliquet orci porta. Interdum et malesuada fames ac ante ipsum primis in faucibus. Integer ultrices ante urna, sit amet elementum dui rhoncus ac. Morbi at odio sodales, porttitor urna quis, blandit elit. Nam fringilla tellus vitae luctus egestas. Phasellus vulputate elit ipsum, non aliquet neque finibus ac. Fusce tristique lobortis enim et dapibus. Nam non enim nisl. Aenean malesuada fermentum laoreet. Vestibulum id lacus eget lorem elementum laoreet in vitae mi. Sed luctus, leo nec tempus ultricies, velit lectus auctor neque, facilisis pretium tortor enim non quam. Curabitur lobortis justo sit amet dui facilisis cursus. Phasellus viverra molestie justo eu sollicitudin. Aenean tincidunt nunc a est venenatis volutpat.

                            In elementum eget lectus a porttitor. Donec tempor pretium justo, ac sodales eros elementum eget. Nunc a risus id ante facilisis gravida. Sed feugiat diam in sapien auctor fringilla. Fusce et sodales neque. Aenean urna dui, semper nec eros in, aliquet pulvinar nibh. Mauris quis pulvinar libero. Sed at enim tellus. 
                        </div>

                    </div>
                </div>
                <div class="carrers-item">
                    <div class="carrers-item-header">
                        <div class="row">
                            <div class="col-md-7 col-sm-12">
                                <h1>CONTENT COPYWRITER</h1><p>Bangkok, Thailand</p>

                            </div>
                            <div class="col-md-3 col-sm-6"><h3>02 Opening</h3></div>
                            <div class="col-md-2 col-sm-6"><a href="#"><img alt="" src="<c:url value="/Images/Icon/facebook.png"/>" /> </a><a href="#"><img alt="" src="<c:url value="/Resources/Theme/image/twitter.png"/>"/> </a></div>
                        </div>

                    </div>

                    <div class="carrers-item-content">
                        <p>
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam eget mi fermentum, euismod ex vel, pretium tortor.
                            Quisque tempor neque lorem, eget convallis mauris sagittis sit amet. Nam venenatis viverra arcu vitae tempor.
                            Vestibulum congue lectus sed nisl lacinia consequat. Vestibulum fermentum nulla non turpis faucibus porttitor.
                            Maecenas lobortis vel eros eget cursus. Praesent rhoncus enim quam, id aliquet ligula dignissim sit amet.
                        </p>

                        <a class="Job" ng-click="ViewDes(2)">JOB DESCRIPTION</a>
                        <div class="JobDetail">

                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris semper aliquam consectetur. Sed volutpat dolor quis tincidunt commodo. Morbi scelerisque ante vel diam ornare, sit amet facilisis dui tristique. Integer non eros ut augue aliquam tristique et sit amet metus. Cras malesuada ultrices erat, mattis tristique sapien volutpat eget. Nullam sagittis purus ut posuere tempor. Curabitur vel est ac ligula tempor molestie et nec lectus.

                            Donec condimentum eget lorem sit amet maximus. Donec facilisis eleifend nulla a sagittis. Vestibulum risus est, condimentum a mi at, commodo finibus sem. Integer vel elit sit amet tellus feugiat porta. Proin sagittis orci augue. Quisque imperdiet faucibus gravida. Praesent rutrum mattis turpis, vitae pretium nisl laoreet quis. Nam convallis justo nec sem rutrum fringilla. Vestibulum semper nibh eget enim sollicitudin commodo. Ut blandit urna et dolor facilisis accumsan. Nunc congue purus a odio luctus ullamcorper. Curabitur sodales tortor purus, in tempus velit varius non. Quisque vel mauris placerat, molestie sem sit amet, malesuada enim.

                            Ut pellentesque porttitor leo, malesuada dictum lectus hendrerit a. Proin massa nulla, dignissim nec enim non, aliquet rutrum nulla. Sed viverra nunc in lorem lobortis, quis laoreet arcu gravida. Nullam a porta ligula. Sed fringilla posuere elit, quis molestie nulla. Aliquam magna ante, efficitur non tristique eget, efficitur quis ex. Pellentesque libero sem, ornare et malesuada sit amet, bibendum sed felis. Curabitur dignissim justo a quam porta sollicitudin. Ut ultrices rutrum nibh a ornare. Cras nec aliquam elit. Aenean tincidunt dolor et vulputate congue. Mauris sed neque dui. Aenean rhoncus, ex ut sodales cursus, nulla odio interdum augue, ac pulvinar metus velit a neque.

                            Donec congue odio sed ante rutrum, ut aliquet orci porta. Interdum et malesuada fames ac ante ipsum primis in faucibus. Integer ultrices ante urna, sit amet elementum dui rhoncus ac. Morbi at odio sodales, porttitor urna quis, blandit elit. Nam fringilla tellus vitae luctus egestas. Phasellus vulputate elit ipsum, non aliquet neque finibus ac. Fusce tristique lobortis enim et dapibus. Nam non enim nisl. Aenean malesuada fermentum laoreet. Vestibulum id lacus eget lorem elementum laoreet in vitae mi. Sed luctus, leo nec tempus ultricies, velit lectus auctor neque, facilisis pretium tortor enim non quam. Curabitur lobortis justo sit amet dui facilisis cursus. Phasellus viverra molestie justo eu sollicitudin. Aenean tincidunt nunc a est venenatis volutpat.

                            In elementum eget lectus a porttitor. Donec tempor pretium justo, ac sodales eros elementum eget. Nunc a risus id ante facilisis gravida. Sed feugiat diam in sapien auctor fringilla. Fusce et sodales neque. Aenean urna dui, semper nec eros in, aliquet pulvinar nibh. Mauris quis pulvinar libero. Sed at enim tellus. 
                        </div>

                    </div>
                </div>
                <div class="carrers-item">
                    <div class="carrers-item-header">
                        <div class="row">
                            <div class="col-md-7 col-sm-12">
                                <h1>CONTENT COPYWRITER</h1><p>Bangkok, Thailand</p>

                            </div>
                            <div class="col-md-3 col-sm-6"><h3>02 Opening</h3></div>
                            <div class="col-md-2 col-sm-6"><a href="#"><img alt="" src="<c:url value="/Images/Icon/facebook.png"/>" /> </a><a href="#"><img alt="" src="<c:url value="/Resources/Theme/image/twitter.png"/>"/> </a></div>
                        </div>

                    </div>

                    <div class="carrers-item-content">
                        <p>
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam eget mi fermentum, euismod ex vel, pretium tortor.
                            Quisque tempor neque lorem, eget convallis mauris sagittis sit amet. Nam venenatis viverra arcu vitae tempor.
                            Vestibulum congue lectus sed nisl lacinia consequat. Vestibulum fermentum nulla non turpis faucibus porttitor.
                            Maecenas lobortis vel eros eget cursus. Praesent rhoncus enim quam, id aliquet ligula dignissim sit amet.
                        </p>

                        <a class="Job" ng-click="ViewDes(3)">JOB DESCRIPTION</a>
                        <div class="JobDetail">

                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris semper aliquam consectetur. Sed volutpat dolor quis tincidunt commodo. Morbi scelerisque ante vel diam ornare, sit amet facilisis dui tristique. Integer non eros ut augue aliquam tristique et sit amet metus. Cras malesuada ultrices erat, mattis tristique sapien volutpat eget. Nullam sagittis purus ut posuere tempor. Curabitur vel est ac ligula tempor molestie et nec lectus.

                            Donec condimentum eget lorem sit amet maximus. Donec facilisis eleifend nulla a sagittis. Vestibulum risus est, condimentum a mi at, commodo finibus sem. Integer vel elit sit amet tellus feugiat porta. Proin sagittis orci augue. Quisque imperdiet faucibus gravida. Praesent rutrum mattis turpis, vitae pretium nisl laoreet quis. Nam convallis justo nec sem rutrum fringilla. Vestibulum semper nibh eget enim sollicitudin commodo. Ut blandit urna et dolor facilisis accumsan. Nunc congue purus a odio luctus ullamcorper. Curabitur sodales tortor purus, in tempus velit varius non. Quisque vel mauris placerat, molestie sem sit amet, malesuada enim.

                            Ut pellentesque porttitor leo, malesuada dictum lectus hendrerit a. Proin massa nulla, dignissim nec enim non, aliquet rutrum nulla. Sed viverra nunc in lorem lobortis, quis laoreet arcu gravida. Nullam a porta ligula. Sed fringilla posuere elit, quis molestie nulla. Aliquam magna ante, efficitur non tristique eget, efficitur quis ex. Pellentesque libero sem, ornare et malesuada sit amet, bibendum sed felis. Curabitur dignissim justo a quam porta sollicitudin. Ut ultrices rutrum nibh a ornare. Cras nec aliquam elit. Aenean tincidunt dolor et vulputate congue. Mauris sed neque dui. Aenean rhoncus, ex ut sodales cursus, nulla odio interdum augue, ac pulvinar metus velit a neque.

                            Donec congue odio sed ante rutrum, ut aliquet orci porta. Interdum et malesuada fames ac ante ipsum primis in faucibus. Integer ultrices ante urna, sit amet elementum dui rhoncus ac. Morbi at odio sodales, porttitor urna quis, blandit elit. Nam fringilla tellus vitae luctus egestas. Phasellus vulputate elit ipsum, non aliquet neque finibus ac. Fusce tristique lobortis enim et dapibus. Nam non enim nisl. Aenean malesuada fermentum laoreet. Vestibulum id lacus eget lorem elementum laoreet in vitae mi. Sed luctus, leo nec tempus ultricies, velit lectus auctor neque, facilisis pretium tortor enim non quam. Curabitur lobortis justo sit amet dui facilisis cursus. Phasellus viverra molestie justo eu sollicitudin. Aenean tincidunt nunc a est venenatis volutpat.

                            In elementum eget lectus a porttitor. Donec tempor pretium justo, ac sodales eros elementum eget. Nunc a risus id ante facilisis gravida. Sed feugiat diam in sapien auctor fringilla. Fusce et sodales neque. Aenean urna dui, semper nec eros in, aliquet pulvinar nibh. Mauris quis pulvinar libero. Sed at enim tellus. 
                        </div>

                    </div>
                </div>
                <div class="carrers-item carrers-item-fix">
                    <div class="carrers-item-header">
                        <div class="row">
                            <div class="col-md-7 col-sm-12">
                                <h1>CONTENT COPYWRITER</h1><p>Bangkok, Thailand</p>

                            </div>
                            <div class="col-md-3 col-sm-6"><h3>02 Opening</h3></div>
                            <div class="col-md-2 col-sm-6"><a href="#"><img alt="" src="<c:url value="/Images/Icon/facebook.png"/>" /> </a><a href="#"><img alt="" src="<c:url value="/Resources/Theme/image/twitter.png"/>"/> </a></div>
                        </div>

                    </div>

                    <div class="carrers-item-content">
                        <p>
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam eget mi fermentum, euismod ex vel, pretium tortor.
                            Quisque tempor neque lorem, eget convallis mauris sagittis sit amet. Nam venenatis viverra arcu vitae tempor.
                            Vestibulum congue lectus sed nisl lacinia consequat. Vestibulum fermentum nulla non turpis faucibus porttitor.
                            Maecenas lobortis vel eros eget cursus. Praesent rhoncus enim quam, id aliquet ligula dignissim sit amet.
                        </p>

                        <a class="Job" ng-click="ViewDes(4)">JOB DESCRIPTION</a>
                        <div class="JobDetail">

                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris semper aliquam consectetur. Sed volutpat dolor quis tincidunt commodo. Morbi scelerisque ante vel diam ornare, sit amet facilisis dui tristique. Integer non eros ut augue aliquam tristique et sit amet metus. Cras malesuada ultrices erat, mattis tristique sapien volutpat eget. Nullam sagittis purus ut posuere tempor. Curabitur vel est ac ligula tempor molestie et nec lectus.

                            Donec condimentum eget lorem sit amet maximus. Donec facilisis eleifend nulla a sagittis. Vestibulum risus est, condimentum a mi at, commodo finibus sem. Integer vel elit sit amet tellus feugiat porta. Proin sagittis orci augue. Quisque imperdiet faucibus gravida. Praesent rutrum mattis turpis, vitae pretium nisl laoreet quis. Nam convallis justo nec sem rutrum fringilla. Vestibulum semper nibh eget enim sollicitudin commodo. Ut blandit urna et dolor facilisis accumsan. Nunc congue purus a odio luctus ullamcorper. Curabitur sodales tortor purus, in tempus velit varius non. Quisque vel mauris placerat, molestie sem sit amet, malesuada enim.

                            Ut pellentesque porttitor leo, malesuada dictum lectus hendrerit a. Proin massa nulla, dignissim nec enim non, aliquet rutrum nulla. Sed viverra nunc in lorem lobortis, quis laoreet arcu gravida. Nullam a porta ligula. Sed fringilla posuere elit, quis molestie nulla. Aliquam magna ante, efficitur non tristique eget, efficitur quis ex. Pellentesque libero sem, ornare et malesuada sit amet, bibendum sed felis. Curabitur dignissim justo a quam porta sollicitudin. Ut ultrices rutrum nibh a ornare. Cras nec aliquam elit. Aenean tincidunt dolor et vulputate congue. Mauris sed neque dui. Aenean rhoncus, ex ut sodales cursus, nulla odio interdum augue, ac pulvinar metus velit a neque.

                            Donec congue odio sed ante rutrum, ut aliquet orci porta. Interdum et malesuada fames ac ante ipsum primis in faucibus. Integer ultrices ante urna, sit amet elementum dui rhoncus ac. Morbi at odio sodales, porttitor urna quis, blandit elit. Nam fringilla tellus vitae luctus egestas. Phasellus vulputate elit ipsum, non aliquet neque finibus ac. Fusce tristique lobortis enim et dapibus. Nam non enim nisl. Aenean malesuada fermentum laoreet. Vestibulum id lacus eget lorem elementum laoreet in vitae mi. Sed luctus, leo nec tempus ultricies, velit lectus auctor neque, facilisis pretium tortor enim non quam. Curabitur lobortis justo sit amet dui facilisis cursus. Phasellus viverra molestie justo eu sollicitudin. Aenean tincidunt nunc a est venenatis volutpat.

                            In elementum eget lectus a porttitor. Donec tempor pretium justo, ac sodales eros elementum eget. Nunc a risus id ante facilisis gravida. Sed feugiat diam in sapien auctor fringilla. Fusce et sodales neque. Aenean urna dui, semper nec eros in, aliquet pulvinar nibh. Mauris quis pulvinar libero. Sed at enim tellus. 
                        </div>

                    </div>
                </div>
            </div>
                         <%@ include file="comparisonList.jsp" %>
        </div>
        <!-- FOOTER -->
        <%@ include file="footer.jsp" %>
        <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/main.js?999"/>"></script>
        <script>
            $(document).ready(function () {
                toggleHeader.init({
                    toggleControl: false
                });
            });

        </script>
    </body>
</html>