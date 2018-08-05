<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<header>
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
                  <li class="single-dropdown"> <a href="index.jsp">Home</a>
                  </li>
                  
                  <% if (session.getAttribute("user") != null) { %>
					    <li class="single-dropdown"> <a class="active" href="#">Welcome, ${user.getLoginName()}!</a>
		                  	<ul class="owl-nav-list-single">
		                  		<li class="single-dropdown"><a href="loginHandler?logout=true">Logout</a> </li>
		                  		<li class="single-dropdown"><a href="myaccount.jsp">My Account</a> </li>
		                  	</ul>
		                  </li>
					<% } else {%>
					    <li class="single-dropdown"> <a class="active" href="login.jsp">Login</a>
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
  