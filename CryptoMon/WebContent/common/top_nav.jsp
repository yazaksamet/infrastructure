<%@page import="ynwa.core.cache.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>

<header>
    <div class="header_top">
      <div class="container">
        <!-- Contact Details -->
        <div id="contact-details">
          <ul>
            <li><i class="fa fa-phone"></i>support@test.com</li>
            <li><i class="fa fa-envelope-o"></i> +11 222 430 231</li>
          </ul>
        </div>
        <ul id="owl-tt-menu" class="owl-tt-menu">
          <li> <a href="#">${userLang.getName()}</a>
            <ul class="owl-tt-submenu">
              <%java.util.HashMap<String, ynwa.core.entity.Language> languageList = Cache.LanguageList.GetCacheMap(); %>
              	<% for (java.util.Map.Entry<String, ynwa.core.entity.Language> entry : languageList.entrySet()) { %>
				    <li><a href="<%= "index.jsp?lang=" + entry.getKey() %>" class="flags <%=entry.getValue().getCss()%>"><%=entry.getValue().getName()  %></a></li>
				<% } %>
             
            </ul>
          </li>
        </ul>
        <div class="social-top"> <a href="#" class="fa fa-twitter"></a> <a href="#" class="fa fa-facebook"></a> <a href="#" class="fa fa-vimeo"></a> <a href="#" class="fa fa-gplus"></a> </div>
        
      </div>
    </div>
    
    <div class="header-inner fixed_menu">
      <div class="container">
        <div class="row">
          <!-- Main Navigation, Search and Side Navigation Button -->
          <nav>
            <div class="nav-sticky">
              <!-- Search -->
              <div class="tp-search">
                <div class="owl-header-buttons"> <a class="owl-search-trigger" href="#owl-search"><span></span></a> </div>
                <div id="owl-search" class="owl-search">
                  <form>
                    <input type="search" placeholder="Search...">
                  </form>
                </div>
                <div class="owl-search-overlay"></div>
              </div>
              <!-- Main Navigation -->
              <div class="owl-contener fright clearfix">
                <div class="cat-title"></div>
                <ul class="owl-menu menu-content">
                  <!--=========== Single Menu ===============-->
                  <li class="single-dropdown"> <a href="index.jsp"><fmt:message key="label.homePage" /></a>
                  </li>
                  
                  <% if (session.getAttribute("user") != null) { %>
					    <li class="single-dropdown"> <a href="#"><fmt:message key="label.adminPanel" /></a>
					    	<ul class="owl-nav-list-single">
		                  		<li class="single-dropdown"><a href="string.jsp"><fmt:message key="label.mlDef" /></a> </li>
		                  	</ul>
                  		</li>
					    <li class="single-dropdown"> <a class="active" href="#"> <fmt:message key="label.welcome" />, ${user.getLoginName()}!</a>
		                  	<ul class="owl-nav-list-single">
		                  		<li class="single-dropdown"><a href="loginHandler?logout=true"><fmt:message key="label.logout" /></a> </li>
		                  		<li class="single-dropdown"><a href="myaccount.jsp"><fmt:message key="label.myAccount" /></a> </li>
		                  	</ul>
		                  </li>
					<% } else {%>
					    <li class="single-dropdown"> <a class="active" href="login.jsp"><fmt:message key="label.login" /></a>
		                  </li>
					<% } %>
                  
                  
                </ul>
              </div>
            </div>
          </nav>
        </div>
      </div>
    </div>
  	<div class="clear"></div>
  </header>
  