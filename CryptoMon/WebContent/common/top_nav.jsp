<%@page import="ynwa.core.cache.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                  <li class="single-dropdown"> <a href="index.jsp"><%= Cache.MultiLanguage.GetValue("homepage", currentLang) %></a>
                  </li>
                  
                  <% if (session.getAttribute("user") != null) { %>
					    <li class="single-dropdown"> <a href="#"><%= Cache.MultiLanguage.GetValue("adminpanel", currentLang) %></a>
					    	<ul class="owl-nav-list-single">
		                  		<li class="single-dropdown"><a href="string.jsp"><%= Cache.MultiLanguage.GetValue("mldef", currentLang) %></a> </li>
		                  	</ul>
                  		</li>
					    <li class="single-dropdown"> <a class="active" href="#"> <%= Cache.MultiLanguage.GetValue("welcome", currentLang) %>, ${user.getLoginName()}!</a>
		                  	<ul class="owl-nav-list-single">
		                  		<li class="single-dropdown"><a href="loginHandler?logout=true"><%= Cache.MultiLanguage.GetValue("logout", currentLang) %></a> </li>
		                  		<li class="single-dropdown"><a href="myaccount.jsp"><%= Cache.MultiLanguage.GetValue("myaccount", currentLang) %></a> </li>
		                  	</ul>
		                  </li>
					<% } else {%>
					    <li class="single-dropdown"> <a class="active" href="login.jsp"><%= Cache.MultiLanguage.GetValue("login", currentLang) %></a>
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
  