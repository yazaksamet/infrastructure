<%@page import="ynwa.core.cache.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page session="true" %>
<%
	String requestedLang = request.getParameter("lang");
    if( null == session.getValue( "userLang" ) ) {
    	session.putValue("userLang", Cache.LanguageList.GetDefaultValue());
	}
    
    if (requestedLang != null && !requestedLang.isEmpty()) {
    	ynwa.core.entity.Language lang = Cache.LanguageList.Get(requestedLang);
    	session.putValue("userLang", lang);
    }
    
    String currentLang = ((ynwa.core.entity.Language)session.getValue( "userLang" )).getShortCode();
%>