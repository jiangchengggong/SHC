<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<core:set var ="webcontext" scope="request" value="${pageContext.request.contextPath}"/>
<core:set var ="imagepath" scope="request" value="${webcontext}/images"/>
<core:set var ="csspath" scope="request" value="${webcontext}/css"/>
<core:set var ="jspath" scope="request" value="${webcontext}/javascript"/>